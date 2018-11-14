package com.bwie.sunli;


import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

public class MainAdapter extends FragmentPagerAdapter {

    private String[] menus = new String[] {"首页", "视频", "我的"};

    public MainAdapter(FragmentManager fm) { super(fm); }

    @Override
    public Fragment getItem(int i) {
        switch (i) {
            case 0:
                return new HomeFragment();
            case 1:
                return new VideoFragment();
            case 2:
                return new MineFragment();
            default:
                return new OtherFragment();
        }
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return menus[position];
    }

    @Override
    public int getCount() {
        return menus.length;
    }
}
