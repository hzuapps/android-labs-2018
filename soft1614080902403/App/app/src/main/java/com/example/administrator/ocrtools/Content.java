package com.example.administrator.ocrtools;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;

public class Content extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_content);

        Bundle bundle = this.getIntent().getExtras();
        String Result = bundle.getString("content");
        ((EditText)findViewById(R.id.editText)).setText(Result);

    }
}
