# 第六次实验报告

## 1. 实验目标：android网络编程

1. 阅读实验要求：https://github.com/hzuapps/android-labs-2018/labels/Lab   

2. 在电脑上Android Studio编写代码  

3.选择完成实验二 下载图片文件到本地并显示

4. 使用Git将代码提交到自己的库中：https://github.com/Demanding/android-labs-2018   

## 2.实验步骤
    1.在最新的安卓中，主线程不能够用来发送网络请求
    所以要在主线程创建消息处理器handler用来接收子线程发来的消息
    2.new一个url存放了图片下载地址的对象，用HttpURLConnection连接并发送http请求
    3.用返回的statuscode判断网络请求是否成功，成功则用message告诉主线程并请求显示图片
    4.更新imageview
    5.manifest中设置Internet权限为允许，不然安卓无法连接到网络

## 3. 实验结果

![在Android SDK Manager中选择6.0库](https://github.com/Demanding/android-labs-2018/blob/master/Soft1614080902422/%236.1.png "配置教育网下载代理")
![在Android SDK Manager中选择6.0库](https://github.com/Demanding/android-labs-2018/blob/master/Soft1614080902422/%236.2.png "配置教育网下载代理")
![在Android SDK Manager中选择6.0库](https://github.com/Demanding/android-labs-2018/blob/master/Soft1614080902422/%236.3.png "配置教育网下载代理")
![在Android SDK Manager中选择6.0库](https://github.com/Demanding/android-labs-2018/blob/master/Soft1614080902422/%236.4.png "配置教育网下载代理")
## 4. 实验体会
这次实验我学会了从网络下载图片到本地，这次实验遇到了很多坑，因为选择从网络上下载图片到本地有很多方法，但我选择了使用HttpURLConnection方法，因为这个方法
就是基于http请求的，在安卓中创建网络请求要在子线程中，因为主线程要接受操作者的响应，不可能一直等待网络从而阻塞，同时要显示图片，要在xml中设置好imageview
同时要记得在manifest中声明Internet权限，像我就是在这里浪费了很多时间。
