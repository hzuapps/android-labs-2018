# 第六次实验

## 实验目的
  1、掌握Android网络访问方法；
  2、理解XML和JSON表示数据的方法。
  
## 实验内容
  1、从网络下载一个文件（图片、MP3、MP4）；
  2、保存到手机，在应用中使用文件；
  3、将应用运行结果截图。
  
## 实验结果
  运行app：
  ![在Android SDK Manager中配置教育网下载代理](https://github.com/sawthesunset44times/android-labs-2018/blob/master/soft1614080902433/%E5%AE%9E%E9%AA%8C6-1.png?raw=true "配置教育网下载代理")
  点击下载按钮：
  ![在Android SDK Manager中配置教育网下载代理](https://github.com/sawthesunset44times/android-labs-2018/blob/master/soft1614080902433/%E5%AE%9E%E9%AA%8C6-2.png?raw=true "配置教育网下载代理")
## 实验结论
    这次实验涉及到网络访问的方法，个人感觉比较难，但是在同学的指导下有了些许的理解。
    首先要在显示图片的Activity中再增加一个EditText文本框为了输入地址，因为在模拟器中输入地址比较麻烦，因此直接把地址复制到了text中。
    然后在增加一个带有监听器的按钮，点击按钮即可以下载图片显示到ImageView里面。
    最后是最难也是最重要的：在java文件写上有关网络连接的代码，写完代码后，就能通过网络下载图片。
