package cn.stucar.model;

import java.math.BigInteger;
import java.sql.Date;

/**
 * 用户二维码
 */
public class UserCode {
    private BigInteger ud_id;
    private String ud_phone;
    private String ud_code;
    private Date ud_time;
    public UserCode(){}
    public UserCode(String ud_phone, String ud_code) {
        this.ud_phone = ud_phone;
        this.ud_code = ud_code;
    }

    public BigInteger getUd_id() {
        return ud_id;
    }

    public void setUd_id(BigInteger ud_id) {
        this.ud_id = ud_id;
    }

    public String getUd_phone() {
        return ud_phone;
    }

    public void setUd_phone(String ud_phone) {
        this.ud_phone = ud_phone;
    }

    public String getUd_code() {
        return ud_code;
    }

    public void setUd_code(String ud_code) {
        this.ud_code = ud_code;
    }

    public Date getUd_time() {
        return ud_time;
    }

    public void setUd_time(Date ud_time) {
        this.ud_time = ud_time;
    }
}
