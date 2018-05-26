# 第六次实验

## 1.实验目标

 掌握Android网络访问方法

## 2.实验内容

（1）在个人目录中创建一个表示数据的XML或JSON文件

（2）数据文件代码提交之后从GitHub获取文件URL

（3）在应用中通过网络编程访问GitHub的数据文件

（4）在应用中解析并显示文件所包含的数据；

（5）将应用运行结果截图。

## 3.实验步骤

1、在自己的Github库中创建一个JSON数据文件

2、在子线程中新建一个URL对象，使用url.openConnection()去访问URL，获得请求

3、使用输入流去读取请求的数据

4、解析JSON，通过键取得对应的值

5、用for循环判断输入的值是否与课时相等，如：sr.equals(time[i])，相等则输出，并用break退出循环，反之，则继续循环

6、返回主线程去更新UI

## 4.实验结果

![](https://github.com/hzulinzr/android-labs-2018/blob/master/soft1614080902212/png6.1.png)

![](https://github.com/hzulinzr/android-labs-2018/blob/master/soft1614080902212/png6.2.png)

## 5.实验体会

这次实验,最困扰我的时判断time与输入的值相等后显示的东西，由于一开始用==，导致总是显示不出自己想要的东西，直到用了equal才得出自己要的结果。而在获取JSON和解析JSON方法的时候，基本没遇到什么问题，同时在网上查了一些资料后，成功的做出了这次的实验。