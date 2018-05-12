package com.example.john.soft1614080902237;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class soft1614080902237Activity extends AppCompatActivity  {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_oft1614080902237);
        Button aaa=(Button) findViewById(R.id.b1);
        aaa.setOnClickListener(new MyOnclicklistener());
    }

   class MyOnclicklistener implements View.OnClickListener{
        public void onClick(View v){
            if(v.getId()==R.id.b1){
                Intent intent = new Intent(soft1614080902237Activity.this,Activity.class);
                startActivity(intent);
            }
        }
   }
}
