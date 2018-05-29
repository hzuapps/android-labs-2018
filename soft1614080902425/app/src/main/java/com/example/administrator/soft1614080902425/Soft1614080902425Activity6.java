package com.example.administrator.soft1614080902425;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.support.design.widget.TextInputEditText;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.*;
import android.view.*;

import java.io.*;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.net.*;

public class Soft1614080902425Activity6 extends AppCompatActivity implements View.OnClickListener {
    TextView textview;
    private Button Button;
    private Context mContext;
    private Socket socket;
    private String get=null;
    private String tonext=null;
    private BufferedReader in = null;
    private PrintWriter out = null;
    public static final String TAG = Soft1614080902425Activity6.class.getSimpleName();
    Activity now;
    private AutoCompleteTextView username;
    private TextInputEditText userkey;
    String[] a=new String[5];
    String[] data = new String[]{
            "admin", "adm"
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_soft1614080902425);
        Button = (Button) findViewById(R.id.button);
        Button.setOnClickListener(this);
        now=this;
        getMemory();
        username=(AutoCompleteTextView)findViewById(R.id.username);
        userkey=(TextInputEditText)findViewById(R.id.userkeyline);
        ArrayAdapter<String> adapter=new ArrayAdapter<String>(Soft1614080902425Activity6.this,android.R.layout.simple_dropdown_item_1line,a);
        username.setAdapter(adapter);
        mContext =Soft1614080902425Activity6.this;

    }
    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.button:
                new Sendbuff().execute();
                break;
            case R.id.button2:
                String str2="2";

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
                    if(!socket.isConnected())
                        get="0";
                    else {
                        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream(), "UTF-8"));
                        String flag = "signin\n";     //业务标识符
                        String sent1 = username.getText().toString() + "\n";
                        String sent2 = userkey.getText().toString() + "\n";
                        writer.write(flag);
                        writer.flush();
                        Thread.sleep(200);
                        writer.write(sent1);
                        writer.flush();
                        Thread.sleep(200);
                        writer.write(sent2);
                        writer.flush();
                        BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream(), "UTF-8"));
                        get = reader.readLine();      //获取服务器应答
                        tonext=reader.readLine();
                        socket.close();
                    }
                }
                catch (IOException e) {
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
            if (get.equals("1")) {
                String text = ((AutoCompleteTextView) findViewById(R.id.username)).getText().toString();
                Saveusername(text);
                Intent intent = new Intent();
                intent.putExtra("value", tonext);
                intent.putExtra("username",username.getText().toString());
                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                intent.setClass(now, nexttableActivity.class); //设置跳转的Activity
                now.startActivity(intent);
            }
            else
            {
                Toast.makeText(mContext, "密码错误或服务器维护中", Toast.LENGTH_SHORT).show();
             }
        }
    }
    public void Saveusername(String text) {
        int flag = 0;
        File dir = this.getFilesDir();
        File file = new File(dir, "memory.txt");
        if (file.exists()) { // 判断文件是否存在
            file.canRead();
            file.canWrite();
            file.canExecute();

            file.getFreeSpace();
            file.getTotalSpace();
        }
        FileReader reader = null;
        try {
            reader = new FileReader(file.getAbsoluteFile());
            BufferedReader bReader = new BufferedReader(reader);
            String line = null;
            int i = 0;
            while ((line = bReader.readLine()) != null) {
                if (line.equals(text) == true)
                    flag = 1;
            }
            bReader.close();
            reader.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }


        if (flag == 0) {
            FileOutputStream fos = null;
            try { // 使用API打开输出流
                fos = openFileOutput("memory.txt", MODE_APPEND);
                fos.write(text.getBytes()); // 写入内容
                fos.close(); // 关闭流
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                try {
                    fos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
    private void getMemory()
    {
        File dir=this.getFilesDir();
        File file = new File(dir, "memory.txt");
        if (file.exists()) { // 判断文件是否存在
            file.canRead();
            file.canWrite();
            file.canExecute();

            file.getFreeSpace();
            file.getTotalSpace();
        }
        FileReader reader = null; // char

        try {
            reader = new FileReader(file.getAbsoluteFile());
            BufferedReader bReader = new BufferedReader(reader);
            String line=null;
            int i=0;
            while(i<5) {
                line = bReader.readLine();
                a[i]=line;
                if(line==null)
                    a[i]=" ";
                i++;
            }

            bReader.close();
            reader.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }


}
}
