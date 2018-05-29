# 第二次实验

## 1、实验目标

（1）、在Issues中创建自己的选题：https://github.com/hzuapps/android-labs-2018/issues ；

（2）、根据自选题目，编写一个或多个Activity（所有均带上学号前缀，放到自己的Java包下）；

（3）、将标题设置为自己的学号+对应的功能或题目；

（4）、根据自己选择的题目实现Activity中导航、调用等功能（选做）。

## 2、实验步骤

（1）、先在GitHub上创建一个Issues,这个Issues包含自己想要做的app要实现的两个功能；

（2）、在Android studio中新建两个Activity；

（3）、通过git将代码和实验文件提交到自己的库中；

（4）、在GitHub中编写实验报告；

## 3、实验结果
<?xml version="1.0" encoding="utf-8"?>
<manifest xmlns:android="http://schemas.android.com/apk/res/android"
    package="soft1614080902310.androidlabs.hzuapps.edu.weather_report">

    <application
        android:allowBackup="true"
        android:icon="@mipmap/ic_launcher"
        android:label="@string/app_name"
        android:roundIcon="@mipmap/ic_launcher_round"
        android:supportsRtl="true"
        android:theme="@style/AppTheme">
        <activity
            android:name=".Soft1614080902310weather_reportActivity"
            android:label="@string/app_name"
            android:theme="@style/AppTheme.NoActionBar">
            <intent-filter>
                <action android:name="android.intent.action.MAIN" />

                <category android:name="android.intent.category.LAUNCHER" />
            </intent-filter>
        </activity>
    </application>

</manifest>






package soft1614080902310.androidlabs.hzuapps.edu.weather_report;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;

public class Soft1614080902310weather_reportActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_soft1614080902310weather_report);
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
        getMenuInflater().inflate(R.menu.menu_soft1614080902310weather_report, menu);
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


< resources>
    < string name="app_name">weather_report</ string>
    
## 4、实验体会

本次实验较为简单，只是单纯的建立一个项目和Activity，但还是有收获的。
