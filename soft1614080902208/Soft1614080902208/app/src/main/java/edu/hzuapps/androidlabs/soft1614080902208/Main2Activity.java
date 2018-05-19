package com.example.soft1614080902208;
import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;


public class Main2Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        final Activity thisAtivity=this;
        Button button1=(Button) findViewById(R.id.zhigong);
        Button button2=findViewById(R.id.shangping);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(v.getId() ==R.id.zhigong){
                    Intent intent=new Intent(Main2Activity.this,StaffActivity.class);
                    startActivity(intent);
                }

            }
        });
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(v.getId() ==R.id.shangping){
                    Intent intent=new Intent(Main2Activity.this,GoodsActivity.class);
                    startActivity(intent);
                }

            }
        });

    }
}
