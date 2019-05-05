package com.example.jeremy.soft1613071002205;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.util.Map;

public class User extends AppCompatActivity {

    private Button mReturnButton;
    private Button download;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.mynews);
        mReturnButton = (Button) findViewById(R.id.returnback);

        Button download = findViewById(R.id.download);
        download.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(User.this, DownloadActivity.class);
                startActivity(i);
            }

        });
    }




    public void back_to_login(View view) {
        Intent intent3 = new Intent(User.this,MainActivity.class) ;
        startActivity(intent3);
        finish();
    }





}