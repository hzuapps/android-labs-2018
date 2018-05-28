# 实验目标

    掌握在Android App中存储数据

## 一、实验内容
    选择实验内容一（选做1个）

    根据选题要求使用文件存储

    将应用产生的数据保存到文件存储中；
    说明使用的文件存储方式：内部 or 外部；
    将运行结果截图。
## 二、实验步骤
###    1、新建一个activity来记录并显示分数；
###    2、在game页面添加一个保存分数的按钮和跳转排行榜的textview；
###    3、创建data保存数据
###    4、把对应的分数数据显示在排行榜中的textview中

## 三、实验结果
输入5，按下“=”
![image](https://github.com/szayd/android-labs-2018/blob/master/com1614080901133/%E5%AE%9E%E9%AA%8C%E4%BA%941.png)
按下“记录”按钮
![image](https://github.com/szayd/android-labs-2018/blob/master/com1614080901133/%E5%AE%9E%E9%AA%8C%E4%BA%942.png)
## 四、实验心得体会
    本次实验有点困难，刚开始不知道在哪下手，一开始是打算用SQLite来完成，但是一直碰到各种问题，百度了很久还是感觉比较困难，
    参考了一下同学们的作业，采用了SharedPreferences存储数据，这个方法比较简单，利用对应的KEY存储和读取value便可完成存储数据。
    本次实验主要还是对数据库不够熟悉，相信以后的实验会越做越好。
