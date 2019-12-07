package com.example.xpaly.com.xpaly.application;

import android.app.Application;
import android.content.Context;

import androidx.annotation.ColorInt;

/**
 * @创建者 tw
 * @创建时间 2019/12/7
 * @描述
 */
public class MyApplication extends Application {

    private static Context context;

    @Override
    public void onCreate() {
        super.onCreate();
        this.context = getApplicationContext();
    }

    public static Context getContext() {
        return context;
    }
}
