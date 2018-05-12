# 实验二

## 一、实验目标
	1、在Issues中创建自己的选题：https://github.com/hzuapps/android-labs-2018/issues ； 
	2、根据自选题目，编写一个或多个Activity（所有均带上学号前缀，放到自己的Java包下）； 
	3、将标题设置为自己的学号+对应的功能或题目； 
	4、根据自己选择的题目实现Activity中导航、调用等功能（选做）

## 二、实验步骤
	1、在Issues中创建选题：事件提醒；
	2、在Android Studio编写代码；
	3、编写实验报告
	4、提交代码并发Pull Request：
		$ git pull
		$ git add 路径/项目/* 
		$ git commit "#2 #970 第二次实验" 
		$ git push	

## 三、实验结果
<?xml version="1.0" encoding="utf-8"?>
<manifest xmlns:android="http://schemas.android.com/apk/res/android"
    package="soft1614080902313.androidlabs.hzuapps.edu.eventreminder">

    <application
        android:allowBackup="true"
        android:icon="@mipmap/ic_launcher"
        android:label="@string/app_name"
        android:roundIcon="@mipmap/ic_launcher_round"
        android:supportsRtl="true"
        android:theme="@style/AppTheme">
        <activity android:name=".Soft1614080902313EventReminderActivity">
            <intent-filter>
                <action android:name="android.intent.action.MAIN" />

                <category android:name="android.intent.category.LAUNCHER" />
            </intent-filter>
        </activity>
    </application>

</manifest>

package soft1614080902313.androidlabs.hzuapps.edu.eventreminder;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class Soft1614080902313EventReminderActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_soft1614080902313_event_reminder);
    }
}

<?xml version="1.0" encoding="utf-8"?>
<android.support.constraint.ConstraintLayout xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:app="http://schemas.android.com/apk/res-auto"
    xmlns:tools="http://schemas.android.com/tools"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    tools:context=".Soft1614080902313EventReminderActivity">

    <TextView
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:text="Hello World!"
        android:textSize="30dp"
        android:textColor="@color/colorPrimaryDark"
        app:layout_constraintBottom_toBottomOf="parent"
        app:layout_constraintLeft_toLeftOf="parent"
        app:layout_constraintRight_toRightOf="parent"
        app:layout_constraintTop_toTopOf="parent" />

</android.support.constraint.ConstraintLayout>

<resources>
    <string name="app_name">事件提醒</string>
</resources>

## 4.实验体会
    本次实验的内容较少，也较为简单，通过实验，了解了一些控件的作用，对标题，字体的大小、颜色等等的修改有了一定的了解。
