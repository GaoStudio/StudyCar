package cn.stucar.model;

/**
 * Created by Administrator on 2017/8/3.
 */
public class User {
    private int u_id;
    private String u_name;
    private String u_phone;
    private String u_logo;
    private String u_sex;
    public User(){}
    public User(String u_name, String u_phone, String u_logo, String u_sex) {
        this.u_name = u_name;
        this.u_phone = u_phone;
        this.u_logo = u_logo;
        this.u_sex = u_sex;
    }
    public int getU_id() {
        return u_id;
    }

    public void setU_id(int u_id) {
        this.u_id = u_id;
    }

    public String getU_name() {
        return u_name;
    }

    public void setU_name(String u_name) {
        this.u_name = u_name;
    }

    public String getU_logo() {
        return u_logo;
    }

    public void setU_logo(String u_logo) {
        this.u_logo = u_logo;
    }

    public String getU_phone() {
        return u_phone;
    }

    public void setU_phone(String u_phone) {
        this.u_phone = u_phone;
    }

    public String getU_sex() {
        return u_sex;
    }

    public void setU_sex(String u_sex) {
        this.u_sex = u_sex;
    }
}
