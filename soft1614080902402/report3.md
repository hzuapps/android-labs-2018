# 第三次实验

## 1.实验目标

（1）掌握在Android应用中使用图片等资源的方法。

（2）在界面上显示至少一张图片（按照自己的题目添加）；

（3）提交res/drawable及图片使用的代码；

（4）提交res/values, res/layout等其他代码；

（5）将应用运行结果截图，放到实验报告中；

（6）点击图片（或按钮）时，打开另一个Activity。

## 2.实验步骤

（1）阅读实验要求：https://github.com/hzuapps/android-labs-2018/labels/Lab

（2）在电脑上Android Studio编写代码

（3）使用Git将代码提交到自己的库中：https://github.com/YOUR_NAME/android-labs-2018

   $ git pull

   $ git add 学号目录/*

   $ git commit "#12345678 "

   $ git push

（4）在自己的GitHub库上创建和发送Pull Request（注意查看Changed files）

（5）在GitHub中使用Markdown文件编写实验报告（report1.md, report2.md）

## 3.实验结果

![在Android SDK Manager中选择6.0库](https://github.com/Ghlyh/android-labs-2018/blob/master/soft1614080902402/3.png "配置教育网下载代理")

![在Android SDK Manager中选择6.0库](https://github.com/Ghlyh/android-labs-2018/blob/master/soft1614080902402/4.png "配置教育网下载代理")

## 4.实验体会

通过本次实验学会了贴入图片，在界面上放置图片，不过我自己修改图片大小都是通过画板来修改的，不知道如何用代码修改，一开始在手机上演示时发现图片都是在手机的左上角，原来是自己没有把图片固定所造成的。

把java代码打好后发现点击却没跳到另外一个界面中是因为没有在ActivityManifest中加入第二个界面，一直都坑在这里，我之前还一直以为是代码错了造成的。

通过这次实验学会到用手机上演示自己做的app,也学会图片处理和界面的跳转。