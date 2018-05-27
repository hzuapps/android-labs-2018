#第五次实验

##一、实验目的

1、掌握在Android App中存储数据。

##二、实验内容

·根据选题要求使用文件存储

1、将应用产生的数据保存到文件存储中；

2、说明使用的文件存储方式：内部 or 外部

3、将运行结果截图。

##三、实验步骤

1、阅读实验要求：https://github.com/hzuapps/android-labs-2018/labels/Lab；

2、在电脑上Android Studio编写代码
   运行Android studio；
   创建一个新的Activity：Soft1614080902128Activity2.java;
   在activity2_soft1614080902128.xml中添加一个EditText控件（用于编辑存储内容）和两个Button控件（用于写入数据和读取数据）；
   在Soft1614080902128Activity2.java中对两个Button添加监听器和编写写入数据和读取数据的函数（运用FileOutputStream、      FileInputStream、BufferedWriter等来实现）；
   在两个监听器中调用写入数据函数和读取数据函数来完成数据存储和读取的功能。
   
3、使用Git将代码提交到自己的库中：https://github.com/huangzip/android-labs-2018；
   $ git pull
   $ git add soft1614080902128/*  
   $ git commit "#5 #959 第五次实验 "
   $ git push
   
4、在自己的GitHub库上创建和发送Pull Request；

5、在GitHub中使用Markdown文件编写实验报告（report5.md）；
   掌握在Android App中存储数据; 
 
##四、实验结果

![在Android SDK Manager中选择6.0库](https://github.com/huangzip/android-labs-2018/blob/master/soft1614080902128/Act4.png"配置教育网下载代理")

![在Android SDK Manager中选择6.0库](https://github.com/huangzip/android-labs-2018/blob/master/soft1614080902128/Act5.png"配置教育网下载代理")


##五、实验体会

1.掌握了存储数据的方法，包括写入和读取。

2.掌握了edittext的编程使用，更加熟悉控件的使用。
