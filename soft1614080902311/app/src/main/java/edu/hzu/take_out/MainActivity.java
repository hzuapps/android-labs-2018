package edu.hzu.take_out;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button btn_jmp = findViewById(R.id.btn_jmp);
        btn_jmp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "美味与你常在", Toast.LENGTH_SHORT).show();
                Intent it=new Intent();
                it.setClass(MainActivity.this,SecondActivity.class);
                startActivity(it);
            }
        });

    }

    public class SecondActivity extends AppCompatActivity {
        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity2);
        }
    }
}


