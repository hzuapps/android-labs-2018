# 第二次实验

## 1.实验要求

（1）在Issues中创建自己的选题：https://github.com/hzuapps/android-labs-2018/issues ；

（2）根据自选题目，编写一个或多个Activity（所有均带上学号前缀，放到自己的Java包下）；

（3）将标题设置为自己的学号+对应的功能或题目；

（4）根据自己选择的题目实现Activity中导航、调用等功能（选做）。

## 2.实验步骤

（1）阅读实验要求：https://github.com/hzuapps/android-labs-2018/labels/Lab

（2）在电脑上Android Studio编写代码

（3）使用Git将代码提交到自己的库中：https://github.com/Qiujialin/android-labs-2018

$ git pull

$ git add soft1614080902407/*

$ git commit "#2 #1015 备忘录 "

$ git push


（4）在自己的GitHub库上创建和发送Pull Request（注意查看Changed files）

（5）在GitHub中使用Markdown文件编写实验报告（report2.md）

## 3.实验结果

1.AndroidManifest.xml

<?xml version="1.0" encoding="utf-8"?>
<manifest xmlns:android="http://schemas.android.com/apk/res/android"
    package="com.example.hzu.soft1614080902407">

    <application
        android:allowBackup="true"
        android:icon="@mipmap/ic_launcher"
        android:label="@string/app_name"
        android:roundIcon="@mipmap/ic_launcher_round"
        android:supportsRtl="true"
        android:theme="@style/AppTheme">
        <activity android:name=".Soft1614080902407Activity_1">
            <intent-filter>
                <action android:name="android.intent.action.MAIN" />

                <category android:name="android.intent.category.LAUNCHER" />
            </intent-filter>
        </activity>
    </application>

</manifest>

2.Soft1614080902407Activity_1.java

package com.example.hzu.soft1614080902407;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class Soft1614080902407Activity_1 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_soft1614080902407_1);
    }
}

3.activity_soft1614080902407_1.xml

<?xml version="1.0" encoding="utf-8"?>
<android.support.constraint.ConstraintLayout xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:app="http://schemas.android.com/apk/res-auto"
    xmlns:tools="http://schemas.android.com/tools"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    tools:context=".Soft1614080902407Activity_1">

    <TextView
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:text="#1015 备忘录"
        app:layout_constraintBottom_toBottomOf="parent"
        app:layout_constraintLeft_toLeftOf="parent"
        app:layout_constraintRight_toRightOf="parent"
        app:layout_constraintTop_toTopOf="parent" />

</android.support.constraint.ConstraintLayout>

4.strings.xml

<resources>
    <string name="app_name">Soft1614080902407备忘录</string>
</resources>

![image](https://github.com/Qiujialin/android-labs-2018/blob/master/soft1614080902407/%E7%AC%AC%E4%BA%8C%E6%AC%A1%E5%AE%9E%E9%AA%8C%E6%88%AA%E5%9B%BE.png?raw=true)

## 4.实验体会

此次实验比之前的实验要复杂一点，但从中学会了许多基础知识，也更加熟悉Android Studio的操作
