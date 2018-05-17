# 实验五
## 一.实验目的

掌握在Android App中存储数据

## 二.实验内容

根据选题要求使用文件存储

将应用产生的数据保存到文件存储中；
说明使用的文件存储方式：内部 or 外部；
将运行结果截图。

## 三.实验步骤

1.android存储数据有多种，在这里我选择用SharedPreferences实现内部存储。

2.首先在soft1614080902119management_Fragment中创建并得到SharedPreferences对象，调用SharedPreferences对象的edit()方法来获取一个SharedPreferences.Editor对象。

3.向SharedPreferences.Editor对象中添加数据管理界面中的各个EditText控件所输入的数值。

4.调用commit方法将添加的数据提交保存。

5.保存后在soft1614080902119query_Fragment中用SharedPreferences中的setText()方法，把前面存储的数据显示在Activity_query.xml中的各个控件中。

6.使用Git将代码提交到自己的库中：https://github.com/MaZongXin/android-labs-2018

   $ git pull origin master<br>
   $ git add com16114080902119<br>
   $ git commit "#5 #885 第5次实验"<br>
   $ git push<br>

7.在GitHub中使用Markdown文件编写实验报告（report5.md）.
8.在自己的GitHub库上创建和发送Pull Request（注意查看Changed files）.
## 四.实验截图

运行首页：
记账管理界面
![image](https://github.com/MaZongXin/android-labs-2018/blob/master/soft1614080902119/5picture1.jpg)
账务查询界面
![image](https://github.com/MaZongXin/android-labs-2018/blob/master/soft1614080902119/5picture2.png)
输入数据并点击保存
![image](https://github.com/MaZongXin/android-labs-2018/blob/master/soft1614080902119/5picture3.png)
进入财务查询界面查看
![image](https://github.com/MaZongXin/android-labs-2018/blob/master/soft1614080902119/5picture4.png)
点击清零
![image](https://github.com/MaZongXin/android-labs-2018/blob/master/soft1614080902119/5picture5.jpg)

## 五.实验体会

通过这次实验我更加熟悉android studio 一些控件的使用，并成功实现了android 简单的数据存储和显示，以及在本次实验中我，还加入了一个数据清除的选项，当想还原初始化数据时即可点击清零实现数据还原。。
