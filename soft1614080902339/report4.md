# 第四次实验
## 1.实验目的
&emsp;1. 根据选题要求设计界面布局及控件使用； 
 
&emsp;2. 布局xml及界面控制操作代码提交并截图；  

&emsp;3. 将应用运行结果截图。
## 2.实验要求
&emsp;1. 使用其中一种布局方式，设计所选题目的界面：  
![](https://user-images.githubusercontent.com/627946/39629467-e47676f2-4fde-11e8-920a-fc1ca6351fdf.png)
 
&emsp;2. 通过控件ID获取界面对象，执行相关操作：  
> android:id="@+id/my_button"

&emsp;3. 实现界面控件的事件处理，例如点击按钮：  
![](https://user-images.githubusercontent.com/627946/39629667-8ba7225a-4fdf-11e8-8a8e-9c7c653eda31.png)

> public class MainActivity extends Activity  implements OnClickListener {    
>     ......   
>     @Override    
>     public void onClick(View v) { 
>     ......  

## 3.实验步骤

- 在电脑上`Android Studio`编写代码  
>打开 `res/layout` 目录下的.xml文件  
>添加 `LinerLayout` 布局所需代码   
>使用代码控制控件至相应位置  
>再在添加多的 `activity` 文件以达到软件功能页面所需   
>在相应的activity文件下添加相应的控件，并设置好页面转跳功能  
>将实验结果进行截图

- 使用 `Git` 将代码提交到自己的库中：https://github.com/Strakly/android-labs-2018
  
>$ git add soft1614080902339/*  
>$ git commit -m "#4 #971 Notepad App code update from Strakly"  
>$ git push  

- 使用 `markdown` 软件编写实验报告，将实验截图加入实验报告中

- 再一次使用 `Git` 将代码提交到自己的库中

- 在自己的`GitHub`库上创建和发送`Pull Request`

## 4.实验截图
&emsp;   
![](https://raw.githubusercontent.com/Strakly/android-labs-2018/master/soft1614080902339/AndroidScreenshot_1.png "Home Page")
&emsp;   
&emsp;   
![](https://raw.githubusercontent.com/Strakly/android-labs-2018/master/soft1614080902339/AndroidScreenshot_2.png "Edit Page")
&emsp;   
&emsp;   
![](https://raw.githubusercontent.com/Strakly/android-labs-2018/master/soft1614080902339/AndroidScreenshot_3.png "Read Page")
## 5.实验体会
&emsp;&emsp;在本次实验中，通过对各个布局的了解，如线性布局或表格布局等。学习适合自己软件使用的页面布局方式，并通过实验，将相应布局的使用方式进行深入的了解、学习以及应用。