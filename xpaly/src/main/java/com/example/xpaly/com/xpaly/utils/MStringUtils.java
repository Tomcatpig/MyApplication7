package com.example.xpaly.com.xpaly.utils;

import android.util.Log;

import java.io.UnsupportedEncodingException;
import java.text.SimpleDateFormat;

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
        }else {
            return str.substring(0,end).trim();
        }

    }

    public static String getMusicName(String str) {

        int start = str.indexOf("-");
        int end = str.lastIndexOf(".");
        if (start == -1) {
            return str.substring(0,end-1).trim();
        }else {
            return str.substring(start+1,end).trim();
        }

    }

    public static String dateFormat(int flag,long time){
        String date="null";
        if (flag==1){
            SimpleDateFormat sDateFormat = new SimpleDateFormat("yyyy-MM-dd");
            date = sDateFormat.format(time);
        }
        return date;
    }
}
