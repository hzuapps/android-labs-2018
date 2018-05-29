package edu.hzuapps.androidlabs;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Search extends AppCompatActivity {

    MyDatabaseHelper dbHelper=new MyDatabaseHelper(Search.this,"cloth",null,1);

    String str;
    String table =  "textinfo" ;
    String[] columns = new  String[] {"name","description"};
    String selection = "name=?" ;
    String groupBy = null ;
    String having = null ;
    String orderBy = null ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);

        EditText SearchText=(EditText)findViewById(R.id.SearchText);
        SearchText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                str=s.toString();
            }
        });

        Button btn1=(Button)findViewById(R.id.ShowButton);

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SQLiteDatabase db = dbHelper.getWritableDatabase();
                //指明去查询textinfo表。
                Cursor cursor = db.query(table,columns,selection,new String[]{str},groupBy,having,orderBy);
                //Cursor cursor = db.query(table,columns,null,null,groupBy,having,orderBy);
                //调用moveToFirst()将数据指针移动到第一行的位置。

                //cursor光标遍历
                /*
                if (cursor.moveToFirst()){
                    do {
                        //然后通过Cursor的getColumnIndex()获取某一列中所对应的位置的索引
                        String name=cursor.getString(cursor.getColumnIndex("name"));
                        String description = cursor.getString(cursor.getColumnIndex("description"));
                        Log.d("MainActivity","name is "+name);
                        Log.d("MainActivity","description is "+description);
                        Intent intent=new Intent(Search.this,ShowSearch.class);
                        intent.putExtra("name",name);
                        intent.putExtra("description",description);
                        startActivity(intent);
                    }while(cursor.moveToNext());
                }
                cursor.close();
                */

                //单个查询
                if(cursor.moveToFirst()){
                    String name=cursor.getString(cursor.getColumnIndex("name"));
                    String description = cursor.getString(cursor.getColumnIndex("description"));
                    Intent intent=new Intent(Search.this,ShowSearch.class);
                    intent.putExtra("name",name);
                    intent.putExtra("description",description);
                    startActivity(intent);
                }
                else{
                    Toast.makeText(Search.this,"查询无名为"+str+"的搭配",Toast.LENGTH_SHORT).show();
                }
            }
        });

        Button btn2=(Button)findViewById(R.id.fromJSON);
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getApplicationContext(),ShowFromJSON.class);
                startActivity(intent);
            }
        });
    }

}
