# 第二次实验

## 1.实验目标

（1）在Issues中创建自己的选题：https://github.com/hzuapps/android-labs-2018/issues ； 
（2）根据自选题目，编写一个或多个Activity（所有均带上学号前缀，放到自己的Java包下）； 
（3）将标题设置为自己的学号+对应的功能或题目； 
（4）根据自己选择的题目实现Activity中导航、调用等功能（选做）

## 2.实验步骤
1.在Github Issues中创建选题“颜色采集器”  
2.在Android Studio中新建项目ColourSelect，默认Activity命名为Soft1614080902326Activity.java  
3.运行调试

## 3.实验结果
```xml
<?xml version="1.0" encoding="utf-8"?>
<manifest xmlns:android="http://schemas.android.com/apk/res/android"
    package="com.example.edu">

    <application
        android:allowBackup="true"
        android:icon="@mipmap/ic_launcher"
        android:label="@string/app_name"
        android:roundIcon="@mipmap/ic_launcher_round"
        android:supportsRtl="true"
        android:theme="@style/AppTheme">
        <activity
            android:name=".MainActivity"
            android:label="@string/app_name">
            <intent-filter>
                <action android:name="android.intent.action.MAIN" />

                <category android:name="android.intent.category.LAUNCHER" />
            </intent-filter>
        </activity>
    </application>

</manifest>
```

## 4.实验体会
通过实验大致掌握了android application的组成，也知道了activity的作用，为以后添加功能奠定基础。
