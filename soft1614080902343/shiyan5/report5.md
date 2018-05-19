# 实验四

## 一.实验目的

掌握在Android App中存储数据

## 二.实验要求

1.根据选题要求使用文件存储

2.将应用产生的数据保存到文件存储中；

3.说明使用的文件存储方式：内部 or 外部；

4.将运行结果截图。

## 三.实验步骤

1.Context提供了两个方法来打开数据文件里的文件IO流 FileInputStream openFileInput(String name);FileOutputStream(String name , int mode)

2.在layou中的activity_open中对TextView添加了输入功能


3.然后在OpenActivity中对textview中的输入范围实现了文件存储

4.创建存储文件的函数save,这里我使用的是内部存储。

5.最后将实验报告和代码上传到我的账号并且推给老师。

## 四.实验截图


![image](https://github.com/Zhancrui/android-labs-2018/blob/master/soft1614080902343/shiyan5/Soft3433.png)



## 实验体会

本次实验还行，依旧运行不了，因为我的游戏比较简单，对于存储还不是很懂，看了一些视频教学才勉强能够弄出来，不过通过这次实验使我更加熟悉git和android studio,获取edittext和spinner控件的值，将值内部存储到文件，创建事件监听器对button控件进行处理。