package edu.hzuapps.androidlabs.Com1614080901210.Com1614080901210Activity.java;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Com1614080901210 extends AppCompatActivity {
    private Button btn1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_com1614080901210);
       btn1=findViewById(R.id.btn_1);
       btn1.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               Intent intent=new Intent(Com1614080901210.this,secondActivity.class);
               startActivity(intent);
           }
       });
    }
}
