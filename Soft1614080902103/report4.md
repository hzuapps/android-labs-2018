# 实验目的

1.根据选题要求设计界面布局及控件使用; 
 
2.布局xml及界面控制操作代码提交并截图；
 
3.将应用运行结果截图。（不要做登录注册！）
 
# 实验要求

1.使用一种布局方式，设计所选题目的界面：

2.通过控件ID获取界面对象，执行相关操作：

3.实现界面控件的事件处理，例如点击按钮：

#实验步骤

1.使用Android studio 建立两个class类。

2.修改两个类的XML文件布局

activity_soft1614080902103.xml代码如下

<?xml version="1.0" encoding="utf-8"?>
    <android.support.constraint.ConstraintLayout xmlns:android="http://schemas.android.com/apk/res/android"
        xmlns:app="http://schemas.android.com/apk/res-auto"
        xmlns:tools="http://schemas.android.com/tools"
        android:layout_width="match_parent"
        android:layout_height="match_parent"
        tools:context=".Soft1614080902103Activity">

        <TextView
            android:id="@+id/textView2"
            android:layout_width="wrap_content"
            android:layout_height="wrap_content"
            android:layout_marginBottom="444dp"
            android:text="Hello World!"
            app:layout_constraintBottom_toBottomOf="parent"
            app:layout_constraintLeft_toLeftOf="parent"
            app:layout_constraintRight_toRightOf="parent"
            app:layout_constraintTop_toTopOf="parent"
            android:layout_marginTop="8dp" />


    <Button
        android:id="@+id/button1"
        android:layout_width="wrap_content"
        android:layout_height="49dp"
        android:layout_marginBottom="8dp"
        android:layout_marginEnd="8dp"
        android:layout_marginLeft="8dp"
        android:layout_marginRight="8dp"
        android:layout_marginStart="8dp"
        android:layout_marginTop="8dp"
        android:text="进入播放"
        app:layout_constraintBottom_toBottomOf="parent"
        app:layout_constraintEnd_toEndOf="parent"
        app:layout_constraintStart_toStartOf="parent"
        app:layout_constraintTop_toBottomOf="@+id/textView2"
        app:layout_constraintVertical_bias="0.887" />

    <ImageView
        android:id="@+id/imageView3"
        android:layout_width="390dp"
        android:layout_height="515dp"
        app:layout_constraintStart_toStartOf="parent"
        app:layout_constraintTop_toTopOf="parent"
        app:srcCompat="@drawable/tu1" />

activity_second.xml代码如下

<?xml version="1.0" encoding="utf-8"?>
    <android.support.design.widget.CoordinatorLayout xmlns:android="http://schemas.android.com/apk/res/android"
        xmlns:app="http://schemas.android.com/apk/res-auto"
        xmlns:tools="http://schemas.android.com/tools"
        android:layout_width="match_parent"
        android:layout_height="match_parent"
        tools:context=".SecondActivity">

        <android.support.design.widget.AppBarLayout
            android:layout_width="match_parent"
            android:layout_height="wrap_content"
            android:theme="@style/AppTheme.AppBarOverlay">

            <android.support.v7.widget.Toolbar
                android:id="@+id/toolbar"
                android:layout_width="match_parent"
                android:layout_height="?attr/actionBarSize"
                android:background="?attr/colorPrimary"
                app:popupTheme="@style/AppTheme.PopupOverlay" />

        </android.support.design.widget.AppBarLayout>

    <include
        layout="@layout/content_second"
        android:layout_height="30dp" />

        <android.support.design.widget.FloatingActionButton
            android:id="@+id/fab"
            android:layout_width="wrap_content"
            android:layout_height="wrap_content"
            android:layout_gravity="bottom|end"
            android:layout_margin="@dimen/fab_margin"
            app:srcCompat="@android:drawable/ic_dialog_email" />

</android.support.design.widget.CoordinatorLayout>



# 实验结果
![image](https://raw.githubusercontent.com/ZhengzyX/android-labs-2018/master/Soft1614080902103/%E6%88%AA%E5%9B%BE1.png)
![image](https://raw.githubusercontent.com/ZhengzyX/android-labs-2018/master/Soft1614080902103/%E6%88%AA%E5%9B%BE2.png)
# 实验体会

1.掌握了布局的特点和使用方法，并且熟练运用LinearLayout布局

2.实现歌曲目录
