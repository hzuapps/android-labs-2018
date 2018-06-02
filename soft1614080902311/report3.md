# 第三次实验

## 1.实验目的

掌握在Android应用中使用图片等资源的方法。

## 2.实验要求

（1）在界面上显示至少一张图片（按照自己的题目添加）；

（2）提交res/drawable及图片使用的代码；

（3）提交res/values, res/layout等其他代码；

（4）将应用运行结果截图，放到实验报告中；

（5）点击图片（或按钮）时，打开另一个Activity。

## 3.实验步骤

（1）在activity_main.xml中添加button控件；

（2）在res的layout文件夹下添加一个activity2.xml：

(3)在java下的MainActivity.java为button控件注册：

（4）用匿名内部类OnclickListener给button添加事件：

（5）在MainActivity中定义另一个公有类Activity2

## 4.实验结果
![在Android SDK Manager中选择6.0库](https://github.com/lazytea/android-labs-2018/blob/c6b335ae9a598d518b11f4a1de6aaa36b4e67fd8/soft1614080902311/test3.jpg "配置教育网下载代理")

![在Android SDK Manager中选择6.0库](https://github.com/lazytea/android-labs-2018/blob/c6b335ae9a598d518b11f4a1de6aaa36b4e67fd8/soft1614080902311/test3.2.jpg "配置教育网下载代理")

## 5.实验体会
实验的难点和重点在于button控件事件的添加和按钮点击事件的完成。用匿名内部类来实现按钮点击事件的代码较为简洁，是一种常用的方式。