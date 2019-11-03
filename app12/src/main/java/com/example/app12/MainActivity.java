package com.example.app12;

import android.content.Intent;
import android.os.Bundle;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.annotation.NonNull;

import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private TextView mTextMessage;

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_home:
                    mTextMessage.setText(R.string.title_home);
                    return true;
                case R.id.navigation_dashboard:
                    mTextMessage.setText(R.string.title_dashboard);
                    return true;
                case R.id.navigation_notifications:
                    mTextMessage.setText(R.string.title_notifications);
                    return true;
            }
            return false;
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        BottomNavigationView navView = findViewById(R.id.nav_view);
        mTextMessage = findViewById(R.id.message);
        navView.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
        initView();
    }

    private void initView() {
        Button copy_message = findViewById(R.id.copy_message);
        Button open_share = findViewById(R.id.open_share);
        Button open_sql = findViewById(R.id.open_sql);
        copy_message.setOnClickListener(new ButtonListener());
        open_share.setOnClickListener(new ButtonListener());
        open_sql.setOnClickListener(new ButtonListener());
    }

    private class ButtonListener implements View.OnClickListener {
        @Override
        public void onClick(View v) {
            Intent intent;
            switch (v.getId()) {
                case R.id.copy_message:
                    intent = new Intent(MainActivity.this, CopyMessage.class);
                    startActivity(intent);
                    break;
                case R.id.open_share:
                    intent = new Intent(MainActivity.this, SharePreference.class);
                    startActivity(intent);
                    break;
                case R.id.open_sql:
                    intent = new Intent(MainActivity.this, SqlActivity.class);
                    startActivity(intent);
                    break;

            }
        }
    }
}
