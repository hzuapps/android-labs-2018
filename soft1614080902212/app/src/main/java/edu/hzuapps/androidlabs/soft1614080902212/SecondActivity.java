package edu.hzuapps.androidlabs.soft1614080902212;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import org.json.JSONArray;
import org.json.JSONObject;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class SecondActivity extends AppCompatActivity {

    private Button Button;
    private EditText Edit;
    public String sr;
    private TextView cxjl;
    private String text;
    private TextView tv;
    private String []place=new String[100];
    private String []time=new String[100];
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        Button = (Button) findViewById(R.id.button2);
        Edit = (EditText) findViewById(R.id.sr1);
        cxjl = (TextView)findViewById(R.id.cxjl);
        tv=(TextView)findViewById(R.id.nik);
        Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sr = Edit.getText().toString();
                write(sr);
                String msg = read();
                if (sr.equals("")) {
                    Toast.makeText(SecondActivity.this, "请输入您要查询的时间段", Toast.LENGTH_SHORT).show();

                }
                String record = cxjl.getText().toString();
                cxjl.setText(record+"\n"+msg);
                getJson();
            }
        });

    }
        public String read() {
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
        public void write(String msg){
            if (msg == null) return;
            try {

                FileOutputStream fos = openFileOutput("message.txt",
                        MODE_PRIVATE
                );
                fos.write(msg.getBytes());
                fos.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    public void getJson() {
        new Thread() {
            @Override
            public void run() {
                try {
                    //你的URL
                    String url_s = "https://raw.githubusercontent.com/hzulinzr/android-labs-2018/master/soft1614080902212/S.json";
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
                        for(int i=0;i<time.length;i++)
                        {
                            if(sr.equals(time[i]))
                            {
                                tv.setText(place[i]);
                                break;
                            }
                        }
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
                 time[i] = person.getString("time");
                 Log.v("time",time[i]);
                 place[i]=person.getString("空教室");
                 Log.v("空教室",place[i]);
            }
        } catch (Exception e) {
            Log.v("出错","Worring");
            e.printStackTrace();
        }
    }

}


