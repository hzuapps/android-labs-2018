## 实验六

## 一.实验目的

掌握Android网络访问方法；

## 二.实验内容

从网络下载一个文件(图片、mp3等等 这次实验我选择通过网络地址获取网络图片，点击显示图片将图片显示出来) 

参考网址https://blog.csdn.net/u011340932/article/details/38819307

保存到手机 在应用中使用文件

将应用运行结果截图

## 三.实验步骤

1.首先上网搜索相关的资料 这里我选择了该网址作为参考：https://blog.csdn.net/u011340932/article/details/38819307

按照步骤  修改AndroidManifest.xml中的文件，以获取上网的相关权限  以及  activity android:name=".Soft1614080902139SecondActivity

2.在Soft1614080902139SecondActivity.java文件中定义功能类（实现连接网络获取图片，显示图片）以及异步线程下载图片等功能

3.在创建的activity_second_soft1614080902139.xml中创建文本输入框（用于输入图片网址） 两个监听按钮（图片下载 图片显示） 以及利用RelativeLayout布局方式 

4.布局成功以及代码运行无误后 进入虚拟机 

在搜索网站上搜索图片 这里我利用百度搜索 搜索唯美图片 点击一张想要的图 进去弹出的界面后 鼠标右键点击在新页面显示 接着复制显示图片的新页面网址

网址复制到文本框中  点击显示图片 图片成功显示即完成（截图可见）

5.将运行结果截图以及相关文件打包 一用git bash 上交这次的实验

## 四.实验截图
 ![在Android SDK Manager中选择6.0库](https://github.com/1614080902139/android-labs-2018/blob/master/Soft1614080902139/9.png)
 
 ![在Android SDK Manager中选择6.0库](https://github.com/1614080902139/android-labs-2018/blob/master/Soft1614080902139/10.png)
 

## 五.实验心得

 本次实验为网络编程， 完成实验还是一如既往的要细心 懂得查询相关的资料来帮助完成实验，对我来说难度还是挺大的。
