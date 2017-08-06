package cn.stucar.dao;

import cn.stucar.model.User;
import cn.stucar.model.UserCode;

/**
 * Created by Administrator on 2017/8/3.
 */
public interface UserDao{
    public User selectUserByID(int id);
    public UserCode queryUserCodeByPhone(String phone);
    public int insertUserCode(UserCode UserCode);
}