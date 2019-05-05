package edu.hzuapps.androidlabs.soft1614080902432.qzy02;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import android.content.ContextWrapper;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import org.w3c.dom.Text;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.text.BreakIterator;

import android.view.View;
import android.widget.Toast;

public class Soft1614080902432 extends AppCompatActivity {

    private Button b1,b2;
    private EditText e1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_soft1614080902432);


        final Soft1614080902432 thisActivity =this;

        //关联
        b1=(Button)findViewById(R.id.b1);
        b2=(Button)findViewById((R.id.b2));
        e1 = (EditText) findViewById(R.id.e1);


        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                save();
            }
        });

        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                read();
            }
        });



    }







    public void save() {
        String content=e1.getText().toString();
        FileOutputStream fos=null;
        BufferedWriter writer =null;
        try{
            fos=openFileOutput("1.txt", Context.MODE_PRIVATE);
            writer=new BufferedWriter(new OutputStreamWriter(fos));
            writer.write(content);
            writer.flush();
            Toast.makeText(this,"亮度大小存储成功",Toast.LENGTH_SHORT).show();


        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try{
                if(writer!=null){
                    writer.close();

                }if (fos!=null){
                    fos.close();

                }


            } catch (IOException e) {
                e.printStackTrace();
            }
        }


    }




    public void read() {
        BufferedReader br =null;
        StringBuilder sb =new StringBuilder();
        try{
            br= new BufferedReader(new InputStreamReader(openFileInput("1.txt")));
            String content=br.readLine();
            while (content!=null){
                sb.append(content);
                content=br.readLine();
            }

            e1.setText(sb.toString());
            Toast.makeText(this, "查找亮度大小完成", Toast.LENGTH_SHORT).show();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try{
                if(br!=null){
                    br.close();
                }

            } catch (IOException e) {
                e.printStackTrace();
            }
        }


    }


}