# 第三次实验 
掌握在Android应用中使用图片等资源的方法。
## 1. 实验目标
1    在界面上显示至少一张图片（按照自己的题目添加）；  
2    提交res/drawable及图片使用的代码；  
3    提交res/values, res/layout等其他代码；  
4    将应用运行结果截图，放到实验报告中；  
5    点击图片（或按钮）时，打开另一个Activity。  
## 2. 实验步骤

1   在XML文件中添加ImatageButton，然后添加属性text、drawable等属性

2   在Activity代码中添加按钮监听事件，设置点击后跳转到下一个Activity

3   创建第二个Activity，通过intent传递信息，实现跳转

## 3. 实验结果
### 点击App打开第一个Activity，开始界面添加了两个Button
![](https://github.com/Ccclk/android-labs-2018/blob/master/soft1614080902214/a.PNG)
### 点击其中一个按钮，跳到下一个Activity
![](https://github.com/Ccclk/android-labs-2018/blob/master/soft1614080902214/b.PNG)
## 4.实验体会
  这次实验主要是让我们尝试在App里添加自己的图片和添加监听器使得按下按钮能够跳转到下一个Activity。花了好长一段时间来调电脑上的SDK，又是百度又是下了好多东西，最终还是全删掉下载一个完整版的才解决问题；还有就是把JPG图片改为png格式需要一个正确的方法，否则运行app总会出现问题。
