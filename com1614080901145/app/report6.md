实验六
一.实验目的
 掌握Android网络访问方法；

二.实验内容
(1)从网络下载一个文件（图片、MP3、MP4）
(2)保存到手机，在应用中使用文件
(3)将应用运行结果截图

三.实验步骤
1.修改AndroidManifest.xml获取相关的权限，即在AndroidManifest.xml-中加入网络通讯uses-permission的设置代码段

2.在搜索页面添加一个按钮“下载器”，点击进去时打开新页面，新页面出现文本框，用户可自行输入要下载图片的url;
在新页面的xml处添加Button用于添加监听通过url地址下载图片，并设定一个ImageView用于显示下载好的图片。

3.开启子线程t进行获取url内容，输入输出，下载图片完成

四.实验截图
![screen](https://github.com/TheZhangh/android-labs-2018/blob/master/com1614080901145/%E5%AE%9E%E9%AA%8C6%E7%9A%841.PNG)
![screen](https://github.com/TheZhangh/android-labs-2018/blob/master/com1614080901145/%E5%AE%9E%E9%AA%8C6%E7%9A%842.PNG)
![screen](https://github.com/TheZhangh/android-labs-2018/blob/master/com1614080901145/%E5%AE%9E%E9%AA%8C6%E7%9A%843.PNG)
五.实验体会
	1.在动手前先要在AndroidManifest.xml设置好权限，这个权限的代码在指导书上就有，直接copy过来即可。
        2.实验之后对android网络编程有了一点点的了解，但是，对于线程什么的之间的通信还是模糊不清。正努力学java中。
