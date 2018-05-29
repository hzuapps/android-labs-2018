# 第四次实验
 
 ## 1.实验目标
1、根据自己的选题要求设计界面布局及控件使用；
2、布局xml及界面控制操作代码提交并截图；
3、将应用运行结果截图。
 
 ## 2.实验步骤及实验截图
 1、上次的实验是一个activity跳转到另一个activity，这次依旧要用到这个方法，首先保留上次的实验代码soft1614080902431activity中的代码，点击其图标：
 ![截图](https://raw.githubusercontent.com/First-lin/android-labs-2018/master/soft1614080902431/应用图标界面soft1614080902431Activity.png)
 后可跳转到菜单界面的activitie也就是InterfaceActivity中：
 ![截图](https://raw.githubusercontent.com/First-lin/android-labs-2018/master/soft1614080902431/菜单选择界面InterfaceActivity.png)
 2、此时有三个选择，当点击第一个选项查看信息时，则跳转到Main2Activity：
  ![截图](https://raw.githubusercontent.com/First-lin/android-labs-2018/master/soft1614080902431/查看信息界面Main2Activity.png)
  点击第二个选项发信息时，则跳转到SendActivity：
   ![截图](https://raw.githubusercontent.com/First-lin/android-labs-2018/master/soft1614080902431/输入信息界面SendActivity.png)
   输入信息后：
   ![截图](https://raw.githubusercontent.com/First-lin/android-labs-2018/master/soft1614080902431/输入信息后截图SendActivity.png)
   当点击退出时，则退出当前应用。
 ## 3.实验体会
 这次实验开始还是遇到很多的困难，不过后来通过网上查找资料后还是一步一步慢慢解决了。
 </p>1、首先是布局，开始时都不懂，后来才知道可以在activity_interface.xml中，用android:orientation="vertical"使其垂直分布。然后在Textview中的 android:text=""输入文字
 后面则接上一个button
 设置好button的id，这样就完成了第一个界面的布局。
 </p>2、然后还需要在InterfaceActivity.java的代码中响应button的事件，先定义一个bt_call：Button bt_call = (Button) findViewById(R.id.bt1)
 获取button的id，然后再用上次实验学的intent方法实现跳转。
 </p>3、在信息界面中，用了TableLayout布局的方法， android:stretchColumns="1"是表示下面的<TableRow>所占屏幕的的大小，而<TableRow>下面的
<TextView>则是每一行中文本，当 <TableRow>下面有两个<TextView>时，一行就有两个文本，以此类推。
</p>4 、在activity_send.xml中，用了EditText， android:text="输入..."是提示的隐藏文本， android:inputType="date"是虚拟键盘，这个xml可以显示我们需要发送的
输入的信息。
</p>总之，这次的实验还是有很多值得学习的东西，后面还需慢慢的深入研究
