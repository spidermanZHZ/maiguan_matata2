package com.example.administrator.matata_android.bean;

import java.io.Serializable;
import java.util.List;

public class MyExtendBean implements Serializable {

    /**
     * studentCount : 0
     * distributionCount : 1
     * distribution : [{"id":1178,"name":null,"user_id":1192,"id_no":null,"nickname":"A丶祝洪智*","sex":"1","province":"暂无","city":"暂无","area":null,"address":null,"email":null,"mobile_no":null,"qq":null,"wechat":null,"profile":null,"desp":null,"head_file":"http://thirdwx.qlogo.cn/mmopen/vi_32/Q0j4TwGTfTJyos9KR4uD04wQZSXfxEuZxABlFpEI5s4fZXiaUmJzY761lWmPtM2LK8myvlRQul7mFgUpDzalVhg/132","status":"0","is_vip":"1","balance":2,"virtual_currency":36,"bind_card_no":null,"bind_card_opennode_no":null,"bind_card_opennode_name":null,"recommend_user_id":null,"goods_address":null,"is_test":"0","sign_date":null,"createDt":"2019-02-28 14:31:01","updateDt":"2019-07-19 14:13:29","agent_user_1":2317,"agent_user_2":null,"agent_user_3":null,"user_shool_id":132,"password":null}]
     * studentList : []
     * goodsOrderList : []
     * withdrawList : [{"id":13,"user_login_id":2317,"real_name":"lly","bankName":"中国建设银行济南分行","bank_card_no":"6236682340007344897","apply_money":84000,"apply_dt":"2018-11-26 12:51:47","remit_dt":"2018-11-26 12:51:47","createDt":"2018-11-26 12:51:47","updateDt":"2018-11-26 12:51:47","status":"01","order_flag":null}]
     * balance : 0
     */

    private int studentCount;
    private int distributionCount;
    private int balance;
    private List<DistributionBean> distribution;
    private List<?> studentList;
    private List<?> goodsOrderList;
    private List<WithdrawListBean> withdrawList;

    public int getStudentCount() {
        return studentCount;
    }

    public void setStudentCount(int studentCount) {
        this.studentCount = studentCount;
    }

    public int getDistributionCount() {
        return distributionCount;
    }

    public void setDistributionCount(int distributionCount) {
        this.distributionCount = distributionCount;
    }

    public int getBalance() {
        return balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }

    public List<DistributionBean> getDistribution() {
        return distribution;
    }

    public void setDistribution(List<DistributionBean> distribution) {
        this.distribution = distribution;
    }

    public List<?> getStudentList() {
        return studentList;
    }

    public void setStudentList(List<?> studentList) {
        this.studentList = studentList;
    }

    public List<?> getGoodsOrderList() {
        return goodsOrderList;
    }

    public void setGoodsOrderList(List<?> goodsOrderList) {
        this.goodsOrderList = goodsOrderList;
    }

    public List<WithdrawListBean> getWithdrawList() {
        return withdrawList;
    }

    public void setWithdrawList(List<WithdrawListBean> withdrawList) {
        this.withdrawList = withdrawList;
    }

    public static class DistributionBean implements Serializable {
        /**
         * id : 1178
         * name : null
         * user_id : 1192
         * id_no : null
         * nickname : A丶祝洪智*
         * sex : 1
         * province : 暂无
         * city : 暂无
         * area : null
         * address : null
         * email : null
         * mobile_no : null
         * qq : null
         * wechat : null
         * profile : null
         * desp : null
         * head_file : http://thirdwx.qlogo.cn/mmopen/vi_32/Q0j4TwGTfTJyos9KR4uD04wQZSXfxEuZxABlFpEI5s4fZXiaUmJzY761lWmPtM2LK8myvlRQul7mFgUpDzalVhg/132
         * status : 0
         * is_vip : 1
         * balance : 2
         * virtual_currency : 36
         * bind_card_no : null
         * bind_card_opennode_no : null
         * bind_card_opennode_name : null
         * recommend_user_id : null
         * goods_address : null
         * is_test : 0
         * sign_date : null
         * createDt : 2019-02-28 14:31:01
         * updateDt : 2019-07-19 14:13:29
         * agent_user_1 : 2317
         * agent_user_2 : null
         * agent_user_3 : null
         * user_shool_id : 132
         * password : null
         */

        private int id;
        private Object name;
        private int user_id;
        private Object id_no;
        private String nickname;
        private String sex;
        private String province;
        private String city;
        private Object area;
        private Object address;
        private Object email;
        private Object mobile_no;
        private Object qq;
        private Object wechat;
        private Object profile;
        private Object desp;
        private String head_file;
        private String status;
        private String is_vip;
        private int balance;
        private int virtual_currency;
        private Object bind_card_no;
        private Object bind_card_opennode_no;
        private Object bind_card_opennode_name;
        private Object recommend_user_id;
        private Object goods_address;
        private String is_test;
        private Object sign_date;
        private String createDt;
        private String updateDt;
        private int agent_user_1;
        private Object agent_user_2;
        private Object agent_user_3;
        private int user_shool_id;
        private Object password;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public Object getName() {
            return name;
        }

        public void setName(Object name) {
            this.name = name;
        }

        public int getUser_id() {
            return user_id;
        }

        public void setUser_id(int user_id) {
            this.user_id = user_id;
        }

        public Object getId_no() {
            return id_no;
        }

        public void setId_no(Object id_no) {
            this.id_no = id_no;
        }

        public String getNickname() {
            return nickname;
        }

        public void setNickname(String nickname) {
            this.nickname = nickname;
        }

        public String getSex() {
            return sex;
        }

        public void setSex(String sex) {
            this.sex = sex;
        }

        public String getProvince() {
            return province;
        }

        public void setProvince(String province) {
            this.province = province;
        }

        public String getCity() {
            return city;
        }

        public void setCity(String city) {
            this.city = city;
        }

        public Object getArea() {
            return area;
        }

        public void setArea(Object area) {
            this.area = area;
        }

        public Object getAddress() {
            return address;
        }

        public void setAddress(Object address) {
            this.address = address;
        }

        public Object getEmail() {
            return email;
        }

        public void setEmail(Object email) {
            this.email = email;
        }

        public Object getMobile_no() {
            return mobile_no;
        }

        public void setMobile_no(Object mobile_no) {
            this.mobile_no = mobile_no;
        }

        public Object getQq() {
            return qq;
        }

        public void setQq(Object qq) {
            this.qq = qq;
        }

        public Object getWechat() {
            return wechat;
        }

        public void setWechat(Object wechat) {
            this.wechat = wechat;
        }

        public Object getProfile() {
            return profile;
        }

        public void setProfile(Object profile) {
            this.profile = profile;
        }

        public Object getDesp() {
            return desp;
        }

        public void setDesp(Object desp) {
            this.desp = desp;
        }

        public String getHead_file() {
            return head_file;
        }

        public void setHead_file(String head_file) {
            this.head_file = head_file;
        }

        public String getStatus() {
            return status;
        }

        public void setStatus(String status) {
            this.status = status;
        }

        public String getIs_vip() {
            return is_vip;
        }

        public void setIs_vip(String is_vip) {
            this.is_vip = is_vip;
        }

        public int getBalance() {
            return balance;
        }

        public void setBalance(int balance) {
            this.balance = balance;
        }

        public int getVirtual_currency() {
            return virtual_currency;
        }

        public void setVirtual_currency(int virtual_currency) {
            this.virtual_currency = virtual_currency;
        }

        public Object getBind_card_no() {
            return bind_card_no;
        }

        public void setBind_card_no(Object bind_card_no) {
            this.bind_card_no = bind_card_no;
        }

        public Object getBind_card_opennode_no() {
            return bind_card_opennode_no;
        }

        public void setBind_card_opennode_no(Object bind_card_opennode_no) {
            this.bind_card_opennode_no = bind_card_opennode_no;
        }

        public Object getBind_card_opennode_name() {
            return bind_card_opennode_name;
        }

        public void setBind_card_opennode_name(Object bind_card_opennode_name) {
            this.bind_card_opennode_name = bind_card_opennode_name;
        }

        public Object getRecommend_user_id() {
            return recommend_user_id;
        }

        public void setRecommend_user_id(Object recommend_user_id) {
            this.recommend_user_id = recommend_user_id;
        }

        public Object getGoods_address() {
            return goods_address;
        }

        public void setGoods_address(Object goods_address) {
            this.goods_address = goods_address;
        }

        public String getIs_test() {
            return is_test;
        }

        public void setIs_test(String is_test) {
            this.is_test = is_test;
        }

        public Object getSign_date() {
            return sign_date;
        }

        public void setSign_date(Object sign_date) {
            this.sign_date = sign_date;
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

        public int getAgent_user_1() {
            return agent_user_1;
        }

        public void setAgent_user_1(int agent_user_1) {
            this.agent_user_1 = agent_user_1;
        }

        public Object getAgent_user_2() {
            return agent_user_2;
        }

        public void setAgent_user_2(Object agent_user_2) {
            this.agent_user_2 = agent_user_2;
        }

        public Object getAgent_user_3() {
            return agent_user_3;
        }

        public void setAgent_user_3(Object agent_user_3) {
            this.agent_user_3 = agent_user_3;
        }

        public int getUser_shool_id() {
            return user_shool_id;
        }

        public void setUser_shool_id(int user_shool_id) {
            this.user_shool_id = user_shool_id;
        }

        public Object getPassword() {
            return password;
        }

        public void setPassword(Object password) {
            this.password = password;
        }
    }

    public static class WithdrawListBean implements Serializable {
        /**
         * id : 13
         * user_login_id : 2317
         * real_name : lly
         * bankName : 中国建设银行济南分行
         * bank_card_no : 6236682340007344897
         * apply_money : 84000
         * apply_dt : 2018-11-26 12:51:47
         * remit_dt : 2018-11-26 12:51:47
         * createDt : 2018-11-26 12:51:47
         * updateDt : 2018-11-26 12:51:47
         * status : 01
         * order_flag : null
         */

        private int id;
        private int user_login_id;
        private String real_name;
        private String bankName;
        private String bank_card_no;
        private int apply_money;
        private String apply_dt;
        private String remit_dt;
        private String createDt;
        private String updateDt;
        private String status;
        private Object order_flag;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public int getUser_login_id() {
            return user_login_id;
        }

        public void setUser_login_id(int user_login_id) {
            this.user_login_id = user_login_id;
        }

        public String getReal_name() {
            return real_name;
        }

        public void setReal_name(String real_name) {
            this.real_name = real_name;
        }

        public String getBankName() {
            return bankName;
        }

        public void setBankName(String bankName) {
            this.bankName = bankName;
        }

        public String getBank_card_no() {
            return bank_card_no;
        }

        public void setBank_card_no(String bank_card_no) {
            this.bank_card_no = bank_card_no;
        }

        public int getApply_money() {
            return apply_money;
        }

        public void setApply_money(int apply_money) {
            this.apply_money = apply_money;
        }

        public String getApply_dt() {
            return apply_dt;
        }

        public void setApply_dt(String apply_dt) {
            this.apply_dt = apply_dt;
        }

        public String getRemit_dt() {
            return remit_dt;
        }

        public void setRemit_dt(String remit_dt) {
            this.remit_dt = remit_dt;
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

        public String getStatus() {
            return status;
        }

        public void setStatus(String status) {
            this.status = status;
        }

        public Object getOrder_flag() {
            return order_flag;
        }

        public void setOrder_flag(Object order_flag) {
            this.order_flag = order_flag;
        }
    }
}
