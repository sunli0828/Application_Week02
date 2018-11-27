package com.bwie.sunli20181127.utils;

import android.os.AsyncTask;

import com.google.gson.Gson;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class NetworkUtils {

    //单例模式
    private static NetworkUtils instance;

    public NetworkUtils(){}

    public static NetworkUtils getInstance() {
        if (instance == null) {
            instance = new NetworkUtils();
        }
        return instance;
    }

    //定义一个接口
    public interface Callback<T> {
        void onSuccess(T t);
    }

    public void getRequest(final String urlStr, final Class clazz, final Callback callback) {
        new AsyncTask<String, Void, Object>(){
            @Override
            protected Object doInBackground(String... strings) {
                return getRequset(urlStr, clazz);
            }

            @Override
            protected void onPostExecute(Object o) {
                callback.onSuccess(o);
            }
        }.execute(urlStr);
    }

    public <T> T getRequset(String urlStr, Class clazz) {
        return (T)new Gson().fromJson(getRequset(urlStr), clazz);
    }

    //网络请求
    public String getRequset(String urlStr) {
        String result = "";

        try {
            URL url = new URL(urlStr);
            HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
            urlConnection.setRequestMethod("GET");
            urlConnection.setConnectTimeout(5000);
            urlConnection.setReadTimeout(5000);
            int responseCode = urlConnection.getResponseCode();
            if (responseCode == 200) {
                result = stream2String(urlConnection.getInputStream());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return result;
    }

    private String stream2String(InputStream is) throws IOException {
        StringBuilder sb = new StringBuilder();
        BufferedReader br = new BufferedReader(new InputStreamReader(is));
        for (String tmp = br.readLine(); tmp != null; tmp = br.readLine()) {
            sb.append(tmp);
        }
        return sb.toString();
    }
}
