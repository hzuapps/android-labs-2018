# �ڶ���ʵ��
## 1.ʵ��Ŀ��
(1)��Issues�д����Լ���ѡ�⣺https://github.com/hzuapps/android-labs-2018/issues�� 
(2)������ѡ��Ŀ����дһ������Activity�����о�����ѧ��ǰ׺���ŵ��Լ���Java���£��� 
(3)����������Ϊ�Լ���ѧ��+��Ӧ�Ĺ��ܻ���Ŀ��
## 2.ʵ�鲽��
(1)�Ķ�ʵ��Ҫ��https://github.com/hzuapps/android-labs-2018/labels/Lab 
(2)�ڵ�����Android Studio��д���� // ����Ҫ�������У�
(3)ʹ��Git�������ύ���Լ��Ŀ��У�https://github.com/YOUR_NAME/android-labs-2018
$ git pull 
$ git add ѧ��Ŀ¼/*
$ git commit "#2 #984 �ڶ���ʵ�� "
$ git push
(4)���Լ���GitHub���ϴ����ͷ���Pull Request��ע��鿴Changed files�� // �Ƿ�ֻ�޸����Լ����ļ��� 
(5)��GitHub��ʹ��Markdown�ļ���дʵ�鱨�棨report1.md, report2.md��// �������Լ����ļ����� 
## 3.ʵ����(4���ļ��Ĵ���)

�ļ�1.java\soft1614080902302\androidlabs\hzuapps\edu\soft1614080902302activity\Soft1614080902302Activity.java
package soft1614080902302.androidlabs.hzuapps.edu.soft1614080902302activity;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;

public class Soft1614080902302Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_soft1614080902302);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_soft1614080902302, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}

�ļ�2.AndroidManifest.xml

<?xml version="1.0" encoding="utf-8"?>
<manifest xmlns:android="http://schemas.android.com/apk/res/android"
    package="soft1614080902302.androidlabs.hzuapps.edu.soft1614080902302activity">

    <application
        android:allowBackup="true"
        android:icon="@mipmap/ic_launcher"
        android:label="@string/app_name"
        android:roundIcon="@mipmap/ic_launcher_round"
        android:supportsRtl="true"
        android:theme="@style/AppTheme">
        <activity
            android:name=".Soft1614080902302Activity"
            android:label="@string/app_name"
            android:theme="@style/AppTheme.NoActionBar">
            <intent-filter>
                <action android:name="android.intent.action.MAIN" />

                <category android:name="android.intent.category.LAUNCHER" />
            </intent-filter>
        </activity>
    </application>

</manifest>

�ļ�3.activity_soft1614080902302.xml

<?xml version="1.0" encoding="utf-8"?>
<android.support.design.widget.CoordinatorLayout xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:app="http://schemas.android.com/apk/res-auto"
    xmlns:tools="http://schemas.android.com/tools"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    tools:context=".Soft1614080902302Activity">

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

    <include layout="@layout/content_soft1614080902302" />

    <android.support.design.widget.FloatingActionButton
        android:id="@+id/fab"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:layout_gravity="bottom|end"
        android:layout_margin="@dimen/fab_margin"
        app:srcCompat="@android:drawable/ic_dialog_email" />

</android.support.design.widget.CoordinatorLayout>

�ļ�4.strings.xml

<resources>
    <string name="app_name">Soft1614080902302��ݲ�ѯϵͳ</string>
    <string name="action_settings">Settings</string>
</resources>


## 4.ʵ����� 
  ͨ�����ʵ��,���˽⵽Android�����,ѧ�����޸ı�����������.