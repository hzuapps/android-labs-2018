# 实验6：	Android网络编程

## 实验目的

1. 掌握Android网络访问方法；

## 实验内容

1. 从网络下载一个文件（图片、MP3、MP4）；

2. 保存到手机，在应用中使用文件；

3. 将应用运行结果截图。

## 实验步骤

1. 打开自己建立的app项目文件soft1614080902145；

2. 修改AndroidManifest.xml获取相关的权限；

3. 修改acticity_Main2.xml以及Main2Activuty.java，以使Main2Activuty中加入一个新的“更换壁纸”按钮，可以跳转到Wallpaper_Activity；

4. 在activity_wallpaper_.xml中设计布局，有一个网络图片地址输入框、一个下载按钮、以及显示图片的空间；

5. 在Wallpaper_Activity.java中输入完成从网络下载图片并保存的代码；

4. 完成并成功运行，提交作业。

## 实验结果

![](https://github.com/haoy1220/android-labs-2018/blob/master/Soft1614080902145/sy6-1.png?raw=true)

![](https://github.com/haoy1220/android-labs-2018/blob/master/Soft1614080902145/sy6-2.png?raw=true)

![](https://github.com/haoy1220/android-labs-2018/blob/master/Soft1614080902145/sy6-3.png?raw=true)

## 实验体会

1. 这次实验很有趣，也是一波三折，开始因为没有修改AndroidManifest.xml获取相关的权限操作，导致app一直闪退，重做了才发现这个问题；

2. 一开始还不懂Android实现下载图片并保存到SD卡中是如何实现的，通过查阅资料了解到从网络上取得的图片，生成Bitmap时有两种方法，一种是先转换为byte[]，再生成bitmap；一种是直接用InputStream生成bitmap，再加上观看了一些大神的代码，总算是会独立完成这个功能了；

3. 课程快要结束了，从老师的课堂上学到了很多，其中最重要的就是自学能力，靠自己慢慢在老师给的大方向中一步步独立完善app，体验真的很不错，感受到了自己的成长，希望以后还有机会跟老师上课。
