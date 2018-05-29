




# 1 实验步骤（采用LinearLayout）
1.首先先通过代码完成软件自身所需要的控件，如Button，设置输入数字的EditText，在strings.xml文件中可以定义按钮的数值0~9，或运算符号（+ ，-， X）
按钮的数值。



2.调节Button和EditText等控件的位置，实际开发中经常采用AndroidAutoLayout等约束控件的库以便适应所有安卓机型，本实验就不采用了，只是简单输入数值定义控件的大小
只是简单定义了paddingBottom等边框margin距离。



3.本实验建立了一个Calculate的interface文件将输入的数值转化为double类型数值，以便进行计算。



4.为按钮添加监听事件“给0-9和.加上数值对应的监听”，“运算符类按钮加上运算法类的监听”，主要调用了.setOnClickListener()方法。


5.最终达到了点击按钮的数字能显示在屏幕上和具有C的数字清空功能。


# 1. 实验结果截图
![screen](https://github.com/779221136/android-labs-2018/blob/master/soft1614080902416/app/%E5%AE%9E%E9%AA%8C4%E6%88%AA%E5%9B%BE.png)


 
