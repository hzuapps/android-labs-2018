# 1.实验目的   

      掌握在Android应用中使用图片等资源的方法 
      
 ## 2.实验要求  

      1. 在界面上显示至少一张图片（按照自己的题目添加）；
     
      2. 提交res/drawable及图片使用的代码;
      
      3. 提交res/values, res/layout等其他代码；
      
      4. 将应用运行结果截图，放到实验报告中；
      
      5. 点击图片（或按钮）时，打开另一个Activity
      
 ## 3.实验步骤
     （1）我首先将收集好的图片paste到drawble目录中，然后通过在layout中activity对应的xml文件中将图片添加到界面中
     
     （2）创建一个空的activity，并且修改对应的xml文件，给新创建的activity设置界面
     
     （3）给新的activity的layout/drawble中添加图片，并且在xml中将图片添加进界面
     
     （4）我在layout的xml文件中添加了按钮并且给按钮命名，设置大小
     
     （5）在activity的java文件中将layout创建的按钮关联起来，并且对其添加监听器以及实现事件（点击按钮跳转到另一个activity）
     
     （6）确认代码无误后运行虚拟机，打开app，点击按钮跳转，截图
     
     （7）将修改的文件以及用到的图片和截图push到github上
     
     （8）提交pull request
     
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
