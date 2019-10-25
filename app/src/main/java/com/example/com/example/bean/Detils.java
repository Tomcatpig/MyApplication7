package com.example.com.example.bean;

import java.util.List;

public class Detils {

    private List<ResultBean> result;

    public List<ResultBean> getResult() {
        return result;
    }

    public void setResult(List<ResultBean> result) {
        this.result = result;
    }

    public static class ResultBean {
        /**
         * entity_id : 64
         * course_name : Java入门第一季
         * description : Java是一种可以撰写跨平台应用程序的面向对象的程序设计语言。Java 技术具有卓越的通用性、高效性、平台移植性和安全性，广泛应用于PC、数据中心、游戏控制台、科学超级计算机、移动电话和互联网，同时拥有全球最大的开发者专业社群。
         * main_teacher : 根号申
         * teacher_level : 金牌讲师
         * study_num : 10740
         * isRecommend : 2
         * course_level : 0
         * cover : https://www.mingrisoft.com/Public/uploads/course_cover/5865ac73bdc70.png
         * class_hour : 10小时9分15秒
         * cate_name : Java
         * course_type : 1
         */

        private String entity_id;
        private String course_name;
        private String description;
        private String main_teacher;
        private String teacher_level;
        private String study_num;
        private String isRecommend;
        private String course_level;
        private String cover;
        private String class_hour;
        private String cate_name;
        private String course_type;

        public String getEntity_id() {
            return entity_id;
        }

        public void setEntity_id(String entity_id) {
            this.entity_id = entity_id;
        }

        public String getCourse_name() {
            return course_name;
        }

        public void setCourse_name(String course_name) {
            this.course_name = course_name;
        }

        public String getDescription() {
            return description;
        }

        public void setDescription(String description) {
            this.description = description;
        }

        public String getMain_teacher() {
            return main_teacher;
        }

        public void setMain_teacher(String main_teacher) {
            this.main_teacher = main_teacher;
        }

        public String getTeacher_level() {
            return teacher_level;
        }

        public void setTeacher_level(String teacher_level) {
            this.teacher_level = teacher_level;
        }

        public String getStudy_num() {
            return study_num;
        }

        public void setStudy_num(String study_num) {
            this.study_num = study_num;
        }

        public String getIsRecommend() {
            return isRecommend;
        }

        public void setIsRecommend(String isRecommend) {
            this.isRecommend = isRecommend;
        }

        public String getCourse_level() {
            return course_level;
        }

        public void setCourse_level(String course_level) {
            this.course_level = course_level;
        }

        public String getCover() {
            return cover;
        }

        public void setCover(String cover) {
            this.cover = cover;
        }

        public String getClass_hour() {
            return class_hour;
        }

        public void setClass_hour(String class_hour) {
            this.class_hour = class_hour;
        }

        public String getCate_name() {
            return cate_name;
        }

        public void setCate_name(String cate_name) {
            this.cate_name = cate_name;
        }

        public String getCourse_type() {
            return course_type;
        }

        public void setCourse_type(String course_type) {
            this.course_type = course_type;
        }
    }
}
