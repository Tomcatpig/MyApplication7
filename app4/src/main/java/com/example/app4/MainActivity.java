package com.example.app4;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.io.FileInputStream;
import java.io.FileOutputStream;

public class MainActivity extends AppCompatActivity {
    private EditText ed_data;
    private Button bt_write;
    private Button bt_read;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ed_data = findViewById(R.id.editText1);
        bt_write = findViewById(R.id.button1);
        bt_read = findViewById(R.id.button2);
        bt_read.setOnClickListener(new ButtonListener());
        bt_write.setOnClickListener(new ButtonListener());

    }

    private class ButtonListener implements View.OnClickListener {
        @Override
        public void onClick(View v) {
            switch (v.getId()) {
                case R.id.button1:
                    String data = ed_data.getText().toString().trim();
                    FileOutputStream fos;
                    try {
                        fos = openFileOutput("data.text", Context.MODE_APPEND);
                        fos.write(data.getBytes());
                        fos.close();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    Toast.makeText(MainActivity.this, "保存成功", Toast.LENGTH_SHORT).show();
                    break;
                case R.id.button2:
                    String showStr = "";
                    try {
                        FileInputStream fis = openFileInput("data.text");
                        byte[] bytes = new byte[fis.available()];
                        fis.read(bytes);
                        showStr = new String(bytes,0,10);
                        fis.close();
                    } catch (Exception e) {
                        e.printStackTrace();

                    }
                    Toast.makeText(MainActivity.this, showStr, Toast.LENGTH_SHORT).show();
                    break;
                default:
                    break;
            }
        }
    }
}
