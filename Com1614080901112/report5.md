#第五次实验报告

##1. 实验目标：android存储编程

阅读实验要求：https://github.com/hzuapps/android-labs-2018/labels/Lab

在电脑上Android Studio编写代码

##3.选择完成实验一

使用Git将代码提交到自己的库中：https://github.com/Demanding/android-labs-2018

2.实验步骤

1.在原来的activity类上进行改动，增加了一个textview显示提示文字，一个edittext用来接收输入的文字，

两个button作为保存和读取功能

2.写java代码，用fileoutputstream类打开一个输出流，接收从edittext传来的消息并写入进去，记得写完要close

3.用fileinputstream打开一个文件流，由于文件是用byte方式读写的，要转化为string

4.对每一个button控件设置监听，由于读写成功并没有任何反应，所以增加一个toast.maketext来显示消息

##4运行并截图结果
![image](https://github.com/shuaidebeirenpi/android-labs-2018/blob/master/Com1614080901112/8.PNG)

![image](https://github.com/shuaidebeirenpi/android-labs-2018/blob/master/Com1614080901112/9.PNG)

##5实验体会

这次实验，让我了解到数据存储有多种方式，有简单的也有复杂的，我采用了比较简单
入门的外部文件存储， 这次实验让我对FileOutputStream、FileInputStream、BufferedWriter
Toast等的使用有了更进一步的了解， 对数据的写入和读取有了更加的理解，
提高了我的编程能力。亲自动手才能更好的学习，这次实验我刚开始 有点不懂，不过在网上
查找了一些有关数据读取的内容并在实验中进行运用，并且成功了
