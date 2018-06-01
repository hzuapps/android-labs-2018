# 第四次实验 

## 1.实验目标
根据选题要求设计界面布局及控件使用；  
布局xml及界面控制操作代码提交并截图；  
将应用运行结果截图。（不要做登录注册！）
## 2. 实验步骤
1、新建一个zuozheActivity，然后在自动生成的activity_zuozhe.xml里面设计自己想要的布局。我选的是RelativeLayout。

    <Button
        android:id="@+id/tv_1"
        android:layout_width="170dp"
        android:layout_height="200dp"
        android:text="图片"
        android:textSize="25dp"
        />
    <EditText
        android:id="@+id/tv_2"
        android:layout_marginLeft="15dp"
        android:layout_width="100dp"
        android:layout_height="50dp"
        android:textSize="16sp"
        android:hint="姓名"
        android:layout_toRightOf="@id/tv_1"
        />
    <EditText
        android:id="@+id/tv_3"
        android:layout_marginLeft="15dp"
        android:layout_width="100dp"
        android:layout_height="50dp"
        android:hint="性别"
        android:textSize="16sp"
        android:layout_toRightOf="@id/tv_2"
        />
    <EditText
        android:id="@+id/tv_4"
        android:layout_marginLeft="15dp"
        android:layout_width="200dp"
        android:layout_height="50dp"
        android:textSize="16sp"
        android:hint="学号"
        android:inputType="number"
        android:layout_below="@id/tv_2"
        android:layout_toRightOf="@id/tv_1"
        />
    <EditText
        android:id="@+id/tv_5"
        android:layout_marginLeft="15dp"
        android:layout_width="200dp"
        android:layout_height="50dp"
        android:textSize="16sp"
        android:hint="宿舍号"
        android:layout_below="@id/tv_4"
        android:layout_toRightOf="@id/tv_1"
        />
    <EditText
        android:id="@+id/tv_6"
        android:layout_marginLeft="15dp"
        android:layout_width="200dp"
        android:layout_height="50dp"
        android:textSize="16sp"
        android:hint="联系方式"
        android:inputType="number"
        android:layout_below="@id/tv_5"
        android:layout_toRightOf="@id/tv_1"
        />
    <EditText
        android:id="@+id/tv_7"
        android:layout_width="170dp"
        android:layout_height="50dp"
        android:textSize="16sp"
        android:hint="年级"
        android:layout_below="@id/tv_1"
        />
    <EditText
        android:id="@+id/tv_8"
        android:layout_marginLeft="15dp"
        android:layout_width="200dp"
        android:layout_height="50dp"
        android:textSize="16sp"
        android:hint="所在系名"
        android:layout_below="@id/tv_1"
        android:layout_toRightOf="@id/tv_7"
        />
    <EditText
        android:id="@+id/tv_9"
        android:layout_width="match_parent"
        android:layout_height="50dp"
        android:textSize="16sp"
        android:hint="所在行政班级"
        android:layout_below="@id/tv_8"
        />
    <EditText
        android:id="@+id/tv_10"
        android:layout_width="match_parent"
        android:layout_height="100dp"
        android:textSize="16sp"
        android:hint="住址"
        android:maxLines="3"
        android:layout_below="@id/tv_9"
        />

2、在布局写完之后，在activity_soft1614080902325.xml里面加上一个button。

    <Button
        android:id="@+id/textview_02"
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:text="查看作者信息"
        android:textSize="25sp"
        />
3、紧跟着在Soft1614080902325Activity里面，写上跳转到zuozheActivity的代码。

    private Button textview_02;
    
        textview_02 = findViewById(R.id.textview_02);
        textview_02.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //跳转到作者信息页面
                Intent intent = new Intent(Soft1614080902325Activity.this,zuozheActivity.class);
                startActivity(intent);

## 3. 实验结果

![在Android SDK](https://github.com/li763407418/android-labs-2018/blob/master/soft1614080902325/%234.png)


## 4. 实验体会
因为这个APP有很多东西没有确定要怎么做或者说是做还是不做，最后为了实验，所以有些东西设计得有点随意，
设计的布局用相对布局我是觉得比线性布局要好理解很多。

**加粗**常规
