# 第二次实验报告

## 一、实验目的：Android组件编程
 
## 二、实验要求：

在Issues中创建自己的选题：https://github.com/hzuapps/android-labs-2018/issues ；

根据自选题目，编写一个或多个Activity（所有均带上学号前缀，放到自己的Java包下）；

将标题设置为自己的学号+对应的功能或题目；

根据自己选择的题目实现Activity中导航、调用等功能（选做）。

## 三、实验结果

<?xml version="1.0" encoding="utf-8"?>
+<manifest xmlns:android="http://schemas.android.com/apk/res/android"
+    package="edu.hzuapps.androidlabs.com1614080901136">
+
+    <application
+        android:allowBackup="true"
+        android:icon="@mipmap/ic_launcher"
+        android:label="@string/app_name"
+        android:roundIcon="@mipmap/ic_launcher_round"
+        android:supportsRtl="true"
+        android:theme="@style/AppTheme">
+        <activity android:name=".Com1614080901136Activity">
+            <intent-filter>
+                <action android:name="android.intent.action.MAIN" />
+
+                <category android:name="android.intent.category.LAUNCHER" />
+            </intent-filter>
+        </activity>
+    </application>
+
+</manifest> 
  
13  .../app/src/main/java/edu/hzuapps/androidlabs/com1614080901136/Com1614080901136Activity.java
@@ -0,0 +1,13 @@
+package edu.hzuapps.androidlabs.com1614080901136;
+
+import android.support.v7.app.AppCompatActivity;
+import android.os.Bundle;
+
+public class Com1614080901136Activity extends AppCompatActivity {
+
+    @Override
+    protected void onCreate(Bundle savedInstanceState) {
+        super.onCreate(savedInstanceState);
+        setContentView(R.layout.activity_com1614080901136);
+    }
+}
  
18  com1614080901136/app/src/main/res/layout/activity_com1614080901136.xml
@@ -0,0 +1,18 @@
+<?xml version="1.0" encoding="utf-8"?>
+<android.support.constraint.ConstraintLayout xmlns:android="http://schemas.android.com/apk/res/android"
+    xmlns:app="http://schemas.android.com/apk/res-auto"
+    xmlns:tools="http://schemas.android.com/tools"
+    android:layout_width="match_parent"
+    android:layout_height="match_parent"
+    tools:context=".Com1614080901136Activity">
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
  
3  com1614080901136/app/src/main/res/values/strings.xml
@@ -0,0 +1,3 @@
+<resources>
+    <string name="app_name">充电站查询系统</string>
+</resources>

## 四、实验体会：

是较简单的一次实验，但还需要慢慢学习摸索
