# 第五次实验

## 一、实验内容

 根据选题要求使用文件存储
1.将应用产生的数据保存到文件存储中；
2.说明使用的文件存储方式：内部存储；
3.将运行结果截图。

## 2.实验步骤

（1）阅读实验要求：https://github.com/hzuapps/android-labs-2018/labels/Lab

（2）在电脑上Android Studio编写代码

（3）按Ctrl+shift+A，输入Device File Explorer，Android studio右边出现了Device File Explorer 界面，在里面的data/data/com1614080901244的路径下面找到dat，打开可以看到写的东西都保存在dat里面。

（4）把自己库的东西拷下来，放在D盘的xiamilin 的文件夹中。
    
（5）使用Git将代码提交到自己的库中：https://github.com/xiamilin/android-labs-2018

    $ git add d/xiamilin/com1614080901244/*

    $ git commit -m "#5 第五次实验"

    $ git push

（4）在自己的GitHub库上创建和发送Pull Request（注意查看Changed files）

（5）在GitHub中使用Markdown文件编写实验报告（report5.md）

## 3.实验结果

在secondActivity中，在编辑框中写完信息后，按下分享，页面在跳转至thirdActivity的同时，把写的信息保存至data/data/com1614080901244/dat里面。效果如下：

![image](https://github.com/xiamilin/android-labs-2018/blob/master/com1614080901244/%E5%AE%9E%E9%AA%8C5%E5%9B%BE%E7%89%87.jpg)

## 4.实验体会

本次实验，我用的是内部存储文件。所保存的数据放在data/data/com1614080901244/dat中。这次实验我是参照了之前的做好了的同学来弄的。这次的代码中，对secondActivity.java文件加了个save（）方法，来保存信息。
