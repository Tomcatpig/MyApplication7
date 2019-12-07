package com.example.myapplication;


import android.util.Log;
import android.widget.ListView;

import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.example.base.BaseActivity;
import com.example.com.example.adapter.DetilsAdapter;
import com.example.com.example.bean.Detils;
import com.example.com.example.bean.UUU;
import com.example.com.example.utils.MStringUtils;
import com.google.gson.Gson;

import java.io.UnsupportedEncodingException;
import java.util.List;

public class NetWorkData extends BaseActivity {
    private ListView class_list;
    private List<UUU.SongListBean> resultBeanList;
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
    //String url="https://www.mingrisoft.com/Index/API/getAllCourse/rows";
       String url="http://tingapi.ting.baidu.com/v1/restserver/ting?size=20&type=2&callback=cb_list&_t=1468380543284&format=json&method=baidu.ting.billboard.billList";
        StringRequest request =new  StringRequest(url, new Response.Listener<String>() {

            @Override
            public void onResponse(String response) {
            //请求数据成功调用此方法
               String string = MStringUtils.getStringBeingToEnd("(",")",response);
               UUU uuu = new Gson().fromJson(string,UUU.class);
               for (UUU.SongListBean songListBean:uuu.getSong_list()){
                   Log.i("title",songListBean.getTitle());
               }



                resultBeanList = uuu.getSong_list();
               class_list.setAdapter(new DetilsAdapter(resultBeanList,NetWorkData.this));


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
