package edu.hzuapps.androidlabs.com1614080901134;

import android.app.DownloadManager;
import android.app.VoiceInteractor;
import android.renderscript.ScriptGroup;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.Buffer;
import java.util.ArrayList;
import java.util.List;

public class thirdActivity extends AppCompatActivity {
    private String text;
    private ListView listView;
    private ArrayAdapter<String>adapter;
    private List<String> list=new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third);
      listView=(ListView)findViewById(R.id.listview);
        getjson();
    }
  public void getjson()
    {
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    URL url = new URL("https://github.com/chenjiahui-xxz/android-labs-2018/blob/master/com1614080901134/content.json");
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
                            adapter=new ArrayAdapter<String>(thirdActivity.this,android.R.layout.simple_list_item_1,list);
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
                        String name=jsonObject.getString("name");
                        String price=jsonObject.getString("price");
                        String count=jsonObject.getString("count");
                        String add;
                        add=name+"    "+price+"     "+count;
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

