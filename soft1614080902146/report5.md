# 第五次实验

 ## 1.实验目标
 ### 1.掌握在Android App中存储数据。
 ## 2.实验内容
 ### 1.将应用产生的数据存储到数据库中；
 ### 2.使用UML类图描述表结构；
 ### 3.将应用运行结果截图。
 ## 3.实验步骤 
 ### 1.新建MyDatabaseHelper类，准备新建数据库；
 ### 2.在名为Add的Activity中建立MyDatabaseHelper类的对象，并初始化数据库；
 ### 3.在Add中分别为两个EditText添加addTextChangedListener,监听EditText并存到Str1、Str2；
 ### 4.在Add中为按钮添加点击事件，进行数据的插入；
 ### 6.监听Search中的文本 5.在名为Search的Activity中同样建立MyDatabaseHelper类的对象并初始化；
 
 ## 4.实验结果
 ### ![image]https://github.com/ZhuHongen/android-labs-2018/blob/master/soft1614080902146/jieg51.JPG
 ### !image[]https://github.com/ZhuHongen/android-labs-2018/blob/master/soft1614080902146/jieg52.JPG
 ### ![image]https://github.com/ZhuHongen/android-labs-2018/blob/master/soft1614080902146/jieg3.JPG
 ## 5.实验体会
 ### 这次实验在建立数据库的时候并未遇到太大问题，但建表并插入内容后由于不能直观地查看数据库内的内容，而且对Coursor类的用法又不太清楚，所以在显示查询结果的时候总是运行失败。经过查询网上的资料后，APP基本上能正常地进行保存和读取数据的工作，但由于时间关系，更新和删除功能仍未添加到APP中，这些功能将会在平时有空的时候写进APP里。
