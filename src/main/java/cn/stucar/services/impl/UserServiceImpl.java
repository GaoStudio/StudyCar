package cn.stucar.services.impl;

import cn.stucar.dao.UserDao;
import cn.stucar.model.User;
import cn.stucar.services.UserService;
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
}
