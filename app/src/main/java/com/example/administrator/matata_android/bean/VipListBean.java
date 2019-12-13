package com.example.administrator.matata_android.bean;

import java.io.Serializable;

public class VipListBean implements Serializable {
    /**
     * id : 287
     * main : USER
     * sub : SCHOOL
     * name : SETTINGS
     * value : {"pic":"201905/6b2a22728c0847d3a91710120fb002e6.png","name":"普通会员","price":99,"distributionRatio1":"25","distributionRatio2":"0"}
     * descp : 暂无描述
     * sort : 1
     * status : 0
     * createDt : 2018-05-30 20:53:28
     * updateDt : 2019-06-10 11:56:46
     */

    private int id;
    private String main;
    private String sub;
    private String name;
    private ValueBean value;
    private String descp;
    private int sort;
    private String status;
    private String createDt;
    private String updateDt;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMain() {
        return main;
    }

    public void setMain(String main) {
        this.main = main;
    }

    public String getSub() {
        return sub;
    }

    public void setSub(String sub) {
        this.sub = sub;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ValueBean getValue() {
        return value;
    }

    public void setValue(ValueBean value) {
        this.value = value;
    }

    public String getDescp() {
        return descp;
    }

    public void setDescp(String descp) {
        this.descp = descp;
    }

    public int getSort() {
        return sort;
    }

    public void setSort(int sort) {
        this.sort = sort;
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

    public static class ValueBean {
        /**
         * pic : 201905/6b2a22728c0847d3a91710120fb002e6.png
         * name : 普通会员
         * price : 99
         * distributionRatio1 : 25
         * distributionRatio2 : 0
         */

        private String pic;
        private String name;
        private int price;
        private String distributionRatio1;
        private String distributionRatio2;

        public String getPic() {
            return pic;
        }

        public void setPic(String pic) {
            this.pic = pic;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getPrice() {
            return price;
        }

        public void setPrice(int price) {
            this.price = price;
        }

        public String getDistributionRatio1() {
            return distributionRatio1;
        }

        public void setDistributionRatio1(String distributionRatio1) {
            this.distributionRatio1 = distributionRatio1;
        }

        public String getDistributionRatio2() {
            return distributionRatio2;
        }

        public void setDistributionRatio2(String distributionRatio2) {
            this.distributionRatio2 = distributionRatio2;
        }
    }
}
