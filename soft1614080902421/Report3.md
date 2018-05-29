+# 第三次实验 
 +
 +## 1. 实验目标
 +掌握在Android应用中使用图片等资源的方法；
 +
 +## 2. 实验要求
 +1.  在界面上显示至少一张图片（按照自己的题目添加）；
 +2.  提交res/drawable及图片使用的代码；
 +3.  提交res/values, res/layout等其他代码；
 +4.  将应用运行结果截图，放到实验报告中；
 +5.  点击图片（或按钮）时，打开另一个Activity。
 +
 +## 2. 实验步骤
 +1.  新建一个`Activity`，并改写其内容，实现按钮监听接口，注意要指定跳转(`intent)`的另一个`Activity`的`class`名。还可以在若干个`Activity`之间实现任意跳转。
 +2.  在`res/layout`下编写相应的`xml`文件，把要添加改写的文本或按钮等添加进去。
 +3.  再改写相应的`res/values`下的`string`文件。
 +4.  检查好预览效果，整理好界面的布局以及控件的位置。最好用虚拟机运行即可。
 +5.  使用Git将代码提交到自己的库中：
 +>$ git pull <br>
 +>$ git add 学号目录/* <br>
 +>$ git commit "#12345678 "<br>
 +>$ git push <br>
 +6.  编辑实验报告，然后将项目目录一并pull给老师;
 +
 +
 +
 +## 3. 实验结果
 +app使用步骤：在启动界面点击的查看动态按钮跳转到子页面，在子页面可以点击返回按钮回到启动界面。<br><br>
 +截图1：<br><br>
 +![image](https://github.com/TokisakiRin/android-labs-2018/blob/master/soft1614080902421/experiment3_1.png)
 +
 +截图2：<br><br>
 +![image](https://github.com/TokisakiRin/android-labs-2018/blob/master/soft1614080902421/experiment3_2.png)
 +
 +
 +## 4. 实验体会
 +1.  这次实验难度一般，重点要学会图片资源的引用，设置图片的大小、位置以及要掌握如何点击按钮进入第二个activity。
 +2.  对android studio的使用更近一步，对后续的安卓课程越来越感兴趣。
