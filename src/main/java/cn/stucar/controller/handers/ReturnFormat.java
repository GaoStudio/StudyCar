package cn.stucar.controller.handers;


import cn.stucar.model.Data;
import cn.stucar.model.Result;

import java.util.HashMap;
import java.util.Map;
//格式化返回客户端数据格式（json）
public class ReturnFormat {
    private static Map<String, String> messageMap = new HashMap();
   /* private static Gson gson =   new GsonBuilder().serializeNulls().create();*/
    //初始化状态码与文字说明
    static {
        messageMap.put("0", "success");
        messageMap.put("400", "Bad Request!");
        messageMap.put("401", "NotAuthorization");
        messageMap.put("405", "Method Not Allowed");
        messageMap.put("406", "Not Acceptable");
        messageMap.put("500", "Internal Server Error");

        messageMap.put("1000", "[服务器]运行时异常");
        messageMap.put("1001", "[服务器]空值异常");
        messageMap.put("1002", "[服务器]数据类型转换异常");
        messageMap.put("1003", "[服务器]IO异常");
        messageMap.put("1004", "[服务器]未知方法异常");
        messageMap.put("1005", "[服务器]数组越界异常");
        messageMap.put("1006", "[服务器]网络异常");

        messageMap.put("1010", "用户未注册");
        messageMap.put("1011", "用户已注册");
        messageMap.put("1012", "用户名或密码错误");
        messageMap.put("1013", "用户帐号冻结");
        messageMap.put("1014", "用户信息编辑失败");
        messageMap.put("1015", "用户信息失效，请重新获取");
    }
    public static Result retParam(int status, String message) {
        Result Result = new Result(status,message,new Data());
        return Result;
    }
    public static Result retParam(int status) {
        Result Result = new Result(status,messageMap.get(String.valueOf(status)),new Data());
        return Result;
    }
    public static Result retParam(int status, String message, Object data) {
        Result Result = new Result(status,message,data);
        return Result;
    }
}