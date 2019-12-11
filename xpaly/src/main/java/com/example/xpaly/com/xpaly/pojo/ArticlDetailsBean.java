package com.example.xpaly.com.xpaly.pojo;

/**
 * @创建者 tw
 * @创建时间 2019/12/11
 * @描述 文章详情 <p></p><img></img>
 */
public class ArticlDetailsBean {
    public static int TYPE_CENTENCE = 1; //tag=1 类型为句子
    public static int TYPE_IMAGE = 2; //tag=2 类型为图片
    private String word;//可以是文字也可以使image的url
    private int tag;

    public ArticlDetailsBean(String word, int tag) {
        this.word = word;
        this.tag = tag;
    }

    public ArticlDetailsBean() {

    }

    public String getWord() {
        return word;
    }

    public void setWord(String word) {
        this.word = word;
    }

    public int getTag() {
        return tag;
    }

    public void setTag(int tag) {
        this.tag = tag;
    }
}
