package com.example.hzu.soft1614080902437;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import org.w3c.dom.Text;

public class soft1614080902437Activity_2 extends AppCompatActivity {

    private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_soft1614080902437_2);

        textView=(TextView)findViewById(R.id.ic_launcher);

        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(soft1614080902437Activity_2.this,soft1614080902437Activity_2.class);
                startActivity(intent);
            }
        });



    }
}