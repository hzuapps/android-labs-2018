# 第三次实验
## 1.实验目的
&emsp;&emsp;掌握在Android应用中使用图片等资源的方法
## 2.实验要求
&emsp;1. 在界面上显示至少一张图片（按照自己的题目添加）； 
 
&emsp;2. 提交res/drawable及图片使用的代码；  

&emsp;3. 提交res/values, res/layout等其他代码；

&emsp;4. 将应用运行结果截图，放到实验报告中；  

&emsp;5. 点击图片（或按钮）时，打开另一个Activity。  
## 3.实验步骤

- 阅读实验要求：https://github.com/hzuapps/android-labs-2018/labels/Lab


- 在电脑上`Android Studio`编写代码  
>新建Activity   
>将需要显示的图片复制粘贴至drawable文件下   
>打开layout目录下相应Activity对应的.xml文件  
>添加图片  
>添加按钮  
>在相应Activity.java文件下添加按钮功能，使其在点击时转跳至另外一个Activity页面  

- 使用`markdown`软件编写代码

- 使用`Git`将代码提交到自己的库中：https://github.com/Strakly/android-labs-2018
>$ git pull  
>$ git add soft1614080902339/*  
>$ git commit -m "#3 #971 Notepad App code update from Strakly"  
>$ git push  

- 在自己的`GitHub`库上创建和发送`Pull Request`

## 4.实验截图
&emsp;   
![](https://raw.githubusercontent.com/Strakly/android-labs-2018/master/soft1614080902339/AndroidScreenshot_1.png "Home Page")
&emsp;   
&emsp;   
![](https://raw.githubusercontent.com/Strakly/android-labs-2018/master/soft1614080902339/AndroidScreenshot_2.png "Edit Page")
&emsp;   
&emsp;   
![](https://raw.githubusercontent.com/Strakly/android-labs-2018/master/soft1614080902339/AndroidScreenshot_3.png "Read Page")

## 5.实验体会
&emsp;&emsp;在本次实验中，对按钮的创建以及Activity跳转功能的配置进行了实践。通过添加对按钮的件监控，实现在按钮被按下时，转跳至指定页面。并且使用控件TextView对图片的添加，并用 `android:background:"@drawable/+图片名"` 将图片设置为背景。