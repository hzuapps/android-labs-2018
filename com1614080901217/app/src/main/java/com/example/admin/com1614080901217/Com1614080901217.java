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

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class Com1614080901217 extends AppCompatActivity {
    private List<String> listContent;
    private List<BianQian> bianQianList;
    private SQLiteDatabase writableDatabase;
    private BianQian bianQian;
    private ArrayAdapter<String> adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {


        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_com1614080901217);
        //initDB();
        initData();
        initDataByJson();
        ListView listView = (ListView) findViewById(R.id.bianqian_list);
        adapter = new ArrayAdapter<>(this, R.layout.support_simple_spinner_dropdown_item, listContent);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent = new Intent(Com1614080901217.this, ContentActivity.class);
                intent.putExtra("content", bianQianList.get(i).getContent());
                startActivity(intent);

            }
        });


    }

    private void initDataByJson() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                OkHttpClient okHttpClient = new OkHttpClient();
                Request request = new Request.Builder().url("https://raw.githubusercontent.com/MoxinHuoHuo/android-labs-2018/master/com1614080901217/jsonFile.json").build();
                try {
                    Response execute = okHttpClient.newCall(request).execute();
                    String jsonData = execute.body().string();
                    Gson gson = new Gson();
                    List<BianQian> newData = gson.fromJson(jsonData, new TypeToken<List<BianQian>>() {
                    }.getType());
                    bianQianList.addAll(newData);
                    List<String> strings = initTitle(newData);
                    listContent.addAll(strings);
                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            adapter.notifyDataSetChanged();
                        }
                    });

                } catch (IOException e) {
                    e.printStackTrace();
                }

            }
        }).start();
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
        listContent = new ArrayList<>();
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

    List<String> initTitle(List<BianQian> newData
    ) {
        List<String> newTitle = new ArrayList<>();
        for (int i = 0; i < newData.size(); i++) {
            newTitle.add(newData.get(i).getTitle());
        }
        return newTitle;
    }
}
