package com.bwie.sunli;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import me.maxwin.view.XListView;

public class FragmentA extends Fragment {

    private XListView newsList;
    private int mPage;
    private final int LOAD_COUNT = 10;
    private FragmentAdapter adapter;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragmenta, container, false);

        newsList = view.findViewById(R.id.newsList);

        mPage = 1;
        adapter = new FragmentAdapter(getContext());
        newsList.setAdapter(adapter);

        newsList.setPullRefreshEnable(true);
        newsList.setPullLoadEnable(true);

        newsList.setXListViewListener(new XListView.IXListViewListener() {
            @Override
            public void onRefresh() {
                mPage = 1;
                //loadData();
            }

            @Override
            public void onLoadMore() {
                mPage ++;
               // loadData();
            }
        });
        //loadData();
        return view;
    }
    /*private void loadData() {
        NetUtils.getInstance().getRequest(String.format(urlStr, LOAD_COUNT, mPage),
            FragmentBean.class, new NetUtils().CallBack<FragmentBean>(){
                @Override
                public void onSuccess(FragmentBean fragmentBean) {
                    if (mPage == 1) {
                        adapter.setDatas(fragmentBean.getResult());
                    } else {
                        adapter.addDatas(fragmentBean.getResult());
                    }
                    newsList.stopLoadMore();
                    newsList.stopRefresh();
                    if (fragmentBean.getResult().size() < LOAD_COUNT) {
                        newsList.setPullLoadEnable(false);
                    }
                }
            });
    }*/
    private String urlStr = "http://api.expoon.com/AppNews/getNewsList/type/1/p/1";
}
