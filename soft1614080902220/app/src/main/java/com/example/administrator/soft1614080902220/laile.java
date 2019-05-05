package com.example.administrator.soft1614080902220;
import android.app.Activity;
import android.os.Bundle;
import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import java.io.FileInputStream;
import java.io.FileOutputStream;

public class Laile extends Activity {
    private Button button_open1;
    private Button button_open2;
    private Button button_close;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_laile);
        button_close= (Button) findViewById(R.id.button_close);
        button_close.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent= new Intent(Laile.this, MainActivity.class);
                Laile.this.startActivity(intent);
            }
        });
       button_open2= (Button) findViewById(R.id.button_open2);
        button_open2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Laile.this, Jinru.class);
                Laile.this.startActivity(intent);
            }
        });
        button_open1=(Button)findViewById(R.id.button_open);
        button_open1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            final EditText txt= (EditText) findViewById(R.id.edittext_input);
            String w = txt.getText().toString();
            if(!w.isEmpty())
            write(w);
            refreshHistoricalRecord(w);  }
            }
        );
        initHistoricalRecord();
    }
   private void refreshHistoricalRecord(String msg)
    {
        if(msg==null) return;
        TextView textView = (TextView) findViewById(R.id.textview_history);
        String s = textView.getText().toString();
        textView.setText(s+"\n"+msg);
    }
    private void initHistoricalRecord()
    {
        TextView textView = (TextView) findViewById(R.id.textview_history);
        String s = read();
       if(s!=null) refreshHistoricalRecord(s);
    }
    //读入存储数据
    public String read() {
        try {
            FileInputStream inStream = this.openFileInput("message.txt");
            byte[] buffer = new byte[100];
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
    //写出存储数据
    public void write(String msg){
        if(msg == null) return;
        try { msg =msg+read();
            FileOutputStream fos = openFileOutput("storage.txt", MODE_APPEND);
            fos.write(msg.getBytes());
            fos.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}