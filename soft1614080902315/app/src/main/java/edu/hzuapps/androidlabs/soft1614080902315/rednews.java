package edu.hzuapps.androidlabs.soft1614080902315;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.*;

import java.io.FileInputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class rednews extends AppCompatActivity {
    private Button 保存;
    private Button 显示;
    private Button 跳转网页;
    private EditText editText2;
    private String text;
    private String name ;

    private String talk;
    private String name1[]={"","",""};
    private String talk1[]={"","",""};

    private EditText 评论1;
    private EditText 评论2;
    private EditText 评论3;

    private String resultx[]={"","",""};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rednews);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
                                   @Override
                                   public void onClick(View view) {
                                       Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                                               .setAction("Action", null).show();


                                   }
                               }
        );

        editText2 = (EditText) findViewById(R.id.editText2);
        保存 = (Button) findViewById(R.id.save);
        显示 = (Button) findViewById(R.id.dispaly);
        跳转网页=(Button)findViewById(R.id.jumpxml);

        评论1=(EditText) findViewById(R.id.editText2);
        评论2=(EditText) findViewById(R.id.editText3);
        评论3=(EditText) findViewById(R.id.editText4);
         final EditText 评论[]={评论1,评论2,评论3};

        保存.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                savaContent();  //  //向内部存储写入数据
                Toast.makeText(rednews.this, "评价成功", Toast.LENGTH_SHORT).show();
            }
        });

        显示.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String s = getContent();
                Toast.makeText(rednews.this, s, Toast.LENGTH_SHORT).show();
            }
        });
        跳转网页.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
             getJson();

                for(int i =0;i<3;i++)
                {
                    resultx[i]=name1[i]+talk1[i];
                    System.out.println(resultx);
                    评论[i].setText(resultx[i]);
                }

            }
        });
    }
        private String getContent()
    {
        String s=null;
        FileInputStream fis=null;
        try{
            fis =this.openFileInput("edit_data.txt");
            int len=0;
            byte[] buf=new byte[1024];
          while ((len=fis.read(buf))!=-1)
            {
                s=new String(buf,0,len,"UTF-8");
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        finally
        {
            if(fis!=null)
            {
                try{
                    fis.close();

                }catch (IOException e)
                {
                    e.printStackTrace();
                }
            }
    }
        return  s;
    }

    private void savaContent()
    {
    FileOutputStream fos=null;
    String content=editText2.getText().toString();
        try {


            //通过该方法向内部存储中写入数据，文件名为edit_data.txt，模式为MODE_PRIVATE，表示该文件操作权限为文本应用，另一个常用的权限MODE_APPEND表示在文件末尾添加内容
            fos = this.openFileOutput("edit_data.txt", MODE_PRIVATE);
            fos.write(content.getBytes());
            fos.flush();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (fos != null) {
                try {
                    fos.close();

                } catch (IOException e) {
                    e.printStackTrace();
                }

            }
        }
    }

    public void getJson() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    //你的URL
                    String url_s = "https://raw.githubusercontent.com/wekun/android-labs-2018/master/soft1614080902315/实验六.json";
                    URL url = new URL(url_s);
                    HttpURLConnection conn = (HttpURLConnection) url.openConnection();

                    conn.setConnectTimeout(5000);//设置超时
                    conn.setUseCaches(false);//数据不多不用缓存了

                    //这里连接了
                    conn.connect();
                    //这里才真正获取到了数据
                    InputStream inputStream = conn.getInputStream();
                    InputStreamReader input = new InputStreamReader(inputStream);
                    BufferedReader buffer = new BufferedReader(input);
                    if (conn.getResponseCode() == 200) {//200意味着返回的是"OK"
                        String inputLine;
                        StringBuffer resultData = new StringBuffer();//StringBuffer字符串拼接很快
                        while ((inputLine = buffer.readLine()) != null) {
                            resultData.append(inputLine);
                        }
                        text = resultData.toString();
                        Log.v("out----------------1>", text);

                        parseJson(text);
                        System.out.println(text);
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }

        }).start();

    }

        public void parseJson(String text){
            try{
                /* 这里的text就是上边获取到的数据，一个String. */
                JSONObject jsonObject = new JSONObject(text);

                JSONArray jsonDatas = jsonObject.getJSONArray("sites");
                int length = jsonDatas.length();


                for(int i =0;i<length;i++){
                    JSONObject person = jsonDatas.getJSONObject(i);
                    name = person.getString("name");
                    Log.v("out----------------2>",i+"---------------"+name);
                    name1[i]=name;
                    talk = person.getString("talk");
                    talk1[i]=talk;
                    Log.v("out----------------3>",i+"---------------"+talk);
                }
            } catch(Exception e){
                e.printStackTrace();
            }
        }




}




