# 第三次实验 

## 1. 实验目的
掌握在Android应用中使用图片等资源的方法。
## 2. 实验步骤
1、加button控件实现跳转
（1）打开之前实验写好的Android程序，在activity_soft1614080902325.xml写一个button

    <Button
        android:id="@+id/textview_01"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:text="查看个人信息"
        android:textSize="25sp"
        android:layout_centerInParent="true"
（2）新建一个Activity，名为personalInformationActivity，先不对新的Activity做任何改动，然后在Soft1614080902325Activity中先声明button，然后写上实现跳转的代码

实现跳转的代码如下：

        textview_01 = findViewById(R.id.textview_01);
        textview_01.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //跳转到个人信息页面
                Intent intent = new Intent(Soft1614080902325Activity.this,personalInformationActivity.class); 
                startActivity(intent);
            }
        });
2、实现图片显示
（1）在res/drawable文件夹中放入图片，命名为huibiao
（2）在新建personalInformationActivity的时候AndroidStudio自动生成的activity_personal_information.xml中写一个TextView

        <TextView
        android:id="@+id/huibiao"
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:drawableTop="@drawable/huibiao"
        android:text="hello_world" />

## 3. 实验结果

![在Android SDK](https://github.com/li763407418/android-labs-2018/blob/master/soft1614080902325/3.1.png)

![在Android SDK](https://github.com/li763407418/android-labs-2018/blob/master/soft1614080902325/3.2.png)


## 4. 实验体会
我先解释一下我为什么这么迟才交这个实验，首先是因为我的手机是iPhone...实验室中的电脑也没有装安卓虚拟机，
而我的电脑运行AndroidStudio的时候内存占到50%，当运行AVD安卓虚拟机的时候上到了90%直接就卡死了...然后我
尝试去网上下载安卓模拟器（用夜神模拟器也差不多到80%但是还能用），下载了一个夜神模拟器，运行发现程序运
行不了，随后我看了一下夜神模拟器的安卓版本是4点几的，而我的程序是基于5.0开发的，我以为是版本问题，遂去
百度如何改API，胡乱改了一通发现还是不能运行，那我只能还是用AndroidStudio的AVD，在关掉我电脑其它的程序
只留下AndroidStudio，运行AVD，勉强能运行，发现还是不能运行程序，最后我只能重新再新建一个Android程序，重
新写代码，发现确实有些地方有问题，改回来后，终于能运行了....实在不容易。

**加粗**常规
