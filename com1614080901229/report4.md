第4次实验 
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
1.打开1614080901229工程
2.在activity_com1614080901229.xml中使用LinearLayout线性布局，在布局里使用Button控件;
3.在第一个Activity中将text为“记一笔”的button设置一个onClickListener，实现跳转到第二个Activity; 
4.在activity_com16140809012292.xml中使用LinearLayout线性布局，在布局里使用Button控件；
5.运行，截图
## 4.实验结果
https://github.com/solidusw/android-labs-2018/blob/master/com1614080901229/p3.png
https://github.com/solidusw/android-labs-2018/blob/master/com1614080901229/p4.png
## 5.实验体会
   本次实验是要求会使用Android的布局和监听器设置，从实验中学习了很多，我只是简单的进行了很基本的设置，还有更多的深入的布局和界面设置需要我进行更深入
   的发掘。
