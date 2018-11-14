package application_week02.application_week02;

import android.annotation.SuppressLint;
import android.os.AsyncTask;

import com.google.gson.Gson;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class Util {

    //06 定义一个本类中的单例 变量
    private static Util instance;

    public Util() {
    }

    //获取 此这方法的单例
    public static Util getInstance() {

        //如果自定的单例变量为空 就把此方法中的单例值给它
        if (instance == null) {
            instance = new Util();
        }
        return instance;
    }
    //04 自定义接口  接口类型为你需要的类型
    public interface Callback<T> {
        void onSuccess(T t);
    }

    //05 定义一个 带有接口回调的方法
    //1. 解析用 2.自定义的Class 类 3. 实例化接口
    @SuppressLint("StaticFieldLeak")
    public void getRequest(final String urlStr, final Class clazz, final Callback callback) {
        new AsyncTask<String, Void, Object>() {
            @Override
            protected Object doInBackground(String... strings) {
                return getRequest(urlStr, clazz);
            }

            @Override
            protected void onPostExecute(Object o) {
                callback.onSuccess(o);
            }
        }.execute(urlStr);
    }

    //03 自定义一个带有Class 类的方法 此方法中调用 01方法
    public <T> T getRequest(String urlStr, Class clazz) {
        
        String request = getRequest(urlStr);

        T t = (T) new Gson().fromJson(request, clazz);

        return t;
    }

    //01第一个方法 就是用来解析Gson
    public String getRequest(String urlStr) {
        String result = "";
        try {
            URL url = new URL(urlStr);
            HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
            urlConnection.setRequestMethod("GET");
            urlConnection.setConnectTimeout(5000);
            urlConnection.setReadTimeout(5000);

            int responseCode = urlConnection.getResponseCode();

            if(responseCode == 200) {
                InputStream inputStream = urlConnection.getInputStream();

                result = stream2String(inputStream);
                return result;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
    //02用来转换
    private String stream2String(InputStream is) throws IOException {
        StringBuilder sb = new StringBuilder();
        BufferedReader br = new BufferedReader(new InputStreamReader(is));
        for (String tmp = br.readLine(); tmp != null; tmp = br.readLine()) {
            sb.append(tmp);
        }
        return sb.toString();
    }
}
