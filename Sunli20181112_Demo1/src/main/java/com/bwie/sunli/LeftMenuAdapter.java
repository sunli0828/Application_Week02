package com.bwie.sunli;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class LeftMenuAdapter extends BaseAdapter {

    private String[] menus = new String[]{
            "首页", "视频", "我的"
    };

    private Context context;

    public LeftMenuAdapter(Context context) {
        this.context = context;
    }

    @Override
    public int getCount() {
        return menus.length + 1;
    }

    private final int ITEM_COUNT = 2;
    private final int IMAGE_TYPE = 0;
    private final int TEXT_TYPE = 1;

    @Override
    public int getItemViewType(int position) {
        return position == 0 ? IMAGE_TYPE : TEXT_TYPE;
    }

    @Override
    public String getItem(int position) {
        if (position == 0) {
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
            convertView = LayoutInflater.from(context)
                    .inflate(getItemViewType(position) == IMAGE_TYPE ? R.layout.menu_image_item : R.layout.menu_text_item,
                            parent, false);
            holder = new ViewHolder(convertView);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }

        if (getItemViewType(position) == TEXT_TYPE) {
            holder.bindData(getItem(position));
        }
        return convertView;
    }

    class ViewHolder {
        ImageView imageView;
        TextView textView;
        public ViewHolder(View itemView) {
            imageView = itemView.findViewById(R.id.icon);
            textView = itemView.findViewById(R.id.text);
            itemView.setTag(this);
        }

        public void bindData(String text) {
            textView.setText(text);
        }

        public void displayIcon() {

        }
    }
}
