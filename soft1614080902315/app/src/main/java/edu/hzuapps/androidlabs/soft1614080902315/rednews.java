package edu.hzuapps.androidlabs.soft1614080902315;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import java.io.*;

import java.io.FileInputStream;

public class rednews extends AppCompatActivity {
    private Button 保存;
    private Button 显示;
    private EditText editText2;

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
}




