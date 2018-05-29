# 第三次实验

## 1.实验目标

 （1） 掌握在Android应用中使用图片等资源的方法。

 （2）在界面上显示至少一张图片（按照自己的题目添加）；

 （3）提交res/drawable及图片使用的代码；

 （4）提交res/values, res/layout等其他代码；

  （5）将应用运行结果截图，放到实验报告中；

  （6）点击图片（或按钮）时，打开另一个Activity。

## 2.实验步骤

（1）阅读实验要求：https://github.com/hzuapps/android-labs-2018/labels/Lab

（2）在电脑上Android Studio编写代码
    
（3）使用Git将代码提交到自己的库中：https://github.com/xiamilin/android-labs-2018

    $ git add d/xiamilin/com1614080901244/*

    $ git commit -m "#3 第三次实验"

    $ git push

（4）在自己的GitHub库上创建和发送Pull Request（注意查看Changed files）

（5）在GitHub中使用Markdown文件编写实验报告（report3.md）

## 3.实验结果

打开APP后，出现下面的图片

![image](https://github.com/xiamilin/android-labs-2018/blob/master/com1614080901244/tupian1.png)

之后按下左上角的按钮，会跳到secondActivity里去。在那里会显示出下面的这个界面

![image](https://github.com/xiamilin/android-labs-2018/blob/master/com1614080901244/tupian2.png)

## 4.实验体会

本次实验，我知道了要怎么插入图片，怎么设置按钮及跳转。刚开始的时候，我都不知道这个实验是干啥，迟迟做不出来。后来看了几个人完成的作业和他们的图片，我才知道原来是做个图片的插入和页和页面间的跳转的实现。

由于我的题材跟别人重了，所以我换成了“美食分享”，所以我在做这次实验时，把AndroidManifest.xml中的label改成了我现在的课题名字。

然后把我选好的照片放入main中的rec中的drawable里面。 

然后就回到Android Studio 中，打开里面的content_com1614080901244.xml，查看图片，按大小对图片进行改动。并把activity_com1614080901244.xml里面的代码中的android:drawableTop="@drawable/meishi"/写入自己的图片名(meishi)。 

图片就这样弄好了。然后要实现页面间的跳转，首先需要至少两个activity。

开始创建第二个activity。在这第二个activity里面我要让它出现“欢迎使用”的字眼，我就在content_second.xml中添加个text的代码。

然后要实现两个activity之间的跳转，用到了按钮，我在activity_com1614080901244.xml中添加了以下的代码。

<Button android:text="打开app"
        android:id="@+id/my_button"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:textSize="20sp"
        android:layout_alignParentBottom="true"
        android:layout_centerHorizontal="true"
        /> 

然后在要使得两个activity能够进行跳转，在第一个activity按下按钮后要产生事件：跳到第二个activity。所以在第一个activity：Com1614080901244Activity.java 中要有onClick()方法。

通过这个实验，我对安卓有了更近一步的认识。
