# 第六次实验  

## 一.实验目的  

1.掌握Android网络访问方法    

2.理解XML和JSON表示数据的方法    

## 二.实验要求  

1.从网络下载一个文件   

2.保存到手机，在应用中使用文件    

3.将应用运行结果截图   

## 三.实验步骤    
  
1.首先在AndroidManifest.xml中添加能够写入读出内存空间权限和网络连接权限的代码  

2.在SecondActivity.java中，通过创建线程和使用文件输入输出流来下载网络图片，新建一个按钮触发线程  

3.在secondactivity.xml中，新建文本框来显示下载链接，点击更换壁纸后，用一个ImageView框来显示下载的图片  

4.编译运行后，git push提交  

## 四.实验结果  

第一个截图：  

![image](https://github.com/TokisakiRin/android-labs-2018/blob/master/soft1614080902421/experiment6_1.png)  

第二个截图：    

![image](https://github.com/TokisakiRin/android-labs-2018/blob/master/soft1614080902421/experiment6_2.png)  

## 六.实验体会  

做完后在测试阶段，程序总是抛出java.io.FileNotFoundException异常，查找了很久才找到解决方法，在填写文件的路径时一定要具体到文件。通过本次实验，我加深了存储编程的印象，更加熟悉了对文件输入输出流的操作；简单认识了怎样在安卓上获取网络上的资源，并保存在本地空间；顺便复习了java中线程的用法。
