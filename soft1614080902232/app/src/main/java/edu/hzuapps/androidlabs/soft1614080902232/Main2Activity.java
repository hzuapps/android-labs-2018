package edu.hzuapps.androidlabs.soft1614080902232;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import org.json.JSONArray;
import org.json.JSONObject;
import org.json.JSONStringer;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class Main2Activity extends AppCompatActivity {

    private TextView texts;
    private String text;
    public static final String TAG = Main2Activity.class.getSimpleName();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
        texts = ((TextView) findViewById(R.id.readView2));
        getJson();
    }

    public void getJson() {
        new Thread() {
            @Override
            public void run() {
                try {
                    // 你的 URL
                    Log.i(TAG, "01");
                    String url_s = "https://raw.githubusercontent.com/JinmingH/android-labs-2018/master/soft1614080902232/information.json";
                    URL url = new URL(url_s);
                    HttpURLConnection conn = (HttpURLConnection) url.openConnection();
                    Log.i(TAG, "1");
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


                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                try {
                                    JSONArray js = new JSONArray(text);
                                    JSONObject ob = js.getJSONObject(0);
                                    String str = ob.getString("sentence");
                                    texts.setText(str);
                                    ob = js.getJSONObject(1);
                                    str = ob.getString("data");
                                    texts.append(str);
                                }catch(Exception e){
                                    e.printStackTrace();
                                }
                            }
                        });

                    }
                } catch (Exception e) {
                    Log.i(TAG, "5");
                    e.printStackTrace();
                }

            }


        }.start();
    }

}
