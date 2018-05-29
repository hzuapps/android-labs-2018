package com.example.administrator.soft1614080902231;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import org.json.JSONArray;
import org.json.JSONObject;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class ThreeActivity extends AppCompatActivity {
    private ArrayAdapter<String> adapter1;
    private ListView listView;
    private String text;
    private List<String> list=new ArrayList<String>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_three);
        init();
        getJson();
    }
    public void init() {
        listView=(ListView)findViewById(R.id.zhongchao);
    }
    public void getJson() {
        new Thread() {
            @Override
            public void run() {
                try {
                    //你的URL
                    String url_s = "https://raw.githubusercontent.com/zglx/android-labs-2018/master/soft1614080902231/informatian.json";
                    URL url = new URL(url_s);
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
                        Log.v("out---------------->", text);
                        parseJson();
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        adapter1 = new ArrayAdapter<String>(
                                ThreeActivity.this, android.R.layout.simple_list_item_1, list);
                        listView.setAdapter(adapter1);
                    }
                });
            }
        }.start();
    }

    public void parseJson() {
        try {
            JSONArray jsonArray = new JSONArray(text);
            for (int i = 0; i < jsonArray.length(); i++) {
                JSONObject person = jsonArray.getJSONObject(i);
                String home = person.getString("home team");
                String goal1 = person.getString("goal1");
                String visit = person.getString("visiting team");
                String goal2 = person.getString("goal2");
                String msg;
               msg= home+"              "+goal1+"        :        "+goal2+"              "+visit;
               Log.v("结果",msg);
               list.add(msg);
            }
        } catch (Exception e) {
            Log.v("出错","Worring");
            e.printStackTrace();
        }
    }

}