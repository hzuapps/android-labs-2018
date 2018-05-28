package edu.hzuapps.androidlabs.soft1614080902444;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

 import android.content.Intent;

 import android.view.View;
 import android.widget.Button;

public class Soft1614080902444Activity extends AppCompatActivity {
      private Button btnStartAty1;
    @Override
     protected void onCreate(Bundle savedInstanceState) {
               super.onCreate(savedInstanceState);
               setContentView(R.layout.activity_soft1614080902444);
               btnStartAty1=(Button) findViewById(R.id.btnStartAty1);
               btnStartAty1.setOnClickListener(new View.OnClickListener() {
              @Override
               public void onClick(View v) {
                  Intent i = new Intent(Soft1614080902444Activity.this, MyTabActivity.class);
                  startActivity(i);
                  Soft1614080902444Activity.this.finish();
                           }
         });
    }
 }