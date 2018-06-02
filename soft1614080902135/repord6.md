# 实验目标
掌握Android网络访问方法；


理解XML和JSON表示数据的方法。

# 实验内容
从网络下载一个文件（图片、MP3、MP4）；

保存到手机，在应用中使用文件；


将应用运行结果截图。

# 实验步骤
先创建一个新的Soft1614080902135Activity3负责下载图片

再创建一个名为跳转至下载界面的按钮，并为之加一个监听器启动线程负责下载图片

在xml文件上创建好ImageView,button和输入框

在Activity线程上完善下载代码


# 实验结果
![](https://github.com/WJKAAA/android-labs-2018/blob/master/soft1614080902135/%E5%BE%AE%E4%BF%A1%E5%9B%BE%E7%89%87_20180527163907.png)
![](https://github.com/WJKAAA/android-labs-2018/blob/master/soft1614080902135/%E5%BE%AE%E4%BF%A1%E5%9B%BE%E7%89%87_20180527163915.png)


# 实验体会

实验六跟实验五的难度差不多，都是需要一些可能比较复杂的代码去运行的（对我来说），但是之前做实验五的时候摸索了很久，
终于有点思路，所以做实验六的时候不会很懵，先是启动匿名 Thread，并调用其 start() 启动运行线程，在这个线程中进行图像下载并解码成 Bitmap，
然后通过 Handler 向 UI 线程发送消息以通知下载结果。
这都是在匿名 Thead 中处理的。主线程也就是 UI 线程收到消息之后，会分发给 Handler，在它的 handleMessage 方法中根据消息 id 来处理下载结果，
要么成功要么失败，并相应地更新 UI，传给imageView把图片显示出来。
