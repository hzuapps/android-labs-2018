# 第三次实验

## 1.实验目标

掌握在Android应用中使用图片等资源的方法。

## 2.实验步骤

（1）在界面上显示至少一张图片（按照自己的题目添加）；

（2）提交res/drawable及图片使用的代码；

（3）提交res/values, res/layout等其他代码；

（4）将应用运行结果截图，放到实验报告中；

（5）点击图片（或按钮）时，打开另一个Activity。

## 3.实验步骤

（1）打开Android Studio，新建一个Activity

（2）在第一个Activity中添加一个Button，名为首页的按钮

（3）在res/drawable文件夹中添加一张background.jpg的图片，并在第一个Activity中添加一个TextView空间，并设置该图片为背景图片

（4）在第一个Activity中添加首页Button的监听，并在对应的java文件中设置跳转，使其跳转到第二个Activity

## 4.实验结果

![image](https://github.com/Qiujialin/android-labs-2018/blob/master/soft1614080902407/%E5%AE%9E%E9%AA%8C3%E6%88%AA%E5%9B%BE1.jpg?raw=true)

![image](https://github.com/Qiujialin/android-labs-2018/blob/master/soft1614080902407/%E5%AE%9E%E9%AA%8C3%E6%88%AA%E5%9B%BE2.jpg?raw=true)

## 5.实验体会

通过本次实验学会了添加背景图片，创建一个Button、Activity，以及知道如何实现Activity之间的跳转；背景图片可以直接在里面添加一句android:background来设置背景图片二不会覆盖其他控件，本次实验使用TextView控件添加图片，但是还可以用ImageView控件添加图片。
