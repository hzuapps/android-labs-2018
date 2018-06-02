package soft1614080902436.androidlabs.hzuapps.edu.app;

import android.content.ContextWrapper;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.*;
import java.io.*;

public class MainActivity extends AppCompatActivity
{
    private Button submit;
    private Button readtext;
    private EditText phone;
    private EditText name;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        //页面初始化
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //submit添加监听
        submit = (Button) findViewById(R.id.submit);
        submit.setOnClickListener(new OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                //获取文本
                phone = (EditText) findViewById(R.id.editphone);
                name = (EditText) findViewById(R.id.editname);

                if(phone.getText().length() == 0 ||name.getText().length() == 0 )
                {
                    //空值操作
                    Toast tot = Toast.makeText(
                            MainActivity.this,
                            "姓名与联系方式不可为空",
                            Toast.LENGTH_LONG);
                    tot.show();
                }
                //非空值操作
                else
                {
                    save(name.getText() + ":" + phone.getText());
                    name.setText("");
                    phone.setText("");
                }
            }

        });

        //读取键初始化及添加监听
        readtext = (Button) findViewById(R.id.read);
        readtext.setOnClickListener(new OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                Toast.makeText(
                        MainActivity.this,
                        read(),
                        Toast.LENGTH_LONG).show();
            }
        });
    }


    public void save(String text)
    {
        FileOutputStream out = null;
        BufferedWriter writer = null;
        try
        {
            out = openFileOutput("new.txt", ContextWrapper.MODE_APPEND);
            writer = new BufferedWriter(new OutputStreamWriter(out));
            writer.write(text);
            Toast.makeText(MainActivity.this, "存储成功", Toast.LENGTH_SHORT).show();
        }
        catch (IOException e)
        {
            e.printStackTrace();
            Toast.makeText(MainActivity.this, "存储失败", Toast.LENGTH_SHORT).show();
        }
        finally
        {
            try
            {
                if (writer != null)
                {
                    writer.close();
                }
            }
            catch (IOException e)
            {
                e.printStackTrace();
                Toast.makeText(MainActivity.this, "存储失败", Toast.LENGTH_SHORT).show();
            }

        }
    }

    public String read()
    {
        String content = "";
        try
        {
            FileInputStream fis = openFileInput("new.txt");
            if (fis == null)
            {
                return null;
            }
            byte[] buffer = new byte[fis.available()];
            fis.read(buffer);
            content = new String(buffer);

            //清空文件
            File file = new File("new.txt");
            file.delete();

            fis.close();
            //Toast.makeText(MainActivity.this, "读取成功", Toast.LENGTH_SHORT).show();
            return content;
        }
        catch (Exception e)
        {
            e.printStackTrace();
            Toast.makeText(MainActivity.this, "读取失败", Toast.LENGTH_SHORT).show();
            return null;
        }
    }
}
