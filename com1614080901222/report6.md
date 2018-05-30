# 实验六
##  一、实验目的
掌握Android网络访问的方法
## 二、实验内容
从网络下载一个文件（图片、MP3、MP4）；
保存到手机，在应用中使用文件；
将运行结果截图。
## 三、实验步骤
### 1、修改AndroidManifest.xml获取相关权限
### 2、在ThirdActivity.java中创建一个saveImageToGallery方法，调用这个方法可以保存图片至本地相册
### 3、下载图片时开辟一个新的线程用来下载图片，这是将要下载的是上个实验的截图
### 4、将下载的图片转换为位图送给ImageView
### 5、运行代码，查看图片是否下载成功，并将运行结果截图
### 6、使用Git将代码提交至自己的库中
## 四、实验截图
![image](https://github.com/imagic97/android-labs-2018/blob/master/com1614080901222/实验6截图1.jpg)
![image](https://github.com/imagic97/android-labs-2018/blob/master/com1614080901222/实验6截图2.png)
![image](https://github.com/imagic97/android-labs-2018/blob/master/com1614080901222/实验6截图3.png)
## 实验体会
在Android中，常用的网络通信技术主要有两种，一种是使用HTTP协议进行网络通信，另一种是用Socket进行网络通信，但是这两种方式都离不开TCP/IP网络协议，所以呢，在Android网络开发中，深入了解TCP/IP可谓是重中之重。
