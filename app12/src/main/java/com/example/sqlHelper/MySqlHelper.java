package com.example.sqlHelper;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

/**
 * @创建者 tw
 * @创建时间 2019/11/3
 * @描述
 */
public class MySqlHelper extends SQLiteOpenHelper {
    public MySqlHelper(Context context) {
        super(context, "data.db", null, 1);
        Log.i("MySqlHelper","创建数据库");
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String sql ="create table info (id integer primary key autoincrement,uname varchar(20),pwd varcahr(16))";
        db.execSQL(sql);
        Log.i("MySqlHelper","创建数据表");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
    Log.i("MySqlHelper","更新数据库");
    }
}
