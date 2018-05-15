# 实验目标

##    根据选题要求设计界面布局及控件使用；
##    布局xml及界面控制操作代码提交并截图；
##    将应用运行结果截图。（不要做登录注册！）

# 实验内容

    使用其中一种布局方式，设计所选题目的界面：

![image](https://user-images.githubusercontent.com/627946/39629467-e47676f2-4fde-11e8-920a-fc1ca6351fdf.png)

    通过控件ID获取界面对象，执行相关操作：

android:id="@+id/my_button"

    实现界面控件的事件处理，例如点击按钮：

![image](https://user-images.githubusercontent.com/627946/39629667-8ba7225a-4fdf-11e8-8a8e-9c7c653eda31.png)

public class MainActivity extends Activity  implements OnClickListener {    
    ......   
    @Override    
    public void onClick(View v) { 
    ......

# 实验步骤
### 1、选择linearlayout新建布局文件activity_modle.xml
### 2、参考资料，编写布局代码
### 3、调整按钮大小，美化界面
### 4、编写Com1614080901239中的代码
### 5、测试监听器的功能
# 实验结果
实现了界面
![image](https://github.com/symbatius/android-labs-2018/blob/master/com1614080901239/lab4.png)
实现了点击数字键显示对应数字的功能
![image](https://github.com/symbatius/android-labs-2018/blob/master/com1614080901239/lab4.2.png)
# 实验体会
这次实验开始做界面布局，由于本次要做的app是参考windows自带的计算器，所以界面也参考了windows的计算器界面，
同时上网查找了制作类似界面的代码，根据自己的需求进行了修改。并查找了一些关于界面修改的技巧，总的来说还是
比较简单的。由于选题的按钮比较多，所以定义了比较多的监听器，代码比较长，后面的运算逻辑部分还要继续编写。
