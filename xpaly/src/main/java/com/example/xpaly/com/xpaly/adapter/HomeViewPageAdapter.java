package com.example.xpaly.com.xpaly.adapter;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import java.util.List;

/**
 * @创建者 tw
 * @创建时间 2019/12/6
 * @描述
 */
public class HomeViewPageAdapter extends FragmentPagerAdapter {
    private List<Fragment> fragments;
    public HomeViewPageAdapter(@NonNull FragmentManager fm,List<Fragment> fragments) {
        super(fm);
        this.fragments =fragments;

    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        return fragments.get(position);
    }

    @Override
    public int getCount() {
        return fragments.size();
    }
}
