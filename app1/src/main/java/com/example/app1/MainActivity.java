package com.example.app1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private Button btn_add, btn_find, btn_delete, btn_update,btn_clear;
    private EditText edit_name;
    private EditText edit_number;
    private TextView textView_show;
    private MySqlHelper mySqlHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //初始化控件
        init();
        mySqlHelper = new MySqlHelper(this);

    }

    //初始化控键
    public void init() {
        btn_add = findViewById(R.id.btn_add);
        btn_delete = findViewById(R.id.btn_delete);
        btn_find = findViewById(R.id.btn_find);
        btn_update = findViewById(R.id.btn_update);
        edit_name = findViewById(R.id.edit_name);
        edit_number = findViewById(R.id.edit_number);
        textView_show=findViewById(R.id.text_show);
        btn_clear = findViewById(R.id.btn_clear);

        //设置监听
        btn_update.setOnClickListener(new ButtonListener());
        btn_find.setOnClickListener(new ButtonListener());
        btn_delete.setOnClickListener(new ButtonListener());
        btn_add.setOnClickListener(new ButtonListener());
        btn_clear.setOnClickListener(new ButtonListener());
    }

    //按钮监听内部类
    private class ButtonListener implements View.OnClickListener {
        @Override
        public void onClick(View v) {
            switch (v.getId()) {
                case R.id.btn_add:
                    addData();
                    break;
                case R.id.btn_delete:
                    delete();
                    break;
                case R.id.btn_find:
                    find();
                    break;
                case R.id.btn_update:
                    update();
                    break;
                case R.id.btn_clear:
                    textView_show.setText("数据");
            }
        }
    }


    //插入数据add
    public void addData() {
        String name = edit_name.getText().toString().trim();
        String number = edit_number.getText().toString().trim();
        SQLiteDatabase db = mySqlHelper.getWritableDatabase();
        if (name != null && !name.equals("") && number != null && !number.equals("")) {

            String sql = "insert into person (name,number) values (?,?)";
            db.execSQL(sql, new Object[]{name, number});
            db.close();
            Toast.makeText(MainActivity.this, "插入数据" + name + "和" + number, Toast.LENGTH_SHORT).show();
        } else {

            Toast.makeText(MainActivity.this, "请输入name和number", Toast.LENGTH_SHORT).show();
        }

    }

    //查找数据
    public void find() {
        String name = edit_name.getText().toString().trim();
        SQLiteDatabase db = mySqlHelper.getWritableDatabase();
        List<User> users = new ArrayList<>();
        if (name != null && !name.equals("")) {
            Cursor cursor = db.query("person", null, "name=?",
                    new String[]{name}, null, null, null);

            while (cursor.moveToNext()) {
                User user = new User();
                user.setId(cursor.getInt(0));
                user.setName(cursor.getString(1));
                user.setNumber(cursor.getString(2));
                users.add(user);
            }
            cursor.close();
            db.close();
            if (users != null) {
                for (User user : users) {
                    textView_show.setText(textView_show.getText() + user.toString()+"||");
                }
            }

        } else {
            Toast.makeText(MainActivity.this, "请输入name", Toast.LENGTH_SHORT).show();
        }

    }

    //删除数据
    public void delete() {
        SQLiteDatabase db=mySqlHelper.getWritableDatabase();
        String name= edit_name.getText().toString().trim();
        if (name!=null&&!name.equals("")){
            String sql="delete from person where name=?";
            db.execSQL(sql,new Object[]{name});
            db.close();
        }else {
            Toast.makeText(MainActivity.this, "请输入name", Toast.LENGTH_SHORT).show();
        }
    }


    //更新数据
    public void update() {
        String name = edit_name.getText().toString().trim();
        String number = edit_number.getText().toString().trim();
        SQLiteDatabase db=mySqlHelper.getWritableDatabase();
        ContentValues values  = new ContentValues();
        if (name != null && !name.equals("") && number != null && !number.equals("")) {

           values.put("number",number);
            db.update("person",values,"name=?", new String[]{name});
            db.close();
            Toast.makeText(MainActivity.this, "更新数据" + name + "和" + number, Toast.LENGTH_SHORT).show();
        } else {

            Toast.makeText(MainActivity.this, "请输入name和number", Toast.LENGTH_SHORT).show();
        }
    }

}
