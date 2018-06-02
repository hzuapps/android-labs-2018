package edu.hzuapps.androidlabs.com1614080901241;

import android.content.Intent;

import android.support.v7.app.AppCompatActivity;

import android.os.Bundle;

import android.view.View;

import android.widget.TextView;

import android.widget.Button;

import android.os.Handler;

import org.w3c.dom.Text;

import android.widget.ImageView;

import java.io.File;

import org.w3c.dom.Text;

public class com1614080901241Activity extends AppCompatActivity{
    private TextView textView;
    private ImageView fengjing;
    private Handler handler=new Handler();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_com1614080901241);
        textView=(TextView)findViewById(R.id.textview_01);
        fengjing=(ImageView)findViewById(R.id.imageView_fengjing);

        textView.setOnClickListener(new View.OnClickListener() {

            @Override

            public void onClick(View v) {

                Intent intent=new Intent(com1614080901241Activity.this,SecondActivity.class);

                startActivity(intent);

            }

        });
        ((Button)findViewById(R.id.button_xiazai)).setOnClickListener(new View.OnClickListener() {

            @Override

            public void onClick(View v) {

                new beijing("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1527775051444&di=04824319c9614545e0f903a834aa22f3&imgtype=0&src=http%3A%2F%2Fimgsrc.baidu.com%2Fimage%2Fc0%253Dpixel_huitu%252C0%252C0%252C294%252C40%2Fsign%3D8ee2712e49a7d933aba5ec33c433b47f%2Fa8773912b31bb0517948f8123d7adab44aede098.jpg",fengjing,handler).start();

            }});
    }
}
