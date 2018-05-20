package edu.huzapps.andriod.soft1614080902216;
import android.content.Intent;
import android.widget.TextView;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;
import java.io.*;
import android.util.Log;
import android.os.Environment;
import android.content.Context;

public class Main4Activity extends AppCompatActivity {

    public static final String DIRECTORY = "demo";
    public static final String FILENAME = "file_storage.txt";

    public static final String TAG = Main4Activity.class.getSimpleName();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main4);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
        Button btnOpen1 = (Button) findViewById(R.id.button7);
        btnOpen1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Main4Activity.this, Main7Activity.class);
                startActivity(intent);

            }
        });
        Button btnOpen2 = (Button) findViewById(R.id.button8);
        btnOpen2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Main4Activity.this, Main8Activity.class);
                startActivity(intent);

            }
        });

    Button btnOpen3 = (Button) findViewById(R.id.button9);
        btnOpen3.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            String text = ((TextView) findViewById(R.id.textView)).getText().toString();
            saveTextIntoInternalStorage(text);
        }
    });
}
    private void saveTextIntoInternalStorage(String text) {
        // 获取内部存储目录
        File dir = this.getFilesDir();
        File file = new File(dir, FILENAME);
//        try {
//            File = File.createTempFile(FILENAME, null, dir);
//        } catch (IOException e) {
//            e.printStackTrace();
//        }

        if (file.exists()) { // 判断文件是否存在
            Log.i(TAG, file.getAbsolutePath());
            Log.i(TAG, file.length() + ""); // bytes*1024=kb *1024 MB
            Log.i(TAG, file.isFile() + "");
            file.canRead();
            file.canWrite();
            file.canExecute();

            file.getFreeSpace();
            file.getTotalSpace();
        }

        FileOutputStream fos = null;  // 字节流  | char | cn : gbk 2 bytes, utf8 3 bytes

        try { // 使用API打开输出流
            fos = openFileOutput(FILENAME, MODE_PRIVATE);

            fos.write(text.getBytes()); // 写入内容
            //  fos.close(); // 关闭流

            Toast.makeText(Main4Activity.this, "数据保存成功", Toast.LENGTH_SHORT).show();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            Toast.makeText(Main4Activity.this, "文件不能建成", Toast.LENGTH_SHORT).show();
        } catch (IOException e) {
            e.printStackTrace();
            Toast.makeText(Main4Activity.this, "输入错误", Toast.LENGTH_SHORT).show();
        } finally {
            try {
                fos.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        FileReader reader = null; // char

        try {
            reader = new FileReader(file.getAbsoluteFile());
            BufferedReader bReader = new BufferedReader(reader);
            String line = bReader.readLine();
            int len=line.length();
            String subStr=line.substring(1,len-1);
            int number=Integer.parseInt(subStr);
            number++;
            String s="第"+number+"天";
            TextView t=(TextView)findViewById(R.id.textView);
            t.setText(s);
            Log.i(TAG, "从文件读取的内容: " + s);
            Toast.makeText(Main4Activity.this, "数据读取成功", Toast.LENGTH_SHORT).show();
            bReader.close();
            reader.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
