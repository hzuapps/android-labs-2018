# 第六次实验

## 一、实验目的
1、掌握Android网络访问方法；<br>
2、理解XML和JSON表示数据的方法。<br>

## 二、实验内容
1、在个人目录中创建一个表示数据JSON文件；<br>
2、数据文件代码提交之后从GitHub获取文件URL；<br>
3、在应用中通过网络编程访问GitHub的数据文件；<br>
4、在应用中解析并显示文件所包含的数据；<br>
5、将应用运行结果截图。<br>

## 三、实验步骤
1、在github上创建myjson.json文件<br>
2、在主页增加查看广告的按钮，实现监听<br>
3、增加一个Advertactivity用于处理显示json数据<br>
4、运行程序，截图<br>

## 四、实验截图
![image](https://github.com/linwt/android-labs-2018/blob/master/soft1614080902318/main.png)<br>
![image](https://github.com/linwt/android-labs-2018/blob/master/soft1614080902318/advert.png)<br>

## 五、实验体会
此次试验有点难度，首先需要在AndroidManifest.xml中设置连接网络，在获取json数据过程中会报错Value of type java.lang.String cannot be converted to JSONObject，原因是utf-8的bom头引起的，需要去掉"\ufeff"，最终完成实验。





