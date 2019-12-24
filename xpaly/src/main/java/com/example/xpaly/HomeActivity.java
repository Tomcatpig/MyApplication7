package com.example.xpaly;

import android.net.Uri;
import android.os.Bundle;

import com.example.xpaly.com.xpaly.adapter.HomeViewPageAdapter;
import com.example.xpaly.com.xpaly.fragment.CatalogFragment;
import com.example.xpaly.com.xpaly.fragment.DiscoveryFragment;
import com.example.xpaly.com.xpaly.fragment.HotAnimeFragment;
import com.example.xpaly.com.xpaly.fragment.HotMovieFragment;
import com.example.xpaly.com.xpaly.fragment.HotTVFragment;
import com.example.xpaly.com.xpaly.fragment.HotVarietyShowFragment;
import com.example.xpaly.com.xpaly.fragment.MineFragment;
import com.example.xpaly.com.xpaly.fragment.PianDanFragment;
import com.example.xpaly.com.xpaly.fragment.TestFragment;
import com.example.xpaly.com.xpaly.utils.ToastShow;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class HomeActivity extends AppCompatActivity implements TestFragment.OnFragmentInteractionListener,
        RecomendFragment.OnFragmentInteractionListener,
        CatalogFragment.OnFragmentInteractionListener,
        DiscoveryFragment.OnFragmentInteractionListener,
        MineFragment.OnFragmentInteractionListener,
        PianDanFragment.OnFragmentInteractionListener,
        HotTVFragment.OnFragmentInteractionListener ,
        HotMovieFragment.OnFragmentInteractionListener ,
        HotVarietyShowFragment.OnFragmentInteractionListener,
        HotAnimeFragment.OnFragmentInteractionListener {
    private List<Fragment> fragments = new ArrayList<>();
    private ViewPager viewPager;
    private long exitTime;

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_home:
                    viewPager.setCurrentItem(0);
                    return true;
                case R.id.navigation_dashboard:
                    viewPager.setCurrentItem(1);
                    return true;
                case R.id.navigation_notifications:
                    viewPager.setCurrentItem(2);
                    return true;
                case R.id.navigation_mine:
                    viewPager.setCurrentItem(3);
                    return true;
            }
            return false;
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        BottomNavigationView navView = findViewById(R.id.nav_view);
        navView.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
        if (getSupportActionBar() != null) {
            getSupportActionBar().hide();
        }
        initView();

    }

    public void initView() {
        fragments.add(new RecomendFragment());
        fragments.add(new CatalogFragment());
        fragments.add(new DiscoveryFragment());
        fragments.add(new MineFragment());
        viewPager = findViewById(R.id.viewPage_home);
        viewPager.setAdapter(new HomeViewPageAdapter(getSupportFragmentManager(), fragments));
        viewPager.setCurrentItem(0);
        viewPager.setOffscreenPageLimit(4);
        viewPager.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                return true;
            }
        });

    }

    @Override
    public void onFragmentInteraction(Uri uri) {

    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {

        if(keyCode==event.KEYCODE_BACK){
            isExitSystem();
            return false;
        }
        return super.onKeyDown(keyCode, event);
    }

    private void isExitSystem() {
        if (System.currentTimeMillis()-exitTime<2000){
            finish();
        }else {
            exitTime =System.currentTimeMillis();
            ToastShow.shortToast(this,"再按一次退出");
        }
    }
}
