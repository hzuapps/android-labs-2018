# 第1次实验报告
## 1.实验目标
（1）在Issues中创建自己的选题：https://github.com/hzuapps/android-labs-2018/issues ；
（2）根据自选题目，编写一个或多个Activity（所有均带上学号前缀，放到自己的Java包下）；
（3）将标题设置为自己的学号+对应的功能或题目；
（4）根据自己选择的题目实现Activity中导航、调用等功能（选做）。
## 2.实验步骤

1. 阅读实验要求：https://github.com/hzuapps/android-labs-2018/labels/Lab   

2. 在电脑上Android Studio编写代码  

```   
// 代码要可以运行！
```   

3. 使用Git将代码提交到自己的库中：https://github.com/YOUR_NAME/android-labs-2018   
```  
$ git pull
$ git add 学号目录/*  (git rm 学号目录/*)
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
```  

## 3.实验结果     
`
<?xml version="1.0" encoding="utf-8"?>
<manifest xmlns:android="http://schemas.android.com/apk/res/android"
    package="com.example.hzu.com1614080901106">

    <application
        android:allowBackup="true"
        android:icon="@mipmap/ic_launcher"
        android:label="@string/app_name"
        android:roundIcon="@mipmap/ic_launcher_round"
        android:supportsRtl="true"
        android:theme="@style/AppTheme">
        <activity android:name=".com1614080901106Activity">
            <intent-filter>
                <action android:name="android.intent.action.MAIN" />

                <category android:name="android.intent.category.LAUNCHER" />
            </intent-filter>
        </activity>
    </application>

</manifest>
`
![image](https://github.com/BoliChen/android-labs-2018/blob/master/com1614080901106/app/src/main/java/com/example/hzu/com1614080901106/com1614080901106Activity.java)
![image](https://github.com/BoliChen/android-labs-2018/blob/master/com1614080901106/app/src/main/res/layout/activity_com1614080901106.xml)
![image](https://github.com/BoliChen/android-labs-2018/blob/master/com1614080901106/app/src/main/res/values/strings.xml)

## 4.实验体会
（1）本次实验了解了如何在Android Studio上创建一个项目，对这个软件有了初步的了解。
（2）这次实验还是比较简单的，毕竟还没开始码代码。

