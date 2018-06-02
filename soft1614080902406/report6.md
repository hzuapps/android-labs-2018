# 第六次实验 

## 1. 实验目标
### 1.掌握Android网络访问方法；
### 2.理解XML和JSON表示数据的方法。


## 2.实验内容
### 1.从网络下载一个文件（图片、MP3、MP4）；
### 2.保存到手机，在应用中使用文件；
### 3.将应用运行结果截图。


## 3. 实验步骤
### 1.在主Activity添加按钮监听以跳转到下载界面。
### 2.在AndroidManifest.xml中添加网络权限。
### 3.使用Handler发送接收Message。
### 4.添加Thread子线程下载图片。
### 5.设置好界面，包含下载按钮、输入框、图片显示。
### 6.运行截图。

## 4. 实验结果

![结果](https://github.com/SurvivorC/android-labs-2018/blob/master/soft1614080902406/Androiddemo6-1.png)
### 输入图片网址
![结果](https://github.com/SurvivorC/android-labs-2018/blob/master/soft1614080902406/Androiddemo6-2.png)

## 5. 实验体会

**本次实验首先要获得网络权限，要在AndroidManifest文件中添加INTERNET等权限。下载图片需要耗时，若把下载写在主线程，主线程就会在下载完毕后才继续，
就会造成卡顿，卡顿时间过长系统还会抛出ANR异常，所以我们要把下载写在子线程，其他需要耗时的操作也应该写在子线程中。**
