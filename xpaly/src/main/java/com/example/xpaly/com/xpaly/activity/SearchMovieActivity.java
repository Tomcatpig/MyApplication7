package com.example.xpaly.com.xpaly.activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;

import com.example.xpaly.R;
import com.example.xpaly.com.xpaly.adapter.SearchMovieRvAdapter;
import com.example.xpaly.com.xpaly.application.MyApplication;
import com.example.xpaly.com.xpaly.pojo.PianDianDetailsUrlJson;
import com.example.xpaly.com.xpaly.pojo.PianDianSingleDetails;
import com.example.xpaly.com.xpaly.pojo.SearchResultBean;
import com.example.xpaly.com.xpaly.utils.MStringUtils;
import com.example.xpaly.com.xpaly.utils.ToastShow;
import com.google.gson.Gson;

import java.io.IOException;
import java.util.List;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public class SearchMovieActivity extends AppCompatActivity {
    private SearchMovieRvAdapter searchMovieRvAdapter;
    private String TAG = getClass().getName();
    private String keyWord="";
    // handler处理
    private Handler handler = new Handler() {
        @Override
        public void handleMessage(@NonNull Message msg) {
            super.handleMessage(msg);
            String result = (String) msg.obj;
            if (msg.what == 0x01) {
                List<SearchResultBean> searchResultBeanList = MStringUtils.getHttpLink(result);
                searchMovieRvAdapter.setResultBeanList(searchResultBeanList);
                searchMovieRvAdapter.notifyDataSetChanged();
                SwipeRefreshLayout swipeRefreshLayout = findViewById(R.id.activity_search_movie_swipeRefresh);
                swipeRefreshLayout.setRefreshing(false);
            } else if (msg.what == 0x02) {
                SwipeRefreshLayout swipeRefreshLayout = findViewById(R.id.activity_search_movie_swipeRefresh);
                swipeRefreshLayout.setRefreshing(false);
                ToastShow.shortToast(MyApplication.getContext(), "数据请求失败！");
            }

        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_movie);
        getSupportActionBar().hide();
        initView();
    }

    public void initView() {
        SwipeRefreshLayout swipeRefreshLayout = findViewById(R.id.activity_search_movie_swipeRefresh);
        swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                getData(keyWord);
            }
        });
        swipeRefreshLayout.setColorSchemeColors(Color.parseColor("#03A9F4"));
        //返回键设置监听搜索键设置监听
        ImageButton goBack = findViewById(R.id.search_actionbar_goBack);
        ImageButton confirm = findViewById(R.id.search_actionbar_confirm);
        confirm.setOnClickListener(new ButtonListener());
        goBack.setOnClickListener(new ButtonListener());
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        layoutManager.setOrientation(RecyclerView.VERTICAL);

        RecyclerView recyclerView = findViewById(R.id.activity_search_movie_recyclerView);
        recyclerView.setLayoutManager(layoutManager);
        searchMovieRvAdapter = new SearchMovieRvAdapter();
        recyclerView.setAdapter(searchMovieRvAdapter);
    }


    class ButtonListener implements View.OnClickListener {
        @Override
        public void onClick(View v) {
            switch (v.getId()) {
                case R.id.search_actionbar_goBack:
                    finish();
                    break;
                case R.id.search_actionbar_confirm:
                    SwipeRefreshLayout swipeRefreshLayout = findViewById(R.id.activity_search_movie_swipeRefresh);
                    swipeRefreshLayout.setRefreshing(true);
                    EditText editText = findViewById(R.id.search_actionbar_editText);
                    keyWord=editText.getText().toString().trim();
                    getData(editText.getText().toString().trim());
                    break;
                default:
                    break;
            }
        }
    }


    /**
     * 网络请求 参数下一次数据的的位置 请求结果post到handler
     *
     * @param searchWord
     */
    private void getData(final String searchWord) {

        Log.e("string", searchWord);
        new Thread(new Runnable() {
            @Override
            public void run() {
                String url = "https://wolongzy.net/search.html?searchword=" + searchWord;
                OkHttpClient okHttpClient = new OkHttpClient();
                final Request request = new Request.Builder()
                        .url(url)
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
}
