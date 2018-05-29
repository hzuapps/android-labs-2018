
# 第二次试验报告
## 1、实验目的
    （1）在Isuse中提交自己的选题；
    （2）使用Android studio生成项目文件，根据项目需求编写出一个Activity
## 2、实验环境
    （1）www.github.com； 
    （2）git软件；
    （3）Android studio
  
## 3、实验步骤
    （1）阅读实验要求：https://github.com/hzuapps/android-labs-2018/labels/Lab；
    （2）在电脑上Android Studio编写代码；
    （3）使用Git将代码提交到自己的库中：https://github.com/YOUR_NAME/android-labs-2018
      $ git pull；
      $ git add 学号目录/*
      $ git commit "#12345678 "
      $ git push
      在自己的GitHub库上创建和发送Pull Request（注意查看Changed files）；
    （4）在GitHub中使用Markdown文件编写实验报告（report1.md, report2.md）。
## 4、实验代码
    （1）AndroidManifest.xml 
    
<?xml version="1.0" encoding="utf-8"?>
<manifest xmlns:android="http://schemas.android.com/apk/res/android"
    package="com.example.hzu.soft1606081301325activity">

    <application
        android:allowBackup="true"
        android:icon="@mipmap/ic_launcher"
        android:label="@string/app_name"
        android:roundIcon="@mipmap/ic_launcher_round"
        android:supportsRtl="true"
        android:theme="@style/AppTheme">
        <activity
            android:name=".Soft1606081301325Activity"
            android:label="@string/app_name"
            android:theme="@style/AppTheme.NoActionBar">
            <intent-filter>
                <action android:name="android.intent.action.MAIN" />

                <category android:name="android.intent.category.LAUNCHER" />
            </intent-filter>
        </activity>
    </application>

</manifest>

    （2）Soft1606081301325Activity.java 
    
    package com.example.hzu.soft1606081301325activity;
    import android.os.Bundle;
    import android.support.design.widget.FloatingActionButton;
    import android.support.design.widget.Snackbar;
    import android.support.v7.app.AppCompatActivity;
    import android.support.v7.widget.Toolbar;
    import android.view.View;
    import android.view.Menu;
    import android.view.MenuItem;

    public class Soft1606081301325Activity extends AppCompatActivity {

    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_soft1606081301325);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_soft1606081301325, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
        }
    }
    （3）activity_soft1606081301325.xml
    
    <?xml version="1.0" encoding="utf-8"?>
    <android.support.design.widget.CoordinatorLayout xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:app="http://schemas.android.com/apk/res-auto"
    xmlns:tools="http://schemas.android.com/tools"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    tools:context="com.example.hzu.soft1606081301325activity.Soft1606081301325Activity">

    <android.support.design.widget.AppBarLayout
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:theme="@style/AppTheme.AppBarOverlay">

        <android.support.v7.widget.Toolbar
            android:id="@+id/toolbar"
            android:layout_width="match_parent"
            android:layout_height="?attr/actionBarSize"
            android:background="?attr/colorPrimary"
            app:popupTheme="@style/AppTheme.PopupOverlay" />

    </android.support.design.widget.AppBarLayout>

    <include layout="@layout/content_soft1606081301325" />

    <android.support.design.widget.FloatingActionButton
        android:id="@+id/fab"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:layout_gravity="bottom|end"
        android:layout_margin="@dimen/fab_margin"
        app:srcCompat="@android:drawable/ic_dialog_email" />

    </android.support.design.widget.CoordinatorLayout>
    （4）strings.xml 
    
    
    <resources>
        <string name="app_name">Soft1606081301325ResourceManager </string>
        <string name="action_settings">Settings</string>
    </resources>
    
## 5、实验体会
    （1）一个应用通常由多个彼此松散联系的 Activity 组成；
    （2）新建的视窗（Activity）都会获得一个窗口；这个窗口是安卓APP实现用户界面的一个重要组成部分，提供给用户交互功能；
    （3）通过仔细的思考，我选择了难度比较低的资源管理器选题，在后续的实验中主要学到的知识在该项目上时间，
         实现一个具有美观页面和文件搜索功能界面的文件管理APP。
