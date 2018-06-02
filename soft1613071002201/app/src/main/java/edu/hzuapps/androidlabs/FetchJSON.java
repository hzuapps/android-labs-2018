package edu.hzuapps.androidlabs;

import android.util.Log;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class FetchJSON {

    String text;

    //新开子线程联网获取JSON数据
    public String getJson() {
        Thread get=new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    //你的URL
                    String url_s = "https://raw.githubusercontent.com/zhaokangye/android-labs-2018/master/soft1613071002201/test.json";
                    URL url = new URL(url_s);
                    HttpURLConnection conn = (HttpURLConnection) url.openConnection();
                    //设置连接属性。不喜欢的话直接默认也阔以
                    conn.setConnectTimeout(5000);//设置超时
                    conn.setUseCaches(false);//数据不多不用缓存了

                    //这里连接了
                    conn.connect();
                    //这里才真正获取到了数据
                    InputStream inputStream = conn.getInputStream();
                    InputStreamReader input = new InputStreamReader(inputStream);
                    BufferedReader buffer = new BufferedReader(input);
                    if (conn.getResponseCode() == 200) {//200意味着返回的是"OK"
                        String inputLine;
                        StringBuffer resultData = new StringBuffer();//StringBuffer字符串拼接很快
                        while ((inputLine = buffer.readLine()) != null) {
                            resultData.append(inputLine);
                        }
                        text = resultData.toString();
                        Log.v("输出获取的json", text);
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
        get.start();
        //等待线程执行完成
        try {
            get.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return text;
    }
}
