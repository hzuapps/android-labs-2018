# 实验六

## 一.实验目的

掌握Android网络访问方法；

## 二.实验内容

从网络下载一个文件（图片、MP3、MP4）；
保存到手机，在应用中使用文件；
将应用运行结果截图。

## 三.实验步骤

1.本次实验需通过网络下载东西，因此先修改AndroidManifest.xml中的文件，以获取上网的相关权限；
2.在soft1614080902119MainActivity.java文件中定义几个功能类，分别实现连接网络获取图片，显示图片，图片保存功能；
3.定义connectNet类用以下载图片，new 一个线程Thread进行下载；
4.下载到的图片，先在getImage类中转换成byte再转化成Bitmap形式显示；
4.定义savefiles类进行图片保存，开辟一个Thread进行保存；
4.使用加载保存按钮获取URL的图片并保存；
5.使用Git将代码提交到自己的库中：https://github.com/MaZongXin/android-labs-2018

   $ git pull origin master<br>
   $ git add soft1614080902119<br>
   $ git commit "#6 #885 第6次实验"<br>
   $ git push<br>

6.在GitHub中使用Markdown文件编写实验报告（report6.md）.
7.在自己的GitHub库上创建和发送Pull Request（注意查看Changed files）.
## 四.实验截图
![image](https://github.com/MaZongXin/android-labs-2018/blob/master/soft1614080902119/%2361.png)

![image](https://github.com/MaZongXin/android-labs-2018/blob/master/soft1614080902119/%2362.png)

## 五.实验体会

一开始做这个实验，无从下手，只能百度，通过别人的代码学习怎么去连接网络，下载图片，完成了代码的编写。但是因为没注意看实验要求，忘了在AndroidManifest.xml中加申请网络连接的权限，导致无法连接网络，一直失败，直到后来才找到原因，加了权限之后，终于成功完成实验，收获良多！
