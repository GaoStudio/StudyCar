package cn.stucar.controller;

import cn.stucar.controller.handers.ReturnFormat;

/**
 * Created by Administrator on 2017/8/4.
 */
public abstract  class BaseController {
    protected String retContent(int status,Object data) {
        return ReturnFormat.retParam(status,data);
    }
    protected String retContent(int status,String message,Object data) {
        return ReturnFormat.retParam(status, message,data);
    }
}
