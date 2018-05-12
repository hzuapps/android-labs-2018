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
1.打开com1614080901219工程；

2.打开layout文件夹里的activity_com1614080901219_activity1.xml、activity_com1614080901219_activity2.xml和activity_com1614080901219_activity3.xml,用线性布局和设置按钮、图片，根据调试设置图片大小；

3.打开仿真器进行测试，当按下“获取聚豆”时，会跳转到activity2；当按下“查看个人信息”时，会跳转到activity3（由于是手机截屏，所以下面的导航栏还在，请见谅）；
![image](https://github.com/as6296463/android-labs-2018/blob/master/com1614080901219/d1.png)
![image](https://github.com/as6296463/android-labs-2018/blob/master/com1614080901219/d2.png)
![image](https://github.com/as6296463/android-labs-2018/blob/master/com1614080901219/d3.png)
## 4.实验结果
代码如下：
package edu.hzuapps.androidlabs.com1614080901219;

import android.support.v7.app.AppCompatActivity;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.view.View.OnClickListener;

public class com1614080901219activity1 extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_com1614080901219activity1);

        final Activity thisActivity = this;

        final Button button1 = (Button) findViewById(R.id.button_1);
        final Button button2 = (Button) findViewById(R.id.button_2);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(v.equals(button1)) {
                    Intent intent = new Intent(thisActivity,com1614080901219activity2.class);
                    thisActivity.startActivity(intent);
                }
            }
        });
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(v.equals(button2)) {
                    Intent intent = new Intent(thisActivity,com1614080901219activity3.class);
                    thisActivity.startActivity(intent);
                }
            }
        });

    }
}

package edu.hzuapps.androidlabs.com1614080901219;

import android.support.v7.app.AppCompatActivity;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.view.View.OnClickListener;
import android.widget.ImageButton;

public class com1614080901219activity2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_com1614080901219activity2);
    }
}

package edu.hzuapps.androidlabs.com1614080901219;

import android.support.v7.app.AppCompatActivity;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.view.View.OnClickListener;
import android.widget.ImageButton;

public class com1614080901219activity3 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_com1614080901219activity3);
    }
}

<?xml version="1.0" encoding="utf-8"?>
<android.support.design.widget.CoordinatorLayout xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:app="http://schemas.android.com/apk/res-auto"
    xmlns:tools="http://schemas.android.com/tools"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    tools:context=".com1614080901219activity1">

    <LinearLayout
        android:layout_width="match_parent"
        android:layout_height="match_parent"
        android:orientation="vertical"
        tools:layout_editor_absoluteX="0dp"
        tools:layout_editor_absoluteY="0dp">

    <LinearLayout
        android:layout_width="match_parent"
        android:layout_height="500dp"
        android:background="#ffffff"
        android:orientation="horizontal">

        <ImageView
            android:id="@+id/imageView1"
            android:layout_width="match_parent"
            android:layout_height="500dp"
            android:scaleType="fitXY"
            android:src="@drawable/timg" />
    </LinearLayout>

        <LinearLayout
            android:layout_width="match_parent"
            android:layout_height="50dp"
            android:background="#ffffff"
            android:orientation="horizontal">

            <Button
                android:id="@+id/button_1"
                android:layout_width="wrap_content"
                android:layout_height="wrap_content"
                android:layout_weight="1"
                android:text="获取聚豆" />

            <Button
                android:id="@+id/button_2"
                android:layout_width="wrap_content"
                android:layout_height="wrap_content"
                android:layout_weight="1"
                android:text="查看个人信息" />
        </LinearLayout>
    </LinearLayout>

</android.support.design.widget.CoordinatorLayout>

<?xml version="1.0" encoding="utf-8"?>
<android.support.constraint.ConstraintLayout xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:app="http://schemas.android.com/apk/res-auto"
    xmlns:tools="http://schemas.android.com/tools"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    tools:context=".com1614080901219activity2">

    <LinearLayout
        android:layout_width="match_parent"
        android:layout_height="match_parent"
        android:orientation="vertical"
        tools:layout_editor_absoluteX="0dp"
        tools:layout_editor_absoluteY="0dp">

        <ImageView
            android:id="@+id/imageView2"
            android:layout_width="match_parent"
            android:layout_height="wrap_content"
            android:src="@drawable/p6"
            android:scaleType="fitXY"/>
    </LinearLayout>
</android.support.constraint.ConstraintLayout>

<?xml version="1.0" encoding="utf-8"?>
<android.support.constraint.ConstraintLayout xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:app="http://schemas.android.com/apk/res-auto"
    xmlns:tools="http://schemas.android.com/tools"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    tools:context=".com1614080901219activity3">

    <LinearLayout
        android:layout_width="match_parent"
        android:layout_height="match_parent"
        android:orientation="vertical"
        tools:layout_editor_absoluteX="0dp"
        tools:layout_editor_absoluteY="0dp">

        <ImageView
            android:id="@+id/imageView3"
            android:layout_width="match_parent"
            android:layout_height="wrap_content"
            android:src="@drawable/p7"
            android:scaleType="fitXY"/>
    </LinearLayout>

</android.support.constraint.ConstraintLayout>

![image](https://github.com/as6296463/android-labs-2018/blob/master/com1614080901219/d1.png)
![image](https://github.com/as6296463/android-labs-2018/blob/master/com1614080901219/d2.png)
![image](https://github.com/as6296463/android-labs-2018/blob/master/com1614080901219/d3.png)

## 5.实验体会
  由于对上一次实验做得不太满意，又重新新建了一个工程来完成这次的实验，之前有学过java，发现android的布局和按钮设置等等与java中的GUI有很多相似的地方，只要仔细认真看就能很容易理解如何使用，在调试的过程中发现图片总是无法填满左右两边的空白，百度了一下发现是要使用android:scaleType="fitXY"写在ImageView才能解决，这次实验不断地调试还是非常有趣的，另外更多的布局和界面设置需要我们去深入学习。
