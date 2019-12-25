package com.example.connect.com.example.pojo;

import java.util.ArrayList;
import java.util.List;

/**
 * @创建者 tw
 * @创建时间 2019/12/25
 * @描述
 */
public class UserLink {
    private String userName;
    private List<String> userNumber = new ArrayList<>();

    public UserLink(String userName, List<String> userNumber) {
        this.userName = userName;
        this.userNumber = userNumber;
    }

    public UserLink() {
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public List<String> getUserNumber() {
        return userNumber;
    }

    public void setUserNumber(List<String> userNumber) {
        this.userNumber = userNumber;
    }
}
