# 实验6   
## 一、实验目的  

掌握Android网络访问方法。  

## 二、实验内容  

从百度上寻找一张网址以后缀名为.jpg的图片，把图片的网址放到activity_second_xml文件中。  

## 三、实验步骤
1.AndroidManifest.xml中添加能够写入读出内存空间权限和网络连接权限的代码。  

2.然后在activity_second_xml中添加一个新的按钮和一个TextView，是用来显示图片的,按钮用来监听。 

3.在Second_Activity中写一个线程函数，用来管理下载和显示的图片。  

4.编译运行，然后push。  


## 四.实验截图  
![Image text](https://github.com/Min4396/android-labs-2018/blob/master/soft1614080902434/6.1.png)
![Image text](https://github.com/Min4396/android-labs-2018/blob/master/soft1614080902434/6.2.png)


## 五.实验心得   
这次实验主要从网上找图片，然后放到我写的app中，我点击图片按钮的时候，发现没变化，看了一下，原来没开网，同时遇到了线程的函数，我不会，只能上网找资料以及求助同学了，同时注意的是还要给网络连接权限以及空间权限才能下载图片。

