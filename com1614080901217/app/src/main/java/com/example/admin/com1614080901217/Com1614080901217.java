package com.example.admin.com1614080901217;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class Com1614080901217 extends AppCompatActivity {
    private List<String> listContent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_com1614080901217);
        initDate();
        ListView listView = (ListView) findViewById(R.id.bianqian_list);
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, R.layout.support_simple_spinner_dropdown_item, listContent);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent = new Intent(Com1614080901217.this, ContentActivity.class);
                startActivity(intent);

            }
        });


    }

    private void initDate() {
        listContent = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            listContent.add("这是第" + i + "条数据");
        }
    }
}
