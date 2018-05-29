package edu.hzuapps.androidlabs.Soft1614080902319Activity;

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

public class Activity_4 extends AppCompatActivity {
    private ArrayAdapter<String> adapter1;
    private ListView listView;
    private String text;
    private List<String> list=new ArrayList<String>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_4);


        listView=(ListView)findViewById(R.id.danciben);
        getJson();
    }
    public void getJson() {
        new Thread() {
            @Override
            public void run() {
                try {
                    //你的URL
                    String url_s = "https://raw.githubusercontent.com/xiaojiahao/android-labs-2018/master/soft1614080902319/information.json";
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
                                Activity_4.this, android.R.layout.simple_list_item_1, list);
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
                String word = person.getString("word");
                String mean = person.getString("mean");

                String msg;
                msg= word;
                Log.v("结果",msg);
                list.add(msg);
                msg= mean;
                Log.v("结果",msg);
                list.add(msg);

            }
        } catch (Exception e) {
            Log.v("出错","Worring");
            e.printStackTrace();
        }
    }

}
