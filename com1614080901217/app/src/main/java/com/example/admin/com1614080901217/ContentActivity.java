package com.example.admin.com1614080901217;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class ContentActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_content);
        String content = getIntent().getStringExtra("content");
        TextView contentView = (TextView) findViewById(R.id.content);
        contentView.setText(content);
    }
}
