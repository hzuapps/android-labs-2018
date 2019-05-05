## 一、实验目的
1.	掌握Android网络访问方法；

2.	理解XML和JSON表示数据的方法。
## 二、实验设备与环境
操作系统：Windows 7；开发工具：Java 7、Android Studio 2等。
## 三、实验要求
1.	从网络下载一个文件（图片、MP3、MP4）；

2.	保存到手机，在应用中使用文件；

3.	将应用运行结果截图。

## 四、实验内容、程序清单及运行结果
实验步骤:

1.先修改AndroidManifest.xml获取相关的权限

2.在activity_soft1614080902140_cover.xml添加两个组件Button用于下载图片，EditText用于输入图片地址。并将imageview的功能作为显示下载的图片的地方

3.在Soft1614080902140CoverActivity中初始化组件，new一个Handler用于在子线程中更新UI，给下载图片的Button添加监听器，写一个子线程下载图片资源

4.使用Git将代码提交到自己的库里

实验截图：

![image](https://github.com/czwly/android-labs-2018/blob/master/Soft1614080902140/%E5%AE%9E%E9%AA%8C%E5%85%AD.jpg)

## 五、实验体会
通过这次实验，我学习到了Android网络编程的应用。对线程有了一定的了解，学会了使用Handler解决线程和线程之间的通信。
