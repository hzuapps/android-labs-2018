package edu.hzuapps.androidlabs.soft1614080902318;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class AdvertActivity extends AppCompatActivity {

    TextView tv;

    Handler handler=new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            String myjson= parseJson((String) msg.obj);
            tv.setText(myjson);
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_advert);
        tv= (TextView) findViewById(R.id.advertId);
        new Thread(){
            @Override
            public void run() {
                super.run();
                String myjson=myjson("https://github.com/linwt/android-labs-2018/blob/master/soft1614080902318/myjson.json");
                Message msg=handler.obtainMessage();
                msg.obj=myjson;
                handler.sendMessage(msg);
            }
        }.start();
    }

    public String myjson(String u) {
        try {
            URL url = new URL(u);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");
            conn.setConnectTimeout(5000);
            InputStream is = conn.getInputStream();
            byte[] b = new byte[1024];
            StringBuilder sb = new StringBuilder();
            String myjson;
            int len;
            while ((len=is.read(b)) != -1) {
                myjson=new String(b,0,len);
                sb.append(myjson);
            }
            return sb.toString();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "";
    }



    public String parseJson(String data){
        StringBuilder sb=new StringBuilder();
        try {
            while(data.startsWith("\ufeff")){
                data = data.substring(1);
            }
            JSONArray jsonArray=new JSONArray(data);
            for (int i=0;i<jsonArray.length();i++){
                JSONObject object=jsonArray.getJSONObject(i);
                sb.append("person:"+object.getString("person"));
                sb.append("\n");
                sb.append("words:"+object.getString("words"));
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return sb.toString();
    }

}
