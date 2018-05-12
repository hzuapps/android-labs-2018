# 第二次实验 

## 1. 实验目标
1.  在Issues中创建自己的选题：https://github.com/hzuapps/android-labs-2018/issues ；
2.  根据自选题目，编写一个或多个Activity（所有均带上学号前缀，放到自己的Java包下）；
3.  将标题设置为自己的学号+对应的功能或题目；
4.  根据自己选择的题目实现Activity中导航、调用等功能（选做）
## 2. 实验步骤
1.  在https://github.com/hzuapps/android-labs-2018/issues 的`issue`中创建一个自己想要做的选题，并加上对预计实现的功能的描述。
2.  之后打开`Android Studio`在我的工作环境下新建一个`project`，包名为`edu.hzuapps.androidlabs.soft1614080902334`。
3.  再新建一个`MainActivity`类，类名为`Soft1614080902334WeatherActivity`，按实验要求进行代码编写。
    包括`res/values/string.xml`下 添加代码：
    <br/> `<string name="app_name">天气查询</string>`
    <br/> `<string name="context">你好，世界！</string>`
4.  然后就成功修改了主页面的显示内容，打开`res\layout\activity_soft1614080902334_weather.xml`中的`preview`可看到效果。
5.  之后就把`app\src\main`包下的相关文件拷到github上就ok了。
6.  在github所fork的此项目自己目录下新建`report2.md`。（点`create new file`）
7.  编辑实验报告，把截图的raw地址复制在`report2.md`文件里,然后将项目目录一并pull给老师;



## 3. 实验结果
（包含4个文件的代码）<br/>
@file1: `java\edu\hzuapps\androidlabs\soft1614080902334\Soft1614080902334WeatherActivity.java`

package edu.hzuapps.androidlabs.soft1614080902334;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class Soft1614080902334WeatherActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_soft1614080902334_weather);
    }
}

@file2: `AndroidManifest.xml`

<?xml version="1.0" encoding="utf-8"?>
<manifest xmlns:android="http://schemas.android.com/apk/res/android"
    package="edu.hzuapps.androidlabs.soft1614080902334">

    <application
        android:allowBackup="true"
        android:icon="@mipmap/ic_launcher"
        android:label="@string/app_name"
        android:roundIcon="@mipmap/ic_launcher_round"
        android:supportsRtl="true"
        android:theme="@style/AppTheme">
        <activity android:name=".Soft1614080902334WeatherActivity">
            <intent-filter>
                <action android:name="android.intent.action.MAIN" />

                <category android:name="android.intent.category.LAUNCHER" />
            </intent-filter>
        </activity>
    </application>

</manifest>

@file3: `res\layout\activity_soft1614080902334_weather.xml`

<?xml version="1.0" encoding="utf-8"?>
<android.support.constraint.ConstraintLayout
    xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:tools="http://schemas.android.com/tools"
    xmlns:app="http://schemas.android.com/apk/res-auto"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    tools:context=".Soft1614080902334WeatherActivity">

    <TextView
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:text="@string/context"
        android:textColor="@color/colorAccent"
        android:textSize="25sp"
        app:layout_constraintBottom_toBottomOf="parent"
        app:layout_constraintLeft_toLeftOf="parent"
        app:layout_constraintRight_toRightOf="parent"
        app:layout_constraintTop_toTopOf="parent" />
<!--
在布局文件中，文本的设置使用如下写法时会有警告，
应该在res/values/xxx.xml中设置，引用的时候使用
这样做可以做到一改全改，在支持多语言时也是很有用的。
-->
</android.support.constraint.ConstraintLayout>

@file4: `res\values\strings.xml`

`<resources>
    <string name="app_name">天气查询</string>`
    `<string name="context">你好，世界！</string>
</resources>`



## 4. 实验体会
1.  这次实验比较简单，有些东西上一节课中已经学过了。再次使用`git bash`更熟练了。
2.  对IDE的运用有进步。期待下一节的内容。
