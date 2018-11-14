package com.bwie.sunli;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class FragmentAdapter extends BaseAdapter {

    //优化
    //属性私有化
    private List<FragmentBean.Data> mDatas;
    private Context context;

    //有参构造
    public FragmentAdapter(Context context) {
        this.context = context;
        mDatas = new ArrayList<>();
    }
    public void setDatas(List<FragmentBean.Data> datas) {
        //清空
        mDatas.clear();
        //添加数据
        mDatas.addAll(datas);
        notifyDataSetChanged();
    }
    //上拉加载
    public void addDatas(List<FragmentBean.Data> datas) {
        //直接追加
        mDatas.addAll(datas);
        notifyDataSetChanged();
    }
    @Override
    public int getCount() {
        return mDatas.size();
    }

    @Override
    public FragmentBean.Data getItem(int position) {
        return mDatas.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;

        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(R.layout.list_item, parent, false);
            holder = new ViewHolder();
            //获取资源ID
            holder.text_title = convertView.findViewById(R.id.text_title);
            holder.text_summary = convertView.findViewById(R.id.text_summary);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }
        //赋值
            holder.text_title.setText(mDatas.get(position).getNews_title());
            holder.text_summary.setText(mDatas.get(position).getNews_summary());
        return convertView;
    }

    class ViewHolder {
        TextView text_title,text_summary;
    }
}
