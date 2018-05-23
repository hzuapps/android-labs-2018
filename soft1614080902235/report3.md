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
### 点击App打开第一个Activity，开始界面添加了一个Button
![](https://github.com/LyL111/android-labs-2018/blob/master/soft1614080902235/1.png)
### 点击其中一个按钮，跳到下一个Activity
![](https://github.com/LyL111/android-labs-2018/blob/master/soft1614080902235/2.png)
## 4.实验体会
 这次实验要在自己的APP添加一个图片和监听器，当我把图片和监听器添加进APP里面，运行时，出现了app:mergedebugresources Execute taskAction的错误，
 百度错误，发现是图片的问题，最后再找另一张图片，运行完成。
