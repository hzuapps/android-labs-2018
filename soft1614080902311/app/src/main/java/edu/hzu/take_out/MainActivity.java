package edu.hzu.take_out;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity3);
     Button btn_jmp = findViewById(R.id.btn_jmp);
        ImageButton ib_add=findViewById(R.id.ib_add);


        btn_jmp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "美味与你常在", Toast.LENGTH_SHORT).show();
                Intent it=new Intent();
                it.setClass(MainActivity.this,Activity3.class);
                startActivity(it);
            }
        });
        ib_add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent it=new Intent();
                it.setClass(MainActivity.this,Activity2.class);
                startActivity(it);
            }
        });

    }

    public class Activity2 extends AppCompatActivity {
        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity2);
        }
    }

    public class Activity3 extends AppCompatActivity {
        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity3);
        }

    }
}
