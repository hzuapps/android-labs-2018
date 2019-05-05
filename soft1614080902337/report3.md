# 第三次实验 

## 1. 实验目标  
（1）掌握在Android的应用中使用图片等资源的方法。  
（2）在界面上面至少显示一张图片  
（3）实现Activity的转换（利用点击图片或则按钮时的事件实现）  

## 2. 实验步骤  
1、阅读实验要求：https：//github.com/hzuapps/android-labs-2018/labels/Lab    
2、在电脑使用Android Studio编写代码，建立需要使用另外的Activity   
3、在主Activity的xml文件中添加文本、图片、Button等内容。注意图片是保存在res文件下的drawable文件夹中。  
4、在主Activity中加设一个BUTTON变量，添加鼠标单击事件，执行startActivity(intent)  
5（例行公事）、使用Git将代码、截图、报告提交到自己的库中：https：//github.com/YOUR_NAME/android-labs-2018    
$ git pull  
$ git add 学号目录/*  
$ git commit "#12345678 "  
$ git push  
在自己的GitHub库中创建并发送Pull Requset（合并请求），注意是否只改变自己的文件夹。    
在GitHub中使用Markdown文件编写实验报告。


## 3. 实验结果  

![在Android SDK Manager中选择6.0库](https://raw.githubusercontent.com/DcXuhm/android-labs-2018/master/soft1614080902337/实验3截图/项目截图.png "配置教育网下载代理")  
![在Android SDK Manager中选择6.0库](https://raw.githubusercontent.com/DcXuhm/android-labs-2018/master/soft1614080902337/实验3截图/运行截图1.png "配置教育网下载代理")  
![在Android SDK Manager中选择6.0库](https://raw.githubusercontent.com/DcXuhm/android-labs-2018/master/soft1614080902337/实验3截图/运行截图2.png "配置教育网下载代理")  
  
 

## 4. 实验体会  

**老师辛苦了！**  
按照实验过程中的操作来讲吧，实验中有以下心得：    
1、在本次实验中，我们要学会使用AS中的控件资源，这个需要根据我们的需求来定。  
而图片是我们肯定要用到的资源，图片又可以分为背景图片（background）和一般的图片。  
在视图之中插入图片的方法有很多种，最简单的一种就是直接在文本（Textview）附近插入了。  
2、AS中的控件有着非常非常多的属性，例如字体、颜色、边距、背景等等，设计到很多函数，这里我还要好好学习。  
实验之中给文本框和编辑框的位置苦恼了很久，后来才知道margin、padding和gravity等属性的作用。  
3、我们的app肯定是要有几个界面（Activity）的，这里就会设计到Activity的生命周期问题，涉及到OnCreate、OnStart、OnResume、Onpause、OnStop、OnDestory等多个函数，当然我们还不用完全清楚。这些函数会在我们的某些交互之中自动调用。  
本次试验当中，我们通过在主Activity的xml中加入Button作为我们切换Activity的单击按钮，在主Activity的java代码之中添加监听事件，再利用startActivity(intent)的方法试验打开另外一个Activity。  
    
额外的问题：由于自己的电脑是AMD的CPU，在AS3.1当中无法使用它里边配置的虚拟设备，查了很多资料，最后使用Genymotion软件才让代码成功跑起来了。
  
