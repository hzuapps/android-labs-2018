实验六

一.实验目的

掌握Android网络访问方法；

二.实验内容

(1)从网络下载一个文件（图片、MP3、MP4） (2)保存到手机，在应用中使用文件 (3)将应用运行结果截图

三.实验步骤

1.首先确定实验内容为从网上下载一张图片，之后新建一个activity

2.在AndroidManifest.xml-中加入uses-permission的设置代码段

3.在activity-soft1614080902442main5里，先设置一个edit文本框来输入图片网址，然后设置按钮显示图片来打开从网上下载的图片

4.在java文件中先导入所需的包，设置对显示图片按钮的监听，再运行线程T

5.运行，从网上找图片的网址，复制，之后在文本框上paste该网址，之后点击显示图片，可以看到图片显示了出来

6.把实验结果截图，然后把代码和实验结果截图保存在文件里面，通过gitBash上传,然后在github中查找自己的文件是否上传成功；

7.实验过程

![screen](https://github.com/hwp001/android-labs-2018/blob/master/soft1614080902429/main06/%E5%AE%9E%E9%AA%8C%E8%BF%87%E7%A8%8B%E7%BB%93%E6%9E%9C%E6%88%AA%E5%9B%BE/17237ca96a5b6ced77565ced3156487.png)

8.实验结果

![screen](https://github.com/hwp001/android-labs-2018/blob/master/soft1614080902429/main06/%E5%AE%9E%E9%AA%8C%E8%BF%87%E7%A8%8B%E7%BB%93%E6%9E%9C%E6%88%AA%E5%9B%BE/d137bbad7813e5e486c2bce94a365a0.png)

![screen](https://github.com/hwp001/android-labs-2018/blob/master/soft1614080902429/main06/%E5%AE%9E%E9%AA%8C%E8%BF%87%E7%A8%8B%E7%BB%93%E6%9E%9C%E6%88%AA%E5%9B%BE/138b7cad6815a85b994c39e8b25a246.png)

9.实验心得

主要了解线程的使用，这个花了比较多的时间，这个仅仅下载图片是比较简单的，后面会在这个APP，增加一个下载题目的功能，应该不能弄，然后在文件存储中弄一个答案验证的，然后结合起来，这个智能答选泽题的功能就基本显现出来了，还需要后续的更新，谢谢老师这学期的教导，受益匪浅。
