# 第二次实验

## 1、实验目标

（1）、在Issues中创建自己的选题：https://github.com/hzuapps/android-labs-2018/issues ；

（2）、根据自选题目，编写一个或多个Activity（所有均带上学号前缀，放到自己的Java包下）；

（3）、将标题设置为自己的学号+对应的功能或题目；

（4）、根据自己选择的题目实现Activity中导航、调用等功能（选做）。

## 2、实验步骤

（1）、通过Android studio 3.1建立一个词汇测试的项目，创建activity文件；

（2）、通过Android studio 3.1编写代码；

（3）、通过git将代码和实验文件提交到自己的库中；

（4）、在GitHub中编写实验代码；

## 3、实验结果
<?xml version="1.0" encoding="utf-8"?>
<manifest xmlns:android="http://schemas.android.com/apk/res/android"
    package="edu.hzuapps.androidlabs.Soft1614080902319Activity">

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
    </application>

</manifest>

package edu.hzuapps.androidlabs.Soft1614080902319Activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

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
    tools:context=".MainActivity">

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
    <string name="app_name">词汇测试</string>
</resources>

    
## 4、实验体会

本次实验较为简单。只是单纯的建立一个项目和Activity.
