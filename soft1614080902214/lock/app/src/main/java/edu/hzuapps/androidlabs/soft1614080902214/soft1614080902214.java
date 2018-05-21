package edu.hzuapps.androidlabs.soft1614080902214;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import org.w3c.dom.Text;

public class soft1614080902214 extends AppCompatActivity {

    private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        }

    public void click(View v) {
        Intent intent=new Intent();
        intent.setClass(soft1614080902214.this, SecondActivity.class);
        startActivity(intent);
    }
    }
