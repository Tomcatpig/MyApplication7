package com.example.connect;

import androidx.appcompat.app.AppCompatActivity;

import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import com.example.connect.com.example.fragment.CloudLinkFragment;
import com.example.connect.com.example.fragment.LocalLinkFragment;

public class WatchLinkActivity extends AppCompatActivity implements
        LocalLinkFragment.OnFragmentInteractionListener,
        CloudLinkFragment.OnFragmentInteractionListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_watch_link);
        getSupportActionBar().hide();
        initView();
    }

    public void initView() {
        ImageButton goBack = findViewById(R.id.search_actionbar_goBack);
        goBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }


    @Override
    public void onFragmentInteraction(Uri uri) {

    }
}
