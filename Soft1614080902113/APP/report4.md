# 第四次实验 

## 1. 实验目标
根据选题要求设计界面布局及控件使用；<br>
布局xml及界面控制操作代码提交并截图；<br>
将应用运行结果截图。<br>

## 2. 实验要求
1.  使用其中一种布局方式，设计所选题目的界面：LinearLayout、RelativeLayout、TableLayout、AbsoluteLayout、ListView、GridView；
2.  通过控件ID获取界面对象，执行相关操作：<br>`android:id="@+id/my_button"`
3.  实现界面控件的事件处理，例如点击按钮：<br>
    `@Override`<br>
    `public void onClick(View v) {`<br>
    `......`<br>

## 3. 实验步骤
1.  新建一个`CityInfoActivity`，并改写其内容，实现按钮监听接口;
2.  在`res/layout`下编写相应的`activity_cityinfo.xml`文件，这里我将`btn_back点击按钮`放在`RelativeLayout`布局里，实现界面控件的事件处理。
    `activity_cityinfo.xml`的整个布局是用`LinearLayout`布局实现的，所以在这个实验里实现了布局的嵌套。
3.  另外还自定义了滚动条（默认是ListView自带的），在`ListView`标签添加<br>
`android:scrollbarSize="10dp"` <br>
`android:scrollbarThumbVertical="@drawable/minibar"` <br>
`android:scrollbarDefaultDelayBeforeFade="1200"`
4.  检查好预览效果，整理好界面的布局以及控件的位置。最好用虚拟机运行即可。`
5.  使用Git将代码提交到自己的库中：
>$ git pull <br>
>$ git add 学号目录/* <br>
>$ git commit "#12345678 "<br>
>$ git push <br>
6.  编辑实验报告，然后将项目目录一并pull给老师;



## 4. 实验结果
我的截图1：<br><br>
![image](https://github.com/ShampooQ/android-labs-2018/blob/master/Soft1614080902113/APP/pc4.1%20(1).png)

我的截图2：<br><br>
![image](https://github.com/ShampooQ/android-labs-2018/blob/master/Soft1614080902113/APP/pc4.1%20(2).png)


## 5. 实验体会
1.  了解了集成环境的便捷性
2.  尝试了LinearLayout和ListView两种布局方式，感觉良好。
3.  希望在接下来的时间把app的UI和功能完善好。
4.  学会了如何快速布局。
