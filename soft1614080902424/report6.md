# 第六次实验

## 1.实验目标

(1)掌握Android网络访问方法；

(2)理解XML和JSON表示数据的方法。

## 2.实验内容
(1)从网络下载一个文件（图片、MP3、MP4）；

(2)保存到手机，在应用中使用文件；

(3)将应用运行结果截图。

## 3.实验步骤
（1）在github中创建一个后缀名为json的文件，然后在其中编写自己要用到的数据。我设置了两个，因为分为寄件人和收件人。

（2）在Android studio中打开项目，然后在项目3和4中设置对应的json。

（3）编写代码，引用json方法，通过方法使前面在github中输入的数据放入到对应的界面选项中，注意每个界面id的不同。

（4）将文件放入到手机中进行运行，可以显示出github中的内容。相当于寄件人和收件人不用设置。直接点开就可以自动显示。

## 3.实验结果

![image](https://github.com/Zhaohongh/android-labs-2018/blob/master/soft1614080902424/%E5%AE%9E%E9%AA%8C6-%E7%BD%91%E7%BB%9C%E5%AF%84%E4%BB%B6%E7%95%8C%E9%9D%A2.png)

![image](https://github.com/Zhaohongh/android-labs-2018/blob/master/soft1614080902424/%E5%AE%9E%E9%AA%8C6-%E7%BD%91%E7%BB%9C%E6%8F%90%E4%BA%A4%E7%95%8C%E9%9D%A2.png)

![image](https://github.com/Zhaohongh/android-labs-2018/blob/master/soft1614080902424/%E5%AE%9E%E9%AA%8C6-%E7%BD%91%E7%BB%9C%E6%94%B6%E4%BB%B6%E7%95%8C%E9%9D%A2.png)

## 4.实验体会
在这一次的实验中，学会了如何在github中添加json文件，首先格式需要对应，即对应的id要一致，这样才可以读取。然后通过在android studio中，添加相对应的
引用json的方法，之后通过这种方法，可以将github中的内容显示在app对应的界面上，刚开始编写起来的时候比较费力，后面了解后就相对比较容易了。现在主要是spinner
不知道应该如何通过网络进行引用，同时如何保存所选择的spinner数据。
