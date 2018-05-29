package com.example.hzu.soft1614080902406;

import android.os.Bundle;
import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import java.io.FileInputStream;
import java.io.FileOutputStream;

public class Soft1614080902406ActivityA2 extends AppCompatActivity {
    private Button seek;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_soft1614080902406_a2);
        seek=(Button)findViewById(R.id.button_seek);
        seek.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final EditText tx= (EditText) findViewById(R.id.edittext_input);
                String s = tx.getText().toString();
                if(!s.isEmpty())
                    save(s);
                refresh(s);
            }
        });
        init();
    }

    public void save(String msg){
        if(msg == null) return;
        try {
            msg += read();
            FileOutputStream fos = openFileOutput("storage.txt",
                    MODE_APPEND);
            fos.write(msg.getBytes());
            fos.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public String read() {
        try {
            FileInputStream inStream = this.openFileInput("message.txt");
            byte[] buffer = new byte[1024];
            int hasRead = 0;
            StringBuilder sb = new StringBuilder();
            while ((hasRead = inStream.read(buffer)) != -1) {
                sb.append(new String(buffer, 0, hasRead));
            }
            inStream.close();
            return sb.toString();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    private void refresh(String msg)
    {
        if(msg==null) return;
        TextView textView = (TextView) findViewById(R.id.textview_history);
        String s = textView.getText().toString();
        textView.setText(s+"\n"+msg);
    }

    private void init()
    {
        TextView textView = (TextView) findViewById(R.id.textview_history);
        String s = read();
        if(s!=null)
            refresh(s);
    }

}
