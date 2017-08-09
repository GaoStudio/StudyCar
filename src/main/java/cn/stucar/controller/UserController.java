package cn.stucar.controller;

import cn.stucar.model.OutputJson;
import cn.stucar.model.User;
import cn.stucar.services.UserService;
import com.aliyuncs.exceptions.ClientException;
import com.google.gson.Gson;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import springfox.documentation.annotations.ApiIgnore;

import javax.annotation.Resource;

/**
 * Created by Administrator on 2017/8/3.
 */
@Controller
@RequestMapping(value = "/api/user", produces="application/json;charset=UTF-8")
@ResponseBody
public class UserController extends BaseController{
    @Resource
    private UserService userService;

    @RequestMapping(value = "/id")
    @ApiOperation(value = "用户登录",httpMethod = "GET",notes = "获取根据ID用户信息")
    public String selectUserById(){
        User user = userService.selectUserById(1);
        return retContent(0,user);
    }
    @ApiOperation(value = "获取验证码",httpMethod = "POST",notes = "获取根据ID用户信息")
    @RequestMapping(value = "/code",method = RequestMethod.POST)
    public String getCode(@ApiParam(name = "手机号") @RequestParam("phone") String phone)  {
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
    @ApiIgnore//生成接口文档时忽略
    @RequestMapping(value = "/register")
    public String register(MultipartFile logo,String phone,String name,String psw,String codee)  {
        return null;
    }
}
