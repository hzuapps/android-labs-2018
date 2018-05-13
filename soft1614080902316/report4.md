# 实验四

## 一、实验目标
	根据选题要求设计界面布局及控件使用；
	布局xml及界面控制操作代码提交并截图；

# 二、实验步骤
	1、由于是竖直居中布局，于是选择线性布局，设置orientation为vertical,设置gravity为center。
	对Soft1614080902316MainActivity进行LinearLayout布局：
		 <LinearLayout
        android:layout_width="match_parent"
        android:layout_height="match_parent"
        android:layout_marginEnd="8dp"
        android:gravity="center"
        android:orientation="vertical"
        app:layout_constraintEnd_toEndOf="parent"
        tools:layout_editor_absoluteY="0dp">
		</LinearLayout>
	2、接下来只要将我的textview, EditText 1-6 ,button放上去即可，由于有了线性布局，不需要另外设置位置，位置依赖于父容器。
        为了控件之间有些距离，可以设置android:layout_margin="5dp"，这样看起来不会挤在一起。
	<TextView
            android:id="@+id/textView6"
            android:layout_width="match_parent"
            android:layout_height="wrap_content"
            android:gravity="center"
            android:text="设置6面" />
	    
	 <EditText
            android:id="@+id/editText5"
            android:layout_width="wrap_content"
            android:layout_height="wrap_content"
            android:layout_margin="5dp"
            android:ems="10"
            android:hint="第五面"
            android:inputType="textPersonName"
            tools:layout_editor_absoluteX="100dp"
            tools:layout_editor_absoluteY="384dp" />
	    
	     <Button
            android:id="@+id/sure"
            android:layout_width="156dp"
            android:layout_height="wrap_content"
            android:layout_margin="5dp"
            android:text="确定" />
	    
	3、提交代码并发Pull Request：
		$ git pull
		$ git add 路径/项目/* 
		$ git commit "#4 #1022 第四次实验" 
		$ git push

# 三、实验结果
![](https://github.com/SuperLikeMe/android-labs-2018/blob/master/soft1614080902316/341255456652733806.png)
![](https://github.com/SuperLikeMe/android-labs-2018/blob/master/soft1614080902316/312343764258538641.png)
![](https://github.com/SuperLikeMe/android-labs-2018/blob/master/soft1614080902316/10108605160052730.png)

# 四、实验体会
  由于这次实验，我的第一个页面很明显是竖直居中，所以本实验并没有遇到什么困难，不过还是学习多个页面的性质。
