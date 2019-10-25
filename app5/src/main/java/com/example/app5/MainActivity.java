package com.example.app5;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Environment;
import android.util.Xml;
import android.view.View;
import android.widget.Toast;

import com.kjksjak.sas.User;

import org.xmlpull.v1.XmlSerializer;

import java.io.File;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private List<User> userList = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        userList = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            User user = new User(i + "", "sasa" + i, "123" + i + i + i);
            userList.add(user);
        }


    }

    public void click(View view) {
        try {
            XmlSerializer xmlSerializer = Xml.newSerializer();
            File file = new File(Environment.getExternalStorageDirectory(), "person.xml");
            FileOutputStream fos = new FileOutputStream(file);
            xmlSerializer.setOutput(fos, "utf-8");
            xmlSerializer.startDocument("utf-8", true);
            xmlSerializer.startTag(null, "persons");
            int count = 0;
            for (User user : userList) {
                xmlSerializer.startTag(null, "person");
                xmlSerializer.attribute(null, "id", count + "");

                xmlSerializer.startTag(null, "uId");
                xmlSerializer.text(user.getUserId());
                xmlSerializer.endTag(null, "uId");


                xmlSerializer.startTag(null, "uName");
                xmlSerializer.text(user.getUserName());
                xmlSerializer.endTag(null, "uName");


                xmlSerializer.startTag(null, "uPwd");
                xmlSerializer.text(user.getUserPwd());
                xmlSerializer.endTag(null, "uPwd");


                xmlSerializer.endTag(null, "person");
                count++;
            }
            xmlSerializer.endTag(null, "persons");
            xmlSerializer.endDocument();
            xmlSerializer.flush();
            fos.close();
            Toast.makeText(MainActivity.this, "保存成功", Toast.LENGTH_SHORT).show();
        } catch (Exception e) {
            e.printStackTrace();

            Toast.makeText(MainActivity.this, "保存失败", Toast.LENGTH_SHORT).show();

        }

    }


}
