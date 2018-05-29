package edu.hzuapps.androidlabs.soft1614080902233;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Locale;

public class SecondActivity extends AppCompatActivity {

    private ArrayAdapter<String> adapter1;
    private ListView listView;
    private List<String> list=new ArrayList<String>();
    private TextView shouru;
    private double sum=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        ((Button) findViewById(R.id.button_02_01)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent2_1=new Intent(SecondActivity.this,thirdActivity.class);
                startActivityForResult(intent2_1,1);
            }
        });
        shouru=findViewById(R.id.textview_shouru);
        init();
        ((Button)findViewById(R.id.button_xiazai)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                list.clear();
                TextView textView = (TextView) findViewById(R.id.textview_history);
                textView.setText(null);
                String url_s = "https://raw.githubusercontent.com/liaohuajjj/android-labs-2018/master/soft1614080902233/informatian.json";
                getJson(url_s,1);
                String url_s2="https://raw.githubusercontent.com/liaohuajjj/android-labs-2018/master/soft1614080902233/informatian2.json";
                getJson(url_s2,2);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode==1&&resultCode==2){
            String s=data.getStringExtra("data1");
            if(!s.isEmpty()) {
                sum += Double.parseDouble(s);
                shouru.setText("¥ " + sum);
                write(s);
            }
            refreshHistoricalRecord("收入 "+s);
        }else if(requestCode==1&&resultCode==3){
            String s=data.getStringExtra("data2");
            if(!s.isEmpty()) {
                sum -= Double.parseDouble(s);
                shouru.setText("¥ " + sum);
                write(s);
            }
            refreshHistoricalRecord("支出 "+s);
        }
        initHistoricalRecord();
    }

    private void refreshHistoricalRecord(String msg)  //刷新一下记录
    {
        if(msg==null) return;

        TextView textView = (TextView) findViewById(R.id.textview_history);
        String s = textView.getText().toString();
        Calendar c = Calendar.getInstance();
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        String formattedDate=df.format(c.getTime());
        textView.setText(s+"\n["+formattedDate+"] "+msg);
        list.add("\n["+formattedDate+"] "+msg);
    }
    private void initHistoricalRecord()  //初始化记录
    {
        TextView textView = (TextView) findViewById(R.id.textview_history);
        String s = read();
        if(s!=null)
            refreshHistoricalRecord(s);
    }

    public String read() {   //读入存储数据
        try {
            FileInputStream inStream = this.openFileInput("message.txt");
            byte[] buffer = new byte[1024];
            int hasRead = 0;
            StringBuilder sb = new StringBuilder();
            while ((hasRead = inStream.read(buffer)) != -1) {
                sb.append(new String(buffer, 0, hasRead));
            }

            inStream.close();
            return sb.toString();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public void write(String msg){   //写出存储数据
        // 步骤1：获取输入值
        if(msg == null) return;
        try {
            // 步骤2:创建一个FileOutputStream对象,MODE_APPEND追加模式
            msg += read();  //前面的也读进来
            FileOutputStream fos = openFileOutput("storage.txt", MODE_APPEND);
            // 步骤3：将获取过来的值放入文件
            fos.write(msg.getBytes());
            // 步骤4：关闭数据流
            fos.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void init() {
        listView=(ListView)findViewById(R.id.list_text);
    }
    public void getJson( final String url_s,final int keyy) {
        new Thread() {
            @Override
            public void run() {
                try {
                    //你的URL
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
                        final String text = resultData.toString();
                        Log.v("out---------------->", text);
                        parseJson(text,keyy);
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        adapter1 = new ArrayAdapter<String>(SecondActivity.this, android.R.layout.simple_list_item_1, list);
                        listView.setAdapter(adapter1);
                    }
                });
            }
        }.start();
    }

    public void parseJson(String text,int keyy) {
        try {
            JSONArray jsonArray = new JSONArray(text);
            if(keyy==1)
            for (int i = 0; i < jsonArray.length(); i++) {
                JSONObject person = jsonArray.getJSONObject(i);
                String time1 = person.getString("history_time");
                String style1 = person.getString("history_style");
                String money1 = person.getString("history_money");
                String msg;
                msg= time1+" "+style1+money1;
                Log.v("结果",msg);
                list.add(msg);
            }
            else if(keyy==2)
                for (int i = 0; i < jsonArray.length(); i++) {
                    JSONObject person = jsonArray.getJSONObject(i);
                    String allSum1 = person.getString("allSum");
                    sum=Double.parseDouble(allSum1);
                    Log.v("结果",allSum1);
                    shouru.setText("¥ " + sum);
                }
        } catch (Exception e) {
            Log.v("出错","Worring");
            e.printStackTrace();
        }
    }
}