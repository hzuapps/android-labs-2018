# 第2次实验
 
## 1.实验目标
* 建立一个自己的项目（密码备忘录）
* 实现如下功能
* 1.进入应用的用户密码验证功能
* 2.进行密码记录的功能
 
## 2.实验步骤
* 1.新建项目
* 2.用线性布局建立第一个界面
``` xml
        <LinearLayout
        android:layout_width="match_parent"
        android:layout_height="match_parent"
        android:orientation="vertical"
        >

        <ImageView
            android:layout_width="wrap_content"
            android:layout_height="wrap_content"
            android:background="@drawable/ic_password_logo"
            android:layout_gravity="center_horizontal"
            android:layout_marginTop="120px"
            />

        <EditText
            android:id="@+id/username"
            android:layout_width="wrap_content"
            android:layout_height="wrap_content"
            android:ems="10"
            android:hint="用户名"
            android:textSize="20dp"
            android:inputType="textPersonName"
            android:layout_gravity="center_horizontal"
            android:layout_marginTop="80px"
            />

        <EditText
            android:id="@+id/password"
            android:layout_width="wrap_content"
            android:layout_height="wrap_content"
            android:ems="10"
            android:hint="密码"
            android:textSize="20dp"
            android:inputType="textPassword"
            android:layout_gravity="center_horizontal"
            android:layout_marginTop="40px"
            />


        <Button
            android:id="@+id/login"
            android:layout_width="170sp"
            android:layout_height="wrap_content"
            android:text="解锁"
            android:textSize="20dp"
            android:layout_gravity="center_horizontal"
            android:layout_marginTop="130px"
            />

        <Button
            android:id="@+id/author"
            android:layout_width="170sp"
            android:layout_height="wrap_content"
            android:text="作者"
            android:textSize="20dp"
            android:layout_gravity="center_horizontal"
            android:layout_marginTop="50px"
            />

    </LinearLayout>
```
 
## 3.实验结果
* 实验截图
![实验截图](https://github.com/OrangeHap/android-labs-2018/blob/master/soft1614080902329/second_labs.png)

## 4.实验体会 
* 通过LinearLayout进行线性布局，通过其属性改变控件状态
