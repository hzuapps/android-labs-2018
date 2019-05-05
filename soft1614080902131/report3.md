# 实验三：Android资源使用编程
## 1.实验目的
掌握在Android应用中使用图片等资源的方法。
 
## 2.实验要求
1.在界面上显示至少一张图片（按照自己的题目添加）；
2.提交res/drawable及图片使用的代码；
3.提交res/values, res/layout等其他代码；
4.将应用运行结果截图，放到实验报告中；
5.点击图片（或按钮）时，打开另一个Activity。
 
## 3.实验步骤（仅供参考）
统一步骤：
https://github.com/hzuapps/android-labs-2018/blob/master/labs-steps.md
Android 在TextView 中显示图片的4种方式：
https://blog.csdn.net/u012724237/article/details/79010741
 
## 4.实验结果
实验截图
https://github.com/MrZengXianSheng/android-labs-2018/blob/master/soft1614080902131/%E5%AE%9E%E9%AA%8C%E4%B8%89%E6%88%AA%E5%9B%BE1.png
https://github.com/MrZengXianSheng/android-labs-2018/blob/master/soft1614080902131/%E5%AE%9E%E9%AA%8C%E4%B8%89%E6%88%AA%E5%9B%BE2.png
 
## 5.实验心得
安卓开发中，可以使用imageView存放作为图片容器展示图片，能通过id为后面添加点击事件作准备。在acitivy逻辑代码中，需要用findViewById与layout的控件绑定。
页面跳转使用Intent类，参数为（当前活动，要跳转活动），最后用startAticity()开启新的活动。
