package com.example.xpaly.com.xpaly.adapter;

import android.content.Context;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import java.util.List;

/**
 * @创建者 tw
 * @创建时间 2019/12/6
 * @描述
 */
public class RVAdapter extends FragmentPagerAdapter {
    private String[] titles=new String[]{"片单","热剧","电影","综艺","动漫"};
    private List<Fragment> fragments;
    public RVAdapter(@NonNull FragmentManager fm, int behavior,List<Fragment> fragments) {
        super(fm, behavior);
        this.fragments = fragments;


    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        Log.e("Tag","fragment "+position);
        return fragments.get(position);
    }

    @Override
    public int getCount() {
        return fragments.size();
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return titles[position];
    }
}
