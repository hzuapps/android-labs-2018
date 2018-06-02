package edu.hzuapps.androidlabs.Soft1614080902122;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import android.content.Intent;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.io.FileInputStream;
import java.io.FileOutputStream;
public class ThreeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_three);
        Button button4=(Button)findViewById(R.id.button4);
        button4.setOnClickListener(new View.OnClickListener() {
               @Override
               public void onClick(View v) {
                   final EditText tx= (EditText) findViewById(R.id.editText);
                   String s = tx.getText().toString();
                   if(!s.isEmpty())
                       write(s);
                   refreshHistorical(s);
                   Intent intent=new Intent(ThreeActivity.this,ThreeActivity.class);
               }
           }

        );
        initHistorical();
    }
    private void refreshHistorical(String msg)  //刷新纪录
    {
        if(msg==null) return;
        TextView textView = (TextView) findViewById(R.id.history);
        String s = textView.getText().toString();
        textView.setText(s+"\n"+msg);
    }
    private void initHistorical()  //初始化记录
    {
        TextView textView = (TextView) findViewById(R.id.history);
        String s = read();
        if(s!=null)
            refreshHistorical(s);
    }

    public String read() {   //读入数据
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
    public void write(String msg){   //写出数据
        if(msg == null) return;
        try {
            msg += read();  //添加之前的数据
            FileOutputStream fos = openFileOutput("storage.txt", MODE_APPEND);
            fos.write(msg.getBytes());
            fos.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
