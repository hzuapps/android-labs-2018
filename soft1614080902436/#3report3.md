# 第三次实验

## 1.实验目标
掌握在Android应用中使用图片等资源的方法。

## 2.实验步骤
阅读实验要求：https://github.com/hzuapps/android-labs-2018/labels/Lab
 
①在AS(android stdio)上创建一个新的activity,命名为Soft1614080902436MainActivity.java
②打开SMA(Soft1614080902436MainAtivity.java)相对应的xml,目录在res/mainactivity_soft1614080902436.xml
③切换到design模式,往xml里添加组件,完成添加图片的操作
④复制代码到xml中,并修改图片路径:

	<TextView   /*添加图片到activty中*/
    android:id="@+id/list"  /*修改路径*/
    android:layout_width="wrap_content"  
    android:layout_height="wrap_content"  
    android:drawableTop="@drawable/ic_launcher"  
    android:text="hello_world" />  

④添加完组建后,需要对其布局样式进行调整:

	android:text="Soft1614080902436#989" //设置文本
	android:layout_width="" //设置组件宽度
    android:layout_height=""//设置组件高度
    android:textSize="" //设置文本大小

⑤实验截图,并编写实验报告
⑥使用git提交本次作业:
	git add *
	git commit -m "#3#989"
	git push

## 3.实验结果

![image](https://github.com/310341802/android-labs-2018/blob/master/soft1614080902436/L3.JPG)
## 4.实验体会
这次实验老师的进度非常的快,于是我上网查了相关代码,并解决很多软件的问题才完成该次实验,虽然耗费了许多的时间;
但是掌握了更多的代码,如修改文本等指令;