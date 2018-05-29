package com.example.admin.com1614080901217;

import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
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
    private List<BianQian> bianQianList;
    private SQLiteDatabase writableDatabase;
    private BianQian bianQian;


    @Override
    protected void onCreate(Bundle savedInstanceState) {


        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_com1614080901217);
     //initDB();
        initData();
        ListView listView = (ListView) findViewById(R.id.bianqian_list);
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, R.layout.support_simple_spinner_dropdown_item, listContent);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent = new Intent(Com1614080901217.this, ContentActivity.class);
                intent.putExtra("content",bianQianList.get(i).getContent());
                startActivity(intent);

            }
        });


    }


    private void initDB() {
        DatabaseHelper databaseHelper = new DatabaseHelper(this);
        writableDatabase = databaseHelper.getWritableDatabase();
        ContentValues values = new ContentValues();
        for (int i = 1; i < 20; i++) {
            values.put("title", "标题" + i);
            values.put("content", "这是第" + i + "个美好的季节！");
            writableDatabase.insert("bianqian", null, values);
            values.clear();
        }

    }

    private void initData() {
        bianQianList = new ArrayList<>();
        listContent =  new ArrayList<>();
        DatabaseHelper databaseHelper = new DatabaseHelper(this);
        writableDatabase = databaseHelper.getWritableDatabase();
        Cursor cursor = writableDatabase.query("bianqian", null, null, null, null, null, null);
        if (cursor.moveToFirst()) {
            do {
                Integer id = cursor.getInt(cursor.getColumnIndex("id"));
                String title = cursor.getString(cursor.getColumnIndex("title"));
                String content = cursor.getString(cursor.getColumnIndex("content"));
                bianQian = new BianQian(id, title, content);
                bianQianList.add(bianQian);

            } while (cursor.moveToNext());
            cursor.close();
        }
        for (int i = 0; i < bianQianList.size(); i++) {

            listContent.add(bianQianList.get(i).getTitle());
        }
    }

}
