��2��ʵ�鱨��
һ��ʵ��Ҫ��
1.��Issues�д����Լ���ѡ�⣺https://github.com/hzuapps/android-labs-2018/issues ��
2.������ѡ��Ŀ����дһ������Activity�����о�����ѧ��ǰ׺���ŵ��Լ���Java���£���
3.����������Ϊ�Լ���ѧ��+��Ӧ�Ĺ��ܻ���Ŀ��
4.�����Լ�ѡ�����Ŀʵ��Activity�е��������õȹ��ܣ�ѡ������
����ʵ�鲽��
1.�Ķ�ʵ��Ҫ��https://github.com/hzuapps/android-labs-2018/labels/Lab
2.�ڵ�����Android Studio��д����
  // ����Ҫ�������У�
3.ʹ��Git�������ύ���Լ��Ŀ��У�https://github.com/xuangangjie/android-labs-2018
  $ git pull
  $ git add ѧ��Ŀ¼/*
  $ git commit "#12345678 "
  $ git push
4.���Լ���GitHub���ϴ����ͷ���Pull Request��ע��鿴Changed files��
  // �Ƿ�ֻ�޸����Լ����ļ���
5.��GitHub��ʹ��Markdown�ļ���дʵ�鱨�棨report1.md, report2.md��
  // �������Լ����ļ�����
����ʵ����
package edu.hzuapps.androidlabs.com1614080901220;

import android.support.v7.app.AppCompatActivity; import android.os.Bundle;

public class com1614080901220Activity extends AppCompatActivity {

@Override
protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_com1614080901220);
}
}

<android.support.constraint.ConstraintLayout xmlns:android="http://schemas.android.com/apk/res/android" xmlns:app="http://schemas.android.com/apk/res-auto" xmlns:tools="http://schemas.android.com/tools" android:layout_width="match_parent" android:layout_height="match_parent" tools:context="edu.hzuapps.androidlabs.com1614080901220.com1614080901220Activity">

<TextView
    android:layout_width="wrap_content"
    android:layout_height="wrap_content"
    android:text="Hello World!"
    app:layout_constraintBottom_toBottomOf="parent"
    app:layout_constraintLeft_toLeftOf="parent"
    app:layout_constraintRight_toRightOf="parent"
    app:layout_constraintTop_toTopOf="parent" />
</android.support.constraint.ConstraintLayout>

<application
    android:allowBackup="true"
    android:icon="@mipmap/ic_launcher"
    android:label="@string/app_name"
    android:roundIcon="@mipmap/ic_launcher_round"
    android:supportsRtl="true"
    android:theme="@style/AppTheme">
    <activity android:name=".com1614080901220Activity">
        <intent-filter>
            <action android:name="android.intent.action.MAIN" />

            <category android:name="android.intent.category.LAUNCHER" />
        </intent-filter>
    </activity>
</application>
soft1606081301318֪���ձ�
�ġ�ʵ�����
����ʵ��ѧϰ�������Android Studioȥ����һ����Ŀ,����ѧϰ�����ȥ�޸ĸ���Ŀ�������������루main.java , AndroidManifest.xml , main_activity.xml , strings.xml��,���˽⵽MVCģʽ�����˼�롣����һֱû��ʱ���ڰ�׿�ϣ����Ըе������Ρ�