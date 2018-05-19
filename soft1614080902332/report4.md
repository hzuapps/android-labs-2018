# 第4次实验
## 1.实验目标
1.根据选题要求设计界面布局及控件使用；

2.布局xml及界面控制操作代码提交并截图；

3.将应用运行结果截图。
## 2.实验内容
1.使用其中一种布局方式，设计所选题目的界面

2.通过控件ID获取界面对象，执行相关操作：
android:id="@+id/my_button"

3.实现界面控件的事件处理，例如点击按钮：
public class MainActivity extends Activity  implements OnClickListener {    
    ......   
    @Override    
    public void onClick(View v) { 
    ......
    
## 3.实验步骤
1.打开Android Studio；

2.打开layout文件夹里的soft_1614080902332_activity2.xml和soft_1614080902332_activity3.xml；

3.在soft_1614080902332_activity2.xml里使用RelativeLayout的布局方式，添加ImageButton、ListView和Button等控件；

4.在soft_1614080902332_activity3.xml里使用LinearLayout的布局方式，添加多个TextView和多个EditText控件，添加ImageButton和若干个Button控件；

5.实现部分控件的事件处理；

6.运行测试。
## 4.实验结果
![image](https://github.com/QFJay/android-labs-2018/blob/master/soft1614080902332/002.png)
![image](https://github.com/QFJay/android-labs-2018/blob/master/soft1614080902332/004.png)
![image](https://github.com/QFJay/android-labs-2018/blob/master/soft1614080902332/005.png)
## 5.实验体会
花费很多时间和精力完成了这次实验，收获不小。
