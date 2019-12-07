package com.example.xpaly;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        if (getSupportActionBar()!=null){
            getSupportActionBar().hide();
        }
        initView();
    }
    public void initView(){
        Button button =findViewById(R.id.return_homeActivity);
        button.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.return_homeActivity:
                startActivity(new Intent(MainActivity.this,HomeActivity.class));
                finish();
        }
    }
}
