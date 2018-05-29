package com.example.myapplication;

import android.content.ContextWrapper;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;

        import android.os.Bundle;

        import android.widget.Button;

        import android.widget.EditText;

        import android.widget.TextView;

        import org.w3c.dom.Text;



        import java.io.BufferedWriter;

        import java.io.FileInputStream;

        import java.io.FileOutputStream;

        import java.io.IOException;

        import java.io.OutputStreamWriter;



        import android.view.View;

        import android.widget.Toast;



public class Main3Activity extends AppCompatActivity {



    @Override

    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main3);
        Intent intent=getIntent();
        final String n1=intent.getStringExtra("extra_n1");
        final String n2=intent.getStringExtra("extra_n2");
        final String n3=intent.getStringExtra("extra_n3");
        final String n4=intent.getStringExtra("extra_n4");
        final String n5=intent.getStringExtra("extra_n5");
        final String n6=intent.getStringExtra("extra_n6");

        ((Button) findViewById(R.id.btn_save)).



                setOnClickListener(new View.OnClickListener() {

                    @Override

                    public void onClick(View v) {

                        String text = n1+n2+n3+n4+n5+n6;

                        save(text);

                    }

                });

        ((Button) findViewById(R.id.btn_read)).



                setOnClickListener(new View.OnClickListener() {

                    @Override

                    public void onClick(View v) {

                        readsy5();

                    }

                });





    }



    public void save(String text) {

        FileOutputStream out = null;

        BufferedWriter writer = null;

        try {

            out = openFileOutput("sy5.txt", ContextWrapper.MODE_APPEND);

            writer = new BufferedWriter(new OutputStreamWriter(out));

            writer.write(text);

        } catch (IOException e) {

            e.printStackTrace();

        } finally {

            try {

                if (writer != null) {

                    writer.close();

                }

            } catch (IOException e) {

                e.printStackTrace();

            }

            Toast.makeText(Main3Activity.this, "数据保存成功", Toast.LENGTH_SHORT).show();

        }

    }



    public void readsy5() {

        String content = "";

        try {

            FileInputStream fis = openFileInput("sy5.txt");

            byte[] buffer = new byte[fis.available()];

            fis.read(buffer);

            content = new String(buffer);

            fis.close();

        } catch (Exception e) {

            e.printStackTrace();

        }

        Toast.makeText(Main3Activity.this, "保存的数据是" + content, Toast.LENGTH_SHORT).show();

    }

}