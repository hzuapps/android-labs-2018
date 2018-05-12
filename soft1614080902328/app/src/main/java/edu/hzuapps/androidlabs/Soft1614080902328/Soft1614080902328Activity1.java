package edu.hzuapps.androidlabs.Soft1614080902328;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Soft1614080902328Activity1 extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.soft_1614080902328_activity1);
        Button button1=(Button)findViewById(R.id.button_2);
        button1.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent intent=new Intent(Soft1614080902328Activity1.this,Soft1614080902328Activity2.class);
                startActivity(intent);
            }
        });
    }




}
