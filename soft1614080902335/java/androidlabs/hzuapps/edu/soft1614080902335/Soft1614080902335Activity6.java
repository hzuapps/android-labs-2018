package androidlabs.hzuapps.edu.soft1614080902335;

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

public class Soft1614080902335Activity6 extends AppCompatActivity {

    String text;
    String user_id;
    String user_name;
    String user_sex;
    String user_area;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_soft1614080902335_qq6);
        getJson();
    }

    public void getJson() {
        new Thread() {
            @Override
            public void run() {
                try {
                    //你的URL
                    String url_user = "https://raw.githubusercontent.com/ChenchenJT/android-labs-2018/master/soft1614080902335/user_information.json";
                    URL url = new URL(url_user);
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

                        text = resultData.toString();input.close();
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
                        ((TextView) findViewById(R.id.new_id)).setText(user_id);
                        ((TextView) findViewById(R.id.new_name)).setText(user_name);
                        ((TextView) findViewById(R.id.new_sex)).setText(user_sex);
                        ((TextView) findViewById(R.id.new_area)).setText(user_area);
                    }
                });
            }
        }.start();
    }


    public void backJson() {
        JSONObject person = null;
        try {
            person = new JSONObject(JSONTokener(text));
            user_id=person.getString("id");
            user_name=person.getString("name");
            user_sex=person.getString("sex");
            user_area=person.getString("area");
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
