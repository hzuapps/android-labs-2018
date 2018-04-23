# 1.实验目的   
      掌握在Android应用中使用图片等资源的方法 
 ## 2.实验要求  
      1. 在界面上显示至少一张图片（按照自己的题目添加）；
      2. 提交res/drawable及图片使用的代码;
      3. 提交res/values, res/layout等其他代码；
      4. 将应用运行结果截图，放到实验报告中；
      5. 点击图片（或按钮）时，打开另一个Activity
 ## 3.实验步骤
     阅读实验要求：https://github.com/hzuapps/android-labs-2018/labels/Lab
     在电脑上Android Studio编写代码，新建Activity
     将需要显示的图片复制粘贴至drawable文件下  
     打开layout目录下相应Activity对应的.xml文件， 添加图片，添加按扭
     在相应Activity.java文件下添加按钮功能，使其在点击时转跳至另外一个Activity页面
     使用markdown软件编写代码
     使用Git将代码提交到自己的库中：https://github.com/cruiji/android-labs-2018
      $ git pull
      $ git add soft1614080902442/*
      $ git commit -m "#3 #985 实验三"
      $ git push
     在自己的GitHub库上创建和发送Pull Request
 ## 4.实验结果
 
     进入虚拟机界面并且找到app
     
 ![image](https://github.com/zzhuangj/android-labs-2018/blob/master/soft1614080902413/1.png)
 
     打开app
     
 ![image](https://github.com/zzhuangj/android-labs-2018/blob/master/soft1614080902413/2.png)
 
     点击按钮后跳转的界面
     
 ![image](https://github.com/zzhuangj/android-labs-2018/blob/master/soft1614080902413/3.png)	
 
 ## 5.实验体会   
     通过本次实验，我学会了在Android studio里面创建按钮，并且学会给按钮设置监听器。还学会组建多个activity，值
     得一提的是，在新建时最好是选择直接新建activity，如果新建的是一个普通java类，还需要自己在manifests文件里注
     册，并且自己创建layout文件，最后还得将activity与layout关联起来，比较麻烦。所以直接创建activity，系统会直
     接全部帮你搞定，相对容易得多。
