### 实验六

## 一.实验目的

掌握Android网络访问方法；

## 二.实验内容

从网络下载一个文件（图片、MP3、MP4）；
保存到手机，在应用中使用文件；
将应用运行结果截图。

## 三.实验步骤

1.先修改AndroidManifest.xml获取相关的权限
2.写一个工具类imgUtils，调用它可以保存图片到本地相册.
3.开辟线程下载图片,将图片转换成位图送给imageView,调用requestPermission获取权限，通过后调用saveImage保存图片到本地相册.
4.使用下载按钮获取URL的图片，点击保存保存图片到本地
5.使用Git将代码提交到自己的库中：https://github.com/PickForSth/android-labs-2018

   $ git pull origin master<br>
   $ git add soft16130905022146<br>
   $ git commit "#5 #1370第6次实验"<br>
   $ git push<br>
6.在GitHub中使用Markdown文件编写实验报告（report6.md）.
7.在自己的GitHub库上创建和发送Pull Request（注意查看Changed files）.

## 四.实验截图

![image](https://github.com/ZhuHongen/android-labs-2018/blob/master/soft1614080902146/report61.JPG)

![image](https://github.com/ZhuHongen/android-labs-2018/blob/master/soft1614080902146/report62.JPG)

![image](https://github.com/ZhuHongen/android-labs-2018/blob/master/soft1614080902146/report63.JPG)
## 五.实验体会

通过这次实验使我更加熟悉git和android studio,为App加一个menu，利用toolbar实现Activity间的切换，开辟线程获取URL进而获取网上的资源文件
