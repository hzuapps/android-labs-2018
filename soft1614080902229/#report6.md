实验六

一.实验目的

掌握Android网络访问方法

二.实验内容

在个人目录中创建一个表示数据的XML或JSON文件
数据文件代码提交之后从GitHub获取文件URL
在应用中通过网络编程访问GitHub的数据文件
在应用中解析并显示文件所包含的数据；
将应用运行结果截图。

三、实验步骤

*在自己的Github库中创建一个JSON数据文件
*在子线程中新建一个URL对象，使用url.openConnection()去访问URL，获得请求
*使用输入流去读取请求的数据（也就是JSON的数据类型转换成String）
*解析JSON，通过键取得对应的值，添加到数据类型ArrayList中
*返回主线程去更新UI
*调试运行程序。

*提交res/drawable以及两个Activity的.java文件以及xml布局文件等文件到github 仓库中，并编写实验报告。

*res/drawable以及两个Activity的.java文件以及xml布局文件等文件到github 仓库中：https://github.com/LJolon/android-labs-2018

 
  
  $ git add soft1614080902229
  
  $ git commit "#6 #10 第6次实验"
  
  $ git push

然后在自己的GitHub库上创建和发送Pull Request

四、实验截图

![](https://github.com/LJolon/android-labs-2018/blob/a903d697d8e0280d918c14ae6fe00fc9899101e5/soft1614080902229/shiyan6/实验6截图1.png)

![](https://github.com/LJolon/android-labs-2018/blob/a903d697d8e0280d918c14ae6fe00fc9899101e5/soft1614080902229/shiyan6/实验6截图2.png)

 五、实验体会

这次实验是第六次试验，这次的实验主要是需要我们学习如何连接.json文件，这一开始对于我来说难度比较大，但是经过询问同学以及百度后，最终完成了实验。
