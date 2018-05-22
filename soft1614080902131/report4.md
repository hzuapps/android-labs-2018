# 实验四：Android界面设计编程

## 1.实验目标
Android界面设计编程 

## 2.实验目标
根据选题要求设计界面布局及控件使用；
布局xml及界面控制操作代码提交并截图；
将应用运行结果截图。（不要做登录注册！）

## 3.实验内容
使用其中一种布局方式，设计所选题目的界面
通过控件ID获取界面对象，执行相关操作
实现界面控件的事件处理，例如点击按钮
 
## 4.实验结果
https://github.com/MrZengXianSheng/android-labs-2018/blob/master/soft1614080902131/%E5%AE%9E%E9%AA%8C%E5%9B%9B%E6%88%AA%E5%9B%BE1.png
https://github.com/MrZengXianSheng/android-labs-2018/blob/master/soft1614080902131/%E5%AE%9E%E9%AA%8C%E5%9B%9B%E6%88%AA%E5%9B%BE2.png
https://github.com/MrZengXianSheng/android-labs-2018/blob/master/soft1614080902131/%E5%AE%9E%E9%AA%8C%E5%9B%9B%E6%88%AA%E5%9B%BE3.png
 
## 5.实验体会
  以前经常用的是线性布局LinearLayout，觉得它简单容易理解，约束条件不用很多，但是随之带来的就是很难实现复杂布局，而且是手机屏幕的适配上有很大的缺陷。现在我经常使用的是相对布局RelativeLayout，虽然在相对布局里面要约束一个控件需要写很多属性，但是这样带来的好出就是能更灵活的控制控件的位置，特别是相对布局能以屏幕的四条边作为基准去放置控件，还是设置到四个方向的偏移量，真的很方便。当然，在本项目中我不仅仅是使用相对布局，挺经常用到的还有线性布局，还有帧布局。掌握越多的布局用法，在布局嵌套的使用下，能更灵活、正确地放置所需要的控件位置。
  以前我只知道只有ImageView能使用图片作为背景，经过这次用法，我发现Button甚至TextView都能设置图片作为背景。还有设置Onclick点击监听事件也是，我以为只有Button能设置点击事件，现在我发现ImageView、TextView等View都可以设置相应的事件监听、只是类型可能会不一样。
