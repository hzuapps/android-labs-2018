# 第四次实验

 ## 一、实验目的
 1.根据选题要求设计界面布局及控件使用；<br>
 2.布局xml及界面控制操作代码提交并截图；<br>
 3.将应用运行结果截图。
 
 ## 二、实验内容
 1.使用一种布局方式，设计所选题目的界面<br>
 2.通过控件ID获取界面对象，执行相关操作<br>
 3.实现界面控件的事件处理，例如点击按钮
 
 ## 三、实验步骤
1、首先用git工具将代码仓库复制到本地后进行修改。

2、在activity_com1614080901134.xml设计自己的登录界面，如下面的截图，通过com1614080901134Activity.java文件来处理逻辑，
 在Java文件上通过这个代码Button button = (Button) findViewById(R.id.button_1)来给button实例化;

3.通过这个button设置点击事件（监听）实现界面活动跳转，也就是跳到第二活动界面

4.在这两个xml文件都是使用线性布局进行设计（linearLayout）

5.这次实验设计背景图片全部放在drawable-v24文件夹里面

6.最后在使用git工具将自己本地的文件push到自己的代码库

 
 ## 四、实验截图
 *登录界面<br>
 ![image](https://github.com/chenjiahui-xxz/android-labs-2018/blob/master/com1614080901134/3.png)<br>
 *点餐下单界面<br>
 ![image](https://github.com/chenjiahui-xxz/android-labs-2018/blob/master/com1614080901134/4.png)<br>
 

 
 ## 五、实验体会
    在这次实验自己设计了登录界面还有点餐界面，通过两个activity.java设计逻辑处理，实现功能与界面的显示。
    第一次使用自己喜欢的图片用于画界面，即使界面不是那么实用但是还是可以勉强完成老师的要求，在设置布局时，
    只是使用了自己现在了解的线性布局进行页面显示，觉得在之后还需要尝试使用其他布局进行界面的设计。
