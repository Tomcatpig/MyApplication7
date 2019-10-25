package com.example.myapplication;


import android.util.Log;
import android.widget.ListView;

import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.example.base.BaseActivity;
import com.example.com.example.adapter.DetilsAdapter;
import com.example.com.example.bean.Detils;
import com.google.gson.Gson;

import java.util.List;

public class NetWorkData extends BaseActivity {
    private ListView class_list;
    private List<Detils.ResultBean> resultBeanList;
    //加载界面
    @Override
    protected void addContentView() {
        setContentView(R.layout.activity_net_work_data);
    }

    @Override
    protected void initContentView() {

           setTitleBarName("分类");
           setTitleBarBackgroundColor(0xffffffff);
           setTitleBarNameColor(0xff000000);


    class_list = findViewById(R.id.class_list);
    String url="https://weatherapi.market.xiaomi.com/wtr-v2/temp/forecast?cityId=101010100";
        StringRequest request =new  StringRequest(url, new Response.Listener<String>() {

            @Override
            public void onResponse(String response) {
            //请求数据成功调用此方法
                Log.e("response",response);
               //Detils detils = new Gson().fromJson(response,Detils.class);
               //resultBeanList = detils.getResult();
               //class_list.setAdapter(new DetilsAdapter(resultBeanList,NetWorkData.this));


            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
            //失败调用此方法

            }
        });
        //需要再次开启
        requestQueue.start();
        requestQueue.add(request);
    }




    @Override
    protected boolean initTitleBar() {
        return true;
    }

    @Override
    protected boolean backBtnShow() {
        return true;
    }
}
