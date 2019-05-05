# 实验三

## 1.实验目的
掌握在Android应用中使用图片等资源的方法 

## 2.实验要求
+ 1. 在界面上显示至少一张图片（按照自己的题目添加）；
+ 2. 提交res/drawable及图片使用的代码；
+ 3. 提交res/values, res/layout等其他代码；
+ 4. 将应用运行结果截图，放到实验报告中；
+ 5. 点击图片（或按钮）时，打开另一个Activity；

## 3.实验步骤
+ 1.将符合课题的图片复制进res/drawable中
+ 2.打开Activity的XML，将图片定义为主界面的背景，代码如下：
~~~
<TextView
        android:id="@+id/XXX"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:drawableTop="@drawable/（图片名）"
~~~
+ 3.定义按钮，在java文件里加入打开另一个Activity的监听事件
~~~ 
    super.onCreate(savedInstanceState);
        setContentView(R.layout.原Activity);

        Button button1 = (Button)findViewById(R.id.button_open);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setClass(原Activity.this,目标打开的Activity.class);
                startActivity(intent);
            }
        });
~~~

## 4.实验结果
![在Android SDK Manager中选择6.0库](https://github.com/Zhengmianjie/android-labs-2018/blob/master/soft1614080902314/3%E8%BF%90%E8%A1%8C%E6%88%AA%E5%9B%BE.png?raw=true"配置教育网下载代理")

## 5.实验体会
    
本次实验，主要让我们掌握按钮创建并通过按钮实现java程序界面的跳转
