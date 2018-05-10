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

3.设计界面布局，添加控件；

4.实现部分控件的事件处理；

5.运行测试。
## 4.实验结果

package edu.hzuapps.androidlabs.Soft1614080902332;

import android.support.v7.app.AppCompatActivity;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.view.View.OnClickListener;
import android.widget.ImageButton;

public class Soft1614080902332Activity2 extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.soft_1614080902332_activity2);




    }
}


package edu.hzuapps.androidlabs.Soft1614080902332;

import android.support.v7.app.AppCompatActivity;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.view.View.OnClickListener;
import android.widget.ImageButton;

public class Soft1614080902332Activity3 extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.soft_1614080902332_activity3);

    }
}


<?xml version="1.0" encoding="utf-8"?>
<android.support.constraint.ConstraintLayout xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:app="http://schemas.android.com/apk/res-auto"
    xmlns:tools="http://schemas.android.com/tools"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    tools:context=".Soft1614080902332Activity2">

    <LinearLayout
        android:layout_width="match_parent"
        android:layout_height="match_parent"
        android:orientation="vertical"
        tools:layout_editor_absoluteX="0dp"
        tools:layout_editor_absoluteY="0dp">

        <ImageButton
            android:id="@+id/imageButton2"
            android:layout_width="match_parent"
            android:layout_height="wrap_content"
            app:srcCompat="@android:drawable/ic_search_category_default" />

        <ListView
            android:layout_width="match_parent"
            android:layout_height="390dp" />

        <LinearLayout
            android:layout_width="match_parent"
            android:layout_height="match_parent"
            android:orientation="horizontal">

            <Button
                android:id="@+id/button"
                android:layout_width="wrap_content"
                android:layout_height="wrap_content"
                android:layout_weight="1"
                android:text="返回首页" />

        </LinearLayout>
    </LinearLayout>
</android.support.constraint.ConstraintLayout>


<?xml version="1.0" encoding="utf-8"?>
<android.support.constraint.ConstraintLayout xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:app="http://schemas.android.com/apk/res-auto"
    xmlns:tools="http://schemas.android.com/tools"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    tools:context=".Soft1614080902332Activity3">

    <LinearLayout
        android:layout_width="match_parent"
        android:layout_height="match_parent"
        android:orientation="vertical"
        tools:layout_editor_absoluteX="0dp"
        tools:layout_editor_absoluteY="0dp">

        <LinearLayout
            android:layout_width="match_parent"
            android:layout_height="100dp"
            android:orientation="horizontal"
            tools:layout_editor_absoluteX="0dp"
            tools:layout_editor_absoluteY="0dp"
            android:background="#ffffff">

            <TextView
                android:id="@+id/textView"
                android:layout_width="wrap_content"
                android:layout_height="100dp"
                android:layout_weight="1"
                android:text="图片"
                android:gravity="center" />

            <ImageButton
                android:id="@+id/imageButton"
                android:layout_width="wrap_content"
                android:layout_height="wrap_content"
                android:layout_weight="1"
                app:srcCompat="@drawable/picture2"
                android:background="#ffffff"/>
        </LinearLayout>

        <LinearLayout
            android:layout_width="match_parent"
            android:layout_height="50dp"
            android:orientation="horizontal"
            android:background="#ffffff">

            <TextView
                android:id="@+id/textView2"
                android:layout_width="wrap_content"
                android:layout_height="50dp"
                android:layout_weight="1"
                android:text="失物简介"
                android:gravity="center" />

            <EditText
                android:id="@+id/editText3"
                android:layout_width="wrap_content"
                android:layout_height="wrap_content"
                android:layout_weight="1"
                android:ems="10" />
        </LinearLayout>

        <LinearLayout
            android:layout_width="match_parent"
            android:layout_height="50dp"
            android:orientation="horizontal"
            android:background="#ffffff">

            <TextView
                android:id="@+id/textView3"
                android:layout_width="wrap_content"
                android:layout_height="50dp"
                android:layout_weight="1"
                android:text="拾到时间"
                android:gravity="center" />

            <EditText
                android:id="@+id/editText4"
                android:layout_width="wrap_content"
                android:layout_height="wrap_content"
                android:layout_weight="1"
                android:ems="10" />
        </LinearLayout>

        <LinearLayout
            android:layout_width="match_parent"
            android:layout_height="50dp"
            android:orientation="horizontal"
            android:background="#ffffff">

            <TextView
                android:id="@+id/textView4"
                android:layout_width="wrap_content"
                android:layout_height="50dp"
                android:layout_weight="1"
                android:text="拾到地点"
                android:gravity="center"/>

            <EditText
                android:id="@+id/editText5"
                android:layout_width="wrap_content"
                android:layout_height="wrap_content"
                android:layout_weight="1"
                android:ems="10" />
        </LinearLayout>

        <LinearLayout
            android:layout_width="match_parent"
            android:layout_height="50dp"
            android:orientation="horizontal"
            android:background="#ffffff">

            <TextView
                android:id="@+id/textView5"
                android:layout_width="wrap_content"
                android:layout_height="50dp"
                android:layout_weight="1"
                android:text="联系方式"
                android:gravity="center"/>

            <EditText
                android:id="@+id/editText"
                android:layout_width="wrap_content"
                android:layout_height="wrap_content"
                android:layout_weight="1"
                android:ems="10" />
        </LinearLayout>

        <Space
            android:layout_width="match_parent"
            android:layout_height="50dp" />

        <LinearLayout
            android:layout_width="match_parent"
            android:layout_height="50dp"
            android:orientation="horizontal"
            android:background="#ffffff">

            <Button
                android:id="@+id/button2"
                android:layout_width="wrap_content"
                android:layout_height="wrap_content"
                android:layout_weight="1"
                android:text="上传" />

            <Button
                android:id="@+id/button3"
                android:layout_width="wrap_content"
                android:layout_height="wrap_content"
                android:layout_weight="1"
                android:text="取消" />
        </LinearLayout>

    </LinearLayout>
</android.support.constraint.ConstraintLayout>


package edu.hzuapps.androidlabs.Soft1614080902332;

import android.support.v7.app.AppCompatActivity;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.view.View.OnClickListener;

import edu.hzuapps.androidlabs.Soft1614080902332.Soft1614080902332Activity1;
import edu.hzuapps.androidlabs.Soft1614080902332.R;

public class Soft1614080902332Activity1 extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.soft_1614080902332_activity1);

        final Activity thisActivity = this;

        final Button btnOpen1 = (Button) findViewById(R.id.button_open1);
        final Button btnOpen2 = (Button) findViewById(R.id.button_open2);
        btnOpen1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(v.equals(btnOpen1)) {
                    Intent intent = new Intent(thisActivity,Soft1614080902332Activity2.class);
                    thisActivity.startActivity(intent);
                }
            }
        });
        btnOpen2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(v.equals(btnOpen2)) {
                    Intent intent = new Intent(thisActivity,Soft1614080902332Activity3.class);
                    thisActivity.startActivity(intent);
                }
            }
        });

    }
}

![image](https://github.com/QFJay/android-labs-2018/blob/master/soft1614080902332/002.png)
![image](https://github.com/QFJay/android-labs-2018/blob/master/soft1614080902332/004.png)
![image](https://github.com/QFJay/android-labs-2018/blob/master/soft1614080902332/005.png)
## 5.实验体会
花费很多时间和精力完成了这次实验，收获不小。
