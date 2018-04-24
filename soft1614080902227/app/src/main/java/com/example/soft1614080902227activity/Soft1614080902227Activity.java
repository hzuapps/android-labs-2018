package com.example.soft1614080902227activity;


import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;

public class Soft1614080902227Activity extends AppCompatActivity{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_CUSTOM_TITLE);
        Button btn_Click = (Button)findViewById(R.id.Air);
        Button btn_Click1 = (Button)findViewById(R.id.TV);
        btn_Click.setOnClickListener(new MyOnClickListener());
        btn_Click1.setOnClickListener(new MyOnClickListener1());
    }
    class MyOnClickListener implements View.OnClickListener{
        @Override
        public void onClick(View v){
            if(v.getId()==R.id.Air) {
                Intent intent = new Intent(Soft1614080902227Activity.this,Remote_0f_Air.class);
                startActivity(intent);
            }
        }

    }
    class MyOnClickListener1 implements View.OnClickListener{
        @Override
        public void onClick(View v){
            if(v.getId()==R.id.TV) {
                Intent intent1 = new Intent(Soft1614080902227Activity.this,Remote_of_TV.class);
                startActivity(intent1);
            }
        }

    }
}
