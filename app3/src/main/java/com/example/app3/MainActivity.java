package com.example.app3;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
private ProgressBar progressBar1;
private  ProgressBar progressBar2;
private  ProgressBar progressBar3;
private TextView textView1;
private TextView textView2;
private TextView textView3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView1=findViewById(R.id.tv_life);
        textView2 = findViewById(R.id.tv_speed);
        textView3 = findViewById(R.id.tv_attack);
         initProgressBar();
         Button button =findViewById(R.id.buy);
         button.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View v) {
                 updateProgressBar();
             }
         });
    }

    public void initProgressBar(){
        progressBar1 =findViewById(R.id.progressBar1);
        progressBar2 = findViewById(R.id.progressBar2);
        progressBar3 = findViewById(R.id.progressBar3);
        progressBar1.setMax(1000);
        progressBar2.setMax(1000);
        progressBar3.setMax(1000);
    }
    public void updateProgressBar(){
        progressBar1.setProgress(progressBar1.getProgress()+20);
        progressBar2.setProgress(progressBar2.getProgress()+20);
        progressBar3.setProgress(progressBar3.getProgress()+100);
        textView1.setText(progressBar1.getProgress()+"");
        textView2.setText(progressBar2.getProgress()+"");
        textView3.setText(progressBar3.getProgress()+"");

    }
}
