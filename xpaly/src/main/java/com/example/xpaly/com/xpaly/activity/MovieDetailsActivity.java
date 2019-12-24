package com.example.xpaly.com.xpaly.activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.view.MenuItem;

import com.example.xpaly.R;
import com.example.xpaly.com.xpaly.adapter.MovieDetailsRvAdapter;
import com.example.xpaly.com.xpaly.application.MyApplication;
import com.example.xpaly.com.xpaly.pojo.SearchResultBean;
import com.example.xpaly.com.xpaly.utils.MStringUtils;
import com.example.xpaly.com.xpaly.utils.SharedPreferencesUtils;
import com.example.xpaly.com.xpaly.utils.ToastShow;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class MovieDetailsActivity extends AppCompatActivity {

    private String TAG = getClass().getName();
    private MovieDetailsRvAdapter movieDetailsRvAdapter;
    private List<SearchResultBean> resultBeanList = new ArrayList<>();
    private String movieUrl = "";
    private String searchType = "1";
    private Handler handler = new Handler() {
        @Override
        public void handleMessage(@NonNull Message msg) {
            super.handleMessage(msg);
            String result = (String) msg.obj;
            if (msg.what == 0x01) {
                if (searchType.equals("1")) {
                    resultBeanList = MStringUtils.getMovieLink(result);
                } else if (searchType.equals("2") || searchType.equals("3") || searchType.equals("4")) {
                    resultBeanList = MStringUtils.getMovieLinkType2(result);
                }

                Log.e("size", resultBeanList.size() + "");
                movieDetailsRvAdapter.setResultBeanList(resultBeanList);
                movieDetailsRvAdapter.notifyDataSetChanged();

            } else if (msg.what == 0x02) {
                ToastShow.shortToast(MyApplication.getContext(), "数据请求失败！");
            }

        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movie_details);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        initView();


    }


    public void initView() {
        movieUrl = getIntent().getStringExtra("movieUrl");
        Log.e("movieUrl", movieUrl);
        searchType = getIntent().getStringExtra("searchType");
        GridLayoutManager layoutManager = new GridLayoutManager(this, 4);
        RecyclerView recyclerView = findViewById(R.id.activity_movie_details_recyclerView);
        movieDetailsRvAdapter = new MovieDetailsRvAdapter();
        recyclerView.setLayoutManager(layoutManager);
        movieDetailsRvAdapter.setOnItemClickListener(new MovieDetailsRvAdapter.OnItemClickListener() {
            @Override
            public void onClick(int position) {
                SharedPreferencesUtils.setFileName("com.example.xpaly_preferences");
                String playType = (String) SharedPreferencesUtils.get(MovieDetailsActivity.this, "player", "1");
                Log.e("playType",playType);
                if (playType.equals("1")){
                    Intent intent = new Intent(MovieDetailsActivity.this, PlayMovieActivity.class);
                    intent.putExtra("movieWebLink", resultBeanList.get(position).getMoviewUrl());
                    startActivity(intent);
                }else if (playType.equals("2")){
                    Intent intent = new Intent(MovieDetailsActivity.this, TencentX5PlayActivity.class);
                    intent.putExtra("movieWebLink", resultBeanList.get(position).getMoviewUrl());
                    startActivity(intent);
                }

            }
        });
        recyclerView.setAdapter(movieDetailsRvAdapter);
        getData(movieUrl);
    }

    /**
     * 网络请求 参数下一次数据的的位置 请求结果post到handler
     *
     * @param movieUrl
     */
    private void getData(final String movieUrl) {

        Log.e("string", movieUrl);
        new Thread(new Runnable() {
            @Override
            public void run() {
                OkHttpClient okHttpClient = new OkHttpClient();
                final Request request = new Request.Builder()
                        .url(movieUrl)
                        .get()//默认就是GET请求，可以不写
                        .build();
                Call call = okHttpClient.newCall(request);
                call.enqueue(new Callback() {
                    @Override
                    public void onFailure(Call call, IOException e) {
                        Log.e(TAG, "onFailure: ");
                        Message message = handler.obtainMessage();
                        message.what = 0x02;
                        handler.sendMessage(message);

                    }

                    @Override
                    public void onResponse(Call call, Response response) throws IOException {
                        String responseString = response.body().string();
                        Log.e(TAG, "onResponse: " + responseString);

                        Message message = handler.obtainMessage();
                        message.what = 0x01;
                        message.obj = responseString;
                        handler.sendMessage(message);


                    }
                });
            }
        }).start();
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                finish();
                return false;
            default:
                return super.onOptionsItemSelected(item);
        }

    }
}
