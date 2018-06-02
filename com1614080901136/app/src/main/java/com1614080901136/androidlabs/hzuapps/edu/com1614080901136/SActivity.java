package com1614080901136.androidlabs.hzuapps.edu.com1614080901136;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;


public class SActivity extends AppCompatActivity  {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shared);
        final EditText editText = (EditText) findViewById(R.id.edit_text);
        Button queryButton = (Button) findViewById(R.id.query);
        queryButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences sharedPreferences = getSharedPreferences("jc", Context.MODE_PRIVATE);
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.putString("username", editText.getText().toString());
                editor.commit();
                Intent intent = new Intent( SActivity .this,firstActivity .class);
                startActivity(intent);

            }
        }
    }
}
