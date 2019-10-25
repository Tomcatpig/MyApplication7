package com.example.myapplication;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private List<User> users = new ArrayList<>();
    private ActionBar actionBar;
    private ListView listView;
    private Button btn_close, btn_aopen, open_web, open_json;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        for (int i = 0; i < 30; i++) {
            User user = new User();
            user.setUid(1000 + i + "");
            user.setUname("隔壁老王" + i);
            users.add(user);
        }


    }

    /**
     * 初始化控件
     */
    private void initView() {
        actionBar = getSupportActionBar();
        btn_aopen = findViewById(R.id.button1);
        btn_close = findViewById(R.id.button2);
        open_web = findViewById(R.id.open_web);
        open_json = findViewById(R.id.open_json);
        listView = findViewById(R.id.list_info);
        Button open_weather = findViewById(R.id.open_weather);

        btn_close.setOnClickListener(new ButtonListener());
        btn_aopen.setOnClickListener(new ButtonListener());
        open_web.setOnClickListener(new ButtonListener());
        open_json.setOnClickListener(new ButtonListener());
        open_weather.setOnClickListener(new ButtonListener());
        listView.setAdapter(new MyAdapter());
    }

    class ButtonListener implements View.OnClickListener {


        @Override
        public void onClick(View v) {
            switch (v.getId()) {
                case R.id.button1:
                    actionBar.hide();
                    break;
                case R.id.button2:
                    actionBar.show();
                    break;
                case R.id.open_web:
                    Intent intent = new Intent(MainActivity.this, MyWebView.class);
                    startActivity(intent);
                    break;
                case R.id.open_json:
                    startActivity(new Intent(MainActivity.this, NetWorkData.class));
                    break;
                case R.id.open_weather:
                    startActivity(new Intent(MainActivity.this,Weather_net.class));
                    break;
            }
        }
    }

    private class MyAdapter extends BaseAdapter {


        @Override
        public int getCount() {
            return users.size();
        }

        @Override
        public Object getItem(int position) {
            return users.get(position);
        }

        @Override
        public long getItemId(int position) {
            return 0;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            User user = users.get(position);
            View view = View.inflate(MainActivity.this, R.layout.list_layout, null);
            TextView user_name = view.findViewById(R.id.user_name);
            TextView user_id = view.findViewById(R.id.user_id);
            ImageView user_photo = view.findViewById(R.id.user_photo);
            user_photo.setImageResource(R.drawable.ic_launcher_background);
            user_name.setText(user.getUname());
            user_id.setText(user.getUid());
            return view;
        }
    }
}
