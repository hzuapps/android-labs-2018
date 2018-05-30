、实验目的

（1）根据选题要求设计界面布局及控件使用；
     
（2）布局xml及界面控制操作代码提交并截图；

（3）将应用运行结果截图

二、实验设备与环境

操作系统：Windows 7；开发工具：Java 7、Android Studio 2等。

四、实验要求

1.使用其中一种布局方式，设计所选题目的界面：

2.通过控件ID获取界面对象，执行相关操作：

3.实现界面控件的事件处理，例如点击按钮：

4.实验代码提交均在GitHub.com上完成：https://github.com/hzuapps/android-labs/。

5.实验报告只需要将提交代码的结果截图即可。

6.实验报告直接上传到网址：http://zeng.shaoning.net/android/。

五、实验步骤

①创建新项目 ②选好理想的布局。

③根据需要向xml中添加控件。

④为点击按钮添加触发事件代码 public void jilu(View view) 

{ //实现点击该按钮后跳转到指定界面 Intent intent = new Intent(Soft1614080902401.this, Soft16140809024012.class); 

startActivity(intent); } ⑤界面2实验LinearLayout布局。

六、实验结果截图

![image](https://github.com/gs-666/android-labs-2018/blob/master/soft1614080902438/main04/%E5%AE%9E%E9%AA%8C%E5%9B%9B%E7%BB%93%E6%9E%9C%E6%88%AA%E5%9B%BE/5782716f962ac32a4bad18d6de1b2be.png)

![image](https://github.com/gs-666/android-labs-2018/blob/master/soft1614080902438/main04/%E5%AE%9E%E9%AA%8C%E5%9B%9B%E7%BB%93%E6%9E%9C%E6%88%AA%E5%9B%BE/a883819196aa78d8e2d6d5c6cbae1f8.png)

![image](https://github.com/gs-666/android-labs-2018/blob/master/soft1614080902438/main04/%E5%AE%9E%E9%AA%8C%E5%9B%9B%E7%BB%93%E6%9E%9C%E6%88%AA%E5%9B%BE/b47c97a82e74a3ba978a9e77d17f8a6.png)

![image](https://github.com/gs-666/android-labs-2018/blob/master/soft1614080902438/main04/%E5%AE%9E%E9%AA%8C%E5%9B%9B%E7%BB%93%E6%9E%9C%E6%88%AA%E5%9B%BE/db4596fdb54e79d1cdce0f9a406e531.png)

七、实验心得

这次实验主要实现计算功能，还有事件响应，然后根据选题，实现各种加减乘除,但是代码稍微简便，主要实现功能而已，后面会增加一些颜色背景
主要是实验比较困难的是事件响应。



