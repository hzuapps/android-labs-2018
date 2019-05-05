package com.example.jeremy.soft1613071002205;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

public class Main2Activity extends AppCompatActivity {
    private TextView mTextViewGetUserName;
    private TextView mTextViewGetPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.mynews);
        mTextViewGetUserName = (TextView) findViewById(R.id.textView2);
        mTextViewGetPassword = (TextView) findViewById(R.id.textView3);
        Bundle b = getIntent().getBundleExtra("data");
        String getStringUserName = b.getString("username");
        mTextViewGetUserName.setText(getStringUserName);
        String getStringPassword = b.getString("password");
        mTextViewGetPassword.setText(getStringPassword);


    }
}
