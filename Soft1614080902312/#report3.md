#第三次实验
## 1.实验目标

	掌握在Android应用中使用图片等资源的方法。

## 2.实验要求

（1）在界面上显示至少一张图片；
（2）提交res/drawable及图片使用的代码；
（3）提交res/values, res/layout等其他代码；
（4）将应用运行结果截图，放到实验报告中；
（5）点击图片（或按钮）时，打开另一个Activity。

## 3.实验步骤

（1）将要使用的图片保存至res/drawable中；
（2）创建saolei.java
（3）在Soft1614080902312Activity添加代码，使其可以打开saolei；
（4）修改activity_soft1614080902312.xml中的代码，添加图片和相应的文本以及创建一个按钮；

	<TextView
        	android:id="@+id/textview_01"
        	android:layout_width="wrap_content"
        	android:layout_height="wrap_content"
        	android:drawableTop="@drawable/sl"
        	android:paddingLeft="100dp"
        	android:paddingRight="100dp"
        	android:paddingTop="100dp" />

（5）修改saolei.xml中的代码，设计打开的程序的界面；
（6）修改AndroidManifest.xml中的代码，添加如下代码
<activity
                 android:name=".saolei"
                    android:label="saolei"
                    android:theme="@style/AppTheme" />

## 4.实验结果

打开程序：
![](https://raw.githubusercontent.com/KaiMin8X8/android-labs-2018/master/Soft1614080902312/1.png)

点击start game按钮：
![](https://raw.githubusercontent.com/KaiMin8X8/android-labs-2018/master/Soft1614080902312/2.png)

## 5.实验体会

	学会了在界面中添加图片、添加按钮以及布局设计，并使按钮的点击事件为跳转到另个界面；
	在实验过程中遇到了诸多困难外加机器的原因所以使用了长时间去探索完成实验。