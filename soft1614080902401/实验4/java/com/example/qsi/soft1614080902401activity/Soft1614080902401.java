package com.example.qsi.soft1614080902401activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class Soft1614080902401 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_soft1614080902401);

    }

    public void lishijilu(View view) {
        Button btn = (Button)findViewById(R.id.button);
        Toast.makeText(this,"查询成功",Toast.LENGTH_SHORT).show();
    }

    public void jilu(View view) {
        Intent intent = new Intent(Soft1614080902401.this, Soft16140809024012.class);
        startActivity(intent);
    }
}