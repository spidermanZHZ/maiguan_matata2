package com.example.administrator.matata_android.bean;

import java.io.Serializable;
import java.util.List;

public class UserInfoBean implements Serializable {
    /**
     * id : 2304
     * name :
     * user_id : 2317
     * id_no : null
     * nickname :
     * sex : 2
     * province : null
     * city : null
     * area : null
     * address : null
     * email : null
     * mobile_no : 15665814171
     * qq : null
     * wechat : null
     * profile : null
     * desp : null
     * head_file : null
     * status : 0
     * is_vip : 0
     * balance : 0
     * virtual_currency : 0
     * bind_card_no : null
     * bind_card_opennode_no : null
     * bind_card_opennode_name : null
     * recommend_user_id : null
     * goods_address : null
     * is_test : 0
     * sign_date : null
     * createDt : 2019-11-04 15:11:08
     * updateDt : 2019-11-04 15:11:08
     * agent_user_1 : null
     * agent_user_2 : null
     * agent_user_3 : null
     * user_shool_id : null
     * password : fcea920f7412b5da7be0cf42b8c93759
     * user_child : [{"id":19,"user_id":2317,"name":"马它它","sex":"1","age":"8","signature":"好好学习","head_file":"storage/2019-11-12/fzn3iOPRf9LdrJ12Ee8HGu72ZKTcP6Gtls7pK9bM.png","grade":0,"plan":"{\"day\":[\"3\",\" 4\",\" 5\"],\"time\":2520}","createDt":"2019-11-12 14:41:02","updateDt":"2019-11-12 16:24:23"}]
     * vip_info : null
     */

    private int id;
    private String name;
    private int user_id;
    private Object id_no;
    private String nickname;
    private String sex;
    private Object province;
    private Object city;
    private Object area;
    private Object address;
    private Object email;
    private String mobile_no;
    private Object qq;
    private Object wechat;
    private Object profile;
    private Object desp;
    private Object head_file;
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
    private Object agent_user_1;
    private Object agent_user_2;
    private Object agent_user_3;
    private Object user_shool_id;
    private String password;
    private Object vip_info;
    private List<UserChildBean> user_child;

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

    public Object getProvince() {
        return province;
    }

    public void setProvince(Object province) {
        this.province = province;
    }

    public Object getCity() {
        return city;
    }

    public void setCity(Object city) {
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

    public String getMobile_no() {
        return mobile_no;
    }

    public void setMobile_no(String mobile_no) {
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

    public Object getHead_file() {
        return head_file;
    }

    public void setHead_file(Object head_file) {
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

    public Object getAgent_user_1() {
        return agent_user_1;
    }

    public void setAgent_user_1(Object agent_user_1) {
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

    public Object getUser_shool_id() {
        return user_shool_id;
    }

    public void setUser_shool_id(Object user_shool_id) {
        this.user_shool_id = user_shool_id;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Object getVip_info() {
        return vip_info;
    }

    public void setVip_info(Object vip_info) {
        this.vip_info = vip_info;
    }

    public List<UserChildBean> getUser_child() {
        return user_child;
    }

    public void setUser_child(List<UserChildBean> user_child) {
        this.user_child = user_child;
    }

    public static class UserChildBean {
        /**
         * id : 19
         * user_id : 2317
         * name : 马它它
         * sex : 1
         * age : 8
         * signature : 好好学习
         * head_file : storage/2019-11-12/fzn3iOPRf9LdrJ12Ee8HGu72ZKTcP6Gtls7pK9bM.png
         * grade : 0
         * plan : {"day":["3"," 4"," 5"],"time":2520}
         * createDt : 2019-11-12 14:41:02
         * updateDt : 2019-11-12 16:24:23
         */

        private int id;
        private int user_id;
        private String name;
        private String sex;
        private String age;
        private String signature;
        private String head_file;
        private int grade;
        private String plan;
        private String createDt;
        private String updateDt;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public int getUser_id() {
            return user_id;
        }

        public void setUser_id(int user_id) {
            this.user_id = user_id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getSex() {
            return sex;
        }

        public void setSex(String sex) {
            this.sex = sex;
        }

        public String getAge() {
            return age;
        }

        public void setAge(String age) {
            this.age = age;
        }

        public String getSignature() {
            return signature;
        }

        public void setSignature(String signature) {
            this.signature = signature;
        }

        public String getHead_file() {
            return head_file;
        }

        public void setHead_file(String head_file) {
            this.head_file = head_file;
        }

        public int getGrade() {
            return grade;
        }

        public void setGrade(int grade) {
            this.grade = grade;
        }

        public String getPlan() {
            return plan;
        }

        public void setPlan(String plan) {
            this.plan = plan;
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
    }
}
