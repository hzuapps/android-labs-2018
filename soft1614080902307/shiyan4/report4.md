++# 第四次实验
+ +
+ +## 实验目标
+ +
+ +1. 根据选题要求设计界面布局及控件使用；
+ +2. 布局xml及界面控制操作代码提交并截图；
+ +3. 将应用运行结果截图。
+ +
+ +
+ +## 实验内容
+ +
+ +1. 使用其中一种布局方式，设计所选题目的界面：
+ +![](https://user-images.githubusercontent.com/627946/39629467-e47676f2-4fde-11e8-920a-fc1ca6351fdf.png)
+ +2. 通过控件ID获取界面对象，执行相关操作：
+ +
+ +```
+ +android:id="@+id/my_button"
+ +```
+ +3. 实现界面控件的事件处理，例如点击按钮：
+ +![](https://user-images.githubusercontent.com/627946/39629667-8ba7225a-4fdf-11e8-8a8e-9c7c653eda31.png)
+ +
+ +```
+ +public class MainActivity extends Activity  implements OnClickListener {    
+ +    ......   
+ +    @Override    
+ +    public void onClick(View v) { 
+ +    ......
+ + ```
+ +
+ +
+ +## 实验步骤
+ +1先声明xml使用TableLayout布局
+ +2设置两个TableRow
+ +3一个放显示的东西
+ +4另一个放两个按钮
+ +5然后创两个按钮监听器，再进行监听器注册
+ +
+ +## 实验结果
+ +![image](https://github.com/Miles1212/android-labs-2018/blob/master/soft1614080902307/shiyan4/tupian.PNG)
+ +![image](https://github.com/Miles1212/android-labs-2018/blob/master/soft1614080902307/shiyan4/tupian2.PNG)
+ +
+ +## 实验心得
+ +  本次实验难度较以往实验有所增长，在宿舍clone时也是出现了ssl验证的问题，后面经过网上多次搜索才得已解决，不懂的地方需要在网上参考教学视频来学习。
