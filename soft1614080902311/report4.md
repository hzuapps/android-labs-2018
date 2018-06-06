# 第四次实验

## 1.实验目的

1.根据选题要求设计界面布局及控件使用；

2.布局xml及界面控制操作代码提交并截图；

3.将应用运行结果截图。（不要做登录注册！）掌握在Android应用中使用图片等资源的方法。

## 2.实验要求

(1)使用其中一种布局方式，设计所选题目的界面：

(2)通过控件ID获取界面对象，执行相关操作：

(3)实现界面控件的事件处理，例如点击按钮：


## 3.实验步骤

实验三的跳过按钮之后的activity是线性布局，实验三的要求的步骤与之前的实验四是相同，依葫芦画瓢。

（1）在layout 文件添加activity3.xml文件

（2）在activity3.xml文件添加ImageButton

（3）在MainActivity.java添加ImageButton和匿名内部类OnclickListener和公有类

## 4.实验结果
![在Android SDK Manager中选择6.0库](https://github.com/lazytea/android-labs-2018/blob/c6b335ae9a598d518b11f4a1de6aaa36b4e67fd8/soft1614080902311/test3.2.jpg "配置教育网下载代理")

![在Android SDK Manager中选择6.0库](https://github.com/lazytea/android-labs-2018/tree/d901c8b2f2f6d6e093a7599603d29681b1801be0/soft1614080902311/test4.jpg "配置教育网下载代理")

## 5.实验体会
android studio 3.1版本提供的ConstraintLayout布局的方式与以前最流行的线性布局和相对布局相结合的应用方式要好用不少。
新建xml文件改动tag标签发现了许多问题。
最后的解决方案是不改动tag标签而在LeanerLayout中添加ConsrainLayout布局，才完成了activity2的效果。
