# 第四次实验 

## 1. 实验目标  
（1）根据选题要求设计界面布局及控件使用;  
（2）布局XML及界面控制操作代码提交并截图;  
（3）将应用运行结果截图。  

## 2. 实验步骤  
1、阅读实验要求：https：//github.com/hzuapps/android-labs-2018/labels/Lab  
2、根据自己的选题具体情况要求，设计每一个Activity适合的Layout布局方式     
3、在Activity对应的xml文件下添加各种需要的控件（例如Button、Textview等等）       
4、为各个控件设置好属性，排列好位置         
5（例行公事)使用Git将代码、截图、报告提交到自己的库中：https：//github.com/YOUR_NAME/android-labs-2018    
$ git pull  
$ git add 学号目录/*  
$ git commit "#12345678 "  
$ git push  
在自己的GitHub库中创建并发送Pull Requset（合并请求），注意是否只改变自己的文件夹。    
在GitHub中使用Markdown文件编写实验报告。


## 3. 实验结果  

![在Android SDK Manager中选择6.0库](https://raw.githubusercontent.com/DcXuhm/android-labs-2018/master/soft1614080902337/实验4截图/实验四1.png "配置教育网下载代理")  
![在Android SDK Manager中选择6.0库](https://raw.githubusercontent.com/DcXuhm/android-labs-2018/master/soft1614080902337/实验4截图/实验四2.png "配置教育网下载代理")  
![在Android SDK Manager中选择6.0库](https://raw.githubusercontent.com/DcXuhm/android-labs-2018/master/soft1614080902337/实验4截图/实验四3.png "配置教育网下载代理")  
  
 

## 4. 实验体会  

**老师辛苦了！**  
按照实验过程中的操作来讲吧，实验中有以下心得：    
1、我们的Layout布局是在xml文件下实现的，而AS新建一个Activity的时候，它会默认帮我们生成xml文件，并且有着它的默认布局（应该是相对布局），此外还会默认帮你配置很多信息（例如标题栏之类的）。  
  这些默认生成的信息，有一些是不能随意删除的，或则说是需要在其他地方也进行相应修改。  
2、那么如何在默认的xml文件中采用我想要的布局方式呢？  
    我尝试过直接将默认生成的xml文件全部删除，然后自己重新打代码，发现缺少了原代码中默认的那些信息之后，app执行起来会报错。    
    **Layout是可以嵌套使用的** 我们可以在这些Activity的xml代码中书写嵌套的Layout（也可以直接从控件栏里面拖拽出来）  
3、不同的界面的布局方式不一样，需要根据我们的事迹需求来选择布局方式。而针对我的选题：课程表，这是一个典型的“表状结构”，那么TableLayout无疑是最好的选择。  
4、需要认真区分不同Layout的专属属性，不能用混淆了。需要明白子控件属性和自身属性的区别。
