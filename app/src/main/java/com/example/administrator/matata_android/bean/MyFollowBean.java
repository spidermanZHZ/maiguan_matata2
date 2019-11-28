package com.example.administrator.matata_android.bean;

import java.io.Serializable;
import java.util.List;

public class MyFollowBean implements Serializable {
    private List<TeacherBeanX> teacher;
    private List<OnlineCourseBeanX> online_course;
    private List<OfflineCourseBean> offline_course;

    public List<TeacherBeanX> getTeacher() {
        return teacher;
    }

    public void setTeacher(List<TeacherBeanX> teacher) {
        this.teacher = teacher;
    }

    public List<OnlineCourseBeanX> getOnline_course() {
        return online_course;
    }

    public void setOnline_course(List<OnlineCourseBeanX> online_course) {
        this.online_course = online_course;
    }

    public List<OfflineCourseBean> getOffline_course() {
        return offline_course;
    }

    public void setOffline_course(List<OfflineCourseBean> offline_course) {
        this.offline_course = offline_course;
    }

    public static class TeacherBeanX {
        /**
         * id : 296
         * user_id : 2317
         * busi_type : 00
         * favorite_id : 80
         * status : 0
         * createDt : 2019-11-28 15:19:52
         * updateDt : 2019-11-28 15:19:52
         * teacher : {"id":80,"class_id":82,"name":"董琦","id_no":"370123198701181036","sex":"1","province":"山东省","city":"济南市","area":"槐荫区","address":"经六纬十二路道德商城四层","longitude":"116.982194","latitude":"36.660378","certification":"大学音乐","grade":"普通","email":null,"mobile_no":"13791122220","qq":null,"wechat":null,"profile":"<p><\/p><div class=\"media-wrap image-wrap\"><img src=\"/matata_server/showFile/showImage?fk=3473ec6a7b2a46589fa689e8c152f060.jpeg&amp;show=null\"/><\/div><p><\/p>","description":"爵士鼓老师\n\n济南打击乐协会副会长\n\n曾任聘于罗兰电鼓教室担任架子鼓专业教师","introduction_video":null,"introduction_images":"storage/2019-07-05/xC6pdBeBIOHmOdZ1OT9u53odUmt8aXU3QJGWh6NU.jpeg","head_pic":"storage/2019-07-05/sVlCcwIuSFeaGJ2IFWZfyliYkFfNxwVqYwLSxAn1.jpeg","sort":30,"sign_date":"2018-05-10","expiry_date":"2019-05-01","status":"0","createDt":"2018-05-10 16:08:12","updateDt":"2019-07-05 15:46:27","wx_openId":"oPXpC02WQGXiSj4qMMxY6f5emC9c","goods_extract":null,"stars":0,"major":null,"index":null}
         */

        private int id;
        private int user_id;
        private String busi_type;
        private int favorite_id;
        private String status;
        private String createDt;
        private String updateDt;
        private TeacherBean teacher;

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

        public String getBusi_type() {
            return busi_type;
        }

        public void setBusi_type(String busi_type) {
            this.busi_type = busi_type;
        }

        public int getFavorite_id() {
            return favorite_id;
        }

        public void setFavorite_id(int favorite_id) {
            this.favorite_id = favorite_id;
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

        public TeacherBean getTeacher() {
            return teacher;
        }

        public void setTeacher(TeacherBean teacher) {
            this.teacher = teacher;
        }

        public static class TeacherBean {
            /**
             * id : 80
             * class_id : 82
             * name : 董琦
             * id_no : 370123198701181036
             * sex : 1
             * province : 山东省
             * city : 济南市
             * area : 槐荫区
             * address : 经六纬十二路道德商城四层
             * longitude : 116.982194
             * latitude : 36.660378
             * certification : 大学音乐
             * grade : 普通
             * email : null
             * mobile_no : 13791122220
             * qq : null
             * wechat : null
             * profile : <p></p><div class="media-wrap image-wrap"><img src="/matata_server/showFile/showImage?fk=3473ec6a7b2a46589fa689e8c152f060.jpeg&amp;show=null"/></div><p></p>
             * description : 爵士鼓老师

             济南打击乐协会副会长

             曾任聘于罗兰电鼓教室担任架子鼓专业教师
             * introduction_video : null
             * introduction_images : storage/2019-07-05/xC6pdBeBIOHmOdZ1OT9u53odUmt8aXU3QJGWh6NU.jpeg
             * head_pic : storage/2019-07-05/sVlCcwIuSFeaGJ2IFWZfyliYkFfNxwVqYwLSxAn1.jpeg
             * sort : 30
             * sign_date : 2018-05-10
             * expiry_date : 2019-05-01
             * status : 0
             * createDt : 2018-05-10 16:08:12
             * updateDt : 2019-07-05 15:46:27
             * wx_openId : oPXpC02WQGXiSj4qMMxY6f5emC9c
             * goods_extract : null
             * stars : 0
             * major : null
             * index : null
             */

            private int id;
            private int class_id;
            private String name;
            private String id_no;
            private String sex;
            private String province;
            private String city;
            private String area;
            private String address;
            private String longitude;
            private String latitude;
            private String certification;
            private String grade;
            private Object email;
            private String mobile_no;
            private Object qq;
            private Object wechat;
            private String profile;
            private String description;
            private Object introduction_video;
            private String introduction_images;
            private String head_pic;
            private int sort;
            private String sign_date;
            private String expiry_date;
            private String status;
            private String createDt;
            private String updateDt;
            private String wx_openId;
            private Object goods_extract;
            private int stars;
            private Object major;
            private Object index;

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

            public String getId_no() {
                return id_no;
            }

            public void setId_no(String id_no) {
                this.id_no = id_no;
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

            public String getArea() {
                return area;
            }

            public void setArea(String area) {
                this.area = area;
            }

            public String getAddress() {
                return address;
            }

            public void setAddress(String address) {
                this.address = address;
            }

            public String getLongitude() {
                return longitude;
            }

            public void setLongitude(String longitude) {
                this.longitude = longitude;
            }

            public String getLatitude() {
                return latitude;
            }

            public void setLatitude(String latitude) {
                this.latitude = latitude;
            }

            public String getCertification() {
                return certification;
            }

            public void setCertification(String certification) {
                this.certification = certification;
            }

            public String getGrade() {
                return grade;
            }

            public void setGrade(String grade) {
                this.grade = grade;
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

            public Object getIntroduction_video() {
                return introduction_video;
            }

            public void setIntroduction_video(Object introduction_video) {
                this.introduction_video = introduction_video;
            }

            public String getIntroduction_images() {
                return introduction_images;
            }

            public void setIntroduction_images(String introduction_images) {
                this.introduction_images = introduction_images;
            }

            public String getHead_pic() {
                return head_pic;
            }

            public void setHead_pic(String head_pic) {
                this.head_pic = head_pic;
            }

            public int getSort() {
                return sort;
            }

            public void setSort(int sort) {
                this.sort = sort;
            }

            public String getSign_date() {
                return sign_date;
            }

            public void setSign_date(String sign_date) {
                this.sign_date = sign_date;
            }

            public String getExpiry_date() {
                return expiry_date;
            }

            public void setExpiry_date(String expiry_date) {
                this.expiry_date = expiry_date;
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

            public String getWx_openId() {
                return wx_openId;
            }

            public void setWx_openId(String wx_openId) {
                this.wx_openId = wx_openId;
            }

            public Object getGoods_extract() {
                return goods_extract;
            }

            public void setGoods_extract(Object goods_extract) {
                this.goods_extract = goods_extract;
            }

            public int getStars() {
                return stars;
            }

            public void setStars(int stars) {
                this.stars = stars;
            }

            public Object getMajor() {
                return major;
            }

            public void setMajor(Object major) {
                this.major = major;
            }

            public Object getIndex() {
                return index;
            }

            public void setIndex(Object index) {
                this.index = index;
            }
        }
    }

    public static class OnlineCourseBeanX {
        /**
         * id : 295
         * user_id : 2317
         * busi_type : 01
         * favorite_id : 22
         * status : 0
         * createDt : 2019-11-28 15:19:41
         * updateDt : 2019-11-28 15:19:41
         * online_course : {"id":22,"class_id":51,"name":"打击乐协会会长亲自上阵 演示架子鼓基础训练","teacher_id":130,"theme_id":0,"num":7,"original_price":0,"discount_price":0,"deductible_virtual_currency":0,"deductible_real_currency":0,"largess_virtual_currency":0,"profile":"<p style=\"text-align:center;\"><\/p><div class=\"media-wrap image-wrap\"><img src=\"/matata_server/showFile/showImage?fk=71fb4abe07844ef5a16a4445ab65478d.jpeg&amp;show=null\"/><\/div><p><\/p>","description":"架子鼓基础课程与演练","cover_pic":"storage/2019-11-12/Bhc4xMgzl1yP4P1KxysLCVhj3JONevZQvlprYGTF.jpeg","detail_pic":"storage/2019-07-30/3rJxSnaIQjGHZgYX5wY9cVeeQC0Dovm15kWmptya.jpeg","distribution_ratio1":0,"distribution_ratio2":0,"distribution_ratio3":null,"click_rate":0,"sort":1,"status":"0","createDt":"2018-05-12 08:28:14","updateDt":"2019-11-12 14:16:41","up_type":"0","up_dt1_start":"2019-01-04 00:00:00","up_dt1_end":"2019-01-11 23:59:59","up_dt2":0,"up_dt3":null,"up_users2":0,"vip_price":0,"stars":15}
         */

        private int id;
        private int user_id;
        private String busi_type;
        private int favorite_id;
        private String status;
        private String createDt;
        private String updateDt;
        private OnlineCourseBean online_course;

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

        public String getBusi_type() {
            return busi_type;
        }

        public void setBusi_type(String busi_type) {
            this.busi_type = busi_type;
        }

        public int getFavorite_id() {
            return favorite_id;
        }

        public void setFavorite_id(int favorite_id) {
            this.favorite_id = favorite_id;
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

        public OnlineCourseBean getOnline_course() {
            return online_course;
        }

        public void setOnline_course(OnlineCourseBean online_course) {
            this.online_course = online_course;
        }

        public static class OnlineCourseBean {
            /**
             * id : 22
             * class_id : 51
             * name : 打击乐协会会长亲自上阵 演示架子鼓基础训练
             * teacher_id : 130
             * theme_id : 0
             * num : 7
             * original_price : 0
             * discount_price : 0
             * deductible_virtual_currency : 0
             * deductible_real_currency : 0
             * largess_virtual_currency : 0
             * profile : <p style="text-align:center;"></p><div class="media-wrap image-wrap"><img src="/matata_server/showFile/showImage?fk=71fb4abe07844ef5a16a4445ab65478d.jpeg&amp;show=null"/></div><p></p>
             * description : 架子鼓基础课程与演练
             * cover_pic : storage/2019-11-12/Bhc4xMgzl1yP4P1KxysLCVhj3JONevZQvlprYGTF.jpeg
             * detail_pic : storage/2019-07-30/3rJxSnaIQjGHZgYX5wY9cVeeQC0Dovm15kWmptya.jpeg
             * distribution_ratio1 : 0
             * distribution_ratio2 : 0
             * distribution_ratio3 : null
             * click_rate : 0
             * sort : 1
             * status : 0
             * createDt : 2018-05-12 08:28:14
             * updateDt : 2019-11-12 14:16:41
             * up_type : 0
             * up_dt1_start : 2019-01-04 00:00:00
             * up_dt1_end : 2019-01-11 23:59:59
             * up_dt2 : 0
             * up_dt3 : null
             * up_users2 : 0
             * vip_price : 0
             * stars : 15
             */

            private int id;
            private int class_id;
            private String name;
            private int teacher_id;
            private int theme_id;
            private int num;
            private int original_price;
            private int discount_price;
            private int deductible_virtual_currency;
            private int deductible_real_currency;
            private int largess_virtual_currency;
            private String profile;
            private String description;
            private String cover_pic;
            private String detail_pic;
            private int distribution_ratio1;
            private int distribution_ratio2;
            private Object distribution_ratio3;
            private int click_rate;
            private int sort;
            private String status;
            private String createDt;
            private String updateDt;
            private String up_type;
            private String up_dt1_start;
            private String up_dt1_end;
            private int up_dt2;
            private Object up_dt3;
            private int up_users2;
            private int vip_price;
            private int stars;

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

            public int getTheme_id() {
                return theme_id;
            }

            public void setTheme_id(int theme_id) {
                this.theme_id = theme_id;
            }

            public int getNum() {
                return num;
            }

            public void setNum(int num) {
                this.num = num;
            }

            public int getOriginal_price() {
                return original_price;
            }

            public void setOriginal_price(int original_price) {
                this.original_price = original_price;
            }

            public int getDiscount_price() {
                return discount_price;
            }

            public void setDiscount_price(int discount_price) {
                this.discount_price = discount_price;
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

            public String getDetail_pic() {
                return detail_pic;
            }

            public void setDetail_pic(String detail_pic) {
                this.detail_pic = detail_pic;
            }

            public int getDistribution_ratio1() {
                return distribution_ratio1;
            }

            public void setDistribution_ratio1(int distribution_ratio1) {
                this.distribution_ratio1 = distribution_ratio1;
            }

            public int getDistribution_ratio2() {
                return distribution_ratio2;
            }

            public void setDistribution_ratio2(int distribution_ratio2) {
                this.distribution_ratio2 = distribution_ratio2;
            }

            public Object getDistribution_ratio3() {
                return distribution_ratio3;
            }

            public void setDistribution_ratio3(Object distribution_ratio3) {
                this.distribution_ratio3 = distribution_ratio3;
            }

            public int getClick_rate() {
                return click_rate;
            }

            public void setClick_rate(int click_rate) {
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

            public String getUp_type() {
                return up_type;
            }

            public void setUp_type(String up_type) {
                this.up_type = up_type;
            }

            public String getUp_dt1_start() {
                return up_dt1_start;
            }

            public void setUp_dt1_start(String up_dt1_start) {
                this.up_dt1_start = up_dt1_start;
            }

            public String getUp_dt1_end() {
                return up_dt1_end;
            }

            public void setUp_dt1_end(String up_dt1_end) {
                this.up_dt1_end = up_dt1_end;
            }

            public int getUp_dt2() {
                return up_dt2;
            }

            public void setUp_dt2(int up_dt2) {
                this.up_dt2 = up_dt2;
            }

            public Object getUp_dt3() {
                return up_dt3;
            }

            public void setUp_dt3(Object up_dt3) {
                this.up_dt3 = up_dt3;
            }

            public int getUp_users2() {
                return up_users2;
            }

            public void setUp_users2(int up_users2) {
                this.up_users2 = up_users2;
            }

            public int getVip_price() {
                return vip_price;
            }

            public void setVip_price(int vip_price) {
                this.vip_price = vip_price;
            }

            public int getStars() {
                return stars;
            }

            public void setStars(int stars) {
                this.stars = stars;
            }
        }
    }

    public static class OfflineCourseBean {
        /**
         * id : 290
         * user_id : 2317
         * busi_type : 04
         * favorite_id : 50
         * status : 0
         * createDt : 2019-11-28 14:38:14
         * updateDt : 2019-11-28 14:38:14
         * offline_course : null
         */

        private int id;
        private int user_id;
        private String busi_type;
        private int favorite_id;
        private String status;
        private String createDt;
        private String updateDt;
        private Object offline_course;

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

        public String getBusi_type() {
            return busi_type;
        }

        public void setBusi_type(String busi_type) {
            this.busi_type = busi_type;
        }

        public int getFavorite_id() {
            return favorite_id;
        }

        public void setFavorite_id(int favorite_id) {
            this.favorite_id = favorite_id;
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

        public Object getOffline_course() {
            return offline_course;
        }

        public void setOffline_course(Object offline_course) {
            this.offline_course = offline_course;
        }
    }
}
