package com.example.asus.soft1614080902307;

import android.content.Context;
import android.content.ContextWrapper;
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


public class soft16140809023071Activity extends AppCompatActivity {
    private EditText editText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_soft16140809023071);
        Button button = (Button) findViewById(R.id.button_1);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Random rand = new Random();
                int a = rand.nextInt(10);
                editText = (EditText) findViewById(R.id.edit_text);
                int b = Integer.parseInt(editText.getText().toString());
                if (a == b) {
                    Toast.makeText(soft16140809023071Activity.this, "恭喜您猜对了",
                            Toast.LENGTH_SHORT).show();
                }else if (a > b) {
                    Toast.makeText(soft16140809023071Activity.this, "抱歉了哦，你猜得可能有点小了哦，再试试吧",
                            Toast.LENGTH_SHORT).show();
                }else if(a < b) {
                    Toast.makeText(soft16140809023071Activity.this, "哦不，有点大了哦，要不再想想？",
                            Toast.LENGTH_SHORT).show();
                }
                String inputText=editText.getText().toString();
                save(inputText);
            }
        });
    }

    public void save(String inputText)
    {
        FileOutputStream out=null;
        BufferedWriter writer=null;
        try
        {
            out=openFileOutput("data", ContextWrapper.MODE_APPEND);
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




