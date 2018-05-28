# 第3次实验
 
## 1.实验目标
* 将图片放入界面中
* 实现Activity间的跳转
 
## 2.实验步骤
* 设置TextView节点，将图片导入相应位置
``` xml
       <ImageView
            android:layout_width="wrap_content"
            android:layout_height="wrap_content"
            android:background="@drawable/ic_password_logo"
            android:layout_gravity="center_horizontal"
            android:layout_marginTop="120px"
            />
```
* 实现OnClickListener接口，复写onClick方法，findViewById获取监听组件，startActivity执行跳转
``` java
        loginButtom = findViewById(R.id.login);
        loginButtom.setOnClickListener(new loginButtomListener());
```

``` java
private class loginButtomListener implements View.OnClickListener {
        public void onClick(View v) {
            Intent intent = new Intent();
            intent.setClass(soft1614080902329Activity.this, soft1614080902329RecordActivity.class);
            soft1614080902329Activity.this.startActivity(intent);
        }
    }
```
 
## 3.实验结果
* 实验截图1
![实验截图](https://github.com/OrangeHap/android-labs-2018/blob/master/soft1614080902329/lab3_1.png)

* 实验截图2
![实验截图](https://github.com/OrangeHap/android-labs-2018/blob/master/soft1614080902329/lab3_2.png)

## 4.实验体会 
* 通过这次实验学会了activity之间的跳转，和图片的导入
