package cn.stucar.model;

/**
 * Created by Administrator on 2017/8/11.
 */
public class Car {
    private int car_id;
    private String car_name;
    private String car_phone;
    private School school;

    public int getCar_id() {
        return car_id;
    }

    public void setCar_id(int car_id) {
        this.car_id = car_id;
    }

    public String getCar_name() {
        return car_name;
    }

    public void setCar_name(String car_name) {
        this.car_name = car_name;
    }

    public String getCar_phone() {
        return car_phone;
    }

    public void setCar_phone(String car_phone) {
        this.car_phone = car_phone;
    }

    public School getSchool() {
        return school;
    }

    public void setSchool(School school) {
        this.school = school;
    }
}
