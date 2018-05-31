package edu.hzuapps.androidlabs.soft1613090502218.soft1613090502218;

import android.util.Log;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class getData {
    private String text;
    public void getJSON() {
        Thread thread=new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    //你的URL
                    String url_s = "https://raw.githubusercontent.com/ChenYHeng/android-labs-2018/master/Soft1613090502218/test2.json";
                    URL url = new URL(url_s);
                    System.out.println("url创建成功");
                    HttpURLConnection conn = (HttpURLConnection) url.openConnection();
                    conn.setRequestMethod("GET");
                    System.out.println("HttpURLConnection连接属性");
                    //设置连接属性。不喜欢的话直接默认也阔以
                    conn.setConnectTimeout(5000);//设置超时
                    System.out.println("超时");
                    conn.setUseCaches(false);//数据不多不用缓存了
                    System.out.println("connect");
                    // 这里连接了
                    conn.connect();
                    System.out.println("连接");
                    //这里才真正获取到了数据
                    InputStream inputStream = conn.getInputStream();
                    InputStreamReader input = new InputStreamReader(inputStream);
                    System.out.println("流");
                    BufferedReader buffer = new BufferedReader(input);
                    if (conn.getResponseCode() == 200) {//200意味着返回的是"OK"
                        String inputLine;
                        StringBuilder resultData = new StringBuilder();//StringBuffer字符串拼接很快
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
        thread.start();
        try {
            thread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    public String getText(){
        return text;
    }
}
