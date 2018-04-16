# 第二次实验
## 实验目标
在Issues中创建自己的选题：https://github.com/hzuapps/android-labs-2018/issues；

根据自选题目，编写一个或多个Activity（所有均带上学号前缀，放到自己的Java包下）；

将标题设置为自己的学号对应的功能或题目；

根据自己选择的题目实现Activity中导航、调用等功能（选做）

## 实验步骤
阅读实验要求：https://github.com/hzuapps/android-labs-2018/labels/Lab

在电脑上Android Studio编写代码

// 代码要可以运行！
使用Git将代码提交到自己的库中：https://github.com/YOUR_NAME/android-labs-2018

$ git pull

$ git add 学号目录/*

$ git commit "#12345678 "

$ git push

在自己的GitHub库上创建和发送Pull Request（注意查看Changed files）

// 是否只修改了自己的文件？

在GitHub中使用Markdown文件编写实验报告（report1.md, report2.md）

// 保存在自己的文件夹下
## 实验结果
### Soft1614080902125Activity.java

package edu.hzuapps.androidlabs.soft1614080902125;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class Soft1614080902125Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_soft1614080902125);
    }
}

### activity_soft1614080902125.xml

<?xml version="1.0" encoding="utf-8"?>
<android.support.constraint.ConstraintLayout xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:app="http://schemas.android.com/apk/res-auto"
    xmlns:tools="http://schemas.android.com/tools"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    tools:context=".Soft1614080902125Activity">

    <TextView
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:text="假装这是一个音乐播放器!"
        app:layout_constraintBottom_toBottomOf="parent"
        app:layout_constraintLeft_toLeftOf="parent"
        app:layout_constraintRight_toRightOf="parent"
        app:layout_constraintTop_toTopOf="parent" />

</android.support.constraint.ConstraintLayout>

### AndroidManifest.xml

<?xml version="1.0" encoding="utf-8"?>
<manifest xmlns:android="http://schemas.android.com/apk/res/android"
    package="edu.hzuapps.androidlabs.soft1614080902125">

    <application
        android:allowBackup="true"
        android:icon="@mipmap/ic_launcher"
        android:label="@string/app_name"
        android:roundIcon="@mipmap/ic_launcher_round"
        android:supportsRtl="true"
        android:theme="@style/AppTheme">
        <activity android:name=".Soft1614080902125Activity">
            <intent-filter>
                <action android:name="android.intent.action.MAIN" />

                <category android:name="android.intent.category.LAUNCHER" />
            </intent-filter>
        </activity>
    </application>

</manifest>

### strings.xml

<resources>
    <string name="app_name">Soft1614080902125音乐播放器</string>
</resources>


## 实验体会
  对于Android项目文件结构有了初步了解
  
了解组件，布局文件等的内容，知道了如何修改界面标题名字。
