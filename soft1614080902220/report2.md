# 1.实验目标
了解Android组件编程

# 2.实验步骤
（1）在Issues中创建自己的选题：https://github.com/hzuapps/android-labs-2018/issues ；
（2）根据自选题目，编写一个或多个Activity（所有均带上学号前缀，放到自己的Java包下）；
（3）将标题设置为自己的学号+对应的功能或题目；
（4）根据自己选择的题目实现Activity中导航、调用等功能（选做）。

# 3.实验结果
（1）package edu.hzuapps.androidlabs.soft1614080902220

import android.support.v7.app.AppCompatActivity
import android.os.Bundle

class soft1614080902220Activity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_soft1614080902220)
    }
}

（2）
<resources>
    <string name="app_name">soft1614080902220微信自动抢红包软件</string>
</resources>

(3)
<?xml version="1.0" encoding="utf-8"?>
<manifest xmlns:android="http://schemas.android.com/apk/res/android"
    package="edu.hzuapps.androidlabs.soft1614080902220">

    <application
        android:allowBackup="true"
        android:icon="@mipmap/ic_launcher"
        android:label="@string/app_name"
        android:roundIcon="@mipmap/ic_launcher_round"
        android:supportsRtl="true"
        android:theme="@style/AppTheme">
        <activity android:name=".soft1614080902220Activity">
            <intent-filter>
                <action android:name="android.intent.action.MAIN" />

                <category android:name="android.intent.category.LAUNCHER" />
            </intent-filter>
        </activity>
    </application>

</manifest>

(4)
<?xml version="1.0" encoding="utf-8"?>
<android.support.constraint.ConstraintLayout xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:app="http://schemas.android.com/apk/res-auto"
    xmlns:tools="http://schemas.android.com/tools"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    tools:context=".soft1614080902220Activity">

    <TextView
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:text="Hello World!"
        app:layout_constraintBottom_toBottomOf="parent"
        app:layout_constraintLeft_toLeftOf="parent"
        app:layout_constraintRight_toRightOf="parent"
        app:layout_constraintTop_toTopOf="parent" />

</android.support.constraint.ConstraintLayout>

# 4.实验体会
  初步了解了Android组件编程的步骤，虽然比较简单，但对后续的Android代码编写不可缺少，同时提高了对Android软件的认识！
