package com.user.utils;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import com.example.sqlHelper.MySqlHelper;

import java.util.ArrayList;
import java.util.List;

/**
 * @创建者 tw
 * @创建时间 2019/11/3
 * @描述 数据库工具类
 */
public class DataBaseUtils {
    private static MySqlHelper mySqlHelper;


    public static void insertData(Context context, String uname, String pwd) {
        mySqlHelper = new MySqlHelper(context);
        SQLiteDatabase db = mySqlHelper.getWritableDatabase();
        String sql = "insert into info (uname,pwd) values(?,?)";
        try {
            db.execSQL(sql, new Object[]{uname, pwd});
            ToastShow.shortToast(context, "插入成功");
            db.close();
        } catch (Exception e) {
            Log.e("insertData", "插入失败");
            ToastShow.shortToast(context, "插入失败");
            e.printStackTrace();
        }


    }

    public static void deleteData(Context context, String uname) {
        mySqlHelper = new MySqlHelper(context);
        SQLiteDatabase db = mySqlHelper.getWritableDatabase();
        String sql = "delete from info where uname=?";
        try {
            db.execSQL(sql, new Object[]{uname});
            db.close();
            ToastShow.shortToast(context, "删除成功");
        } catch (Exception e) {
            ToastShow.shortToast(context, "删除失败");
            Log.e("insertData", "删除失败");
            e.printStackTrace();
        }


    }

    public static void upDate(Context context, String beforeUname, String newPwd, String newName) {
        mySqlHelper = new MySqlHelper(context);
        SQLiteDatabase db = mySqlHelper.getWritableDatabase();
        String sql = "update info set uname=?,pwd=? where uname=?";
        try {
            db.execSQL(sql, new Object[]{newName, newPwd, beforeUname});
            db.close();
            ToastShow.shortToast(context, "更新成功");
        } catch (Exception e) {
            ToastShow.shortToast(context, "更新失败");
            Log.e("insertData", "更新失败");
            e.printStackTrace();
        }
    }

    public static List<Info> query(Context context, String name) {
        mySqlHelper = new MySqlHelper(context);
        SQLiteDatabase db = mySqlHelper.getWritableDatabase();
        List<Info> infos = new ArrayList<>();
        try {
            Cursor cursor = db.query("info", null, "uname=?",
                    new String[]{name}, null, null, null);

            while (cursor.moveToNext()) {
                Info user = new Info();
                user.setId(cursor.getInt(0));
                user.setUname(cursor.getString(1));
                user.setPwd(cursor.getString(2));
                infos.add(user);
            }
            cursor.close();
            db.close();
        } catch (Exception e) {
            ToastShow.shortToast(context, "查询失败");
            Log.e("insertData", "查询失败");
            e.printStackTrace();
        }
        ToastShow.shortToast(context, "查询成功");

        return infos;
    }

    public static List<Info> queryAll(Context context) {
        mySqlHelper = new MySqlHelper(context);
        SQLiteDatabase db = mySqlHelper.getWritableDatabase();
        List<Info> infos = new ArrayList<>();
        String sql = "select * from info";
        try {
            Cursor cursor = db.rawQuery(sql, null);

            while (cursor.moveToNext()) {
                Info user = new Info();
                user.setId(cursor.getInt(0));
                user.setUname(cursor.getString(1));
                user.setPwd(cursor.getString(2));
                infos.add(user);
            }
            cursor.close();
            db.close();
            ToastShow.shortToast(context, "查询成功");
        } catch (Exception e) {
            ToastShow.shortToast(context, "查询失败");
            Log.e("insertData", "查询失败");
            e.printStackTrace();
        }
        return infos;
    }

}
