# 第六次实验
## 1.实验目标
掌握Android网络访问方法；

## 2.实验步骤
### 1.从网络下载一个文件（图片、MP3、MP4）；
### 2.保存到手机，在应用中使用文件；
### 3.将应用运行结果截图。
##3.实验步骤
### 1.先修改AndroidManifest.xml获取相关的权限
### 2.写一个工具类imgUtils，调用它可以保存图片到本地相册.
### 3.开辟线程下载图片,将图片转换成位图送给imageView,调用requestPermission获取权限，通过后调用saveImage保存图片到本地相册.
### 4.使用下载按钮获取URL的图片，点击保存保存图片到本地
###5.使用Git将代码提交到自己的库中：https://github.com/PickForSth/android-labs-2018

   $ git pull origin master<br>
   $ git add soft1614080902129<br>
   $ git commit "#6 #949 实验6<br>
   $ git push<br>
## 4.实验结果
![在Android SDK Manager中配置教育网下载代理](https://github.com/bujingyu/android-labs-2018/blob/master/soft1614080902129/%E5%AE%9E%E9%AA%8C6-1.png "配置教育网下载代理")

![在Android SDK Manager中配置教育网下载代理](https://github.com/bujingyu/android-labs-2018/blob/master/soft1614080902129/%E5%AE%9E%E9%AA%8C6-2.png "配置教育网下载代理")
## 5.实验体会
通过这次实验使我更加熟悉git和android studio,利用menu和线程获取url网络资源，通过toolbar来实现各个activity的切换。在那么多的实验学会了很多，感觉自己也从一无所知开始了解了安卓。
