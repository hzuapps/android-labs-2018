package androidlabs.hzuapps.edu.soft1614080902215;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class ThirdActivity extends AppCompatActivity{
    private TextView textView;
    private TextView textView1;
    private String str,num1,num2;
    private double result;
    private String result1;
    private boolean addNum;
    private Button More;
    //private Button Build;
    private TextView texts;
    private String text;
    public static final String TAG1 = ThirdActivity.class.getSimpleName();

    public static final String DIRECTORY = "demo";
    public static final String FILENAME = "file_demo.txt";
    public static final String TAG = ThirdActivity.class.getSimpleName();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third);
        textView = (TextView) findViewById(R.id.textView1);
        textView1 = (TextView) findViewById(R.id.textView);
        addNum = true;

        texts = ((TextView) findViewById(R.id.textView));
        getJson();

        More=(Button)findViewById(R.id.btn_more);
        More.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(ThirdActivity.this,SecondActivity.class);
                startActivity(intent);
            }
        });



        ((Button) findViewById(R.id.btn_save)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String text = ((TextView) findViewById(R.id.textView)).getText().toString();
                saveTextIntoInternalStorage(text);
            }
        });}
    public void getJson() {
        new Thread() {
            @Override
            public void run() {
                try {
                    //你的URL
                    Log.i(TAG1, "01");
                    String url_s = "https://raw.githubusercontent.com/Zhenghizhong/android-labs-2018/master/soft1614080902215/text.json";
                    URL url = new URL(url_s);
                    HttpURLConnection conn = (HttpURLConnection) url.openConnection();
                    Log.i(TAG1, "1");
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
                        text = resultData.toString();
                        Log.v("out---------------->", text);


                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                try {
                                   // JSONArray js = new JSONArray(text);
                                    JSONObject ob = new JSONObject(text);
                                    String str = ob.getString("text");
                                    texts.setText(str);
                                }catch(Exception e){
                                    e.printStackTrace();
                                }
                            }
                        });

                    }
                } catch (Exception e) {
                    Log.i(TAG1, "5");
                    e.printStackTrace();
                }

            }


        }.start();
    }
// 将文字保存到内部存储
    private void saveTextIntoInternalStorage(String text) {
        // 获取内部存储目录
        File dir = this.getFilesDir();
        //File dir = getCacheDir();

        if (dir.isDirectory()) {
//            dir.mkdir();
//            dir.mkdirs();
        }

        if (dir.isFile()) {
            // D:/Abc.txt , -> D:/Abc1.txt ->D:/abc.txt
        }

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

        FileReader reader = null; // char
        try {
            reader = new FileReader(file.getAbsoluteFile());
            BufferedReader bReader = new BufferedReader(reader);
            String line = bReader.readLine();
            Log.i(TAG, "从文件读取的内容: " + line);
            bReader.close();
            reader.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        // 显示结果
        showResult(file.getAbsolutePath());
    }
    private void showResult(String result) {
        ((TextView) findViewById(R.id.textView)) //
                .setText(result.toCharArray(), 0, result.length());
    }


    public void onClick(View v){
        str = (String) textView.getText();
        switch (v.getId()) {
            case R.id.btn_cle:
                textView.setText("");
                textView1.setText("");
                break;
            case R.id.btn_del:
                if(!str.equals("") && str != null){
                    textView.setText(str.substring(0, str.length()-1));
                }
                break;
            case R.id.btn_equ:
                if(str.contains("+")){
                    getResult(num1, num2, "+");
                }
                else if(str.contains("-")){
                    getResult(num1, num2, "-");
                }
                else if(str.contains("×")){
                    getResult(num1, num2, "×");
                }
                else if(str.contains("÷")){
                    getResult(num1, num2, "÷");
                }
                else {
                    return;
                }
                break;
            case R.id.btn_add:
            case R.id.btn_sub:
            case R.id.btn_mul:
            case R.id.btn_div:
                if (str.contains("+")||str.contains("-")||str.contains("×")||str.contains("÷"))
                    return;
                else
                    textView.setText(str+((Button)v).getText());
                if(!addNum)
                    addNum = true;
                break;
            default:
                if (addNum) {
                    textView.setText(str+((Button)v).getText());
                }else{
                    textView.setText(((Button)v).getText());
                    addNum = true;
                }
                break;
        }
    }
    private void getResult(String num1,String num2,String op) {
        num1 = str.substring(0,str.indexOf(op));
        num2 = str.substring(str.indexOf(op)+1);
        try {
            double n1 = Double.parseDouble(num1);
            double n2 = Double.parseDouble(num2);
            if (op.equals("+")) {
                result = n1+n2;
                result1=n1+"+"+n2;
            }else if(op.equals("-")){
                result = n1-n2;
                result1=n1+"-"+n2;
            }else if(op.equals("×")){
                result = n1*n2;
                result1=n1+"×"+n2;
            }else if(op.equals("÷")){
                result = n1/n2;
                result1=n1+"÷"+n2;
            }else {
                return;
            }

            String r = result+"";
            if(r.contains(".")&&r.substring(r.length()-1).equals("0")){
                r = r.substring(0,r.indexOf("."));
            }
            textView1.setText(result1+"="+r);
            textView.setText(r);
            addNum = false;
        } catch (Exception e) {
            return;
        }
    }
}
