package com.example.connect;

import androidx.appcompat.app.AppCompatActivity;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;

import com.example.connect.com.example.pojo.UserLink;
import com.example.connect.com.example.ui.ItemSetting;
import com.example.connect.com.example.utils.ProviderLink;
import com.example.connect.com.example.utils.ToastShow;

import java.util.List;

public class HomeActivity extends AppCompatActivity {
    private long currentTime;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        if (!hasPermission()) {
            requestPermission();
        }
        initView();
    }

    //TODO 初始化控件
    public void initView() {
        ItemSetting watch_link = findViewById(R.id.itemSetting1);
        watch_link.setOnClickListener(new ViewListener());
        ItemSetting favorite = findViewById(R.id.itemSetting3);
        favorite.setOnClickListener(new ViewListener());
        ItemSetting delete_recording = findViewById(R.id.itemSetting4);
        delete_recording.setOnClickListener(new ViewListener());
        ItemSetting setting = findViewById(R.id.itemSetting5);
        setting.setOnClickListener(new ViewListener());
        ItemSetting about = findViewById(R.id.itemSetting6);
        about.setOnClickListener(new ViewListener());


    }

    // TODO 按键监听内部类 ViewListener
    class ViewListener implements View.OnClickListener {


        @Override
        public void onClick(View v) {
            switch (v.getId()) {
                case R.id.itemSetting1:
                    /*
                    ProviderLink providerLink = new ProviderLink(HomeActivity.this);
                    List<UserLink> userLinkList= providerLink.getUserLink();
                    ToastShow.shortToast(HomeActivity.this,"点击");
                    for (UserLink userLink:userLinkList){
                        Log.e("name",userLink.getUserName());
                        if (userLinkList.size()!=0){
                            for (String str:userLink.getUserNumber()){
                                Log.e("number",str);
                            }
                        }
                    }
                     */
                    startActivity(new Intent(HomeActivity.this, WatchLinkActivity.class));
                    break;
                case R.id.itemSetting3:
                    startActivity(new Intent(HomeActivity.this, FavoriteActivity.class));
                    break;
                case R.id.itemSetting4:
                    startActivity(new Intent(HomeActivity.this, DeleteRecordingActivity.class));
                    break;
                case R.id.itemSetting5:
                    startActivity(new Intent(HomeActivity.this, SettingsActivity.class));
                    break;
                case R.id.itemSetting6:
                    startActivity(new Intent(HomeActivity.this, AboutActivity.class));
                    break;
                default:
                    break;

            }
        }
    }

    //TODO 重写返回键
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK) {
            isExitSystem();
            return false;
        }
        return super.onKeyDown(keyCode, event);
    }

    public void isExitSystem() {
        if (System.currentTimeMillis() - currentTime < 2500) {
            finish();

        } else {
            currentTime = System.currentTimeMillis();
            ToastShow.shortToast(this, "再按一次退出");
        }
    }

    /**
     * *判断是否有访问联系人权限
     */
    private boolean hasPermission() {
        Log.i("TAG", "hasPermission:判断是否有权限");
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {

            return checkSelfPermission(Manifest.permission.READ_CONTACTS) == PackageManager.PERMISSION_GRANTED;

        } else {

            return true;
        }

    }

    /**
     * 请求读取联系人权限
     */

    private void requestPermission() {
        Log.i("requestPermission", "请求权限");
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            if (shouldShowRequestPermissionRationale(Manifest.permission.READ_CONTACTS)) {

                Log.i("TAG", "requestPermission:请求权限");
            }
            requestPermissions(new String[]{Manifest.permission.READ_CONTACTS}, 1);
        }
    }

}
