package cn.stucar.controller;

import cn.stucar.controller.handers.ReturnFormat;
import cn.stucar.model.Result;

/**
 * Created by Administrator on 2017/8/4.
 */
public abstract  class BaseController {
    protected Result retContent(int status) {
        return ReturnFormat.retParam(status);
    }
    protected Result retContent(int status, String message) {
        return ReturnFormat.retParam(status,message);
    }
    protected Result retContent(int status, String message, Object data) {
        return ReturnFormat.retParam(status, message,data);
    }
}
