实验六
=
一.实验目的
-
掌握Android网络访问方法<br>
  
二.实验内容
-
在个人目录中创建一个表示数据的XML或JSON文件<br>
数据文件代码提交之后从GitHub获取文件URL<br>
在应用中通过网络编程访问GitHub的数据文件<br>
在应用中解析并显示文件所包含的数据；<br>
将应用运行结果截图。<br>

三、实验步骤
-
*在自己的Github库中创建一个JSON数据文件<br>
*在子线程中新建一个URL对象，使用url.openConnection()去访问URL，获得请求<br>
*使用输入流去读取请求的数据（也就是JSON的数据类型转换成String）<br>
*解析JSON，通过键取得对应的值，添加到数据类型ArrayList中<br>
*返回主线程去更新UI<br>
*调试运行程序。<br>

*提交res/drawable以及两个Activity的.java文件以及xml布局文件等文件到github 仓库中，并编写实验报告。<br>

*res/drawable以及两个Activity的.java文件以及xml布局文件等文件到github 仓库中：https://github.com/mvp-szf/android-labs-2018
  
      $ git pull origin master
      
      $ git add soft1614080902238(git rm 学号目录/*)
      
      $ git commit "#6 # 963 第6次实验"
      
      $ git push

*在自己的GitHub库上创建和发送Pull Request（注意查看Changed files）<br>

四、实验截图
-
![](https://github.com/mvp-szf/android-labs-2018/blob/master/soft1614080902238/xg/sy61.png)
![](https://github.com/mvp-szf/android-labs-2018/blob/master/soft1614080902238/xg/sy62.png)
![](https://github.com/mvp-szf/android-labs-2018/blob/master/soft1614080902238/xg/sy63.png)
五、实验体会
-
这次实验获取JSON和解析JSON方法不难，我觉得主要难度在于将读出的json
文件显示在Activity中，一开始，我设置的位置不合理，导致在显示屏上看
不到读取的文件，一开始以为没读取成功，后来调了下显示的位置，就成功了。

  
