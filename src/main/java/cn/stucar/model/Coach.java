package cn.stucar.model;

/**
 * Created by Administrator on 2017/8/11.
 */
public class Coach {
    private String  ch_id;
    private String  ch_name;
    private String  ch_phone;
    private String  ch_state;
    private String  ch_card;
    private String  ch_auth;
    private String ch_logo;
    private int  car_id;
    private int  u_id;

    public Coach(){}
    public Coach(String ch_name, String ch_phone, String  ch_logo,String ch_card, String ch_auth, int u_id, int car_id) {
        this.ch_name = ch_name;
        this.ch_phone = ch_phone;
        this.ch_card = ch_card;
        this.ch_logo = ch_logo;
        this.ch_auth = ch_auth;
        this.u_id = u_id;
        this.car_id = car_id;
    }
    public String getCh_logo() {
        return ch_logo;
    }

    public void setCh_logo(String ch_logo) {
        this.ch_logo = ch_logo;
    }
    public int getCar_id() {
        return car_id;
    }

    public void setCar_id(int car_id) {
        this.car_id = car_id;
    }

    public int getU_id() {
        return u_id;
    }

    public void setU_id(int u_id) {
        this.u_id = u_id;
    }

    private User user;
    private Car car;
    public String getCh_id() {
        return ch_id;
    }

    public void setCh_id(String ch_id) {
        this.ch_id = ch_id;
    }

    public String getCh_name() {
        return ch_name;
    }

    public void setCh_name(String ch_name) {
        this.ch_name = ch_name;
    }

    public String getCh_phone() {
        return ch_phone;
    }

    public void setCh_phone(String ch_phone) {
        this.ch_phone = ch_phone;
    }

    public String getCh_state() {
        return ch_state;
    }

    public void setCh_state(String ch_state) {
        this.ch_state = ch_state;
    }

    public String getCh_card() {
        return ch_card;
    }

    public void setCh_card(String ch_card) {
        this.ch_card = ch_card;
    }

    public String getCh_auth() {
        return ch_auth;
    }

    public void setCh_auth(String ch_auth) {
        this.ch_auth = ch_auth;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }
}
