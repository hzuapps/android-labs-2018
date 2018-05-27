package edu.hzuapps.androidlabs.Soft1614080902332;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import org.json.JSONException;
import org.json.JSONObject;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import android.view.View;
import android.content.Intent;
import android.widget.Button;
public class Soft1614080902332Activity5 extends AppCompatActivity {
    String text;
    String object_name;
    String object_time;
    String object_place;
    String object_phone;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.soft_1614080902332_activity5);

        getJson();

        final Soft1614080902332Activity5 thisActivity = this;
        final Button btn = (Button) findViewById(R.id.button);
        final Button btn4 = (Button) findViewById(R.id.button4);

        btn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(v.equals(btn4)) {
                    Intent intent = new Intent(thisActivity,Soft1614080902332Activity1.class);
                    thisActivity.startActivity(intent);
                }
            }
        });
    }

    public void getJson() {
        new Thread() {
            @Override
            public void run() {
                try {
                    //你的URL
                    String url_s = "https://raw.githubusercontent.com/QFJay/android-labs-2018/master/soft1614080902332/LAB6.json";
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
                        input.close();
                        inputStream.close();
                        Log.v("Json解析：", text);
                        backJson();
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        ((TextView) findViewById(R.id.new_name)).setText(object_name);
                        ((TextView) findViewById(R.id.new_time)).setText(object_time);
                        ((TextView) findViewById(R.id.new_place)).setText(object_place);
                        ((TextView) findViewById(R.id.new_phone)).setText(object_phone);
                    }
                });
            }
        }.start();
    }

    public void backJson() {
        JSONObject lostObject = null;
        try {
            lostObject = new JSONObject(JSONTokener(text));
            object_name=lostObject.getString("name");
            object_time=lostObject.getString("time");
            object_place=lostObject.getString("place");
            object_phone=lostObject.getString("phone");
        } catch (JSONException e) {
            e.printStackTrace();
            Log.v("错误","Wrong!");
        }

    }
    public String JSONTokener(String in) {
        // consume an optional byte order mark (BOM) if it exists
        if (in != null && in.startsWith("\ufeff")) {
            in = in.substring(1);
        }
        return in;
    }
}
