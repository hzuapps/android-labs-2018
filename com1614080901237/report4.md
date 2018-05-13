1.实验要求 

（1）根据选题要求设计界面布局及控件使用；    
（2）布局xml及界面控制操作代码提交并截图；  
（3）将应用运行结果截图。 

2.实验内容  

(1).使用其中一种布局方式，设计所选题目的界面：LinearLayout；    
(2).通过控件id获取界面对象，执行相关操作；  
android:id="@+id/my_button"  
(3).实现界面控件的事件处理，例如点击按钮。 

3.实验步骤  

(1).找一个图片作为背景图放在drawable中可供使用；  
(2).在actvity_com1614080901237.xml文件中在<LinearLayout>这个标签下用android:background引入，  
  如：android:background="@drawable/beijing"；    
(3).在另外两个xml文件中也如此操作设置背景图片；  
(4).在添加与查看的页面的xml文件中用<TextView>标签引入“欢迎来到界面的”文字，而写入则是用android:text="。。。"的格式引入。

4.实验结果  

![image](https://github.com/Cai-ZT/android-labs-2018/blob/master/com1614080901237/shiyan4-1.png)
![image](https://github.com/Cai-ZT/android-labs-2018/blob/master/com1614080901237/shiyan4-2.png)
![image](https://github.com/Cai-ZT/android-labs-2018/blob/master/com1614080901237/shiyan4-3.png)

5.实验体会  

由于上次实验，我已经有使用了插件——按钮，这次实验加上了背景图，在调整各个插件的位置，让页面看起来比较圆滑些。
你所需要的插件都是嵌套进去的，在进行各个属性的操作就可以了。
