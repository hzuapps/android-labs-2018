第六次实验报告

Android网络编程

一、实验步骤

1、动态加载网络图片

和 WebView 一样，加载网络图片也需要网络访问权限：
    <uses-permission android:name="android.permission.INTERNET" />
    
2、载入图片的原理：根据图片地址获取图片，并将图片由文件流转换为位图对象。

载入图片的过程必须进行异步处理，否则就很容易出现程序无响应（Application Not Responding）的情况。
创建一个 LoadImagesTask 类，继承自 AsyncTask：

3、最后在 Main1Activity 中进行测试

二、实验结果
![](https://github.com/LaineChen/android-labs-2018/blob/master/com1614080901225/6.png)

三、实验体会
这一次实验采用Android 本地加载网页&显示网络图片，通过从网络下载一个图片，保存到手机，在应用中使用文件。
第一次接触应用网络编程来加载网络图片，一开始不知道该怎么弄，通过查找资料和咨询同学，弄出了简单的图片加载。
