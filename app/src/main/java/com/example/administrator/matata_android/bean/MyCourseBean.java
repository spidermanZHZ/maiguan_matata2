package com.example.administrator.matata_android.bean;

import java.io.Serializable;
import java.util.List;

public class MyCourseBean implements Serializable {


    private List<AllBean> all;
    private List<OnlineCourseBean> online_course;
    private List<OfflineCourseBean> offline_course;

    public List<AllBean> getAll() {
        return all;
    }

    public void setAll(List<AllBean> all) {
        this.all = all;
    }

    public List<OnlineCourseBean> getOnline_course() {
        return online_course;
    }

    public void setOnline_course(List<OnlineCourseBean> online_course) {
        this.online_course = online_course;
    }

    public List<OfflineCourseBean> getOffline_course() {
        return offline_course;
    }

    public void setOffline_course(List<OfflineCourseBean> offline_course) {
        this.offline_course = offline_course;
    }

    public static class AllBean {
        /**
         * id : 100000516
         * course_type : 00
         * wechat_order_id : null
         * course_id : 27
         * user_id : 2317
         * pay_type : wx
         * order_amount : 1
         * pay_amount : 1
         * virtual_currency : 0
         * status : 01
         * recommend_user_id : null
         * pay_time : null
         * confirm_time : null
         * createDt : 2019-12-10 11:57:03
         * updateDt : 2019-12-10 11:57:11
         * section_up_json : null
         * agent_user_1 : null
         * agent_user_2 : null
         * agent_user_3 : null
         * is_apply_changing : 0
         * user_course_pindan_id : null
         * user_course_pindan_type : null
         * jigou_id : null
         * order_flag : null
         * no : MTT201912101157049466429437
         * card_type : null
         * child_id : null
         * course : {"id":27,"class_id":51,"name":"<手碟> ：从普通人到男神/女神的进阶之路","teacher_id":139,"theme_id":1,"num":10,"original_price":1,"discount_price":1,"deductible_virtual_currency":0,"deductible_real_currency":0,"largess_virtual_currency":4,"profile":"<p style=\"text-align:center;\"><\/p><div class=\"media-wrap image-wrap\"><img src=\"http://www.maiguanjy.com/matata_server/showFile/showImage?fk=757bec06de5a430481827380265c155c.jpeg&amp;show=null\" width=\"auto\" height=\"auto\" style=\"width:auto;height:auto\"/><\/div><p><\/p><div class=\"media-wrap image-wrap\"><img src=\"http://www.maiguanjy.com/matata_server/showFile/showImage?fk=876f32c8292e44a091dc2abca05d221e.jpeg&amp;show=null\" width=\"auto\" height=\"auto\" style=\"width:auto;height:auto\"/><\/div><p><\/p><div class=\"media-wrap image-wrap\"><img src=\"/matata_server/showFile/showImage?fk=a67037bed6ed45f39fc9971cc05bed1e.jpeg&amp;show=null\"/><\/div><p><\/p>","description":"珍藏级手碟教程，由国内顶尖手碟演奏者小小老师主讲，干货满满、制作精良，伴你快速入门！","cover_pic":"storage/2019-06-13/XQM8n7GxJKWwO95OjGk7f9GSvslBVg7xFZ8u12Yi.jpeg","detail_pic":"storage/2019-06-13/0eQXDnJFJMiMxFWgffpEfnkhKw78pC3ypXFS4z3V.png","distribution_ratio1":10,"distribution_ratio2":5,"distribution_ratio3":null,"click_rate":0,"sort":2,"status":"0","createDt":"2018-05-26 18:55:07","updateDt":"2019-07-19 10:20:37","up_type":"0","up_dt1_start":null,"up_dt1_end":null,"up_dt2":0,"up_dt3":null,"up_users2":0,"vip_price":1,"stars":15}
         */

        private int id;
        private String course_type;
        private Object wechat_order_id;
        private int course_id;
        private int user_id;
        private String pay_type;
        private int order_amount;
        private int pay_amount;
        private int virtual_currency;
        private String status;
        private Object recommend_user_id;
        private Object pay_time;
        private Object confirm_time;
        private String createDt;
        private String updateDt;
        private Object section_up_json;
        private Object agent_user_1;
        private Object agent_user_2;
        private Object agent_user_3;
        private String is_apply_changing;
        private Object user_course_pindan_id;
        private Object user_course_pindan_type;
        private Object jigou_id;
        private Object order_flag;
        private String no;
        private Object card_type;
        private Object child_id;
        private CourseBean course;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getCourse_type() {
            return course_type;
        }

        public void setCourse_type(String course_type) {
            this.course_type = course_type;
        }

        public Object getWechat_order_id() {
            return wechat_order_id;
        }

        public void setWechat_order_id(Object wechat_order_id) {
            this.wechat_order_id = wechat_order_id;
        }

        public int getCourse_id() {
            return course_id;
        }

        public void setCourse_id(int course_id) {
            this.course_id = course_id;
        }

        public int getUser_id() {
            return user_id;
        }

        public void setUser_id(int user_id) {
            this.user_id = user_id;
        }

        public String getPay_type() {
            return pay_type;
        }

        public void setPay_type(String pay_type) {
            this.pay_type = pay_type;
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

        public int getVirtual_currency() {
            return virtual_currency;
        }

        public void setVirtual_currency(int virtual_currency) {
            this.virtual_currency = virtual_currency;
        }

        public String getStatus() {
            return status;
        }

        public void setStatus(String status) {
            this.status = status;
        }

        public Object getRecommend_user_id() {
            return recommend_user_id;
        }

        public void setRecommend_user_id(Object recommend_user_id) {
            this.recommend_user_id = recommend_user_id;
        }

        public Object getPay_time() {
            return pay_time;
        }

        public void setPay_time(Object pay_time) {
            this.pay_time = pay_time;
        }

        public Object getConfirm_time() {
            return confirm_time;
        }

        public void setConfirm_time(Object confirm_time) {
            this.confirm_time = confirm_time;
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

        public Object getSection_up_json() {
            return section_up_json;
        }

        public void setSection_up_json(Object section_up_json) {
            this.section_up_json = section_up_json;
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

        public String getIs_apply_changing() {
            return is_apply_changing;
        }

        public void setIs_apply_changing(String is_apply_changing) {
            this.is_apply_changing = is_apply_changing;
        }

        public Object getUser_course_pindan_id() {
            return user_course_pindan_id;
        }

        public void setUser_course_pindan_id(Object user_course_pindan_id) {
            this.user_course_pindan_id = user_course_pindan_id;
        }

        public Object getUser_course_pindan_type() {
            return user_course_pindan_type;
        }

        public void setUser_course_pindan_type(Object user_course_pindan_type) {
            this.user_course_pindan_type = user_course_pindan_type;
        }

        public Object getJigou_id() {
            return jigou_id;
        }

        public void setJigou_id(Object jigou_id) {
            this.jigou_id = jigou_id;
        }

        public Object getOrder_flag() {
            return order_flag;
        }

        public void setOrder_flag(Object order_flag) {
            this.order_flag = order_flag;
        }

        public String getNo() {
            return no;
        }

        public void setNo(String no) {
            this.no = no;
        }

        public Object getCard_type() {
            return card_type;
        }

        public void setCard_type(Object card_type) {
            this.card_type = card_type;
        }

        public Object getChild_id() {
            return child_id;
        }

        public void setChild_id(Object child_id) {
            this.child_id = child_id;
        }

        public CourseBean getCourse() {
            return course;
        }

        public void setCourse(CourseBean course) {
            this.course = course;
        }

        public static class CourseBean {
            /**
             * id : 27
             * class_id : 51
             * name : <手碟> ：从普通人到男神/女神的进阶之路
             * teacher_id : 139
             * theme_id : 1
             * num : 10
             * original_price : 1
             * discount_price : 1
             * deductible_virtual_currency : 0
             * deductible_real_currency : 0
             * largess_virtual_currency : 4
             * profile : <p style="text-align:center;"></p><div class="media-wrap image-wrap"><img src="http://www.maiguanjy.com/matata_server/showFile/showImage?fk=757bec06de5a430481827380265c155c.jpeg&amp;show=null" width="auto" height="auto" style="width:auto;height:auto"/></div><p></p><div class="media-wrap image-wrap"><img src="http://www.maiguanjy.com/matata_server/showFile/showImage?fk=876f32c8292e44a091dc2abca05d221e.jpeg&amp;show=null" width="auto" height="auto" style="width:auto;height:auto"/></div><p></p><div class="media-wrap image-wrap"><img src="/matata_server/showFile/showImage?fk=a67037bed6ed45f39fc9971cc05bed1e.jpeg&amp;show=null"/></div><p></p>
             * description : 珍藏级手碟教程，由国内顶尖手碟演奏者小小老师主讲，干货满满、制作精良，伴你快速入门！
             * cover_pic : storage/2019-06-13/XQM8n7GxJKWwO95OjGk7f9GSvslBVg7xFZ8u12Yi.jpeg
             * detail_pic : storage/2019-06-13/0eQXDnJFJMiMxFWgffpEfnkhKw78pC3ypXFS4z3V.png
             * distribution_ratio1 : 10
             * distribution_ratio2 : 5
             * distribution_ratio3 : null
             * click_rate : 0
             * sort : 2
             * status : 0
             * createDt : 2018-05-26 18:55:07
             * updateDt : 2019-07-19 10:20:37
             * up_type : 0
             * up_dt1_start : null
             * up_dt1_end : null
             * up_dt2 : 0
             * up_dt3 : null
             * up_users2 : 0
             * vip_price : 1
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
            private Object up_dt1_start;
            private Object up_dt1_end;
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

            public Object getUp_dt1_start() {
                return up_dt1_start;
            }

            public void setUp_dt1_start(Object up_dt1_start) {
                this.up_dt1_start = up_dt1_start;
            }

            public Object getUp_dt1_end() {
                return up_dt1_end;
            }

            public void setUp_dt1_end(Object up_dt1_end) {
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

    public static class OnlineCourseBean {
        /**
         * id : 100000516
         * course_type : 00
         * wechat_order_id : null
         * course_id : 27
         * user_id : 2317
         * pay_type : wx
         * order_amount : 1
         * pay_amount : 1
         * virtual_currency : 0
         * status : 01
         * recommend_user_id : null
         * pay_time : null
         * confirm_time : null
         * createDt : 2019-12-10 11:57:03
         * updateDt : 2019-12-10 11:57:11
         * section_up_json : null
         * agent_user_1 : null
         * agent_user_2 : null
         * agent_user_3 : null
         * is_apply_changing : 0
         * user_course_pindan_id : null
         * user_course_pindan_type : null
         * jigou_id : null
         * order_flag : null
         * no : MTT201912101157049466429437
         * card_type : null
         * child_id : null
         * course : {"id":27,"class_id":51,"name":"<手碟> ：从普通人到男神/女神的进阶之路","teacher_id":139,"theme_id":1,"num":10,"original_price":1,"discount_price":1,"deductible_virtual_currency":0,"deductible_real_currency":0,"largess_virtual_currency":4,"profile":"<p style=\"text-align:center;\"><\/p><div class=\"media-wrap image-wrap\"><img src=\"http://www.maiguanjy.com/matata_server/showFile/showImage?fk=757bec06de5a430481827380265c155c.jpeg&amp;show=null\" width=\"auto\" height=\"auto\" style=\"width:auto;height:auto\"/><\/div><p><\/p><div class=\"media-wrap image-wrap\"><img src=\"http://www.maiguanjy.com/matata_server/showFile/showImage?fk=876f32c8292e44a091dc2abca05d221e.jpeg&amp;show=null\" width=\"auto\" height=\"auto\" style=\"width:auto;height:auto\"/><\/div><p><\/p><div class=\"media-wrap image-wrap\"><img src=\"/matata_server/showFile/showImage?fk=a67037bed6ed45f39fc9971cc05bed1e.jpeg&amp;show=null\"/><\/div><p><\/p>","description":"珍藏级手碟教程，由国内顶尖手碟演奏者小小老师主讲，干货满满、制作精良，伴你快速入门！","cover_pic":"storage/2019-06-13/XQM8n7GxJKWwO95OjGk7f9GSvslBVg7xFZ8u12Yi.jpeg","detail_pic":"storage/2019-06-13/0eQXDnJFJMiMxFWgffpEfnkhKw78pC3ypXFS4z3V.png","distribution_ratio1":10,"distribution_ratio2":5,"distribution_ratio3":null,"click_rate":0,"sort":2,"status":"0","createDt":"2018-05-26 18:55:07","updateDt":"2019-07-19 10:20:37","up_type":"0","up_dt1_start":null,"up_dt1_end":null,"up_dt2":0,"up_dt3":null,"up_users2":0,"vip_price":1,"stars":15}
         */

        private int id;
        private String course_type;
        private Object wechat_order_id;
        private int course_id;
        private int user_id;
        private String pay_type;
        private int order_amount;
        private int pay_amount;
        private int virtual_currency;
        private String status;
        private Object recommend_user_id;
        private Object pay_time;
        private Object confirm_time;
        private String createDt;
        private String updateDt;
        private Object section_up_json;
        private Object agent_user_1;
        private Object agent_user_2;
        private Object agent_user_3;
        private String is_apply_changing;
        private Object user_course_pindan_id;
        private Object user_course_pindan_type;
        private Object jigou_id;
        private Object order_flag;
        private String no;
        private Object card_type;
        private Object child_id;
        private CourseBeanX course;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getCourse_type() {
            return course_type;
        }

        public void setCourse_type(String course_type) {
            this.course_type = course_type;
        }

        public Object getWechat_order_id() {
            return wechat_order_id;
        }

        public void setWechat_order_id(Object wechat_order_id) {
            this.wechat_order_id = wechat_order_id;
        }

        public int getCourse_id() {
            return course_id;
        }

        public void setCourse_id(int course_id) {
            this.course_id = course_id;
        }

        public int getUser_id() {
            return user_id;
        }

        public void setUser_id(int user_id) {
            this.user_id = user_id;
        }

        public String getPay_type() {
            return pay_type;
        }

        public void setPay_type(String pay_type) {
            this.pay_type = pay_type;
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

        public int getVirtual_currency() {
            return virtual_currency;
        }

        public void setVirtual_currency(int virtual_currency) {
            this.virtual_currency = virtual_currency;
        }

        public String getStatus() {
            return status;
        }

        public void setStatus(String status) {
            this.status = status;
        }

        public Object getRecommend_user_id() {
            return recommend_user_id;
        }

        public void setRecommend_user_id(Object recommend_user_id) {
            this.recommend_user_id = recommend_user_id;
        }

        public Object getPay_time() {
            return pay_time;
        }

        public void setPay_time(Object pay_time) {
            this.pay_time = pay_time;
        }

        public Object getConfirm_time() {
            return confirm_time;
        }

        public void setConfirm_time(Object confirm_time) {
            this.confirm_time = confirm_time;
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

        public Object getSection_up_json() {
            return section_up_json;
        }

        public void setSection_up_json(Object section_up_json) {
            this.section_up_json = section_up_json;
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

        public String getIs_apply_changing() {
            return is_apply_changing;
        }

        public void setIs_apply_changing(String is_apply_changing) {
            this.is_apply_changing = is_apply_changing;
        }

        public Object getUser_course_pindan_id() {
            return user_course_pindan_id;
        }

        public void setUser_course_pindan_id(Object user_course_pindan_id) {
            this.user_course_pindan_id = user_course_pindan_id;
        }

        public Object getUser_course_pindan_type() {
            return user_course_pindan_type;
        }

        public void setUser_course_pindan_type(Object user_course_pindan_type) {
            this.user_course_pindan_type = user_course_pindan_type;
        }

        public Object getJigou_id() {
            return jigou_id;
        }

        public void setJigou_id(Object jigou_id) {
            this.jigou_id = jigou_id;
        }

        public Object getOrder_flag() {
            return order_flag;
        }

        public void setOrder_flag(Object order_flag) {
            this.order_flag = order_flag;
        }

        public String getNo() {
            return no;
        }

        public void setNo(String no) {
            this.no = no;
        }

        public Object getCard_type() {
            return card_type;
        }

        public void setCard_type(Object card_type) {
            this.card_type = card_type;
        }

        public Object getChild_id() {
            return child_id;
        }

        public void setChild_id(Object child_id) {
            this.child_id = child_id;
        }

        public CourseBeanX getCourse() {
            return course;
        }

        public void setCourse(CourseBeanX course) {
            this.course = course;
        }

        public static class CourseBeanX {
            /**
             * id : 27
             * class_id : 51
             * name : <手碟> ：从普通人到男神/女神的进阶之路
             * teacher_id : 139
             * theme_id : 1
             * num : 10
             * original_price : 1
             * discount_price : 1
             * deductible_virtual_currency : 0
             * deductible_real_currency : 0
             * largess_virtual_currency : 4
             * profile : <p style="text-align:center;"></p><div class="media-wrap image-wrap"><img src="http://www.maiguanjy.com/matata_server/showFile/showImage?fk=757bec06de5a430481827380265c155c.jpeg&amp;show=null" width="auto" height="auto" style="width:auto;height:auto"/></div><p></p><div class="media-wrap image-wrap"><img src="http://www.maiguanjy.com/matata_server/showFile/showImage?fk=876f32c8292e44a091dc2abca05d221e.jpeg&amp;show=null" width="auto" height="auto" style="width:auto;height:auto"/></div><p></p><div class="media-wrap image-wrap"><img src="/matata_server/showFile/showImage?fk=a67037bed6ed45f39fc9971cc05bed1e.jpeg&amp;show=null"/></div><p></p>
             * description : 珍藏级手碟教程，由国内顶尖手碟演奏者小小老师主讲，干货满满、制作精良，伴你快速入门！
             * cover_pic : storage/2019-06-13/XQM8n7GxJKWwO95OjGk7f9GSvslBVg7xFZ8u12Yi.jpeg
             * detail_pic : storage/2019-06-13/0eQXDnJFJMiMxFWgffpEfnkhKw78pC3ypXFS4z3V.png
             * distribution_ratio1 : 10
             * distribution_ratio2 : 5
             * distribution_ratio3 : null
             * click_rate : 0
             * sort : 2
             * status : 0
             * createDt : 2018-05-26 18:55:07
             * updateDt : 2019-07-19 10:20:37
             * up_type : 0
             * up_dt1_start : null
             * up_dt1_end : null
             * up_dt2 : 0
             * up_dt3 : null
             * up_users2 : 0
             * vip_price : 1
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
            private Object up_dt1_start;
            private Object up_dt1_end;
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

            public Object getUp_dt1_start() {
                return up_dt1_start;
            }

            public void setUp_dt1_start(Object up_dt1_start) {
                this.up_dt1_start = up_dt1_start;
            }

            public Object getUp_dt1_end() {
                return up_dt1_end;
            }

            public void setUp_dt1_end(Object up_dt1_end) {
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

    public static class OfflineCourseBean implements Serializable{
        /**
         * id : 100000519
         * course_type : 01
         * wechat_order_id : null
         * course_id : 12
         * user_id : 2317
         * pay_type : null
         * order_amount : 1280000
         * pay_amount : 1280000
         * virtual_currency : 0
         * status : 01
         * recommend_user_id : null
         * pay_time : null
         * confirm_time : null
         * createDt : 2019-12-10 17:30:59
         * updateDt : 2019-12-10 17:30:59
         * section_up_json : null
         * agent_user_1 : null
         * agent_user_2 : null
         * agent_user_3 : null
         * is_apply_changing : 0
         * user_course_pindan_id : null
         * user_course_pindan_type : null
         * jigou_id : null
         * order_flag : null
         * no : MTT201912101730599605178328
         * card_type : year
         * child_id : 19
         * course : {"id":12,"class_id":50,"name":"PBL成长教育戏剧","teacher_id":149,"theme_id":null,"num":52,"price":"{\"month\":{\"name\":\"\\u6708\\u5361\",\"price\":0,\"num\":null,\"day\":null},\"season\":{\"name\":\"\\u5b63\\u5361\",\"price\":380000,\"num\":\"13\",\"day\":null},\"year\":{\"name\":\"\\u5e74\\u5361\",\"price\":1280000,\"num\":\"48\",\"day\":null}}","deductible_virtual_currency":0,"deductible_real_currency":0,"largess_virtual_currency":0,"profile":"<p style=\"text-align:center;\"><strong><span style=\"font-family:宋体;font-weight:bold;font-size:21px;\">P<\/span><\/strong><strong><span style=\"font-family:Calibri;font-weight:bold;font-size:21px;\">BL成长教育戏剧<\/span><\/strong><\/p><p><br><\/p><p><br><\/p><p><strong><span style=\"font-family:宋体;font-weight:bold;font-size:14px;\">在戏剧中促进儿童心智发展<\/span><\/strong><\/p><p><br><\/p><p><span style=\"font-family:宋体;font-size:14px;\">PBL成长教育戏剧以寓教于乐的戏剧项目为载体，根据少年儿童不同年龄段心理、生理的发展特点，在教育戏剧中融入心智发展的专业教学内容。通过不同角色的扮演，让孩子模拟多种多样的人生境遇，在专业老师的正向引导中全面发展心智、塑造健全人格。<\/span><\/p><p><img src=\"https://www.maiguanjy.com/storage/2019-11-19/sKZtj2UIpcHF5me6elPJADkeZIiJPWHzXLcPQddE.jpeg\" style=\"width: 300px;\" class=\"fr-fic fr-dib\"><\/p><p><br><\/p><p><strong><span style=\"font-family:宋体;font-weight:bold;font-size:14px;\">更专业的师资保障<\/span><\/strong><\/p><p><br><\/p><p><span style=\"font-family:宋体;font-size:14px;\">所有戏剧教师均受过专业心理知识培训，系首批获国家专业技能证书的上岗教师<\/span><span style=\"font-family:Calibri;font-size:14px;\">。<\/span><\/p><p><img src=\"https://www.maiguanjy.com/storage/2019-11-19/MS2gsa1r2MruE7AjftGAO3alEs9JgXOTRMMIOUJ5.jpeg\" style=\"width: 300px;\" class=\"fr-fic fr-dib\"><\/p><p><br><\/p><p><strong><span style=\"font-family:宋体;font-weight:bold;font-size:14px;\">在戏剧体验<\/span><\/strong><strong><span style=\"font-family:Calibri;font-weight:bold;font-size:14px;\">中收获成长<\/span><\/strong><\/p><p><br><\/p><table border=\"1\" cellspacing=\"0\" style=\"border-collapse: collapse;width: 100%;border: none;\"><tbody><tr><td style=\"width:138.2500pt;padding:0.0000pt 5.4000pt 0.0000pt 5.4000pt ;border-left:1.0000pt solid windowtext;border-right:1.0000pt solid windowtext;border-top:1.0000pt solid windowtext;border-bottom:1.0000pt solid windowtext;\" valign=\"center\" width=\"33.333333333333336%\"><p style=\"text-align:center;\"><strong><span style=\"font-family:宋体;font-weight:bold;font-size:14px;\">个人成长<\/span><\/strong><\/p><\/td><td style=\"width:138.2500pt;padding:0.0000pt 5.4000pt 0.0000pt 5.4000pt ;border-left:none;border-right:1.0000pt solid windowtext;border-top:1.0000pt solid windowtext;border-bottom:1.0000pt solid windowtext;\" valign=\"center\" width=\"33.333333333333336%\"><p style=\"text-align:center;\"><strong><span style=\"font-family:宋体;font-weight:bold;font-size:14px;\">家庭关系<\/span><\/strong><\/p><\/td><td style=\"width:138.3000pt;padding:0.0000pt 5.4000pt 0.0000pt 5.4000pt ;border-left:none;border-right:1.0000pt solid windowtext;border-top:1.0000pt solid windowtext;border-bottom:1.0000pt solid windowtext;\" valign=\"center\" width=\"33.333333333333336%\"><p style=\"text-align:center;\"><strong><span style=\"font-family:宋体;font-weight:bold;font-size:14px;\">社会关系<\/span><\/strong><\/p><\/td><\/tr><tr><td style=\"width:138.2500pt;padding:0.0000pt 5.4000pt 0.0000pt 5.4000pt ;border-left:1.0000pt solid windowtext;border-right:1.0000pt solid windowtext;border-top:none;border-bottom:1.0000pt solid windowtext;\" valign=\"center\" width=\"33.333333333333336%\"><p style=\"text-align:center;\"><span style=\"font-family:宋体;font-size:14px;\">提高情商<\/span><\/p><p style=\"text-align:center;\"><span style=\"font-family:宋体;font-size:14px;\">建立初步心理认知<\/span><\/p><p style=\"text-align:center;\"><span style=\"font-family:宋体;font-size:14px;\">正向引导情绪管理<\/span><\/p><p style=\"text-align:center;\"><span style=\"font-family:宋体;font-size:14px;\">纠正不良行为习惯<\/span><\/p><p style=\"text-align:center;\"><span style=\"font-family:宋体;font-size:14px;\">强化团队协作意识<\/span><\/p><p style=\"text-align:center;\"><span style=\"font-family:Calibri;font-size:14px;\">提高自处<\/span><span style=\"font-family:宋体;font-size:14px;\">能力<\/span><\/p><p style=\"text-align:center;\"><span style=\"font-family:Calibri;font-size:14px;\">提升社交能力<\/span><\/p><p style=\"text-align:center;\"><span style=\"font-family:Calibri;font-size:14px;\">树立正确三观<\/span><\/p><p style=\"text-align:center;\"><span style=\"font-family:Calibri;font-size:14px;\">塑造完美型健全人格<\/span><\/p><\/td><td style=\"width:138.2500pt;padding:0.0000pt 5.4000pt 0.0000pt 5.4000pt ;border-left:none;border-right:1.0000pt solid windowtext;border-top:none;border-bottom:1.0000pt solid windowtext;\" valign=\"center\" width=\"33.333333333333336%\"><p style=\"text-align:center;\"><span style=\"font-family:宋体;font-size:14px;\">强化共情意识和换位思考<\/span><\/p><p style=\"text-align:center;\"><span style=\"font-family:宋体;font-size:14px;\">妥善处理亲密关系<\/span><\/p><p style=\"text-align:center;\"><span style=\"font-family:Calibri;font-size:14px;\">正确<\/span><span style=\"font-family:宋体;font-size:14px;\">疏导个人情绪波动<\/span><\/p><p style=\"text-align:center;\"><span style=\"font-family:宋体;font-size:14px;\">排解<\/span><span style=\"font-family:Calibri;font-size:14px;\">成员相处间的矛盾<\/span><\/p><p style=\"text-align:center;\"><span style=\"font-family:宋体;font-size:14px;\">打造良好的家庭教育环境<\/span><\/p><p style=\"text-align:center;\"><br><\/p><\/td><td style=\"width:138.3000pt;padding:0.0000pt 5.4000pt 0.0000pt 5.4000pt ;border-left:none;border-right:1.0000pt solid windowtext;border-top:none;border-bottom:1.0000pt solid windowtext;\" valign=\"center\" width=\"33.333333333333336%\"><p style=\"text-align:center;\"><span style=\"font-family:宋体;font-size:14px;\">寻找自我定位<\/span><\/p><p style=\"text-align:center;\"><span style=\"font-family:宋体;font-size:14px;\">清晰社会认知<\/span><\/p><p style=\"text-align:center;\"><span style=\"font-family:宋体;font-size:14px;\">构建良性的同伴关系<\/span><\/p><p style=\"text-align:center;\"><span style=\"font-family:Calibri;font-size:14px;\">学会解决伙伴间的冲突<\/span><\/p><p style=\"text-align:center;\"><span style=\"font-family:宋体;font-size:14px;\">正确排解社会压力<\/span><\/p><p style=\"text-align:center;\"><span style=\"font-family:宋体;font-size:14px;\">个性和社会性全面发展<\/span><\/p><\/td><\/tr><\/tbody><\/table><p><br><\/p><p><br><\/p><p><strong><span style=\"font-family:Calibri;font-weight:bold;font-size:14px;\">结合儿童心理发展规律解决问题<\/span><\/strong><\/p><p><br><\/p><p><span style=\"font-family:宋体;font-size:14px;\">1~<\/span><span style=\"font-family:Calibri;font-size:14px;\">6<\/span><span style=\"font-family:宋体;font-size:14px;\">年级<\/span><span style=\"font-family:Calibri;font-size:14px;\">是儿童<\/span><span style=\"font-family:宋体;font-size:14px;\">心理发展<\/span><span style=\"font-family:Calibri;font-size:14px;\">的关键时期，<\/span><span style=\"font-family:宋体;font-size:14px;\">从儿童常见<\/span><span style=\"font-family:Calibri;font-size:14px;\">的心理状态<\/span><span style=\"font-family:宋体;font-size:14px;\">出发<\/span><span style=\"font-family:Calibri;font-size:14px;\">，<\/span><span style=\"font-family:宋体;font-size:14px;\">结合<\/span><span style=\"font-family:Calibri;font-size:14px;\">心理学知识及儿童心理发展规律，<\/span><span style=\"font-family:宋体;font-size:14px;\">设计具有针对性的教育戏剧项目<\/span><span style=\"font-family:Calibri;font-size:14px;\">。<\/span><\/p><p><br><\/p><table border=\"1\" cellspacing=\"0\" style=\"border-collapse: collapse;width: 100%;border: none;\"><tbody><tr><td style=\"width:77.7500pt;padding:0.0000pt 5.4000pt 0.0000pt 5.4000pt ;border-left:1.0000pt solid windowtext;border-right:1.0000pt solid windowtext;border-top:1.0000pt solid windowtext;border-bottom:1.0000pt solid windowtext;\" valign=\"center\" width=\"18.693284936479127%\"><p style=\"text-align:center;\"><strong><span style=\"font-family:Calibri;font-weight:bold;font-size:14px;\">年龄段<\/span><\/strong><\/p><\/td><td style=\"width:155.9000pt;padding:0.0000pt 5.4000pt 0.0000pt 5.4000pt ;border-left:none;border-right:1.0000pt solid windowtext;border-top:1.0000pt solid windowtext;border-bottom:1.0000pt solid windowtext;\" valign=\"center\" width=\"37.56805807622504%\"><p style=\"text-align:center;\"><strong><span style=\"font-family:Calibri;font-weight:bold;font-size:14px;\">常见心理状态<\/span><\/strong><\/p><\/td><td style=\"width:181.1500pt;padding:0.0000pt 5.4000pt 0.0000pt 5.4000pt ;border-left:none;border-right:1.0000pt solid windowtext;border-top:1.0000pt solid windowtext;border-bottom:1.0000pt solid windowtext;\" valign=\"center\" width=\"43.738656987295826%\"><p style=\"text-align:center;\"><strong><span style=\"font-family:宋体;font-weight:bold;font-size:14px;\">心理<\/span><\/strong><strong><span style=\"font-family:Calibri;font-weight:bold;font-size:14px;\">构建目标<\/span><\/strong><\/p><\/td><\/tr><tr><td style=\"width:77.7500pt;padding:0.0000pt 5.4000pt 0.0000pt 5.4000pt ;border-left:1.0000pt solid windowtext;border-right:1.0000pt solid windowtext;border-top:none;border-bottom:1.0000pt solid windowtext;\" valign=\"center\" width=\"18.693284936479127%\"><p style=\"text-align:center;\"><span style=\"font-family:Calibri;font-size:14px;\">一年级<\/span><\/p><\/td><td style=\"width:155.9000pt;padding:0.0000pt 5.4000pt 0.0000pt 5.4000pt ;border-left:none;border-right:1.0000pt solid windowtext;border-top:none;border-bottom:1.0000pt solid windowtext;\" valign=\"center\" width=\"37.56805807622504%\"><p><span style=\"font-family:Calibri;font-size:14px;\">集体意识较弱、不<\/span><span style=\"font-family:宋体;font-size:14px;\">具备自我评价能力<\/span><span style=\"font-family:Calibri;font-size:14px;\">、<\/span><span style=\"font-family:宋体;font-size:14px;\">较为敏感<\/span><span style=\"font-family:Calibri;font-size:14px;\">、<\/span><span style=\"font-family:宋体;font-size:14px;\">不能正确表达<\/span><span style=\"font-family:Calibri;font-size:14px;\">、存在孤独感、<\/span><span style=\"font-family:宋体;font-size:14px;\">缺乏安全感<\/span><\/p><\/td><td style=\"width:181.1500pt;padding:0.0000pt 5.4000pt 0.0000pt 5.4000pt ;border-left:none;border-right:1.0000pt solid windowtext;border-top:none;border-bottom:1.0000pt solid windowtext;\" valign=\"center\" width=\"43.738656987295826%\"><p><span style=\"font-family:Calibri;font-size:14px;\">激发自我意识、养成良好习惯、适应新环境、初步建立人际关系、培养学习兴趣、正确表达自身想法<\/span><\/p><\/td><\/tr><tr><td style=\"width:77.7500pt;padding:0.0000pt 5.4000pt 0.0000pt 5.4000pt ;border-left:1.0000pt solid windowtext;border-right:1.0000pt solid windowtext;border-top:none;border-bottom:1.0000pt solid windowtext;\" valign=\"center\" width=\"18.693284936479127%\"><p style=\"text-align:center;\"><span style=\"font-family:Calibri;font-size:14px;\">二年级<\/span><\/p><\/td><td style=\"width:155.9000pt;padding:0.0000pt 5.4000pt 0.0000pt 5.4000pt ;border-left:none;border-right:1.0000pt solid windowtext;border-top:none;border-bottom:1.0000pt solid windowtext;\" valign=\"center\" width=\"37.56805807622504%\"><p><span style=\"font-family:Calibri;font-size:14px;\">渴求表扬、注意力不集中、说谎、注重输赢、形成自我判断力<\/span><\/p><\/td><td style=\"width:181.1500pt;padding:0.0000pt 5.4000pt 0.0000pt 5.4000pt ;border-left:none;border-right:1.0000pt solid windowtext;border-top:none;border-bottom:1.0000pt solid windowtext;\" valign=\"center\" width=\"43.738656987295826%\"><p><span style=\"font-family:Calibri;font-size:14px;\">体会责任感、自觉遵守规则、形成集体荣誉感、培养正确胜负观、诚实守信<\/span><\/p><\/td><\/tr><tr><td style=\"width:77.7500pt;padding:0.0000pt 5.4000pt 0.0000pt 5.4000pt ;border-left:1.0000pt solid windowtext;border-right:1.0000pt solid windowtext;border-top:none;border-bottom:1.0000pt solid windowtext;\" valign=\"center\" width=\"18.693284936479127%\"><p style=\"text-align:center;\"><span style=\"font-family:Calibri;font-size:14px;\">三年级<\/span><\/p><\/td><td style=\"width:155.9000pt;padding:0.0000pt 5.4000pt 0.0000pt 5.4000pt ;border-left:none;border-right:1.0000pt solid windowtext;border-top:none;border-bottom:1.0000pt solid windowtext;\" valign=\"center\" width=\"37.56805807622504%\"><p><span style=\"font-family:Calibri;font-size:14px;\">有意识的自我展示、兴趣广泛、时间和空间感较差、自制力差、有意识形成小团体、积极做事但耐性低、推崇有力量的英雄<\/span><\/p><\/td><td style=\"width:181.1500pt;padding:0.0000pt 5.4000pt 0.0000pt 5.4000pt ;border-left:none;border-right:1.0000pt solid windowtext;border-top:none;border-bottom:1.0000pt solid windowtext;\" valign=\"center\" width=\"43.738656987295826%\"><p><span style=\"font-family:Calibri;font-size:14px;\">提升自制力、集中注意力、提升空间感和时间感、初步形成正确的心理价值观、树立正确的偶像观、培养劳动习惯、培养正确的学习习惯<\/span><\/p><\/td><\/tr><tr><td style=\"width:77.7500pt;padding:0.0000pt 5.4000pt 0.0000pt 5.4000pt ;border-left:1.0000pt solid windowtext;border-right:1.0000pt solid windowtext;border-top:none;border-bottom:1.0000pt solid windowtext;\" valign=\"center\" width=\"18.693284936479127%\"><p style=\"text-align:center;\"><span style=\"font-family:Calibri;font-size:14px;\">四年级<\/span><\/p><\/td><td style=\"width:155.9000pt;padding:0.0000pt 5.4000pt 0.0000pt 5.4000pt ;border-left:none;border-right:1.0000pt solid windowtext;border-top:none;border-bottom:1.0000pt solid windowtext;\" valign=\"center\" width=\"37.56805807622504%\"><p><span style=\"font-family:Calibri;font-size:14px;\">情绪性明显、爱争论问题、容易激动、开始在意自我形象、对事情有自我判断、<\/span><span style=\"font-family:宋体;font-size:14px;\">习惯<\/span><span style=\"font-family:Calibri;font-size:14px;\">养成与性格塑造的关键期<\/span><\/p><\/td><td style=\"width:181.1500pt;padding:0.0000pt 5.4000pt 0.0000pt 5.4000pt ;border-left:none;border-right:1.0000pt solid windowtext;border-top:none;border-bottom:1.0000pt solid windowtext;\" valign=\"center\" width=\"43.738656987295826%\"><p><span style=\"font-family:Calibri;font-size:14px;\">正确打扮自己、培养自行解决和自行选择的能力、勇于承担后果、正确处理情绪、合理讨论与表达自我意见、<\/span><span style=\"font-family:宋体;font-size:14px;\">培养正确的行为习惯与自身性格<\/span><\/p><\/td><\/tr><tr><td style=\"width:77.7500pt;padding:0.0000pt 5.4000pt 0.0000pt 5.4000pt ;border-left:1.0000pt solid windowtext;border-right:1.0000pt solid windowtext;border-top:none;border-bottom:1.0000pt solid windowtext;\" valign=\"center\" width=\"18.693284936479127%\"><p style=\"text-align:center;\"><span style=\"font-family:Calibri;font-size:14px;\">五年级<\/span><\/p><\/td><td style=\"width:155.9000pt;padding:0.0000pt 5.4000pt 0.0000pt 5.4000pt ;border-left:none;border-right:1.0000pt solid windowtext;border-top:none;border-bottom:1.0000pt solid windowtext;\" valign=\"center\" width=\"37.56805807622504%\"><p><span style=\"font-family:Calibri;font-size:14px;\">对事物的感知更精确、注意力更集中、竞争意识更强、<\/span><span style=\"font-family:宋体;font-size:14px;\">对老师不公正的处理会有不满的表现<\/span><span style=\"font-family:Calibri;font-size:14px;\">、自我意识加强<\/span><\/p><\/td><td style=\"width:181.1500pt;padding:0.0000pt 5.4000pt 0.0000pt 5.4000pt ;border-left:none;border-right:1.0000pt solid windowtext;border-top:none;border-bottom:1.0000pt solid windowtext;\" valign=\"center\" width=\"43.738656987295826%\"><p><span style=\"font-family:Calibri;font-size:14px;\">学会归纳重点、培养计划性、培养幽默能力、培养写作创造性、<\/span><span style=\"font-family:宋体;font-size:14px;\">正确处理冒险精神与偷窃问题<\/span><span style=\"font-family:Calibri;font-size:14px;\">、<\/span><span style=\"font-family:宋体;font-size:14px;\">增强学习技能训练<\/span><span style=\"font-family:Calibri;font-size:14px;\">、树立<\/span><span style=\"font-family:宋体;font-size:14px;\">正确的竞争意识<\/span><span style=\"font-family:Calibri;font-size:14px;\">、<\/span><span style=\"font-family:宋体;font-size:14px;\">建立进取的人生态度<\/span><\/p><\/td><\/tr><tr><td style=\"width:77.7500pt;padding:0.0000pt 5.4000pt 0.0000pt 5.4000pt ;border-left:1.0000pt solid windowtext;border-right:1.0000pt solid windowtext;border-top:none;border-bottom:1.0000pt solid windowtext;\" valign=\"center\" width=\"18.693284936479127%\"><p style=\"text-align:center;\"><span style=\"font-family:Calibri;font-size:14px;\">六年级<\/span><\/p><\/td><td style=\"width:155.9000pt;padding:0.0000pt 5.4000pt 0.0000pt 5.4000pt ;border-left:none;border-right:1.0000pt solid windowtext;border-top:none;border-bottom:1.0000pt solid windowtext;\" valign=\"center\" width=\"37.56805807622504%\"><p><span style=\"font-family:宋体;font-size:14px;\">喜爱规则竞赛<\/span><span style=\"font-family:Calibri;font-size:14px;\">、<\/span><span style=\"font-family:宋体;font-size:14px;\">经常<\/span><span style=\"font-family:Calibri;font-size:14px;\">高估自己、内心世界丰富、出现反抗精神、<\/span><span style=\"font-family:宋体;font-size:14px;\">论证事物的方式较为片面<\/span><span style=\"font-family:Calibri;font-size:14px;\">、很难被说服、会不时失去信心、容易被引导产生错误认知<\/span><\/p><\/td><td style=\"width:181.1500pt;padding:0.0000pt 5.4000pt 0.0000pt 5.4000pt ;border-left:none;border-right:1.0000pt solid windowtext;border-top:none;border-bottom:1.0000pt solid windowtext;\" valign=\"center\" width=\"43.738656987295826%\"><p><span style=\"font-family:Calibri;font-size:14px;\">学会坦率表达真实想法、找准自我定位、提高学习效率、扩大知识面、互相合作、承担力所能及的责任和义务、、合理把控<\/span><span style=\"font-family:宋体;font-size:14px;\">&ldquo;虚荣心&rdquo;<\/span><span style=\"font-family:Calibri;font-size:14px;\">、养成正确的价值观和是非观<\/span><\/p><\/td><\/tr><\/tbody><\/table><p><br><\/p><p><br><\/p><p><strong><span style=\"font-family:宋体;font-weight:bold;font-size:14px;\">选择PBL成长<\/span><\/strong><strong><span style=\"font-family:Calibri;font-weight:bold;font-size:14px;\">教育戏剧的原因<\/span><\/strong><\/p><p><br><\/p><p><strong><span style=\"font-family:宋体;font-weight:bold;font-size:14px;\">强大<\/span><\/strong><strong><span style=\"font-family:Calibri;font-weight:bold;font-size:14px;\">师资保障<\/span><\/strong><\/p><p><span style=\"font-family:宋体;font-size:14px;\">由受过专业心理知识培训、首批获国家专业技能证书的教育戏剧老师授课<\/span><span style=\"font-family:Calibri;font-size:14px;\">，<\/span><span style=\"font-family:宋体;font-size:14px;\">保障<\/span><span style=\"font-family:Calibri;font-size:14px;\">师资的专业和权威。<\/span><\/p><p><img src=\"https://www.maiguanjy.com/storage/2019-11-19/AB8XBUN0slzKfrIlkDGFHq2jWGyGuhPaCjDgYHaf.jpeg\" style=\"width: 300px;\" class=\"fr-fic fr-dib\"><\/p><p><br><\/p><p><strong><span style=\"font-family:宋体;font-weight:bold;font-size:14px;\">科学的<\/span><\/strong><strong><span style=\"font-family:Calibri;font-weight:bold;font-size:14px;\">教学方式<\/span><\/strong><\/p><p><span style=\"font-family:Calibri;font-size:14px;\">入学测试，<\/span><span style=\"font-family:宋体;font-size:14px;\">按照<\/span><span style=\"font-family:Calibri;font-size:14px;\">不同性格特点分<\/span><span style=\"font-family:宋体;font-size:14px;\">班。在<\/span><span style=\"font-family:Calibri;font-size:14px;\">教学过程中，<\/span><span style=\"font-family:宋体;font-size:14px;\">根据<\/span><span style=\"font-family:Calibri;font-size:14px;\">不同的个体状态针对性<\/span><span style=\"font-family:宋体;font-size:14px;\">指导<\/span><span style=\"font-family:Calibri;font-size:14px;\">教学<\/span><span style=\"font-family:宋体;font-size:14px;\">。<\/span><\/p><p><img src=\"https://www.maiguanjy.com/storage/2019-11-19/dPuGH1FCk7ldDXUr8i5HrMQxcFeM4IhI2oUjjdY7.jpeg\" style=\"width: 300px;\" class=\"fr-fic fr-dib\"><\/p><p><br><\/p><p><strong><span style=\"font-family:宋体;font-weight:bold;font-size:14px;\">量化<\/span><\/strong><strong><span style=\"font-family:Calibri;font-weight:bold;font-size:14px;\">课堂表现<\/span><\/strong><\/p><p><span style=\"font-family:宋体;font-size:14px;\">对孩子每节课的表现量化评分，形成数据分析表，跟踪记录<\/span><span style=\"font-family:Calibri;font-size:14px;\">孩子的成长变化。<\/span><\/p><p><img src=\"https://www.maiguanjy.com/storage/2019-11-19/HBs1tIhSpxhnvSBrJQhgp0dW5jfBffpeJ4gjrupk.jpeg\" style=\"width: 300px;\" class=\"fr-fic fr-dib\"><\/p><p><br><\/p><p><strong><span style=\"font-family:宋体;font-weight:bold;font-size:14px;\">寓教于乐，参与感强<\/span><\/strong><\/p><p><span style=\"font-family:宋体;font-size:14px;\">融合游戏、假扮、故事和戏剧基本元素，让孩子全身心参与、零距离体验。<\/span><\/p><p><img src=\"https://www.maiguanjy.com/storage/2019-11-19/okUfSvxz8fAWQ3cdKgOcBkWj5wqxMkXXW6b0q76p.jpeg\" style=\"width: 300px;\" class=\"fr-fic fr-dib\"><\/p><p><br><\/p><p><strong><span style=\"font-family:宋体;font-weight:bold;font-size:14px;\">丰富人生体验<\/span><\/strong><strong><span style=\"font-family:Calibri;font-weight:bold;font-size:14px;\">，强化心理素质<\/span><\/strong><\/p><p><span style=\"font-family:宋体;font-size:14px;\">在不同的戏剧项目中模拟多种多样的人生境遇，增加失败、成功、沮丧等不同人生体验，强化孩子<\/span><span style=\"font-family:Calibri;font-size:14px;\">的<\/span><span style=\"font-family:宋体;font-size:14px;\">心理素质。<\/span><\/p><p><img src=\"https://www.maiguanjy.com/storage/2019-11-19/713v2dRDnA0GGhxgHTy8xK5sco4DiFNNpMeVFUWl.jpeg\" style=\"width: 300px;\" class=\"fr-fic fr-dib\"><\/p><p><br><\/p><p style=\"text-align:left;\"><strong><span style=\"font-family:宋体;font-weight:bold;font-size:14px;\">提升<\/span><\/strong><strong><span style=\"font-family:Calibri;font-weight:bold;font-size:14px;\">综合<\/span><\/strong><strong><span style=\"font-family:宋体;font-weight:bold;font-size:14px;\">素质<\/span><\/strong><\/p><p><span style=\"font-family:宋体;font-size:14px;\">在<\/span><span style=\"font-family:Calibri;font-size:14px;\">戏剧<\/span><span style=\"font-family:宋体;font-size:14px;\">项目<\/span><span style=\"font-family:Calibri;font-size:14px;\">中<\/span><span style=\"font-family:宋体;font-size:14px;\">完成<\/span><span style=\"font-family:Calibri;font-size:14px;\">形象设计及道具制作，<\/span><span style=\"font-family:宋体;font-size:14px;\">正向<\/span><span style=\"font-family:Calibri;font-size:14px;\">强化孩子的动手动脑、<\/span><span style=\"font-family:宋体;font-size:14px;\">想象力<\/span><span style=\"font-family:Calibri;font-size:14px;\">、团队协作、<\/span><span style=\"font-family:宋体;font-size:14px;\">美学<\/span><span style=\"font-family:Calibri;font-size:14px;\">素养等综合能力<\/span><span style=\"font-family:宋体;font-size:14px;\">。<\/span><\/p><p><img src=\"https://www.maiguanjy.com/storage/2019-11-19/rsbW4rYVLqfireCZZ88qEs0jDM0pjd4Mbsr8o5st.jpeg\" style=\"width: 300px;\" class=\"fr-fic fr-dib\"><\/p><p><br><\/p><p><strong><span style=\"font-family:宋体;font-weight:bold;font-size:14px;\">科普专业的心理学<\/span><\/strong><strong><span style=\"font-family:Calibri;font-weight:bold;font-size:14px;\">知识<\/span><\/strong><\/p><p><span style=\"font-family:宋体;font-size:14px;\">让孩子了解心理学知识，掌握情绪疏导和心态调整的方法。为家长提供科学合理的教育指导方法，从心理学角度正确、恰当的引导孩子行为。<\/span><\/p><p><strong><span style=\"font-family:Calibri;font-weight:bold;font-size:14px;\"><\/span><\/strong><img src=\"https://www.maiguanjy.com/storage/2019-11-19/gpyb7422ALBsLXpJWmarERkA1ErgpsTn1jUh0I8f.jpeg\" style=\"width: 300px;\" class=\"fr-fic fr-dib\"><\/p><p data-f-id=\"pbf\" style=\"text-align: center; font-size: 14px; margin-top: 30px; opacity: 0.65; font-family: sans-serif;\">Powered by <a href=\"https://www.froala.com/wysiwyg-editor?pb=1\" title=\"Froala Editor\">Froala Editor<\/a><\/p>","description":"在戏剧中促进儿童心智发展","cover_pic":"storage/2019-11-19/zzu9CqyAgVs6cEzZyUSrQenla4ipr66tDPxdGz6Z.jpeg","detail_pic":"storage/2019-11-19/bZkcy0NUSjq6fFWL5U3Zq0SHdLcF2NmxQnjRVaRn.jpeg","distribution_ratio1":null,"distribution_ratio2":null,"distribution_ratio3":null,"click_rate":null,"sort":1,"status":"0","createDt":"2019-11-19 10:34:23","updateDt":"2019-11-19 10:34:23","stars":0,"discount":0,"course_type":"offline"}
         */

        private int id;
        private String course_type;
        private Object wechat_order_id;
        private int course_id;
        private int user_id;
        private Object pay_type;
        private int order_amount;
        private int pay_amount;
        private int virtual_currency;
        private String status;
        private Object recommend_user_id;
        private Object pay_time;
        private Object confirm_time;
        private String createDt;
        private String updateDt;
        private Object section_up_json;
        private Object agent_user_1;
        private Object agent_user_2;
        private Object agent_user_3;
        private String is_apply_changing;
        private Object user_course_pindan_id;
        private Object user_course_pindan_type;
        private Object jigou_id;
        private Object order_flag;
        private String no;
        private String card_type;
        private int child_id;
        private CourseBeanXX course;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getCourse_type() {
            return course_type;
        }

        public void setCourse_type(String course_type) {
            this.course_type = course_type;
        }

        public Object getWechat_order_id() {
            return wechat_order_id;
        }

        public void setWechat_order_id(Object wechat_order_id) {
            this.wechat_order_id = wechat_order_id;
        }

        public int getCourse_id() {
            return course_id;
        }

        public void setCourse_id(int course_id) {
            this.course_id = course_id;
        }

        public int getUser_id() {
            return user_id;
        }

        public void setUser_id(int user_id) {
            this.user_id = user_id;
        }

        public Object getPay_type() {
            return pay_type;
        }

        public void setPay_type(Object pay_type) {
            this.pay_type = pay_type;
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

        public int getVirtual_currency() {
            return virtual_currency;
        }

        public void setVirtual_currency(int virtual_currency) {
            this.virtual_currency = virtual_currency;
        }

        public String getStatus() {
            return status;
        }

        public void setStatus(String status) {
            this.status = status;
        }

        public Object getRecommend_user_id() {
            return recommend_user_id;
        }

        public void setRecommend_user_id(Object recommend_user_id) {
            this.recommend_user_id = recommend_user_id;
        }

        public Object getPay_time() {
            return pay_time;
        }

        public void setPay_time(Object pay_time) {
            this.pay_time = pay_time;
        }

        public Object getConfirm_time() {
            return confirm_time;
        }

        public void setConfirm_time(Object confirm_time) {
            this.confirm_time = confirm_time;
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

        public Object getSection_up_json() {
            return section_up_json;
        }

        public void setSection_up_json(Object section_up_json) {
            this.section_up_json = section_up_json;
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

        public String getIs_apply_changing() {
            return is_apply_changing;
        }

        public void setIs_apply_changing(String is_apply_changing) {
            this.is_apply_changing = is_apply_changing;
        }

        public Object getUser_course_pindan_id() {
            return user_course_pindan_id;
        }

        public void setUser_course_pindan_id(Object user_course_pindan_id) {
            this.user_course_pindan_id = user_course_pindan_id;
        }

        public Object getUser_course_pindan_type() {
            return user_course_pindan_type;
        }

        public void setUser_course_pindan_type(Object user_course_pindan_type) {
            this.user_course_pindan_type = user_course_pindan_type;
        }

        public Object getJigou_id() {
            return jigou_id;
        }

        public void setJigou_id(Object jigou_id) {
            this.jigou_id = jigou_id;
        }

        public Object getOrder_flag() {
            return order_flag;
        }

        public void setOrder_flag(Object order_flag) {
            this.order_flag = order_flag;
        }

        public String getNo() {
            return no;
        }

        public void setNo(String no) {
            this.no = no;
        }

        public String getCard_type() {
            return card_type;
        }

        public void setCard_type(String card_type) {
            this.card_type = card_type;
        }

        public int getChild_id() {
            return child_id;
        }

        public void setChild_id(int child_id) {
            this.child_id = child_id;
        }

        public CourseBeanXX getCourse() {
            return course;
        }

        public void setCourse(CourseBeanXX course) {
            this.course = course;
        }

        public static class CourseBeanXX {
            /**
             * id : 12
             * class_id : 50
             * name : PBL成长教育戏剧
             * teacher_id : 149
             * theme_id : null
             * num : 52
             * price : {"month":{"name":"\u6708\u5361","price":0,"num":null,"day":null},"season":{"name":"\u5b63\u5361","price":380000,"num":"13","day":null},"year":{"name":"\u5e74\u5361","price":1280000,"num":"48","day":null}}
             * deductible_virtual_currency : 0
             * deductible_real_currency : 0
             * largess_virtual_currency : 0
             * profile : <p style="text-align:center;"><strong><span style="font-family:宋体;font-weight:bold;font-size:21px;">P</span></strong><strong><span style="font-family:Calibri;font-weight:bold;font-size:21px;">BL成长教育戏剧</span></strong></p><p><br></p><p><br></p><p><strong><span style="font-family:宋体;font-weight:bold;font-size:14px;">在戏剧中促进儿童心智发展</span></strong></p><p><br></p><p><span style="font-family:宋体;font-size:14px;">PBL成长教育戏剧以寓教于乐的戏剧项目为载体，根据少年儿童不同年龄段心理、生理的发展特点，在教育戏剧中融入心智发展的专业教学内容。通过不同角色的扮演，让孩子模拟多种多样的人生境遇，在专业老师的正向引导中全面发展心智、塑造健全人格。</span></p><p><img src="https://www.maiguanjy.com/storage/2019-11-19/sKZtj2UIpcHF5me6elPJADkeZIiJPWHzXLcPQddE.jpeg" style="width: 300px;" class="fr-fic fr-dib"></p><p><br></p><p><strong><span style="font-family:宋体;font-weight:bold;font-size:14px;">更专业的师资保障</span></strong></p><p><br></p><p><span style="font-family:宋体;font-size:14px;">所有戏剧教师均受过专业心理知识培训，系首批获国家专业技能证书的上岗教师</span><span style="font-family:Calibri;font-size:14px;">。</span></p><p><img src="https://www.maiguanjy.com/storage/2019-11-19/MS2gsa1r2MruE7AjftGAO3alEs9JgXOTRMMIOUJ5.jpeg" style="width: 300px;" class="fr-fic fr-dib"></p><p><br></p><p><strong><span style="font-family:宋体;font-weight:bold;font-size:14px;">在戏剧体验</span></strong><strong><span style="font-family:Calibri;font-weight:bold;font-size:14px;">中收获成长</span></strong></p><p><br></p><table border="1" cellspacing="0" style="border-collapse: collapse;width: 100%;border: none;"><tbody><tr><td style="width:138.2500pt;padding:0.0000pt 5.4000pt 0.0000pt 5.4000pt ;border-left:1.0000pt solid windowtext;border-right:1.0000pt solid windowtext;border-top:1.0000pt solid windowtext;border-bottom:1.0000pt solid windowtext;" valign="center" width="33.333333333333336%"><p style="text-align:center;"><strong><span style="font-family:宋体;font-weight:bold;font-size:14px;">个人成长</span></strong></p></td><td style="width:138.2500pt;padding:0.0000pt 5.4000pt 0.0000pt 5.4000pt ;border-left:none;border-right:1.0000pt solid windowtext;border-top:1.0000pt solid windowtext;border-bottom:1.0000pt solid windowtext;" valign="center" width="33.333333333333336%"><p style="text-align:center;"><strong><span style="font-family:宋体;font-weight:bold;font-size:14px;">家庭关系</span></strong></p></td><td style="width:138.3000pt;padding:0.0000pt 5.4000pt 0.0000pt 5.4000pt ;border-left:none;border-right:1.0000pt solid windowtext;border-top:1.0000pt solid windowtext;border-bottom:1.0000pt solid windowtext;" valign="center" width="33.333333333333336%"><p style="text-align:center;"><strong><span style="font-family:宋体;font-weight:bold;font-size:14px;">社会关系</span></strong></p></td></tr><tr><td style="width:138.2500pt;padding:0.0000pt 5.4000pt 0.0000pt 5.4000pt ;border-left:1.0000pt solid windowtext;border-right:1.0000pt solid windowtext;border-top:none;border-bottom:1.0000pt solid windowtext;" valign="center" width="33.333333333333336%"><p style="text-align:center;"><span style="font-family:宋体;font-size:14px;">提高情商</span></p><p style="text-align:center;"><span style="font-family:宋体;font-size:14px;">建立初步心理认知</span></p><p style="text-align:center;"><span style="font-family:宋体;font-size:14px;">正向引导情绪管理</span></p><p style="text-align:center;"><span style="font-family:宋体;font-size:14px;">纠正不良行为习惯</span></p><p style="text-align:center;"><span style="font-family:宋体;font-size:14px;">强化团队协作意识</span></p><p style="text-align:center;"><span style="font-family:Calibri;font-size:14px;">提高自处</span><span style="font-family:宋体;font-size:14px;">能力</span></p><p style="text-align:center;"><span style="font-family:Calibri;font-size:14px;">提升社交能力</span></p><p style="text-align:center;"><span style="font-family:Calibri;font-size:14px;">树立正确三观</span></p><p style="text-align:center;"><span style="font-family:Calibri;font-size:14px;">塑造完美型健全人格</span></p></td><td style="width:138.2500pt;padding:0.0000pt 5.4000pt 0.0000pt 5.4000pt ;border-left:none;border-right:1.0000pt solid windowtext;border-top:none;border-bottom:1.0000pt solid windowtext;" valign="center" width="33.333333333333336%"><p style="text-align:center;"><span style="font-family:宋体;font-size:14px;">强化共情意识和换位思考</span></p><p style="text-align:center;"><span style="font-family:宋体;font-size:14px;">妥善处理亲密关系</span></p><p style="text-align:center;"><span style="font-family:Calibri;font-size:14px;">正确</span><span style="font-family:宋体;font-size:14px;">疏导个人情绪波动</span></p><p style="text-align:center;"><span style="font-family:宋体;font-size:14px;">排解</span><span style="font-family:Calibri;font-size:14px;">成员相处间的矛盾</span></p><p style="text-align:center;"><span style="font-family:宋体;font-size:14px;">打造良好的家庭教育环境</span></p><p style="text-align:center;"><br></p></td><td style="width:138.3000pt;padding:0.0000pt 5.4000pt 0.0000pt 5.4000pt ;border-left:none;border-right:1.0000pt solid windowtext;border-top:none;border-bottom:1.0000pt solid windowtext;" valign="center" width="33.333333333333336%"><p style="text-align:center;"><span style="font-family:宋体;font-size:14px;">寻找自我定位</span></p><p style="text-align:center;"><span style="font-family:宋体;font-size:14px;">清晰社会认知</span></p><p style="text-align:center;"><span style="font-family:宋体;font-size:14px;">构建良性的同伴关系</span></p><p style="text-align:center;"><span style="font-family:Calibri;font-size:14px;">学会解决伙伴间的冲突</span></p><p style="text-align:center;"><span style="font-family:宋体;font-size:14px;">正确排解社会压力</span></p><p style="text-align:center;"><span style="font-family:宋体;font-size:14px;">个性和社会性全面发展</span></p></td></tr></tbody></table><p><br></p><p><br></p><p><strong><span style="font-family:Calibri;font-weight:bold;font-size:14px;">结合儿童心理发展规律解决问题</span></strong></p><p><br></p><p><span style="font-family:宋体;font-size:14px;">1~</span><span style="font-family:Calibri;font-size:14px;">6</span><span style="font-family:宋体;font-size:14px;">年级</span><span style="font-family:Calibri;font-size:14px;">是儿童</span><span style="font-family:宋体;font-size:14px;">心理发展</span><span style="font-family:Calibri;font-size:14px;">的关键时期，</span><span style="font-family:宋体;font-size:14px;">从儿童常见</span><span style="font-family:Calibri;font-size:14px;">的心理状态</span><span style="font-family:宋体;font-size:14px;">出发</span><span style="font-family:Calibri;font-size:14px;">，</span><span style="font-family:宋体;font-size:14px;">结合</span><span style="font-family:Calibri;font-size:14px;">心理学知识及儿童心理发展规律，</span><span style="font-family:宋体;font-size:14px;">设计具有针对性的教育戏剧项目</span><span style="font-family:Calibri;font-size:14px;">。</span></p><p><br></p><table border="1" cellspacing="0" style="border-collapse: collapse;width: 100%;border: none;"><tbody><tr><td style="width:77.7500pt;padding:0.0000pt 5.4000pt 0.0000pt 5.4000pt ;border-left:1.0000pt solid windowtext;border-right:1.0000pt solid windowtext;border-top:1.0000pt solid windowtext;border-bottom:1.0000pt solid windowtext;" valign="center" width="18.693284936479127%"><p style="text-align:center;"><strong><span style="font-family:Calibri;font-weight:bold;font-size:14px;">年龄段</span></strong></p></td><td style="width:155.9000pt;padding:0.0000pt 5.4000pt 0.0000pt 5.4000pt ;border-left:none;border-right:1.0000pt solid windowtext;border-top:1.0000pt solid windowtext;border-bottom:1.0000pt solid windowtext;" valign="center" width="37.56805807622504%"><p style="text-align:center;"><strong><span style="font-family:Calibri;font-weight:bold;font-size:14px;">常见心理状态</span></strong></p></td><td style="width:181.1500pt;padding:0.0000pt 5.4000pt 0.0000pt 5.4000pt ;border-left:none;border-right:1.0000pt solid windowtext;border-top:1.0000pt solid windowtext;border-bottom:1.0000pt solid windowtext;" valign="center" width="43.738656987295826%"><p style="text-align:center;"><strong><span style="font-family:宋体;font-weight:bold;font-size:14px;">心理</span></strong><strong><span style="font-family:Calibri;font-weight:bold;font-size:14px;">构建目标</span></strong></p></td></tr><tr><td style="width:77.7500pt;padding:0.0000pt 5.4000pt 0.0000pt 5.4000pt ;border-left:1.0000pt solid windowtext;border-right:1.0000pt solid windowtext;border-top:none;border-bottom:1.0000pt solid windowtext;" valign="center" width="18.693284936479127%"><p style="text-align:center;"><span style="font-family:Calibri;font-size:14px;">一年级</span></p></td><td style="width:155.9000pt;padding:0.0000pt 5.4000pt 0.0000pt 5.4000pt ;border-left:none;border-right:1.0000pt solid windowtext;border-top:none;border-bottom:1.0000pt solid windowtext;" valign="center" width="37.56805807622504%"><p><span style="font-family:Calibri;font-size:14px;">集体意识较弱、不</span><span style="font-family:宋体;font-size:14px;">具备自我评价能力</span><span style="font-family:Calibri;font-size:14px;">、</span><span style="font-family:宋体;font-size:14px;">较为敏感</span><span style="font-family:Calibri;font-size:14px;">、</span><span style="font-family:宋体;font-size:14px;">不能正确表达</span><span style="font-family:Calibri;font-size:14px;">、存在孤独感、</span><span style="font-family:宋体;font-size:14px;">缺乏安全感</span></p></td><td style="width:181.1500pt;padding:0.0000pt 5.4000pt 0.0000pt 5.4000pt ;border-left:none;border-right:1.0000pt solid windowtext;border-top:none;border-bottom:1.0000pt solid windowtext;" valign="center" width="43.738656987295826%"><p><span style="font-family:Calibri;font-size:14px;">激发自我意识、养成良好习惯、适应新环境、初步建立人际关系、培养学习兴趣、正确表达自身想法</span></p></td></tr><tr><td style="width:77.7500pt;padding:0.0000pt 5.4000pt 0.0000pt 5.4000pt ;border-left:1.0000pt solid windowtext;border-right:1.0000pt solid windowtext;border-top:none;border-bottom:1.0000pt solid windowtext;" valign="center" width="18.693284936479127%"><p style="text-align:center;"><span style="font-family:Calibri;font-size:14px;">二年级</span></p></td><td style="width:155.9000pt;padding:0.0000pt 5.4000pt 0.0000pt 5.4000pt ;border-left:none;border-right:1.0000pt solid windowtext;border-top:none;border-bottom:1.0000pt solid windowtext;" valign="center" width="37.56805807622504%"><p><span style="font-family:Calibri;font-size:14px;">渴求表扬、注意力不集中、说谎、注重输赢、形成自我判断力</span></p></td><td style="width:181.1500pt;padding:0.0000pt 5.4000pt 0.0000pt 5.4000pt ;border-left:none;border-right:1.0000pt solid windowtext;border-top:none;border-bottom:1.0000pt solid windowtext;" valign="center" width="43.738656987295826%"><p><span style="font-family:Calibri;font-size:14px;">体会责任感、自觉遵守规则、形成集体荣誉感、培养正确胜负观、诚实守信</span></p></td></tr><tr><td style="width:77.7500pt;padding:0.0000pt 5.4000pt 0.0000pt 5.4000pt ;border-left:1.0000pt solid windowtext;border-right:1.0000pt solid windowtext;border-top:none;border-bottom:1.0000pt solid windowtext;" valign="center" width="18.693284936479127%"><p style="text-align:center;"><span style="font-family:Calibri;font-size:14px;">三年级</span></p></td><td style="width:155.9000pt;padding:0.0000pt 5.4000pt 0.0000pt 5.4000pt ;border-left:none;border-right:1.0000pt solid windowtext;border-top:none;border-bottom:1.0000pt solid windowtext;" valign="center" width="37.56805807622504%"><p><span style="font-family:Calibri;font-size:14px;">有意识的自我展示、兴趣广泛、时间和空间感较差、自制力差、有意识形成小团体、积极做事但耐性低、推崇有力量的英雄</span></p></td><td style="width:181.1500pt;padding:0.0000pt 5.4000pt 0.0000pt 5.4000pt ;border-left:none;border-right:1.0000pt solid windowtext;border-top:none;border-bottom:1.0000pt solid windowtext;" valign="center" width="43.738656987295826%"><p><span style="font-family:Calibri;font-size:14px;">提升自制力、集中注意力、提升空间感和时间感、初步形成正确的心理价值观、树立正确的偶像观、培养劳动习惯、培养正确的学习习惯</span></p></td></tr><tr><td style="width:77.7500pt;padding:0.0000pt 5.4000pt 0.0000pt 5.4000pt ;border-left:1.0000pt solid windowtext;border-right:1.0000pt solid windowtext;border-top:none;border-bottom:1.0000pt solid windowtext;" valign="center" width="18.693284936479127%"><p style="text-align:center;"><span style="font-family:Calibri;font-size:14px;">四年级</span></p></td><td style="width:155.9000pt;padding:0.0000pt 5.4000pt 0.0000pt 5.4000pt ;border-left:none;border-right:1.0000pt solid windowtext;border-top:none;border-bottom:1.0000pt solid windowtext;" valign="center" width="37.56805807622504%"><p><span style="font-family:Calibri;font-size:14px;">情绪性明显、爱争论问题、容易激动、开始在意自我形象、对事情有自我判断、</span><span style="font-family:宋体;font-size:14px;">习惯</span><span style="font-family:Calibri;font-size:14px;">养成与性格塑造的关键期</span></p></td><td style="width:181.1500pt;padding:0.0000pt 5.4000pt 0.0000pt 5.4000pt ;border-left:none;border-right:1.0000pt solid windowtext;border-top:none;border-bottom:1.0000pt solid windowtext;" valign="center" width="43.738656987295826%"><p><span style="font-family:Calibri;font-size:14px;">正确打扮自己、培养自行解决和自行选择的能力、勇于承担后果、正确处理情绪、合理讨论与表达自我意见、</span><span style="font-family:宋体;font-size:14px;">培养正确的行为习惯与自身性格</span></p></td></tr><tr><td style="width:77.7500pt;padding:0.0000pt 5.4000pt 0.0000pt 5.4000pt ;border-left:1.0000pt solid windowtext;border-right:1.0000pt solid windowtext;border-top:none;border-bottom:1.0000pt solid windowtext;" valign="center" width="18.693284936479127%"><p style="text-align:center;"><span style="font-family:Calibri;font-size:14px;">五年级</span></p></td><td style="width:155.9000pt;padding:0.0000pt 5.4000pt 0.0000pt 5.4000pt ;border-left:none;border-right:1.0000pt solid windowtext;border-top:none;border-bottom:1.0000pt solid windowtext;" valign="center" width="37.56805807622504%"><p><span style="font-family:Calibri;font-size:14px;">对事物的感知更精确、注意力更集中、竞争意识更强、</span><span style="font-family:宋体;font-size:14px;">对老师不公正的处理会有不满的表现</span><span style="font-family:Calibri;font-size:14px;">、自我意识加强</span></p></td><td style="width:181.1500pt;padding:0.0000pt 5.4000pt 0.0000pt 5.4000pt ;border-left:none;border-right:1.0000pt solid windowtext;border-top:none;border-bottom:1.0000pt solid windowtext;" valign="center" width="43.738656987295826%"><p><span style="font-family:Calibri;font-size:14px;">学会归纳重点、培养计划性、培养幽默能力、培养写作创造性、</span><span style="font-family:宋体;font-size:14px;">正确处理冒险精神与偷窃问题</span><span style="font-family:Calibri;font-size:14px;">、</span><span style="font-family:宋体;font-size:14px;">增强学习技能训练</span><span style="font-family:Calibri;font-size:14px;">、树立</span><span style="font-family:宋体;font-size:14px;">正确的竞争意识</span><span style="font-family:Calibri;font-size:14px;">、</span><span style="font-family:宋体;font-size:14px;">建立进取的人生态度</span></p></td></tr><tr><td style="width:77.7500pt;padding:0.0000pt 5.4000pt 0.0000pt 5.4000pt ;border-left:1.0000pt solid windowtext;border-right:1.0000pt solid windowtext;border-top:none;border-bottom:1.0000pt solid windowtext;" valign="center" width="18.693284936479127%"><p style="text-align:center;"><span style="font-family:Calibri;font-size:14px;">六年级</span></p></td><td style="width:155.9000pt;padding:0.0000pt 5.4000pt 0.0000pt 5.4000pt ;border-left:none;border-right:1.0000pt solid windowtext;border-top:none;border-bottom:1.0000pt solid windowtext;" valign="center" width="37.56805807622504%"><p><span style="font-family:宋体;font-size:14px;">喜爱规则竞赛</span><span style="font-family:Calibri;font-size:14px;">、</span><span style="font-family:宋体;font-size:14px;">经常</span><span style="font-family:Calibri;font-size:14px;">高估自己、内心世界丰富、出现反抗精神、</span><span style="font-family:宋体;font-size:14px;">论证事物的方式较为片面</span><span style="font-family:Calibri;font-size:14px;">、很难被说服、会不时失去信心、容易被引导产生错误认知</span></p></td><td style="width:181.1500pt;padding:0.0000pt 5.4000pt 0.0000pt 5.4000pt ;border-left:none;border-right:1.0000pt solid windowtext;border-top:none;border-bottom:1.0000pt solid windowtext;" valign="center" width="43.738656987295826%"><p><span style="font-family:Calibri;font-size:14px;">学会坦率表达真实想法、找准自我定位、提高学习效率、扩大知识面、互相合作、承担力所能及的责任和义务、、合理把控</span><span style="font-family:宋体;font-size:14px;">&ldquo;虚荣心&rdquo;</span><span style="font-family:Calibri;font-size:14px;">、养成正确的价值观和是非观</span></p></td></tr></tbody></table><p><br></p><p><br></p><p><strong><span style="font-family:宋体;font-weight:bold;font-size:14px;">选择PBL成长</span></strong><strong><span style="font-family:Calibri;font-weight:bold;font-size:14px;">教育戏剧的原因</span></strong></p><p><br></p><p><strong><span style="font-family:宋体;font-weight:bold;font-size:14px;">强大</span></strong><strong><span style="font-family:Calibri;font-weight:bold;font-size:14px;">师资保障</span></strong></p><p><span style="font-family:宋体;font-size:14px;">由受过专业心理知识培训、首批获国家专业技能证书的教育戏剧老师授课</span><span style="font-family:Calibri;font-size:14px;">，</span><span style="font-family:宋体;font-size:14px;">保障</span><span style="font-family:Calibri;font-size:14px;">师资的专业和权威。</span></p><p><img src="https://www.maiguanjy.com/storage/2019-11-19/AB8XBUN0slzKfrIlkDGFHq2jWGyGuhPaCjDgYHaf.jpeg" style="width: 300px;" class="fr-fic fr-dib"></p><p><br></p><p><strong><span style="font-family:宋体;font-weight:bold;font-size:14px;">科学的</span></strong><strong><span style="font-family:Calibri;font-weight:bold;font-size:14px;">教学方式</span></strong></p><p><span style="font-family:Calibri;font-size:14px;">入学测试，</span><span style="font-family:宋体;font-size:14px;">按照</span><span style="font-family:Calibri;font-size:14px;">不同性格特点分</span><span style="font-family:宋体;font-size:14px;">班。在</span><span style="font-family:Calibri;font-size:14px;">教学过程中，</span><span style="font-family:宋体;font-size:14px;">根据</span><span style="font-family:Calibri;font-size:14px;">不同的个体状态针对性</span><span style="font-family:宋体;font-size:14px;">指导</span><span style="font-family:Calibri;font-size:14px;">教学</span><span style="font-family:宋体;font-size:14px;">。</span></p><p><img src="https://www.maiguanjy.com/storage/2019-11-19/dPuGH1FCk7ldDXUr8i5HrMQxcFeM4IhI2oUjjdY7.jpeg" style="width: 300px;" class="fr-fic fr-dib"></p><p><br></p><p><strong><span style="font-family:宋体;font-weight:bold;font-size:14px;">量化</span></strong><strong><span style="font-family:Calibri;font-weight:bold;font-size:14px;">课堂表现</span></strong></p><p><span style="font-family:宋体;font-size:14px;">对孩子每节课的表现量化评分，形成数据分析表，跟踪记录</span><span style="font-family:Calibri;font-size:14px;">孩子的成长变化。</span></p><p><img src="https://www.maiguanjy.com/storage/2019-11-19/HBs1tIhSpxhnvSBrJQhgp0dW5jfBffpeJ4gjrupk.jpeg" style="width: 300px;" class="fr-fic fr-dib"></p><p><br></p><p><strong><span style="font-family:宋体;font-weight:bold;font-size:14px;">寓教于乐，参与感强</span></strong></p><p><span style="font-family:宋体;font-size:14px;">融合游戏、假扮、故事和戏剧基本元素，让孩子全身心参与、零距离体验。</span></p><p><img src="https://www.maiguanjy.com/storage/2019-11-19/okUfSvxz8fAWQ3cdKgOcBkWj5wqxMkXXW6b0q76p.jpeg" style="width: 300px;" class="fr-fic fr-dib"></p><p><br></p><p><strong><span style="font-family:宋体;font-weight:bold;font-size:14px;">丰富人生体验</span></strong><strong><span style="font-family:Calibri;font-weight:bold;font-size:14px;">，强化心理素质</span></strong></p><p><span style="font-family:宋体;font-size:14px;">在不同的戏剧项目中模拟多种多样的人生境遇，增加失败、成功、沮丧等不同人生体验，强化孩子</span><span style="font-family:Calibri;font-size:14px;">的</span><span style="font-family:宋体;font-size:14px;">心理素质。</span></p><p><img src="https://www.maiguanjy.com/storage/2019-11-19/713v2dRDnA0GGhxgHTy8xK5sco4DiFNNpMeVFUWl.jpeg" style="width: 300px;" class="fr-fic fr-dib"></p><p><br></p><p style="text-align:left;"><strong><span style="font-family:宋体;font-weight:bold;font-size:14px;">提升</span></strong><strong><span style="font-family:Calibri;font-weight:bold;font-size:14px;">综合</span></strong><strong><span style="font-family:宋体;font-weight:bold;font-size:14px;">素质</span></strong></p><p><span style="font-family:宋体;font-size:14px;">在</span><span style="font-family:Calibri;font-size:14px;">戏剧</span><span style="font-family:宋体;font-size:14px;">项目</span><span style="font-family:Calibri;font-size:14px;">中</span><span style="font-family:宋体;font-size:14px;">完成</span><span style="font-family:Calibri;font-size:14px;">形象设计及道具制作，</span><span style="font-family:宋体;font-size:14px;">正向</span><span style="font-family:Calibri;font-size:14px;">强化孩子的动手动脑、</span><span style="font-family:宋体;font-size:14px;">想象力</span><span style="font-family:Calibri;font-size:14px;">、团队协作、</span><span style="font-family:宋体;font-size:14px;">美学</span><span style="font-family:Calibri;font-size:14px;">素养等综合能力</span><span style="font-family:宋体;font-size:14px;">。</span></p><p><img src="https://www.maiguanjy.com/storage/2019-11-19/rsbW4rYVLqfireCZZ88qEs0jDM0pjd4Mbsr8o5st.jpeg" style="width: 300px;" class="fr-fic fr-dib"></p><p><br></p><p><strong><span style="font-family:宋体;font-weight:bold;font-size:14px;">科普专业的心理学</span></strong><strong><span style="font-family:Calibri;font-weight:bold;font-size:14px;">知识</span></strong></p><p><span style="font-family:宋体;font-size:14px;">让孩子了解心理学知识，掌握情绪疏导和心态调整的方法。为家长提供科学合理的教育指导方法，从心理学角度正确、恰当的引导孩子行为。</span></p><p><strong><span style="font-family:Calibri;font-weight:bold;font-size:14px;"></span></strong><img src="https://www.maiguanjy.com/storage/2019-11-19/gpyb7422ALBsLXpJWmarERkA1ErgpsTn1jUh0I8f.jpeg" style="width: 300px;" class="fr-fic fr-dib"></p><p data-f-id="pbf" style="text-align: center; font-size: 14px; margin-top: 30px; opacity: 0.65; font-family: sans-serif;">Powered by <a href="https://www.froala.com/wysiwyg-editor?pb=1" title="Froala Editor">Froala Editor</a></p>
             * description : 在戏剧中促进儿童心智发展
             * cover_pic : storage/2019-11-19/zzu9CqyAgVs6cEzZyUSrQenla4ipr66tDPxdGz6Z.jpeg
             * detail_pic : storage/2019-11-19/bZkcy0NUSjq6fFWL5U3Zq0SHdLcF2NmxQnjRVaRn.jpeg
             * distribution_ratio1 : null
             * distribution_ratio2 : null
             * distribution_ratio3 : null
             * click_rate : null
             * sort : 1
             * status : 0
             * createDt : 2019-11-19 10:34:23
             * updateDt : 2019-11-19 10:34:23
             * stars : 0
             * discount : 0
             * course_type : offline
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
            private String detail_pic;
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

            public String getDetail_pic() {
                return detail_pic;
            }

            public void setDetail_pic(String detail_pic) {
                this.detail_pic = detail_pic;
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
        }
    }
}
