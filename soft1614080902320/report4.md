# 第四次实验

## 一、实验目的
1.根据选题要求设计界面布局及控件使用；<br>
2.布局xml及界面控制操作代码提交并截图；<br>
3.将应用运行结果截图。

## 二、实验内容
1.使用一种布局方式，设计所选题目的界面<br>
2.通过控件ID获取界面对象，执行相关操作<br>
3.实现界面控件的事件处理，例如点击按钮

## 三、实验步骤
1、在base_activity.xml中设置使用FrameLayout布局，设置两个Button和一个TextView，其中“我学会了”按钮表示这个单词不用再出现跳到下一个单词，
“再学一会”按钮表示继续学该单词跳到下一个单词，但是我打出的功能是跳到下一个界面，TextView中是单词<br>
2、在Soft1614080902428Activity和BaseActivity中实现OnClickListener，重写onClick方法，通过findViewById获取相应组件及其值、获取监听Button和TextView
 组件并设置监听<br>
3、编译和运行程序 <br>
4、提交实验内容

## 四、实验截图
* 首页<br>
https://github.com/callmeliqin/android-labs-2018/blob/master/soft1614080902320/Soft1614080902320Activity.png<br>

*第一个<br>
https://github.com/callmeliqin/android-labs-2018/blob/master/soft1614080902320/BaseActivity.PNG<br>

* 第二个<br>
https://github.com/callmeliqin/android-labs-2018/blob/master/soft1614080902320/ThirdActivity.PNG<br>

## 五、实验体会
	通过这次实验，学习掌握安卓的各种布局方式，并在自己的项目中利用FrameLayout布局方式，在实验过程为了实现跳转功能，学习掌握如何调整页面内容。
