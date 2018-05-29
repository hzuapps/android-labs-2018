package edu.hzuapps.androidlabs.soft1614080902218;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;

import java.io.DataInputStream;
import java.io.FileDescriptor;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

public class SecordActivity extends AppCompatActivity {
    private  TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
                super.onCreate(savedInstanceState);
                setContentView(R.layout.activity_secord);
                //String buffer= new String() ;
                //buffer = "达会计师对巴萨卡的巴萨肯德基";
                //buffer = read();
                //textView=(TextView)findViewById(R.id.wendu);
                //textView.setText(new String(buffer));

                //String s = textView.getText().toString();

                //if(!s.isEmpty())
                    //write(s);
                doRaw();

    }

    private void doRaw(){
        InputStream is = this.getResources().openRawResource(R.raw.wendu);
        try{
            doRead(is);
        }catch(IOException e){
            e.printStackTrace();
        }
    }
    private void doRead(InputStream is) throws IOException{
        DataInputStream dis = new DataInputStream(is);
        byte[]buffer = new byte[is.available()];
        dis.readFully(buffer);
        textView=(TextView)findViewById(R.id.wendu);
        textView.setText(new String(buffer));
        dis.close();
        is.close();
    }




}
