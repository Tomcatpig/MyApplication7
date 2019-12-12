package com.example.xpaly;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Message;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.example.xpaly.com.xpaly.pojo.ArticlDetailsBean;
import com.example.xpaly.com.xpaly.pojo.PianDianDetailsUrlJson;
import com.example.xpaly.com.xpaly.utils.Analysisbypull;
import com.example.xpaly.com.xpaly.utils.MStringUtils;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        if (getSupportActionBar() != null) {
            getSupportActionBar().hide();
        }
        initView();
    }

    public void initView() {
        Button button = findViewById(R.id.return_homeActivity);
        button.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.return_homeActivity:
                PianDianDetailsUrlJson json = new PianDianDetailsUrlJson("121212",0,15,0,"");
                Log.e("json",json.toString());
                startActivity(new Intent(MainActivity.this, HomeActivity.class));
                finish();
                //testGetData();
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
