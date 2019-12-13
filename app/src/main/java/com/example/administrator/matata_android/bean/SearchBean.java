package com.example.administrator.matata_android.bean;

import java.io.Serializable;
import java.util.List;

public class SearchBean implements Serializable {

    private List<AllBean> all;
    private List<TeacherBean> teacher;
    private List<CourseBean> course;

    public List<CourseBean> getCourse() {
        return course;
    }

    public void setCourse(List<CourseBean> course) {
        this.course = course;
    }

    private List<CampsiteBean> campsite;

    public List<AllBean> getAll() {
        return all;
    }

    public void setAll(List<AllBean> all) {
        this.all = all;
    }

    public List<TeacherBean> getTeacher() {
        return teacher;
    }

    public void setTeacher(List<TeacherBean> teacher) {
        this.teacher = teacher;
    }



    public List<CampsiteBean> getCampsite() {
        return campsite;
    }

    public void setCampsite(List<CampsiteBean> campsite) {
        this.campsite = campsite;
    }

    public static class AllBean {
        /**
         * id : 79
         * name : 王向飞
         * img : 201805/6014a85008294630a415dacccac7c658.jpeg
         * description : 音乐教育老师

         国际打击乐教育协会会员

         古典吉他考级教材编委
         * type : teacher
         */

        private int id;
        private String name;
        private String img;
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

        public String getImg() {
            return img;
        }

        public void setImg(String img) {
            this.img = img;
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

    public static class TeacherBean {
        /**
         * id : 79
         * name : 王向飞
         * img : 201805/6014a85008294630a415dacccac7c658.jpeg
         * description : 音乐教育老师

         国际打击乐教育协会会员

         古典吉他考级教材编委
         * type : teacher
         */

        private int id;
        private String name;
        private String img;
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

        public String getImg() {
            return img;
        }

        public void setImg(String img) {
            this.img = img;
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
    public static class CourseBean {
        /**
         * id : 12
         * name : 泰国清迈PBL戏剧游学|来这里，开启微笑王国奇遇记
         * img : storage/2019-12-13/iI59vkJdH995OBzD6qSKWjBgTVSwXZ6Heqo1amcX.jpeg
         * description : 快来泰国清迈PLB戏剧游学，开启微笑王国奇遇记吧！
         * type : campsite
         */

        private int id;
        private String name;
        private String img;
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

        public String getImg() {
            return img;
        }

        public void setImg(String img) {
            this.img = img;
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
    public static class CampsiteBean {
        /**
         * id : 12
         * name : 泰国清迈PBL戏剧游学|来这里，开启微笑王国奇遇记
         * img : storage/2019-12-13/iI59vkJdH995OBzD6qSKWjBgTVSwXZ6Heqo1amcX.jpeg
         * description : 快来泰国清迈PLB戏剧游学，开启微笑王国奇遇记吧！
         * type : campsite
         */

        private int id;
        private String name;
        private String img;
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

        public String getImg() {
            return img;
        }

        public void setImg(String img) {
            this.img = img;
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
}
