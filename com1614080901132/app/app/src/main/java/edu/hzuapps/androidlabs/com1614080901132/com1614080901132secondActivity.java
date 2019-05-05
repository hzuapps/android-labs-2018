package edu.hzuapps.androidlabs.com1614080901132;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class com1614080901132secondActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_com1614080901132second);
        final EditText editText3=(EditText)findViewById(R.id.editText_3);
        Button button4=(Button)findViewById(R.id.button_4);
        button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(com1614080901132secondActivity.this,thirdActivity.class);
                startActivity(intent);
            }
        });
        Button button3=(Button)findViewById(R.id.button_3);
        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SharedPreferences.Editor editor=getSharedPreferences("data",MODE_PRIVATE).edit();
                editor.putString("便签内容",editText3.getText().toString());
                editor.apply();
            }
        });
    }
}
