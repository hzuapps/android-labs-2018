# 第六次实验

## 1.实验目标

（1）掌握Android网络访问方法；

（2）理解XML和JSON表示数据的方法。

## 2.实验步骤

实验内容一：

（1）从网络下载一个文件（图片、MP3、MP4）；

（2）保存到手机，在应用中使用文件；

（3）将运行结果截图；

（4）写实验报告。

## 3.实验结果

文件内容保存截图：
![image](https://github.com/Beginner-hww/android-labs-2018/blob/master/soft1613071002123/%E6%96%87%E4%BB%B6%E5%86%85%E5%AE%B9%E4%BF%9D%E5%AD%98.png?raw=true)

联网下载文件前截图：
![image](https://github.com/Beginner-hww/android-labs-2018/blob/master/soft1613071002123/%E8%81%94%E7%BD%91%E4%B8%8B%E8%BD%BD%E5%89%8D.png?raw=true)

联网下载文件后截图：
![image](https://github.com/Beginner-hww/android-labs-2018/blob/master/soft1613071002123/%E8%81%94%E7%BD%91%E4%B8%8B%E8%BD%BD%E5%90%8E.jpg?raw=true)

## 4.实验体会 

因为老师要求不能写登陆注册功能，但是我确实想学习一下它，所以在上次实验五我是通过实现账号密码保存本机中的方法完成老师要求的，为了遵守老师要求的不能写登陆注册
，所以本次实验增加了文件内容保存功能，即用户可以编辑文件，并允许文件内容保存在本机中。

对于实验六我是通过达到从网上下载图片的功能来完成老师的联网要求，其实也很简单，就是创建一个线程，然后先给定下载url，最后通过I/O流来完成资源下载。
