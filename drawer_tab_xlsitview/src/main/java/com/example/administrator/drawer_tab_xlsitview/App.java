package com.example.administrator.drawer_tab_xlsitview;

import android.app.Application;

import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;
import com.nostra13.universalimageloader.core.display.RoundedBitmapDisplayer;

public class App extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        ImageLoader.getInstance().init(
                new ImageLoaderConfiguration.Builder(this)
                        .defaultDisplayImageOptions(
                                new DisplayImageOptions.Builder()

                                .build()
                        )
                        .build()
        );
    }
}
