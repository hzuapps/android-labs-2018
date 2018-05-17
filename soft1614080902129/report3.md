# 第3次实验
## 1.实验目标
掌握在Android应用中使用图片等资源的方法。

## 2.实验步骤
### 1.在界面上显示至少一张图片；
### 2.提交res/drawable及图片使用的代码；
### 3.提交res/values, res/layout等其他代码；
### 4.将应用运行结果截图，放到实验报告中；
### 5.点击图片（或按钮）时，打开另一个Activity。
## 3.实验结果
![在Android SDK Manager中配置教育网下载代理](android-labs-2018/soft1614080902129/)1Z@9Z33HSC09L[YKGX%C8L.png "配置教育网下载代理")

![在Android SDK Manager中配置教育网下载代理](android-labs-2018/soft1614080902129/A%@%D0$Q9TCOXHCUR7(H5EX.png "配置教育网下载代理")

##Soft1614080902129.java
package soft1614080902129.androidlabs.hzuapps.edu.soft1614080902129;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class Soft1614080902129 extends AppCompatActivity {

    private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_soft1614080902129);

        textView=(TextView)findViewById(R.id.text_view);
        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(Soft1614080902129.this,Soft16140809021292.class);
                startActivity(intent);
            }
        });
    }
}

##Soft16140809021292.java
package soft1614080902129.androidlabs.hzuapps.edu.soft1614080902129;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class Soft16140809021292 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_soft16140809021292);
    }
}

##activity_soft1614080902129.xml
<?xml version="1.0" encoding="utf-8"?>
<android.support.constraint.ConstraintLayout xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:app="http://schemas.android.com/apk/res-auto"
    xmlns:tools="http://schemas.android.com/tools"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    tools:context="soft1614080902129.androidlabs.hzuapps.edu.soft1614080902129.Soft1614080902129">

    <TextView
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:background="@drawable/timg"
        android:id="@+id/text_view"
        app:layout_constraintBottom_toBottomOf="parent"
        app:layout_constraintLeft_toLeftOf="parent"
        app:layout_constraintRight_toRightOf="parent"
        app:layout_constraintTop_toTopOf="parent" />
        
##activity_soft16140809021292.xml
<?xml version="1.0" encoding="utf-8"?>
<RelativeLayout
    xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:app="http://schemas.android.com/apk/res-auto"
    xmlns:tools="http://schemas.android.com/tools"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    tools:context="soft1614080902129.androidlabs.hzuapps.edu.soft1614080902129.Soft16140809021292">

    <TextView
        android:layout_width="match_parent"
        android:layout_height="match_parent"
        android:textSize="22sp"
        android:text="这是第二个页面"
        android:gravity="center"/>

</RelativeLayout>

</android.support.constraint.ConstraintLayout>
## 4.实验体会
在这个实验我们学着自己去将图片显示在虚拟机上，老师耐心讲解，让我们做的时候得心应手，主要没有太多的操作，我觉得需要学习的东西还有很多，上课认真点听老师的可以收获不少。
