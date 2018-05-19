package com.example.administrator.soft1614080902425;

import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class nexttableActivity extends AppCompatActivity {
    /*private Context mContext;
    private GridView gridView;
    private ArrayAdapter mAdapter = null;
    private ArrayList<String> mData = null;*/
    final private int test1=1;
    final private int test2=2;
    final private int addtest=3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nexttable);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        /*gridView=(GridView)findViewById(R.id.gridview);
        mData = new ArrayList<String>();
        mData.add("课程1");
        mData.add("课程2");
        gridView.setAdapter(mAdapter);
        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(mContext, "你点击了~" + position + "~项", Toast.LENGTH_SHORT).show();
            }
        });*/
        //tv_test = (TextView) findViewById(R.id.tv_test);
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        menu.add(1,test1,1, "测试1");
        menu.add(1,test2,2,"测试2");
        menu.add(1,addtest,3,"添加");
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        switch (id)
        {
            case test1:
                break;
            case test2:
                break;
            case addtest:
                break;
        }
        return super.onOptionsItemSelected(item);
    }
    private void est1()
    {

    }

}
