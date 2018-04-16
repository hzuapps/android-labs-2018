# 第二次实验
## 1.实验目标
完成对Android组件编程

## 2.实验步骤
### 1.在Issues中创建自己的选题：https://github.com/hzuapps/android-labs-2018/issues ；
### 2.根据自选题目，编写一个或多个Activity（所有均带上学号前缀，放到自己的Java包下）；
### 3.将标题设置为soft1614080902129学习软件；
提交代码$ git add soft1614080902129.java
$ git commit -m "#1 第1次实验" 
$ git push
## 3.实验结果
app
- src
-- main
--- AndroidManifest.xml (第1个文件)
--- java
---- com / example / administrator / soft1614080902129 / soft1614080902129MainActivity.kt (第2个文件)
--- res 
---- layout
----- activity_soft1614080902129_main.xml (第3个文件)
---- values
----- strings.xml (第4个文件)

#AndroidManifest.xml 
<?xml version="1.0" encoding="utf-8"?>
<manifest xmlns:android="http://schemas.android.com/apk/res/android"
    package="com.example.administrator.soft1614080902129">

    <application
        android:allowBackup="true"
        android:icon="@mipmap/ic_launcher"
        android:label="@string/app_name"
        android:roundIcon="@mipmap/ic_launcher_round"
        android:supportsRtl="true"
        android:theme="@style/AppTheme">
        <activity android:name=".soft1614080902129MainActivity">
            <intent-filter>
                <action android:name="android.intent.action.MAIN" />

                <category android:name="android.intent.category.LAUNCHER" />
            </intent-filter>
        </activity>
    </application>

</manifest>

#soft1614080902129MainActivity.kt
package com.example.administrator.soft1614080902129

import android.support.v7.app.AppCompatActivity
import android.os.Bundle

class soft1614080902129MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_soft1614080902129_main)
    }
}

#activity_soft1614080902129_main
<?xml version="1.0" encoding="utf-8"?>
<android.support.constraint.ConstraintLayout xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:app="http://schemas.android.com/apk/res-auto"
    xmlns:tools="http://schemas.android.com/tools"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    tools:context=".soft1614080902129MainActivity">

    <TextView
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:text="Hello World!"
        app:layout_constraintBottom_toBottomOf="parent"
        app:layout_constraintLeft_toLeftOf="parent"
        app:layout_constraintRight_toRightOf="parent"
        app:layout_constraintTop_toTopOf="parent" />

</android.support.constraint.ConstraintLayout>

#strings.xml
<resources>
    <string name="app_name">soft1614080902129学习软件</string>
</resources>


## 4.实验体会
这个实验要我们学会了对安卓的基本认识，通过对Android组件编程，对以后安卓项目有了初步的认识，需要自己对java有一定的了解，毕竟安卓的基础是java。
