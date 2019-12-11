package com.example.xpaly.com.xpaly.utils;
import com.example.xpaly.com.xpaly.pojo.ArticlDetailsBean;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlPullParserFactory;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.List;

public class Analysisbypull {
    public static List<ArticlDetailsBean> Receive(String response){
        List<ArticlDetailsBean> articlDetailsBeanList = new ArrayList<>();
        try {
            //获取XmlPullParserFactory实例
            XmlPullParserFactory factory = XmlPullParserFactory.newInstance();
            //通过XmlPullParserFactory实例获取XmlPullParser对象
            XmlPullParser xmlPullParser = factory.newPullParser();
            //调用XmlPullParser的setInput方法将XML数据放置进去
            InputStream is = new ByteArrayInputStream(response.getBytes());
            xmlPullParser.setInput(is, "utf-8");
            //得到当前解析事件
            int eventType = xmlPullParser.getEventType();

            //如果eventType=XmlPullParser.END_DOCUMENT则表示解析完成
            while (eventType!=XmlPullParser.END_DOCUMENT){
                //获取节点的名称
                String nodeName = xmlPullParser.getName();
                switch (eventType){
                    case XmlPullParser.START_TAG:{
                        if("div".equals(nodeName)){

                        }
                        else if("p".equals(nodeName)){
                            ArticlDetailsBean articlDetailsBean =new ArticlDetailsBean();

                            try {
                                if (xmlPullParser.nextText()!=null||!xmlPullParser.nextText().contains("<p>")){
                                    articlDetailsBean.setWord(xmlPullParser.nextText());
                                    articlDetailsBean.setTag(ArticlDetailsBean.TYPE_CENTENCE);
                                    articlDetailsBeanList.add(articlDetailsBean);

                                }

                            } catch (Exception e) {
                                e.printStackTrace();
                            }
                        }
                        break;
                    }
                    case XmlPullParser.END_TAG:
                        break;
                }
                try {
                    eventType=xmlPullParser.next();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        } catch (XmlPullParserException e) {
            e.printStackTrace();
        }
        return articlDetailsBeanList;
    }
}
