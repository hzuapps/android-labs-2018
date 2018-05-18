# 第四次实验

## 实验目标

1.根据选题要求设计界面布局及控件使用

2.布局xml及界面控制操作代码提交并截图

3.将应用运行结果截图

## 实验步骤

1.修改res文件下的drawable文件中的图片资源

2.在之前的文件布局基础上修改activity_second.xml，在 activity_second.xml里把布局格式设置为 RelativeLayout相对布局，然后按这个布局添加ImageButton控件

3.修改AndroidManifest.xml文件，修改代码使SecondActivity全屏并且横屏

4.，在SecondActivity.java给ImageButton按钮添加触摸事件

5.在手机模拟器上调试运行

## 实验结果

1. 
  ![截图1](https://github.com/imagic97/android-labs-2018/blob/master/com1614080901222/实验4截图1.png)

2.
![截图2](https://github.com/imagic97/android-labs-2018/blob/master/com1614080901222/实验4截图2.png)

## 实验体会

在这次实验中用到了RelativeLayout和LinearLayout两种布局方式，在RelativeLayout布局中的控件布局总是相对于父容器或者兄弟组件的位置，在Linearayout布局中会将组件一个个排列起来，而且可以通过Android：orientation属性控制组件横向或者纵向排列