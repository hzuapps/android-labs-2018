package com.example.asus.soft1614080902206;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.Log;

import com.squareup.okhttp.*;


import java.io.*;
import java.util.List;

/**
 * Created by asus on 2018/4/27.
 */

public class LoginServer {
    String loginStr = "";
    String myUrl;
    String number;
    String password;
    String cookie;
    String s;

    /*
    返回值说明：
    -1：网络连接错误
    0：密码错误
    -2：密码错误
    */
    public int Connect(String number, String password) {
        this.number = number;
        this.password = password;
        String _VIEWSTATE = "";
        try {
            //获取教务系统页面
            loginStr = HttpDatasend.sendGet("http://202.192.224.156/jwweb/index.aspx");
            //获取SessionId
            myUrl = Value.URL;
            int d = myUrl.indexOf(")");
            myUrl = myUrl.substring(0, d + 1);
        } catch (IOException ex) {
            return -1;
        }
        if (loginStr == "")
            return -1;
        if (loginStr == null)
            return -2;
        int error = loginStr.indexOf("服务器太忙");
        if (error != -1)
            return -2;
        if (loginStr != "") {
            int startIndex = loginStr.indexOf("");//viewstate开始的地方
            int endIndex = loginStr.indexOf("");//viewstate结束的地方
            loginStr = loginStr.substring(startIndex + 18, loginStr.length());
            _VIEWSTATE = loginStr;
        }
        try {
            //转化为utf-8编码
            _VIEWSTATE = java.net.URLEncoder.encode(_VIEWSTATE, "utf-8");
        } catch (UnsupportedEncodingException e1) {
            return -1;
        }
        //合成post请求
        String sendStr = "_VIEWSTATE=" + _VIEWSTATE + "&TextBox1=" + this.number + "&TextBox2";
        return 1;
    }

    private void ChangeImage() {
        OkHttpClient okHttpClient = new OkHttpClient();
        Request request = new Request.Builder()
                .url("http://222.24.62.120/CheckCode.aspx")
                .build();
        Call call = okHttpClient.newCall(request);
        call.enqueue(new Callback() {

            public void onFailure(Request request, IOException e) {
                Log.i("info_callFailure", e.toString());
            }

            public void onResponse(Response response) throws IOException {
                byte[] byte_image = response.body().bytes();


                //把字节数组转化为bitmap


                //session
                Headers headers = response.headers();
                List<String> cookies = headers.values("Set-Cookie");
                String session = cookies.get(0);
                cookie = cookies.toString();
                s = session.substring(0, session.indexOf(";"));
            }
        });
    }
}
