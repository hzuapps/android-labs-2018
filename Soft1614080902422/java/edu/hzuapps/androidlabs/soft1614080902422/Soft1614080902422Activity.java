package edu.hzuapps.androidlabs.soft1614080902422;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Soft1614080902422Activity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_soft1614080902422);
        Button bt1 = (Button) findViewById(R.id.b1);
        Button bt2 = (Button) findViewById(R.id.b2);

        bt1.setOnClickListener(this);
        bt2.setOnClickListener(this);
    }




    @Override
    public void onClick(View v) {
         switch (v.getId()){
             case R.id.b1:
                 Intent i1 = new Intent(this,Soft1614080902422Activity_01.class);
                 startActivity(i1);
                 break;
             case R.id.b2:
                 Intent i2 = new Intent(this,Soft1614080902422Activity_02.class);
                 startActivity(i2);
                 break;
         }
    }
}


