#第六次实验

##一、实验目的

掌握Android网络访问方法

##二、实验内容

在个人目录中创建一个表示数据的XML或JSON文件
数据文件代码提交之后从GitHub获取文件URL
在应用中通过网络编程访问GitHub的数据文件
在应用中解析并显示文件所包含的数据；
将应用运行结果截图。

##三、实验步骤

1、在自己的Github库中创建一个JSON数据文件

2、在子线程中新建一个URL对象，使用url.openConnection()去访问URL，获得请求

3、使用输入流去读取请求的数据（也就是JSON的数据类型转换成String）

4、解析JSON，通过键取得对应的值，添加到数据类型ArrayList中

5、返回主线程去更新UI

https://github.com/huangzip/android-labs-2018；
   $ git pull
   $ git add soft1614080902128/*  
   $ git commit "#6 #959 简易课程表 "
   $ git push
   
4、在自己的GitHub库上创建和发送Pull Request；

5、在GitHub中使用Markdown文件编写实验报告（report6.md）

##四、实验截图
![在Android SDK Manager中选择6.0库](https://github.com/huangzip/android-labs-2018/blob/master/soft1614080902128/act6.png"配置教育网下载代理")
![在Android SDK Manager中选择6.0库](https://github.com/huangzip/android-labs-2018/blob/master/soft1614080902128/act7.png"配置教育网下载代理")

##五、实验体会

获取和解析JSON方法不难，但更新UI有点困难，若子线程用来更新UI会造成程序终止，可以使用 runOnUiThread返回主线程解决这个问题
