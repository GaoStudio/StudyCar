package cn.stucar.controller;

import cn.stucar.model.Data;
import cn.stucar.model.OutputJson;
import cn.stucar.model.User;
import cn.stucar.services.UserService;
import cn.stucar.utils.FileUpload;
import com.aliyuncs.exceptions.ClientException;
import com.google.gson.Gson;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import springfox.documentation.annotations.ApiIgnore;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.POST;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Administrator on 2017/8/3.
 */
@Controller
@RequestMapping(value = "/api/user", produces="application/json;charset=UTF-8")
@ResponseBody
public class UserController extends BaseController{
    @Resource
    private UserService userService;

    @ApiOperation(value = "获取验证码",httpMethod = "POST",notes = "获取根据ID用户信息")
    @ApiResponse(code = 200, message = "success", response = OutputJson.class)
    @RequestMapping(value = "/code",method = RequestMethod.POST)
    public String getCode(@ApiParam(name = "phone",type = "String", required = true, value = "用户手机号码") @RequestParam("phone")  String phone)  {
        int  result = -1;
        try {
            System.out.println(phone);
            result = userService.getCode(phone);
        } catch (ClientException e) {
            System.out.println(e.getErrCode());
            System.out.println(e.getErrMsg());
            return retContent(1,"获取失败");
        }
        if(result>=0){
            return retContent(0,"获取成功");
        }else if(result==-2){
            return retContent(1,"获取失败");
        }else {
            return retContent(0,"用户已存在！请直接登录");
        }
    }

    @ApiOperation(value = "用户注册",httpMethod = "POST",notes = "用户注册接口")
    @RequestMapping(value = "/register",method = RequestMethod.POST)
    public String register(HttpServletRequest request ,MultipartFile logo, String phone, String name, String psw, String codee)  {
        String saveFilePath = "images/userlogo/defaultlogo.jpg";
        if(logo!=null){
            //获得文件类型（可以判断如果不是图片，禁止上传）
            String contentType = logo.getContentType();
            //获得文件后缀名称
            String imageName = contentType.substring(contentType.indexOf("/") + 1);
            saveFilePath = "images/userlogo/"+phone+"logo."+imageName;
        }
        int i = userService.register(request,logo,saveFilePath,name,phone,psw,codee);
        if(i==-1){
            return retContent(0,"用户已存在！请直接登录");
        }else if(i==-2){
            return retContent(0,"验证码错误");
        }else if (i==-3){
            return retContent(0,"头像上传失败");
        }
        else {
            Map<String,Object> map = new HashMap<String,Object>();
            map.put("logo",saveFilePath);
            return retContent(1,"注册成功",map);
        }
    }

    @ApiOperation(value = "用户登录",httpMethod = "POST",notes = "用户登录接口")
    @ApiResponse(code = 200, message = "success", response = OutputJson.class)
    @RequestMapping(value = "/login",method = RequestMethod.POST)
    public String login(String phone,String psw){
        //System.out.println(phone+":::"+psw);
        Object Object = userService.login(phone,psw);
        if(Object instanceof User){
            return retContent(1,"登录成功！",Object);
        }else if(Object==null){
            return retContent(0,"用户不存在！");
        }else {
            return retContent(0,"密码错误！");
        }

    }
}
