# 第五次实验报告

## 1. 实验目标：android存储编程

1. 阅读实验要求：https://github.com/hzuapps/android-labs-2018/labels/Lab   

2. 在电脑上Android Studio编写代码  

3.选择完成实验一

4. 使用Git将代码提交到自己的库中：https://github.com/Demanding/android-labs-2018   

## 2.实验步骤
    1.在原来的activity类上进行改动，增加了一个textview显示提示文字，一个edittext用来接收输入的文字，
    两个button作为保存和读取功能
    2.写java代码，用fileoutputstream类打开一个输出流，接收从edittext传来的消息并写入进去，记得写完要close
    3.用fileinputstream打开一个文件流，由于文件是用byte方式读写的，要转化为string
    4.对每一个button控件设置监听，由于读写成功并没有任何反应，所以增加一个toast.maketext来显示消息
    5.运行并截图结果

## 3. 实验结果

![在Android SDK Manager中选择6.0库](https://github.com/Demanding/android-labs-2018/blob/master/Soft1614080902422/1.png "配置教育网下载代理")
![在Android SDK Manager中选择6.0库](https://github.com/Demanding/android-labs-2018/blob/master/Soft1614080902422/2.png "配置教育网下载代理")
![在Android SDK Manager中选择6.0库](https://github.com/Demanding/android-labs-2018/blob/master/Soft1614080902422/3.png "配置教育网下载代理")

## 4. 实验体会
这次实验我学会了使用文件的输入输出流来对安卓的进行文件存储操作，事实上存储成功后，安卓的data文件夹里会出现相对应的文件，文件名是我的命名的，文件里有输入
的内容，读操作要找到创建的文件名并打开。这一种文件读写操作跟java的思想基本差异不大，关键是要注意一些细节，比如byte和string的转换以及用完后的close
