package edu.androidlabs.soft1614080902418;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.app.Activity;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class soft1614080902418MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_soft1614080902418_main);

        final Activity thisActivity = this;
        listView=findViewById(R.id.listview);
        listView.setAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_expandable_list_item_1,getData()));

        Button btnOpen = (Button) findViewById(R.id.button);
        btnOpen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(soft1614080902418MainActivity.this,sBianqian.class);
                               startActivity(intent);

                //thisActivity.startActivityForResult(intent, 2016);
            }
        });
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> arg0, View arg1, int arg2, long arg3) {
                // TODO Auto-generated method stub
                int a;
                Intent intent = new Intent(soft1614080902418MainActivity.this,sBianqian.class);
                startActivity(intent);
            }
        });
    }
    private ListView listView;
    //private List<String> data = new ArrayList<String>();





    private List<String> getData(){

        List<String> data = new ArrayList<String>();
        data.add("便签1");
        data.add("便签2");
        data.add("便签3");
        data.add("便签4");

        return data;
    }
}