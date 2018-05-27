package com.example.mr_ke.text5;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        final EditText usernameET= findViewById(R.id.username);
        final EditText passwordET= findViewById(R.id.password);
        Button login= findViewById(R.id.login);
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String username=usernameET.getText().toString();
                String password=passwordET.getText().toString();
                FileOutputStream fos=null;
                try{
                    fos=openFileOutput("login",MODE_PRIVATE);
                    fos.write((username+""+password).getBytes());
                    fos.flush();
                }catch (FileNotFoundException e){
                    e.printStackTrace();
                }catch (IOException e){
                    e.printStackTrace();
                }finally {
                    if(fos!=null){
                        try{
                            fos.close();
                        }catch (IOException e){
                            e.printStackTrace();
                        }
                    }
                }
                Intent intent=new Intent();
                intent.setClass(MainActivity.this,InternalDataReadActivity.class);
                startActivity(intent);
            }
        });
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}
