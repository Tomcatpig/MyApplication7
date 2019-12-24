package com.example.xpaly;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.TextView;

import com.example.xpaly.com.xpaly.pojo.ArticlDetailsBean;
import com.example.xpaly.com.xpaly.pojo.PianDianDetailsUrlJson;
import com.example.xpaly.com.xpaly.utils.Analysisbypull;
import com.example.xpaly.com.xpaly.utils.MStringUtils;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private int recLen = 5;//跳过倒计时提示5秒
    private TextView skip_text;
    Timer timer = new Timer();
    private Handler handler;
    private Runnable runnable;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        if (getSupportActionBar() != null) {
            getSupportActionBar().hide();
        }
        initView();

        timer.schedule(task, 1000, 1000);//等待时间一秒，停顿时间一秒
        /**
         * 正常情况下不点击跳过
         */
        handler = new Handler();
        handler.postDelayed(runnable = new Runnable() {
            @Override
            public void run() {
                //从闪屏界面跳转到首界面
                Intent intent = new Intent(MainActivity.this, HomeActivity.class);
                startActivity(intent);
                finish();
            }
        }, 5000);//延迟5S后发送handler信息

    }

    public void initView() {
        skip_text = findViewById(R.id.go_homeActivity);
        skip_text.setOnClickListener(this);
    }

    TimerTask task = new TimerTask() {
        @Override
        public void run() {
            runOnUiThread(new Runnable() { // UI thread
                @Override
                public void run() {
                    recLen--;
                    skip_text.setText("跳过 " + recLen);
                    if (recLen < 0) {
                        timer.cancel();
                        skip_text.setVisibility(View.GONE);//倒计时到0隐藏字体
                    }
                }
            });
        }
    };

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.go_homeActivity:
                Intent intent = new Intent(MainActivity.this, HomeActivity.class);
                startActivity(intent);
                finish();
                if (runnable != null) {
                    handler.removeCallbacks(runnable);
                }
                break;
            default:
                break;

        }
    }

    /**
     * 测试
     */
    public void testGetData() {

        new Thread(new Runnable() {
            @Override
            public void run() {
                String url = "http://pc.wangpan.xycdn.n0808.com/1a48bd22fd579fb174ffd4dc8e5eb765";
                OkHttpClient okHttpClient = new OkHttpClient();
                final Request request = new Request.Builder()
                        .url(url)
                        .get()//默认就是GET请求，可以不写
                        .build();
                Call call = okHttpClient.newCall(request);
                call.enqueue(new Callback() {
                    @Override
                    public void onFailure(Call call, IOException e) {
                        Log.e("错误", "onFailure: ");


                    }

                    @Override
                    public void onResponse(Call call, Response response) throws IOException {
                        String responseString = response.body().string();
                        // List<String> stringList = new ArrayList<>();
                        List<ArticlDetailsBean> articlDetailsBeanList = MStringUtils.getArticlDetails(responseString);
                        for (ArticlDetailsBean articlDetailsBean : articlDetailsBeanList) {
                            Log.e("TYPE " + articlDetailsBean.getTag(), articlDetailsBean.getWord());
                        }
                    }
                });
            }
        }).start();
    }
}
