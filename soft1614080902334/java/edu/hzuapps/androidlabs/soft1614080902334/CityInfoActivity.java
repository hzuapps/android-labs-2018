package edu.hzuapps.androidlabs.soft1614080902334;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.ContextWrapper;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;

public class CityInfoActivity extends Activity {
    private final String[] data = { "北京 Beijing", "上海 Shanghai", "广州 Guangzhou", "深圳 Shenzhen","杭州 Hangzhou","南京 Nanjing", "钓鱼岛 Diaoyu Island", "香港 Hong Kong", "台北 Taipei",
            "东京 Tokyo" ,"首尔 Seoul","新加坡 Singapore","吉隆坡 Kuala Lumpur","曼谷 Pangkok", "悉尼 Sydney", "纽约 New York", "洛杉矶 Los Angeles", "伦敦 London",
            "巴黎 Paris", "柏林 Berlin", "米兰 Milan","马德里 Madrid", };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cityinfo);

        final Activity thisActivity = this;
        final Button btn_back = (Button) findViewById(R.id.btn_back);
        final Button btn_query = (Button) findViewById(R.id.btn_query);
        //子页面增加按钮返回启动页面
        btn_back.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if (v.equals(btn_back)) {
                    Intent intent = new Intent(thisActivity, Soft1614080902334WeatherActivity.class);
                    thisActivity.startActivity(intent);
                }
            }
        });

        //查询7天趋势按钮
        btn_query.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if (v.equals(btn_query)) {
                    Intent intent = new Intent(thisActivity, LatestWeatherInfoActivity.class);
                    thisActivity.startActivity(intent);
                }
            }
        });

        // 列表listView
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(
                CityInfoActivity.this, android.R.layout.simple_list_item_1, data);
        ListView listView = (ListView) findViewById(R.id.list_view);
        listView.setAdapter(adapter);

        //搜索按钮
        ((Button) findViewById(R.id.btn_search)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String text = ((EditText) findViewById(R.id.et)).getText().toString();
                save(text);
            }
        });
    }

    //保存数据至内部文件logs
    public void save(String text){
        FileOutputStream out;
        BufferedWriter writer=null;
        try{
            //写入
            out=openFileOutput("logs", ContextWrapper.MODE_APPEND);
            writer=new BufferedWriter(new OutputStreamWriter(out));
            writer.write(text);
        }catch (IOException e){
            e.printStackTrace();
        }finally {
            try {
                //关闭流
                if(writer!=null){
                    writer.close();
                }
            }catch (IOException e){
                e.printStackTrace();
            }
        }
    }























//class
}

