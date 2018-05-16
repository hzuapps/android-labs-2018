package com.example.b.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.support.v7.app.AppCompatActivity;
import org.w3c.dom.Text;
import android.view.WindowManager;
import java.io.FileInputStream;
import java.io.FileOutputStream;



public class soft1606081301337Activity2  extends AppCompatActivity{
    private Button queding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
     super.onCreate(savedInstanceState);
        getSupportActionBar().hide();// 隐藏ActionBar
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);//remove notification bar  即全屏
        setContentView(R.layout.activity2_soft1606081301337_mian);
    queding=(Button)findViewById(R.id.button);
         queding.setOnClickListener(new View.OnClickListener() {
        @Override

        public void onClick(View v) {

            final EditText tx= (EditText) findViewById(R.id.et);
            String s = tx.getText().toString();

            if(!s.isEmpty()) {
                write(s);
            }

            refreshHistoricalRecord(s);

          
            // startActivity(intent);
        }
    }

         );
        initHistoricalRecord();

            }

    private void refreshHistoricalRecord(String msg)  //刷新一下记录
   {
                if(msg==null) return;

                        TextView textView = (TextView) findViewById(R.id.tv);
                String s = textView.getText().toString();
                textView.setText(s+"\n"+msg);
           }
   private void initHistoricalRecord()  //初始化记录
    {
                TextView textView = (TextView) findViewById(R.id.tv);
                String s = read();
                if(s!=null)
                    refreshHistoricalRecord(s);
            }

            public String read() {   //读入存储数据
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

    public void write(String msg){   //写出存储数据
                // 步骤1：获取输入值
                        if(msg == null) return;
                try {
                        // 步骤2:创建一个FileOutputStream对象,MODE_APPEND追加模式
                                msg += read();  //前面的也读进来
                       FileOutputStream fos = openFileOutput("storage.txt",
                                        MODE_APPEND);
                       // 步骤3：将获取过来的值放入文件
                    ;fos.write(msg.getBytes());
                       // 步骤4：关闭数据流
                                fos.close();
                   } catch (Exception e) {
                        e.printStackTrace();
                    }
    }	     }






       /* super.onCreate(savedInstanceState);
        getSupportActionBar().hide();// 隐藏ActionBar
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);//remove notification bar  即全屏
        setContentView(R.layout.activity2_soft1606081301337_mian);*/




