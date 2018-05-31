package com.example.wen.com1614080901115;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.content.Intent;
import android.widget.Button;

public class SecondActivity extends Activity {
    Button button1 = null;
    Button button2 = null;
    Button button3 = null;
    Button button4 = null;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        button1 = (Button)findViewById(R.id.button1);
        button1.setOnClickListener( new button1Listener());

        button2 = (Button)findViewById(R.id.button2);
        button2.setOnClickListener( new button2Listener());

        button3 = (Button)findViewById(R.id.button3);
        button3.setOnClickListener( new button3Listener());

        button4 = (Button)findViewById(R.id.button4);
        button4.setOnClickListener( new button4Listener());
    }
    class button1Listener implements OnClickListener{

        @Override
        public void onClick(View arg0) {
            // TODO Auto-generated method stub
            Intent intent = new Intent();
            intent.setClass(SecondActivity.this,Button1Activity.class);
            SecondActivity.this.startActivity(intent);
        }

    }

    class button2Listener implements OnClickListener{

        @Override
        public void onClick(View arg0) {
            // TODO Auto-generated method stub
            Intent intent = new Intent();
            intent.setClass(SecondActivity.this,Save.class);
            SecondActivity.this.startActivity(intent);
        }

    }

    class button3Listener implements OnClickListener{

        @Override
        public void onClick(View arg0) {
            // TODO Auto-generated method stub
            Intent intent = new Intent();
            intent.setClass(SecondActivity.this,Download.class);
            SecondActivity.this.startActivity(intent);
        }

    }

    class button4Listener implements OnClickListener{

        @Override
        public void onClick(View arg0) {
            // TODO Auto-generated method stub
            Intent intent = new Intent();
            intent.setClass(SecondActivity.this,Button4Activity.class);
            SecondActivity.this.startActivity(intent);
        }

    }

}