+第二次试验
		+##一.实验目标
		+Android组件编程
		+
		+##二.实验要求
		+###1.在Issues中创建自己的选题：https://github.com/hzuapps/android-labs-2018/issues ；
		+###2.根据自选题目，编写一个或多个Activity（所有均带上学号前缀，放到自己的Java包下）；
		+###3.将标题设置为自己的学号+对应的功能或题目；
		+###4.根据自己选择的题目实现Activity中导航、调用等功能（选做）。
		+
		+##三.实验步骤
		+###1.阅读实验要求：https://github.com/hzuapps/android-labs-2018/labels/Lab
		+###2.在电脑上Android Studio编写代码 
		+###3.使用Git将代码提交到自己的库中：https://github.com/YOUR_NAME/android-labs-2018
		+$ git pull
		+$ git add 学号目录/*
		+$ git commit "#第二次实验 "
		+$ git push
		+###4.在自己的GitHub库上创建和发送Pull Request（注意查看Changed files） 
		+###5.在GitHub中使用Markdown文件编写实验报告（report1.md, report2.md） 
		+
		+##四.实验结果
		+###AndroidManifest.xml代码
	<?xml version="1.0" encoding="UTF-8"?>
<manifest package="edu.hzuapps.androidlabs.soft1614080902444" xmlns:android="http://schemas.android.com/apk/res/android">
<application android:theme="@style/AppTheme" android:supportsRtl="true" android:roundIcon="@mipmap/ic_launcher_round" android:label="@string/app_name" android:icon="@mipmap/ic_launcher" android:allowBackup="true">
<activity android:name=".Soft1614080902444Activity">
<intent-filter>
<action android:name="android.intent.action.MAIN"/>
<category android:name="android.intent.category.LAUNCHER"/>
</intent-filter>
</activity>
</application>
</manifest>
		+###activity_soft1614080902444.xml代码
		<?xml version="1.0" encoding="UTF-8"?>
<android.support.constraint.ConstraintLayout tools:context=".Soft1614080902444Activity" android:layout_height="match_parent" android:layout_width="match_parent" xmlns:tools="http://schemas.android.com/tools" xmlns:app="http://schemas.android.com/apk/res-auto" xmlns:android="http://schemas.android.com/apk/res/android">
<TextView android:layout_height="wrap_content" android:layout_width="wrap_content" app:layout_constraintTop_toTopOf="parent" app:layout_constraintRight_toRightOf="parent" app:layout_constraintLeft_toLeftOf="parent" app:layout_constraintBottom_toBottomOf="parent" android:text="Hello World!"/>
</android.support.constraint.ConstraintLayout>
		+###strings.xml代码
	<?xml version="1.0"?>
<resources>
<string name="app_name">QQ聊天</string>
</resources>
		+##五.实验体会
		+**通过本次实验，了解到安卓Activity的含义，并通过创建自己的项目，使自已感受到了APP的初步开发的体会，谢谢老师让我们对学习android移动应用开发产生更加强烈的兴趣。
