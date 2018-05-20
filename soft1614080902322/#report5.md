# 第五次实验 

Android存储编程

## 1. 实验目标

掌握在Android App中存储数据

## 2.实验内容

1.本次根据自身的需要来使用文件存储。
  
2.将应用产生的数据保存到文件存储中。

3.此处使用的是内部存储（Internal Storage）。

## 3. 实验步骤

1.我另外新建了一个xml文件和java文件来操作安卓的存储

2.在网上查询了Context的使用方法：可用两个方法来打开数据文件里的文件IO流 FileInputStream openFileInput(String name);FileOutputStream(String name , int mode),
这两个方法第一个参数 用于指定文件名，第二个参数指定打开文件的模式。

3.在步骤2所查找到的方法使用MODE_APPEND.指定文件名为demo。

3.获取edittext的值。

3.（内部存储）创建存储文件的函数save。

4.调用save函数，传递edittext的值。

## 4. 实验截图

![screen](https://raw.githubusercontent.com/zhongtf/android-labs-2018/master/soft1614080902322/z1.jpg)

![screen](https://raw.githubusercontent.com/zhongtf/android-labs-2018/master/soft1614080902322/z2.jpg)

![screen](https://raw.githubusercontent.com/zhongtf/android-labs-2018/master/soft1614080902322/z3.jpg)

![screen](https://raw.githubusercontent.com/zhongtf/android-labs-2018/master/soft1614080902322/z4.jpg)

## 5.实验体会
内部存储一般用Context来获取和操作。

可用openFileOutput()来读写应用在内部存储空间上的文件。

总结一下文件相关操作，可以得出以下三个特点：

1. 文件操作只需要向函数提供文件名，所以程序自己只需要维护文件名即可。

2. 不用自己去创建文件对象和输入、输出流，提供文件名就可以返回File对象或输入输出流

3. 对于路径操作返回的都是文件对象。