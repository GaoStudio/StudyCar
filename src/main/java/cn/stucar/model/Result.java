package cn.stucar.model;

import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;

import java.io.Serializable;
public class Result<T> implements Serializable {
    /**
     * 返回客户端统一格式，包括状态码，提示信息，以及业务数据
     */

    private static final long serialVersionUID = 1L;
    //状态码
    private int status;
    //必要的提示信息
    private String message;
    //业务数据
    private T data;


    public Result(int status, String message, T data) {
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

    public void setData(T data) {
        this.data = data;
    }

}
