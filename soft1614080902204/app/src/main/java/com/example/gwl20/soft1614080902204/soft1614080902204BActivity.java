package com.example.gwl20.soft1614080902204;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class soft1614080902204BActivity extends AppCompatActivity {

    private Button bu,jiandao,shitou;
    private ImageView beijin;
    private Handler handler=new Handler();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_soft1614080902204_b);
        bu=(Button)findViewById(R.id.button_bu);
        jiandao=(Button)findViewById(R.id.button_jiandao);
        shitou=(Button)findViewById(R.id.button_shitou);
        beijin=(ImageView)findViewById(R.id.imageView_beijin);
        bu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(soft1614080902204BActivity.this,soft1614080902204CActivity.class);
                intent.putExtra("quan","2");
                startActivityForResult(intent,1);
            }
        });
        jiandao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(soft1614080902204BActivity.this,soft1614080902204CActivity.class);
                intent.putExtra("quan","0");
                startActivityForResult(intent,1);
            }
        });
        shitou.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(soft1614080902204BActivity.this,soft1614080902204CActivity.class);
                intent.putExtra("quan","1");
                startActivityForResult(intent,1);
            }
        });
        ((Button)findViewById(R.id.button_xiazai)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new HttpThread("http://5b0988e595225.cdn.sohucs.com/images/20170904/d03b058017fc42568e4b595f40879ba1.jpeg",beijin,handler).start();
            }
        });
    }
    @Override

    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode==1&&resultCode==2){
            String s=data.getStringExtra("jieguo");

            if(!s.isEmpty()) {
                write(s);
            }
            refreshHistoricalRecord(s);
        }
        initHistoricalRecord();
    }
    private void refreshHistoricalRecord(String msg)  //刷新一下记录

    {
        if(msg==null) return;
        TextView textView = (TextView) findViewById(R.id.textview_history);
        String s = textView.getText().toString();
        Calendar c = Calendar.getInstance();
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String formattedDate=df.format(c.getTime());
        textView.setText(s+"\n"+formattedDate+":"+msg);
    }

    private void initHistoricalRecord()  //初始化记录
    {
        TextView textView = (TextView) findViewById(R.id.textview_history);
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
            FileOutputStream fos = openFileOutput("storage.txt", MODE_APPEND);
            // 步骤3：将获取过来的值放入文件
            fos.write(msg.getBytes());
            // 步骤4：关闭数据流
            fos.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

