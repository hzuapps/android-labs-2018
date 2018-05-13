第二次实验
# 1、实验目标
## （1）、在Issues中创建自己的选题：https://github.com/hzuapps/android-labs-2018/issues ；
## （2）、根据自选题目，编写一个或多个Activity（所有均带上学号前缀，放到自己的Java包下）；
## （3）、将标题设置为自己的学号+对应的功能或题目；
## （4）、根据自己选择的题目实现Activity中导航、调用等功能（选做）。

# 2、实验步骤
1.创建工程

2.新建一个名为com1614080901219的basic类，在edu.hzuapps.androidlabs.com1614080901219包下

3.截图

# 3、实验结果
 package edu.hzuapps.androidlabs.com1614080901219;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class com1614080901219 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_com1614080901219);
    }
}

<?xml version="1.0" encoding="utf-8"?>
<manifest xmlns:android="http://schemas.android.com/apk/res/android"
    package="edu.hzuapps.androidlabs.com1614080901219">

    <application
        android:allowBackup="true"
        android:icon="@mipmap/ic_launcher"
        android:label="@string/app_name"
        android:roundIcon="@mipmap/ic_launcher_round"
        android:supportsRtl="true"
        android:theme="@style/AppTheme">
        <activity android:name=".com1614080901219">
            <intent-filter>
                <action android:name="android.intent.action.MAIN" />

                <category android:name="android.intent.category.LAUNCHER" />
            </intent-filter>
        </activity>
    </application>

</manifest>

<?xml version="1.0" encoding="utf-8"?>
<android.support.constraint.ConstraintLayout xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:app="http://schemas.android.com/apk/res-auto"
    xmlns:tools="http://schemas.android.com/tools"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    tools:context=".com1614080901219">

    <TextView
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:text="Hello World!"
        app:layout_constraintBottom_toBottomOf="parent"
        app:layout_constraintLeft_toLeftOf="parent"
        app:layout_constraintRight_toRightOf="parent"
        app:layout_constraintTop_toTopOf="parent" />

</android.support.constraint.ConstraintLayout>

<resources>
    <string name="app_name">掌上道具城</string>
</resources>

![在Android SDK Manager中配置教育网下载代理](https://github.com/as6296463/android-labs-2018/blob/master/com1614080901219/2.png "配置教育网下载代理")
# 4、实验体会
 本次实验总体操作比较简单，进一步熟悉了Android stdio这个软件，在添加那4个文件时需要根据目录寻找到后再上传，花了比较长的时间，懂得了如何修改项目的配置。
