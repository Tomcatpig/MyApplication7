package com.example.app12;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentResolver;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.example.pojo.Message;
import com.user.utils.BackUpSms;
import com.user.utils.ToastShow;

import java.util.ArrayList;
import java.util.List;

public class CopyMessage extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_copy_messga);
        initView();
    }

    public  void initView(){
        Button copy_message = findViewById(R.id.copy_message);
        copy_message.setOnClickListener(new ButtonListener());

    }
    private class ButtonListener implements View.OnClickListener {
        @Override
        public void onClick(View v) {
            switch(v.getId()){
                case R.id.copy_message:
                    copyMessage();
                    break;

            }
        }


    }
    private void copyMessage() {
        Uri uri =Uri.parse("content://sms/");
        List<Message> messages = new ArrayList<>();
        ContentResolver contentResolver = getContentResolver();

        Cursor cursor = contentResolver.query(uri,new String[]{"address","date","type","body"},null,null,null);
        int i=1;
        while (cursor.moveToNext()){
            Message message = new Message();
            message.setAddress(cursor.getString(0));
            message.setBody(cursor.getString(3));
            message.setDate(cursor.getLong(1));
            message.setType(cursor.getInt(2));
            message.setId(i);
            Log.i("Message",message+"");
            messages.add(message);
            i++;
        }
        cursor.close();
        BackUpSms.backUpSms(messages,CopyMessage.this);

    }



}
