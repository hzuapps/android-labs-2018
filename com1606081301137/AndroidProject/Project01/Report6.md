# 实验6：Android网络编程

## 1. 实验内容

1.从网络下载一个文件（图片、MP3、MP4）；<br>

2.保存到手机，在应用中使用文件；<br>

3.将应用运行结果截图。<br>

## 2. 实验步骤

1.首先创建`Download`和`Jump`来实现图片的下载和一个跳转，并创建对应的xml文件，添加控件。<br>

2.并从`Jump`新建一个按钮”下载“，实现跳转到`Download`,并将TexView记录的图片网址传给`Download`。<br>

3.在`Download`实现接收网址并且从网上下载图片的功能。<br>

4.给`AndroidManifest.xml`添加联网权限。<br>

## 3. 实验结果

![image](https://raw.githubusercontent.com/ChaShu618/android-labs-2018/master/com1606081301137/AndroidProject/Project01/E601.png)<br>

![image](https://raw.githubusercontent.com/ChaShu618/android-labs-2018/master/com1606081301137/AndroidProject/Project01/E602.png)<br>

![image](https://raw.githubusercontent.com/ChaShu618/android-labs-2018/master/com1606081301137/AndroidProject/Project01/E603.png)<br>

## 4. 实验体会

我做的issue好像不怎么需要用到网络编程，所以新建了一个下载图片的功能，最后还是直接去实现一个点击按钮显示图片。关键点在于需要重新打开一个线程。

