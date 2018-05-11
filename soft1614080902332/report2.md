# 第2次实验

## 1.实验要求
1.在Issues中创建自己的选题：https://github.com/hzuapps/android-labs-2018/issues ；

2.根据自选题目，编写一个或多个Activity（所有均带上学号前缀，放到自己的Java包下）；

3.将标题设置为自己的学号+对应的功能或题目；

4.根据自己选择的题目实现Activity中导航、调用等功能（选做）。
## 2.实验步骤
1. 阅读实验要求：https://github.com/hzuapps/android-labs-2018/labels/Lab   

2. 在电脑上Android Studio编写代码  

3. 使用Git将代码提交到自己的库中 
$ git pull
$ git add 学号目录/*
$ git commit "#2"
$ git push

4. 在自己的GitHub库上创建和发送Pull Request（注意查看Changed files）  

5. 在GitHub中使用Markdown文件编写实验报告
## 3.实验结果
###AndroidManifest.xml
<?xml version="1.0" encoding="utf-8"?>
<manifest xmlns:android="http://schemas.android.com/apk/res/android"
    package="edu.hzuapps.androidlabs.Soft1614080902332">

    <application
        android:allowBackup="true"
        android:icon="@mipmap/ic_launcher"
        android:label="@string/app_name"
        android:roundIcon="@mipmap/ic_launcher_round"
        android:supportsRtl="true"
        android:theme="@style/AppTheme">
        <activity android:name=".Soft1614080902332Activity1">
            <intent-filter>
                <action android:name="android.intent.action.MAIN" />

                <category android:name="android.intent.category.LAUNCHER" />
            </intent-filter>
        </activity>
        <activity android:name=".Soft1614080902332Activity2"></activity>
    </application>

</manifest>

###soft_1614080902332_activity1.xml
<?xml version="1.0" encoding="utf-8"?>
<android.support.constraint.ConstraintLayout xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:app="http://schemas.android.com/apk/res-auto"
    xmlns:tools="http://schemas.android.com/tools"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    tools:context=".Soft1614080902332Activity1">

    <TextView
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:text="Hello World!"
        app:layout_constraintBottom_toBottomOf="parent"
        app:layout_constraintLeft_toLeftOf="parent"
        app:layout_constraintRight_toRightOf="parent"
        app:layout_constraintTop_toTopOf="parent" />

</android.support.constraint.ConstraintLayout>


###soft_1614080902332_activity2.xml
<?xml version="1.0" encoding="utf-8"?>
<android.support.constraint.ConstraintLayout xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:app="http://schemas.android.com/apk/res-auto"
    xmlns:tools="http://schemas.android.com/tools"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    tools:context=".Soft1614080902332Activity2">

</android.support.constraint.ConstraintLayout>


###strings.xml
<resources>
    <string name="app_name">失物招领</string>
</resources>


###Soft1614080902332Activity1.java
package edu.hzuapps.androidlabs.Soft1614080902332;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class Soft1614080902332Activity1 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.soft_1614080902332_activity1);
    }
}


###Soft1614080902332Activity2.java
package edu.hzuapps.androidlabs.Soft1614080902332;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class Soft1614080902332Activity2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.soft_1614080902332_activity2);
    }
}


## 4.实验体会
本次实验花费较多时间，一开始很多细节没有搞清楚，实验过程中需要和同学交流讨论……
