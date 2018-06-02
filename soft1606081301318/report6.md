### 实验六

## 一.实验目的

掌握Android网络访问方法；

## 二.实验内容

从网络下载一个文件（图片、MP3、MP4）；
保存到手机，在应用中使用文件；
将应用运行结果截图。

## 三.实验步骤

1.先修改AndroidManifest.xml获取相关的权限
```
<uses-permission android:name="android.permission.INTERNET" />
```

2.使用okhttp库进行网络请求的处理，包括知乎日报的不同http api请求的处理

3.使用AsyncTask异步进行网络图片的获取，在doInBackground方法中执行图片的下载

4.将图片的数据流保存图片到本地做缓存，以便下一次省流量使用

6.上传自己的代码到github并且发送Pull Reques.


## 四.实验截图

![image](https://raw.githubusercontent.com/0r2dev/android-labs-2018/master/soft1606081301318/screenshot4_1.png)

![image](https://raw.githubusercontent.com/0r2dev/android-labs-2018/master/soft1606081301318/screenshot4_2.png)

## 五.实验体会

通过这次实验使我更加熟悉Android 开发中的网络请求的运用，包括同步和异步