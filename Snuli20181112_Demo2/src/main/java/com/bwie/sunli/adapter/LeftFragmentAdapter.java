package com.bwie.sunli.adapter;

import android.content.Context;
import android.support.v4.app.FragmentPagerAdapter;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

public class LeftFragmentAdapter extends BaseAdapter {

    private String[] menus = new String[]{"首页", "视频", "我的"};
    private Context context;

    public LeftFragmentAdapter(Context context) {
        this.context = context;
    }

    @Override
    public int getCount() {
        return menus.length + 1;
    }

    private final int IMAGE_TYPE = 0;
    private final int TEXT_TYPE = 1;

    @Override
    public int getItemViewType(int position) {
        return position == 0 ? IMAGE_TYPE : TEXT_TYPE;
    }

    @Override
    public String getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        return null;
    }
}
