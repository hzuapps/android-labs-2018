## 一.实验目的

掌握Android网络访问方法；
 
## 二.实验内容

从网络下载一个文件（图片、MP3、MP4）；

保存到手机，在应用中使用文件；

将应用运行结果截图。

## 三.实验步骤

1.从网上获得图片路径

2.通过openstream从网络下载，返回Inputstream类型

3.用BitmapFactory.decodeStream将inputstream转化为bitmap

4.用handler设置imageview

5.最后像实验5一样把图片储存

## 四.实验截图

![](https://github.com/SuperLikeMe/android-labs-2018/blob/master/soft1614080902316/385965654441939004.jpg)

## 五.实验体会
本次实验知道了如何通过网络路径下载图片，核心为openStream下载并返回 InputStream类型。
