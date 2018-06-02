# 实验6报告
## 一、实验步骤
### 1、新建类pictureThread，作为下载图片的线程，也设置图片作为背景在
###    计算器中间的EditText。
### 2、在AndroidManifest中添加允许联网的代码。
### 3、修改build.grade中的app文件，minSdkVersion值改到16，这样才可
###    pictureThread中使用setBackground函数。
## 二、实验结果截图
### 运行程序
![image](https://github.com/symbatius/android-labs-2018/blob/master/com1614080901239/lab6.png)
## 三、实验体会
  这次的实验难度还是比较大的，上网查了不少资料后，才知道要添加联网许可，同时做为下载图片的线程
要写在另一个类里，否则会运行不了，而到了设置为背景这一步，又一直提示错误，又查了一些资料，才知
要更改build.grader里的app的内容。在这个过程中也请教了同学，还是学到了很多与安卓相关的知识的。
