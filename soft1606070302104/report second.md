# 第二次实验报告  

## 1.实验目标
### 实验二：Android组件编程

## 2.实验步骤

### （1）实验要求
(1).根据MVC、MVP设计模式或其他Android App设计模式设计Java类；
(2).先设计表示业务数据的Java类，如表示订单、图书、商品、车辆、音乐、笔记等的类；
(3).再考虑设计一些业务服务类，如网络连接等类；
(4).上传代码时，代码放到自己的学号里面，同时保留Studio的目录结果

### （2）. 在电脑上Android Studio编写代码  

### （3）. 使用Git将代码提交到自己的库中：https://github.com/lili503946540/android-labs-2018   
```  
$ git pull
$ git add 学号目录/*
$ git commit "#2 第二次实验 纸牌24点 "
$ git push
```  

### （4）. 在自己的GitHub库上创建和发送Pull Request（注意查看Changed files）  

### （5）. 在GitHub中使用Markdown文件编写实验报告（report1.md, report2.md）  
```  
// 保存在自己的文件夹下
```  

## 3.实验结果

#### 1.Soft1606070302104Activity.java
```
package edu.hzuapps.androidlabs2018.soft1606070302104;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class Soft1606070302104Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_soft1606070302104);
    }
}
```
#### 2.AndroidManifest.xml
```
<?xml version="1.0" encoding="utf-8"?>
<manifest xmlns:android="http://schemas.android.com/apk/res/android"
    package="edu.hzuapps.androidlabs2018.soft1606070302104">

    <application
        android:allowBackup="true"
        android:icon="@mipmap/ic_launcher"
        android:label="@string/app_name"
        android:roundIcon="@mipmap/ic_launcher_round"
        android:supportsRtl="true"
        android:theme="@style/AppTheme">
        <activity android:name=".Soft1606070302104Activity">
            <intent-filter>
                <action android:name="android.intent.action.MAIN" />

                <category android:name="android.intent.category.LAUNCHER" />
            </intent-filter>
        </activity>
    </application>

</manifest>
```
#### 3.activity_soft1606070302104.xml
```
<?xml version="1.0" encoding="utf-8"?>
<android.support.constraint.ConstraintLayout 
    xmlns:android="http://schemas.android.com/apk/res/android"  
    xmlns:app="http://schemas.android.com/apk/res-auto"
    xmlns:tools="http://schemas.android.com/tools"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    tools:context=".Soft1606070302104Activity">

    <TextView
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:text="Hello World!"
        app:layout_constraintBottom_toBottomOf="parent"
        app:layout_constraintLeft_toLeftOf="parent"
        app:layout_constraintRight_toRightOf="parent"
        app:layout_constraintTop_toTopOf="parent" />

</android.support.constraint.ConstraintLayout>
```
#### 4.strings.xml
```
<resources>
    <string name="app_name">soft1606070302104</string>
</resources>
```
## 4.实验体会
本次实验是通过AndroidStudio来创建自己的选题的项目并且写入代码运行，看似简单，但是没有改好包名和项目名字还有java类的名字就不能正常运行。同时要上传四个文件，必须要找到相应文件的位置，再用git add上传。我选择了一个简单的小游戏--纸牌24点，由于对java不是很熟，我打算下次再写纸牌的功能代码。在实验室中，有许多网络不好或者软件没有安装正确的电脑，在多次尝试之后，我在实验室上传成功了，却发现我仓库里的文件contributor是另外一个人的名字，原因是我在实验室的时候去用其他人的电脑，未登陆自己的账号，所以上传上去就是本机的那个同学的账号。。。于是回去之后，我上传多次覆盖掉还是有它的名字。。但这个是我自己做的。通过这次实验，启发到我的是对于每一步的操作需要更加谨慎，而且拥有安装完好的软件也是很重要，再而就是要学好java。
