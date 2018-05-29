# 第六次实验

## 1.实验目标

(1)掌握Android网络访问方法；

(2)理解XML和JSON表示数据的方法。

## 2.实验内容
(1)从网络下载一个文件（图片、MP3、MP4）；

(2)保存到手机，在应用中使用文件；

(3)将应用运行结果截图。

## 3.实验步骤
（1）打开已建好的项目soft1614080902204

（2）在新建一个下载线程.java文件httpThread.java，用来下载图片，新建一个下载Button用来触发下载线程；

（3）在httpThread文件中用URL和HttpURLConnection来连接图片所在的网络地址获得图片数据的输入流

（3）在本地创建一个文件并设置一个输出流用来保存图片数据，并用Bitmap形式保存图片并展示在ImageView中

（4）用handler.post来刷新ui；

（5）完成并运行成功

（6）用git上交

## 4.实验结果
![实验截图](https://github.com/545072985/android-labs-2018/blob/master/soft1614080902204/sy6/tupian6.1.png)

![实验结果](https://github.com/545072985/android-labs-2018/blob/master/soft1614080902204/sy6/tupian6.2.png) 

## 5.实验体会
这次实验让我学会了简用URL的相关用法来进行网络连接下载图片，并对文件创建和输入输出流有了更深一的理解。
