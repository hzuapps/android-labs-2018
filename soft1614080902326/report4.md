# 第四次实验

## 实验目标

1.根据选题要求设计界面布局及控件使用

2.布局xml及界面控制操作代码提交并截图

3.将应用运行结果截图

## 实验步骤

1.将Activity中布局更改为线性布局，为了使内容分布合理，使用嵌套布局使得各组件位置排放美观。

2.为添加按钮定义popupWindow，利用onKeyDown监视返回按钮，避免按下返回键退出程序而不是关闭popupWindow。

3.界面优化。

4.运行调试。


## 实验结果

![截图](https://github.com/JWL1ang/android-labs-2018/blob/master/soft1614080902326/experiment%204.png)

## 实验体会

在popupWindow中花费相对较多时间，本原想使用popupMenu，但交互效果相对较差，其次在TextView添加事件出现点击无响应，原因是在一些机型上TextView的 android:clickable默认为false，所以如果要在xml中写TextView的点击事件回调的话，一定要写上android:clickable="true"。
