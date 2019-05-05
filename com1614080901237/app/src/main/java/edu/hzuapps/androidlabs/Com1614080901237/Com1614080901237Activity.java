package edu.hzuapps.androidlabs.Com1614080901237;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import com.example.myapplication.R;



public class Com1614080901237Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_com1614080901237);
        Button button1=(Button) findViewById(R.id.tianjia);
        Button button2=(Button) findViewById(R.id.chakan);
        Button button3=(Button) findViewById(R.id.xiazai);
        button1.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent intent=new Intent(Com1614080901237Activity.this,secondActivity.class);
                startActivity(intent);
            }
        });
        button2.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent intent=new Intent(Com1614080901237Activity.this,thirdActivity.class);
                startActivity(intent);
            }
        });
        button3.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent intent=new Intent(Com1614080901237Activity.this,fourthActivity.class);
                startActivity(intent);
            }
        });
    }

}
