package com.zhancruilenovo.eduhzuappsandroidlabssoft161408090243;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.StringReader;


public class OpenActivity extends AppCompatActivity {
    private String filename="text";
    private EditText et;
    private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_open);


        final  OpenActivity thisActivity = this;
        Intent intent = new Intent(thisActivity,  OpenActivity.class);
        thisActivity.startActivity(intent);
        et =findViewById(R.id.editText);
        Object show = (TextView) findViewById(R.id.textview_01);
        findViewById(R.id.Startbutton).setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        findViewById(R.id.buttonjson).setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(OpenActivity.this,AnotherAty.class));
            }
        });

        Button btnOpen = (Button) findViewById(R.id.button_open);
        btnOpen.setOnClickListener( new OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    FileOutputStream fos =openFileOutput(filename, Context.MODE_PRIVATE);

                     OutputStreamWriter osw = OutputStreamWriter(fos, "UTF-8") {
                           try {
                            osw.write(et.getText().toString());
                            osw.flush();
                            fos.flush();
                            osw.close();
                            fos.close();
                            Toast.makeText(getApplicationContext(),"输入完成",Toast.LENGTH_SHORT).show();
                        } catch (FileNotFoundException e) {
                            e.printStackTrace();
                            findViewById(R.id.Readbutton).setOnClickListener(new OnClickListener());
                               public void onClick(View view){
                                   try{FileInputStreame  fis =openFileInput(filename);
                                       InputStreamReader is = new InputStreamReader(fis,"UTF-8");
                                       char input[] =new char[fis.available()];
                                       is.read(input);
                                      is.close();
                                       fis.close();
                                       String Readed =new String(input);
                                       show.settext(Readed);


                                     } catch (IOException e) {
                             e.printStackTrace();
                                   } catch (IOException e) {
                                       e.printStackTrace();
                                   }
                }

            } catch (IOException e) {
                               e.printStackTrace();
                           }
                    };
    }
})
        }