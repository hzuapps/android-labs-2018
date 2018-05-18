package com1614080901225.androidlabs.hzuapps.edu.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;


public class com1614080901225Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.com1614080901225Activity.java);
        Button button1 = (Button)findViewById(R.id.my_button);/*c将layout中创建的button关联起来*/
        button1.setOnClickListener(button_listener);
    }
    private Button.OnClickListener button_listener = new Button.OnClickListener(){     //创建button listener
        public void onClick(View v){

            Intent intent = new Intent();
            intent.setClass(com1614080901225Activity.this, TaskbarActivity.class);
            startActivity(intent);

        }
    };
}
