package com.bwie.sunli;

import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.FrameLayout;

import com.bwie.sunli.adapter.MainAdapter;

public class MainActivity extends AppCompatActivity {

    private DrawerLayout drawer;
    private TabLayout bottom_indicator;
    private ViewPager contents;
    private ActionBarDrawerToggle toggle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        drawer = findViewById(R.id.drawer);
        bottom_indicator = findViewById(R.id.bottom_indicator);

        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction().add(R.id.drawer_left, new LeftFragment()).commit();
        }

        initView();
        initData();
    }

    private void initData() {
    }

    private void initView() {
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        drawer = findViewById(R.id.drawer);

        toggle = new ActionBarDrawerToggle(this, drawer, R.string.open_drawer, R.string.close_drawer);

        drawer.addDrawerListener(toggle);

        toggle.syncState();

        contents = findViewById(R.id.contents);

        contents.setAdapter(new MainAdapter(getSupportFragmentManager()));


    }
}
