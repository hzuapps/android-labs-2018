package hzuapps.edu.soft1614080902213;

import android.content.Intent;
import android.widget.EditText;
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
public class ContextActivity extends AppCompatActivity {
    public static final String DIRECTORY = "demo";
    public static final String FILENAME = "file_demo.txt";

    public static final String TAG = ContextActivity.class.getSimpleName();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main8);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);

        Button btnOpen1 = (Button) findViewById(R.id.button10);
        btnOpen1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ContextActivity.this,MainActivity.class);
                startActivity(intent);

            }
        });
        final EditText tx = (EditText) findViewById(R.id.editText3);
        Button btnOpen2 = (Button) findViewById(R.id.button9);
        btnOpen2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String s = tx.getText().toString();
                saveTextIntoInternalStorage(s);
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

        try { // 使用 API 打开输出流
            fos = openFileOutput(FILENAME, MODE_PRIVATE);
                fos.write(text.getBytes()); // 写入内容
                //  fos.close(); // 关闭流

            Toast.makeText(ContextActivity.this," 数据保存成功 ",Toast.LENGTH_SHORT).show();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            Toast.makeText(ContextActivity.this," 文件建立失败 ",Toast.LENGTH_SHORT).show();
        } catch (IOException e) {
            e.printStackTrace();
            Toast.makeText(ContextActivity.this," 保存失败 ",Toast.LENGTH_SHORT).show();
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
            Log.i(TAG, " 从文件读取的内容: " + line);
            Toast.makeText(ContextActivity.this," 数据读取成功 ",Toast.LENGTH_SHORT).show();
            bReader.close();
            reader.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }



}



