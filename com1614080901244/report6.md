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

  （1）选做了第一个题目。在百度上找json在线编辑器，然后编写一个json文件，编写完下载到本地。
  
  （2）然后把json文件提交到自己github上的库中 

  （3）然后在Android studio 上创建一个新的Activity,从github获取json文件URL,再建立parseJson函数对json解析 

  （4）在AndroidManifest.xml添加对应代码获取网络权限 

  （5）在第一个activity 中加一个按钮控件，使点击后，能将页面跳转至解析了json的页面上

  （6）运行程序并截图，使用git将代码和截图提交到自己的库里 

  （7）在GitHub中使用Markdown文件编写实验报告（report6.md)  

## 四.实验结果 

![image](https://github.com/xiamilin/android-labs-2018/blob/master/com1614080901244/实验6图片.jpg) 

## 五.实验体会 

做这个实验时，由于对json 不了解，不知道json要去哪里写，后来听别人说有在线编辑器可以写。然后就根据实验六的实验内容做这次实验。在此途中，遇到了些问题，我改完代码后，运行发下R报错，可是，R是它自己生成的，我并没有动到它。之后我重新写了三四次，最后发现是我的代码写错地方了。我建的是basic activity，
layout中有activity_main.xml和content_main.xml。activity_main主要负责的是包含toolbar的整个页面布局，其中，使用了一个<include/>标签把content_main放进activity_main布局中。改完后，运行。发现无法单个运行我新建的这个activity。后来百度了下，才发现，Android studio在第一个activity才会自动配置<intent-filter>
，其他的如果要单个运行，需要在mainfest中配置<intent-filter>。如果不要的话，就要在第一个activity中，加个按钮控件让它跳转至解析json的页面上。最后我直接加了个按钮让它跳转。成功运行了，截图如上所示。总之，这次实验，我学到了挺多东西的。
