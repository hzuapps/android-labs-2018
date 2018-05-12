package com.example.administrator.soft1614080902404;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class soft1614080902404 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_soft1614080902404);
    }

    private Button.OnClickListener button_listener = new Button.OnClickListener() {     //创建button listener
        public void onClick(View v) {

            Intent intent = new Intent();
            intent.setClass(soft1614080902404.this, otherActivity.class);
            startActivity(intent);

        }



    };
}
