package edu.hzuapps.androidlabs.soft1614080902207;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class Main2Activity extends AppCompatActivity {
    private Button btnSave;
    private Button btnRead;
    private EditText edName,edNumber,edReadName,edReadNumber;
    private SharedPreferences sp ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        btnSave = (Button)this.findViewById(R.id.btnSave);
        btnRead = (Button)this.findViewById(R.id.btnRead);
        edName = (EditText)this.findViewById(R.id.edName);
        edNumber = (EditText)this.findViewById(R.id.edNumber);
        edReadName = (EditText)this.findViewById(R.id.edReadName);
        edReadNumber = (EditText)this.findViewById(R.id.edReadNumber);
    }

    public void Click(View view){
        sp = getSharedPreferences("User",Context.MODE_PRIVATE);
        switch (view.getId()){
            case R.id.btnSave:
                SharedPreferences.Editor edit = sp.edit();
                edit.putString("Value",edName.getText().toString().trim());
                edit.putString("Value1",edNumber.getText().toString().trim());
                edit.commit();
                break;
            case R.id.btnRead:
                String value = sp.getString("Value","Null");
                String value1 = sp.getString("Value1","Null");
                edReadName.setText(value);
                edReadNumber.setText(value1);
                break;
        }
    }
}
