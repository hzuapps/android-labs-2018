package edu.hzuapps.androidlabs.soft1614080902124;

import android.content.res.Resources;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.Scanner;

public class Main3Activity extends AppCompatActivity {
    public ArrayList<String> data = new ArrayList<String>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);

        load();
        ListView listView=(ListView) findViewById(R.id.listview);
        ArrayAdapter<String> adapter=new ArrayAdapter<String>(Main3Activity.this,android.R.layout.simple_list_item_1,data);
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
