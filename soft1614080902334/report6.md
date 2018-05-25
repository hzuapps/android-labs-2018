# 第六次实验 

## 1. 实验目标
1. 掌握Android网络访问方法;    
2. 理解XML和JSON表示数据的方法。

## 2. 实验要求
1. 在个人目录中创建一个表示数据的XML或JSON文件；
2. 数据文件代码提交之后从GitHub获取文件URL；
3. 在应用中通过网络编程访问GitHub的数据文件；
4. 在应用中解析并显示文件所包含的数据；
5. 将应用运行结果截图。

## 3. 实验步骤
1.  首先再自己github库的目录下创建一个`weather_info.json`文件，根据自己的题目内容创建。
2.  新建`LatestWeatherInfoActivity`，实例化`HttpURLConnection`对象并调用`openConnection()`方法获取到请求。  
    注意：需要在`AndroidManifest.xml`下添加：（以获取网络访问权限）
```
    <uses-permission android:name="android.permission.INTERNET" />
    <uses-permission android:name="android.permission.WRITE_EXTERNAL_STORAGE" />
    <uses-permission android:name="android.permission.ACCESS_WIFI_STATE" />
    <uses-permission android:name="android.permission.CHANGE_WIFI_STATE" />
    <uses-permission android:name="android.permission.CHANGE_NETWORK_STATE" />
    <uses-permission android:name="android.permission.ACCESS_NETWORK_STATE" /> 
```
3.  使用相应的`IO流`将JSON格式转为字符串。   
4.  调用`parseJson()`方法用`JSONArray`遍历解析JSON，添加到列表数组中。
5.  最后需要实现Activity内部的方法`runOnUiThread()`返回主线程更新UI.
6.  检查好预览效果，整理好界面的布局以及控件的位置。最好用虚拟机运行即可。
7.  使用Git将代码提交到自己的库中：
>$ git pull <br>
>$ git add 学号目录/* <br>
>$ git commit "#12345678 "<br>
>$ git push <br>
8.  编辑实验报告，然后将项目目录一并pull给老师;



## 4. 实验结果
我的截图：<br><br>
![This is a gif...](https://github.com/neptuneman/android-labs-2018/blob/master/soft1614080902334/lab6_weather_info.gif "我的截图")

## 5. 实验体会
1.  实验难度不大，知道了获取JSON和解析JSON的方法。
2.  刚开始弄好后，发现不能成功获取JSON数据，后来发现是没开网络权限...
3.  必须调用runOnUiThread方法返回主线程更新UI。
4.  对IDE的运用有进步。期待下一节的内容。
