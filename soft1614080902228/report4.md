## 第四次实验

# 实验目的
1.根据选题要求设计界面布局及控件使用；
2.布局xml及界面控制操作代码提交并截图；
3.将应用运行结果截图。

# 实验内容
1.使用一种布局方式，设计所选题目的界面
2.通过控件ID获取界面对象，执行相关操作
3.实现界面控件的事件处理，例如点击按钮


# 实验步骤
1.将实验3里面的activity_main.xml的登陆界面设置为相对布局，截图如下：
   
   https://github.com/hzulwy/android-labs-2018/blob/master/soft1614080902228/%E6%8D%95%E8%8E%B74.GIF
   
 对应代码：
  <RelativeLayout xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:tools="http://schemas.android.com/tools"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    android:gravity="top"
    android:paddingBottom="@dimen/activity_vertical_margin"
    android:paddingLeft="@dimen/activity_horizontal_margin"
    android:paddingRight="@dimen/activity_horizontal_margin"
    android:paddingTop="@dimen/activity_vertical_margin"
    tools:context=".Soft1614080902228Activity" 
     android:background="@drawable/back"
    >

</RelativeLayout>
 
   
 2.将实验3里面的activity_jiemian.xml的棋盘界面设置为线性布局，截图如下：
   
   https://github.com/hzulwy/android-labs-2018/blob/master/soft1614080902228/%E6%8D%95%E8%8E%B73.GIF
   
   对应代码：
    <RelativeLayout xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:tools="http://schemas.android.com/tools"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    android:paddingBottom="@dimen/activity_vertical_margin"
    android:paddingLeft="@dimen/activity_horizontal_margin"
    android:paddingRight="@dimen/activity_horizontal_margin"
    android:paddingTop="@dimen/activity_vertical_margin"
    tools:context=".Jiemian" >
  <Button
        android:id="@+id/button1"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:text="开始"
        android:layout_margin="100dp" 
        />

</RelativeLayout>
    
 3.点击开始界面中的开始按钮就可以进入到棋盘布局
 
 #实验体会
 刚开始不太会怎么导入另一个activity，导致在用intent的时候，使用模拟器模拟时频频出错，后来查阅了一些资料才懂。
 本次实验我初步掌握了一些布局方式，用到了 RelativeLayout 和 LinearLayout 两种布局。也学会如何充满背景的问题。
