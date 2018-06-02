package com.example.dengcyu;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;


public class Activity2 extends AppCompatActivity {

    public static final String DIRECTORY = "leaderboard";
    public static final String FILENAME = "file_leaderboard.txt";

    public static final String TAG =Activity2.class.getSimpleName();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_Film);

        Button textView2 = (Button) findViewById(R.id.button_open3);
        textView2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Activity2.this, com1614080901124Activity.class);
                startActivity(intent);
            }
        });

        Button save = (Button) findViewById(R.id.save);
        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String ranking = ((TextView) findViewById(R.id.ranking1)).getText().toString();
                String name = ((TextView) findViewById(R.id.ranking1_name)).getText().toString();
                String point = ((TextView) findViewById(R.id.ranking1_point)).getText().toString();
                saveText(ranking,name,);
            }
        });

        Button save= (Button) findViewById(R.id.save1);
        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String r ="甄嬛传.";
                String n ="孙俪";
                String p ="观看";
                ((TextView) findViewById(R.id.ranking1)).setText(r);
                ((TextView) findViewById(R.id.ranking1_name)).setText(n);
                ((TextView) findViewById(R.id.ranking1_point)).setText(p);
                Toast.makeText(Activity2.this,"已更新："+r+" "+n+" "+p,Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void saveText(String _ranking,String _name,String _point) {
        String blank = " ";
        File dir = this.getFilesDir();  // 获取内部存储目录
        File file = new File(dir, FILENAME);
        FileOutputStream fos = null;    // 字节流  | char | cn : gbk 2 bytes, utf8 3 bytes

        try { // 使用API打开输出流
            fos = openFileOutput(FILENAME, MODE_PRIVATE);
            //FileOutputStream fos = new FileOutputStream(file);
            fos.write(_ranking.getBytes()); // 写入剧名
            fos.write(' ');
            fos.write(_name.getBytes()); // 写入主演名字
            fos.write(' ');
            fos.write(_point.getBytes()); // 写入资源
            fos.write(' ');
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

        Toast.makeText(Activity2.this,"数据已保存:"+_ranking+" "+_name+" "+_point,Toast.LENGTH_SHORT).show();
    }

}
    }

}
