package edu.hzuapps.androidlabs.Com1614080901206;

import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.huishouzhan.R;

public class SecondActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        Button tijiao=(Button) findViewById(R.id.tijiao);
        final EditText editText=(EditText) findViewById(R.id.edit_text);
        tijiao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String inputText=editText.getText().toString();
                SharedPreferences.Editor editor=getSharedPreferences("shangpin",MODE_PRIVATE).edit();
                editor.putString("dongxi",inputText);
                editor.apply();
            }
        });
    }
}
