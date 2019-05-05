package edu.hzuapps.androidlabs.com1614080901144;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.nfc.Tag;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.Random;
import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;


public class com16140809011442Activity extends AppCompatActivity {
    private EditText editText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_com16140809011442);
        Button button3 = (Button) findViewById(R.id.button_3);
        Button button6=(Button)findViewById(R.id.button_6);
        button6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(com16140809011442Activity.this,thirdActivity.class);
                startActivity(intent);
            }
        });
        Button button4=(Button) findViewById(R.id.button_4);
        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Random rand = new Random();
                int a = rand.nextInt(10);
                editText = (EditText) findViewById(R.id.edit_text);
                int b = Integer.parseInt(editText.getText().toString());
                if (a == b) {
                    Toast.makeText(com16140809011442Activity.this, "恭喜你猜对了",
                            Toast.LENGTH_SHORT).show();
                }
                if (a > b) {
                    Toast.makeText(com16140809011442Activity.this, "你眼光太狭隘了",
                            Toast.LENGTH_SHORT).show();
                }
                if (a < b) {
                    Toast.makeText(com16140809011442Activity.this, "年轻人，不要看太远",
                            Toast.LENGTH_SHORT).show();
                }
                Toast.makeText(com16140809011442Activity.this,editText.getText().toString(),Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    protected void onDestroy()
    {
        super.onDestroy();
        String inputText=editText.getText().toString();
        save(inputText);
    }
    public void save(String inputText)
    {
        FileOutputStream out=null;
        BufferedWriter writer=null;
        try
        {
            out=openFileOutput("data",Context.MODE_PRIVATE);
            writer=new BufferedWriter(new OutputStreamWriter(out));
            writer.write(inputText);
        }catch (IOException e){
            e.printStackTrace();
        }
        finally {
            try{
                if(writer!=null){
                    writer.close();
                }
            }
            catch (IOException e)
            {
                e.printStackTrace();
            }
        }
    }



}




