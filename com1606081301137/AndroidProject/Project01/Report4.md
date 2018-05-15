# 实验四

## 1.实验目的
1.根据选题要求设计界面布局及控件使用；<br>
2.布局xml及界面控制操作代码提交并截图；<br>
3.将应用运行结果截图。<br>
  
## 2.实验要求
1.使用一种布局方式，设计所选题目的界面；<br>
2.通过控件ID获取界面对象，执行相关操作；<br>
3.实现界面控件的事件处理，例如点击按钮。<br>

## 3.实验步骤
1.创建一个新的类`AlarmView.java`。<br>
2. 使用`LinearLayout`和`ListView`布局，分别在2个Activity进行布局，`TimeView`使用`LinearLayout`布局，`AlarmView`使用`ListView`布局。<br>
3.设置`TextView`节点、`ListView`节点和`Button`节点并调整节点的大小和位置。<br>
4.在`AlarmView`中实现功能和`OnClickListener()`，重写`OnClick`方法，通过`findViewById`获取相应组件及其值、获取监听组件并设置监听。<br>
5.编译、运行程序，在模拟机中进行效果测试：点击`Add Alarm`按钮后添加一个闹钟。<br>
6.使用Git将代码提交到自己的库中：https://github.com/ChaShu618/android-labs-2018<br>
```
$ git pull origin master
$ git add com1606081301137 (git rm 学号目录/*)
$ git commit "#4 第4次实验 #1353"
$ git push
```
7.在自己的GitHub库上创建和发送Pull Request（注意查看Changed files）<br>
8.在GitHub中使用Markdown文件编写实验报告（Report4.md）<br>

## 4.实验截图
![](https://raw.githubusercontent.com/ChaShu618/android-labs-2018/master/com1606081301137/AndroidProject/Project01/E401.png)

## 5.实验体会
通过这次实验使我更加熟悉Git和Android Studio,使用各种控件，使用布局设计界面，创建事件监听器对Button控件进行处理。本次实验难度相对于之前的难度较大，对于布局和界面的考察更加严格，需要进一步的学习才能完成！
