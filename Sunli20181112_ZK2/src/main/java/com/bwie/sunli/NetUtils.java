package com.bwie.sunli;

import android.os.AsyncTask;
import com.google.gson.Gson;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import javax.security.auth.callback.Callback;

public class NetUtils {

    private Gson gson;
    private static NetUtils instance;

    private NetUtils() {
        gson = new Gson();
    }

    public static NetUtils getInstance() {
        if (instance == null) {
            instance = new NetUtils();
        }
        return instance;
    }

    public interface CallBack<T> {
        void onSuccess(T t);
    }

    public void getRequest(final String urlStr, final Class clazz, final Callback callback) {
        new AsyncTask<String, Void, Object>(){
            @Override
            protected Object doInBackground(String... strings) {
                return getRequest(urlStr, clazz);
            }

            @Override
            protected void onPostExecute(Object o) {
           //     callback.onSuccess(o);
            }
        }.execute(urlStr);
    }

    public  <T> T getRequest(String urlStr, Class clazz) {
        return (T) gson.fromJson(getRequest(urlStr),clazz);
    }

    public String getRequest(String urlStr) {
        String result = "";

        try {
            URL url = new URL(urlStr);
            HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
            urlConnection.setRequestMethod("GET");
            urlConnection.setConnectTimeout(5000);
            urlConnection.setReadTimeout(5000);
            int responseCode = urlConnection.getResponseCode();
            if (responseCode == 200) {
                return stream2String(urlConnection.getInputStream());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    private String stream2String(InputStream inputStream) throws IOException {
        InputStreamReader is = new InputStreamReader(inputStream);
        BufferedReader br = new BufferedReader(is);
        StringBuilder sb = new StringBuilder();
        for (String tmp = br.readLine(); tmp != null; tmp = br.readLine()){
            sb.append(tmp);
        }
        return sb.toString();
    }
}
