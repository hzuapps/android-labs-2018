# 第三次实验

## 一、实验目的
掌握在Android应用中使用图片等资源的方法。
## 二、实验要求
1、在界面上显示至少一张图片（按照自己的题目添加）；

2、提交res/drawable及图片使用的代码；

3、提交res/values, res/layout等其他代码；

4、将应用运行结果截图，放到实验报告中；

5、点击图片（或按钮）时，打开另一个Activity。
## 三、实验步骤
1、在电脑上Android Studio编写代码；

2、使用Git将代码提交到自己的库中；

git add app/

git commit"#3 #1094 231第三次实验"

git push

3、在自己的GitHub库上创建和发送Pull Request；

4、在GitHub中使用Markdown文件编写实验报告。
## 四、实验结果
![image](https://github.com/zglx/android-labs-2018/blob/master/soft1614080902231/1.png)
![image](https://github.com/zglx/android-labs-2018/blob/master/soft1614080902231/2.png)
## 五、实验体会
通过这次实验，学会了Activity的跳转，在第一个Activity中创建了一个按钮的监听对象，当触发时，调用方法中使用 

Intent intent = new Intent("另一个Activity的完整名称");    

startActivity(intent);    

使其跳转，并且可以在两个Activity的布局文件xml插入图片，按钮。因为还没了解到布局，所以

只能做到这样，实验过程中出现闪退，发现自己是另一个个Activity中写了一个按钮监听对象，

但是没写按钮，导致跳转时出现空值返回情况，所以下次要注意这种情况的发生
