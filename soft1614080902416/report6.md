




实验六
=
一.实验目的
-
掌握Android网络访问方法；

二.实验内容
-
(1)从网络下载一个文件（图片、MP3、MP4）<br>
(2)保存到手机，在应用中使用文件<br>
(3)将应用运行结果截图<br>

三.实验步骤
-
1.先修改AndroidManifest.xml获取相关的权限<br>
在AndroidManifest.xml-</manifest>中加入实验6指导书中有关网络通讯uses-permission的设置代码段<br>

2.xml部分EditText用于获取图片的url地址<br>
添加Button用于添加监听通过url地址下载图片
ImageView用于显示下载好的图片

3.开启子线程t进行获取url内容，输入输出，下载图片完成

四.实验截图

![screen](https://github.com/779221136/android-labs-2018/blob/master/soft1614080902416/app/61.png)
![screen](https://github.com/779221136/android-labs-2018/blob/master/soft1614080902416/app/62.png)
![screen](https://github.com/779221136/android-labs-2018/blob/master/soft1614080902416/app/63.png)
五.实验体会
  一开始忘记在AndroidManifest.xml中添加有关有关网络通讯uses-permission的网络通讯设置运行程序时程序总是自动闪退，后来添加添加后程序就能正常运行。
  在程序中开启了子线程t，将通讯部分让子线程中运行，提高了程序的性能，降低了代码的耦合性并且在程序中提高了代码的重复利用率，添加子线程t也使代码结构变得更加清晰，
  便于代码的管理和修改。

 
