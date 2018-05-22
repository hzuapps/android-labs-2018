第三次实验

1.实验目标

掌握在Android应用中使用图片等资源的方法。

2.实验步骤

阅读实验要求：https://github.com/hzuapps/android-labs-2018/labels/Lab (1) 创建新Activity，名字为SecondActivity

在Soft1614080902241Activity.java编写代码，代码如下 
 
private TextView textView;
@Override
protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_soft1614080902241);

    textView=(TextView)findViewById(R.id.huanying);

    textView.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent intent=new Intent(Soft1614080902241Activity.this,SecondActivity.class);
            startActivity(intent);
        }
    });
（2）在drawable目录下插入一张跟自己选题相关的图片

然后在activity_soft1614080902241.xml编写如下代码

  <TextView
    android:id="@+id/huanying"
    android:layout_width="wrap_content"
    android:layout_height="wrap_content"
    android:drawableTop="@drawable/huanying"
    android:text="hello_world" />
    
huanying是图片的名字，可以在design看到图片
(3)在strings.xml改成自己选题名字， 结果如下 天天记账本

（4）使用Git将代码提交到自己的库中：https://github.com/YOUR_NAME/android-labs-2018

 $ git pull 

 $ git add 学号目录/* 

 $ git commit "#3 #921第三次实验 " 

 $ git push 

 在自己的GitHub库上创建和发送Pull Request（注意查看Changed files） 

 // 是否只修改了自己的文件？ 

 在GitHub中使用Markdown文件编写实验报告（report3.md）
 3.实验结果

![image](https://github.com/LuoJKL/android-labs-2018/blob/master/soft1614080902241/3_1.jpg) 

![image](https://github.com/LuoJKL/android-labs-2018/blob/master/soft1614080902241/3_2.jpg) 

4.实验体会

这次实验要自己亲自动手写代码完成，其实并不难，主要是因为不懂得Java的语法。

最后把程序转换为apk文件在手机上安装并且成功运行，很开心
