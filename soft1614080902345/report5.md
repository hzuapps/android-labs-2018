# 第五次实验 

## 1、实验要求 
1.掌握在Android App中存储数据
2.将应用产生的数据保存到存储文件中。
3.说明使用的文件存储方式为内部or外部

## 2、实验步骤 
1.创建一个新Activity为兼职界面，在主Activity添加按钮监听以跳转到发布兼职界面。

2.在发布兼职界面中设计好布局内容，设置fabu函数把输入的数据存放到文件JZmessage中。

3.提交res/values, res/layout等其他代码；

4.将应用运行结果截图，放到实验报告中；



## 3、实验结果 
我的Android应用第一个activity截图。

![在Android SDK Manager中选择6.0库](https://raw.githubusercontent.com/chinesehope/android-labs-2018/master/soft1614080902345/%E5%AE%9E%E9%AA%8C5%E6%88%AA%E5%9B%BE1.jpg "配置教育网下载代理")

点击按钮后跳转的发布兼职页面activity.

![在Android SDK Manager中选择6.0库](https://raw.githubusercontent.com/chinesehope/android-labs-2018/master/soft1614080902345/%E5%AE%9E%E9%AA%8C5%E6%88%AA%E5%9B%BE2.jpg "配置教育网下载代理")

输入信息后的页面情况。

![在Android SDK Manager中选择6.0库](https://raw.githubusercontent.com/chinesehope/android-labs-2018/master/soft1614080902345/%E5%AE%9E%E9%AA%8C5%E6%88%AA%E5%9B%BE3.jpg "配置教育网下载代理")

点击发布按钮查看在activity中实现的提示框功能。显示功能正常

![在Android SDK Manager中选择6.0库](https://raw.githubusercontent.com/chinesehope/android-labs-2018/master/soft1614080902345/%E5%AE%9E%E9%AA%8C5%E6%88%AA%E5%9B%BE4.jpg "配置教育网下载代理")

查询数据有无存入文件中。

![在Android SDK Manager中选择6.0库](https://raw.githubusercontent.com/chinesehope/android-labs-2018/master/soft1614080902345/%E5%AE%9E%E9%AA%8C5%E6%88%AA%E5%9B%BE5.jpg "配置教育网下载代理")

## 4、实验体会 
1. 这个实验的布局其实有多种方法，可以采用内部存储也就是我这种方法，也可以采用数据库SQlite存储，也可以用文件存储。
2. 这个实验主要是通过SharedPreferences方法来实现的，用他的editor函数进行数据的写入，editor来提交，每次的写入都要commit一次不然没有效果。
3.学会用Toast.makeText函数实现提示框功能，增强APP可用性。
