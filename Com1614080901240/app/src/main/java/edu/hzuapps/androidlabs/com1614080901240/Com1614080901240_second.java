package edu.hzuapps.androidlabs.com1614080901240;

import android.content.ContextWrapper;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.EditText;
import android.widget.Button;

import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;

        public class Com1614080901240_second extends AppCompatActivity {

            @Override
    protected void onCreate(Bundle savedInstanceState) {
                super.onCreate(savedInstanceState);
                setContentView(R.layout.activity_com1614080901240_second);
                Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
                setSupportActionBar(toolbar);

                        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
                   fab.setOnClickListener(new View.OnClickListener() {
            @Override
               public void onClick(View view) {
                                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                                                .setAction("Action", null).show();
                            }
        });

                ((Button) findViewById(R.id.button_save)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                                        String text = ((EditText) findViewById(R.id.editText)).getText().toString();
                                        save(text);
                                    }
        });
            }
            public void save(String text){
                        FileOutputStream out=null;
                       BufferedWriter writer=null;
                       try{
                               out=openFileOutput("recorder", ContextWrapper.MODE_APPEND);
                               writer=new BufferedWriter(new OutputStreamWriter(out));
                               writer.write(text);
                           }catch (IOException e){
                               e.printStackTrace();
                           }finally {
                               try {
                                       if(writer!=null){
                                               writer.close();
                                           }
                                   }catch (IOException e){
                                       e.printStackTrace();
                                   }
                           }
                   }
        }
