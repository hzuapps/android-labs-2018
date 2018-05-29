# 第五次实验 

## 1. 实验目标
### 掌握在Android App中存储数据

## 2.实验内容
### 1.将应用产生的数据保存到文件存储中；
### 2.说明使用的文件存储方式：内部 or 外部；
### 3.将运行结果截图。

## 3. 实验步骤
### 1.在主Activity添加按钮监听以跳转到查询界面。
### 2.在ActivityA2中设置openFileOutput()把输入的数据传输到文件中，openFileInput（）读取文件内容，若有输入则输入的内容就会显示在“查询历史”。
### 3.设置好布局界面，含有输入框，查找按钮，查询历史框。
### 4.运行与截图。

## 4. 实验结果

![结果](https://github.com/SurvivorC/android-labs-2018/blob/master/soft1614080902406/Androiddemo5-1.png)
### 输入数据并点击“查找”
![结果](https://github.com/SurvivorC/android-labs-2018/blob/master/soft1614080902406/Androiddemo5-2.png)
![结果](https://github.com/SurvivorC/android-labs-2018/blob/master/soft1614080902406/Androiddemo5-3.png)

## 5. 实验体会

**本次实验使用的文件储存方式是外部储存，要把输入的字符保存到一个文本文件再读取出来，并且要实时刷新显示输入的内容。
使用openFileOutput()时不能包含路径分隔符/，并且若是文件不存在就会自动新建文件，在手机上会保存在/data/data/package name/files文件夹中。**
