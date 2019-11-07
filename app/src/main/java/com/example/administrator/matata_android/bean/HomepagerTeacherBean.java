package com.example.administrator.matata_android.bean;

import java.io.Serializable;
import java.util.List;

public class HomepagerTeacherBean implements Serializable {


    private List<TeacherBean> teacher;
    private List<CourseBean> course;
    private List<BannerBean> banner;

    public List<TeacherBean> getTeacher() {
        return teacher;
    }

    public void setTeacher(List<TeacherBean> teacher) {
        this.teacher = teacher;
    }

    public List<CourseBean> getCourse() {
        return course;
    }

    public void setCourse(List<CourseBean> course) {
        this.course = course;
    }

    public List<BannerBean> getBanner() {
        return banner;
    }

    public void setBanner(List<BannerBean> banner) {
        this.banner = banner;
    }

    public static class TeacherBean {
        /**
         * id : 83
         * class_id : 65
         * name : 毕涛
         * id_no : 370105199408083711
         * sex : 1
         * province : 山东省
         * city : 济南市
         * area : 历城区
         * address : 隆悦花园
         * longitude : 117.070398
         * latitude : 36.687623
         * certification : 大学音乐
         * grade : 普通
         * email : null
         * mobile_no : 18366115850
         * qq : null
         * wechat : null
         * profile : <p></p><div class="media-wrap image-wrap"><img src="/matata_server/showFile/showImage?fk=040cc66dcef240299cb416d7673fc8dc.png&amp;show=null"/></div><p></p>
         * description : 电吉他老师

         “意识形态”乐队组建者

         乐队多次获得音乐大赛一等奖
         * introduction_video : null
         * introduction_images : storage/2019-07-05/yLPX9k9QASo8PRJ4IGp0KWrfqkJuRuK2RaZaifJx.jpeg
         * head_pic : storage/2019-07-05/AOdAE5N7WTRzZePxLppbeDrEfIjvLfYokOqgK6NF.jpeg
         * sort : 5
         * sign_date : 2018-05-10
         * expiry_date : 2019-05-01
         * status : 0
         * createDt : 2018-05-10 16:18:51
         * updateDt : 2019-07-15 17:11:07
         * wx_openId : oPXpC05457LnACkoX0IPR57VrzvI
         * goods_extract : null
         * stars : 15
         * major : 吉他
         * index : 1
         * classify : {"id":65,"name":"吉他"}
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
        private String major;
        private int index;
        private ClassifyBean classify;

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

        public String getMajor() {
            return major;
        }

        public void setMajor(String major) {
            this.major = major;
        }

        public int getIndex() {
            return index;
        }

        public void setIndex(int index) {
            this.index = index;
        }

        public ClassifyBean getClassify() {
            return classify;
        }

        public void setClassify(ClassifyBean classify) {
            this.classify = classify;
        }

        public static class ClassifyBean {
            /**
             * id : 65
             * name : 吉他
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

    public static class CourseBean {
        /**
         * id : 22
         * name : 打击乐协会会长亲自上阵 演示架子鼓基础训练
         * sort : 1
         * price : 0
         * cover_pic : storage/2019-07-30/kBuoXeaHj1Xotv5ZsPHmclFS1CxGxbEQHlOFnfji.jpeg
         * course_type : 15
         * description : 架子鼓基础课程与演练
         * type : online
         */

        private int id;
        private String name;
        private int sort;
        private String price;
        private String cover_pic;
        private String course_type;
        private String description;
        private String type;

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

        public int getSort() {
            return sort;
        }

        public void setSort(int sort) {
            this.sort = sort;
        }

        public String getPrice() {
            return price;
        }

        public void setPrice(String price) {
            this.price = price;
        }

        public String getCover_pic() {
            return cover_pic;
        }

        public void setCover_pic(String cover_pic) {
            this.cover_pic = cover_pic;
        }

        public String getCourse_type() {
            return course_type;
        }

        public void setCourse_type(String course_type) {
            this.course_type = course_type;
        }

        public String getDescription() {
            return description;
        }

        public void setDescription(String description) {
            this.description = description;
        }

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }
    }

    public static class BannerBean {

        /**
         * id : 393
         * main : BANNER
         * sub : DRAMA
         * name : 戏剧课程1
         * value : {"fk":"storage/2019-11-01/EMgPmARSHn11iGVoxUsMfbaAXYAyxvUxCzYjSIMq.png","objName":"2236","urlType":"own","objId":"7","url":"2236"}
         * descp : null
         * sort : 1
         * status : 0
         * createDt : 2019-10-29 10:16:39
         * updateDt : 2019-11-01 14:25:34
         * img : storage/2019-11-01/EMgPmARSHn11iGVoxUsMfbaAXYAyxvUxCzYjSIMq.png
         */

        private int id;
        private String main;
        private String sub;
        private String name;
        private ValueBean value;
        private Object descp;
        private int sort;
        private String status;
        private String createDt;
        private String updateDt;
        private String img;

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

        public Object getDescp() {
            return descp;
        }

        public void setDescp(Object descp) {
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

        public String getImg() {
            return img;
        }

        public void setImg(String img) {
            this.img = img;
        }

        public static class ValueBean {
            /**
             * fk : storage/2019-11-01/EMgPmARSHn11iGVoxUsMfbaAXYAyxvUxCzYjSIMq.png
             * objName : 2236
             * urlType : own
             * objId : 7
             * url : 2236
             */

            private String fk;
            private String objName;
            private String urlType;
            private String objId;
            private String url;

            public String getFk() {
                return fk;
            }

            public void setFk(String fk) {
                this.fk = fk;
            }

            public String getObjName() {
                return objName;
            }

            public void setObjName(String objName) {
                this.objName = objName;
            }

            public String getUrlType() {
                return urlType;
            }

            public void setUrlType(String urlType) {
                this.urlType = urlType;
            }

            public String getObjId() {
                return objId;
            }

            public void setObjId(String objId) {
                this.objId = objId;
            }

            public String getUrl() {
                return url;
            }

            public void setUrl(String url) {
                this.url = url;
            }
        }
    }
}
