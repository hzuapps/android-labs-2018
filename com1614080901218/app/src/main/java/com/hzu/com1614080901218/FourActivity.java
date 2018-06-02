package com.hzu.com1614080901218;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;



/**

 * Created by 76027 on 2018/5/29.

 */



public class FourActivity extends AppCompatActivity {

    private EditText et;

    private Button bt;



    private TextView textView;



    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_four);

//        实例化控件

        initData();



        //实现跳转



        textView=(TextView)findViewById(R.id.button7);

        textView.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v){



                Intent intent=new Intent(FourActivity.this,Com1614080901218Activity.class);

                startActivity(intent);

            }});

        textView=(TextView)findViewById(R.id.button5);

        textView.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v){

                save();

                Intent intent=new Intent(FourActivity.this,FifthActivity.class);

                startActivity(intent);

            }});



    }







    private void initData(){

        et=(EditText)findViewById(R.id.editText8);

        bt=(Button)findViewById(R.id.button5);





    }







    public void save() {

        String data=et.getText().toString();

        FileOutputStream out = null;

        BufferedWriter writer = null;

        try {

            //设置文件名称，以及存储方式



            out = openFileOutput("data1", Context.MODE_PRIVATE);

            //创建一个OutputStreamWriter对象，传入BufferedWriter的构造器中

            writer = new BufferedWriter(new OutputStreamWriter(out));

            //向文件中写入数据

            writer.write(data);



        } catch (IOException e) {

            e.printStackTrace();

        } finally {

            try {

                writer.close();

            } catch (IOException e) {

                e.printStackTrace();

            }

        }

    }





}