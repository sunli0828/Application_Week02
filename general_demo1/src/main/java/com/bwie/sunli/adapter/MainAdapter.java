package com.bwie.sunli.adapter;

import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.bwie.sunli.HomeFragment;
import com.bwie.sunli.MessageFragment;
import com.bwie.sunli.OtherFragment;
import com.bwie.sunli.VideoFragment;

public class MainAdapter extends FragmentPagerAdapter {

    private String[] menus = new String[]{"首页", "视频", "消息", "其他"};

    public MainAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int i) {
        switch (i) {
            case 0:
                return new HomeFragment();
            case 1:
                return new VideoFragment();
            case 2:
                return new MessageFragment();
            case 3:
                return new OtherFragment();
            default:
                return new HomeFragment();
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
