package com.example.xpaly.com.xpaly.pojo;

import java.util.List;

/**
 * @创建者 tw
 * @创建时间 2019/12/8
 * @描述  首页推荐电影数据
 */
public class HotMovieBean {


    private List<DataBean> data;

    public List<DataBean> getData() {
        return data;
    }

    public void setData(List<DataBean> data) {
        this.data = data;
    }

    public static class DataBean {
        /**
         * directors : ["莱恩·约翰逊"]
         * rate : 8.3
         * cover_x : 1685
         * star : 40
         * title : 利刃出鞘
         * url : https://movie.douban.com/subject/30318116/
         * casts : ["丹尼尔·克雷格","安娜·德·阿玛斯","克里斯·埃文斯","杰米·李·柯蒂斯","托妮·科莱特"]
         * cover : https://img1.doubanio.com/view/photo/s_ratio_poster/public/p2574172427.webp
         * id : 30318116
         * cover_y : 2500
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
