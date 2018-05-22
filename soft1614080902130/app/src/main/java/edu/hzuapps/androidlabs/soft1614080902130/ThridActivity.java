package edu.hzuapps.androidlabs.soft1614080902130;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

public class ThridActivity extends AppCompatActivity {
    private String[] data={"用户名： fly","排名： 1234","好友数： 20","好友排行榜： 30","最近在线时间： 2018/5/20","最高分： 30"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_thrid);

        ArrayAdapter<String> adapter=new ArrayAdapter<String>(
                ThridActivity.this,android.R.layout.simple_list_item_1,data);
        ListView listView=(ListView) findViewById(R.id.my_listview);
        listView.setAdapter(adapter);

    }

}
