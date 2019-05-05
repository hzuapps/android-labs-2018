# 第五次实验
 ## 一.实验目的
 
 掌握在Android App中存储数据
 
 ## 二.实验内容
 
 根据选题要求使用文件存储
 
 将应用产生的数据保存到文件存储中；
 说明使用的文件存储方式：内部 or 外部；
 将运行结果截图。
 
 ## 三.实验步骤
 
 1.在activity_second.xml中设置两个Button，并设置好相关信息。

 2.在secondActivity.java加入按钮监听，点击按钮保存数据调用方法save，读取信息为raed。
 
 3.用openFileOutput、OutputStreamWriter、BufferedWriter，其中的write等方法实现save方法的数据储存。
 
 4.用FileInputStream、openFileInput和其中的read等方法实现read方法的数据读取。
 
 5.使用Toast.makeText通知保存数据成功和读取文件数据。
 
 6.运行代码截图并用git上交相关文件。
 
 ## 四.实验截图
 
![image](https://github.com/BoliChen/android-labs-2018/blob/master/com1614080901106/jt5-1.png)
![image](https://github.com/BoliChen/android-labs-2018/blob/master/com1614080901106/jt5-2.png)
 
 ## 五.实验体会
 
 通过这次实验了解了Android的存储方式实现，也初略了解了各种存储方式的不同。这次实验感觉难度较大，参考了很多东西，花了好多时间才完成，
 最后总算是实现了简单的数据存储与读取。
