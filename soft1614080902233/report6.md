# 第六次实验

## 1.实验目标

掌握Android网络访问方法

## 2.实验内容

（1）在个人目录中创建一个表示数据的XML或JSON文件

（2）数据文件代码提交之后从GitHub获取文件URL

（3）在应用中通过网络编程访问GitHub的数据文件

（4）在应用中解析并显示文件所包含的数据；

（5）将应用运行结果截图。

## 2.实验步骤

（1）打开已建好的项目soft1614080902233。

（2）在自己的Github库中创建两个JSON数据文件（information.json和information2.json）。

（3）在开辟一个子线程中并新建一个URL对象，使用url.openConnection()去访问URL，使用输入流去获得json上的数据转换成String类。

（4）解析JSON，通过键取得对应的值，添加到数据类型ArrayList中，然后返回主线程去更新UI。

（5）按照标题进行功能修改，完成并运行成功。

（6）用git上交。

## 3.实验结果

![image](https://github.com/liaohuajjj/android-labs-2018/blob/master/soft1614080902233/shiyan6/t6_1.png)

![image](https://github.com/liaohuajjj/android-labs-2018/blob/master/soft1614080902233/shiyan6/t6_2.png)

## 4.实验体会

通过这次实验懂得了一些用URL及相关语法进行git文件内容的下载，还学会了一些解析json用键取值的方法，和学会了一些线程之间改变。