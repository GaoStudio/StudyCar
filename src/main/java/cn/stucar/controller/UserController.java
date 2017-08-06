package cn.stucar.controller;

import cn.stucar.model.User;
import cn.stucar.services.UserService;
import com.aliyuncs.exceptions.ClientException;
import com.google.gson.Gson;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

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
        return retContent(0,user);
    }
    @RequestMapping(value = "/code")
    public String getCode(@RequestParam("phone") String phone)  {
        int  result = -1;
        try {
            result = userService.getCode(phone);
        } catch (ClientException e) {
            e.printStackTrace();
            return retContent(1,"获取失败",null);
        }
        if(result>=0){
            return retContent(0,null);
        }else {
            return retContent(1,"获取失败",null);
        }
    }
    @RequestMapping(value = "/register")
    public String register(MultipartFile logo,String phone,String name,String psw,String code)  {
        return null;
    }
}
