# 第六次实验
## 1.实验目的
&emsp;1. 掌握Android网络访问方法；
&emsp;理解XML和JSON表示数据的方法。

## 2.实验要求
&emsp;1. 从网络下载一个文件（图片、MP3、MP4）；

&emsp;2. 保存到手机，在应用中使用文件；

&emsp;3. 将应用运行结果截图。

## 3.实验步骤

- 在电脑上`Android Studio`编写代码  
>打开 `AndroidMainFest.xml` 为APP添加网络权限   
>在 `layout` 目录下封面的xml文件，添加控件 `ImageView` 和 `Button`   
>在封面的 `Activity` 文件下新增线程下载图片   
>在封面的 `Activity` 文件下为新增的按钮添加监听，使其执行线程中的内容   
>启动虚拟机运行程序，对功能进行测试   
>将实验结果进行截图

- 使用 `Git` 将代码提交到自己的库中：https://github.com/Strakly/android-labs-2018
  
>$ git add soft1614080902339/*  
>$ git commit -m "#6 #971 Notepad App code update from Strakly"  
>$ git push  

- 使用 `markdown` 软件编写实验报告，将实验截图地址加入实验报告中

- 再一次使用 `Git` 将代码提交到自己的库中

- 在自己的 `GitHub` 库中创建和发送`Pull Request`

## 4.实验截图
&emsp;   
![](https://raw.githubusercontent.com/Strakly/android-labs-2018/master/soft1614080902339/AndroidScreenshot_7.png "Downloap Image Test")
  
## 5.实验体会
&emsp;&emsp;通过本次实验，进行了对ImageView的应用、线程的应用、图片的下载、文件的存储以及权限的设置的学习。虽然只是为了对功能进行实现，而完成了一些较为基础的内容。但其间仍然碰到因为图片过大，在下载的过程中，或许由于下载时间过长，导致下载一半便被终止，因而图片获取失败，最终显示空白。   