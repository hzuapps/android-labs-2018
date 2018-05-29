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
 ### 5.在名为Search的Activity中同样建立MyDatabaseHelper类的对象并初始化；
 ### 6.监听Search中的文本框，并将文本框中的内容赋值到str；
 ### 7.通过query()进行数据库内的查询；
 ### 8.将查询的结果通过intent传送到新建的名为ShowSearch的Activity中并跳转到ShowSearch；
 ### 9.接收从Search中传来的字符串并显示先前所查询的内容。
 ## 4.实验结果
 ### ![image](https://raw.githubusercontent.com/zhaokangye/android-labs-2018/master/soft1613071002201/%E5%AE%9E%E9%AA%8C%E4%BA%94%E6%88%AA%E5%9B%BE/upload.png) 
 ### ![image](https://raw.githubusercontent.com/zhaokangye/android-labs-2018/master/soft1613071002201/%E5%AE%9E%E9%AA%8C%E4%BA%94%E6%88%AA%E5%9B%BE/Search.png) 
 ## 5.实验体会
 ### 这次实验在建立数据库的时候并未遇到太大问题，但建表并插入内容后由于不能直观地查看数据库内的内容，而且对Coursor类的用法又不太清楚，所以在显示查询结果的时候总是运行失败。经过查询网上的资料后，APP基本上能正常地进行保存和读取数据的工作，但由于时间关系，更新和删除功能仍未添加到APP中，这些功能将会在平时有空的时候写进APP里。
