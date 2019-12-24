package com.example.xpaly.com.xpaly.utils;


import android.content.Context;
import android.content.SharedPreferences;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Map;

/**
 * @创建者 tw
 * @创建时间 2019/11/16
 * @描述
 */

@SuppressWarnings("unused")
public class SharedPreferencesUtils {
    //文件名
    // private static final String FILE_NAME = "share_pref";
    //默认文件名file
    private static  String FILE_NAME = "file";

    /**
     * 根据传入的object按照对应方法写入文件
     *
     * @param context 上下文
     * @param key     key
     * @param object  值
     */

    public static void put(Context context, String key, Object object) {
        SharedPreferences sp = context.getSharedPreferences(FILE_NAME, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sp.edit();
        if (object instanceof Integer) {
            editor.putInt(key, (Integer) object);
        } else if (object instanceof String) {
            editor.putString(key, (String) object);
        } else if (object instanceof Float) {
            editor.putFloat(key, (Float) object);
        } else if (object instanceof Long) {
            editor.putLong(key, (Long) object);
        } else if (object instanceof Boolean) {
            editor.putBoolean(key, (Boolean) object);
        }
        SharedPreferencesCompat.apply(editor);

    }
    /**
     *@描述
     *@参数  [fileName]
     *@返回值  void
     *@创建人  tw
     *@创建时间  2019/11/16
     *@设置文件名
     */

    public static void setFileName(String fileName) {
        FILE_NAME = fileName;
    }

    /**
     * 根据key与defaultValue获取对应的值
     *
     * @param context      上下文
     * @param key          key
     * @param defaultValue 默认值
     * @return Object
     */
    public static Object get(Context context, String key, Object defaultValue) {
        SharedPreferences sp = context.getSharedPreferences(FILE_NAME, Context.MODE_PRIVATE);
        if (defaultValue instanceof String) {
            return sp.getString(key, (String) defaultValue);
        } else if (defaultValue instanceof Integer) {
            return sp.getInt(key, (Integer) defaultValue);
        } else if (defaultValue instanceof Boolean) {
            return sp.getBoolean(key, (Boolean) defaultValue);
        } else if (defaultValue instanceof Float) {
            return sp.getFloat(key, (Float) defaultValue);
        } else if (defaultValue instanceof Long) {
            return sp.getLong(key, (Long) defaultValue);
        }
        return null;
    }

    /**
     * 删除对应key的值
     *
     * @param context 上下文
     * @param key     key
     */
    public static void remove(Context context, String key) {
        SharedPreferences sp = context.getSharedPreferences(FILE_NAME, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sp.edit();
        editor.remove(key);
        SharedPreferencesCompat.apply(editor);
    }

    /**
     * 是否包含指定key
     *
     * @param context 上下文
     * @param key     key
     * @return boolean
     */
    public static boolean contains(Context context, String key) {
        SharedPreferences sp = context.getSharedPreferences(FILE_NAME, Context.MODE_PRIVATE);
        return sp.contains(key);
    }

    /**
     * 清空
     *
     * @param context Context
     */
    public static void clear(Context context) {
        SharedPreferences sp = context.getSharedPreferences(FILE_NAME, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sp.edit();
        editor.clear();
        SharedPreferencesCompat.apply(editor);
    }

    /**
     * 获取所有
     *
     * @param context Context
     * @return map
     */
    public static Map<String, ?> getAll(Context context) {
        SharedPreferences sp = context.getSharedPreferences(FILE_NAME, Context.MODE_PRIVATE);
        return sp.getAll();
    }


    /**
     *
     */
    private static class SharedPreferencesCompat {

        private static final Method applyMethod = findApplyMethod();

        /**
         * 反射查找apply方法
         *
         * @return Method
         */
        private static Method findApplyMethod() {
            try {
                Class<?> clazz = SharedPreferences.Editor.class;
                return clazz.getMethod("apply");
            } catch (NoSuchMethodException e) {
                e.printStackTrace();
            }
            return null;
        }

        /**
         * apply存在则使用apply,否则使用commit
         *
         * @param editor SharedPreferences.Editor
         */
        private static void apply(SharedPreferences.Editor editor) {
            if (applyMethod != null) {
                try {
                    applyMethod.invoke(editor);
                    return;
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            editor.commit();
        }
    }
}
