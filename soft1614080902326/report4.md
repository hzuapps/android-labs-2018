# 第四次实验

## 实验目标

1.根据选题要求设计界面布局及控件使用

2.布局xml及界面控制操作代码提交并截图

3.将应用运行结果截图

## 实验步骤
1.启动Android Studio并启动项目ColourSelect<br><br>
2.将Activity中布局更改为线性布局，使内容分布合理，使用嵌套布局使得各组件位置排放美观。<br><br>
3. 为添加按钮定义popupWindow，利用onKeyDown监视返回按钮，避免按下返回键退出程序而不是关闭popupWindow。<br><br>
4. 界面优化。<br><br>
5. 运行调试。<br><br>  

## 部分代码
      <LinearLayout
            android:layout_width="match_parent"
            android:layout_height="wrap_content"
            android:orientation="horizontal">
            
            <Button
                android:id="@+id/add_Button"
                style="@android:style/Widget.DeviceDefault.Button.Borderless"
                android:layout_width="55dp"
                android:layout_height="42dp"
                android:layout_marginTop="6dp"
                android:gravity="start"
                android:text="@string/add" />

            <TextView
                android:id="@+id/textView"
                android:layout_width="wrap_content"
                android:layout_height="match_parent"
                android:layout_gravity="center_horizontal"
                android:layout_weight="2"
                android:gravity="center"
                android:text="@string/app_name"
                android:textAppearance="@style/TextAppearance.AppCompat.Widget.TextView.SpinnerItem"
                android:textSize="24sp" />

            <Button
                android:id="@+id/collectButton"
                style="@android:style/Widget.DeviceDefault.Button.Borderless"
                android:layout_width="55dp"
                android:layout_height="42dp"
                android:layout_marginTop="6dp"
                android:gravity="end"
                android:text="@string/collect" />
        </LinearLayout>



## 实验结果

![截图](https://github.com/JWL1ang/android-labs-2018/blob/master/soft1614080902326/experiment%204.png)  
![截图](https://github.com/JWL1ang/android-labs-2018/blob/master/soft1614080902326/experiment%204(2).png)

## 实验体会
  在popupWindow中花费相对较多时间，本原想使用popupMenu，但交互效果相对较差，其次在TextView添加事件出现点击无响应，参考：https://blog.csdn.net/hz51390/article/details/52098284 原因是在一些机型上TextView的 android:clickable默认为false，所以如果要在xml中写TextView的点击事件回调的话，一定要写上android:clickable="true"。
