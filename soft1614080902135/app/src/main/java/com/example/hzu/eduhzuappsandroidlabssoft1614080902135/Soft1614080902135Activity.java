package com.example.hzu.eduhzuappsandroidlabssoft1614080902135;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import org.w3c.dom.Text;

public class Soft1614080902135Activity extends AppCompatActivity {

    private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_soft1614080902135);

        textView=(TextView)findViewById(R.id.ic_launcher);

        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(Soft1614080902135Activity.this,Soft1614080902135Activity2.class);
                startActivity(intent);
            }
        });



    }
}
