package com1614080901228.androidlabs.hzuapps.edu.com1614080901228;
import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.view.Menu;
import android.view.MenuItem;


public class Com1614080901228Activity extends AppCompatActivity {
    private TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_com1614080901228);

        Button but1=(Button)findViewById(R.id.button1);
        but1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(Com1614080901228Activity.this,intel2Activity.class);
                startActivity(intent);
            }
        });

        Button but2=(Button)findViewById(R.id.button2);
        but2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(Com1614080901228Activity.this,appearActivity.class);
                startActivity(intent);
            }
        });

        Button but3=(Button)findViewById(R.id.button3);
        but3.setOnClickListener(new View.OnClickListener() {


            @Override
            public void onClick(View v) {
                Intent intent=new Intent(Com1614080901228Activity.this,appearActivity.class);
                startActivity(intent);


            }
        });

    }


}
