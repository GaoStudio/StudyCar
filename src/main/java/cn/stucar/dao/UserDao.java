package cn.stucar.dao;

import cn.stucar.model.User;
import cn.stucar.model.UserCode;
import org.apache.ibatis.annotations.Param;

/**
 * Created by Administrator on 2017/8/3.
 */
public interface UserDao{
    public User selectUserById(String id);
    public User selectUserByPhone(String id);
    public String selectPswByPhone(String id);
    public UserCode queryUserCodeByPhone(String phone);
    public int insertUserCode(UserCode UserCode);
    public int insertUser(@Param(value="u_name") String u_name ,@Param(value="u_phone") String u_phone,@Param(value="u_logo") String u_logo,@Param(value="password") String password);
}