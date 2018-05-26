# 实验六实验报告

## 实验目的

### 1、Android网络编程

## 实验要求

### 1、掌握Android网络访问方法；

### 2、理解XML和JSON表示数据的方法。

## 实验内容一（选做一）

### 1、在个人目录中创建一个表示数据的XML或JSON文件；

### 2、数据文件代码提交之后从GitHub获取文件URL；

### 3、在应用中通过网络编程访问GitHub的数据文件；

### 4、在应用中解析并显示文件所包含的数据；

### 5、将应用运行结果截图。

## 实验内容二（选做二）

### 1、从网络下载一个文件（图片、MP3、MP4）；

### 2、保存到手机，在应用中使用文件；

### 3、将应用运行结果截图。

## 实验步骤

### 1、阅读实验要求：https://github.com/hzuapps/android-labs-2018/labels/Lab；

### 2、在电脑上Android Studio编写代码

#### ①、运行Android studio；

#### ②、创建一个新的Activity：Soft1614080902440Activity3.java;

#### ③、在activity3_soft1614080902440.xml中添加一个TextView控件（用于查看存储获得的数据）、一个ListView控件（用于查看解析后的数据）、两个Button控件（用于获得数据和解析数据）和四个EditText控件（用于显示属性名）；

#### ④、在Soft1614080902440Activity3.java中对两个Button添加监听器、获取json文件函数、解析json文件函数和获取并解析json文件函数（注意要在子线程中进行）；

#### ⑤、在两个监听器中分别调用获取json文件函数和获取并解析json文件函数；

#### ⑥、在activity3_soft1614080902440.xml中添加多一个Button控件（用于跳转），在Soft1614080902440Activity2.java中对这个Button添加跳转到Soft1614080902440Activity3.java的监听器。

### 3、使用Git将代码提交到自己的库中：https://github.com/HHuangF/android-labs-2018；
       $ git pull
       $ git add soft1614080902440/*  
       $ git commit "#6 #991 第六次实验 "
       $ git push
### 4、在自己的GitHub库上创建和发送Pull Request；
       
### 5、在GitHub中使用Markdown文件编写实验报告（report6.md）；

## 实验结果

![运行截图](https://github.com/HHuangF/android-labs-2018/blob/master/soft1614080902440/Sixth/Soft1614080902440png1.png)

### 获取json文件数据

![运行截图](https://github.com/HHuangF/android-labs-2018/blob/master/soft1614080902440/Sixth/Soft1614080902440png2.png)

### 解析json文件数据

![运行截图](https://github.com/HHuangF/android-labs-2018/blob/master/soft1614080902440/Sixth/Soft1614080902440png3.png)


## 实验体会

### 这次实验主要的难点在与解析json文件并显示出来和UI的更新，刚开始很多次都是获取到了json文件，却无法解析并显示文件；通过这次是让我了解到了网络编程解析json文件的四种方法（JSONObject、Gson、JackSon、Fastjson）和网络编程的功能。
