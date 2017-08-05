package cn.stucar.controller;

import cn.stucar.model.User;
import cn.stucar.services.UserService;
import com.google.gson.Gson;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

/**
 * Created by Administrator on 2017/8/3.
 */
@Controller
@RequestMapping(value = "/user", produces="text/html;charset=UTF-8")
@ResponseBody
public class UserController extends BaseController{
    @Resource
    private UserService userService;

    @RequestMapping(value = "/id")
    public String selectUserById(){
        User user = userService.selectUserById(1);
        return retContent(200,user);
    }
}
