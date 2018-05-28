package edu.hzuapps.androidlabs.soft1614080902130;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.icu.text.IDNA;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Scanner;

public class ThridActivity extends AppCompatActivity {
    public String FileName = "data.txt";
    public ArrayList<String> data = new ArrayList<String>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_thrid);

        load();
        ListView listView=(ListView) findViewById(R.id.my_listview);
        ArrayAdapter<String> adapter=new ArrayAdapter<String>(ThridActivity.this,android.R.layout.simple_list_item_1,data);
        listView.setAdapter(adapter);

    }

    public void load() {
        Resources resources = this.getResources();
        InputStream StdInfo = null;
        try {
            // 用InputStream方式读取保存在 /res/raw 下的原始文件
            StdInfo = resources.openRawResource(R.raw.data);
            if (StdInfo.available() == 0)
                return;
            if (StdInfo != null) {
                //用utf-8读取文件
                Scanner input = new Scanner(StdInfo, "GBK");
                while (input.hasNext()) {
                    String Name = input.next();
                    data.add(Name);
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
