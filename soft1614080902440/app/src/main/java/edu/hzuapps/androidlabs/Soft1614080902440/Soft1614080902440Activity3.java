package edu.androidlabs.soft1614080902440;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class Soft1614080902440Activity3 extends Activity {
    private String text;
    private String name;
    private String sex;
    private int age;
    private String subject;
    private String msg;
    private ListView listView;
    private ArrayAdapter<String> adapter1;
    private List<String> list = new ArrayList<String>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity3_soft1614080902440);
        //获得UI对象
        Button bt_get = (Button) findViewById(R.id.get);
        Button bt_parse = (Button) findViewById(R.id.parse);
        listView=(ListView)findViewById(R.id.ListView_1);
        //对获取json文件数据的按钮添加监听器
        bt_get.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getJson();

            }
        });
        //对获取并解析json文件数据的按钮添加监听器
        bt_parse.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               getParseJson();
            }
        });

    }
    //获得json文件数据
    public void getJson(){
        new Thread() {
            @Override
            public void run() {
                try {
                    //你的URL
                    String url_s = "https://raw.githubusercontent.com/HHuangF/android-labs-2018/master/soft1614080902440/data.json";
                    URL url = new URL(url_s);
                    HttpURLConnection conn = (HttpURLConnection) url.openConnection();
                    //设置连接属性。不喜欢的话直接默认也阔以
                    conn.setConnectTimeout(5000);//设置超时
                    conn.setUseCaches(false);//数据不多不用缓存了

                    //这里连接了
                    conn.connect();
                    //这里才真正获取到了数据
                    InputStream inputStream = conn.getInputStream();
                    InputStreamReader input = new InputStreamReader(inputStream);
                    BufferedReader buffer = new BufferedReader(input);
                    if (conn.getResponseCode() == 200) {//200意味着返回的是"OK"
                        String inputLine;
                        StringBuffer resultData = new StringBuffer();//StringBuffer字符串拼接很快
                        while ((inputLine = buffer.readLine()) != null) {
                            resultData.append(inputLine);
                        }
                        text = resultData.toString();
                        Log.v("out---------------->", text);
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        ((TextView) findViewById(R.id.get_result)).setText(text);

                    }
                });
            }
        }.start();
    }
    //解析json文件数据
    public void parseJson(){
        try{
            //这里的text就是上边获取到的数据，一个String.
            JSONArray jsonArray = new JSONArray(text);
            for(int i =0;i<jsonArray.length();i++){
                JSONObject person = jsonArray.getJSONObject(i);
                 name  = person.getString("name");
                 sex  = person.getString("sex");
                 age  = person.getInt("age");
                 subject  = person.getString("subject");
                 msg = name+"           "+sex+"           "+age+"             "+subject;
                Log.v("result",msg);
                list.add(msg);
            }
        } catch(Exception e){
            e.printStackTrace();
        }

    }
    //获得并解析json文件数据
    public void getParseJson(){
        new Thread() {
            @Override
            public void run() {
                try {
                    //你的URL
                    String url_s = "https://raw.githubusercontent.com/HHuangF/android-labs-2018/master/soft1614080902440/data.json";
                    URL url = new URL(url_s);
                    HttpURLConnection conn = (HttpURLConnection) url.openConnection();
                    //设置连接属性。不喜欢的话直接默认也阔以
                    conn.setConnectTimeout(5000);//设置超时
                    conn.setUseCaches(false);//数据不多不用缓存了

                    //这里连接了
                    conn.connect();
                    //这里才真正获取到了数据
                    InputStream inputStream = conn.getInputStream();
                    InputStreamReader input = new InputStreamReader(inputStream);
                    BufferedReader buffer = new BufferedReader(input);
                    if (conn.getResponseCode() == 200) {//200意味着返回的是"OK"
                        String inputLine;
                        StringBuffer resultData = new StringBuffer();//StringBuffer字符串拼接很快
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
                                Soft1614080902440Activity3.this, android.R.layout.simple_list_item_1, list);
                        listView.setAdapter(adapter1);
                    }
                });
            }
        }.start();
    }

}
