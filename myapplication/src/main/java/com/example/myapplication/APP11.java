package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.app.Dialog;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.KeyEvent;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.Toast;

public class APP11 extends AppCompatActivity {
    private long currentTime = 0;
    private Button btn_confirm, login;
    private Button btn_cancle;
    private AlertDialog dialog;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_app11);
        login = findViewById(R.id.button2);
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                click();
            }
        });
    }


    public void click() {
        dialog = new AlertDialog.Builder(APP11.this).create();
        dialog.show();
        Window window = dialog.getWindow();
        window.setGravity(Gravity.CENTER);
        window.setWindowAnimations(R.style.dialog_anim);
        window.setContentView(R.layout.dialog);
        btn_cancle = window.findViewById(R.id.cancel);
        btn_confirm =window.findViewById(R.id.confirm);
        btn_confirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
                finish();
            }
        });
        btn_cancle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
            }
        });

    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == event.KEYCODE_BACK) {
            exit();
            return false;
        }

        return super.onKeyDown(keyCode, event);
    }

    public void exit() {
        if (System.currentTimeMillis() - currentTime < 3000) {
            finish();
            System.exit(0);
        } else {

            Toast.makeText(APP11.this, "再按一次返回键退出", Toast.LENGTH_LONG).show();
            currentTime = System.currentTimeMillis();
        }

    }
}
