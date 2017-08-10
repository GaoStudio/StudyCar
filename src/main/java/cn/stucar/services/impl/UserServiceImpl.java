package cn.stucar.services.impl;

import cn.stucar.dao.UserDao;
import cn.stucar.model.User;
import cn.stucar.model.UserCode;
import cn.stucar.services.UserService;
import cn.stucar.thridutils.SendMessageUtil;
import cn.stucar.utils.FileUpload;
import com.aliyuncs.dysmsapi.model.v20170525.SendSmsResponse;
import com.aliyuncs.exceptions.ClientException;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

/**
 * Created by Administrator on 2017/8/3.
 */
@Service
public class UserServiceImpl implements UserService {
    @Resource
    public UserDao UserDao;
    public int  getCode(String phone) throws ClientException {
        User user = UserDao.selectUserByPhone(phone);
        if(user != null){
            return -2;
        }
        /**
         * 加入接口限制，防止刷接口
         */
        int code = SendMessageUtil.getRandNum(100000,999999);
        String json = "{\"number\":\""+code+"\"}";
        SendSmsResponse sendSmsResponse =  SendMessageUtil.sendSms(phone,"SMS_82190071",json);
        if(sendSmsResponse.getCode() != null && sendSmsResponse.getCode().equals("OK")) {
            return UserDao.insertUserCode(new UserCode(phone,code+""));
        }else {
            return -1;
        }
    }
    public int register(HttpServletRequest request, MultipartFile logo, String fileName, String name, String phone, String psw, String codee) {
        User user = UserDao.selectUserByPhone(phone);
        if(user != null){
            return -1;
        }
        UserCode  UserCode= UserDao.queryUserCodeByPhone(phone);
        if(UserCode==null){
            return -2;
        }
        if(!codee.equals(UserCode.getUd_code())){
            return -2;
        }
        String path = request.getSession().getServletContext().getRealPath(fileName);
        if(logo!=null){
            try {
                FileUpload.uploadImage(logo,path);
            } catch (IOException e) {
                e.printStackTrace();
                return -3;
            }
        }
        int i = UserDao.insertUser(name,phone,fileName,psw);
        return i;
    }
    public <T> T login(String phone,String psw) {
        User user = UserDao.selectUserByPhone(phone);

        if(user==null){
            return null;
        }else {
            String password = UserDao.selectPswByPhone(phone);
            if(psw.equals(password)){
                return (T)user;
            } else {
                return (T)new Integer(-1);
            }
        }

    }
}
