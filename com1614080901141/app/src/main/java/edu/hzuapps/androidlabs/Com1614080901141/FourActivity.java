package edu.hzuapps.android.labs.Com1614080901141;

import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.cnt.ball.R;

public class FourActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_four);
        final EditText editText=(EditText) findViewById(R.id.editText_3);
        Button button4=(Button)findViewById(R.id.button_3);
        button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SharedPreferences.Editor editor=getSharedPreferences("data",MODE_PRIVATE).edit();
                editor.putString("发帖的内容",editText.getText().toString());
                editor.apply();
            }
        });
    }
;}
