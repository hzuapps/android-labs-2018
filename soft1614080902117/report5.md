# 第五次实验

## 一、实验目标

掌握在Android App中存储数据

## 二、实验内容

使用文件存储

1.将应用产生的数据保存到文件存储中；

2.说明使用的文件存储方式：内部 or 外部；

3.将运行结果截图。

## 三、实验步骤
1.选用内容部存储的方式来存取；

2.在主界面Soft1614080902117Activity中添加文件读取函数public String load();
  将读取的文件内容转换成字符串赋给字符串数字adapterData，再添加到listview的item中，
  每一次返回主界面都会读取一次文件；
  
3.在编辑界面Soft1614080902117Activity1中添加文件存储函数public void save
  (String inputText);主要是将editText中输入的文本转换为字符串赋给inputText，并
  传入save函数中，进行文件保存；通过点击√（保存）按钮进行保存并跳转回主界面，点击×则
  放弃修改且返回主界面；
  
## 四、实验截图
编辑
![image](https://github.com/1614080902117/android-labs-2018/blob/master/soft1614080902117/shiyan5.1.png)
保存
![image](https://github.com/1614080902117/android-labs-2018/blob/master/soft1614080902117/shiyan5.2.png)

## 五、实验体会
  本次实验是了解使用Android App中存储数据的方式，在实验过程中确实是不太懂得这些存储方式的具体
  是如何实现的，只能通过参考已经实现的代码进行修改来完成自己的课题，本来想用数据库实现的，但是
  过程中出现了很多错误最后只能选用内部存储暂时实现存储，数据库的存储还在自己摸索当中。
