package com.example.xpaly.com.xpaly.activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.Application;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Log;

import com.example.xpaly.R;
import com.example.xpaly.com.xpaly.adapter.ArticleDetailsAdapter;
import com.example.xpaly.com.xpaly.application.MyApplication;
import com.example.xpaly.com.xpaly.pojo.ArticlDetailsBean;
import com.example.xpaly.com.xpaly.pojo.HotMovieBean;
import com.example.xpaly.com.xpaly.utils.MStringUtils;
import com.example.xpaly.com.xpaly.utils.ToastShow;
import com.google.gson.Gson;

import java.io.IOException;
import java.util.List;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class ArticleDetailsActivity extends AppCompatActivity {
    private ArticleDetailsAdapter articleDetailsAdapter;
    private RecyclerView recyclerView;
    // handler处理
    private Handler handler = new Handler() {
        @Override
        public void handleMessage(@NonNull Message msg) {
            super.handleMessage(msg);
            if (msg.what == 0x01) {
                articleDetailsAdapter.setArticlDetailsBeanList((List<ArticlDetailsBean>) msg.obj);
                articleDetailsAdapter.notifyDataSetChanged();
                Log.e("接收", "ok");

            } else if (msg.what == 0x02) {
                ToastShow.shortToast(MyApplication.getContext(), "数据加载失败！");
                getData(getIntent().getStringExtra("articleUrl"));
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_article_details);
        if (getSupportActionBar() != null) {
            getSupportActionBar().setDefaultDisplayHomeAsUpEnabled(true);
        }

        ToastShow.shortToast(this, getIntent().getStringExtra("articleUrl"));
        initView();

    }

    public void initView() {
        recyclerView = findViewById(R.id.activity_article_details_recyclerView);
        articleDetailsAdapter = new ArticleDetailsAdapter();
        articleDetailsAdapter.setmContext(this);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        linearLayoutManager.setOrientation(RecyclerView.VERTICAL);
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setAdapter(articleDetailsAdapter);
        getData(getIntent().getStringExtra("articleUrl"));
    }

    public void getData(String url) {
        final String strUrl = url;
        new Thread(new Runnable() {
            @Override
            public void run() {
                OkHttpClient okHttpClient = new OkHttpClient();
                final Request request = new Request.Builder()
                        .url(strUrl)
                        .get()//默认就是GET请求，可以不写
                        .build();
                Call call = okHttpClient.newCall(request);
                call.enqueue(new Callback() {
                    @Override
                    public void onFailure(Call call, IOException e) {
                        Log.e("错误", "onFailure: ");
                        Message message = handler.obtainMessage();
                        message.what = 0x02;
                        handler.sendMessage(message);
                    }

                    @Override
                    public void onResponse(Call call, Response response) throws IOException {
                        String responseString = response.body().string();
                        // List<String> stringList = new ArrayList<>();
                        List<ArticlDetailsBean> articlDetailsBeanList = MStringUtils.getArticlDetails(responseString);
                      /*
                       for (ArticlDetailsBean articlDetailsBean : articlDetailsBeanList) {
                            Log.e("TYPE " + articlDetailsBean.getTag(), articlDetailsBean.getWord());
                        }
                       */
                        Log.e("sum", "sum=" + articlDetailsBeanList.size());
                        Message message = handler.obtainMessage();
                        message.what = 0x01;
                        message.obj = articlDetailsBeanList;
                        handler.sendMessage(message);
                    }
                });
            }
        }).start();
    }
}
