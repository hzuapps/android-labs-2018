package com.example.muren.soft1614080902142;


import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity{

    private EditText inputet;
    private Button getTime,startTime,stopTime,saveTime;
    private TextView time;
    private  int i=0;
    private  int t=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }

    private  void initView(){
        inputet =(EditText)findViewById(R.id.inputtime);
        getTime =(Button)findViewById(R.id.gettime);
        startTime=(Button)findViewById(R.id.starttime);
        stopTime =(Button)findViewById(R.id.stoptime);
        time = (TextView)findViewById(R.id.time);
        saveTime = (Button)findViewById(R.id.savetime);
        getTime.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switch (v.getId()){
                    case R.id.gettime:
                        time.setText(inputet.getText().toString());
                        i=Integer.parseInt(inputet.getText().toString());
                        break;
                    default:
                        break;
                }
            }
        });
        startTime.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {

            }
        });
        stopTime.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        saveTime.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                t = Integer.parseInt(inputet.getText().toString());
                SharedPreferences.Editor editor = getSharedPreferences("time",MODE_PRIVATE).edit();
                editor.putInt("Time",t);
                editor.apply();
            }
        });


    }
}
