package edu.hzuapps.androidlabs.sotf1614080902107;

import android.content.res.Resources;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.Scanner;

import static android.R.attr.data;

public class FourActivity extends AppCompatActivity {
    public ArrayList<String> data = new ArrayList<String>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_four);

        load();
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(FourActivity.this, android.R.layout.simple_list_item_1, data);
        ListView listView = (ListView) findViewById(R.id.listview1);
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
                Scanner input = new Scanner(StdInfo, "utf-8");
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
