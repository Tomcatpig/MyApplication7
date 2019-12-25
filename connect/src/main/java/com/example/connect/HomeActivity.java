package com.example.connect;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.KeyEvent;

import com.example.connect.com.example.utils.ToastShow;

public class HomeActivity extends AppCompatActivity {
    private long currentTime;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
    }




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
}
