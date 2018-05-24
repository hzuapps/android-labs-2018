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
1、在自己的Github库中创建一个JSON数据文件<br>
2、在子线程中新建一个URL对象，使用url.openConnection()去访问URL，获得请求<br>
3、使用输入流去读取请求的数据（也就是JSON的数据类型转换成String）<br>
4、解析JSON，通过键取得对应的值，添加到数据类型ArrayList中<br>
5、返回主线程去更新UI<br>

四、实验截图
-
![](https://github.com/zglx/android-labs-2018/blob/master/soft1614080902231/r6.png)

四、实验体会
-
这次实验获取JSON和解析JSON方法不难，就是更新UI有点困难，因为刚开始不知道子线程如果用来更新UI会造成程序终止，百度后，使用 runOnUiThread返回主线程后就可以了
