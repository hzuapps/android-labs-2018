package edu.hzuapps.androidlabs.soft1614080902117;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class Soft1614080902117Activity extends Activity {
    String[]  adapterData;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_soft1614080902117);
        final ListView listView = (ListView)findViewById(R.id.listView);
        adapterData = new String[] {load()};
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>
                ( Soft1614080902117Activity.this, android.R.layout.simple_list_item_1, adapterData);
        listView.setAdapter(arrayAdapter);
        final Activity  thisActivity = this;
        Button  btnHome = (Button)findViewById(R.id.button);
        btnHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(thisActivity,Soft1614080902117Activity1.class);
                thisActivity.startActivity(intent);
            }
        });
        Button  btnDlow = (Button)findViewById(R.id.button8);
        btnDlow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(thisActivity,Soft1614080902117Activity2.class);
                thisActivity.startActivity(intent);
            }
        });
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
}
