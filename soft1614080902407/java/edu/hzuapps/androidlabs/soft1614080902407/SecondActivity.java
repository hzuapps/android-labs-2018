package edu.hzuapps.androidlabs.soft1614080902407;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.lang.String;
import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class SecondActivity extends AppCompatActivity {
    private EditText editText;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        final Activity thisActivity = this;
        Button getJson = (Button)findViewById(R.id.getJson);
        Button btnJoin= (Button)findViewById(R.id.btnJoin);
        editText = (EditText)findViewById(R.id.edittext);

        getJson.setOnClickListener(new View.OnClickListener() {//解析JSON
            @Override
            public void onClick(View v) {
                sendRequestWithOkHttp();
            }
        });
        btnJoin.setOnClickListener(new View.OnClickListener() {//从文件读取内容
            @Override
            public void onClick(View v) {
                String inputText = load();
                editText.setText(inputText);
                editText.setSelection(inputText.length());
            }
        });
    }
    protected void onDestroy() {                            //存储文件

        super.onDestroy();
        String  inputText = editText.getText().toString();
        save(inputText);
    }
    public void save(String inputText){
        FileOutputStream out;
        BufferedWriter  writer = null;
        try {
            out = openFileOutput("data", MODE_PRIVATE);
            writer = new BufferedWriter(new OutputStreamWriter(out));
            writer.write(inputText);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if(writer!=null){
                    writer.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }
    public String load(){                                           //读取文件
        FileInputStream in =null;
        BufferedReader reader = null;
        StringBuilder content = new StringBuilder();
        try {
            in = openFileInput("data");
            reader = new BufferedReader(new InputStreamReader(in));
            String line = "";
            while ((line=reader.readLine())!= null){
                content.append(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if(reader!=null){
                try {
                    reader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return content.toString();
    }
    private void sendRequestWithOkHttp(){//访问服务器
        new Thread(new Runnable() {
            @Override
            public void run() {

                try {
                    OkHttpClient client = new OkHttpClient();
                    Request request = new Request.Builder().url("https://raw.githubusercontent.com/Qiujialin/android-labs-2018/master/soft1614080902407/get_data.json").build();
                    Response response = client.newCall(request).execute();
                    String responseData = response.body().string();
                    parseJSONWithJSONObject(responseData);
                } catch (IOException e) {
                    e.printStackTrace();
                }

            }
        }).start();
    }
    private void parseJSONWithJSONObject(String jsonData) {//解析JSON
        try {
            JSONArray jsonArray = new JSONArray(jsonData);
            for(int i=0;i<jsonArray.length();i++){
                JSONObject jsonObject = jsonArray.getJSONObject(i);
                String id = jsonObject.getString("id");
                String  name = jsonObject.getString("name");
                String  text = "id is "+id+"\r\n"+"name is "+name;
                showResponse(text);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }
    private void showResponse(final String response) {//显示出来
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                //editText.append(response);
                editText.setText(response);
            }
        });
    }
}
