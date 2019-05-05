# 第六次实验

## 1.实验目标

(1)掌握Android网络访问方法；

(2)理解XML和JSON表示数据的方法。

## 2.实验内容
(1)从网络下载一个文件（图片、MP3、MP4）；

(2)保存到手机，在应用中使用文件；

(3)将应用运行结果截图。

## 3.实验步骤
（1）打开已建好的项目soft1614080902223

（2）在新建httpThread线程类，作用是下载图片并设置显示，新建一个下载Button和EditText输入网址用来触发下载线程；

（3）在httpThread文件中用URL和HttpURLConnection来连接图片所在的网络地址获得图片数据的输入流

（3）在本地创建一个文件并设置一个输出流用来保存图片数据，并用Bitmap形式保存图片并展示在ImageView中

（4）用handler.post来刷新ui；

（5）完成并运行成功

（6）用git上交

## 3.实验结果

![实验报告](https://github.com/soulDeer/android-labs-2018/blob/master/soft1614080902223/shiyan6/tp6_1.png)

![实验报告](https://github.com/soulDeer/android-labs-2018/blob/master/soft1614080902223/shiyan6/tp6_2.png)

![实验报告](https://github.com/soulDeer/android-labs-2018/blob/master/soft1614080902223/shiyan6/tp6_3.png)

## 4.实验体会

这次实验让我学会了网络编程的下载图片用法，并使用java.io提供的方法来进行简单读写数据传输存。
