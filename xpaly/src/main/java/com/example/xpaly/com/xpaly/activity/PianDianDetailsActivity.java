package com.example.xpaly.com.xpaly.activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.view.MenuItem;

import com.example.xpaly.R;
import com.example.xpaly.com.xpaly.adapter.PianDianDetailsAdapter;
import com.example.xpaly.com.xpaly.application.MyApplication;
import com.example.xpaly.com.xpaly.pojo.HotMovieBean;
import com.example.xpaly.com.xpaly.pojo.PianDianDetailsUrlJson;
import com.example.xpaly.com.xpaly.pojo.PianDianSingleDetails;
import com.example.xpaly.com.xpaly.utils.ToastShow;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.jcodecraeer.xrecyclerview.XRecyclerView;

import org.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public class PianDianDetailsActivity extends AppCompatActivity {


    private PianDianDetailsAdapter pianDianDetailsAdapter;
    private List<PianDianSingleDetails.DataBean.ListBean> pianDanDetailsList = new ArrayList<>();
    private int offset = 0;
    private XRecyclerView xRecyclerView;
    private String TAG = getClass().getName();
    private int total;

    private String id;
    // handler处理
    private Handler handler = new Handler() {
        @Override
        public void handleMessage(@NonNull Message msg) {
            super.handleMessage(msg);
            if (msg.what == 0x01) {
                String result = (String) msg.obj;
                PianDianSingleDetails pianDianSingleDetails = new Gson().fromJson(result, PianDianSingleDetails.class);
                total = pianDianSingleDetails.getData().getTotal();
                Log.e("total", total + "");
                if (offset == 0) {
                    pianDanDetailsList = pianDianSingleDetails.getData().getList();
                    pianDianDetailsAdapter.setPianDanDetailsList(pianDanDetailsList);
                    pianDianDetailsAdapter.notifyDataSetChanged();
                    xRecyclerView.refreshComplete();
                } else {
                    try {
                        pianDanDetailsList.addAll(pianDianSingleDetails.getData().getList());
                        pianDianDetailsAdapter.setPianDanDetailsList(pianDanDetailsList);
                    } catch (Exception e) {
                        Log.e("接收", e.getMessage());
                    }

                    pianDianDetailsAdapter.notifyDataSetChanged();
                    xRecyclerView.loadMoreComplete();
                }


                Log.e("接收", "ok");

            } else if (msg.what == 0x02) {
                ToastShow.shortToast(MyApplication.getContext(), "数据加载失败！");
                xRecyclerView.refreshComplete();
            }
        }
    };

    /**
     * 网络请求 参数下一次数据的的位置 请求结果post到handler
     *
     * @param offset
     */
    private void getData(String id, int offset) {
        final PianDianDetailsUrlJson urlJson = new PianDianDetailsUrlJson(id, offset, 10, 0, "");
        Log.e("id", urlJson.getId());
        Log.e("string", urlJson.toString());
        new Thread(new Runnable() {
            @Override
            public void run() {
                String url = "http://api-xl9-ssl.xunlei.com/sl/xlppc.playlist.api/v2/playlist/list";
                RequestBody requestBody = RequestBody.create(MediaType.parse("application/json; charset=utf-8"), urlJson.toString());
                OkHttpClient okHttpClient = new OkHttpClient();
                final Request request = new Request.Builder()
                        .url(url)
                        .post(requestBody)//默认就是GET请求，可以不写
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
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pian_dian_details);
        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }
        initView();
    }

    public void initView() {
        id = getIntent().getStringExtra("id");
        Log.e("id:", id);
        xRecyclerView = findViewById(R.id.activity_pian_dian_details_recyclerView);
        pianDianDetailsAdapter = new PianDianDetailsAdapter(this);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        layoutManager.setOrientation(XRecyclerView.VERTICAL);
        xRecyclerView.setLayoutManager(layoutManager);//设置布局管理器
        pianDianDetailsAdapter.setOnItemClickListener(new PianDianDetailsAdapter.OnItemClickListener() {
            @Override
            public void onClick(int position) {
                Intent intent = new Intent(PianDianDetailsActivity.this,SearchMovieActivity.class);
                intent.putExtra("movieName",pianDanDetailsList.get(position).getName());
                startActivity(intent);
            }
        });
        xRecyclerView.setAdapter(pianDianDetailsAdapter);
        //设置刷新和加载监听
        xRecyclerView.setLoadingListener(new XRecyclerView.LoadingListener() {
            @Override
            public void onRefresh() {
                pianDanDetailsList.clear();
                offset = 0;
                getData(id, offset);
            }

            @Override
            public void onLoadMore() {
                offset = offset + 10;
                if (offset < total) {
                    getData(id, offset);
                } else {
                    xRecyclerView.loadMoreComplete();
                    ToastShow.shortToast(MyApplication.getContext(), "没有更多啦");
                }

            }
        });
        xRecyclerView.refresh();

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
