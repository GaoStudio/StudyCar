package cn.stucar.model;
/**
 * 用户二维码
 */
public class UserCode {
    private String ucode_id;

    public String getUcode_id() {
        return ucode_id;
    }

    public void setUcode_id(String ucode_id) {
        this.ucode_id = ucode_id;
    }

    private String ucode_phone;
    private String ucode_code;
    private String ucode_time;

    public UserCode(String ucode_phone, String ucode_code) {
        this.ucode_phone = ucode_phone;
        this.ucode_code = ucode_code;
    }

    public String getUcode_phone() {
        return ucode_phone;
    }

    public void setUcode_phone(String ucode_phone) {
        this.ucode_phone = ucode_phone;
    }

    public String getUcode_code() {
        return ucode_code;
    }

    public void setUcode_code(String ucode_code) {
        this.ucode_code = ucode_code;
    }

    public String getUcode_time() {
        return ucode_time;
    }

    public void setUcode_time(String ucode_time) {
        this.ucode_time = ucode_time;
    }
}
