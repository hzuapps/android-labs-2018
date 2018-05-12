  package edu.androidlabs.soft1614080902413;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class OpenActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_open);
        setTitle("皮皮钟已打开");
        Button button1 = (Button)findViewById(R.id.btn1);/*c将layout中创建的button关联起来*/
        button1.setOnClickListener(button_listener);
        Button button2 = (Button)findViewById(R.id.btn2);/*c将layout中创建的button关联起来*/
        button2.setOnClickListener(button_listener);
        Button button3 = (Button)findViewById(R.id.btn3);/*c将layout中创建的button关联起来*/
        button2.setOnClickListener(button_listener);
    }
    private Button.OnClickListener button_listener = new Button.OnClickListener(){     //创建button listener
        public void onClick(View v){

        }
    };
}
