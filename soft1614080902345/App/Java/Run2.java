package com.example.administrator;

import android.app.Activity;
import android.content.ContentUris;
import android.content.ContentValues;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ShareActionProvider;
import android.widget.Toast;

public class Run2 extends Activity{
    private Button send;
    private EditText name,message,phone;
    private SharedPreferences pref;
    private SharedPreferences.Editor editor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.run2);
        name=(EditText)findViewById(R.id.name);
        message=(EditText)findViewById(R.id.message);
        phone=(EditText)findViewById(R.id.phone);
        send=(Button)findViewById(R.id.send);
        pref=getSharedPreferences("JZmessage",MODE_PRIVATE);
        editor=pref.edit();

    }
    public void fabu(View v){
        switch (v.getId()){
            case R.id.send:
                String Name=name.getText().toString();
                String Message=message.getText().toString();
                String Phone=phone.getText().toString();
                editor.putString("发布人姓名",Name);
                editor.putString("发布人电话",Phone);
                editor.putString("兼职信息",Message);
                editor.commit();
                Toast.makeText(Run2.this,"登记成功",Toast.LENGTH_LONG).show();


        }
    }
}
