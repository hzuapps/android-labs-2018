package com.example.myapplication;

import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import java.net.URI;
import java.net.URL;
import java.util.Timer;
import  java.io.*;

public class Main2Activity extends AppCompatActivity {
    public static final String TAG = Main2Activity.class.getSimpleName();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        final Button btn2=(Button) findViewById(R.id.button2);
        final Intent intent=getIntent();
        final Intent intent1=new Intent(Main2Activity.this,Main3Activity.class);

        final pl.droidsonroids.gif.GifImageView g1=(pl.droidsonroids.gif.GifImageView)findViewById(R.id.activity_gif_giv1);
        final TextView t1=(TextView)findViewById(R.id.textView) ;
        final String n1=intent.getStringExtra("extra_n1");
        final String n2=intent.getStringExtra("extra_n2");
        final String n3=intent.getStringExtra("extra_n3");
        final String n4=intent.getStringExtra("extra_n4");
        final String n5=intent.getStringExtra("extra_n5");
        final String n6=intent.getStringExtra("extra_n6");
        intent1.putExtra("extra_n1",n1);
        intent1.putExtra("extra_n2",n2);
        intent1.putExtra("extra_n3",n3);
        intent1.putExtra("extra_n4",n4);
        intent1.putExtra("extra_n5",n5);
        intent1 .putExtra("extra_n6",n6);

        final Handler handler = new Handler();
        Button btn=(Button)findViewById(R.id.button);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
              startActivity(intent1);
            }
        });
                btn2.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        t1.setVisibility(View.INVISIBLE);
                        final int num = (int) (((Math.random() * 9 + 1) * 100) % 6 + 1);
                        final String Snum = num + "";
                        final String s = "touzi" + Snum;
                        final int Img = getResources().getIdentifier(s, "drawable", "res");

                        if (num == 1) {
                            g1.setImageResource(R.drawable.touzi1);
                            handler.postDelayed(new Runnable() {

                                @Override
                                public void run() {
                                    t1.setText(n1);
                                    t1.setVisibility(View.VISIBLE);
                                }
                            }, 1400);

                        }

                        if (num == 2) {
                            g1.setImageResource(R.drawable.touzi2);
                            handler.postDelayed(new Runnable() {

                                @Override
                                public void run() {
                                    t1.setText(n2);
                                    t1.setVisibility(View.VISIBLE);
                                }
                            }, 1400);
                        }

                        if (num == 3) {
                            g1.setImageResource(R.drawable.touzi3);
                            handler.postDelayed(new Runnable() {

                                @Override
                                public void run() {
                                    t1.setText(n3);
                                    t1.setVisibility(View.VISIBLE);
                                }
                            }, 1400);
                        }

                        if (num == 4) {
                            g1.setImageResource(R.drawable.touzi4);
                            handler.postDelayed(new Runnable() {

                                @Override
                                public void run() {
                                    t1.setText(n4);
                                    t1.setVisibility(View.VISIBLE);
                                }
                            }, 1400);
                        }

                        if (num == 5) {
                            g1.setImageResource(R.drawable.touzi5);
                            handler.postDelayed(new Runnable() {

                                @Override
                                public void run() {

                                    t1.setText(n5);
                                    t1.setVisibility(View.VISIBLE);
                                }
                            }, 1400);
                        }

                        if (num == 6) {
                            g1.setImageResource(R.drawable.touzi6);
                            handler.postDelayed(new Runnable() {

                                @Override
                                public void run() {
                                    t1.setText(n6);
                                    t1.setVisibility(View.VISIBLE);
                                }
                            }, 1400);
                        }
                    }
                });

            }
    }
