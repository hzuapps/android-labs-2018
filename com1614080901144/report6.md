# 第6次实验报告 

## 一.实验目标 

  （1）掌握Android网络访问方法；

  （2）理解XML和JSON表示数据的方法。
 
 ## 二.实验内容（选做了第一个） 
 
  （1）在个人目录中创建一个表示数据的XML或JSON文件； 

  （2）数据文件代码提交之后从GitHub获取文件URL； 

  （3）在应用中通过网络编程访问GitHub的数据文件； 

  （4）在应用中解析并显示文件所包含的数据；

  （5）将应用运行结果截图。 

## 三.实验步骤 

  （1）通过网上的json在线编辑器，然后编写一个json文件，编写完下载到本地。
  
  （2）然后把json文件提交到自己github上的库中 

  （3）然后在Android studio 上创建一个新的Activity,从github获取json文件URL,再通过BufferedReader对服务器的流进行读取，再调用函数进行json解析。

  （4）在AndroidManifest.xml添加对应代码获取网络权限 

  （6）运行程序并截图，使用git将代码和截图提交到自己的库里 

  （7）在GitHub中使用Markdown文件编写实验报告（report6.md)  
  
  （8）create new pull request

## 3.实验结果 

![image](https://github.com/1614080901144/android-labs-2018/blob/master/com1614080901144/%E5%AE%9E%E9%AA%8C6%E6%88%AA%E5%9B%BE.PNG) 
![image](https://github.com/1614080901144/android-labs-2018/blob/master/com1614080901144/%E5%AE%9E%E9%AA%8C6%E6%88%AA%E5%9B%BE%20(2).PNG)
## 4.实验体会 
  这个实验主要考验我们对网络权限的理解，和对json解析的理解，通过这次实验，我把json解析这方面的内容了解了一遍，加深了我的印象。而实验过程遇到的问题就是json文件的格式没写好，
  导致无法获取，出现了403错误，最后解决之后，就可以运行了。
