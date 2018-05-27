package edu.hzuapps.androidlabs.com1614080901144;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class com1614080901144Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_com1614080901144);
       Button button1=(Button) findViewById(R.id.button_1);
      button1.setOnClickListener(new View.OnClickListener() {
          @Override
          public void onClick(View view) {
              Intent intent = new Intent(com1614080901144Activity.this, com16140809011442Activity.class);
              startActivity(intent);
          }
      }
        );
    }
}
