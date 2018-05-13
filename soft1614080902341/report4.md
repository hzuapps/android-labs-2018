## 1.实验目标
  掌握在Android应用中使用图片等资源的方法。 
## 2.实验步骤 
 （1）在实验三的基础上应用RelativeLayout,设置剪刀按钮与图片从顶部对齐，相差130pd.代码为：
 
 
        android:id="@+id/but_one"
        android:text="剪刀"
        android:layout_alignTop="@+id/textview_01"
        android:layout_marginTop="130dp"。
 
 （2）设置三个按钮之间有一定的间距，也是用顶部对齐的方式
 
        android:id="@+id/but_tow"
        android:text="石头"
        android:layout_alignTop="@+id/but_one"
        android:layout_marginTop="65dp"。 
 
 （3）改写原来的监听器的函数，改用创建内部类的方式建立监听，实现按钮的点击事件。 
 
 （4) 设置监听函数，用switch语句，判断对应的id为按钮几，分三个按钮打开不同的Activity。 
 
 （5）用github提交，完成实验。 
 
## 3.实验结果  
###3.1打开界面改变
![界面图]( https://github.com/linliyuan/android-labs-2018/blob/c764b1c593e0bad42c7610d7402b9176b59140c2/soft1614080902341/4.1.png)
###3.2实现弹出Activity
  ![弹出图]( https://github.com/linliyuan/android-labs-2018/blob/c764b1c593e0bad42c7610d7402b9176b59140c2/soft1614080902341/4.2.png) 

## 4.实验体会
 本次实验认识了几种布局的不同与巧妙之处，初次是用默认的相对布局，采用与父组件的相对位置定义，实现各组件的位置排版。同时学会了用内部类实现点击事件的方法。相对比较简单，基本按书中的知识基本可以解决