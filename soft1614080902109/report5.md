
# 第五次实验

## 一、实验目标

掌握在Android App中存储数据

## 二、实验内容

使用文件存储

1.将应用产生的数据保存到文件存储中；

2.说明使用的文件存储方式：内部 or 外部；

3.将运行结果截图。

## 三、实验步骤
1.选用内部存储的方式来存取；

2.创建对应的几个按钮还有相关监听器的实现，布局采用的是线性布局

3.在TestActivity.java中编写readPrefs函数实现读取数据和编写save函数实现保存数据的相关代码

4.编译运行成功后截图，并且通过git 发到github库上去，然后在提交
  
## 四、实验截图
在应用上写一个保存文本的页面：
![image](https://github.com/GhostITS/android-labs-2018/blob/master/soft1614080902109/%E5%AE%9E%E9%AA%8C%E4%BA%94%E6%88%AA%E5%9B%BE1.png?raw=true)
按照文件名以文本的方式读取文件：
![image](https://github.com/GhostITS/android-labs-2018/blob/master/soft1614080902109/%E5%AE%9E%E9%AA%8C%E4%BA%94%E6%88%AA%E5%9B%BE2.png?raw=true)

## 五、实验体会
 这次的实验内容是文件存储，简单的尝试了文件类的使用，过程中遇到了空指针异常，问题的成因是我是在fragment上使用文件类的而不是在activity使用文件类。本次实验初步了解了
 文件储存的编程。
