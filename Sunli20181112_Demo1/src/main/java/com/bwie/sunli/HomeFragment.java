package com.bwie.sunli;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class HomeFragment extends Fragment {
    private TabLayout tabLayout;
    private ViewPager contents;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_home, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        tabLayout = view.findViewById(R.id.top_indicator);
        contents = view.findViewById(R.id.contents);
        //
        //Fragment嵌套Fragment，使用getChildFragmentManager()
        //getFragmentManager();
        contents.setAdapter(new HomeFragmentAdapter(getChildFragmentManager()));
        //TableLayout

        tabLayout.setupWithViewPager(contents);

        //FragmentActivity; Fragment 3.0//封装了Fragment, 让你在低版本Android上能用
        //
        //AppCompatActivity;//封闭了ActionBar
    }
}
