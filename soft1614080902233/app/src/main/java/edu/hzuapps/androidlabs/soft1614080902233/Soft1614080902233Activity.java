package edu.hzuapps.androidlabs.soft1614080902233;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import org.w3c.dom.Text;

public class Soft1614080902233Activity extends AppCompatActivity {

    private TextView textView1_1,textView1_2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_soft1614080902233);

        //textView1_1=(TextView)findViewById(R.id.button_01_01);
        textView1_2=(TextView)findViewById(R.id.textview_01_01) ;
//        textView1_1.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent intent1_1=new Intent(Soft1614080902233Activity.this,SecondActivity.class);
//                startActivity(intent1_1);
//            }
//        });
        textView1_2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent1_2=new Intent(Soft1614080902233Activity.this,SecondActivity.class);
                startActivity(intent1_2);
            }
        });


    }
}