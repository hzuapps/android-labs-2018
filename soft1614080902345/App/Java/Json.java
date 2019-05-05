package com.example.administrator;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
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

public class Json extends AppCompatActivity {
    private String text;
    private ListView listView;
    private ArrayAdapter<String> adapter;
    private List<String> list=new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.json);
        listView=(ListView)findViewById(R.id.listview);
        getjson();
    }
    public void getjson()
    {
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    URL url = new URL("https://raw.githubusercontent.com/chinesehope/android-labs-2018/master/soft1614080902345/message1.json");
                    HttpURLConnection connection = (HttpURLConnection) url.openConnection();
                    connection.setRequestMethod("GET");
                    connection.setConnectTimeout(8000);
                    connection.setReadTimeout(8000);
                    connection.setUseCaches(false);
                    connection.connect();
                    InputStream in = connection.getInputStream();
                    InputStreamReader input=new InputStreamReader(in);
                    BufferedReader reader=new BufferedReader(input);
                    if (connection.getResponseCode() == 200) {
                        StringBuilder response = new StringBuilder();
                        String Line;
                        while ((Line = reader.readLine()) != null) {
                            response.append(Line);
                        }
                        text = response.toString();
                        Log.v("out---------------->",text);
                        analyzejson();
                    }
                }
                catch(Exception e)
                {
                    e.printStackTrace();
                }
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        adapter=new ArrayAdapter<String>(Json.this,android.R.layout.simple_list_item_1,list);
                        listView.setAdapter(adapter);
                    }
                });
            }
        }).start();
    }
    public void analyzejson()
    {
        try{
            JSONArray jsonArray=new JSONArray(text);
            for(int a=0;a<jsonArray.length();a++)
            {
                JSONObject jsonObject=jsonArray.getJSONObject(a);
                String number=jsonObject.getString("地点");
                String number1=jsonObject.getString("时间");
                String number2=jsonObject.getString("内容");
                String add;
                add=number+"    "+number1+"     "+number2;
                list.add(add);
                Log.v("结果",add);
            }

        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }

}