实验六
=
一.实验目的
-
掌握Android网络访问方法；
  
二.实验内容
-
在个人目录中创建一个表示数据的XML或JSON文件；<br>
数据文件代码提交之后从GitHub获取文件URL；<br>
在应用中通过网络编程访问GitHub的数据文件；<br>
在应用中解析并显示文件所包含的数据；<br>
将应用运行结果截图。<br>

三.实验步骤
-
1.创建一个HttpUtil.java类，里面有一个静态方法sendOkHttpRequest、execute()方法发送OkHttp请求并获取服务器返回的数据.<br>
2.在Activity4中调用HttpUtil.sendOkHttpRequest方法，传入参数url(json数据源地址),和实现Callback回调类.<br>
3.在得到了服务器返回的数据传入到一个JSONArray对象中，然后调用parseJSONObject()方法解析数据.<br>

四.实验截图
-
![](https://github.com/xuguh/android-labs-2018/blob/master/soft1614080902226/Soft1614080902226Activity/jietu6.png)

五.实验体会
-
1.这次实验感觉比较难,要从github库中获取json并解析。大部分都是参考相关书籍与查找网上资料，还有很多应该学习和进步的空间，可以做得更好。<br>
