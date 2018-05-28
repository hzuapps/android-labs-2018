package edu.hzuapps.androidlabs.soft1614080902234application;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class Soft1614080902234Activity2 extends AppCompatActivity {
    private ListView listView;
    private ArrayAdapter<String> adapter;
    private List<String> list=new ArrayList<>();
    private String text;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_soft16140809022342);
        listView= findViewById(R.id.view);
        getJson();
    }

    //读取Test.json文件
    public void getJson(){
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    //文件的URL
                    String url_s="https://raw.githubusercontent.com/hehehe1002/android-labs-2018/master/soft1614080902234/Test.json";
                    URL url = new URL(url_s);
                    HttpURLConnection conn = (HttpURLConnection)url.openConnection();
                    //设置连接属性
                    conn.setConnectTimeout(5000);//设置超时
                    //conn.setRequestMethod("GET");
                    //conn.setDoInput(true);
                    conn.setUseCaches(false);//数据不多不用缓存了
                    //这里连接了
                    conn.connect();
                    //这里才真正获取到了数据
                    InputStream inputStream = conn.getInputStream();
                    InputStreamReader input = new InputStreamReader(inputStream);
                    BufferedReader buffer = new BufferedReader(input);
                    if(conn.getResponseCode() == 200){//200意味着返回的是"OK"
                        String inputLine;//用来保存每行读取的内容
                        StringBuilder resultData  = new StringBuilder();//StringBuffer字符串拼接很快
                        while((inputLine = buffer.readLine())!= null){  //如果inputline为空说明读完了
                            resultData.append(inputLine);   //将读到的内容添加到resultData中
                        }
                        text = resultData.toString();
                        Log.v("out---------------->",text);
                        parseJson();
                    }
                } catch(Exception e){
                    e.printStackTrace();
                }
                //返回主线程
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        //创建一个数组适配器
                        //第一个参数是上下文，即当前的Activity，第二个参数是android sdk中自己内置的一个布局，表明数组每一条数据的布局，第三个参数就是我们要显示的数据
                        adapter= new ArrayAdapter<>(Soft1614080902234Activity2.this, android.R.layout.simple_list_item_1, list);
                        listView.setAdapter(adapter);//通过adapter把数据映射到ListView中
                    }
                });
            }
        }).start();
    }

    //解析Text.json文件
    public void parseJson(){
        try {
            JSONArray jsonArray=new JSONArray(text);  //把字符串转成JSONArray对象
            for(int i=0;i<jsonArray.length();i++){
                JSONObject thing=jsonArray.getJSONObject(i); //遍历jsonArray数组，把每一个对象转成json对象
                String time=thing.getString("time");
                String ok=thing.getString("ok");
                String no=thing.getString("no");
                String msg;
                msg=time+"     "+ok+"     "+no;
                Log.v("结果",msg);
                list.add(msg);
            }
        } catch (JSONException e) {
            Log.v("出错","Wrong");
            e.printStackTrace();
        }
    }
}


