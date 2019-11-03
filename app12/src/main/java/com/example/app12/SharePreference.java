package com.example.app12;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.user.utils.SPUtils;
import com.user.utils.ToastShow;

import java.util.Map;

public class SharePreference extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_share_preference);
        initView();
    }

    private void initView() {
        Button share_set = findViewById(R.id.share_set);
        Button share_get = findViewById(R.id.share_get);
        share_get.setOnClickListener(new ButtonListener());
        share_set.setOnClickListener(new ButtonListener());
    }

    private class ButtonListener implements View.OnClickListener {
        @Override
        public void onClick(View v) {

            switch (v.getId()) {
                case R.id.share_get:
                    Map<String, String> mapInfo = SPUtils.getInfo(SharePreference.this);
                    String uname = mapInfo.get("userName");
                    String pwd = mapInfo.get("pwd");
                    ToastShow.shortToast(SharePreference.this, uname + ":" + pwd);
                    break;
                case R.id.share_set:
                    SPUtils.saveInfo(SharePreference.this, "tom", "123456567");
                    ToastShow.shortToast(SharePreference.this, "保存成功");
                    break;

            }
        }
    }
}
