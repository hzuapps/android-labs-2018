# 1.实验目标

（1）掌握Android网络访问方法；

（2）理解XML和JSON表示数据的方法。

# 2.实验内容

（1）从网络下载一个文件（图片、MP3、MP4）；

（2）保存到手机，在应用中使用文件；

（3）将应用运行结果截图。

# 3.实验步骤

（1）打开Android Studio，打开自己的项目soft1614080902230

（2）新建一个HttpThread类，一个用以忘了下载图片的线程

（3）新建一个ThridActivity，用以下载和显示网络图片

（3）在soft1614080902230Activity中新加一个按钮“跳转至课表”，并添加监控器，点击后跳转到新建的ThirdActivity

（4）在ThridActivity添加显示图片的控件ImageView和一个按钮控件，按钮用来触发下载命令，ImageView控件用来显示下载的图片

（5）给“下载课表”按钮添加监控器，监控事件是调用线程HttpThread对象，下载一张图片，并显示在ImageView控件上

（6）截图结果，上交作业

# 4.实验结果

![](https://github.com/laiguoqiang/android-labs-2018/blob/master/soft1614080902230/61.png)

![](https://github.com/laiguoqiang/android-labs-2018/blob/master/soft1614080902230/62.png)

![](https://github.com/laiguoqiang/android-labs-2018/blob/master/soft1614080902230/63.png)

# 5.实验体会

    这是本次安卓课的最后一次实验，也是本人认为最难的一次，因为涉及到网络，这有与手机的下载权限挂勾，跟网络输入流挂钩。一开始找到代码，看懂代码之后，自己模仿着改，发现一点下载按钮就会弹出手机主菜单。经过多次测试最后发现，并非自己的代码有误，而是自己一开始就没给app设置下载权限，所以代码语法虽然正确，却无法执行下载命令。这是一次难忘而又有意义的实验。



















