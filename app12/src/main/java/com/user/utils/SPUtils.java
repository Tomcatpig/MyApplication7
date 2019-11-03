package com.user.utils;

import android.content.Context;
import android.content.SharedPreferences;

import java.util.HashMap;
import java.util.Map;

/**
 * @创建者 tw
 * @创建时间 2019/11/3
 * @描述
 */
public class SPUtils {
  public static boolean saveInfo(Context context,String arg0,String arg1){
      SharedPreferences sp =context.getSharedPreferences("data",Context.MODE_PRIVATE);
      SharedPreferences.Editor editor = sp.edit();
      editor.putString("userName",arg0);
      editor.putString("pwd",arg1);
      editor.commit();
      return true;
  }

  public static Map<String ,String>getInfo(Context context){
      SharedPreferences sp = context.getSharedPreferences("data",Context.MODE_PRIVATE);
      String agr0 = sp.getString("userName",null);
      String agr1 = sp.getString("pwd",null);
      Map<String ,String > infoMap = new HashMap<>();
      infoMap.put("userName",agr0);
      infoMap.put("pwd",agr1);
      return infoMap;
  }
}
