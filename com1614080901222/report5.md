# 第五次实验报告
## Android存储编程
## 一、实验步骤
### 1.在Com1614080901222Activity的xml文件里，添加一个Button按钮组件,可以使用这个Button设置游戏的音效，由于需要保存的数据量很小，所以使用ShardPreferences保存数据；
### 2.在Com1614080901222Activity的java文件里编写相应代码，Android studio会导入相应的依赖包；
### 3.在Com1614080901222Activity.java 中创建initData(),这方法用于每次开启应用时初始化数据，这里的初始化是从ShardPreferences中读取数据；
### 4.在Com1614080901222Activity.java 中实现对Button1的OnClick()的点击事件，执行向ShardPreferences保存数据以及读取数据。
### 5.运行程序，验证数据正确性
### 6.使用Git将文件提交到自己的库中。
## 二、实验结果截图
![image](https://github.com/imagic97/android-labs-2018/blob/master/com1614080901222/实验5截图1.png)
![image](https://github.com/imagic97/android-labs-2018/blob/master/com1614080901222/实验5截图2.png)
![image](https://github.com/imagic97/android-labs-2018/blob/master/com1614080901222/实验5截图3.png)
![image](https://github.com/imagic97/android-labs-2018/blob/master/com1614080901222/实验5截图4.png)
## 三、实验体会
在Android平台中实现数据存储有以下5种方式： 使用SharedPreferences存储数据、使用文件存储数据、使用SQLite数据库存储数据、使用ContentProvider存储数据、使用网络在云端存储数据。
在这次实验中用到的是SharedPreferences，其原理是保存基于XML文件存储的key-value键值对数据，通常用来存储一些简单的配置信息。通过Android Studio中DDMS的File Explorer面板展开文件浏览树，SharedPreferences数据总是存储在/data/data/<package name>/shared_prefs目录下。
