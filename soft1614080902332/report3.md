# 第3次实验
## 1.实验目标
掌握在Android应用中使用图片等资源的方法。
## 2.实验要求
1.在界面上显示至少一张图片（按照自己的题目添加）；

2.提交res/drawable及图片使用的代码；

3.提交res/values, res/layout等其他代码；

4.将应用运行结果截图，放到实验报告中；

5.点击图片（或按钮）时，打开另一个Activity。
## 3.实验步骤
1.打开Android studio；

2.打开layout文件夹里的soft_1614080902332_activity1.xml;

3.添加1张图片和2个按钮；

4.打开java类文件Soft1614080902332Activity1;

5.设计动作，实现在Soft1614080902332Activity1点击按钮1时打开Soft1614080902332Activity2，点击按钮2时打开Soft1614080902332Activity3。


## 3.实验结果
package edu.hzuapps.androidlabs.Soft1614080902332;

import android.support.v7.app.AppCompatActivity;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.view.View.OnClickListener;

import edu.hzuapps.androidlabs.Soft1614080902332.Soft1614080902332Activity1;
import edu.hzuapps.androidlabs.Soft1614080902332.R;

public class Soft1614080902332Activity1 extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.soft_1614080902332_activity1);

        final Activity thisActivity = this;

        final Button btnOpen1 = (Button) findViewById(R.id.button_open1);
        final Button btnOpen2 = (Button) findViewById(R.id.button_open2);
        btnOpen1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(v.equals(btnOpen1)) {
                    Intent intent = new Intent(thisActivity,Soft1614080902332Activity2.class);
                    thisActivity.startActivity(intent);
                }
            }
        });
        btnOpen2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(v.equals(btnOpen2)) {
                    Intent intent = new Intent(thisActivity,Soft1614080902332Activity3.class);
                    thisActivity.startActivity(intent);
                }
            }
        });

    }
}


<?xml version="1.0" encoding="utf-8"?>
<android.support.constraint.ConstraintLayout xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:app="http://schemas.android.com/apk/res-auto"
    xmlns:tools="http://schemas.android.com/tools"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    tools:context=".Soft1614080902332Activity1">

    <LinearLayout
        android:layout_width="match_parent"
        android:layout_height="match_parent"
        android:orientation="vertical"
        tools:layout_editor_absoluteX="0dp"
        tools:layout_editor_absoluteY="0dp">

        <ImageView
            android:id="@+id/imageView2"
            android:layout_width="match_parent"
            android:layout_height="wrap_content"
            android:src="@drawable/picture" />

        <LinearLayout
            android:layout_width="match_parent"
            android:layout_height="50dp"
            android:background="#ffffff"
            android:orientation="horizontal">

            <Button
                android:id="@+id/button_open1"
                android:layout_width="wrap_content"
                android:layout_height="wrap_content"
                android:layout_weight="1"
                android:text="浏览失物" />

            <Button
                android:id="@+id/button_open2"
                android:layout_width="wrap_content"
                android:layout_height="wrap_content"
                android:layout_weight="1"
                android:text="上传失物" />
        </LinearLayout>
    </LinearLayout>
</android.support.constraint.ConstraintLayout>

![image](https://github.com/QFJay/android-labs-2018/blob/master/soft1614080902332/002.png)
![image](https://github.com/QFJay/android-labs-2018/blob/master/soft1614080902332/003.png)
## 4.实验体会
本次实验难度略大于上一次实验，花费了较多时间，但同时也学到不少知识。
