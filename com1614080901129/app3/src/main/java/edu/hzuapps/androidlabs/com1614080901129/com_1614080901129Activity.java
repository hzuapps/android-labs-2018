package edu.hzuapps.androidlabs.com1614080901129;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

public class com_1614080901129Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_com_1614080901129);
       ImageButton button=(ImageButton)findViewById(R.id.button_2);
       button.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {
               Intent intent=new Intent(com_1614080901129Activity.this,com1614080901129thirdActivity.class);
               startActivity(intent);
           }
       });




    }
    }
