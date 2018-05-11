# 第三次实验

## 1.实验要求
掌握在Android应用中使用图片等资源的方法。
## 2.实验步骤
（1）在界面上显示至少一张图片（按照自己的题目添加）；
（2）提交res/drawable及图片使用的代码；
（3）提交res/values, res/layout等其他代码；
（4）将应用运行结果截图，放到实验报告中；
（5）点击图片（或按钮）时，打开另一个Activity。
## 3.实验步骤
（1）阅读实验要求：https://github.com/hzuapps/android-labs-2018/labels/Lab
（2）在电脑上Android Studio编写代码
// 代码要可以运行！
（3）使用Git将代码提交到自己的库中：https://github.com/unihaoke/android-labs-2018
$ git pull
$ git add soft1609081602618/*
$ git commit "#3 #1015 备忘录 "
$ git push
（4）在自己的GitHub库上创建和发送Pull Request（注意查看Changed files）
// 是否只修改了自己的文件？
（5）在GitHub中使用Markdown文件编写实验报告（report3.md）
// 保存在自己的文件夹下
## 4.实验结果
![image](https://github.com/unihaoke/android-labs-2018/blob/master/soft1609081602618/1524989985(1).png)
![image](https://github.com/unihaoke/android-labs-2018/blob/master/soft1609081602618/1524990028(1).png)
## 5.实验体会
在使用intent进行传值的时候发现传到另外一个activity的值一直是错的，然后自己debug了好久，最后才发生
原来是自己在另一个activity中生成intent的方法错了，我写到new inten（）了，应该是getintent（）才是正确的
，自己也能够通过这次案例利用Rollviewpager实现轮播图效果。
