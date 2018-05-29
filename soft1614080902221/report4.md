实验四
=
一.实验目的
-
1.根据选题要求设计界面布局及控件使用；<br>
2.布局xml及界面控制操作代码提交并截图；<br>
3.将应用运行结果截图。<br>
  
二.实验要求
-
1.使用一种布局方式，设计所选题目的界面：<br>
2.通过控件ID获取界面对象，执行相关操作：<br>
3.实现界面控件的事件处理，例如点击按钮：<br>

三.实验步骤
-
1.布局选用LinearLayout方式；<br>
2.选用EditText组件，id为edText1实现输入玩家的名称；<br>
3.选用RadioGroup组件，id为sex_rg选择玩家性别；<br>
4.选用RadioGroup组件，id为gameCharacters选择游戏角色<br>
5.选用TextView组件，id为text2实现输出选择的结果<br>
6.嵌套一个LinearLayout里面有两个Button,实现“确定”和“重置”<br>
7.最后一个id为goButton的按钮，准备实现跳到下一个activity<br>
8.在JAVA代码中，绑定一个监听器到“确定”按钮，当被点击时检测输入的玩家名称是否为空，如果“是”就调用id为text2的setText方法设置玩家选择的结果,如果“否”，用     Toast.makeText方法提示错误。<br>
9.绑定一个监听器到“重置”按钮，当被点击时，清空玩家输入的内容，还原默认选择。

四.实验截图
-
初始界面:
-
![screen](https://github.com/yangyangyang2017/android-labs-2018/blob/master/soft1614080902221/%E7%AC%AC4%E6%AC%A1%E5%AE%9E%E9%AA%8C%E6%88%AA%E5%9B%BE1.png)

不输入玩家名称直接点确定:
-
![screen](https://github.com/yangyangyang2017/android-labs-2018/blob/master/soft1614080902221/%E7%AC%AC4%E6%AC%A1%E5%AE%9E%E9%AA%8C%E6%88%AA%E5%9B%BE2.png)

正常输入名称选择性别和角色点确定:
-
![](https://github.com/yangyangyang2017/android-labs-2018/blob/master/soft1614080902221/%E7%AC%AC4%E6%AC%A1%E5%AE%9E%E9%AA%8C%E6%88%AA%E5%9B%BE3.png)

然后点重置按钮:
-
![](https://github.com/yangyangyang2017/android-labs-2018/blob/master/soft1614080902221/%E7%AC%AC4%E6%AC%A1%E5%AE%9E%E9%AA%8C%E6%88%AA%E5%9B%BE4.png)


五.实验体会
-
1.学会了LinearLayout布局和单选按钮，布局之间可以嵌套使用。
