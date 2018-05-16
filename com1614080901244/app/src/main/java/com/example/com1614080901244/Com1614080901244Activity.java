package com.example.com1614080901244;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;


public class Com1614080901244Activity extends AppCompatActivity {

    protected TextView textView;
    protected Button button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_com1614080901244);
        textView = findViewById(R.id.textview_01);
        button = findViewById(R.id.my_button);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Com1614080901244Activity.this, secondActivity.class);
                startActivity(intent);
            }
        });
    }

}
