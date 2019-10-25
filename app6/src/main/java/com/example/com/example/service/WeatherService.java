package com.example.com.example.service;

import android.util.Xml;

import com.example.info.WeatherInfo;

import org.xmlpull.v1.XmlPullParser;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

public class WeatherService {

    public static List<WeatherInfo> getWeatherInfos(InputStream inputStream) throws Exception {
        //创建pull解析器
        XmlPullParser parser = Xml.newPullParser();
        //初始化解析器
        parser.setInput(inputStream, "utf-8");
        List<WeatherInfo> weatherInfoList = null;
        WeatherInfo weatherInfo = null;
        //得到当前事件的类型
        int type = parser.getEventType();

        while (type != XmlPullParser.END_DOCUMENT) {
            switch (type) {
                //节点的开始
                case XmlPullParser.START_TAG:
                    if ("resources".equals(parser.getName())) {
                        weatherInfoList = new ArrayList<>();
                    } else if ("city".equals(parser.getName())) {
                        weatherInfo = new WeatherInfo();
                        String idStr = parser.getAttributeValue(0);
                        weatherInfo.setId(Integer.parseInt(idStr));

                    } else if ("temp".equals(parser.getName())) {
                        String temp = parser.nextText();
                        weatherInfo.setTemp(temp);

                    } else if ("weather".equals(parser.getName())) {
                        String weather = parser.nextText();
                        weatherInfo.setWeather(weather);

                    } else if ("name".equals(parser.getName())){
                        String name = parser.nextText();
                        weatherInfo.setName(name);

                    }else if ("pm".equals(parser.getName())){
                        String pm = parser.nextText();
                        weatherInfo.setPm(pm);

                    }else if ("wind".equals(parser.getName())){
                        String wind = parser.nextText();
                        weatherInfo.setWind(wind);
                    }
                    break;
                    //一个节点标签结束
                case XmlPullParser.END_TAG:
                    //一个城市的信息读取完
                    if ("city".equals(parser.getName())){
                        weatherInfoList.add(weatherInfo);
                        weatherInfo = null;

                }
                    break;
            }
            type = parser.next();
        }
        return weatherInfoList;
    }
}
