# 第二次实验

## 1.实验目的

（1）在Issues中创建自己的选题：https://github.com/hzuapps/android-labs-2018/issues ；

（2）根据自选题目，编写一个或多个Activity（所有均带上学号前缀，放到自己的Java包下）；

（3）将标题设置为自己的学号+对应的功能或题目；

（4）根据自己选择的题目实现Activity中导航、调用等功能（选做）

## 2.实验步骤

（1）阅读实验要求：https://github.com/hzuapps/android-labs-2018/labels/Lab

（2）在电脑上Android Studio编写代码，提取四个文件

（3）通过Git将文件提交到自己的库中：https://github.com/chbaju/android-labs-2018

（4）在自己的库中编写实验报告

（5）在自己的GitHub库上将文件连同实验报告发送到hzuapps库中

## 3.实验结果
package com.example.administrator.soft1614080902219;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;


public class MainActivity extends Activity{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
}
}

<?xml version="1.0" encoding="utf-8"?>
<android.support.constraint.ConstraintLayout xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:app="http://schemas.android.com/apk/res-auto"
    xmlns:tools="http://schemas.android.com/tools"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    tools:context="com.example.administrator.soft1614080902219.MainActivity">
    
    <resources>
    <string name="阅读器">soft1614080902219</string>

?xml version="1.0" encoding="utf-8"?>
<manifest xmlns:android="http://schemas.android.com/apk/res/android"
 package="com.example.administrator.soft1614080902219">
   <application
        android:allowBackup="true"
        android:icon="@mipmap/ic_launcher"
        android:label="@string/"
        android:roundIcon="@mipmap/ic_launcher_round"
        android:supportsRtl="true"
        android:theme="@style/AppTheme"
        >
         </application>
</manifest>

阅读器

## 4.实验体会

由于对android软件的使用十分陌生，使得实验过程十分的复杂和坎坷，用Git Bash上传代码也很困难。
