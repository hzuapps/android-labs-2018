package edu.hzuapps.androidlabs.soft1614080902318;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Soft1614080902318Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_soft1614080902318);
        Button button_start = (Button)findViewById(R.id.start);
        button_start.setOnClickListener(new MyOnClickListener());
    }

    class MyOnClickListener implements View.OnClickListener{
         @Override
         public void onClick(View v){
             if(v.getId()==R.id.start) {
                 Intent intent = new Intent(Soft1614080902318Activity.this,startActivity.class);
                 startActivity(intent);
             }
         }
    }
}
