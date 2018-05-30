# 第六次实验
## 一.实验目的
   1.掌握Android网络访问方法；
   2.理解XML和JSON表示数据的方法。

## 二.实验内容
   1.通过url下载一张照片
   2.将照片显示到ImagView上
   3.实验截图

## 三.实验步骤
   1.通过新建一个新线程，加载图片信息
   2.将加载的图片信息发送到消息队列中
   3.注意点：网络图片通过转化inputStream流，在转化为bitMap，最后将bitMap传给imageView
   4.在消息队列中进行UI修改
   5.运行代码截图并用git上交相关文件。

## 四.实验截图
   ![image](https://github.com/lgc1999/android-labs-2018/blob/master/soft1614080902134/%E5%AE%9E%E9%AA%8C6-1.png)
   ![image](https://github.com/lgc1999/android-labs-2018/blob/master/soft1614080902134/%E5%AE%9E%E9%AA%8C6-2.png)

## 五.实验体会
   这次实验涉及到了网络编程和Java的thread多线程的知识，复习了java中线程的用法；也加深了存储编程的印象，更加熟悉了对文件输入输出流的操作；简单认识了怎样在安卓上获取网络上的资源，并保存在本地空间。