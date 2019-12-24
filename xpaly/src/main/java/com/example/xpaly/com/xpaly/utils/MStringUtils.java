package com.example.xpaly.com.xpaly.utils;

import android.util.Log;

import com.example.xpaly.com.xpaly.enums.WebLink;
import com.example.xpaly.com.xpaly.pojo.ArticlDetailsBean;
import com.example.xpaly.com.xpaly.pojo.SearchResultBean;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.UnsupportedEncodingException;
import java.math.BigDecimal;
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

                if (!strings[z].substring(endIndex).equals("")) {
                    ArticlDetailsBean articlDetailsBean = new ArticlDetailsBean(strings[z].substring(endIndex), 1);
                    articlDetailsBeanList.add(articlDetailsBean);
                }


                String[] string2List = string2.split("src=\"");

                for (String stringHttp : string2List) {

                    if (!stringHttp.contains("img")) {

                        int endIndex2 = stringHttp.indexOf("\"");

                        //System.out.println(stringHttp);

                        //System.out.println(stringHttp.substring(0, endIndex2));

                        //   stringList.add(stringHttp.substring(0, endIndex2));
                        if (!stringHttp.substring(0, endIndex2).equals("")) {
                            ArticlDetailsBean articlDetailsBean2 = new ArticlDetailsBean(stringHttp.substring(0, endIndex2), 2);
                            articlDetailsBeanList.add(articlDetailsBean2);
                        }


                    }

                }

            } else {

                int endIndex = strings[z].lastIndexOf(">") + 1;

                //System.out.println(strings[z].substring(endIndex));
                //    stringList.add(strings[z].substring(endIndex));
                if (!strings[z].substring(endIndex).equals("")) {
                    ArticlDetailsBean articlDetailsBean = new ArticlDetailsBean(strings[z].substring(endIndex), 1);
                    articlDetailsBeanList.add(articlDetailsBean);
                }

            }

            //System.out.println(strings[z]);

        }
        return articlDetailsBeanList;


    }

    public static String intChange2Str(int number) {
        String str;
        if (number <= 0) {
            str = "";
        } else if (number < 10000) {
            str = number + "";
        } else {
            double d = (double) number;
            double num = d / 10000;//1.将数字转换成以万为单位的数字

            BigDecimal b = new BigDecimal(num);
            double f1 = b.setScale(1, BigDecimal.ROUND_HALF_UP).doubleValue();//2.转换后的数字四舍五入保留小数点后一位;
            str = f1 + "万";
        }
        return str;
    }


    public static List<SearchResultBean> getHttpLink(String htmlText) {
        List<SearchResultBean> searchResultBeanList = new ArrayList<>();
        String headString = "https://wolongzy.net";//结果没有域名，手动添加
        Document doc = Jsoup.parse(htmlText);


        Elements links = doc.select("a.videoName"); // 带有href属性的a元素

        for (Element element : links) {

            String urlString = element.attr("href");
            String nameString = element.text();
            SearchResultBean searchResultBean = new SearchResultBean(nameString, headString + urlString);
            //String urlNameString = element.text();
            searchResultBeanList.add(searchResultBean);
            Log.e("test", "name" + nameString + "url" + ":" + headString + urlString);
        }
        return searchResultBeanList;
    }


    public static List<SearchResultBean> getMovieLink(String htmlText) {
        List<SearchResultBean> searchResultBeanList = new ArrayList<>();
        Document doc = Jsoup.parse(htmlText);

        Elements links = doc.select("a[href][title]"); // 带有href属性的a元素

        for (Element element : links) {
            String urlString = element.attr("href");
            //String nameString = element.attr("title");
            //String urlNameString = element.text();
            if (urlString.contains("http") && !urlString.contains("m3u8")) {
                SearchResultBean searchResultBean = new SearchResultBean(element.attr("title"), urlString);
                searchResultBeanList.add(searchResultBean);
            }


        }
        return searchResultBeanList;
    }

    public static List<SearchResultBean> getHttpLinkType2(String urlType, String htmlText) {
        List<SearchResultBean> searchResultBeanList = new ArrayList<>();
        String headString = "";
        if (urlType.equals("2")) {
            headString = WebLink.SU_BO_ZI_YUAN_HOST;
        } else if (urlType.equals("3")) {
            headString = WebLink.OK_ZI_YUAN_HOST;
        }else if (urlType.equals("4")){
            headString = WebLink.KU_BO_ZI_YUAN_HOST;
        }
        Document doc = Jsoup.parse(htmlText);


        Elements links = doc.select("span.xing_vb4").select("a[href]"); // 带有href属性的a元素

        for (Element element : links) {
            String urlString = element.attr("href");
            String nameString = element.text();
            SearchResultBean searchResultBean = new SearchResultBean(nameString, headString + urlString);
            searchResultBeanList.add(searchResultBean);
            Log.e("name:" + nameString, "url" + urlString);
        }
        return searchResultBeanList;
    }


    public static List<SearchResultBean> getMovieLinkType2(String htmlText) {
        List<SearchResultBean> searchResultBeanList = new ArrayList<>();

        Document doc = Jsoup.parse(htmlText);


        Elements links = doc.select("li"); // 带有href属性的a元素

        for (Element element : links) {
            String urlString = element.text();
            if (urlString.contains("$") && !urlString.contains("m3u8")) {
                int index = urlString.indexOf("$");
                SearchResultBean searchResultBean = new SearchResultBean(urlString.substring(0, index), urlString.substring(index + 1));
                searchResultBeanList.add(searchResultBean);
                System.out.println(urlString.substring(0, index) + urlString.substring(index + 1));
            }


        }
        return searchResultBeanList;
    }

    public static String getSearchUrl(String type, String keyWord) {

        if (type.equals("1")) {
            return WebLink.WO_LONG_ZI_YUAN + keyWord;
        } else if (type.equals("2")) {
            return WebLink.SU_BO_ZI_YUAN + keyWord;
        } else if (type.equals("3")) {
            return WebLink.OK_ZI_YUAN_ + keyWord;
        } else if (type.equals("4")) {
            return WebLink.KU_BO_ZI_YUAN+keyWord;
        } else {
            return null;
        }
    }
}
