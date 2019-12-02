package com.example.administrator.matata_android.bean;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class WXPayBean implements Serializable {
    /**
     * appid : wx0c29113c18ba2dfc
     * partnerid : 1540786021
     * prepayid : wx0215103882185636b00407e81547265700
     * noncestr : 5de4b8eedb612
     * timestamp : 1575270638
     * package : Sign=WXPay
     * sign : 51EE3611FA7253DC36A2278186A8E5B9
     */

    private String appid;
    private String partnerid;
    private String prepayid;
    private String noncestr;
    private int timestamp;
    @SerializedName("package")
    private String packageX;
    private String sign;

    public String getAppid() {
        return appid;
    }

    public void setAppid(String appid) {
        this.appid = appid;
    }

    public String getPartnerid() {
        return partnerid;
    }

    public void setPartnerid(String partnerid) {
        this.partnerid = partnerid;
    }

    public String getPrepayid() {
        return prepayid;
    }

    public void setPrepayid(String prepayid) {
        this.prepayid = prepayid;
    }

    public String getNoncestr() {
        return noncestr;
    }

    public void setNoncestr(String noncestr) {
        this.noncestr = noncestr;
    }

    public int getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(int timestamp) {
        this.timestamp = timestamp;
    }

    public String getPackageX() {
        return packageX;
    }

    public void setPackageX(String packageX) {
        this.packageX = packageX;
    }

    public String getSign() {
        return sign;
    }

    public void setSign(String sign) {
        this.sign = sign;
    }
}
