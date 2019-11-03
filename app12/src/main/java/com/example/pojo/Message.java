package com.example.pojo;

/**
 * @创建者 tw
 * @创建时间 2019/11/1
 * @描述
 */

public class Message {
private  String body;
private  String address;
private  long date;
private  int type;
private  int id;

    public Message() {

    }

    public Message(String body, String address, long date, int type, int id) {
        this.body = body;
        this.address = address;
        this.date = date;
        this.type = type;
        this.id = id;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public long getDate() {
        return date;
    }

    public void setDate(long date) {
        this.date = date;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Message{" +
                "body='" + body + '\'' +
                ", address='" + address + '\'' +
                ", date=" + date +
                ", type=" + type +
                ", id=" + id +
                '}';
    }
}
