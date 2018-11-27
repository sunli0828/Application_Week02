package com.bwie.sunli20181127.utils;

import android.app.Application;

import com.bwie.sunli20181127.R;
import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;

public class App extends Application {

    @Override
    public void onCreate() {
        super.onCreate();

        ImageLoader.getInstance().init(new ImageLoaderConfiguration.Builder(this)
            .memoryCacheSizePercentage(10)
            .diskCacheSize(50*1024*1024)
            .defaultDisplayImageOptions(new DisplayImageOptions.Builder()
                .cacheOnDisk(true)
                .cacheInMemory(true)
                .showImageOnLoading(R.mipmap.ic_launcher)
                .showImageForEmptyUri(R.mipmap.ic_launcher)
                .showImageOnFail(R.mipmap.ic_launcher)
                .build()
            )
        .build());
    }
}
