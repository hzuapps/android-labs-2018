# 第三次实验 
掌握在Android应用中使用图片等资源的方法。
## 1. 实验目标
1    在界面上显示至少一张图片；  
2    提交res/drawable及图片使用的代码；  
3    提交res/values, res/layout等其他代码；  
4    将应用运行结果截图，放到实验报告中；  
5    点击图片（或按钮）时，打开另一个Activity。  
## 2. 实验步骤

1    打开Android Studio进行编程；  
2    通过对按钮设置监听来实现跳转到另一个Activity的事件；  
3    通过Intent类来实现跳转Activity这个功能；  
4    代码实现后，通过git将app目录结构且有编码、有添加的文件先储存在自己clone下来的目录下，后上传到GitHub。  
git指令代码如下：  
    git add res/*  
    git add drawable/*  
    git commit -m "#3 #994 QQ the 3rd lab"  
    git push  

5    继续上传report3.md文件，写实验报告
## 3. 实验结果
app运行结果:
![在Android SDK Manager中选择6.0库](https://raw.githubusercontent.com/ChenchenJT/android-labs-2018/master/soft1614080902335/%E5%AE%9E%E9%AA%8C%E4%B8%89%E6%88%AA%E5%9B%BE1.png "配置教育网下载代理")


点击按钮后调到另一个Activity：
![在Android SDK Manager中选择6.0库](https://raw.githubusercontent.com/ChenchenJT/android-labs-2018/master/soft1614080902335/%E5%AE%9E%E9%AA%8C%E4%B8%89%E6%88%AA%E5%9B%BE2.png "配置教育网下载代理")

改变的文件代码：
1   Soft1614080902335Activity1.java  
package androidlabs.hzuapps.edu.soft1614080902335;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.view.View.OnClickListener;

import androidlabs.hzuapps.edu.soft1614080902335.R;
import androidlabs.hzuapps.edu.soft1614080902335.Soft1614080902335Activity1;

public class Soft1614080902335Activity1 extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_soft1614080902335_qq1);

        final Activity thisActivity = this;
        final Button btnOpen = (Button) findViewById(R.id.button_open);
        btnOpen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (v.equals(btnOpen)) {
                    Intent intent = new Intent(thisActivity,Soft1614080902335Activity2.class);
                    thisActivity.startActivity(intent);
                }
            }
        });

    }
}

2   activity_soft1614080902335_qq1.xml  
<?xml version="1.0" encoding="utf-8"?>
<RelativeLayout xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:app="http://schemas.android.com/apk/res-auto"
    xmlns:tools="http://schemas.android.com/tools"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    tools:context=".Soft1614080902335Activity1">

    <TextView
        android:id="@+id/textview_01"
        android:layout_width="310dp"
        android:layout_height="398dp"
        android:layout_above="@+id/button_open"
        android:layout_centerHorizontal="true"
        android:layout_marginHorizontal="20dp"
        android:drawableTop="@drawable/qqlogo"
        tools:ignore="MissingConstraints"
        tools:layout_editor_absoluteX="25dp"
        tools:layout_editor_absoluteY="0dp" />

    <TextView
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:layout_alignParentBottom="true"
        android:layout_centerHorizontal="true"
        android:layout_marginBottom="169dp"
        android:text="Hello World!"
        android:textSize="25dp"
        app:layout_constraintBottom_toBottomOf="parent"
        app:layout_constraintHorizontal_bias="0.502"
        app:layout_constraintLeft_toLeftOf="parent"
        app:layout_constraintRight_toRightOf="parent"
        app:layout_constraintTop_toTopOf="parent"
        app:layout_constraintVertical_bias="0.624" />

    <Button
        android:id="@+id/button_open"
        android:layout_width="189dp"
        android:layout_height="46dp"
        android:layout_alignParentBottom="true"
        android:layout_centerHorizontal="true"
        android:layout_marginBottom="56dp"
        android:text="查看用户信息"
        android:textSize="15dp"
        tools:ignore="MissingConstraints"
        tools:layout_editor_absoluteX="86dp"
        tools:layout_editor_absoluteY="413dp" />
</RelativeLayout>

3   activity_soft1614080902335_qq2.xml  
<?xml version="1.0" encoding="utf-8"?>
<RelativeLayout xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:app="http://schemas.android.com/apk/res-auto"
    xmlns:tools="http://schemas.android.com/tools"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    tools:context=".Soft1614080902335Activity2">

    <TextView
        android:layout_width="223dp"
        android:layout_height="wrap_content"
        android:layout_centerInParent="true"
        android:text="该功能开发中..."
        android:textSize="30dp"
        tools:ignore="MissingConstraints"
        tools:layout_editor_absoluteX="80dp"
        tools:layout_editor_absoluteY="224dp" />

</RelativeLayout>


## 4. 实验体会
1   在对Activity布局进行编写时，由于要对控件进行布局，之前所采用的ConstraintLayout布局方式需要更改为相对布局Relativelayout，这样可让控件自由设置;  
2   在写Activity时，通过监听在xml定义的按钮，在运用Intent来启动另一个Activity。

**加粗**常规
