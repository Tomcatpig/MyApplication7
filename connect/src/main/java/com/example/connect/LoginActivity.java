package com.example.connect;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;

import com.example.connect.com.example.utils.ToastShow;

public class LoginActivity extends AppCompatActivity {
    private long currentTime;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        getSupportActionBar().hide();
        initView();
    }

    public void initView() {
        Button activity_login_loginButton = findViewById(R.id.activity_login_loginButton);

        activity_login_loginButton.setOnClickListener(new ViewListener());
    }

    class ViewListener implements View.OnClickListener {

        @Override
        public void onClick(View v) {
            switch (v.getId()) {

                case R.id.activity_login_loginButton:
                    startActivity(new Intent(LoginActivity.this, HomeActivity.class));
                    finish();
            }
        }
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
