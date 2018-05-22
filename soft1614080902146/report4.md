# 第四次实验

## 1. 实验目标

根据选题要求设计界面布局及控件使用；
布局xml及界面控制操作代码提交并截图；
将应用运行结果截图。

## 2. 实验要求

使用其中一种布局方式，设计所选题目的界面：LinearLayout、RelativeLayout、TableLayout、AbsoluteLayout、ListView、GridView；
通过控件ID获取界面对象，执行相关操作：
android:id="@+id/my_button"
实现界面控件的事件处理，例如点击按钮：
@Override
public void onClick(View v) {
......
## 3. 实验步骤

 新建一个`CityInfoActivity`，并改写其内容，实现按钮监听接口;
  2.  在`res/layout`下编写相应的`activity_cityinfo.xml`文件，这里我将`btn_back点击按钮`放在`RelativeLayout`布局里，实现界面控件的事件处理。
      `activity_cityinfo.xml`的整个布局是用`LinearLayout`布局实现的，所以在这个实验里实现了布局的嵌套。
## 4. 实验结果
![image](https://github.com/ZhuHongen/android-labs-2018/blob/master/soft1614080902146/report4.JPG)
## 4. 实验体会

这次实验难度还行，使我体会到了选择好一种布局方式是多么的重要。
尝试了LinearLayout和ListView两种布局方式，感觉良好。
希望在接下来的时间把app的UI和功能完善好。
