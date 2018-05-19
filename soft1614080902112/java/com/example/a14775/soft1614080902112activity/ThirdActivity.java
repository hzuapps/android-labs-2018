package com.example.a14775.soft1614080902112activity;

import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class ThirdActivity extends AppCompatActivity {
    private String[] data={"项目一","项目二","项目三"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third);
        ArrayAdapter<String> adapter=new ArrayAdapter<String>(
                ThirdActivity.this,android.R.layout.simple_list_item_1,data
        );
        ListView listView=(ListView) findViewById(R.id.ListView_1);
        listView.setAdapter(adapter);
    }
}