package com.example.xpaly.com.xpaly.pojo;

import java.util.List;

/**
 * @创建者 tw
 * @创建时间 2019/12/8
 * @描述
 */
public class HotAnimeBean {

    private List<DataBean> data;

    public List<DataBean> getData() {
        return data;
    }

    public void setData(List<DataBean> data) {
        this.data = data;
    }

    public static class DataBean {
        /**
         * directors : ["贾斯汀·罗兰"]
         * rate : 9.7
         * cover_x : 564
         * star : 50
         * title : 瑞克和莫蒂 第一季
         * url : https://movie.douban.com/subject/11537954/
         * casts : ["贾斯汀·罗兰","汤姆·肯尼","克里斯·帕内尔","斯宾瑟·格拉默","萨拉·乔克"]
         * cover : https://img9.doubanio.com/view/photo/s_ratio_poster/public/p2168567316.webp
         * id : 11537954
         * cover_y : 810
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
