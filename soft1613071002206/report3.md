第三次实验报告
1.实验目标
实验三：Android资源使用编程
2.实验要求
(1). 在界面上显示至少一张图片（按照自己的题目添加）；
(2).提交res/drawable及图片使用的代码；
(3).提交res/values, res/layout等其他代码；
(4).将应用运行结果截图，放到实验报告中；
(5).点击图片（或按钮）时，打开另一个Activity。
3.实验步骤
(1).找到自己想要插入的图片，并且以小写字母命名好，复制该图片到res/drawable目录下
(2).此时在 activity_soft1606070302104.xml中的<TextView插入

    android:id="@+id/textview_01"
    android:drawableTop="@drawable/poke"

此时图片就可以显示出来了。

(3).在activity_soft1606070302104.xml的Design页面中，添加Button，并且命名，它会在TEXT页面中相应显示代码
(4).新建second2Activity，该Activity为按钮Button点出的另外一个Activity,。并且编辑activity_second2.xml的页面内容
(5).在Soft1606070302104Activity.java中新建一个按钮private Button btn;。
(6).再创建一个button监听器，并使监听器能打开另一个activity并传值，添加以下代码：


    //创建一个Button的OnClick监听器这个属于一个内部类
class MyButtonListener implements OnClickListener {
    //
    public void onClick(View v) {
        // TODO Auto-generated method stub
        //创建一个Intent的实例
        Intent intent = new Intent();
        //设置从哪个activity启动哪个activity
        intent.setClass(Soft1606070302104Activity.this, second2Activity.class);
        //把一个值写入到Intent中
        //intent.putExtra("Text", "测试值");
        //启动另一个activity
        Soft1606070302104Activity.this.startActivity(intent);
    }
}

二．把监听事件绑定到按钮btn

    btn = (Button) findViewById(R.id.button);
     //绑定监听事件  
    btn.setOnClickListener(new MyButtonListener() );  

三．在另一个activity中读取intent值

    //创建一个Intent实例存储传送过来的值
    Intent myIntent = getIntent();
    //读取Intent的值
    String TextValue = myIntent.getStringExtra("Text");

(7).运行
实验结果如下：
![image](https://github.com/ZZZZmin/android-labs-2018/blob/master/soft1613071002206/%E5%AE%9E%E9%AA%8C%E4%B8%89-1.png?raw=true)
![image](https://github.com/ZZZZmin/android-labs-2018/blob/master/soft1613071002206/%E5%AE%9E%E9%AA%8C%E4%B8%89-2.png?raw=true)
实验体会：
这次实验总体来讲最大的难度应该就是设置那个点击事件了，利用了监听器，我的java基础较弱也同样查了许多资料才搞明白，在添加监听器过程中有许多错误，需要添加import，之后要把监听器绑定到按钮上，之后在另一个activity中读取intent值。在这个过程中总是让人从盲区中到豁然开朗，也学到了很多。
希望我能去多学习点JAVA知识，才能更好学习ANDROID开发。
