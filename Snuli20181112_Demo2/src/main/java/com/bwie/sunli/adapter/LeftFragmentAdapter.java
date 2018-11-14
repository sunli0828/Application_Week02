package com.bwie.sunli.adapter;

import android.content.Context;
import android.support.v4.app.FragmentPagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bwie.sunli.R;

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
        return position == IMAGE_TYPE ? IMAGE_TYPE : TEXT_TYPE;
    }

    @Override
    public String getItem(int position) {
        if (position == IMAGE_TYPE) {
            return null;
        }
        return menus[position - 1];
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;

        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(
                    getItemViewType(position) == IMAGE_TYPE ? R.layout.menu_image_item : R.layout.menu_text_item, parent, false);
            holder = new ViewHolder();

            holder.text = convertView.findViewById(R.id.text);
            holder.icon = convertView.findViewById(R.id.icon);

            convertView.setTag(this);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }

        if (getItemViewType(position) == TEXT_TYPE) {
            holder.text = convertView.findViewById(R.id.text);
            holder.icon = convertView.findViewById(R.id.icon);
            holder.text.setText(getItem(position));
        }

        return convertView;
    }

    class ViewHolder {
        TextView text;
        ImageView icon;

    }
}
