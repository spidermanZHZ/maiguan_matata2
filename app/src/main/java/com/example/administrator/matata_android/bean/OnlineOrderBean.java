package com.example.administrator.matata_android.bean;

import java.io.Serializable;

public class OnlineOrderBean implements Serializable {
    /**
     * no : MTT201912101042277299335030
     * course_type : 00
     * course_id : 51
     * user_id : 2317
     * order_amount : 10
     * pay_amount : 10
     * status : 00
     * createDt : 2019-12-10 10:42:27
     * updateDt : 2019-12-10 10:42:27
     * id : 100000504
     * name : 测试
     */

    private String no;
    private String course_type;
    private String course_id;
    private int user_id;
    private int order_amount;
    private int pay_amount;
    private String status;
    private String createDt;
    private String updateDt;
    private int id;
    private String name;

    public String getNo() {
        return no;
    }

    public void setNo(String no) {
        this.no = no;
    }

    public String getCourse_type() {
        return course_type;
    }

    public void setCourse_type(String course_type) {
        this.course_type = course_type;
    }

    public String getCourse_id() {
        return course_id;
    }

    public void setCourse_id(String course_id) {
        this.course_id = course_id;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public int getOrder_amount() {
        return order_amount;
    }

    public void setOrder_amount(int order_amount) {
        this.order_amount = order_amount;
    }

    public int getPay_amount() {
        return pay_amount;
    }

    public void setPay_amount(int pay_amount) {
        this.pay_amount = pay_amount;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getCreateDt() {
        return createDt;
    }

    public void setCreateDt(String createDt) {
        this.createDt = createDt;
    }

    public String getUpdateDt() {
        return updateDt;
    }

    public void setUpdateDt(String updateDt) {
        this.updateDt = updateDt;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
