package com.example.mr_ke.text5;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class InternalDataReadActivity extends AppCompatActivity{
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.result);
        FileInputStream fis=null;
        byte[] buffer=null;
        try{
            fis=openFileInput("login");
            buffer=new byte[fis.available()];
            fis.read(buffer);
        }catch (FileNotFoundException e){
            e.printStackTrace();
        }catch (IOException e){
            e.printStackTrace();
        }finally{
            if(fis!=null){
                try{
                    fis.close();
                }catch (IOException e){
                    e.printStackTrace();
                }
            }
        }
        TextView usernameTV= findViewById(R.id.username);
        TextView passwordTV= findViewById(R.id.password);
        String data=new String(buffer);
        String username=data.split(" ")[0];
        String password=data.split(" ")[1];
        usernameTV.setText("用户名: "+username);
        passwordTV.setText("密  码: "+password);
    }
}
