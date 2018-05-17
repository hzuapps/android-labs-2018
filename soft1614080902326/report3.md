# 第三次实验

## 1.实验目标

掌握在Android应用中使用图片等资源的方法。

## 2.实验步骤
1.启动Android Studio打开项目  
2.在activity_soft1614080902326Activity.xml中添加代码
```xml
<TextView
            android:id="@+id/oreo"
            android:layout_width="wrap_content"
            android:layout_height="300dp"
            android:layout_gravity="center"
            android:drawableTop="@drawable/oreo"
            android:layout_margin="10dp" />
```
3.把图片资源复制到app\src\main\res\drawable目录下  
4.在activity_soft1614080902326Activity.xml添加Button按钮
```xml
<Button
                android:id="@+id/collectButton"
                style="@android:style/Widget.DeviceDefault.Button.Borderless"
                android:layout_width="55dp"
                android:layout_height="42dp"
                android:layout_marginTop="6dp"
                android:gravity="end"
                android:text="@string/collect" />
```  
5.在Soft1614080902326.java中添加Activity跳转命令
```java
 Button collect = (Button) findViewById(R.id.collectButton);
 collect.setOnClickListener(this);
  public void onClick(View v) {
        switch(v.getId()){
            case R.id.collectButton:
                Intent intent = new Intent ();
                intent.setClass(Soft1614080902326Activity.this,CollectActivity.class);
                startActivity(intent);
                break;
        }
    }
```  
6.调试运行
## 3.实验结果
![截图](https://github.com/JWL1ang/android-labs-2018/blob/master/soft1614080902326/experiment%203(1).PNG)
![截图](https://github.com/JWL1ang/android-labs-2018/blob/master/soft1614080902326/experiment%203(2).PNG)

## 4.实验体会
本次实验掌握了在应用中添加图片资源，也知道了如何控制部件的布局，activity跳转与java类似，后续就是功能与美工方面的填充了。
