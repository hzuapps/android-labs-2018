package com.example.administrator.soft1614080902425;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.*;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.TextView;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.util.ArrayList;

public class nexttableActivity extends AppCompatActivity {
    private String username=null;
    private Context mContext;
    private Socket socket;
    private Activity now;
    private String value=null;
    private GridView gridView;
    private ReAdapter<Icon> mAdapter = null;
    private ArrayList<Icon> mData = null;
    private int []menubutton=new int [20];
    private String menumessment=null;
    private String classtable=null;
    char []getvalue=new char[200];
    public int a=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nexttable);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        mContext =nexttableActivity.this;
        menumessment="test";
        now=this;
        //tv_test = (TextView) findViewById(R.id.tv_test);
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        value=getIntent().getStringExtra("value");
        getvalue=value.toCharArray();
        //Toast.makeText(mContext, value, Toast.LENGTH_SHORT).show();
        String menutext=null;
        int i=0,k=0;
        int j;
        while(getvalue[i]!='|')
        {
            char []a=new char[20];
            ++k;
            j=0;

            while(getvalue[i]!='$')
            {
                a[j]=getvalue[i];
                ++i;
                ++j;
            }
            ++i;
            a[j+1]='\0';
            menubutton[k]=k;
            menu.add(1,menubutton[k],k, String.valueOf(a));
        }
        username=getIntent().getStringExtra("username");
        //Toast.makeText(mContext,username, Toast.LENGTH_SHORT).show();
        ++k;
        menu.add(1,k,k,"添加");
        /* menu.add(1,test1,1, "测试1");
        menu.add(1,test2,2,"测试2");
        menu.add(1,addtest,3,"添加");*/
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        menumessment=item.toString();
        if(menumessment.equals("添加")==true)
        {
            Intent intent = new Intent();
            intent.putExtra("username",username);
            intent.putExtra("loop",value);
            intent.setClass(now, CreatetableActivity.class);
            now.startActivity(intent);
        }
        else
            new Yibu().execute();
        /*switch (id) {
            case menubutton[1]:
                new Yibu().execute();
                break;
            case test2:
                break;
            case addtest:
                break;
        }*/
        return super.onOptionsItemSelected(item);
    }

    class Yibu extends AsyncTask<String, String, String>
    {

        @Override
        protected String doInBackground(String... params) {
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            try {
                socket = new Socket("120.79.37.250", 43491);
                if(!socket.isConnected())
                    Toast.makeText(mContext, "服务器无响应", Toast.LENGTH_SHORT).show();
                else {
                    BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream(), "UTF-8"));
                    String flag = "getmenu\n";     //业务标识符
                    //String sendmes=menumessment;
                    writer.write(flag);
                    writer.flush();
                    Thread.sleep(200);
                    writer.write(menumessment);
                    writer.flush();
                    BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream(), "UTF-8"));
                    classtable= reader.readLine();      //获取服务器应答
                    socket.close();
                }
            }
            catch (IOException e) {
                e.printStackTrace();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return null;
        }
        @Override
        protected void onPostExecute(String result) {       //更新ui
            // TODO Auto-generated method stub
            char []a=new char[77];
            char [][]Class=new char[8][6];
            a=classtable.toCharArray();
            for(int i=0;i<8;i++)
                for(int j=0;j<6;j++)
                {
                    Class[i][j]=0;
                }
            int i=0;
            while(a[i]!='|')
            {
                Class[a[i]-48][a[i+1]-48]=1;
                i=i+2;
            }
            Updataclass(Class);

        }
    }
    private void Updataclass(char Class[][])
    {
        Toast.makeText(mContext,   menumessment + "~项", Toast.LENGTH_SHORT).show();
        gridView=(GridView)findViewById(R.id.gridview);
        mData = new ArrayList<Icon>();
        int classicon=R.drawable.havaclass3;
        for(int i=1;i<8;i++)
            for(int j=1;j<6;j++) {
                if (Class[i][j]==0)
                    mData.add(new Icon(R.drawable.withoutclass ,"无课"));
                else {
                    if(classicon==R.drawable.havaclass1)
                        classicon=R.drawable.havaclass2;
                    if(classicon==R.drawable.havaclass2)
                        classicon=R.drawable.havaclass3;
                    if(classicon==R.drawable.havaclass3)
                        classicon=R.drawable.havaclass1;
                    mData.add(new Icon(classicon, "有课"));
                }
            }
        mAdapter = new ReAdapter<Icon>(mData, R.layout.clas) {
            @Override
            public void bindView(ViewHolder holder, Icon obj) {
                holder.setImageResource(R.id.img_icon,obj.getiId());
                holder.setText(R.id.txt_icon, obj.getiName());
            }
        };
        gridView.setAdapter(mAdapter);
        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                TextView mesg = (TextView) findViewById(R.id.txt_icon);
                Toast.makeText(mContext, "你点击了~" + position + "~项", Toast.LENGTH_SHORT).show();
                    /*Looper.prepare();
                    Toast.makeText(mContext,""+id,Toast.LENGTH_SHORT).show();
                    Looper.loop();*/
            }
        });

    }
    }
