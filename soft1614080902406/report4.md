# 第四次实验 

## 1. 实验目标
### 1.根据选题要求设计界面布局及控件使用；
### 2.布局xml及界面控制操作代码提交并截图；
### 3.将应用运行结果截图。

## 2. 实验步骤
### 1.选择LinearLayout布局方式进行布局,先设置一个垂直的全局布局，再在里面设置两个布局，上为分区按钮的布局，下为视频布局，使用weight可以设置布局所占比例大小；
### 2.设置视频布局为水平布局，分为左右两大块，设置两个大块为垂直布局，一个大块中有三个小块垂直排列；
### 3.使用Button控件设置图片及文字，使用layout_margin设置边距让图片不要占用整个小块布局，图片及文字使用layout_gravity设置居中，视频与文字weight比例1：4;
### 4.设置顶端的按钮控件ID button01,button02,button03,button04,按钮weight都设置为1就可以等大小;
### 5.button02设置监听器，实现点击button“动画”按钮跳到ActivityA1。

## 3. 实验结果

![结果](https://github.com/SurvivorC/android-labs-2018/blob/master/soft1614080902406/Androiddemo4.png)
### 点击“动画”后
![结果](https://github.com/SurvivorC/android-labs-2018/blob/master/soft1614080902406/Androiddemo4-1.png)
## 4. 实验体会

**这次实验我学会了使用LinearLayout进行布局，比较麻烦的就是设置垂直和水平布局，要在一个LinearLayout设置垂直，在这个LinearLayout下再设置LinearLayout水平来实现多样化。
使用weight可以按比例设置控件大小，使用的时候要把相关的width或height设置为0dp。
使用Button来设置图片及文字来实现点击图片或文字跳转到视频界面。
textview控件无法设置图片大小，所以就用button，设置图片为背景，再设置一个button来存放文字。**
