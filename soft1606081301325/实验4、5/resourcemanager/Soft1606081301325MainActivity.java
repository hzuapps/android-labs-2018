package com.example.asus.resourcemanager;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Soft1606081301325MainActivity extends AppCompatActivity {


    private TextView textView0;
    private TextView textView1;
    private TextView textView2;
    private TextView textView3;
    private Button button01;
    private Button button02;
    private Button button03;
    private Button button04;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_soft1606081301325_main);
        textView0=(TextView)findViewById(R.id.textview_01);
        textView1=(TextView)findViewById(R.id.textview_02);
        textView2=(TextView)findViewById(R.id.textview_03);
        textView3=(TextView)findViewById(R.id.textview_04);
        button01=(Button) findViewById(R.id.button01);
        button02=(Button) findViewById(R.id.button02);
        button03=(Button) findViewById(R.id.button03);
        button04=(Button) findViewById(R.id.button04);


        textView0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent=new Intent(Soft1606081301325MainActivity.this,SecondActivity.class);
                startActivity(intent);
            }
        }
        );

        textView1.setOnClickListener(new View.OnClickListener() {
                                         @Override
                                         public void onClick(View v) {

                                             Intent intent=new Intent(Soft1606081301325MainActivity.this,pptActivity.class);
                                             startActivity(intent);
                                         }
                                     }
        );

        textView2.setOnClickListener(new View.OnClickListener() {
                                         @Override
                                         public void onClick(View v) {

                                             Intent intent=new Intent(Soft1606081301325MainActivity.this,xlsActivity.class);
                                             startActivity(intent);
                                         }
                                     }
        );

        textView3.setOnClickListener(new View.OnClickListener() {
                                         @Override
                                         public void onClick(View v) {

                                             Intent intent=new Intent(Soft1606081301325MainActivity.this,txtActivity.class);
                                             startActivity(intent);
                                         }
                                     }
        );

        button01.setOnClickListener(new View.OnClickListener() {
                                        @Override
                                        public void onClick(View v) {

                                            Intent intent=new Intent(Soft1606081301325MainActivity.this,save.class);
                                            startActivity(intent);
                                        }
                                    }
        );

        button02.setOnClickListener(new View.OnClickListener() {
                                        @Override
                                        public void onClick(View v) {

                                            Intent intent=new Intent(Soft1606081301325MainActivity.this,save.class);
                                            startActivity(intent);
                                        }
                                    }
        );

        button03.setOnClickListener(new View.OnClickListener() {
                                        @Override
                                        public void onClick(View v) {

                                            Intent intent=new Intent(Soft1606081301325MainActivity.this,save.class);
                                            startActivity(intent);
                                        }
                                    }
        );

        button04.setOnClickListener(new View.OnClickListener() {
                                         @Override
                                         public void onClick(View v) {

                                             Intent intent=new Intent(Soft1606081301325MainActivity.this,save.class);
                                             startActivity(intent);
                                         }
                                     }
        );

    }
}
