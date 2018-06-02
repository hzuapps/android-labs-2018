    package edu.hzuapps.androidlabs;

import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

    public class Add extends AppCompatActivity {

    private MyDatabaseHelper dbHelper;

    String str1,str2;

    public static final String CREATE_INFO = "create table textinfo(" +
            //primary key 将id列设为主键    autoincrement表示id列是自增长的
            "id integer primary key autoincrement," +
            "name text," +
            "description text)";
    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);


        EditText text_nameinfo=(EditText)findViewById(R.id.nameText);

        text_nameinfo.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                str1 = s.toString();
                Log.d("EditText",str1);
            }
        });

        EditText text_description=(EditText)findViewById(R.id.descriptionText);
        text_description.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                str2=s.toString();
                Log.d("EditText",str2);
            }
        });
        //数据库建立
        dbHelper = new MyDatabaseHelper(this,"cloth",null,1);
        dbHelper.getWritableDatabase();
        //上传确认
        Button btn1 =(Button)findViewById(R.id.confirmUpload);
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SQLiteDatabase db=dbHelper.getWritableDatabase();
                //db.execSQL(CREATE_INFO);
                db.execSQL("insert into textinfo(name,description) values(?,?)",
                        new Object[]{str1,str2});
                Toast.makeText(Add.this,"添加成功",Toast.LENGTH_SHORT).show();
                Intent intent=new Intent(Add.this,Soft1613071002201Activity.class);
                startActivity(intent);
            }
        });
    }
}
