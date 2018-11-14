package com.example.administrator.drawer_tab_xlsitview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.administrator.drawer_tab_xlsitview.Adapter.MyloadAdapter;

import me.maxwin.view.XListView;

public class MainActivity extends AppCompatActivity {
    private int mPage;
    private XListView xListView;
    private MyloadAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        xListView = findViewById(R.id.main_xlist);
        adapter = new MyloadAdapter(this);
        xListView.setAdapter(adapter);
        //设置可扩展属性
        xListView.setPullLoadEnable(true);
        xListView.setPullRefreshEnable(true);
        mPage=1;
        //设置监听
        xListView.setXListViewListener(new XListView.IXListViewListener() {
            @Override
            public void onRefresh() {
                //目的在于 当你刷新的时候 删除掉你之前加载的东西
                mPage=1;
                LoadData();
            }

            @Override
            public void onLoadMore() {
                //目的在于 往后加载数据
                mPage++;
                LoadData();
            }
        });

        LoadData();

    }
    //路径
    private String urlStr="http://api.expoon.com/AppNews/getNewsList/type/1/p/%d";
    private void LoadData() {
        Util.getInstance().getRequest(String.format(urlStr, mPage), MyloaddataBean.class, new Util.Callback<MyloaddataBean>() {

            @Override
            public void onSuccess(MyloaddataBean myloaddataBean) {
                if(mPage==1){
                    adapter.setList(myloaddataBean.getData());
                }else{
                    adapter.addList(myloaddataBean.getData());
                }
                xListView.stopRefresh();
                xListView.stopLoadMore();
            }
        });
    }
}
