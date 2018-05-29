# 1.实验目的
掌握Android网络访问方法；
# 2.实验内容
1.从网络下载一个文件（图片、MP3、MP4）；

2.保存到手机，在应用中使用文件；

3.将应用运行结果截图。
# 3.实验步骤
首先，所要下载的是微信抢红包的界面，主要修改的是页面三，即主要修改有activity_jinru.xml和Jinru.java；

同时，为了有上网权限，在AndroidManifest.xml添加对应代码<uses-permission android:name="android.permission.INTERNET" />获许权限；
在activity_jinru.xml中添加EditText用于用户填写所要下载的网址，或默认使用已填好的网址；在“加载抢红包页面”的按钮添加一个监听；
添加一个新的子线程Thread t=new Thread()，用于下载图片；添加String iPath=EditText.getText().toString()用于获得下载路径；

在drawable中的ic_launcher_background.xml进行修改，添加动态的加载圆圈，并没有实际用途，让用户有更好的体验；
在Jinru.java多加两个按钮，分别为button_close、button_close1，分别用于返回页面1、返回页面2。
# 4.实验结果
![](https://github.com/Mrwuwu12138/android-labs-2018/blob/master/soft1614080902220/20180524131105.jpg)
![](https://github.com/Mrwuwu12138/android-labs-2018/blob/master/soft1614080902220/201805241312892.jpg)
# 5.实验体会
总的来说，通过这次实验，在网上、向同学学到了不少的知识，了解基本的Android网络访问方法，同时了解要在AndroidManifest.xml添加对应代码获许权限才能上网；还有学会简单的
添加动态加载圆圈，以后争取完善其功能，对页面的布局更加熟悉！
