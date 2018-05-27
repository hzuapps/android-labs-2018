package edu.hzuapps.androidlabs.soft1614080902211;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class A5 extends AppCompatActivity {
    private TextView texts;
    private String text;
    public static final String TAG = A5.class.getSimpleName();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_a5);

        texts = ((TextView) findViewById(R.id.readView2));
        getJson();
    }
    public void getJson() {
        new Thread() {
            @Override
            public void run() {
                try {
                    String url_s = "https://raw.githubusercontent.com/LinCJ1998/android-labs-2018/master/soft1614080902211/first.json";
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

                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                try {
                                    JSONArray js = new JSONArray(text);
                                    texts.setText("版本号:");
                                    JSONObject ob = js.getJSONObject(0);
                                    String str = ob.getString("版本号");
                                    texts.append(str);
                                    texts.append("\n");
                                    ob = js.getJSONObject(1);
                                    str = ob.getString("content");
                                    texts.append(str);
                                    texts.append("\n"+"开发人员:");
                                    ob = js.getJSONObject(2);
                                    str = ob.getString("开发人员");
                                    texts.append(str);

                                }catch(Exception e){
                                    e.printStackTrace();
                                }
                            }
                        });
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }

            }


        }.start();
    }
}
