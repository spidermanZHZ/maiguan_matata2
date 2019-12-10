package com.example.administrator.matata_android.bean;

import java.io.Serializable;

public class OffLineOrderBean implements Serializable {


    /**
     * no : MTT201912101730599605178328
     * course_type : 01
     * course_id : 12
     * user_id : 2317
     * order_amount : 1280000
     * pay_amount : 1280000
     * status : 00
     * createDt : 2019-12-10 17:30:59
     * updateDt : 2019-12-10 17:30:59
     * card_type : year
     * child_id : 19
     * id : 100000519
     * name : PBL成长教育戏剧
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
    private String card_type;
    private String child_id;
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

    public String getCard_type() {
        return card_type;
    }

    public void setCard_type(String card_type) {
        this.card_type = card_type;
    }

    public String getChild_id() {
        return child_id;
    }

    public void setChild_id(String child_id) {
        this.child_id = child_id;
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
