package com.example.soft1614080902227activity;


import android.app.VoiceInteractor;
import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.TextView;

public class Soft1614080902227Activity extends AppCompatActivity{
    private int dushu1 = 27;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_soft1614080902227);
        Button btn_Click = (Button)findViewById(R.id.Air);
        Button btn_Click1 = (Button)findViewById(R.id.TV);
        Button btn_Click2 = (Button)findViewById(R.id.add);
        btn_Click.setOnClickListener(new MyOnClickListener());
        btn_Click1.setOnClickListener(new MyOnClickListener1());
        UserDBHelper dbHelper3 = new UserDBHelper(Soft1614080902227Activity.this,"user_ino",null,1);
        SQLiteDatabase sqLiteDatabase3 = dbHelper3.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("name","wendu");
        values.put("number",dushu1);
        sqLiteDatabase3.insert("user_ino",null,values);
        sqLiteDatabase3.close();

    }
    class MyOnClickListener implements View.OnClickListener{
        @Override
        public void onClick(View v){
            if(v.getId()==R.id.Air) {
                Intent intent = new Intent(Soft1614080902227Activity.this,Remote_0f_Air.class);
                startActivity(intent);

            }
        }

    }
    class MyOnClickListener1 implements View.OnClickListener{
        @Override
        public void onClick(View v){
            if(v.getId()==R.id.TV) {
                Intent intent1 = new Intent(Soft1614080902227Activity.this,Remote_of_TV.class);
                startActivity(intent1);
            }
        }

    }
}
