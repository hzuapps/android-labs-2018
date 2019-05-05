package edu.hauapps.androidlabs.com1614080901131;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
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


public class SecondActivity extends AppCompatActivity {
    private Button bt_get;
    private TextView tv_text;
    private String text;
    private ListView listView;
    private ArrayAdapter<String> adapter;
    private List<String> list=new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        bt_get=(Button)findViewById(R.id.bt_put);
        tv_text=(TextView)findViewById(R.id.tv_text);
        bt_get.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String text1=tv_text.getText().toString();
                SharedPreferences.Editor editor=getSharedPreferences("data",MODE_PRIVATE).edit();
                editor.putString("text1",text1);
                editor.apply();
                Toast.makeText(SecondActivity.this,"发送成功",Toast.LENGTH_LONG).show();

                Intent intent=new Intent(SecondActivity.this,TextActivity.class);
                startActivity(intent);
            }
        });
        listView=(ListView)findViewById(R.id.listV);
        getjson();
    }

    public void getjson()
    {
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    URL url = new URL("https:/raw.githubusercontent.com/JianPengChen/android-labs-2018/master/Com1614080901111/test.json");
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
                        adapter=new ArrayAdapter<String>(SecondActivity.this,android.R.layout.simple_list_item_1,list);
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
                String content=jsonObject.getString("con");
                list.add(content);
                Log.v("结果",content);
            }

        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }
}
