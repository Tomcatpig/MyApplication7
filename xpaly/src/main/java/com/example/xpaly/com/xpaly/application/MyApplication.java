package com.example.xpaly.com.xpaly.application;

import android.app.Application;
import android.content.Context;
import android.util.Log;

import androidx.annotation.ColorInt;

import com.tencent.smtt.sdk.QbSdk;

/**
 * @创建者 tw
 * @创建时间 2019/12/7
 * @描述
 */
public class MyApplication extends Application {

    private static Context context;
    public static boolean isAddX5=false;

    @Override
    public void onCreate() {
        super.onCreate();
        this.context = getApplicationContext();
        initX5();
    }
public void initX5(){
    //搜集本地tbs内核信息并上报服务器，服务器返回结果决定使用哪个内核。

    QbSdk.PreInitCallback cb = new QbSdk.PreInitCallback() {

        @Override
        public void onViewInitFinished(boolean arg0) {
            if (arg0){
                isAddX5=true;
            }
            // TODO Auto-generated method stub
            //x5內核初始化完成的回调，为true表示x5内核加载成功，否则表示x5内核加载失败，会自动切换到系统内核。
            Log.e("app", " onViewInitFinished is " + arg0);
        }

        @Override
        public void onCoreInitFinished() {
            // TODO Auto-generated method stub
        }
    };
    QbSdk.setDownloadWithoutWifi(true);
    //x5内核初始化接口
    QbSdk.initX5Environment(getApplicationContext(),  cb);
}

    public static Context getContext() {
        return context;
    }
}