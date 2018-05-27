# 第6次实验报告

## 1.实验目标

（1）在个人目录中创建一个表示数据的XML或JSON文件；

（2）数据文件代码提交之后从GitHub获取文件URL；

（3）在应用中通过网络编程访问GitHub的数据文件；

（4）在应用中解析并显示文件所包含的数据；

（5）将应用运行结果截图。

## 2.实验步骤

（1）用json在线编辑器，编写一个json文件，然后上传到自己github上的库

（2）创建一个新的Activity,通过url获取json,再建立parseJson函数对json解析

（3）在AndroidManifest.xml添加对应代码获取网络权限

（4）改写了一个按钮控件，使点击后，能将页面跳转至解析了json的页面

（5）运行程序并截图，使用git将代码提交到自己的库里
 
（6）在GitHub中使用Markdown文件编写实验报告（report6.md)

## 3.实验结果
![image](https://github.com/BlueDuper/android-labs-2018/blob/master/com1614080901207/six.png)


## 4.实验体会
由于不了解JSON的格式，所以在网上找了JSON在线编辑器编写JSON文件，上传了JSON文件后，在获取JSON的ｕｒｌ上，遇到了一些问题，直接复制了网址，但是一直运行不出结果，请教了同学，最后找到了一个简单的方法，点击进入JSON文件后，在右上角的点击ｒａｗ，就能得到该文件地址。还有重要的一点，就是要记住获取网络权限。通过这次实验，了解到如何访问网络，在AndroidManifest.xml添加网络权限，如何解析JSON的代码，收获很大。
