+#2 第二次实验 
 +
 +## 1. 实验步骤
 +1.阅读实验要求：https://github.com/hzuapps/android-labs-2018/labels/Lab
 +
 +2.在电脑上Android Studio编写代码
 +
 +3.使用Git将代码提交到自己的库中：https://github.com/ChenchenJT/android-labs-2018
 +
 +$ git pull
 +$ git add 学号目录/*
 +$ git commit "#2 "
 +$ git push
 +
 +4.在自己的GitHub库上创建和发送Pull Request（注意查看Changed files）
 +
 +5.在GitHub中使用Markdown文件编写实验报告（report1.md, report2.md）
 +
 +
 +## 3. 实验结果
 +
 +###1strings.xml
 +<resources>
 +   <string name="app_name">餐厅点餐</string>
 +</resources>
 +
 +###2
 +<?xml version="1.0" encoding="utf-8"?>
<android.support.constraint.ConstraintLayout xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:app="http://schemas.android.com/apk/res-auto"
    xmlns:tools="http://schemas.android.com/tools"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    tools:context=".Soft161207051328Activity">

</android.support.constraint.ConstraintLayout>
 +
 +###3
 +package com.example.hasee.soft1612070501328;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class Soft161207051328Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_soft161207051328);
    }
}

 +
 +
 +###4
 +<?xml version="1.0" encoding="utf-8"?>
<manifest xmlns:android="http://schemas.android.com/apk/res/android"
    package="com.example.hasee.soft1612070501328">

    <application
        android:allowBackup="true"
        android:icon="@mipmap/ic_launcher"
        android:label="@string/app_name"
        android:roundIcon="@mipmap/ic_launcher_round"
        android:supportsRtl="true"
        android:theme="@style/AppTheme">
        <activity android:name=".MainActivity">
            <intent-filter>
                <action android:name="android.intent.action.MAIN" />

                <category android:name="android.intent.category.LAUNCHER" />
            </intent-filter>
        </activity>
        <activity android:name=".Soft161207051328Activity"></activity>
    </application>

</manifest>
 +
 +
 +
 +
 +
 +
 +## 4. 实验体会
