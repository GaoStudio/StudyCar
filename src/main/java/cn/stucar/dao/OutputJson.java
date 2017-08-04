package cn.stucar.dao;

import com.google.gson.Gson;

import javax.annotation.Resource;
import java.io.Serializable;
public class OutputJson implements Serializable {
    /**
     * 返回客户端统一格式，包括状态码，提示信息，以及业务数据
     */
    @Resource
    private Gson gson;

    private static final long serialVersionUID = 1L;
    //状态码
    private int status;
    //必要的提示信息
    private String message;
    //业务数据
    private Object data;

    public OutputJson(int status, String message, Object data) {
        this.status = status;
        this.message = message;
        this.data = data;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public String toString() {
        if (null == this.data) {
            this.setData(new Object());
        }
        return gson.toJson(this);
    }
}
