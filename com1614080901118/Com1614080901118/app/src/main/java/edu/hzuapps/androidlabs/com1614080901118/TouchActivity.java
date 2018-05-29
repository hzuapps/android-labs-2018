package edu.hzuapps.androidlabs.com1614080901118;

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

public class TouchActivity extends AppCompatActivity {
    private ArrayAdapter<String> adapter1;
    private ListView listView;
    private String text;
    private List<String> list=new ArrayList<String>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_touch);
        listView=(ListView)findViewById(R.id.lv_paihang);
        getJson();
    }

    public void getJson() {
        new Thread() {
            @Override
            public void run() {
                try {
                    //你的URL
                    String path = "https://raw.githubusercontent.com/wojiaojianxiaobai/android-labs-2018/master/com1614080901118/touch.json";

                    URL url = new URL(path);

                    HttpURLConnection conn = (HttpURLConnection) url.openConnection();
                    conn.setConnectTimeout(5000);
                    conn.setRequestMethod("GET");
                    conn.setUseCaches(false);
                    conn.connect();
                    InputStream inputStream = conn.getInputStream();
                    InputStreamReader input = new InputStreamReader(inputStream);
                    BufferedReader buffer = new BufferedReader(input);
                    if (conn.getResponseCode() == 200) {
                        String inputLine;
                        StringBuilder resultData = new StringBuilder();
                        while ((inputLine = buffer.readLine()) != null) {
                            resultData.append(inputLine);
                        }
                        text = resultData.toString();
                        Log.v("out>>>>>>>>>>>>>>>>>", text);
                        parseJson();
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        adapter1 = new ArrayAdapter<String>(TouchActivity.this, android.R.layout.simple_list_item_1, list);
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
                JSONObject paihanban = jsonArray.getJSONObject(i);
                String hero = paihanban.getString("hero");
                String touch = paihanban.getString("touch");
                String msg;
                msg= hero+"              "+touch+"                ";
                Log.v("输出结果",msg);
                list.add(msg);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
