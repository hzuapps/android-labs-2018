package com.example.administrator.com1614080901126;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

/**
 * Created by Administrator on 2018/5/31.
 */

public class zengfiora4 extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.zengfiora);
        Button but1=(Button)findViewById(R.id.button1);
        but1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(zengfiora4.this,MainActivity4.class);
                startActivity(intent);
            }
        });
    }
}

