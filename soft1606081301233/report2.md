# 第2次实验报告

## 一、实验要求

### 1.在Issues中创建自己的选题：https://github.com/hzuapps/android-labs-2018/issues ；

### 2.根据自选题目，编写一个或多个Activity（所有均带上学号前缀，放到自己的Java包下）；

### 3.将标题设置为自己的学号+对应的功能或题目；

### 4.根据自己选择的题目实现Activity中导航、调用等功能（选做）。

## 二、实验步骤

### 1.阅读实验要求：https://github.com/hzuapps/android-labs-2018/labels/Lab

### 2.在电脑上Android Studio编写代码
      // 代码要可以运行！
      
### 3.使用Git将代码提交到自己的库中：https://github.com/YOUR_NAME/android-labs-2018
      $ git pull
      $ git add 学号目录/*
      $ git commit "#12345678 "
      $ git push
      
### 4.在自己的GitHub库上创建和发送Pull Request（注意查看Changed files）
      // 是否只修改了自己的文件？
      
### 5.在GitHub中使用Markdown文件编写实验报告（report1.md, report2.md）
      // 保存在自己的文件夹下
## 三、实验提示
根据MVC、MVP设计模式或其他Android App设计模式设计Java类；
先设计表示业务数据的Java类，如表示订单、图书、商品、车辆、音乐、笔记等的类；
再考虑设计一些业务服务类，如网络连接等类；
上传代码时，代码放到自己的学号里面，同时保留Studio的目录结果，如：
app
- src
-- main
--- AndroidManifest.xml (第1个文件)
--- java
---- edu / hzuapps / androidlabs / Soft学号 / Soft学号Activity.java (第2个文件)
--- res 
---- layout
----- soft_学号_activity.xml (第3个文件)
---- values
----- strings.xml (第4个文件)
## 四、实验结果
package edu.hzuapps.androidlabs.soft1606081301233;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
 public class Soft1606081301233Activity extends AppCompatActivity {

   @Override
   protected void onCreate(Bundle savedInstanceState) {
       super.onCreate(savedInstanceState);
       setContentView(R.layout.activity_soft1606081301233);
   }
}

   <?xml version="1.0" encoding="utf-8"?>
   <android.support.constraint.ConstraintLayout
   xmlns:android="http://schemas.android.com/apk/res/android"
   xmlns:tools="http://schemas.android.com/tools"
   xmlns:app="http://schemas.android.com/apk/res-auto"
   android:layout_width="match_parent"
   android:layout_height="match_parent"
   tools:context="edu.hzuapps.androidlabs.soft1606081301233.Soft1606081301233Activity">
   <TextView
       android:layout_width="wrap_content"
       android:layout_height="wrap_content"
       android:text="Hello World!"
       app:layout_constraintBottom_toBottomOf="parent"
       app:layout_constraintLeft_toLeftOf="parent"
       app:layout_constraintRight_toRightOf="parent"
       app:layout_constraintTop_toTopOf="parent" />
</android.support.constraint.ConstraintLayout>

 <?xml version="1.0" encoding="utf-8"?>
 <manifest xmlns:android="http://schemas.android.com/apk/res/android"
   package="edu.hzuapps.androidlabs.soft1606081301233" >

   <application
       android:allowBackup="true"
       android:icon="@mipmap/ic_launcher"
       android:label="soft1606081301233日历日程"
       android:roundIcon="@mipmap/ic_launcher_round"
       android:supportsRtl="true"
       android:theme="@style/AppTheme" >
       <activity android:name=".Soft1606081301233Activity" >
       <intent-filter>
       <action android:name="android.intent.action.MAIN" /
       <category android:name="android.intent.category.LAUNCHER" />
       </intent-filter>
       </activity>
</application>
</manifest>

<resources>
      <string name="app_name">soft1606081301233日历日程</string> 
</resources>


## 四、实验体会
本次实验是首先创建一个简单的项目，项目的实现代码还没有给出，但项目还是可以成功运行的，运行app时需要有模拟机，否则不能运行。搭建开发环境的过程较为耗时，
运行过程也很缓慢。虽然创建这个简单的程序并不是很难，只是我不熟悉，不懂如何操作才正确，然后花费了挺多时间的，不过还好最后成功创建运行。
