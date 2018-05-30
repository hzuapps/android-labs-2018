# 第四次实验
 
 ## 1.实验目标
1、根据自己的选题要求设计界面布局及控件使用；
2、布局xml及界面控制操作代码提交并截图；
3、将应用运行结果截图。
 
 ## 2.实验步骤及实验截图
 1、上次的实验是一个activity跳转到另一个activity，这次依旧要用到这个方法，首先保留上次的实验代码soft1614080902444activity中的代码，点击其图标：
 ![截图](https://github.com/linxin666/android-labs-2018/blob/5ea5e03a7ff42f90bd6096b2eca86b9c07bb1971/soft1614080902444/4_1.png)
 后可跳转到菜单界面的activity
 ![截图](https://github.com/linxin666/android-labs-2018/blob/5ea5e03a7ff42f90bd6096b2eca86b9c07bb1971/soft1614080902444/4_2.png)
 
 ## 3.实验体会
 这次实验开始还是遇到很多的困难，不过后来通过网上查找资料后还是一步一步慢慢解决了。
 </p>1、首先是布局，开始时都不懂，后来才知道可以在xml中，用android:orientation="vertical"使其垂直分布。然后在Textview中的 android:text=""输入文字
 后面则接上一个button
 设置好button的id，这样就完成了第一个界面的布局。
 </p>2、然后还需要在.java的代码中响应button的事件仔细分析。
 获取button的id，然后再用上次实验学的intent方法实现跳转。
 </p>3、在信息界面中，用了TableLayout布局的方法， android:stretchColumns="1"是表示下面的<TableRow>所占屏幕的的大小，而<TableRow>下面的
<TextView>则是每一行中文本，当 <TableRow>下面有两个<TextView>时，一行就有两个文本，以此类推。
</p>总之，这次的实验还是学到了很多很多值得学习的东西。


