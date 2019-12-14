package com.example.xpaly.com.xpaly.pojo;

/**
 * @创建者 tw
 * @创建时间 2019/12/14
 * @描述
 */
public class SearchResultBean {

    private String movieName;
    private String moviewUrl;

    public SearchResultBean(String movieName, String moviewUrl) {
        this.movieName = movieName;
        this.moviewUrl = moviewUrl;
    }

    public SearchResultBean() {
    }

    public String getMovieName() {
        return movieName;
    }

    public void setMovieName(String movieName) {
        this.movieName = movieName;
    }

    public String getMoviewUrl() {
        return moviewUrl;
    }

    public void setMoviewUrl(String moviewUrl) {
        this.moviewUrl = moviewUrl;
    }
}
