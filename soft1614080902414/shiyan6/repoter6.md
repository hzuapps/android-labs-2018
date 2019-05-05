## 一.实验目的

掌握Android网络访问方法；
 
## 二.实验内容

从网络下载一个文件（图片、MP3、MP4）；

保存到手机，在应用中使用文件；

将应用运行结果截图。

## 三.实验步骤

1.先创建一个新的Activity去负责下载图片；

2.先创建按钮，并为之加一个监听器启动线程负责下载图片；通过openstream从网络下载，返回的是Inputstream类型；

3.然后使用的是BitmapFactory.decodeStream使得inputstream转化为bitmap；

4.最后使用handler来设置设置imageview；

5.安装到手机上，运行程序是否可以进行图片的下载，然后截图

## 四.实验截图

![](https://github.com/haoxinchen/android-labs-2018/blob/master/soft1614080902414/shiyan6/%E5%BE%AE%E4%BF%A1%E5%9B%BE%E7%89%87_20180527220841.png)

## 五.实验体会
这次实验涉及到如何网络路径下载图片，一开始不是很明白从什么地方下手，查了一些资料后，开始着手，但是一直运行失败，后来改了下线程的格式，安装就成功了。
实验的重点是如何使用openStream下载并返回 InputStream类型，这一点是需要多次操作才可以熟练运用在其他软件上的，是个很好的知识点。
