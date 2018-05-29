# 1.实验要求  
1）根据选题要求设计界面布局及控件使用；    
2）布局xml及界面控制操作代码提交并截图；  
3）将应用运行结果截图。    
# 2.实验内容  
1）使用其中一种布局方式(本界面所选题目的布局为RelativeLayout) ；    
2）页面有六个按钮，通过控件id获取界面对象，执行相关操作，跳道各自的页面；  
3）实现界面控件的事件处理，例如点击按钮。  
# 3.实验步骤  
1）将默认的Layout改成RelativeLayout<br>
2）创建6个Button组件，排列方式为2行3列，位置在界面的下方<br>
3）创建一个TextView，内容为“网页导航”，字体颜色为粉红色，位置在界面的最上方<br>
4）创建一个SearchView，作搜索框，位置在界面中间<br>
5）创建6个按钮对应的跳转界面 <br>
# 4实验结果  

![image](https://github.com/LinCJ1998/android-labs-2018/blob/master/soft1614080902211/p41.png)
![image](https://github.com/LinCJ1998/android-labs-2018/blob/master/soft1614080902211/p42.png)

# 5.实验体会
1.一开始用默认的Layout,在图片放按钮,然后开机调试之后按钮的位置总是不对,后来试了LinearLayout和RelativeLayout,<br>
发现RelativeLayout最合适.RelativeLayout,各个组件的位置是以其他组件为标准的.<br>
2.真机调试的速度比电脑上的虚拟机快.
