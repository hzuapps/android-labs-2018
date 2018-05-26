实验六
=
一.实验目的
-
掌握Android网络访问方法；
  
二.实验内容
-
从网络下载一个文件（图片、MP3、MP4）；<br>

保存到手机，在应用中使用文件；<br>

将应用运行结果截图。<br>

三.实验步骤
-
1.先修改AndroidManifest.xml获取相关的权限：
Android访问网络的权限是android.permission.INTERNET，在application节点之前增加
<uses-permission android:name=”android.permission.INTERNET”></uses-permission>
还有文件控制权限：
<uses-permission android:name="android.permission.MOUNT_UNMOUNT_FILESYSTEMS"/>  
<uses-permission android:name="android.permission.WRITE_EXTERNAL_STORAGE"/>  <br>

2.另外设置一个xml文件和activity来测试Android的网络访问，xml提供了一个文本编辑框来存放网址

3.新建一个线程来下载所提供的网址上的图片

4.点击下载后启动线程下载图片并进行输出

5.使用Git将代码提交到自己的库中：https://github.com/PickForSth/android-labs-2018<br>

       $ git pull origin master<br>
       $ git add soft1614080902322<br>
       $ git commit "#6 #1005"<br>
       $ git push<br>
       
6.在GitHub中使用Markdown文件编写实验报告（report6.md）.<br>

7.在自己的GitHub库上创建和发送Pull Request（注意查看Changed files）.<br>

四.实验截图
-
![screen](https://raw.githubusercontent.com/zhongtf/android-labs-2018/master/soft1614080902322/f1.png)
![screen](https://raw.githubusercontent.com/zhongtf/android-labs-2018/master/soft1614080902322/f2.png)

五.实验体会
-
	此次实验在网上查询了很多知识，让我对安卓的网络访问方法有了更深的了解。

	要想上网和修改文件要先修改AndroidManifest.xml获取相关的权限，开辟线程获取URL进而获取网上的资源文件。
