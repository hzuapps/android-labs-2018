﻿# 第四次实验
 
 ## 1.实验目标

### 1将应用产生的数据保存到文件存储中；
### 2说明使用的文件存储方式：内部 ；
### 3将运行结果截图。
## 2实验步骤
### 1、获取External存储的权限，在manifest文件WRITE_EXTERNAL_STORAGE权限和WRITE_EXTERNAL_STORAGE 权限，在mainfest文件下输入：uses-permission android:name="android.permission.READ_EXTERNAL_STORAGE" 和   uses-permission android:name="android.permission.WRITE_EXTERNAL_STORAGE" 。
### 2、此次实验是用内部的文件储存方式，用了openFileOutput（）方法和openFileInput（）两种方法，分别获取FileOutputStream对象和FileInputStream对象，FileOutputStream保存 数据，FileInputStream读取数据。
## 3、运行结果
 ![截图](https://raw.githubusercontent.com/First-lin/android-labs-2018/master/soft1614080902431/输入信息界面.png)
 ![截图](https://raw.githubusercontent.com/First-lin/android-labs-2018/master/soft1614080902431/保存信息界面.png)
## 4、此次实验我只是用了一个简单的读取和保存信息，对这方面还不是很熟练，所以这次实验做得较为简陋，后面还需自己加强联系，使得令记录在另一个界面生成，然后发送信息的界面还有很多需要完善的地方
