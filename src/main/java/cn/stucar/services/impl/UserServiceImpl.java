package cn.stucar.services.impl;

import cn.stucar.dao.UserDao;
import cn.stucar.model.User;
import cn.stucar.model.UserCode;
import cn.stucar.services.UserService;
import cn.stucar.thridutils.SendMessageUtil;
import com.aliyuncs.dysmsapi.model.v20170525.SendSmsResponse;
import com.aliyuncs.exceptions.ClientException;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * Created by Administrator on 2017/8/3.
 */
@Service
public class UserServiceImpl implements UserService {
    @Resource
    public UserDao UserDao;
    public User selectUserById(int id) {
        return UserDao.selectUserByID(id);
    }
    public int  getCode(String phone) throws ClientException {
        int code = SendMessageUtil.getRandNum(1,999999);
        String json = "{\"number\":\""+code+"\"}";
        SendSmsResponse sendSmsResponse =  SendMessageUtil.sendSms(phone,"SMS_82190071",json);
        if(sendSmsResponse.getCode() != null && sendSmsResponse.getCode().equals("OK")) {
            return UserDao.insertUserCode(new UserCode(phone,code+""));
        }else {
            return -1;
        }
    }
}
