package com.example.gwl20.soft1614080902204;


import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class soft1614080902204Activity extends AppCompatActivity {

    private TextView textView;

    @Override

    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_soft1614080902204);
        textView=(TextView)findViewById(R.id.textview_01);

        textView.setOnClickListener(new View.OnClickListener() {

            @Override

            public void onClick(View v) {
                Intent intent=new Intent(soft1614080902204Activity.this,soft1614080902204BActivity.class);
                startActivity(intent);
            }

        });

    }

}