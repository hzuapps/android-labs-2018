package edu.hzuapps.androidlabs.Com1614080901237;

import android.support.v4.text.TextUtilsCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.EditText;
import android.widget.Toast;

import com.example.myapplication.R;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class thirdActivity extends AppCompatActivity {

    private EditText edit;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third);
        edit=(EditText)findViewById(R.id.watch);
        String inputText=load();
        if(!TextUtils.isEmpty(inputText)){
            edit.setText(inputText);
            edit.setSelection(inputText.length());
            Toast.makeText(this,"Restoring succeeded",Toast.LENGTH_SHORT).show();
        }
    }
    public String load(){
        FileInputStream in =null;
        BufferedReader reader=null;
        StringBuilder content=new StringBuilder();
        try{
            in=openFileInput("data");
            reader=new BufferedReader(new InputStreamReader(in));
            String line="";
            while((line=reader.readLine())!=null){
                content.append(line);
            }
        }catch (IOException e){
            e.printStackTrace();
        }finally {
            if(reader!=null){
                try{
                    reader.close();
                }catch (IOException e){
                    e.printStackTrace();
                }
            }
        }
        return content.toString();
    }
}
