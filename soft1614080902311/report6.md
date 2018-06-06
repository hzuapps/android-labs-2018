#第六次实验
##1.实验目标

1.掌握Android网络访问方法；

2.理解XML和JSON表示数据的方法。

##2.实验内容

1.从网络下载一个文件（图片、MP3、MP4）；

2.保存到手机，在应用中使用文件；

3.将应用运行结果截图。

##3.实验步骤

1.在java/edu.hzu.take_out文件下新建InternetActivity.java代码

2.在layout中新添activity4布局 其中有三个控件 输入框et_url 下载按钮 btn_download 和 预览视图 iv_resources

3.在InterneiActivity中增加handler 方法（用来查看预览视图） 声明三个控件并监听btn_dowanload的点击事件

4.用输入输出流和线程定义文件的写入

##4.实验结果

![在Android SDK Manager中选择6.0库](https://github.com/lazytea/android-labs-2018/blob/77a84c35446de292b8be5528762f2f3994140784/soft1614080902311/test6.jpg "配置教育网下载代理")

##5.实验心得

实验六综合运用了实验一到实验五的知识。

线程的使用和handler的继承是实验六的重点。