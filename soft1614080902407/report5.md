# 第五次实验

## 一、实验内容

使用文件存储

1.将应用产生的数据保存到文件存储中；

2.说明使用的文件存储方式：内部 or 外部；

3.将运行结果截图。

## 二、实验步骤

1.打开Android Studio；

2.修改SecondActivity.java

3.在onCreate()方法中获取EditText的实例并重写了onDestroy()方法，从而在活动销毁前必定调用这个方法，在里面调用save()方法把文本输入框内的内容存储到文件中，采用内部存储

4.save()方法采用Java流的方式，通过获取EditText的内容，采用带有缓冲区的字符流写入文件中，文件的操作模式采用默认的操作模式——MODE_PRIVATE

5.load()方法为读取文件方法，也是采用Java流的方式读取到EditText中，点击读取按钮即可读取文件内容至文本输入框

## 三、实验代码和截图

（1）SecondActivity.java

package edu.hzuapps.androidlabs.soft1614080902407;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.lang.String;
import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

public class SecondActivity extends AppCompatActivity {
    private EditText editText;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        final Activity thisActivity = this;
        Button btnBack = (Button)findViewById(R.id.gback);
        Button btnJoin= (Button)findViewById(R.id.btnJoin);
        editText = (EditText)findViewById(R.id.edittext);

        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(thisActivity,Soft1614080902407Activity_1.class);
                thisActivity.startActivity(intent);
            }
        });
        btnJoin.setOnClickListener(new View.OnClickListener() {//从文件读取内容
            @Override
            public void onClick(View v) {
                String inputText = load();
                editText.setText(inputText);
                editText.setSelection(inputText.length());
            }
        });
    }
    protected void onDestroy() {                            //存储文件

        super.onDestroy();
        String  inputText = editText.getText().toString();
        save(inputText);
    }
    public void save(String inputText){
        FileOutputStream out;
        BufferedWriter  writer = null;
        try {
            out = openFileOutput("data", MODE_PRIVATE);
            writer = new BufferedWriter(new OutputStreamWriter(out));
            writer.write(inputText);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if(writer!=null){
                    writer.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }
    public String load(){                                           //读取文件
        FileInputStream in =null;
        BufferedReader reader = null;
        StringBuilder content = new StringBuilder();
        try {
            in = openFileInput("data");
            reader = new BufferedReader(new InputStreamReader(in));
            String line = "";
            while ((line=reader.readLine())!= null){
                content.append(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if(reader!=null){
                try {
                    reader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return content.toString();
    }
}

（2）Soft1614080902407Activity_1.java

package edu.hzuapps.androidlabs.soft1614080902407;
import java.lang.String;
import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;

public class Soft1614080902407Activity_1 extends AppCompatActivity {
    String[]  adapterData;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_soft1614080902407_1);
        final ListView listView = (ListView)findViewById(R.id.listview);
        adapterData = new String[] { "文本1","文本2", "文本3","文本4"};
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>( Soft1614080902407Activity_1.this, android.R.layout.simple_list_item_1, adapterData);
        listView.setAdapter(arrayAdapter);
        final Activity  thisActivity = this;
        Button  btnHome = (Button)findViewById(R.id.btn_new);
        btnHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(thisActivity,SecondActivity.class);
                thisActivity.startActivity(intent);
            }
        });
    }
}

(3)activity_second.xml

<?xml version="1.0" encoding="utf-8"?>
<LinearLayout xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:app="http://schemas.android.com/apk/res-auto"
    xmlns:tools="http://schemas.android.com/tools"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    android:orientation="vertical"
    tools:context=".SecondActivity">

    <LinearLayout
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:gravity="center">

        <TextView
            android:layout_width="wrap_content"
            android:layout_height="match_parent"
            android:layout_weight="1"
            android:gravity="center"
            android:text="内容"
            android:textSize="20dp"
            android:textStyle="bold" />

    </LinearLayout>

    <LinearLayout
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:gravity="start">

        <EditText
            android:id="@+id/edittext"
            android:layout_width="wrap_content"
            android:layout_height="wrap_content"
            android:ems="20"
            android:hint="@string/hint_content"
            android:inputType="textMultiLine"
            android:minLines="5"
            android:textAppearance="?android:attr/textAppearanceLargeInverse" />
    </LinearLayout>

    <LinearLayout
        android:layout_width="wrap_content"
        android:layout_height="wrap_content">

        <ImageView
            android:layout_width="match_parent"
            android:layout_height="wrap_content"
            android:background="@drawable/example" />
    </LinearLayout>

    <LinearLayout
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:gravity="center_horizontal">

        <Button
            android:layout_width="wrap_content"
            android:layout_height="wrap_content"
            android:layout_weight="1"
            android:text="定时提醒"
            android:textStyle="bold" />

        <Button
            android:layout_width="wrap_content"
            android:layout_height="wrap_content"
            android:layout_weight="1"
            android:text="添加图片"
            android:textStyle="bold" />
    </LinearLayout>

    <LinearLayout
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:gravity="center_vertical">

        <Button
            android:id="@+id/btnJoin"
            android:layout_width="wrap_content"
            android:layout_height="wrap_content"
            android:layout_weight="1"
            android:text="读取备忘录"
            android:textStyle="bold" />

        <Button
            android:id="@+id/gback"
            android:layout_width="50dp"
            android:layout_height="wrap_content"
            android:background="@drawable/ic_arrow_back_black_24dp" />
    </LinearLayout>

</LinearLayout>

![image](https://github.com/Qiujialin/android-labs-2018/blob/master/soft1614080902407/%E5%AE%9E%E9%AA%8C%E6%88%AA%E5%9B%BE5-1.jpg?raw=true)

![image](https://github.com/Qiujialin/android-labs-2018/blob/master/soft1614080902407/%E5%AE%9E%E9%AA%8C%E6%88%AA%E5%9B%BE5-2.jpg?raw=true)

## 四、实验体会

本次实验我采用内部存储的方式，通过本次实验，我去学习了Java流的知识，学会了如何使用Java流进行一些简单的操作，了解了Android如何存储文件以及读取文件，并用Java流的方式将EditText的内容存储到文件中以及读取到EditText，文件保存在/data/data/edu.hzuapps.androidlabs.soft1614080902407/files文件夹下
