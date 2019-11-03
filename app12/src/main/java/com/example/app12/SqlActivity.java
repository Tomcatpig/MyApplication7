package com.example.app12;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.user.utils.DataBaseUtils;
import com.user.utils.Info;
import com.user.utils.SPUtils;
import com.user.utils.ToastShow;

import java.util.List;
import java.util.Map;

public class SqlActivity extends AppCompatActivity {
    TextView sql_show;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sql);
        initView();
    }

    private void initView() {
        Button sql_delete = findViewById(R.id.sql_delete);
        Button sql_insert = findViewById(R.id.sql_insert);
        Button sql_query = findViewById(R.id.sql_query);
        Button sql_queryAll = findViewById(R.id.sql_queryAll);
        Button sql_update = findViewById(R.id.sql_update);
        sql_show = findViewById(R.id.sql_show);

        sql_delete.setOnClickListener(new ButtonListener());
        sql_insert.setOnClickListener(new ButtonListener());
        sql_query.setOnClickListener(new ButtonListener());
        sql_queryAll.setOnClickListener(new ButtonListener());
        sql_update.setOnClickListener(new ButtonListener());

    }

    private class ButtonListener implements View.OnClickListener {
        @Override
        public void onClick(View v) {

            switch (v.getId()) {
                case R.id.sql_delete:
                    DataBaseUtils.deleteData(SqlActivity.this, "tom");
                    break;
                case R.id.sql_insert:
                    DataBaseUtils.insertData(SqlActivity.this, "tom", "123");

                    break;

                case R.id.sql_query:
                    List<Info> infos = DataBaseUtils.query(SqlActivity.this, "pig");
                    if (infos.size() != 0) {

                        for (Info info : infos) {
                            sql_show.setText(sql_show.getText()+info.toString());
                        }
                    }
                    break;
                case R.id.sql_update:
                    DataBaseUtils.upDate(SqlActivity.this, "tom", "1234","pig");
                    break;

            }
        }
    }
}
