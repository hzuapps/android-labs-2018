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

2.打开layout文件夹里的activity_com1614080901115.xml和activity_second.xml；

3.设计界面布局，添加控件；

4.实现部分控件的事件处理；

5.运行测试。
## 4.实验结果
package com.example.wen.com1614080901115;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import java.util.Timer;
import java.util.TimerTask;

public class Com1614080901115Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_com1614080901115);

        final Intent it = new Intent(this,SecondActivity.class); //你要转向的Activity
        Timer timer = new Timer();
        TimerTask task = new TimerTask() {
            @Override
            public void run() {
                startActivity(it); //执行
            }
        };
        timer.schedule(task, 1000 * 5);
    }
}

package com.example.wen.com1614080901115;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.content.Intent;
import android.widget.Button;

public class SecondActivity extends Activity {
    Button button1 = null;
    Button button2 = null;
    Button button3 = null;
    Button button4 = null;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        button1 = (Button)findViewById(R.id.button1);
        button1.setOnClickListener( new button1Listener());

        button2 = (Button)findViewById(R.id.button2);
        button2.setOnClickListener( new button2Listener());

        button3 = (Button)findViewById(R.id.button3);
        button3.setOnClickListener( new button3Listener());

        button4 = (Button)findViewById(R.id.button4);
        button4.setOnClickListener( new button4Listener());
    }
    class button1Listener implements OnClickListener{

        @Override
        public void onClick(View arg0) {
            // TODO Auto-generated method stub
            Intent intent = new Intent();
            intent.setClass(SecondActivity.this,Button1Activity.class);
            SecondActivity.this.startActivity(intent);
        }

    }

    class button2Listener implements OnClickListener{

        @Override
        public void onClick(View arg0) {
            // TODO Auto-generated method stub
            Intent intent = new Intent();
            intent.setClass(SecondActivity.this,Button2Activity.class);
            SecondActivity.this.startActivity(intent);
        }

    }

    class button3Listener implements OnClickListener{

        @Override
        public void onClick(View arg0) {
            // TODO Auto-generated method stub
            Intent intent = new Intent();
            intent.setClass(SecondActivity.this,Button3Activity.class);
            SecondActivity.this.startActivity(intent);
        }

    }

    class button4Listener implements OnClickListener{

        @Override
        public void onClick(View arg0) {
            // TODO Auto-generated method stub
            Intent intent = new Intent();
            intent.setClass(SecondActivity.this,Button4Activity.class);
            SecondActivity.this.startActivity(intent);
        }

    }

}

package com.example.wen.com1614080901115;

import android.app.Activity;
import android.os.Bundle;

public class Button1Activity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.button1);
    }
}

package com.example.wen.com1614080901115;

import android.app.Activity;
import android.os.Bundle;

public class Button2Activity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.button2);
    }
}

package com.example.wen.com1614080901115;

import android.app.Activity;
import android.os.Bundle;

public class Button3Activity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.button3);
    }
}

package com.example.wen.com1614080901115;

import android.app.Activity;
import android.os.Bundle;

public class Button4Activity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.button4);
    }
}

<?xml version="1.0" encoding="utf-8"?>
<android.support.constraint.ConstraintLayout xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:app="http://schemas.android.com/apk/res-auto"
    xmlns:tools="http://schemas.android.com/tools"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    android:background="@drawable/beijing"
    tools:context=".Com1614080901115Activity">

    <TextView
        android:id="@+id/no1"
        android:layout_width="230dp"
        android:layout_height="52dp"
        android:layout_gravity="center_horizontal"
        android:gravity="center_horizontal"
        android:text="欢迎您的到来!"
        android:textColor="#FFFFFF"
        android:textSize="35dp"
        app:layout_constraintBottom_toBottomOf="parent"
        app:layout_constraintEnd_toEndOf="parent"
        app:layout_constraintHorizontal_bias="0.5"
        app:layout_constraintStart_toStartOf="parent"
        app:layout_constraintTop_toTopOf="parent" />

</android.support.constraint.ConstraintLayout>

<?xml version="1.0" encoding="utf-8"?>
<android.support.constraint.ConstraintLayout xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:app="http://schemas.android.com/apk/res-auto"
    xmlns:tools="http://schemas.android.com/tools"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    android:background="@drawable/chiji"
    tools:context=".SecondActivity"
    tools:layout_editor_absoluteY="81dp">

    <Button
        android:id="@+id/button1"
        android:layout_width="0dp"
        android:layout_height="50dp"
        android:layout_marginBottom="2dp"
        android:layout_marginEnd="22dp"
        android:layout_marginLeft="16dp"
        android:layout_marginRight="22dp"
        android:layout_marginStart="16dp"
        android:layout_marginTop="422dp"
        android:background="@drawable/news"
        app:layout_constraintBottom_toTopOf="@+id/textView2"
        app:layout_constraintEnd_toStartOf="@+id/button2"
        app:layout_constraintStart_toStartOf="parent"
        app:layout_constraintTop_toTopOf="parent" />

    <Button
        android:id="@+id/button2"
        android:layout_width="0dp"
        android:layout_height="50dp"
        android:layout_marginBottom="2dp"
        android:layout_marginEnd="21dp"
        android:layout_marginRight="21dp"
        android:layout_marginTop="422dp"
        android:background="@drawable/friends"
        app:layout_constraintBottom_toTopOf="@+id/textView3"
        app:layout_constraintEnd_toStartOf="@+id/button3"
        app:layout_constraintStart_toEndOf="@+id/button1"
        app:layout_constraintTop_toTopOf="parent" />

    <Button
        android:id="@+id/button3"
        android:layout_width="0dp"
        android:layout_height="50dp"
        android:layout_marginBottom="2dp"
        android:layout_marginEnd="21dp"
        android:layout_marginRight="21dp"
        android:layout_marginTop="422dp"
        android:background="@drawable/pk"
        app:layout_constraintBottom_toTopOf="@+id/textView4"
        app:layout_constraintEnd_toStartOf="@+id/button4"
        app:layout_constraintStart_toEndOf="@+id/button2"
        app:layout_constraintTop_toTopOf="parent" />

    <Button
        android:id="@+id/button4"
        android:layout_width="0dp"
        android:layout_height="50dp"
        android:layout_marginBottom="2dp"
        android:layout_marginEnd="16dp"
        android:layout_marginRight="16dp"
        android:layout_marginTop="422dp"
        android:background="@drawable/my"
        app:layout_constraintBottom_toTopOf="@+id/textView5"
        app:layout_constraintEnd_toEndOf="parent"
        app:layout_constraintStart_toEndOf="@+id/button3"
        app:layout_constraintTop_toTopOf="parent" />

    <TextView
        android:id="@+id/textView2"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:layout_marginBottom="3dp"
        android:layout_marginEnd="46dp"
        android:layout_marginLeft="31dp"
        android:layout_marginRight="46dp"
        android:layout_marginStart="31dp"
        android:text="资讯"
        android:textSize="20sp"
        app:layout_constraintBottom_toBottomOf="parent"
        app:layout_constraintEnd_toStartOf="@+id/textView3"
        app:layout_constraintStart_toStartOf="parent"
        app:layout_constraintTop_toBottomOf="@+id/button1" />

    <TextView
        android:id="@+id/textView3"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:layout_marginBottom="3dp"
        android:layout_marginEnd="47dp"
        android:layout_marginRight="47dp"
        android:text="好友"
        android:textSize="20sp"
        app:layout_constraintBottom_toBottomOf="parent"
        app:layout_constraintEnd_toStartOf="@+id/textView4"
        app:layout_constraintStart_toEndOf="@+id/textView2"
        app:layout_constraintTop_toBottomOf="@+id/button2" />

    <TextView
        android:id="@+id/textView4"
        android:layout_width="43dp"
        android:layout_height="28dp"
        android:layout_marginEnd="46dp"
        android:layout_marginRight="46dp"
        android:text="战绩"
        android:textSize="20sp"
        app:layout_constraintBottom_toBottomOf="parent"
        app:layout_constraintEnd_toStartOf="@+id/textView5"
        app:layout_constraintStart_toEndOf="@+id/textView3"
        app:layout_constraintTop_toBottomOf="@+id/button3" />

    <TextView
        android:id="@+id/textView5"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:layout_marginBottom="3dp"
        android:layout_marginEnd="30dp"
        android:layout_marginRight="30dp"
        android:text="我的"
        android:textSize="20sp"
        app:layout_constraintBottom_toBottomOf="parent"
        app:layout_constraintEnd_toEndOf="parent"
        app:layout_constraintStart_toEndOf="@+id/textView4"
        app:layout_constraintTop_toBottomOf="@+id/button4" />

</android.support.constraint.ConstraintLayout>

<?xml version="1.0" encoding="utf-8"?>
<android.support.constraint.ConstraintLayout xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:app="http://schemas.android.com/apk/res-auto"
    xmlns:tools="http://schemas.android.com/tools"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    android:background="@drawable/ji1"
    tools:context="Button1Activity">

</android.support.constraint.ConstraintLayout>

<?xml version="1.0" encoding="utf-8"?>
<android.support.constraint.ConstraintLayout xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:app="http://schemas.android.com/apk/res-auto"
    xmlns:tools="http://schemas.android.com/tools"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    android:background="@drawable/ji2"
    tools:context="Button2Activity">

</android.support.constraint.ConstraintLayout>

<?xml version="1.0" encoding="utf-8"?>
<android.support.constraint.ConstraintLayout xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:app="http://schemas.android.com/apk/res-auto"
    xmlns:tools="http://schemas.android.com/tools"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    android:background="@drawable/ji3"
    tools:context="Button3Activity">

</android.support.constraint.ConstraintLayout>

<?xml version="1.0" encoding="utf-8"?>
<android.support.constraint.ConstraintLayout xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:app="http://schemas.android.com/apk/res-auto"
    xmlns:tools="http://schemas.android.com/tools"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    android:background="@drawable/ji4"
    tools:context="Button4Activity">

</android.support.constraint.ConstraintLayout>

![image](https://github.com/weno9o2/android-labs-2018/blob/master/com1614080901115/app/%E5%AE%9E%E9%AA%8C%E5%9B%9B%E6%88%AA%E5%9B%BE.png)

## 5.实验体会
本次实验和实验三在我看来所学到的东西都差不多，只不过实验四更加要求细节处理例如布局上的安排，这次我使用了button的跳转，采用constrainlayout布局的方式，这是个可以在design模式下自由操控的，对于我这种敲代码不太熟练的人简直就是神技。在做本次实验时，
有次clean project后不知为何重新move了一次项目，结果导致我的项目不知所踪，后来在根目录下找到了我的AS文件夹，修改下后重新成功
导入，不然真的是欲哭无泪。
