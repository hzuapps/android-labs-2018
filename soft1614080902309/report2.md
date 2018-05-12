# 第二次实验
## 1.实验目标 选出自己要写的程序课题
## 2. 实验步骤
1. 阅读实验要求：https://github.com/hzuapps/android-labs-2018/labels/Lab   

2. 在电脑上Android Studio编写代码  
 
// 代码要可以运行！

3. 使用Git将代码提交到自己的库中：https://github.com/YOUR_NAME/android-labs-2018   

$ git pull
$ git add 学号目录/*
$ git commit "#12345678 "
$ git push
   
4. 在自己的GitHub库上创建和发送Pull Request（注意查看Changed files）  
  
// 是否只修改了自己的文件？
  
5. 在GitHub中使用Markdown文件编写实验报告（report1.md, report2.md）`  
// 保存在自己的文件夹下

 


## 3. 实验结果
package edu.hzuapps.androidlabs.Soft1614080902309;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class Soft1614080902309Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.soft_1614080902309_activity);
    }
}





<?xml version="1.0" encoding="UTF-8"?>

-<android.support.constraint.ConstraintLayout tools:context=".Soft1614080902309Activity" android:layout_height="match_parent" android:layout_width="match_parent" xmlns:tools="http://schemas.android.com/tools" xmlns:app="http://schemas.android.com/apk/res-auto" xmlns:android="http://schemas.android.com/apk/res/android">

<TextView android:layout_height="wrap_content" android:layout_width="wrap_content" app:layout_constraintTop_toTopOf="parent" app:layout_constraintRight_toRightOf="parent" app:layout_constraintLeft_toLeftOf="parent" app:layout_constraintBottom_toBottomOf="parent" android:text="Hello World!"/>

</android.support.constraint.ConstraintLayout>





<?xml version="1.0"?>

-<resources>

<string name="app_name">空教室申请</string>

</resources>






<?xml version="1.0" encoding="UTF-8"?>

-<manifest package="edu.hzuapps.androidlabs.Soft1614080902309" xmlns:android="http://schemas.android.com/apk/res/android">


-<application android:theme="@style/AppTheme" android:supportsRtl="true" android:roundIcon="@mipmap/ic_launcher_round" android:label="@string/app_name" android:icon="@mipmap/ic_launcher" android:allowBackup="true">


-<activity android:name=".Soft1614080902309Activity">


-<intent-filter>

<action android:name="android.intent.action.MAIN"/>

<category android:name="android.intent.category.LAUNCHER"/>

</intent-filter>

</activity>

</application>

</manifest>
## 4. 实验体会
通过这次实验，让我初步明白了Activity的定义以及内容，掌握了创建基本的Activity的方法;
通过本次实验，让我进一步提高了对Android开发的认识，以及对Android Studio的实验。
