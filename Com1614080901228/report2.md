一、实验要求
在Issues中创建自己的选题：https://github.com/hzuapps/android-labs-2018/issues ；
根据自选题目，编写一个或多个Activity（所有均带上学号前缀，放到自己的Java包下）；
将标题设置为自己的学号+对应的功能或题目；
根据自己选择的题目实现Activity中导航、调用等功能（选做）。

二.实验步骤
阅读实验要求：https://github.com/hzuapps/android-labs-2018/labels/Lab
在电脑上Android Studio编写代码
1）.自己建一个Activity文件
2）.找到values文件下的strings.xml文件，然后修改里面的一个值

3.使用Git将代码提交到自己的库中：
$ git add android-labs-2018/Com1614080901228/app/src/main/java/com1614080901228/androidlabs/hzuapps/edu/com1614080901228/Com1614080901228Activity.java
$ git add android-labs-2018/Com1614080901228/app/src/main/res/layout/activity_com1614080901228.xml
$ git add android-labs-2018/Com1614080901228/app/src/main/res/values/strings.xml
$ git add android-labs-2018/Com1614080901228/app/src/main/AndroidManifest.xml

$ git commit -m "第二次实验"

$ git push

1.在自己的GitHub库上创建和发送Pull Request（注意查看Changed files）
看有没有4个文件：三个xml文件，一个java

2.在GitHub中使用Markdown文件编写实验报告 report2.md

1）.creat 一个文件，命名为report2.md。
2）.编写文件
三.实验结果：
1.android-labs-2018/Com1614080901228/app/src/main/AndroidManifest.xml
<manifest xmlns:android="http://schemas.android.com/apk/res/android"
    package="com1614080901228.androidlabs.hzuapps.edu.com1614080901228">

    <application
        android:allowBackup="true"
        android:icon="@mipmap/ic_launcher"
        android:label="@string/app_name"
        android:roundIcon="@mipmap/ic_launcher_round"
        android:supportsRtl="true"
        android:theme="@style/AppTheme">
        <activity android:name=".Com1614080901228Activity">
            <intent-filter>
                <action android:name="android.intent.action.MAIN" />

                <category android:name="android.intent.category.LAUNCHER" />
            </intent-filter>
        </activity>
    </application>

</manifest>


2.android-labs-2018/Com1614080901228/app/src/main/res/layout/activity_com1614080901228.xml
<android.support.constraint.ConstraintLayout xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:app="http://schemas.android.com/apk/res-auto"
    xmlns:tools="http://schemas.android.com/tools"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    tools:context=".Com1614080901228Activity">

    <TextView
        android:layout_width="348dp"
        android:layout_height="wrap_content"
        android:text="1、查看 取件码\n2、查看快件物流"
        android:textColor="@android:color/white"
        android:textSize="25sp"
        tools:layout_editor_absoluteX="18dp"
        tools:layout_editor_absoluteY="223dp" />

</android.support.constraint.ConstraintLayout>
3.android-labs-2018/Com1614080901228/app/src/main/res/values/strings.xml
<resources>
    <string name="app_name">intelpickup</string>
</resources>
4.android-labs-2018/Com1614080901228/app/src/main/java/com1614080901228/androidlabs/hzuapps/edu/com1614080901228/Com1614080901228Activity.java
package com1614080901228.androidlabs.hzuapps.edu.com1614080901228;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class Com1614080901228Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_com1614080901228);
    }
}

四.实验体会：
经历了种种坎坷，我终于独立自主地做好了。不知道何方原因，首先，电脑配置不够，千辛万苦安装好之后，androidstudio跑不起来。其次，在别人电脑上操作的时候，
由于对软件的不熟悉，app名字一直修改不了，在解决问题之后，提交时，账号或者密码一直出错，配了好多好多遍sshkey，千辛万苦迟到的作业，忘老师手下留情。
