package soft1614080902310.androidlabs.hzuapps.edu.weather_report;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import android.content.Intent;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;
import java.util.ArrayList;
public class soft1614080902310weather_report1Activity extends AppCompatActivity {
    public TextView TV7;
    private String text;
    private ListView LV1;
    private Button Bt1;
    private ArrayAdapter<String> adapter1;
        private List<String> list= new ArrayList<String>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_soft1614080902310weather_report1);

        definecontent();
        getintent();
        setAction();
        getJson();
    }
    public void definecontent(){
        TV7=findViewById(R.id.tv7);
        LV1=findViewById(R.id.lv1);
        Bt1=findViewById(R.id.bt1);
    }
    public void getintent(){
        Intent intent=getIntent();
        String cityname= intent.getStringExtra("et1");
        TV7.setText(cityname);
    }
    public void setAction(){
        Bt1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(soft1614080902310weather_report1Activity.this,soft1614080902310_weather_report2Activity.class);
                startActivity(intent);
            }
        });
    }

    public void getJson(){
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    //你的URL
                    String url_s = "https://raw.githubusercontent.com/yangyingq/android-labs-2018/master/soft1614080902310/data.json";
                    URL url = new URL(url_s);
                    HttpURLConnection conn = (HttpURLConnection)url.openConnection();
                    //设置连接属性。不喜欢的话直接默认也阔以
                    conn.setConnectTimeout(5000);//设置超时
                    conn.setUseCaches(false);//数据不多不用缓存了

                    //这里连接了
                    conn.connect();
                    //这里才真正获取到了数据
                    InputStream inputStream = conn.getInputStream();
                    InputStreamReader input = new InputStreamReader(inputStream);
                    BufferedReader buffer = new BufferedReader(input);
                    if(conn.getResponseCode() == 200){//200意味着返回的是"OK"
                        String inputLine;
                        StringBuffer resultData  = new StringBuffer();//StringBuffer字符串拼接很快
                        while((inputLine = buffer.readLine())!= null){
                            resultData.append(inputLine);
                        }
                        text = resultData.toString();
                        Log.v("out---------------->",text);
                        parseJson();
                    }
                } catch(Exception e){
                    e.printStackTrace();
                }
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        adapter1=new ArrayAdapter<String>(
                         soft1614080902310weather_report1Activity.this,android.R.layout.simple_list_item_1,list);
                            LV1.setAdapter(adapter1);
                    }
                });


            }
        }).start();
    }
    public void parseJson(){
        try{
            JSONArray jsonArray = new JSONArray(text);
            for(int i =0;i<jsonArray.length();i++){
                JSONObject person = jsonArray.getJSONObject(i);
                String days=person.getString("day");
                String weathers=person.getString("weather");
                String temperatures=person.getString("temperature");
                String msg=days+"           "+weathers+"            "+temperatures+"";
                list.add(msg);
                Log.v("结果",msg);
            }
        } catch(Exception e){
            Log.v("读取不到","error");
            e.printStackTrace();

        }
    }


}


