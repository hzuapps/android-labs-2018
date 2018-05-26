package com.example.administrator.soft1614080902425;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.support.design.widget.TextInputEditText;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;

public class CreatetableActivity extends AppCompatActivity implements View.OnClickListener {
    private TextInputEditText input;
    private String insertmes;
    private Button create;
    private Activity now;
    private Context mContext;
    private Button returnlast;
    private Socket socket;
    private int flags=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_createtable);
        input = (TextInputEditText) findViewById(R.id.inputmes);
        create = (Button) findViewById(R.id.creat);
        mContext =CreatetableActivity.this;
        returnlast = (Button) findViewById(R.id.returnlast);
        create.setOnClickListener(this);
        returnlast.setOnClickListener(this);
        now=this;
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.creat: {
                insertmes = input.getText().toString();
                new Sendbuff().execute();
            }
                break;
            case R.id.returnlast: {
                String value=getIntent().getStringExtra("loop");
                Intent intent = new Intent(now, nexttableActivity.class);
                intent.putExtra("value",value);
                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                now.startActivity(intent);
            }
                break;
        }
    }

    class Sendbuff extends AsyncTask<String, String, String> {

        @Override
        protected String doInBackground(String... params) { //设置延迟
            try {
                Thread.sleep(500);
                try {
                    socket = new Socket("120.79.37.250", 43491);
                    String username=null;
                    username=now.getIntent().getStringExtra("username");
                    BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream(), "UTF-8"));
                    String flag = "createsid\n";     //业务标识符
                    String sent1 = username + "\n";
                    String sent2 = insertmes + "\n";
                    writer.write(flag);
                    writer.flush();
                    Thread.sleep(200);
                    writer.write(sent1);
                    writer.flush();
                    Thread.sleep(200);
                    writer.write(sent2);
                    writer.flush();
                    BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream(), "UTF-8"));
                    String tonext=reader.readLine();//获取服务器应答
                    if(tonext.equals("1"))
                    {
                        flags=1;
                    }
                    socket.close();

                } catch (IOException e) {
                    e.printStackTrace();
                }

            } catch (InterruptedException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();

                }
                return null;
            }


        @Override
        protected void onPostExecute(String result) {       //更新ui
            // TODO Auto-generated method stub
            if(flags==1)
            {
                Toast.makeText(mContext, "创建成功", Toast.LENGTH_SHORT).show();
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e1) {
                    e1.printStackTrace();
                }
                String value=getIntent().getStringExtra("loop");
                char []a=new char[200];
                a=value.toCharArray();
                for(int i=0;i<value.length();i++)
                {
                    if(a[i]=='|')
                    {
                        a[i]='\0';
                        break;
                    }
                }
                value=String.valueOf(a);
                value=value+input.getText().toString()+'|';
                //Toast.makeText(mContext, value, Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(now, nexttableActivity.class);
                intent.putExtra("value",value);
                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                now.startActivity(intent);
            }
        }
    }
}
