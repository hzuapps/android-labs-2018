package edu.hzuapps.androidlabs.soft1614080902334;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.Window;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class LatestWeatherInfoActivity extends Activity {

    private ArrayAdapter<String> adapter1;
    private ListView listView;
    private String content;
    private List<String> list = new ArrayList<String>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);//去掉标题栏，一定要在setContentView之前
        setContentView(R.layout.activity_latest_weather_info);
        getJson();
    }

    /**
     * 获取JSON
     */
    public void getJson() {
        new Thread() {
            @Override
            public void run() {
                try {
                    //线上JSON文件的URL地址
                    String url_s = "https://raw.githubusercontent.com/neptuneman/android-labs-2018/master/soft1614080902334/weather_info.json";
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
                        StringBuilder resultData = new StringBuilder();
                        while ((inputLine = buffer.readLine()) != null) {
                            resultData.append(inputLine);
                        }
                        content = resultData.toString();
                        Log.v("Show Contents", content);
                        parseJson();
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }

                /**
                 * //runOnUiThread 用于更新UI
                 */
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        //创建Adapter
                        adapter1 = new ArrayAdapter<String>(LatestWeatherInfoActivity.this, android.R.layout.simple_list_item_1, list);
                        listView = (ListView) findViewById(R.id.weather_list);
                        //给天气列表设置Adapter
                        listView.setAdapter(adapter1);
                    }
                });
            }
        }.start();
    }

    /**
     * 解析JSON
     */
    public void parseJson() {
        try {
            JSONArray jsonArray = new JSONArray(content);
            for (int i = 0; i < jsonArray.length(); i++) {
                JSONObject person = jsonArray.getJSONObject(i);
                String date = person.getString("date");
                String w_info = person.getString("w_info");
                String temperature = person.getString("temperature");
                String wind = person.getString("wind");
                String weather_info;
                weather_info = date + "      " + w_info + "      " + temperature + "       "+ wind;
                Log.v("result",weather_info);
                list.add(weather_info);
            }
        } catch (Exception e) {
            Log.v("Error","error..");
            e.printStackTrace();
        }
    }

}
