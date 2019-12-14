package com.example.xpaly.com.xpaly.pojo;

/**
 * @创建者 tw
 * @创建时间 2019/12/12
 * @描述
 */
public class PianDianDetailsUrlJson {
    private String id;
    private int offset;
    private int limit;
    private int type;
    private String passwd;

    public PianDianDetailsUrlJson(String id, int offset, int limit, int type, String passwd) {
        this.id = id;
        this.offset = offset;
        this.limit = limit;
        this.type = type;
        this.passwd = passwd;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getOffset() {
        return offset;
    }

    public void setOffset(int offset) {
        this.offset = offset;
    }

    public int getLimit() {
        return limit;
    }

    public void setLimit(int limit) {
        this.limit = limit;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public String getPasswd() {
        return passwd;
    }

    public void setPasswd(String passwd) {
        this.passwd = passwd;
    }

    @Override
    public String toString() {
        return "{" +
                "\"id\":\"" + id + "\"" +
                ",\"offset\":" + offset +
                ",\"limit\":" + limit +
                ",\"type\":" + type +
                ",\"passwd\":\"" + passwd + "\"" +
                '}';
    }
}
