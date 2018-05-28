# 第六次实验

## 一、实验目的
1.掌握Android网络访问方法；<br>

## 二、实验内容
1.从网络下载一个文件（图片、MP3、MP4）<br>
2.保存到手机，在应用中使用文件<br>
3.将应用运行结果截图<br>


## 三、实验步骤
1.先修改AndroidManifest.xml获取相关的权限<br>
在AndroidManifest.xml-</manifest>中加入实验6指导书中有关网络通讯uses-permission的设置代码段<br>

2.xml部分EditText用于获取图片的url地址<br>
添加Button用于添加监听通过url地址下载图片
ImageView用于显示下载好的图片

3.开启子线程t进行获取url内容，输入输出，下载图片完成

## 四、实验截图
![image](https://github.com/lin1472/android-labs-2018/blob/master/soft1614080902437/实验六截图一.png)<br>
![image](https://github.com/lin1472/android-labs-2018/blob/master/soft1614080902437/实验六截图二.png)<br>
![image](https://github.com/lin1472/android-labs-2018/blob/master/soft1614080902437/实验六截图三.png)<br>

## 五、实验体会
这次的实验有点难度，需要在AndroidManifest.xml中设置连接网络，修改内容获取相关的权限才能上网和修改权限，获取网上的资源文件。这次Android网络的访问主要是调用其start启动运行线程从网络上下载图片保存，然后进行图片解码，使图片显示出来。



