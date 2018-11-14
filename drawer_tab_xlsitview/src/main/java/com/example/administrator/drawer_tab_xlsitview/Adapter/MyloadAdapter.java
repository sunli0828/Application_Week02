package com.example.administrator.drawer_tab_xlsitview.Adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.administrator.drawer_tab_xlsitview.MyloaddataBean;
import com.example.administrator.drawer_tab_xlsitview.R;
import com.nostra13.universalimageloader.core.ImageLoader;

import java.util.ArrayList;
import java.util.List;

public class MyloadAdapter extends BaseAdapter {

    private static final int COUNTS = 2;
    private Context context;
    private List<MyloaddataBean.Data> list;

    public MyloadAdapter(Context context) {
        this.context = context;
        list = new ArrayList<>();
    }

    //001 得到布局的数量
    @Override
    public int getViewTypeCount() {
        return COUNTS;
    }

    //002
    @Override
    public int getItemViewType(int position) {
        return position%2;
    }

    //刷新
    public void setList(List<MyloaddataBean.Data> lists) {

            list.clear();
            list.addAll(lists);

        notifyDataSetChanged();
    }
    //追加用的
    public void addList(List<MyloaddataBean.Data> lists) {

        list.addAll(lists);
        notifyDataSetChanged();
    }
    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public MyloaddataBean.Data getItem(int position) {
        return list.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    private static final int IMAGE_TYPE = 1;
    private static final int TEXT_TYPE = 0;

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder;
        if (convertView==null) {
            convertView = View.inflate(context,
                    getItemViewType(position) == TEXT_TYPE ? R.layout.item01 : R.layout.item02,
                    null);
            viewHolder = new ViewHolder();
            //
            viewHolder.t101 =  convertView.findViewById(R.id.item01_title01);
            viewHolder.t102 =  convertView.findViewById(R.id.item01_title02);
            viewHolder.t201 =  convertView.findViewById(R.id.item02_title01);
            viewHolder.imageView =  convertView.findViewById(R.id.item02_image);
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }

        if (getItemViewType(position) == TEXT_TYPE) {
            viewHolder.t101.setText(list.get(position).getNews_id());
            viewHolder.t102.setText(list.get(position).getNews_title());
        }else if (getItemViewType(position) == IMAGE_TYPE) {
            viewHolder.t201.setText(list.get(position).getNews_summary());

            ImageLoader.getInstance().displayImage(list.get(position).getPic_url(),viewHolder.imageView);

        }

        return  convertView;

    }

    class ViewHolder {

        TextView t101,t102;

        TextView t201;
        ImageView imageView;
    }

}
