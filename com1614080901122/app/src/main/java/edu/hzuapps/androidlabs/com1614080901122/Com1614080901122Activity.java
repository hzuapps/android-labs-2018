package edu.hzuapps.androidlabs.com1614080901122;



import android.content.Intent;

import android.support.v7.app.AppCompatActivity;

import android.os.Bundle;

import android.view.View;

import android.widget.Button;
import android.widget.TextView;
import java.io.*;
import android.widget.*;



import org.w3c.dom.Text;



public class Com1614080901122Activity extends AppCompatActivity {

   private EditText textBox;
   private static final int READ_BLOCK_SIZE=100;

    private TextView textView;
    private Button newbutton;


    @Override

    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);
        textBox=(EditText) findViewById(R.id.txtText1);
        Button saveBtn=(Button) findViewById(R.id.btnSave);
        Button loadBtn=(Button) findViewById(R.id.btnLoad);

        saveBtn.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                String str=textBox.getText().toString();
                try
                {
                    FileOutputStream fOut=
                            openFileOutput("textfile.txt",
                             MODE_WORLD_READABLE);
                    OutputStreamWriter osw=new
                            OutputStreamWriter(fOut);
                    osw.write(str);
                    osw.flush();
                    osw.close();
                    Toast.makeText(getBaseContext(),
                            "数据保存成功！",
                            Toast.LENGTH_SHORT).show();

                    textBox.setText("");
                }
                catch (IOException ioe)
                {
                    ioe.printStackTrace();
                }
            }
        });

        loadBtn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                try
                {
                    FileInputStream fIn=
                            openFileInput("textfile.txt");
                    InputStreamReader isr=new
                            InputStreamReader(fIn);
                    char[] inputBuffer=new char[READ_BLOCK_SIZE];
                    String s="";

                    int charRead;
                    while ((charRead=isr.read(inputBuffer))>0)
                    {
                        String readString=
                                String.copyValueOf(inputBuffer,0,
                                        charRead);
                        s+=readString;
                        inputBuffer=new char[READ_BLOCK_SIZE];
                    }
                    textBox.setText(s);
                    Toast.makeText(getBaseContext(),
                            "数据加载成功！",
                            Toast.LENGTH_SHORT).show();
                }
                catch (IOException ioe){
                    ioe.printStackTrace();
                }
            }
        });


        textView=(TextView)findViewById(R.id.textview_01);



        textView.setOnClickListener(new View.OnClickListener() {

            @Override

            public void onClick(View v) {

                Intent intent=new Intent(Com1614080901122Activity.this,second1614080901122Ativity.class);

                startActivity(intent);

            }

        });
        newbutton=(Button)findViewById(R.id.button3);
        newbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Com1614080901122Activity.this,second1614080901122Ativity.class);
                startActivity(intent);
            }
        });







    }

}