package com.example.com1614080901244;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class secondActivity extends AppCompatActivity {

    protected Button button1;
    protected Intent intent;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        intent = new Intent(secondActivity.this,thirdActivity.class);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_com1614080901244);
        setContentView(R.layout.activity_second);
        setTitle("app已启动");
        button1 = findViewById(R.id.my_button1);
        EditText editText = findViewById(R.id.edit_message1);
        intent.putExtra("message", editText.getText().toString().trim());
        button1.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {



                startActivity(intent);
            }
        });
                                   }

    }

