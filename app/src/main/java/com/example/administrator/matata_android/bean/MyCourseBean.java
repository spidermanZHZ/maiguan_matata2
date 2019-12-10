package com.example.administrator.matata_android.bean;

import java.io.Serializable;

public class MyCourseBean implements Serializable {

    /**
     * id : 100000520
     * course_type : 01
     * wechat_order_id : null
     * course_id : 9
     * user_id : 2317
     * pay_type : wx
     * order_amount : 1
     * pay_amount : 1
     * virtual_currency : 0
     * status : 01
     * recommend_user_id : null
     * pay_time : null
     * confirm_time : null
     * createDt : 2019-12-10 17:37:22
     * updateDt : 2019-12-10 17:37:32
     * section_up_json : null
     * agent_user_1 : null
     * agent_user_2 : null
     * agent_user_3 : null
     * is_apply_changing : 0
     * user_course_pindan_id : null
     * user_course_pindan_type : null
     * jigou_id : null
     * order_flag : null
     * no : MTT20191210173725939775609
     * card_type : year
     * child_id : 21
     * course : {"id":9,"class_id":50,"name":"PBL双语教育戏剧","teacher_id":149,"theme_id":null,"num":52,"price":"{\"month\":{\"name\":\"\\u6708\\u5361\",\"price\":0,\"num\":null,\"day\":null},\"season\":{\"name\":\"\\u5b63\\u5361\",\"price\":1,\"num\":\"13\",\"day\":null},\"year\":{\"name\":\"\\u5e74\\u5361\",\"price\":1,\"num\":\"48\",\"day\":null}}","deductible_virtual_currency":0,"deductible_real_currency":0,"largess_virtual_currency":0,"profile":""description":"玩着学英语，培养孩子适应未来社会的必要能力","cover_pic":"storage/2019-11-15/weXYgTWlLDpMoQ6dlhCVgx9iTdSL3CTSt7ckRcoo.jpeg","detail_pic":"storage/2019-11-15/CQuo01yFMJy2u7BbgRgWI68RbwO6AOl4cY0nB7ab.jpeg","distribution_ratio1":null,"distribution_ratio2":null,"distribution_ratio3":null,"click_rate":null,"sort":1,"status":"0","createDt":"2019-11-18 16:46:18","updateDt":"2019-11-18 16:46:18","stars":0,"discount":0,"course_type":"drama"}
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
    private String card_type;
    private int child_id;
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

    public CourseBean getCourse() {
        return course;
    }

    public void setCourse(CourseBean course) {
        this.course = course;
    }

    public static class CourseBean {
        /**
         * id : 9
         * class_id : 50
         * name : PBL双语教育戏剧
         * teacher_id : 149
         * theme_id : null
         * num : 52
         * price : {"month":{"name":"\u6708\u5361","price":0,"num":null,"day":null},"season":{"name":"\u5b63\u5361","price":1,"num":"13","day":null},"year":{"name":"\u5e74\u5361","price":1,"num":"48","day":null}}
         * deductible_virtual_currency : 0
         * deductible_real_currency : 0
         * largess_virtual_currency : 0
         * profile : <p style="text-align:center;"><strong><span style="font-family:宋体;font-weight:bold;font-size:21px;">P</span></strong><strong><span style="font-family:Calibri;font-weight:bold;font-size:21px;">BL</span></strong><strong><span style="font-family:宋体;font-weight:bold;font-size:21px;">双语</span></strong><strong><span style="font-family:Calibri;font-weight:bold;font-size:21px;">教育戏剧</span></strong></p><p><br></p><p><br></p><p><strong><span style="font-family:Calibri;font-weight:bold;font-size:14px;">用戏剧的方式学英语</span></strong></p><p><br></p><p><span style="font-family:宋体;font-size:14px;">PBL双语教育戏剧以寓教于乐的戏剧项目为载体，融合文化、探险、科学、地理四大主题，打造全英语戏剧环境，</span><span style="font-family:Calibri;font-size:14px;">让孩子们通过玩戏剧的方式</span><span style="font-family:宋体;font-size:14px;">学习</span><span style="font-family:Calibri;font-size:14px;">或练习英语。</span></p><p><img src="https://www.maiguanjy.com/storage/2019-11-18/6fxbyxEWGRJt1d0cTTZgI8yF1JvDGa7BPSjoFHus.png" style="width: 300px;" class="fr-fic fr-dib"></p><p><br></p><p><br></p><p><strong><span style="font-family:宋体;font-weight:bold;font-size:14px;">专业双语师资</span></strong><strong><span style="font-family:Calibri;font-weight:bold;font-size:14px;">联袂授课</span></strong></p><p><br></p><p><span style="font-family:宋体;font-size:14px;">戏剧老师与语言老师同堂联袂授课。戏剧教师系首批获国家专业技能证书的上岗教师。外教及海归语言教师来自外国名校，保障</span><span style="font-family:Calibri;font-size:14px;">教学质量，</span><span style="font-family:宋体;font-size:14px;">有效强化</span><span style="font-family:Calibri;font-size:14px;">孩子的英语技能。</span></p><p><img src="https://www.maiguanjy.com/storage/2019-11-18/59JyKJo55c68066aBgLSXdWP5TWbjzmfLUAkzQFE.jpeg" style="width: 300px;" class="fr-fic fr-dib"></p><p><br></p><p><br></p><p><strong><span style="font-family:宋体;font-weight:bold;font-size:14px;">收获</span></strong></p><p><br></p><table border="1" cellspacing="0" style="border-collapse: collapse;border: none;width: 100%;"><tbody><tr><td style="width:99.0000pt;padding:0.0000pt 5.4000pt 0.0000pt 5.4000pt ;border-left:1.0000pt solid windowtext;border-right:1.0000pt solid windowtext;border-top:1.0000pt solid windowtext;border-bottom:1.0000pt solid windowtext;" valign="center" width="28.02547770700637%"><p style="text-align:center;"><br></p></td><td style="width:120.5000pt;padding:0.0000pt 5.4000pt 0.0000pt 5.4000pt ;border-left:none;border-right:1.0000pt solid windowtext;border-top:1.0000pt solid windowtext;border-bottom:1.0000pt solid windowtext;" valign="center" width="33.97027600849257%"><p style="text-align:center;"><strong><span style="font-family:宋体;font-weight:bold;font-size:14px;">英语</span></strong></p></td><td style="width:134.6500pt;padding:0.0000pt 5.4000pt 0.0000pt 5.4000pt ;border-left:none;border-right:1.0000pt solid windowtext;border-top:1.0000pt solid windowtext;border-bottom:1.0000pt solid windowtext;" valign="center" width="38.004246284501065%"><p style="text-align:center;"><strong><span style="font-family:宋体;font-weight:bold;font-size:14px;">戏剧</span></strong></p></td></tr><tr><td style="width:99.0000pt;padding:0.0000pt 5.4000pt 0.0000pt 5.4000pt ;border-left:1.0000pt solid windowtext;border-right:1.0000pt solid windowtext;border-top:none;border-bottom:1.0000pt solid windowtext;" valign="center" width="28.02547770700637%"><p style="text-align:center;"><strong><span style="font-family:宋体;font-weight:bold;font-size:14px;">LEVEL 1~ 2</span></strong></p></td><td style="width:120.5000pt;padding:0.0000pt 5.4000pt 0.0000pt 5.4000pt ;border-left:none;border-right:1.0000pt solid windowtext;border-top:none;border-bottom:1.0000pt solid windowtext;" valign="center" width="33.97027600849257%"><p style="text-align:center;"><span style="font-family:宋体;font-size:14px;">英语</span><span style="font-family:Calibri;font-size:14px;">戏剧环境</span><span style="font-family:宋体;font-size:14px;">、纠正错误</span><span style="font-family:Calibri;font-size:14px;">发音</span><span style="font-family:宋体;font-size:14px;">和</span><span style="font-family:Calibri;font-size:14px;">思维</span><span style="font-family:宋体;font-size:14px;">方式、巩固</span><span style="font-family:Calibri;font-size:14px;">基础词汇</span><span style="font-family:宋体;font-size:14px;">、口语表达</span></p></td><td rowspan="3" style="width:134.6500pt;padding:0.0000pt 5.4000pt 0.0000pt 5.4000pt ;border-left:none;border-right:1.0000pt solid windowtext;border-top:none;border-bottom:1.0000pt solid windowtext;" valign="center" width="38.004246284501065%"><p style="text-align:center;"><br></p><p style="text-align:center;"><span style="font-family:宋体;font-size:14px;">逻辑思维</span></p><p style="text-align:center;"><span style="font-family:宋体;font-size:14px;">想象力</span></p><p style="text-align:center;"><span style="font-family:宋体;font-size:14px;">表现力</span></p><p style="text-align:center;"><span style="font-family:宋体;font-size:14px;">理解力</span></p><p style="text-align:center;"><span style="font-family:宋体;font-size:14px;">动手</span><span style="font-family:Calibri;font-size:14px;">动脑</span></p><p style="text-align:center;"><span style="font-family:宋体;font-size:14px;">沟通与表达</span></p><p style="text-align:center;"><span style="font-family:宋体;font-size:14px;">共情</span><span style="font-family:Calibri;font-size:14px;">能力</span></p><p style="text-align:center;"><span style="font-family:宋体;font-size:14px;">团队协作能力</span></p><p style="text-align:center;"><span style="font-family:宋体;font-size:14px;">决策与组织能力</span></p><p style="text-align:center;"><span style="font-family:宋体;font-size:14px;">社交能力</span></p><p style="text-align:center;"><span style="font-family:宋体;font-size:14px;">&hellip;&hellip;</span></p><p style="text-align:center;"><br></p></td></tr><tr><td style="width:99.0000pt;padding:0.0000pt 5.4000pt 0.0000pt 5.4000pt ;border-left:1.0000pt solid windowtext;border-right:1.0000pt solid windowtext;border-top:none;border-bottom:1.0000pt solid windowtext;" valign="center" width="45.205479452054796%"><p style="text-align:center;"><strong><span style="font-family:宋体;font-weight:bold;font-size:14px;">LEVEL 3~ 4</span></strong></p></td><td style="width:120.5000pt;padding:0.0000pt 5.4000pt 0.0000pt 5.4000pt ;border-left:none;border-right:1.0000pt solid windowtext;border-top:none;border-bottom:1.0000pt solid windowtext;" valign="center" width="54.794520547945204%"><p style="text-align:center;"><span style="font-family:宋体;font-size:14px;">英式发音</span><span style="font-family:Calibri;font-size:14px;">、</span><span style="font-family:宋体;font-size:14px;">熟练</span><span style="font-family:Calibri;font-size:14px;">英语听说、</span><span style="font-family:宋体;font-size:14px;">俚语应用、特殊</span><span style="font-family:Calibri;font-size:14px;">句型、特定场景词汇</span></p></td></tr><tr><td style="width:99.0000pt;padding:0.0000pt 5.4000pt 0.0000pt 5.4000pt ;border-left:1.0000pt solid windowtext;border-right:1.0000pt solid windowtext;border-top:none;border-bottom:1.0000pt solid windowtext;" valign="center" width="45.205479452054796%"><p style="text-align:center;"><strong><span style="font-family:宋体;font-weight:bold;font-size:14px;">LEVEL 5</span></strong><strong><span style="font-family:Calibri;font-weight:bold;font-size:14px;">~</span></strong><strong><span style="font-family:宋体;font-weight:bold;font-size:14px;">&nbsp;6</span></strong></p></td><td style="width:120.5000pt;padding:0.0000pt 5.4000pt 0.0000pt 5.4000pt ;border-left:none;border-right:1.0000pt solid windowtext;border-top:none;border-bottom:1.0000pt solid windowtext;" valign="center" width="54.794520547945204%"><p style="text-align:center;"><span style="font-family:宋体;font-size:14px;">英文书面</span><span style="font-family:Calibri;font-size:14px;">表达、</span><span style="font-family:宋体;font-size:14px;">英式思维、强化英语</span><span style="font-family:Calibri;font-size:14px;">沟通</span><span style="font-family:宋体;font-size:14px;">、熟悉</span><span style="font-family:Calibri;font-size:14px;">各类句型</span><span style="font-family:宋体;font-size:14px;">、</span><span style="font-family:Calibri;font-size:14px;">丰富</span><span style="font-family:宋体;font-size:14px;">词汇量</span></p></td></tr></tbody></table><p><br></p><p style="text-align:right;"><br></p><p><strong><span style="font-family:宋体;font-weight:bold;font-size:14px;">多元</span></strong><strong><span style="font-family:Calibri;font-weight:bold;font-size:14px;">戏剧</span></strong><strong><span style="font-family:宋体;font-weight:bold;font-size:14px;">主题</span></strong><strong><span style="font-family:Calibri;font-weight:bold;font-size:14px;">项目</span></strong><strong><span style="font-family:宋体;font-weight:bold;font-size:14px;">课程</span></strong></p><p><br></p><p><strong><span style="font-family:Calibri;color:rgb(127,127,127);font-weight:bold;font-size:14px;">P</span></strong><strong><span style="font-family:宋体;color:rgb(127,127,127);font-weight:bold;font-size:14px;">s：孩子</span></strong><strong><span style="font-family:Calibri;color:rgb(127,127,127);font-weight:bold;font-size:14px;">将在</span></strong><strong><span style="font-family:宋体;color:rgb(127,127,127);font-weight:bold;font-size:14px;">开课前接受</span></strong><strong><span style="font-family:Calibri;color:rgb(127,127,127);font-weight:bold;font-size:14px;">英语水平</span></strong><strong><span style="font-family:宋体;color:rgb(127,127,127);font-weight:bold;font-size:14px;">测试</span></strong><strong><span style="font-family:Calibri;color:rgb(127,127,127);font-weight:bold;font-size:14px;">，根据</span></strong><strong><span style="font-family:宋体;color:rgb(127,127,127);font-weight:bold;font-size:14px;">测试</span></strong><strong><span style="font-family:Calibri;color:rgb(127,127,127);font-weight:bold;font-size:14px;">结果</span></strong><strong><span style="font-family:宋体;color:rgb(127,127,127);font-weight:bold;font-size:14px;">推荐不同</span></strong><strong><span style="font-family:Calibri;color:rgb(127,127,127);font-weight:bold;font-size:14px;">等级的戏剧项目。</span></strong></p><p><br></p><table border="1" cellspacing="0" style="border-collapse: collapse;border: none;width: 100%;"><tbody><tr><td style="width:99.0000pt;padding:0.0000pt 5.4000pt 0.0000pt 5.4000pt ;border-left:1.0000pt solid windowtext;border-right:1.0000pt solid windowtext;border-top:1.0000pt solid windowtext;border-bottom:1.0000pt solid windowtext;" valign="center" width="23.869801084990957%"><p style="text-align:center;"><strong><span style="font-family:宋体;font-weight:bold;font-size:14px;">LEVEL 1</span></strong></p></td><td style="width: 315.8pt;padding: 0pt 5.4pt;border-left: none;border-right: 1pt solid windowtext;border-top: 1pt solid windowtext;border-bottom: 1pt solid windowtext;vertical-align: top;" valign="top" width="76.13019891500905%"><p><span style="font-family:宋体;font-size:12px;">传统文化:《酒神节的故事》《奥林匹斯的由来》《老杰克的南瓜灯》 &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;探险:《海盗法典》《受诅咒的金子》 &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;</span></p><p><span style="font-family:宋体;font-size:12px;">科学:《哥白尼与日心说》《蒸汽的力量》 &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;</span></p><p><span style="font-family:宋体;font-size:12px;">地理:《落日的尼罗河》</span></p></td></tr><tr><td style="width:99.0000pt;padding:0.0000pt 5.4000pt 0.0000pt 5.4000pt ;border-left:1.0000pt solid windowtext;border-right:1.0000pt solid windowtext;border-top:none;border-bottom:1.0000pt solid windowtext;" valign="center" width="23.869801084990957%"><p style="text-align:center;"><strong><span style="font-family:宋体;font-weight:bold;font-size:14px;">LEVEL 2</span></strong></p></td><td style="width: 315.8pt;padding: 0pt 5.4pt;border-left: none;border-right: 1pt solid windowtext;border-top: none;border-bottom: 1pt solid windowtext;vertical-align: top;" valign="top" width="76.13019891500905%"><p><span style="font-family:宋体;font-size:12px;">传统文化:《尼伯龙根》《南丁格尔》 &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;&nbsp;</span></p><p><span style="font-family:宋体;font-size:12px;">探险:《通天塔废墟》《香巴拉》 &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;</span></p><p><span style="font-family:宋体;font-size:12px;">科学:《牛顿的苹果》《撬动地球之人》《巴甫洛夫的狗》 &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;&nbsp;</span></p><p><span style="font-family:宋体;font-size:12px;">地理:《世界屋脊》</span></p></td></tr><tr><td style="width:99.0000pt;padding:0.0000pt 5.4000pt 0.0000pt 5.4000pt ;border-left:1.0000pt solid windowtext;border-right:1.0000pt solid windowtext;border-top:none;border-bottom:1.0000pt solid windowtext;" valign="center" width="23.869801084990957%"><p style="text-align:center;"><strong><span style="font-family:宋体;font-weight:bold;font-size:14px;">LEVEL 3</span></strong></p></td><td style="width: 315.8pt;padding: 0pt 5.4pt;border-left: none;border-right: 1pt solid windowtext;border-top: none;border-bottom: 1pt solid windowtext;vertical-align: top;" valign="top" width="76.13019891500905%"><p><span style="font-family:宋体;font-size:12px;">传统文化:《圣诞精灵》《穿靴子的猫》《复活节的兔子》 &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;</span></p><p><span style="font-family:宋体;font-size:12px;">探险:《落日岛》 &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;</span></p><p><span style="font-family:宋体;font-size:12px;">科学:《银河系的模样》 &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;</span></p><p><span style="font-family:宋体;font-size:12px;">地理:《地球之肺》《东非大裂谷》《玛雅金字塔》</span></p></td></tr><tr><td style="width:99.0000pt;padding:0.0000pt 5.4000pt 0.0000pt 5.4000pt ;border-left:1.0000pt solid windowtext;border-right:1.0000pt solid windowtext;border-top:none;border-bottom:1.0000pt solid windowtext;" valign="center" width="23.869801084990957%"><p style="text-align:center;"><strong><span style="font-family:宋体;font-weight:bold;font-size:14px;">LEVEL 4</span></strong></p></td><td style="width: 315.8pt;padding: 0pt 5.4pt;border-left: none;border-right: 1pt solid windowtext;border-top: none;border-bottom: 1pt solid windowtext;vertical-align: top;" valign="top" width="76.13019891500905%"><p><span style="font-family:宋体;font-size:12px;">传统文化:《樱之歌》《西红柿作战》 &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;&nbsp;</span></p><p><span style="font-family:宋体;font-size:12px;">探险:《天上的城市》《塔尔塔罗斯》《海底两万里》 &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;&nbsp;</span></p><p><span style="font-family:宋体;font-size:12px;">科学:《地球是圆的》 &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;&nbsp;</span></p><p><span style="font-family:宋体;font-size:12px;">地理:《雾之都》《大堤与荷兰》</span></p></td></tr><tr><td style="width:99.0000pt;padding:0.0000pt 5.4000pt 0.0000pt 5.4000pt ;border-left:1.0000pt solid windowtext;border-right:1.0000pt solid windowtext;border-top:none;border-bottom:1.0000pt solid windowtext;" valign="center" width="23.869801084990957%"><p style="text-align:center;"><strong><span style="font-family:宋体;font-weight:bold;font-size:14px;">LEVEL 5</span></strong></p></td><td style="width: 315.8pt;padding: 0pt 5.4pt;border-left: none;border-right: 1pt solid windowtext;border-top: none;border-bottom: 1pt solid windowtext;vertical-align: top;" valign="top" width="76.13019891500905%"><p><span style="font-family:宋体;font-size:12px;">传统文化:《辣椒狂欢节》 &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;</span></p><p><span style="font-family:宋体;font-size:12px;">探险:《月球背面》《雪人的家乡》 &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;&nbsp;</span></p><p><span style="font-family:宋体;font-size:12px;">科学:《翡冷翠的微笑》《进化变奏曲》 &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;&nbsp;</span></p><p><span style="font-family:宋体;font-size:12px;">地理:《奔牛斗篷》《墨西哥狂欢节》《马里纳亚大海沟》</span></p></td></tr><tr><td style="width:99.0000pt;padding:0.0000pt 5.4000pt 0.0000pt 5.4000pt ;border-left:1.0000pt solid windowtext;border-right:1.0000pt solid windowtext;border-top:none;border-bottom:1.0000pt solid windowtext;" valign="center" width="23.869801084990957%"><p style="text-align:center;"><strong><span style="font-family:宋体;font-weight:bold;font-size:14px;">LEVEL 6</span></strong></p></td><td style="width: 315.8pt;padding: 0pt 5.4pt;border-left: none;border-right: 1pt solid windowtext;border-top: none;border-bottom: 1pt solid windowtext;vertical-align: top;" valign="top" width="76.13019891500905%"><p><span style="font-family:宋体;font-size:12px;">传统文化:《法厄同的启示》 &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;</span></p><p><span style="font-family:宋体;font-size:12px;">探险:《月下吉普赛》《消失的古城》 &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;&nbsp;</span></p><p><span style="font-family:宋体;font-size:12px;">科学:《斜塔上的铁球》《风筝与雷电》《不写神的神曲》 &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;</span></p><p><span style="font-family:宋体;font-size:12px;">地理:《雪落撒哈拉》《枫糖的由来》</span></p></td></tr></tbody></table><p><br></p><p><br></p><p style="text-align:left;"><strong><span style="font-family:宋体;font-weight:bold;font-size:14px;">PBL双语</span></strong><strong><span style="font-family:Calibri;font-weight:bold;font-size:14px;">教育戏剧</span></strong><strong><span style="font-family:宋体;font-weight:bold;font-size:14px;">VS常规</span></strong><strong><span style="font-family:Calibri;font-weight:bold;font-size:14px;">英语学习</span></strong></p><p><br></p><table border="1" cellspacing="0" style="border-collapse: collapse;border: none;width: 100%;"><tbody><tr><td style="width:207.4000pt;padding:0.0000pt 5.4000pt 0.0000pt 5.4000pt ;border-left:1.0000pt solid windowtext;border-right:1.0000pt solid windowtext;border-top:1.0000pt solid windowtext;border-bottom:1.0000pt solid windowtext;" valign="center" width="50%"><p style="text-align:center;"><strong><span style="font-family:宋体;font-weight:bold;font-size:14px;">常规英语学习</span></strong></p></td><td style="width:207.4000pt;padding:0.0000pt 5.4000pt 0.0000pt 5.4000pt ;border-left:none;border-right:1.0000pt solid windowtext;border-top:1.0000pt solid windowtext;border-bottom:1.0000pt solid windowtext;" valign="center" width="50%"><p style="text-align:center;"><strong><span style="font-family:宋体;font-weight:bold;font-size:14px;">PBL双语教育戏剧</span></strong></p></td></tr><tr><td style="width:207.4000pt;padding:0.0000pt 5.4000pt 0.0000pt 5.4000pt ;border-left:1.0000pt solid windowtext;border-right:1.0000pt solid windowtext;border-top:none;border-bottom:1.0000pt solid windowtext;" valign="center" width="50%"><p style="text-align:center;"><span style="font-family:宋体;font-size:14px;">老师</span><span style="font-family:Calibri;font-size:14px;">讲学生</span><span style="font-family:宋体;font-size:14px;">听，学习过程</span><span style="font-family:Calibri;font-size:14px;">枯燥乏味</span></p></td><td style="width:207.4000pt;padding:0.0000pt 5.4000pt 0.0000pt 5.4000pt ;border-left:none;border-right:1.0000pt solid windowtext;border-top:none;border-bottom:1.0000pt solid windowtext;" valign="center" width="50%"><p style="text-align:center;"><span style="font-family:宋体;font-size:14px;">与</span><span style="font-family:Calibri;font-size:14px;">老师一起&ldquo;</span><span style="font-family:宋体;font-size:14px;">玩</span><span style="font-family:Calibri;font-size:14px;">&rdquo;</span><span style="font-family:宋体;font-size:14px;">英语，学习过程</span><span style="font-family:Calibri;font-size:14px;">轻松有趣</span></p></td></tr><tr><td style="width:207.4000pt;padding:0.0000pt 5.4000pt 0.0000pt 5.4000pt ;border-left:1.0000pt solid windowtext;border-right:1.0000pt solid windowtext;border-top:none;border-bottom:1.0000pt solid windowtext;" valign="center" width="50%"><p style="text-align:center;"><span style="font-family:宋体;font-size:14px;">偏重应试英语，忽略</span><span style="font-family:Calibri;font-size:14px;">口语表达</span></p></td><td style="width:207.4000pt;padding:0.0000pt 5.4000pt 0.0000pt 5.4000pt ;border-left:none;border-right:1.0000pt solid windowtext;border-top:none;border-bottom:1.0000pt solid windowtext;" valign="center" width="50%"><p style="text-align:center;"><span style="font-family:宋体;font-size:14px;">兼顾</span><span style="font-family:Calibri;font-size:14px;">应试</span><span style="font-family:宋体;font-size:14px;">英语，重点锻炼</span><span style="font-family:Calibri;font-size:14px;">口语表达</span></p></td></tr><tr><td style="width:207.4000pt;padding:0.0000pt 5.4000pt 0.0000pt 5.4000pt ;border-left:1.0000pt solid windowtext;border-right:1.0000pt solid windowtext;border-top:none;border-bottom:1.0000pt solid windowtext;" valign="center" width="50%"><p style="text-align:center;"><span style="font-family:宋体;font-size:14px;">用中式</span><span style="font-family:Calibri;font-size:14px;">思维</span><span style="font-family:宋体;font-size:14px;">解决</span><span style="font-family:Calibri;font-size:14px;">问题</span></p></td><td style="width:207.4000pt;padding:0.0000pt 5.4000pt 0.0000pt 5.4000pt ;border-left:none;border-right:1.0000pt solid windowtext;border-top:none;border-bottom:1.0000pt solid windowtext;" valign="center" width="50%"><p style="text-align:center;"><span style="font-family:宋体;font-size:14px;">用英语思维解决</span><span style="font-family:Calibri;font-size:14px;">问题</span></p></td></tr><tr><td style="width:207.4000pt;padding:0.0000pt 5.4000pt 0.0000pt 5.4000pt ;border-left:1.0000pt solid windowtext;border-right:1.0000pt solid windowtext;border-top:none;border-bottom:1.0000pt solid windowtext;" valign="center" width="50%"><p style="text-align:center;"><span style="font-family:宋体;font-size:14px;">以固定</span><span style="font-family:Calibri;font-size:14px;">词汇量</span><span style="font-family:宋体;font-size:14px;">及</span><span style="font-family:Calibri;font-size:14px;">句式为</span><span style="font-family:宋体;font-size:14px;">学习</span><span style="font-family:Calibri;font-size:14px;">单元</span></p></td><td style="width:207.4000pt;padding:0.0000pt 5.4000pt 0.0000pt 5.4000pt ;border-left:none;border-right:1.0000pt solid windowtext;border-top:none;border-bottom:1.0000pt solid windowtext;" valign="center" width="50%"><p style="text-align:center;"><span style="font-family:宋体;font-size:14px;">以完整</span><span style="font-family:Calibri;font-size:14px;">的戏剧项目为学</span><span style="font-family:宋体;font-size:14px;">习</span><span style="font-family:Calibri;font-size:14px;">单元</span></p></td></tr><tr><td style="width:207.4000pt;padding:0.0000pt 5.4000pt 0.0000pt 5.4000pt ;border-left:1.0000pt solid windowtext;border-right:1.0000pt solid windowtext;border-top:none;border-bottom:1.0000pt solid windowtext;" valign="center" width="50%"><p style="text-align:center;"><span style="font-family:宋体;font-size:14px;">知识覆盖面</span><span style="font-family:Calibri;font-size:14px;">少，仅限书本内容</span></p></td><td style="width:207.4000pt;padding:0.0000pt 5.4000pt 0.0000pt 5.4000pt ;border-left:none;border-right:1.0000pt solid windowtext;border-top:none;border-bottom:1.0000pt solid windowtext;" valign="center" width="50%"><p style="text-align:center;"><span style="font-family:宋体;font-size:14px;">知识覆盖</span><span style="font-family:Calibri;font-size:14px;">面广，</span><span style="font-family:宋体;font-size:14px;">内容</span><span style="font-family:Calibri;font-size:14px;">包罗万象</span></p></td></tr><tr><td style="width:207.4000pt;padding:0.0000pt 5.4000pt 0.0000pt 5.4000pt ;border-left:1.0000pt solid windowtext;border-right:1.0000pt solid windowtext;border-top:none;border-bottom:1.0000pt solid windowtext;" valign="center" width="50%"><p style="text-align:center;"><strong><span style="font-family:宋体;font-weight:bold;font-size:14px;">&hellip;&hellip;</span></strong></p></td><td style="width:207.4000pt;padding:0.0000pt 5.4000pt 0.0000pt 5.4000pt ;border-left:none;border-right:1.0000pt solid windowtext;border-top:none;border-bottom:1.0000pt solid windowtext;" valign="center" width="50%"><p style="text-align:center;"><strong><span style="font-family:宋体;font-weight:bold;font-size:14px;">&hellip;&hellip;</span></strong></p></td></tr></tbody></table><p><br></p><p><br></p><p><strong><span style="font-family:Calibri;font-weight:bold;font-size:14px;">强化</span></strong><strong><span style="font-family:宋体;font-weight:bold;font-size:14px;">英语</span></strong><strong><span style="font-family:Calibri;font-weight:bold;font-size:14px;">技能</span></strong><strong><span style="font-family:宋体;font-weight:bold;font-size:14px;">，</span></strong><strong><span style="font-family:Calibri;font-weight:bold;font-size:14px;">提升综合素质</span></strong></p><p><br></p><p><strong><span style="font-family:宋体;font-weight:bold;font-size:14px;">全英戏剧</span></strong><strong><span style="font-family:Calibri;font-weight:bold;font-size:14px;">环境</span></strong></p><p><span style="font-family:宋体;font-size:14px;">提供</span><span style="font-family:Calibri;font-size:14px;">全</span><span style="font-family:宋体;font-size:14px;">英语</span><span style="font-family:Calibri;font-size:14px;">戏剧</span><span style="font-family:宋体;font-size:14px;">项目</span><span style="font-family:Calibri;font-size:14px;">工作环境，</span><span style="font-family:宋体;font-size:14px;">锻炼</span><span style="font-family:Calibri;font-size:14px;">多种</span><span style="font-family:宋体;font-size:14px;">工作</span><span style="font-family:Calibri;font-size:14px;">场景</span><span style="font-family:宋体;font-size:14px;">英文</span><span style="font-family:Calibri;font-size:14px;">沟通能力</span><span style="font-family:宋体;font-size:14px;">。</span></p><p><img src="https://www.maiguanjy.com/storage/2019-11-18/aACK2J9SxAYeIfn639s8eNBSIYQGGh4soy96MNmH.jpeg" style="width: 300px;" class="fr-fic fr-dib"></p><p><br></p><p><strong><span style="font-family:宋体;font-weight:bold;font-size:14px;">激发学习兴趣</span></strong></p><p><span style="font-family:宋体;font-size:14px;">多元的文化、探索、科普等主题戏剧内容，激发英语学习兴趣。</span></p><p><img src="https://www.maiguanjy.com/storage/2019-11-18/m6tAV6E9dMxUln9l1WzfKRGfAQdmgWk6Qqa9rIsa.jpeg" style="width: 300px;" class="fr-fic fr-dib"></p><p><br></p><p><strong><span style="font-family:宋体;font-weight:bold;font-size:14px;">培养英式</span></strong><strong><span style="font-family:Calibri;font-weight:bold;font-size:14px;">思维</span></strong></p><p><span style="font-family:宋体;font-size:14px;">长期用</span><span style="font-family:Calibri;font-size:14px;">戏剧的方式学英语</span><span style="font-family:宋体;font-size:14px;">能</span><span style="font-family:Calibri;font-size:14px;">锻炼英语思维，</span><span style="font-family:宋体;font-size:14px;">帮助孩子改正</span><span style="font-family:Calibri;font-size:14px;">用中</span><span style="font-family:宋体;font-size:14px;">文</span><span style="font-family:Calibri;font-size:14px;">逻辑</span><span style="font-family:宋体;font-size:14px;">思考英语问题</span><span style="font-family:Calibri;font-size:14px;">的</span><span style="font-family:宋体;font-size:14px;">错误模式</span><span style="font-family:Calibri;font-size:14px;">。</span></p><p><span style="font-family:Calibri;font-size:14px;"><img src="https://www.maiguanjy.com/storage/2019-11-18/0bSP6t23dE7ZC7WUARaj1hAplqax6XozmZR8TkPM.jpeg" style="width: 300px;" class="fr-fic fr-dib"></span></p><p><strong><span style="font-family:宋体;font-weight:bold;font-size:14px;">规范纯正</span></strong><strong><span style="font-family:Calibri;font-weight:bold;font-size:14px;">英音</span></strong></p><p><span style="font-family:宋体;font-size:14px;">强化</span><span style="font-family:Calibri;font-size:14px;">听力</span><span style="font-family:宋体;font-size:14px;">及</span><span style="font-family:Calibri;font-size:14px;">口语表达，</span><span style="font-family:宋体;font-size:14px;">规范纯正英语</span><span style="font-family:Calibri;font-size:14px;">发音，</span><span style="font-family:宋体;font-size:14px;">学习</span><span style="font-family:Calibri;font-size:14px;">地道俚语</span><span style="font-family:宋体;font-size:14px;">。</span></p><p><img src="https://www.maiguanjy.com/storage/2019-11-18/QRYmxE5EBPhQCLoeZVuN3qRleqaCemWwRAQrdi4a.jpeg" style="width: 300px;" class="fr-fic fr-dib"></p><p><br></p><p><br></p><p><strong><span style="font-family:宋体;font-weight:bold;font-size:14px;">在应用场景中练习</span></strong></p><p><span style="font-family:宋体;font-size:14px;">为常规英语教育提供应用场景，反复练习，巩固学习效果。</span></p><p><br></p><p><img src="https://www.maiguanjy.com/storage/2019-11-18/dgLDD5Hy0zYGspfIFvSOdRx34jynNRPTqiwYAzKt.jpeg" style="width: 300px;" class="fr-fic fr-dib"></p><p><br></p><p><br></p><p><strong><span style="font-family:宋体;font-weight:bold;font-size:14px;">英语</span></strong><strong><span style="font-family:Calibri;font-weight:bold;font-size:14px;">学习贯穿始终</span></strong></p><p><span style="font-family:宋体;font-size:14px;">除了</span><span style="font-family:Calibri;font-size:14px;">英语台词</span><span style="font-family:宋体;font-size:14px;">之外</span><span style="font-family:Calibri;font-size:14px;">，在造型设计、道具制作等环节都</span><span style="font-family:宋体;font-size:14px;">能</span><span style="font-family:Calibri;font-size:14px;">学到新的英语词汇</span><span style="font-family:宋体;font-size:14px;">。</span></p><p><img src="https://www.maiguanjy.com/storage/2019-11-18/6urk91JD6PSWCa5DcP7HBLZ3YiMSirLq2hwX2nMk.jpeg" style="width: 300px;" class="fr-fic fr-dib"></p><p><br></p><p><strong><span style="font-family:宋体;font-weight:bold;font-size:14px;">丰富沟通</span></strong><strong><span style="font-family:Calibri;font-weight:bold;font-size:14px;">与表达</span></strong></p><p><span style="font-family:宋体;font-size:14px;">在多元场景中学习特定词汇及对话，增加</span><span style="font-family:Calibri;font-size:14px;">词汇量，</span><span style="font-family:宋体;font-size:14px;">丰富英文沟通与表达。</span></p><p><img src="https://www.maiguanjy.com/storage/2019-11-18/nTZRzJfXSkifsxlFXeHpkXleSV6lVxcRZdMy1C6B.jpeg" style="width: 300px;" class="fr-fic fr-dib"></p><p><br></p><p style="text-align:left;"><strong><span style="font-family:宋体;font-weight:bold;font-size:14px;">提升</span></strong><strong><span style="font-family:Calibri;font-weight:bold;font-size:14px;">综合</span></strong><strong><span style="font-family:宋体;font-weight:bold;font-size:14px;">素质</span></strong></p><p style="text-align:left;"><span style="font-family:宋体;font-size:14px;">在</span><span style="font-family:Calibri;font-size:14px;">戏剧</span><span style="font-family:宋体;font-size:14px;">项目</span><span style="font-family:Calibri;font-size:14px;">中</span><span style="font-family:宋体;font-size:14px;">完成</span><span style="font-family:Calibri;font-size:14px;">形象设计及道具制作，</span><span style="font-family:宋体;font-size:14px;">正向</span><span style="font-family:Calibri;font-size:14px;">强化孩子的动手动脑、</span><span style="font-family:宋体;font-size:14px;">想象力</span><span style="font-family:Calibri;font-size:14px;">、团队协作、</span><span style="font-family:宋体;font-size:14px;">美学</span><span style="font-family:Calibri;font-size:14px;">素养等综合能力</span><span style="font-family:宋体;font-size:14px;">。</span></p><p><br></p><p><img src="https://www.maiguanjy.com/storage/2019-11-18/maD1I7Judqk3loq4xcOaypy1DdscNnUOVoxYATqv.jpeg" style="width: 300px;" class="fr-fic fr-dib"></p><p><strong><span style="font-family:Calibri;font-weight:bold;font-size:14px;"></span></strong><br></p><p data-f-id="pbf" style="text-align: center; font-size: 14px; margin-top: 30px; opacity: 0.65; font-family: sans-serif;">Powered by <a href="https://www.froala.com/wysiwyg-editor?pb=1" title="Froala Editor">Froala Editor</a></p>
         * description : 玩着学英语，培养孩子适应未来社会的必要能力
         * cover_pic : storage/2019-11-15/weXYgTWlLDpMoQ6dlhCVgx9iTdSL3CTSt7ckRcoo.jpeg
         * detail_pic : storage/2019-11-15/CQuo01yFMJy2u7BbgRgWI68RbwO6AOl4cY0nB7ab.jpeg
         * distribution_ratio1 : null
         * distribution_ratio2 : null
         * distribution_ratio3 : null
         * click_rate : null
         * sort : 1
         * status : 0
         * createDt : 2019-11-18 16:46:18
         * updateDt : 2019-11-18 16:46:18
         * stars : 0
         * discount : 0
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
