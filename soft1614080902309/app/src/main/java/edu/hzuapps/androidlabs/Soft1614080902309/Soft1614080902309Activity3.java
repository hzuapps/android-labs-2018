package edu.hzuapps.androidlabs.Soft1614080902309;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class Soft1614080902309Activity3 extends AppCompatActivity {

    public  String text;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.soft_1614080902309_activity3);
        //Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
       // setSupportActionBar(toolbar);



        Button readJson = (Button)findViewById(R.id.readJson);
        Button parseJson = (Button)findViewById(R.id.parseJson);
        final TextView Json_TV_read =(TextView)findViewById(R.id.Json_TV_read);
        final TextView Json_TV_parse =(TextView)findViewById(R.id.Json_TV_parse);

        readJson.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //网络编程获取Json
                new Thread(
                        new Runnable() {
                            @Override
                            public void run() {
                                String url_s = "https://raw.githubusercontent.com/Caixz/android-labs-2018/master/soft1614080902309/app/src/main/text.json";
                                try {
                                    URL url = new URL(url_s);
                                    HttpURLConnection conn =(HttpURLConnection)url.openConnection();
                                    conn.setConnectTimeout(5000);
                                    conn.setUseCaches(false);

                                    conn.connect();
                                    InputStream inputStream = conn.getInputStream();
                                    InputStreamReader reader = new InputStreamReader(inputStream);
                                    BufferedReader buffer = new BufferedReader(reader);
                                    if(conn.getResponseCode()==200)
                                    {
                                        String inputline;
                                        StringBuffer resultdata = new StringBuffer();
                                        while ((inputline = buffer.readLine())!=null)
                                        {
                                            resultdata.append(inputline);
                                        }
                                        text=resultdata.toString();
                                    }
                                } catch (Exception e) {
                                    e.printStackTrace();
                                }
                            }
                        }
                ).start();
                Json_TV_read.setText(text);
            }
        });


        parseJson.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    JSONObject jsonObject = new JSONObject(text);
                    JSONArray jsongoods = jsonObject.getJSONArray("goods");
                    for(int i=0;i<jsongoods.length();i++)
                    {
                        JSONObject goods = jsongoods.getJSONObject(i);
                        Json_TV_parse.append("name:"+goods.getString("name")+"\n");
                        Json_TV_parse.append("Sex:"+goods.getString("price")+"\n");
                        Json_TV_parse.append("age:"+goods.getString("data")+"\n");
                    }

                } catch (Exception e) {
                    e.printStackTrace();
                }
            }}
        );
    }





}