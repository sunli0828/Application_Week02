package com.bwie.sunli20181127;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.bwie.sunli20181127.bean.GoodsBean;
import com.bwie.sunli20181127.utils.NetworkUtils;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.youth.banner.Banner;
import com.youth.banner.BannerConfig;
import com.youth.banner.loader.ImageLoaderInterface;

public class MainActivity extends AppCompatActivity {

    private String urlStr = "https://www.zhaoapi.cn/product/getProductDetail?pid=1";
    private Banner banner_image;
    private TextView text_name, text_cost, text_now;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        banner_image = findViewById(R.id.banner_image);
        text_name = findViewById(R.id.text_name);
        text_cost = findViewById(R.id.text_cost);
        text_now = findViewById(R.id.text_now);

        initData();

        banner_image.setBannerStyle(BannerConfig.CIRCLE_INDICATOR);
        banner_image.setImageLoader(new ImageLoaderInterface<ImageView>() {
            @Override
            public void displayImage(Context context, Object path, ImageView imageView) {
                GoodsBean.DataBean bean = (GoodsBean.DataBean) path;
                ImageLoader.getInstance().displayImage(bean.getImages(), imageView);
            }

            @Override
            public ImageView createImageView(Context context) {
                ImageView imageView = new ImageView(context);
                imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
                return imageView;
            }
        });
    }

    private void initData() {

        NetworkUtils.getInstance().getRequest(urlStr, GoodsBean.class, new NetworkUtils.Callback<GoodsBean>() {
            @Override
            public void onSuccess(GoodsBean o) {
             //   banner_image.setImages(o.getData());
                banner_image.start();
            }
        });

    }
}
