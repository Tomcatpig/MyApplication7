package com.example.xpaly.com.xpaly.utils;

import android.util.Log;

import com.example.xpaly.com.xpaly.pojo.ArticlDetailsBean;

import java.io.UnsupportedEncodingException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

/**
 * @创建者 tw
 * @创建时间 2019/11/17
 * @描述
 */
public class MStringUtils {
    public static String getStringBeingToEnd(String beingIndex, String endIndex, String str) {
        String string;
        char[] arrays = new char[str.length()];
        int being = str.indexOf(beingIndex);
        int end = str.indexOf(endIndex);
        str.getChars(being + 1, end, arrays, 0);
        string = String.valueOf(arrays);
        return string.trim();
    }

    public static String reEncoding(String text, String newEncoding) {
        String str = null;
        try {
            str = new String(text.getBytes(), newEncoding);
        } catch (UnsupportedEncodingException e) {
            Log.e("不支持的字符编码", "" + newEncoding);
            throw new RuntimeException(e);
        }
        return str;
    }

    public static String getUserName(String str) {
        String userName = "未知";
        int end = str.indexOf("-");
        if (end == -1) {
            return userName;
        } else {
            return str.substring(0, end).trim();
        }

    }

    public static String getMusicName(String str) {

        int start = str.indexOf("-");
        int end = str.lastIndexOf(".");
        if (start == -1) {
            return str.substring(0, end - 1).trim();
        } else {
            return str.substring(start + 1, end).trim();
        }

    }

    public static String dateFormat(int flag, long time) {
        String date = "null";
        if (flag == 1) {
            SimpleDateFormat sDateFormat = new SimpleDateFormat("yyyy-MM-dd");
            date = sDateFormat.format(time);
        }
        return date;
    }

    public static List<ArticlDetailsBean> getArticlDetails(String html) {
        List<ArticlDetailsBean> articlDetailsBeanList = new ArrayList<>();
      //  List<String> stringList = new ArrayList<String>();
        String[] strings = html.split("</p>");

        for (int z = 0; z < strings.length; z++) {

            if (strings[z].contains("img")) {

                int endIndex = strings[z].lastIndexOf(">") + 1;
                //System.out.println(endIndex);
                String string2 = strings[z].substring(0, endIndex);

                //System.out.println(strings[z].substring(endIndex));
             //   stringList.add(strings[z].substring(endIndex));

                ArticlDetailsBean articlDetailsBean = new ArticlDetailsBean(strings[z].substring(endIndex), 1);
                articlDetailsBeanList.add(articlDetailsBean);


                String[] string2List = string2.split("src=\"");

                for (String stringHttp : string2List) {

                    if (!stringHttp.contains("img")) {

                        int endIndex2 = stringHttp.indexOf("\"");

                        //System.out.println(stringHttp);

                        //System.out.println(stringHttp.substring(0, endIndex2));

                     //   stringList.add(stringHttp.substring(0, endIndex2));
                        ArticlDetailsBean articlDetailsBean2 = new ArticlDetailsBean(stringHttp.substring(0, endIndex2), 2);
                        articlDetailsBeanList.add(articlDetailsBean2);

                    }

                }

            } else {

                int endIndex = strings[z].lastIndexOf(">") + 1;

                //System.out.println(strings[z].substring(endIndex));
            //    stringList.add(strings[z].substring(endIndex));
                ArticlDetailsBean articlDetailsBean = new ArticlDetailsBean(strings[z].substring(endIndex), 1);
                articlDetailsBeanList.add(articlDetailsBean);
            }

            //System.out.println(strings[z]);

        }
        return articlDetailsBeanList;


    }
}
