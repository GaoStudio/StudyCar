package cn.stucar.dao;

import cn.stucar.model.User;

/**
 * Created by Administrator on 2017/8/3.
 */
public interface UserDao{
    public User selectUserByID(int id);
}