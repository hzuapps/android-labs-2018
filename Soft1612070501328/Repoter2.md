#2 第二次实验
  
  ## 1.实验目标
  
  创建第一个activity文件
  
  ## 2. 实验步骤
  1.阅读实验要求：https://github.com/hzuapps/android-labs-2018/labels/Lab
  
  2.在电脑上Android Studio编写代码
  
  3.使用Git将代码提交到自己的库中：https://github.com/IsMyLucas/android-labs-2018.git
  
 $ git pull
 $ git add 学号目录/*
 $ git commit "#2 "
 $ git push
 4.在自己的GitHub库上创建和发送Pull Request（注意查看Changed files）
 5.在GitHub中使用Markdown文件编写实验报告（report1.md, report2.md）
 
 
  ## 3.实验结果
  ###1、AndroidManifest.xml
 <?xml version="1.0" encoding="utf-8"?>
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

###2.Soft161207051328Activity.java
package com.example.hasee.soft1612070501328;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class Soft161207051328Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_soft161207051328);
    }
}

###3.activity_soft161207051328.xml
 <?xml version="1.0" encoding="utf-8"?>
<android.support.constraint.ConstraintLayout 
xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:app="http://schemas.android.com/apk/res-auto"
    xmlns:tools="http://schemas.android.com/tools"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    tools:context=".Soft161207051328Activity">

</android.support.constraint.ConstraintLayout>

###4.strings.xml 
<resources>
    <string name="app_name">餐厅点餐</string>
</resources>

 
  ## 4.实验体会
     弄了一晚上，初步明白了Activity的定义以及内容，掌握了创建基本的Activity的方法没有太大的问题，进一步提高了对Android开发的认识。
