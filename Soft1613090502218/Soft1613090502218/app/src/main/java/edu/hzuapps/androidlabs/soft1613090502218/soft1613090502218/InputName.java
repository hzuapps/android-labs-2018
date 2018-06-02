package edu.hzuapps.androidlabs.soft1613090502218.soft1613090502218;

import android.app.Activity;
import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class InputName extends Activity {
    EditText et1;
    Button jump1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_input_name);

        et1=findViewById(R.id.et1);
        jump1=findViewById(R.id.jump1);
        ScoreDataBase scoreDataBase = new ScoreDataBase(this,"database",4);
        final SQLiteDatabase db = scoreDataBase.getWritableDatabase();
        jump1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String getet=et1.getText().toString();
                int getdps=getIntent().getIntExtra("dps",0);
                Log.v("getdps:",getet+"  "+getdps);
                insert(db,getet,getdps);
                db.close();
                Intent intent=new Intent(InputName.this,Score.class);
                startActivity(intent);
            }
        });
    }
    public void insert(SQLiteDatabase db,String pn,int ps){
        Cursor cursor1=db.rawQuery("select* from score",null);
        int count=cursor1.getCount();
        if(count<=10&&count>=0){
            //db.execSQL("insert into score values(pn,ps)");
            ContentValues values=new ContentValues();
            values.put("playername",pn);
            values.put("playscore",ps);
            db.insert("score",null,values);
        }
        else{
            db.execSQL("delete from score where playscore=(" +
                    "select MIN(playscore) from score)");
            //db.execSQL("insert into score values(pn,ps)");
            ContentValues values=new ContentValues();
            values.put("playername",pn);
            values.put("playscore",ps);
            db.insert("score",null,values);
        }
        cursor1.close();
    }
}
