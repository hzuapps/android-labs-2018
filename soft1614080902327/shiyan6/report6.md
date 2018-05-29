#实验六
##一.实验目的

掌握Android网络访问方法；
##二.实验内容

###从网络下载一个文件（图片、MP3、MP4）；
###保存到手机，在应用中使用文件；
###将应用运行结果截图。

##三.实验步骤

###1.先修改AndroidManifest.xml获取相关的权限
###2.写一个工具类imgUtils，调用它可以保存图片到本地相册.
###3.开辟线程下载图片,将图片转换成位图送给imageView,调用requestPermission获取权限，通过后调用saveImage保存图片到本地相册.
###4.使用下载按钮获取URL的图片，点击保存保存图片到本地
###5.使用Git将代码提交到自己的库中：https://github.com/getcharyanch/android-labs-2018
###6.在GitHub中使用Markdown文件编写实验报告（report6.md）.
###7.在自己的GitHub库上创建和发送Pull Request（注意查看Changed files）.

##四.实验截图
![screen](https://raw.githubusercontent.com/getcharyanch/android-labs-2018/10644f1e407f2c630cc594a1b57ff20c977f2194/soft1614080902327/shiyan6/%236-1.png)
![screen](https://raw.githubusercontent.com/getcharyanch/android-labs-2018/10644f1e407f2c630cc594a1b57ff20c977f2194/soft1614080902327/shiyan6/%236-2.png)
![screen](https://raw.githubusercontent.com/getcharyanch/android-labs-2018/10644f1e407f2c630cc594a1b57ff20c977f2194/soft1614080902327/shiyan6/%236-3.png)
![screen](https://raw.githubusercontent.com/getcharyanch/android-labs-2018/10644f1e407f2c630cc594a1b57ff20c977f2194/soft1614080902327/shiyan6/%236-4.png)

##五.实验体会

本次叫以往实验难度有所增加，我通过这次实验更加熟悉git和android studio,为App加一个menu，利用线程获取URL进而获取网上的资源文件。
