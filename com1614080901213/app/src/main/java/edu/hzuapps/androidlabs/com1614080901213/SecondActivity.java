package edu.hzuapps.androidlabs.com1614080901213;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import java.io.FileDescriptor;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

public class SecondActivity extends AppCompatActivity {

    private ImageButton pai1, pai2, pai3;
    private Button mImage01;
    private Button mImage02;
    private Button mImage03;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        final TextView textView = (TextView)findViewById(R.id.text1);

        String text =read();
        if(text!=null && !text.equals("null"))
            textView.setText(text);
        else textView.setText("");

        pai1 = (ImageButton) findViewById(R.id.mImage01);
        pai2 = (ImageButton) findViewById(R.id.mImage02);
        pai3 = (ImageButton) findViewById(R.id.mImage03);
        pai1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               // String text = textView.getText() + "\n" + "恭喜你猜对了";
                String text = read();
                if(text!=null && !text.equals("null"))
                write("\n" + "恭喜你猜对了");
                else write( "恭喜你猜对了");
                Intent intent = new Intent(SecondActivity.this, ThreeActivity.class);

                startActivity(intent);
            }
        });

        pai2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String text = read();
                if(text!=null && !text.equals("null"))
                    write("\n" + "很遗憾猜错了");
                else write( "很遗憾猜错了");
                Intent intent = new Intent(SecondActivity.this, FourActivity.class);

                startActivity(intent);
            }
        });

        pai3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String text = read();
                if(text!=null && !text.equals("null"))
                    write("\n" + "很遗憾猜错了");
                else write( "很遗憾猜错了");
                Intent intent = new Intent(SecondActivity.this, FourActivity.class);

                startActivity(intent);
            }
        });

    }
    public String read() {
        try {
            FileInputStream inStream = this.openFileInput("aa.txt");
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

    public void write(String msg){
        // 步骤1：获取输入值
        if(msg == null) return;
        try {
            // 步骤2:创建一个FileOutputStream对象,MODE_APPEND追加模式
            FileOutputStream fos = openFileOutput("aa.txt",
                    MODE_APPEND);
            // 步骤3：将获取过来的值放入文件
            fos.write(msg.getBytes());
            // 步骤4：关闭数据流
            fos.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

