package com.example.administrator.soft1614080902230;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class soft1614080902230Activity extends AppCompatActivity {
    private Button button;
    private Button button_download;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_soft1614080902230);
        button=(Button)findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(soft1614080902230Activity.this,secondActivity.class);
                startActivity(intent);
            }
        });
        button_download=(Button)findViewById(R.id.download);
        button_download.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(soft1614080902230Activity.this,ThirdActivity.class);
                startActivity(intent);
            }
        });

    }
}
