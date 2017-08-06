package cn.stucar.services;

import cn.stucar.model.User;
import com.aliyuncs.exceptions.ClientException;

/**
 * Created by Administrator on 2017/8/3.
 */
public interface UserService {
   public User selectUserById(int id);
   public int getCode(String phone) throws ClientException;
}
