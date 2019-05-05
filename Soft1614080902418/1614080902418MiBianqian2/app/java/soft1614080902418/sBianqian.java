package edu.androidlabs.soft1614080902418;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.content.Context;
import android.os.Bundle;
import android.os.Environment;

import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import edu.androidlabs.soft1614080902418.R;


public class sBianqian extends AppCompatActivity {

 //   @Override
//   protected void onCreate(Bundle savedInstanceState) {
 //       super.onCreate(savedInstanceState);
 //     setContentView(R.layout.activity_s_bianqian);
 //  }
 String tex;
    String multiAutoCompleteTextView;


    public static final String DIRECTORY = "demo";
    public static final String FILENAME = "file_demo.txt";
    public static final String TAG = sBianqian.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_s_bianqian);
        getJson();

        File dir = this.getFilesDir();
        File file = new File(dir, FILENAME);
        if (!file.exists()){
            try {
                file= File.createTempFile(FILENAME, null, dir);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        Reader(file);
        ((Button) findViewById(R.id.button2)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String text = ((EditText) findViewById(R.id.multiAutoCompleteTextView)).getText().toString();
                saveTextIntoInternalStorage(text);
            }

        });
    }

    // 将文字保存到内部存储
    private void saveTextIntoInternalStorage(String text) {
        // 获取内部存储目录
        File dir = this.getFilesDir();
        //File dir = getCacheDir();

        File file = new File(dir, FILENAME);
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
            //FileOutputStream fos = new FileOutputStream(file);
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
        Reader(file);
    }
    private void showResult(String result) {
        ((TextView) findViewById(R.id.multiAutoCompleteTextView)).setText(result);
    }
    private void Reader(File file){
        FileReader reader = null; // char
        try {
            reader = new FileReader(file.getAbsoluteFile());
            BufferedReader bReader = new BufferedReader(reader);
            String line = bReader.readLine();
            showResult(line);   // 显示结果
            Log.i(TAG, "从文件读取的内容: " + line);
            bReader.close();
            reader.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void getJson() {
        new Thread() {
            @Override
            public void run() {
                try {
                    String url_user = "https://raw.githubusercontent.com/liudlblue/android-labs-2018/master/Soft1614080902418/bianqian.json";
                    URL url = new URL(url_user);
                    HttpURLConnection conn = (HttpURLConnection) url.openConnection();
                    conn.setConnectTimeout(5000);
                    conn.setUseCaches(false);
                    conn.connect();
                    InputStream inputStream = conn.getInputStream();
                    InputStreamReader input = new InputStreamReader(inputStream);
                    BufferedReader buffer = new BufferedReader(input);
                    if (conn.getResponseCode() == 200) {
                        String inputLine;
                        StringBuffer resultData = new StringBuffer();
                        while ((inputLine = buffer.readLine()) != null) {
                            resultData.append(inputLine);
                        }

                        tex = resultData.toString();
                        System.out.println(tex);
                        input.close();
                        inputStream.close();
                        Log.v("解析：", tex);
                        parseJson();
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        ((EditText) findViewById(R.id.multiAutoCompleteTextView)).setText(multiAutoCompleteTextView);

                    }
                });
            }
        }.start();
    }

    public void parseJson() {
        JSONObject Json1 = null;
        try {
            Json1 = new JSONObject(tex);
            multiAutoCompleteTextView = Json1.getString("yunbian");

        } catch (JSONException e) {
            e.printStackTrace();
            Log.v("Error", "出现错误！");
        }

    }



}





