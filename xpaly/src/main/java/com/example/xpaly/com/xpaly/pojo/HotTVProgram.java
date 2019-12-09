package com.example.xpaly.com.xpaly.pojo;

import java.util.List;

/**
 * @创建者 tw
 * @创建时间 2019/12/7
 * @描述
 */
public class HotTVProgram {

    private List<DataBean> data;

    public List<DataBean> getData() {
        return data;
    }

    public void setData(List<DataBean> data) {
        this.data = data;
    }

    public static class DataBean {
        /**
         * directors : ["孙皓","温若寒","高寒"]
         * rate : 8.0
         * cover_x : 5675
         * star : 40
         * title : 庆余年
         * url : https://movie.douban.com/subject/25853071/
         * casts : ["张若昀","李沁","陈道明","吴刚","李小冉"]
         * cover : https://img1.doubanio.com/view/photo/s_ratio_poster/public/p2575362797.webp
         * id : 25853071
         * cover_y : 8000
         */

        private String rate;
        private int cover_x;
        private String star;
        private String title;
        private String url;
        private String cover;
        private String id;
        private int cover_y;
        private List<String> directors;
        private List<String> casts;

        public String getRate() {
            return rate;
        }

        public void setRate(String rate) {
            this.rate = rate;
        }

        public int getCover_x() {
            return cover_x;
        }

        public void setCover_x(int cover_x) {
            this.cover_x = cover_x;
        }

        public String getStar() {
            return star;
        }

        public void setStar(String star) {
            this.star = star;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }

        public String getCover() {
            return cover;
        }

        public void setCover(String cover) {
            this.cover = cover;
        }

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public int getCover_y() {
            return cover_y;
        }

        public void setCover_y(int cover_y) {
            this.cover_y = cover_y;
        }

        public List<String> getDirectors() {
            return directors;
        }

        public void setDirectors(List<String> directors) {
            this.directors = directors;
        }

        public List<String> getCasts() {
            return casts;
        }

        public void setCasts(List<String> casts) {
            this.casts = casts;
        }
    }
}
