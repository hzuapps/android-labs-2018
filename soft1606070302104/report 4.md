# 第四次实验报告  

## 1.实验目标
### 实验四：Android界面设计编程

## 2.实验要求
```
(1).根据选题要求设计界面布局及控件使用；
(2).布局xml及界面控制操作代码提交并截图；
(3).将应用运行结果截图。
```

## 3.实验步骤
```
（1）打开activity_soft1606070302104.xml,把要添加的组件先添加好，比如按钮，图片等
（2）选定一种布局。我选定了linearlayout,则可以在其中添加

```
        <LinearLayout
                android:layout_width="fill_parent"
                android:layout_height="wrap_content"
                android:orientation="vertical"//或者"horizontal"，可以垂直分布也可以水平分布
                android:gravity="center"//设置使该模块居中
                >//之后再加上各种组件代码
                />
        </LinearLayout>
```

（3）想好如何把各个组件布局好。可以选择垂直分布也可以水平分布。也可以在水平分布中的其中一个模块中再进行水平分布或者垂直分布。
（4）在Soft1606070302104Activity.java中新建多个按钮private Button btn;可以不同按钮名字对应其id。
（5）再创建一个button监听器，并使监听器能打开另一个activity并传值，添加以下代码：


```
        //创建一个Button的OnClick监听器这个属于一个内部类
    class MyButtonListener implements OnClickListener {
        //
        public void onClick(View v) {
            Intent intent = new Intent();
            intent.setClass(Soft1606070302104Activity.this, second2Activity.class);
            Soft1606070302104Activity.this.startActivity(intent);
        }
    }
```

二．把监听事件绑定到按钮btn

```
        btn = (Button) findViewById(R.id.button);
         //绑定监听事件  
        btn.setOnClickListener(new MyButtonListener() );  
```

三．在另一个activity中读取intent值

```
        //创建一个Intent实例存储传送过来的值
        Intent myIntent = getIntent();
        //读取Intent的值
        String TextValue = myIntent.getStringExtra("Text");
```

（6）在子activity中也可以做相应的操作，做不同的布局
（7）运行
```

## 3.实验结果

![image](https://github.com/lili503946540/android-labs-2018/blob/master/soft1606070302104/test4-1.png)

![image](https://github.com/lili503946540/android-labs-2018/blob/master/soft1606070302104/test4-2.png)

![image](https://github.com/lili503946540/android-labs-2018/blob/master/soft1606070302104/test4-3.png)

## 4.实验体会
本次实验是运用布局来设计界面，只要知道是用那些代码来设计布局的，并且想好如何设计组件的分布，问题就很简单了。通过这次实验我对布局的方法更加了解了，也不断尝试去用用了不同的方法实现布局。。但依旧对jva的语法掌握不足，我在创建多个按钮想要出现=多个activity的时候，没有建立多个监听器而使我i在过程中又浪费了些时间去解决这些低级错误。
