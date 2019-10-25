package com.example.base;



import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;
import androidx.annotation.ColorInt;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import com.android.volley.RequestQueue;
import com.example.app.MineApplication;
import com.example.myapplication.R;

public abstract class BaseActivity extends AppCompatActivity {
    protected   RequestQueue requestQueue;//请求队列
    private ImageButton title_back;//返回按钮
    private TextView title_name;//actionbar标题
    private View titleBar;//actionbar

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestQueue = MineApplication.getRequestQueue();
        addContentView();//设置界面布局

        if (initTitleBar()) {
            titleBar  = View.inflate(this,R.layout.title_bar,null);
            title_back = findViewById(R.id.title_bar_back);
            title_name = findViewById(R.id.title_bar_name);

            setTitleBarShowType();//设置是否显示返回键
        }

        addListener();
        initContentView();//初始化界面布局
    }



    private void addListener() {
        if (initTitleBar()){
            title_back.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    finish();
                }
            });
        }

    }

    private void setTitleBarShowType() {
        if (backBtnShow()) {
            title_back.setVisibility(View.VISIBLE);
        } else {
            title_back.setVisibility(View.GONE);
        }
    }

    protected  boolean backBtnShow(){

        return false;
    }
    protected abstract void addContentView();
    protected abstract void initContentView();




    protected abstract boolean initTitleBar();

    protected final void setTitleBarBackgroundColor(@ColorInt int color) {
        titleBar.setBackgroundColor(color);
    }

    protected final void setTitleBarName(@NonNull String name) {
        title_name.setText(name);
    }

    protected final void setTitleBarNameColor(@ColorInt int color) {
        title_name.setTextColor(color);
    }

    @Override
    protected void onDestroy() {
        requestQueue.stop();
        super.onDestroy();
    }
}
