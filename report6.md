# 第六次实验
## 实验目标
### 1掌握Android网络访问方法；
### 2理解XML和JSON表示数据的方法。
## 实验内容
### 1从网络下载一个文件（图片、MP3、MP4）；
### 2保存到手机，在应用中使用文件；
### 3将应用运行结果截图。
## 实验步骤
### 建立一个Download的类，用private String imgPath=""获取需要下载的网址，用ImageView mImageView定义可以使得获取的照片在本地显示，还需要用URL来读取到网站地址，开启连接。
### 完成了Download这个类后，再将主类创建一个button跳转，点击button可以跳到Download，button本文改为“下载图片”。运行结果如下:
 ![截图](https://raw.githubusercontent.com/First-lin/android-labs-2018/ba8b2d2b26e272bcede2b4950ef71143c7ef2ce1/soft1614080902431/%E7%AC%AC%E5%85%AD%E6%AC%A1%E5%AE%9E%E9%AA%8C1.jpg)
 ![截图](https://raw.githubusercontent.com/First-lin/android-labs-2018/ba8b2d2b26e272bcede2b4950ef71143c7ef2ce1/soft1614080902431/%E7%AC%AC%E5%85%AD%E6%AC%A1%E5%AE%9E%E9%AA%8C2.jpg)
### 点击下载网络图片后跳转到第二个下载后的图片。
## 实验体会
### 这次实验相对于以往的较为难，需要获取网址然后再将获取后下载的文件保存在本地，然后再显示出来，主要是要学会对ImageView，和URL的运用。
