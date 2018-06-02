package edu.hzuapps.androidlabs.com1614080901101;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.OutputStreamWriter;

public class Activity3 extends AppCompatActivity {
    public static final String DIRECTORY = "leaderboard";
    public static final String FILENAME = "file_leaderboard.txt";

    public static final String TAG = Activity3.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity3);

        Button game = (Button) findViewById(R.id.button_open2);
        game.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Activity3.this, Activity2.class);
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
                saveText(ranking,name,point);
            }
        });

        Button reflash = (Button) findViewById(R.id.reflash);
        reflash.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                readText();
            }
        });

        Button set_values1 = (Button) findViewById(R.id.set_values1);
        set_values1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String r ="1.";
                String n ="ABC";
                String p ="987";
                ((TextView) findViewById(R.id.ranking1)).setText(r);
                ((TextView) findViewById(R.id.ranking1_name)).setText(n);
                ((TextView) findViewById(R.id.ranking1_point)).setText(p);
                Toast.makeText(Activity3.this,"已修改："+r+" "+n+" "+p,Toast.LENGTH_SHORT).show();
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
            fos.write(_ranking.getBytes()); // 写入名次
            fos.write(' ');
            fos.write(_name.getBytes()); // 写入名字
            fos.write(' ');
            fos.write(_point.getBytes()); // 写入分数
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

        Toast.makeText(Activity3.this,"数据已保存:"+_ranking+" "+_name+" "+_point,Toast.LENGTH_SHORT).show();
    }

    private void readText(){
        String ranking = " ";
        String name = " ";
        String point = " ";

        File dir = this.getFilesDir();
        File file = new File(dir, FILENAME);
        FileInputStream fis = null;

        try {
            int i=0;
            fis = openFileInput(FILENAME);
            byte[] _ranking = new byte[fis.available()];
            byte[] _name = new byte[fis.available()];
            byte[] _point = new byte[fis.available()];
            _ranking[i] = (byte) fis.read();
            i++;
            _ranking[i] = (byte) fis.read();
            i++;
            ranking = new String(_ranking);
            _ranking[i]=(byte) fis.read();
            i=0;

            _name[i] = (byte) fis.read();
            i++;
            _name[i] = (byte) fis.read();
            i++;
            _name[i] = (byte) fis.read();
            i++;
            name = new String(_name);
            _name[i] = (byte) fis.read();
            i=0;

            _point[i] = (byte) fis.read();
            i++;
            _point[i] = (byte) fis.read();
            i++;
            _point[i] = (byte) fis.read();
            i++;
            point = new String(_point);

            fis.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        ((TextView) findViewById(R.id.ranking1_name)).setText(name);
        ((TextView) findViewById(R.id.ranking1_point)).setText(point);
        Toast.makeText(Activity3.this,"已更新："+ranking+" "+name+" "+point,Toast.LENGTH_SHORT).show();
    }
}