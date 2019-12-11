package com.example.administrator.matata_android.bean;

import java.io.Serializable;

public class MyOffLineCourseNumBean implements Serializable {
    /**
     * num : 1
     * time : 2019-12-12 12:00:00
     * is_end : false
     * num_id : 5
     */

    private String num;
    private String time;
    private String is_end;
    private String num_id;

    public String getNum() {
        return num;
    }

    public void setNum(String num) {
        this.num = num;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getIs_end() {
        return is_end;
    }

    public void setIs_end(String is_end) {
        this.is_end = is_end;
    }

    public String getNum_id() {
        return num_id;
    }

    public void setNum_id(String num_id) {
        this.num_id = num_id;
    }
}
