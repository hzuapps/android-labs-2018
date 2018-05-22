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
1.创建一个HttpUtil.java类，里面有一个静态方法sendOkHttpRequest来发送OkHttp请求.<br>
2.在Activity5中调用HttpUtil.sendOkHttpRequest方法，传入参数address(json数据源地址),和实现Callback回调类.<br>
3.在onResponse中用JSONArray解析接收到的json数据.<br>
4.最后用runOnUiThread回到主线程更新UI，实现网络排行榜.<br>

四.实验截图
-
![](https://github.com/yangyangyang2017/android-labs-2018/blob/master/soft1614080902221/%E7%AC%AC%E5%85%AD%E6%AC%A1%E5%AE%9E%E9%AA%8C%E6%88%AA%E5%9B%BE.gif)

五.实验体会
-
1.这次实验比较简单,从自己github库中获取json并解析。要注意的是不能在子线程中更新UI，要调用runOnUiThread方法。<br>
