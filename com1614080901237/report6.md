## 1.实验要求  
掌握Android网络访问方法；   
## 2.实验内容  
从网络下载一个文件（图片、MP3、MP4）；  
保存到手机，在应用中使用文件；  
将应用运行结果截图。  
## 3.实验步骤
(1).先修改AndroidManifest.xml获取相关的权限；  
(2).在主界面的xml中再多加一个下载的按钮；  
(3).在建一个用于下载的fourthActivity，并在xml文件中加一个输入框用于获取url，还有一个下载按钮，最后就是用于显示图片的框
## 4.实验结果    
![image](https://github.com/Cai-ZT/android-labs-2018/blob/master/com1614080901237/shiyan6-1.png)   
![image](https://github.com/Cai-ZT/android-labs-2018/blob/master/com1614080901237/shiyan6-2.png)
![image](https://github.com/Cai-ZT/android-labs-2018/blob/master/com1614080901237/shiyan6-3.png)

## 5.实验体会  

这次实验我利用了线程下载图片资源文件，在下载的Activity.java文件中利用输入流、输出流来完成。这次实验比较难，查找了解网上关于网络编程的内容，而且有参考了不是通过的同学的例子，收获了不少。
