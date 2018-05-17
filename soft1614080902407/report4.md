# 第四次实验

## 1.实验目标
1.根据选题要求设计界面布局及控件使用；

2.布局xml及界面控制操作代码提交并截图；

3.将应用运行结果截图。

## 2.实验内容
1.使用其中一种布局方式，设计所选题目的界面；

2.通过控件ID获取界面对象，执行相关操作：android:id="@+id/my_button"

3.实现界面控件的事件处理，例如点击按钮：
public class MainActivity extends Activity  implements OnClickListener {    
    ......   
    @Override    
    public void onClick(View v) { 
    ......

## 3.实验步骤
1.打开Android Studio；

2.进入res/layout文件夹，打开activity_soft1614080902407_1.xml和activity_second.xml；

3.根据自己的选题选择相关布局以及添加相应的控件，# 1015备忘录 采用LinearLayout布局

4.实现Button的事件监听与处理

5.在手机上运行测试并修改

## 4.实验结果

（1）activity_soft1614080902407_1.xml

<?xml version="1.0" encoding="utf-8"?>
<LinearLayout xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:app="http://schemas.android.com/apk/res-auto"
    xmlns:tools="http://schemas.android.com/tools"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    tools:context=".Soft1614080902407Activity_1"
    android:orientation="vertical">

    <LinearLayout
        android:layout_width="match_parent"
        android:layout_height="500dp">
        <ListView
            android:layout_width="wrap_content"
            android:layout_height="wrap_content"
            android:id="@+id/listview">
        </ListView>
    </LinearLayout>

    <LinearLayout
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:gravity="center_vertical">
        <Button
            android:id="@+id/btn_new"
            android:layout_width="wrap_content"
            android:layout_height="wrap_content"
            android:layout_weight="1"
            android:text="@string/button_new"
            android:textStyle="bold"/>
    </LinearLayout>

</LinearLayout>

（2）activity_second.xml

<?xml version="1.0" encoding="utf-8"?>
<LinearLayout xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:app="http://schemas.android.com/apk/res-auto"
    xmlns:tools="http://schemas.android.com/tools"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    android:orientation="vertical"
    tools:context=".SecondActivity">

    <LinearLayout
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:gravity="center">

        <TextView
            android:layout_width="wrap_content"
            android:layout_height="match_parent"
            android:layout_weight="1"
            android:gravity="center"
            android:text="内容"
            android:textSize="20dp"
            android:textStyle="bold" />

    </LinearLayout>

    <LinearLayout
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:gravity="start">

        <EditText
            android:id="@+id/text1"
            android:layout_width="wrap_content"
            android:layout_height="wrap_content"
            android:ems="20"
            android:hint="@string/hint_content"
            android:inputType="textMultiLine"
            android:minLines="5"
            android:textAppearance="?android:attr/textAppearanceLargeInverse" />
    </LinearLayout>

    <LinearLayout
        android:layout_width="wrap_content"
        android:layout_height="wrap_content">

        <ImageView
            android:layout_width="match_parent"
            android:layout_height="wrap_content"
            android:background="@drawable/example" />
    </LinearLayout>

    <LinearLayout
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:gravity="center_horizontal">

        <Button
            android:layout_width="wrap_content"
            android:layout_height="wrap_content"
            android:layout_weight="1"
            android:text="定时提醒"
            android:textStyle="bold" />

        <Button
            android:layout_width="wrap_content"
            android:layout_height="wrap_content"
            android:layout_weight="1"
            android:text="添加图片"
            android:textStyle="bold" />
    </LinearLayout>

    <LinearLayout
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:gravity="center_vertical">

        <Button
            android:id="@+id/btnJoin"
            android:layout_width="wrap_content"
            android:layout_height="wrap_content"
            android:layout_weight="1"
            android:text="添加备忘录"
            android:textStyle="bold" />

        <Button
            android:id="@+id/gback"
            android:layout_width="50dp"
            android:layout_height="wrap_content"
            android:background="@drawable/ic_arrow_back_black_24dp" />
    </LinearLayout>

</LinearLayout>

（3）Soft1614080902407Activity_1.java

package edu.hzuapps.androidlabs.soft1614080902407;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Soft1614080902407Activity_1 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_soft1614080902407_1);

        final Activity  thisActivity = this;
        Button  btnHome = (Button)findViewById(R.id.btn_new);
        btnHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(thisActivity,SecondActivity.class);
                thisActivity.startActivity(intent);

            }
        });

    }
}

（4）SecondActivity.java

package edu.hzuapps.androidlabs.soft1614080902407;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        final Activity thisActivity = this;
        Button btnBack = (Button)findViewById(R.id.gback);
        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(thisActivity,Soft1614080902407Activity_1.class);
                thisActivity.startActivity(intent);
            }
        });
    }
}

（5）strings.xml

<resources>
<string name="app_name">Soft1614080902407备忘录</string>
<string name="title_activity_second">首页</string>
<string name="button_new">新建备忘录</string>
<string name="hint_content">请在这里输入备忘录的内容</string>
</resources>

实验截图
![image](https://github.com/Qiujialin/android-labs-2018/blob/master/soft1614080902407/%E5%AE%9E%E9%AA%8C%E6%88%AA%E5%9B%BE4-1.jpg?raw=true)

![image](https://github.com/Qiujialin/android-labs-2018/blob/master/soft1614080902407/%E5%AE%9E%E9%AA%8C%E6%88%AA%E5%9B%BE4-2.jpg?raw=true)

## 5.实验体会

本次实验比较复杂，通过上网查询了解并学会使用了一些控件与布局，以及事件的处理，总而言之，本次实验十分有收获。
