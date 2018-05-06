#第二次实验
 
 ## 1.实验目标
 
 （1）在Issues中创建自己的选题：https://github.com/hzuapps/android-labs-2018/issues ；
 
 （2）根据自选题目，编写一个或多个Activity（所有均带上学号前缀，放到自己的Java包下）；
 
 （3）将标题设置为自己的学号+对应的功能或题目；
 
 （4）根据自己选择的题目实现Activity中导航、调用等功能（选做）
 
 ## 2.实验步骤
 
    我首先创建了自己的选题皮皮钟，然后按照老师的提示，创建了一个activity，并且修改了layout中的string文件，设置界面的标题。
    接着我就使用Git将代码提交到我的库中：https://github.com/zzhuangj/android-labs-2018，代码如下！最后我登录github网
    将自己修改提交的文件，以及攥写的实验报告提交，通过pull request提交，以待老师检查。
 
 ## 3.实验代码
 
 1.AndroidManifest.xml
 
 <?xml version="1.0" encoding="utf-8"?>
<manifest xmlns:android="http://schemas.android.com/apk/res/android"
    package="edu.hzuapps.androidlabs.soft1614080902413">

    <application
        android:allowBackup="true"
        android:icon="@mipmap/ic_launcher"
        android:label="@string/app_name"
        android:roundIcon="@mipmap/ic_launcher_round"
        android:supportsRtl="true"
        android:theme="@style/AppTheme">
        <activity android:name=".soft1614080902413Activity">
            <intent-filter>
                <action android:name="android.intent.action.MAIN" />

                <category android:name="android.intent.category.LAUNCHER" />
            </intent-filter>
        </activity>
    </application>

</manifest>
 
 2.soft1614080902413Activity.java
 
 package edu.hzuapps.androidlabs.soft1614080902413;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class soft1614080902413Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_soft1614080902413);
    }
}

3.activity_soft1614080902413.xml

<?xml version="1.0" encoding="utf-8"?>
<android.support.constraint.ConstraintLayout xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:app="http://schemas.android.com/apk/res-auto"
    xmlns:tools="http://schemas.android.com/tools"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    tools:context=".soft1614080902413Activity">

    <TextView
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:text="Hello World!"
        app:layout_constraintBottom_toBottomOf="parent"
        app:layout_constraintLeft_toLeftOf="parent"
        app:layout_constraintRight_toRightOf="parent"
        app:layout_constraintTop_toTopOf="parent" />

</android.support.constraint.ConstraintLayout>

4.strings.xml

<resources>
    <string name="app_name">soft1614080902413皮皮钟</string>
</resources>

## 4.实验体会

通过本次实验，熟悉了activity的创建，以及activity对应layout文件的一些知识，比如修改layout李main的string可以修改界面标题。

当然，还能做更多更好看的布局，这些就留待以后再挖掘。

