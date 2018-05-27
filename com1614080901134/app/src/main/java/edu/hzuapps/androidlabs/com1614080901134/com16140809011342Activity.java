package edu.hzuapps.androidlabs.com1614080901134;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

public class com16140809011342Activity extends AppCompatActivity {
    private int a,b,c;
    private int sum;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_com16140809011342);
        Button button9=(Button) findViewById(R.id.button_3);
        ImageButton button3 = (ImageButton) findViewById(R.id.button1);
        final TextView textView = (TextView) findViewById(R.id.textView_2);
        Button button_9=(Button)findViewById(R.id.button9);
        button_9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(com16140809011342Activity.this,thirdActivity.class);
                startActivity(intent);
            }
        });
        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                textView.setText(Integer.valueOf(textView.getText().toString()) + 1 + "");
            }
        });
        ImageButton button4 = (ImageButton) findViewById(R.id.button);
        button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                textView.setText(Integer.valueOf(textView.getText().toString()) - 1 + "");
            }
        });
        ImageButton button7 = (ImageButton) findViewById(R.id.button_7);
        final TextView textView4 = (TextView) findViewById(R.id.textView_4);
        button7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                textView4.setText(Integer.valueOf(textView4.getText().toString()) - 1 + "");
            }
        });
        ImageButton button8 = (ImageButton) findViewById(R.id.button_8);
        button8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                textView4.setText(Integer.valueOf(textView4.getText().toString()) + 1 + "");
            }
        });
        ImageButton button5 = (ImageButton) findViewById(R.id.button_5);
        final TextView textView3 = (TextView) findViewById(R.id.textView_3);
        button5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                textView3.setText(Integer.valueOf(textView3.getText().toString()) - 1 + "");
            }
        });
        ImageButton button6 = (ImageButton) findViewById(R.id.button_6);
        button6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                textView3.setText(Integer.valueOf(textView3.getText().toString()) + 1 + "");
            }
        });
        final TextView text_view3 = (TextView) findViewById(R.id.text_view3);
        a =Integer.parseInt(textView.getText().toString()) ;
        b = Integer.parseInt(textView3.getText().toString());
        c=Integer.parseInt(textView4.getText().toString()) ;
        sum=a*50+b*80+c*20;
        text_view3.setText(""+sum+"");
        button9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SharedPreferences.Editor editor=getSharedPreferences("data",MODE_PRIVATE).edit();
                editor.putString("低级蛋糕数量",textView.getText().toString());
                editor.putString("中级蛋糕数量",textView3.getText().toString());
                editor.putString("小蛋糕数量",textView4.getText().toString());
                editor.apply();

            }
        });

    }



    
}