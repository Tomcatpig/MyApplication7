package com.example.connect.com.example.utils;

import android.content.Context;
import android.widget.Toast;


/**
 * @创建者 tw
 * @创建时间 2019/10/31
 * @描述:toast 气泡工具类
 */
public class ToastShow {

    /**
     *@描述
     *@参数  [context, showMessage]
     *@返回值  void
     *@创建人  tw
     *@创建时间  2019/10/31
     *@修改人和其它信息
     */
    public static void longToast(Context context ,String showMessage){

        Toast.makeText(context,showMessage,Toast.LENGTH_LONG).show();
    }
    public static void shortToast(Context context ,String showMessage){

        Toast.makeText(context,showMessage,Toast.LENGTH_SHORT).show();
    }
    public static void longToast(Context context ,Integer showMessage){

        Toast.makeText(context,showMessage,Toast.LENGTH_LONG).show();
    }
    public static void shortToast(Context context ,Integer showMessage){

        Toast.makeText(context,showMessage,Toast.LENGTH_SHORT).show();
    }
}
