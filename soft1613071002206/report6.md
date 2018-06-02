实验六

一.实验目的

掌握Android网络访问方法；

二.实验内容

从网络下载一个文件（图片、MP3、MP4）；

保存到手机，在应用中使用文件；

将应用运行结果截图。

三.实验步骤

1.本次实验需通过网络下载东西，因此先修改AndroidManifest.xml中的文件，以获取上网的相关权限；

2.在soft1609081602308MainActivity.java文件中定义几个功能类，分别实现连接网络获取图片，显示图片，图片保存功能；

3.定义connectNet类用以下载图片，new 一个线程Thread进行下载；

4.使用加载保存按钮获取URL的图片并保存；
如图为结果
![Alt text](https://github.com/ZZZZmin/android-labs-2018/blob/master/soft1613071002206/%E5%AE%9E%E9%AA%8C6-2.png?raw=true)

5.使用Git将代码提交到自己的库中：https://github.com/Kehp/android-labs-2018

$ git pull origin master<br>
$ git add soft1609081602308<br>
$ git commit "实验6"<br>
$ git push<br>
6.在GitHub中使用Markdown文件编写实验报告（report6.md）.

7.在自己的GitHub库上创建和发送Pull Request
实验体会
这次的实验总体来说并没有特别非常难了，因为有了之前的经验，所以其实做起来稍微有点懂得套路了，然后也问了同学很多，有很多的不懂，打算课下去找点视频来看，加深一下对github的使用。希望我能好好静下来学习。
