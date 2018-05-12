package edu.hzuapps.androidlabs.com1614080901134;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

public class com16140809011342Activity extends AppCompatActivity {
    private int a,b,c;
    private int sum;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_com16140809011342);
        ImageButton button3 = (ImageButton) findViewById(R.id.button1);
        final TextView textView = (TextView) findViewById(R.id.textView_2);
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
    }

    
}