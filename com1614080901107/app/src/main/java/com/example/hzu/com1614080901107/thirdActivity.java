package com.example.hzu.com1614080901107;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class thirdActivity extends AppCompatActivity {
    String text;
    String d1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third);
        getJson();
    }

    public void getJson() {
        new Thread() {
            @Override
            public void run() {
                try {
                    String url_user = "https://raw.githubusercontent.com/liyanxian12/android-labs-2018/master/com1614080901107/dd.json";
                    URL url = new URL(url_user);
                    HttpURLConnection conn = (HttpURLConnection) url.openConnection();
                    conn.setConnectTimeout(5000);
                    conn.setUseCaches(false);
                    conn.connect();
                    InputStream inputStream = conn.getInputStream();
                    InputStreamReader input = new InputStreamReader(inputStream);
                    BufferedReader buffer = new BufferedReader(input);
                    if (conn.getResponseCode() == 200) {
                        String inputLine;
                        StringBuffer resultData = new StringBuffer();
                        while ((inputLine = buffer.readLine()) != null) {
                            resultData.append(inputLine);
                        }

                        text = resultData.toString();
                        System.out.println(text);
                        input.close();
                        inputStream.close();
                        Log.v("解析：", text);
                        parseJson();
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        ((TextView) findViewById(R.id.text_view)).setText(d1);


                    }
                });
            }
        }.start();
    }

    public void parseJson() {
        JSONObject Json1 = null;
        try {
            Json1 = new JSONObject(text);
            d1 = Json1.getString("d1");

        } catch (JSONException e) {
            e.printStackTrace();
            Log.v("Error", "出现错误！");
        }

    }
}

