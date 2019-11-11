package com.example.administrator.matata_android.bean;

import java.io.Serializable;
import java.util.List;

public class OffLineCourseBean implements Serializable {
    /**
     * id : 7
     * class_id : 52
     * name : 2236
     * teacher_id : 84
     * theme_id : null
     * num : 3
     * price : {"month":{"name":"\u6708\u5361","price":300,"num":"3","day":"3"},"season":{"name":"\u5b63\u5361","price":300,"num":"3","day":"3"},"year":{"name":"\u5e74\u5361","price":300,"num":"3","day":"3"}}
     * deductible_virtual_currency : 3
     * deductible_real_currency : 0
     * largess_virtual_currency : 3
     * profile : <p>3</p>
     * description : 3
     * cover_pic : storage/2019-10-10/yQplMFKYvHkJiDITDTbfkKnReNBF9N8vkXp1nsdK.png
     * detail_pic : ["storage/2019-10-10/kxilTnQm2dips8EHqljsBVQhtP2OM1XN3Ska9BxJ.png"]
     * distribution_ratio1 : null
     * distribution_ratio2 : null
     * distribution_ratio3 : null
     * click_rate : null
     * sort : 1
     * status : 0
     * createDt : 2019-10-10 14:50:32
     * updateDt : 2019-10-10 14:51:07
     * stars : 0
     * discount : 3
     * course_type : drama
     * isFavorite : false
     * evaluate : []
     * catalog : []
     * pay_num : 0
     * classify : {"id":52,"name":"弦乐"}
     */

    private int id;
    private int class_id;
    private String name;
    private int teacher_id;
    private Object theme_id;
    private int num;
    private String price;
    private int deductible_virtual_currency;
    private int deductible_real_currency;
    private int largess_virtual_currency;
    private String profile;
    private String description;
    private String cover_pic;
    private Object distribution_ratio1;
    private Object distribution_ratio2;
    private Object distribution_ratio3;
    private Object click_rate;
    private int sort;
    private String status;
    private String createDt;
    private String updateDt;
    private int stars;
    private int discount;
    private String course_type;
    private boolean isFavorite;
    private int pay_num;
    private ClassifyBean classify;
    private List<String> detail_pic;
    private List<EvaluateBean> evaluate;
    private List<?> catalog;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getClass_id() {
        return class_id;
    }

    public void setClass_id(int class_id) {
        this.class_id = class_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getTeacher_id() {
        return teacher_id;
    }

    public void setTeacher_id(int teacher_id) {
        this.teacher_id = teacher_id;
    }

    public Object getTheme_id() {
        return theme_id;
    }

    public void setTheme_id(Object theme_id) {
        this.theme_id = theme_id;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public int getDeductible_virtual_currency() {
        return deductible_virtual_currency;
    }

    public void setDeductible_virtual_currency(int deductible_virtual_currency) {
        this.deductible_virtual_currency = deductible_virtual_currency;
    }

    public int getDeductible_real_currency() {
        return deductible_real_currency;
    }

    public void setDeductible_real_currency(int deductible_real_currency) {
        this.deductible_real_currency = deductible_real_currency;
    }

    public int getLargess_virtual_currency() {
        return largess_virtual_currency;
    }

    public void setLargess_virtual_currency(int largess_virtual_currency) {
        this.largess_virtual_currency = largess_virtual_currency;
    }

    public String getProfile() {
        return profile;
    }

    public void setProfile(String profile) {
        this.profile = profile;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCover_pic() {
        return cover_pic;
    }

    public void setCover_pic(String cover_pic) {
        this.cover_pic = cover_pic;
    }

    public Object getDistribution_ratio1() {
        return distribution_ratio1;
    }

    public void setDistribution_ratio1(Object distribution_ratio1) {
        this.distribution_ratio1 = distribution_ratio1;
    }

    public Object getDistribution_ratio2() {
        return distribution_ratio2;
    }

    public void setDistribution_ratio2(Object distribution_ratio2) {
        this.distribution_ratio2 = distribution_ratio2;
    }

    public Object getDistribution_ratio3() {
        return distribution_ratio3;
    }

    public void setDistribution_ratio3(Object distribution_ratio3) {
        this.distribution_ratio3 = distribution_ratio3;
    }

    public Object getClick_rate() {
        return click_rate;
    }

    public void setClick_rate(Object click_rate) {
        this.click_rate = click_rate;
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

    public int getStars() {
        return stars;
    }

    public void setStars(int stars) {
        this.stars = stars;
    }

    public int getDiscount() {
        return discount;
    }

    public void setDiscount(int discount) {
        this.discount = discount;
    }

    public String getCourse_type() {
        return course_type;
    }

    public void setCourse_type(String course_type) {
        this.course_type = course_type;
    }

    public boolean isIsFavorite() {
        return isFavorite;
    }

    public void setIsFavorite(boolean isFavorite) {
        this.isFavorite = isFavorite;
    }

    public int getPay_num() {
        return pay_num;
    }

    public void setPay_num(int pay_num) {
        this.pay_num = pay_num;
    }

    public ClassifyBean getClassify() {
        return classify;
    }

    public void setClassify(ClassifyBean classify) {
        this.classify = classify;
    }

    public List<String> getDetail_pic() {
        return detail_pic;
    }

    public void setDetail_pic(List<String> detail_pic) {
        this.detail_pic = detail_pic;
    }

    public List<EvaluateBean> getEvaluate() {
        return evaluate;
    }

    public void setEvaluate(List<EvaluateBean> evaluate) {
        this.evaluate = evaluate;
    }

    public List<?> getCatalog() {
        return catalog;
    }

    public void setCatalog(List<?> catalog) {
        this.catalog = catalog;
    }
    public static class EvaluateBean implements Serializable {
        /**
         * id : 256
         * is_anonymous : 1
         * user_id : 897
         * busi_type : 01
         * order_id : 0
         * obj_id : 22
         * desc_consistent : 5
         * feel : 5
         * service_attitude : 5
         * evaluate_content : 111
         * status : 0
         * evaluate_time : 2018-10-13 09:42:43
         * reply_admin_id : null
         * reply_content : null
         * reply_time : null
         * updateDt : 2018-10-13 09:42:43
         * obj_name : 打击乐协会会长亲自上阵 演示架子鼓基础训练
         * fd_user_name : null
         * fd_user_head : null
         */

        private int id;
        private String is_anonymous;
        private int user_id;
        private String busi_type;
        private int order_id;
        private int obj_id;
        private String desc_consistent;
        private String feel;
        private String service_attitude;
        private String evaluate_content;
        private String status;
        private String evaluate_time;
        private Object reply_admin_id;
        private Object reply_content;
        private Object reply_time;
        private String updateDt;
        private String obj_name;
        private Object fd_user_name;
        private Object fd_user_head;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getIs_anonymous() {
            return is_anonymous;
        }

        public void setIs_anonymous(String is_anonymous) {
            this.is_anonymous = is_anonymous;
        }

        public int getUser_id() {
            return user_id;
        }

        public void setUser_id(int user_id) {
            this.user_id = user_id;
        }

        public String getBusi_type() {
            return busi_type;
        }

        public void setBusi_type(String busi_type) {
            this.busi_type = busi_type;
        }

        public int getOrder_id() {
            return order_id;
        }

        public void setOrder_id(int order_id) {
            this.order_id = order_id;
        }

        public int getObj_id() {
            return obj_id;
        }

        public void setObj_id(int obj_id) {
            this.obj_id = obj_id;
        }

        public String getDesc_consistent() {
            return desc_consistent;
        }

        public void setDesc_consistent(String desc_consistent) {
            this.desc_consistent = desc_consistent;
        }

        public String getFeel() {
            return feel;
        }

        public void setFeel(String feel) {
            this.feel = feel;
        }

        public String getService_attitude() {
            return service_attitude;
        }

        public void setService_attitude(String service_attitude) {
            this.service_attitude = service_attitude;
        }

        public String getEvaluate_content() {
            return evaluate_content;
        }

        public void setEvaluate_content(String evaluate_content) {
            this.evaluate_content = evaluate_content;
        }

        public String getStatus() {
            return status;
        }

        public void setStatus(String status) {
            this.status = status;
        }

        public String getEvaluate_time() {
            return evaluate_time;
        }

        public void setEvaluate_time(String evaluate_time) {
            this.evaluate_time = evaluate_time;
        }

        public Object getReply_admin_id() {
            return reply_admin_id;
        }

        public void setReply_admin_id(Object reply_admin_id) {
            this.reply_admin_id = reply_admin_id;
        }

        public Object getReply_content() {
            return reply_content;
        }

        public void setReply_content(Object reply_content) {
            this.reply_content = reply_content;
        }

        public Object getReply_time() {
            return reply_time;
        }

        public void setReply_time(Object reply_time) {
            this.reply_time = reply_time;
        }

        public String getUpdateDt() {
            return updateDt;
        }

        public void setUpdateDt(String updateDt) {
            this.updateDt = updateDt;
        }

        public String getObj_name() {
            return obj_name;
        }

        public void setObj_name(String obj_name) {
            this.obj_name = obj_name;
        }

        public Object getFd_user_name() {
            return fd_user_name;
        }

        public void setFd_user_name(Object fd_user_name) {
            this.fd_user_name = fd_user_name;
        }

        public Object getFd_user_head() {
            return fd_user_head;
        }

        public void setFd_user_head(Object fd_user_head) {
            this.fd_user_head = fd_user_head;
        }
    }
    public static class ClassifyBean {
        /**
         * id : 52
         * name : 弦乐
         */

        private int id;
        private String name;

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
}
