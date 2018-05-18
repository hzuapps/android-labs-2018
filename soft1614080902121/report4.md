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

Soft1614080902121Activity类代码如下
<pre><code>
package edu.hzuapps.androidlabs.soft1614080902121;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
public class Soft1614080902121Activity extends AppCompatActivity {
    private TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_soft1614080902121);
        textView=(TextView)findViewById(R.id.button2);
        textView.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v){
                Intent intent=new Intent(Soft1614080902121Activity.this,SecondActivity.class);
                startActivity(intent);
            }});
    }

    }
</pre></code>
SecondActivity代码如下
<pre><code>
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class SecondActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
    }
}
</pre></code>
2.修改两个类的XML文件布局

activity_soft1614080902121.xml代码如下

<?xml version="1.0" encoding="utf-8"?>
<RelativeLayout xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:tools="http://schemas.android.com/tools"
    android:id="@+id/activity_soft1614080902121"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    android:paddingBottom="@dimen/activity_vertical_margin"
    android:paddingLeft="@dimen/activity_horizontal_margin"
    android:paddingRight="@dimen/activity_horizontal_margin"
    android:paddingTop="@dimen/activity_vertical_margin"
    tools:context="edu.hzuapps.androidlabs.soft1614080902121.Soft1614080902121Activity">


    <TextView
        android:id="@+id/bj"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:drawableTop="@drawable/qqmusic"
        android:text="QQ音乐!" />


    <LinearLayout
        android:layout_width="match_parent"
        android:layout_height="match_parent"
        tools:layout_editor_absoluteX="0dp"
        tools:layout_editor_absoluteY="0dp">
        <LinearLayout
            android:layout_width="120dp"
            android:layout_height="50dp"
            android:orientation="horizontal"
            tools:layout_editor_absoluteX="0dp"
            tools:layout_editor_absoluteY="0dp"
            android:background="#ffffff">

            <Button
                android:id="@+id/button1"
                android:layout_width="wrap_content"
                android:layout_height="wrap_content"
                android:layout_weight="1"
                android:text="我的" />
        </LinearLayout>
        <LinearLayout
            android:layout_width="120dp"
            android:layout_height="50dp"
            android:orientation="horizontal"
            tools:layout_editor_absoluteX="0dp"
            tools:layout_editor_absoluteY="0dp"
            android:background="#ffffff">

            <Button
                android:id="@+id/button2"
                android:layout_width="wrap_content"
                android:layout_height="wrap_content"
                android:layout_weight="1"
                android:text="音乐库"/>
        </LinearLayout>
        <LinearLayout
            android:layout_width="120dp"
            android:layout_height="50dp"
            android:orientation="horizontal"
            tools:layout_editor_absoluteX="0dp"
            tools:layout_editor_absoluteY="0dp"
            android:background="#ffffff">

            <Button
                android:id="@+id/button3"
                android:layout_width="wrap_content"
                android:layout_height="wrap_content"
                android:layout_weight="1"

                android:text="发现"/>
        </LinearLayout>


    </LinearLayout>
</RelativeLayout>


activity_second.xml代码如下

<?xml version="1.0" encoding="utf-8"?>
<LinearLayout xmlns:android="http://schemas.android.com/apk/res/android"
    android:orientation="vertical" android:layout_width="match_parent"
    android:layout_height="match_parent">
    <Button
        android:id="@+id/button"
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:text="搜索" />
</LinearLayout>

# 实验结果
![image](https://github.com/Zmingcheng/android-labs-2018/blob/master/soft1614080902121/001.png)
![image](https://github.com/Zmingcheng/android-labs-2018/blob/master/soft1614080902121/002.png)
# 实验体会

1.掌握了六种布局的特点和使用方法，并且熟练运用LinearLayout布局

2.实现界面控件的事件处理，例如点击音乐库，跳转到搜索歌曲页面。
