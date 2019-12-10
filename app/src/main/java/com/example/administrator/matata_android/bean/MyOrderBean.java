package com.example.administrator.matata_android.bean;

import java.io.Serializable;
import java.util.List;

public class MyOrderBean implements Serializable {


    private List<AllBean> all;
    private List<FinishedBean> finished;
    private List<UnfinishedBean> unfinished;
    private List<EvalBean> eval;

    public List<AllBean> getAll() {
        return all;
    }

    public void setAll(List<AllBean> all) {
        this.all = all;
    }

    public List<FinishedBean> getFinished() {
        return finished;
    }

    public void setFinished(List<FinishedBean> finished) {
        this.finished = finished;
    }

    public List<UnfinishedBean> getUnfinished() {
        return unfinished;
    }

    public void setUnfinished(List<UnfinishedBean> unfinished) {
        this.unfinished = unfinished;
    }

    public List<EvalBean> getEval() {
        return eval;
    }

    public void setEval(List<EvalBean> eval) {
        this.eval = eval;
    }

    public static class AllBean {
        /**
         * id : 51
         * order_id : 100000504
         * name : 测试
         * image : 201905/a39a3db2a960499980a160ff1bef50ce.jpeg
         * description : 一个
         * price : 10
         * status : 0
         * type : online
         * eval : 1
         * time : 1575945747
         */

        private int id;
        private int order_id;
        private String name;
        private String image;
        private String description;
        private int price;
        private String status;
        private String type;
        private String eval;
        private int time;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public int getOrder_id() {
            return order_id;
        }

        public void setOrder_id(int order_id) {
            this.order_id = order_id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getImage() {
            return image;
        }

        public void setImage(String image) {
            this.image = image;
        }

        public String getDescription() {
            return description;
        }

        public void setDescription(String description) {
            this.description = description;
        }

        public int getPrice() {
            return price;
        }

        public void setPrice(int price) {
            this.price = price;
        }

        public String getStatus() {
            return status;
        }

        public void setStatus(String status) {
            this.status = status;
        }

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }

        public String getEval() {
            return eval;
        }

        public void setEval(String eval) {
            this.eval = eval;
        }

        public int getTime() {
            return time;
        }

        public void setTime(int time) {
            this.time = time;
        }
    }

    public static class FinishedBean {
        /**
         * id : 27
         * order_id : 100000516
         * name : <手碟> ：从普通人到男神/女神的进阶之路
         * image : storage/2019-06-13/XQM8n7GxJKWwO95OjGk7f9GSvslBVg7xFZ8u12Yi.jpeg
         * description : 珍藏级手碟教程，由国内顶尖手碟演奏者小小老师主讲，干货满满、制作精良，伴你快速入门！
         * price : 1
         * status : 1
         * type : online
         * eval : 0
         * time : 1575950223
         */

        private int id;
        private int order_id;
        private String name;
        private String image;
        private String description;
        private int price;
        private String status;
        private String type;
        private String eval;
        private int time;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public int getOrder_id() {
            return order_id;
        }

        public void setOrder_id(int order_id) {
            this.order_id = order_id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getImage() {
            return image;
        }

        public void setImage(String image) {
            this.image = image;
        }

        public String getDescription() {
            return description;
        }

        public void setDescription(String description) {
            this.description = description;
        }

        public int getPrice() {
            return price;
        }

        public void setPrice(int price) {
            this.price = price;
        }

        public String getStatus() {
            return status;
        }

        public void setStatus(String status) {
            this.status = status;
        }

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }

        public String getEval() {
            return eval;
        }

        public void setEval(String eval) {
            this.eval = eval;
        }

        public int getTime() {
            return time;
        }

        public void setTime(int time) {
            this.time = time;
        }
    }

    public static class UnfinishedBean {
        /**
         * id : 51
         * order_id : 100000504
         * name : 测试
         * image : 201905/a39a3db2a960499980a160ff1bef50ce.jpeg
         * description : 一个
         * price : 10
         * status : 0
         * type : online
         * eval : 1
         * time : 1575945747
         */

        private int id;
        private int order_id;
        private String name;
        private String image;
        private String description;
        private int price;
        private String status;
        private String type;
        private String eval;
        private int time;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public int getOrder_id() {
            return order_id;
        }

        public void setOrder_id(int order_id) {
            this.order_id = order_id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getImage() {
            return image;
        }

        public void setImage(String image) {
            this.image = image;
        }

        public String getDescription() {
            return description;
        }

        public void setDescription(String description) {
            this.description = description;
        }

        public int getPrice() {
            return price;
        }

        public void setPrice(int price) {
            this.price = price;
        }

        public String getStatus() {
            return status;
        }

        public void setStatus(String status) {
            this.status = status;
        }

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }

        public String getEval() {
            return eval;
        }

        public void setEval(String eval) {
            this.eval = eval;
        }

        public int getTime() {
            return time;
        }

        public void setTime(int time) {
            this.time = time;
        }
    }

    public static class EvalBean {
        /**
         * id : 27
         * order_id : 100000516
         * name : <手碟> ：从普通人到男神/女神的进阶之路
         * image : storage/2019-06-13/XQM8n7GxJKWwO95OjGk7f9GSvslBVg7xFZ8u12Yi.jpeg
         * description : 珍藏级手碟教程，由国内顶尖手碟演奏者小小老师主讲，干货满满、制作精良，伴你快速入门！
         * price : 1
         * status : 1
         * type : online
         * eval : 0
         * time : 1575950223
         */

        private int id;
        private int order_id;
        private String name;
        private String image;
        private String description;
        private int price;
        private String status;
        private String type;
        private String eval;
        private int time;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public int getOrder_id() {
            return order_id;
        }

        public void setOrder_id(int order_id) {
            this.order_id = order_id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getImage() {
            return image;
        }

        public void setImage(String image) {
            this.image = image;
        }

        public String getDescription() {
            return description;
        }

        public void setDescription(String description) {
            this.description = description;
        }

        public int getPrice() {
            return price;
        }

        public void setPrice(int price) {
            this.price = price;
        }

        public String getStatus() {
            return status;
        }

        public void setStatus(String status) {
            this.status = status;
        }

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }

        public String getEval() {
            return eval;
        }

        public void setEval(String eval) {
            this.eval = eval;
        }

        public int getTime() {
            return time;
        }

        public void setTime(int time) {
            this.time = time;
        }
    }
}
