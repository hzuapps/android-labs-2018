# 第五次实验

## 1.实验目标

 掌握在Android App中存储数据。

## 2.实验步骤

1.根据选题要求使用文件存储

2.item添加监听，获取item的内容，将其保存为字符串msg

3.通过openFileOutput("message.txt",MODE_PRIVATE);

4.创建一个FileOutStream的对象fos，第一个参数是文件名，第二个参数是文件打开方式

5.将msg.getBytesz转换成字节型数据，fos.write()将其写入文件中

6.读取文件时，创建Stringbuilder对象，逐一接收openFileInput对象文件的内容

7.返回其内容字符串类型

8.git提交

## 3.实验结果

![](https://github.com/hzulinzr/android-labs-2018/blob/master/soft1614080902212/png5.1.png)

![](https://github.com/hzulinzr/android-labs-2018/blob/master/soft1614080902212/png5.2.png)

![](https://github.com/hzulinzr/android-labs-2018/blob/master/soft1614080902212/png5.3.png)

## 4.实验体会

做完本次实验，我学会了Android的文件存储，一开始做的时候有些无从下手，在上网查了一些知识后，懂了一些语句的用法，从而成功的做出了实验的内容。