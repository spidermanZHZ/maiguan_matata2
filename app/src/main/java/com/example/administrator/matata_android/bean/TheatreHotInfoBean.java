package com.example.administrator.matata_android.bean;

import java.io.Serializable;
import java.util.List;

public class TheatreHotInfoBean implements Serializable {
    private List<CourseBean> course;
    private List<?> banner;

    public List<CourseBean> getCourse() {
        return course;
    }

    public void setCourse(List<CourseBean> course) {
        this.course = course;
    }

    public List<?> getBanner() {
        return banner;
    }

    public void setBanner(List<?> banner) {
        this.banner = banner;
    }

    public static class CourseBean {
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
        private List<String> detail_pic;

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

        public List<String> getDetail_pic() {
            return detail_pic;
        }

        public void setDetail_pic(List<String> detail_pic) {
            this.detail_pic = detail_pic;
        }
    }
}
