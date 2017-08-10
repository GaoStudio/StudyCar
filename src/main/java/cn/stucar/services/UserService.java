package cn.stucar.services;

import cn.stucar.model.User;
import com.aliyuncs.exceptions.ClientException;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by Administrator on 2017/8/3.
 */
public interface UserService {
   public int getCode(String phone) throws ClientException;
   public int register(HttpServletRequest request, MultipartFile logo,String savePath, String name, String phone, String psw, String codee);
   public <T> T login(String phone,String psw);
}
