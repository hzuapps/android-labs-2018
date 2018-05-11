# 第二次实验 

## 1. 实验步骤
1.在hzuapps中的issues中创建"QQ"，并写上该实现的两个功能  
2.在电脑上Android Studio编写代码，创建一个Activity，以自己的专业+学号作为前缀  
3.使用Git将代码提交到自己的库中：https://github.com/ChenchenJT/android-labs-2018  
具体代码如下：  
$ git pull  
$ git add soft1614080902335/*  
$ git commit "#2 the second lab"  
$ git push  
4.在自己的GitHub库上创建和发送Pull Request  
5.在GitHub中使用Markdown文件编写实验报告  

## 3. 实验结果

###1、AndroidManifest.xml

<?xml version="1.0" encoding="utf-8"?>
<manifest xmlns:android="http://schemas.android.com/apk/res/android"
    package="androidlabs.hzuapps.edu.soft1614080902335">

    <application
        android:allowBackup="true"
        android:icon="@mipmap/ic_launcher"
        android:label="@string/app_name"
        android:roundIcon="@mipmap/ic_launcher_round"
        android:supportsRtl="true"
        android:theme="@style/AppTheme">
        <activity android:name=".Soft1614080902335Activity1">
            <intent-filter>
                <action android:name="android.intent.action.MAIN" />

                <category android:name="android.intent.category.LAUNCHER" />
            </intent-filter>
        </activity>
        <activity android:name=".Soft1614080902335Activity2"></activity>
    </application>

</manifest>

###2.Soft1614080902335Activity1.java

package androidlabs.hzuapps.edu.soft1614080902335;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class Soft1614080902335Activity1 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_soft1614080902335_qq1);
    }
}

###3.Soft1614080902335Activity2.java

package androidlabs.hzuapps.edu.soft1614080902335;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class Soft1614080902335Activity2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_soft1614080902335_qq2);
    }
}

###4.activity_soft1614080902335_qq1.xml

<?xml version="1.0" encoding="utf-8"?>
<android.support.constraint.ConstraintLayout xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:app="http://schemas.android.com/apk/res-auto"
    xmlns:tools="http://schemas.android.com/tools"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    tools:context=".Soft1614080902335Activity1">

    <TextView
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:text="Hello World!"
        app:layout_constraintBottom_toBottomOf="parent"
        app:layout_constraintLeft_toLeftOf="parent"
        app:layout_constraintRight_toRightOf="parent"
        app:layout_constraintTop_toTopOf="parent" />

</android.support.constraint.ConstraintLayout>

###5.activity_soft1614080902335_qq2.xml

<?xml version="1.0" encoding="utf-8"?>
<android.support.constraint.ConstraintLayout xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:app="http://schemas.android.com/apk/res-auto"
    xmlns:tools="http://schemas.android.com/tools"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    tools:context=".Soft1614080902335Activity2">

</android.support.constraint.ConstraintLayout>

###6.strings.xml

<resources>
   <string name="app_name">QQ</string>
</resources>


## 4. 实验体会
1.通过这次实验，让我初步明白了Activity的定义以及内容，掌握了创建基本的Activity的方法;
2.通过本次实验，让我进一步提高了对Android开发的认识，以及对Android Studio的实验。

**加粗**常规
