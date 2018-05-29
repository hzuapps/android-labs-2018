# 第二次实验

## 1.实验目标
Android组件编程

## 2.实验步骤

1. 阅读实验要求：https://github.com/hzuapps/android-labs-2018/labels/Lab   

2. 在电脑上Android Studio编写代码  

```   
// 代码要可以运行！
```   

3. 使用Git将代码提交到自己的库中：https://github.com/YOUR_NAME/android-labs-2018   
```  
$ git pull
$ git add 学号目录/*
$ git commit "#12345678 "
$ git push
```  

4. 在自己的GitHub库上创建和发送Pull Request（注意查看Changed files）  
```  
// 是否只修改了自己的文件？
```  

5. 在GitHub中使用Markdown文件编写实验报告（report1.md, report2.md）  
```  
// 保存在自己的文件夹下
## 3.实验结果
1.Soft1614080902117Activity.java

package edu.hzuapps.androidlabs.soft1614080902117.myapplication;
+
+import android.support.v7.app.AppCompatActivity;
+import android.os.Bundle;
+
+public class Soft1614080902117Activity extends AppCompatActivity {
+
+    @Override
+    protected void onCreate(Bundle savedInstanceState) {
+        super.onCreate(savedInstanceState);
+        setContentView(R.layout.activity_soft1614080902117);
+    }
+}

2.AndroidManifest.xml

<?xml version="1.0" encoding="utf-8"?>
<manifest xmlns:android="http://schemas.android.com/apk/res/android"
    package="edu.hzuapps.androidlabs.soft1614080902117.myapplication">

    <application
        android:allowBackup="true"
        android:icon="@mipmap/ic_launcher"
        android:label="@string/app_name"
        android:roundIcon="@mipmap/ic_launcher_round"
        android:supportsRtl="true"
        android:theme="@style/AppTheme">
        <activity android:name=".Soft1614080902117Activity">
            <intent-filter>
                <action android:name="android.intent.action.MAIN" />

                <category android:name="android.intent.category.LAUNCHER" />
            </intent-filter>
        </activity>
    </application>

</manifest>

3.activity_soft1614080902117.xml

+<?xml version="1.0" encoding="utf-8"?>
+<android.support.constraint.ConstraintLayout xmlns:android="http://schemas.android.com/apk/res/android"
+    xmlns:app="http://schemas.android.com/apk/res-auto"
+    xmlns:tools="http://schemas.android.com/tools"
+    android:layout_width="match_parent"
+    android:layout_height="match_parent"
+    tools:context="edu.hzuapps.androidlabs.soft1614080902117.myapplication.Soft1614080902117Activity">
+
+    <TextView
+        android:layout_width="wrap_content"
+        android:layout_height="wrap_content"
+        android:text="Hello World!"
+        app:layout_constraintBottom_toBottomOf="parent"
+        app:layout_constraintLeft_toLeftOf="parent"
+        app:layout_constraintRight_toRightOf="parent"
+        app:layout_constraintTop_toTopOf="parent" />
+
+</android.support.constraint.ConstraintLayout>

4.strings.xml

<resources>
+    <string name="app_name">Soft1614080902117备忘录</string>
+</resources>

## 4.实验体会
    本次实验使用Android Studio编写代码，通过此次实验学会了在Android中Activity的
    创建、标题的修改，同时也选择了相对简单的选题进行接下来的实验。
