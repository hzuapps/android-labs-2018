
 # 实验六

 ## 一.实验目的

 掌握Android网络访问方法；
 
 ## 二.实验内容
 
 从网络下载一个文件（图片、MP3、MP4）；

 保存到手机，在应用中使用文件；

 将应用运行结果截图。
 
 ## 三.实验步骤
 
 1.本次实验需通过网络下载东西，因此先修改AndroidManifest.xml中的文件，以获取上网的相关权限；

 2.在SecondActivity.java文件中定义几个功能类，分别实现连接网络获取图片，显示图片，保存链接功能；

 3.定义一个类用以下载图片，new 一个线程Thread进行下载；

 4.下载到的图片，先在getImage类中转换成byte再转化成Bitmap形式显示；

使用加载保存按钮获取的图片并保存；

 5.使用Git将代码提交到自己的库中
 
 6.在GitHub中编写实验报告（report6.md）

 7.在自己的GitHub库上创建和发送Pull Request（注意查看Changed files）.

 ## 四.实验截图

 ![image](https://github.com/Ademzw/android-labs-2018/blob/master/soft1614080902336/%E5%AE%9E%E9%AA%8C%E5%85%AD%E6%88%AA%E5%9B%BE1.png)
 
 ![image](https://github.com/Ademzw/android-labs-2018/blob/master/soft1614080902336/%E5%AE%9E%E9%AA%8C%E5%85%AD%E6%88%AA%E5%9B%BE2.png)

![image](https://github.com/Ademzw/android-labs-2018/blob/master/soft1614080902336/%E5%AE%9E%E9%AA%8C%E5%85%AD%E6%88%AA%E5%9B%BE3.png)

 
 ## 五.实验体会
 
这个实验是从网络下载一个文件（图片、MP3、MP4），保存到手机，在应用中使用文件，将应用运行结果截图。我选择的是在网上下载一张图片，然后保存在手机，在应用中去使用这个文件。这个实验我感觉比较难，刚开始并不知道怎么去做，最后通过问同学和自己在网上百度，最终还是做出来了。通过这几次实验我发现，不管做什么事情，经过自己动手总是能学到很多的东西，经过前几次的实验，我发现我做实验做得越来越好了，但是还有很多没有完善的地方，希望以后能够做得越来越好。