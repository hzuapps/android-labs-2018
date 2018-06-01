实验6
一、实验目的
+ 掌握Android网络访问方法。

二、实验内容
+ 从网络下载一个文件（图片、MP3、MP4）； 保存到手机，在应用中使用文件； 将应用运行结果截图。

三、实验步骤
+ 往AndroidManifest.xml中添加的代码获取相关的权限。
+ 选择布局模式，添加按钮控件和图片区域。
+ 写线程进行获取url，输入输出，并且完成下载。

四、实验截图
+ ![image](https://github.com/uzi-up/android-labs-2018/blob/master/soft1614080902401/%E5%AE%9E%E9%AA%8C6/%E5%BE%AE%E4%BF%A1%E5%9B%BE%E7%89%87_20180601140816.png)
+ ![image](https://github.com/uzi-up/android-labs-2018/blob/master/soft1614080902401/%E5%AE%9E%E9%AA%8C6/%E5%BE%AE%E4%BF%A1%E5%9B%BE%E7%89%87_20180601140825.jpg)

五、实验体会
   本次实验填完代码后，发现应用一点击下载按钮就闪退，反复调试了很久，都还是一样。后来网上搜索才知道AndroidManifest.xml需要进行授权，才把问题完美解决了。
