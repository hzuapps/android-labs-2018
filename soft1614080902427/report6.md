## 实验目标

1. 掌握Android网络访问方法；
2. 理解XML和JSON表示数据的方法。

## 实验内容（选做一）

1. 在个人目录中创建一个表示数据的XML或JSON文件；
2. 数据文件代码提交之后从GitHub获取文件URL；
3. 在应用中通过网络编程访问GitHub的数据文件；
4. 在应用中解析并显示文件所包含的数据；
5. 将应用运行结果截图。

## 实验内容（选做一）

1. 从网络下载一个文件（图片、MP3、MP4）；
2. 保存到手机，在应用中使用文件；
3. 将应用运行结果截图。


## 实验步骤

1. 分析：歌单文件用JSON方式存放在github上（https://raw.githubusercontent.com/harytfw/android-labs-2018/master/soft1614080902427/song.json）
  在APP中用GSON库解析JSON，获得歌曲的mp3文件名，然后与网站域名拼接，得到歌曲的下载链接：https://raw.githubusercontent.com/harytfw/android-labs-2018/master/soft1614080902427/%E4%B9%9D%E9%BE%99%E8%B5%9E.mp3
  
2. 因为与下载文件有关的网络操作不能放在APP的主线程中，所以新建一个 [Downloader](https://github.com/harytfw/android-labs-2018/blob/master/soft1614080902427/java/edu/hzuapps/androidlabs/soft1614080902427/Downloader.java)类

用来实例化AsyncTask，进行后台的网络操作。创建一个 DownloaderListener 类实现简单的监听器功能，监听下载完成和下载错误的后续操作

3. 根据实际需求，给 SongItem 添加一个类型是String mp3 的属性.

4. 下载的mp3文件可以先保存到内存中， 也就是写入到 ByteArrayOutputStream 中，等下载完整个mp3文件后，在写入手机存储中。减少对手机性能的影响

5. URL链接中不能直接存放中文字符和某些特定字符（空格），所以需要进行URL编码，不然直接出错。我们可以利用Android自带的Uri库对url编码

## 实验结果

![](https://github.com/harytfw/android-labs-2018/blob/master/soft1614080902427/screenshot1.png)
![](https://github.com/harytfw/android-labs-2018/blob/master/soft1614080902427/screenshot2.png)
![](https://github.com/harytfw/android-labs-2018/blob/master/soft1614080902427/screenshot3.png)

## 实验心得

AsyncTask类的泛型类型对应着 doInBackground 参数的类型，onProgressUpdate 参数的类型，doInBackground 返回的参数类型
这是从StackOverflow：https://stackoverflow.com/questions/9671546/asynctask-android-example 复制下来的图片
![](https://github.com/harytfw/android-labs-2018/blob/master/soft1614080902427/I23KW.png)

因为使用到了网络权限，那么一定要在 AndroidManifest.xml 里声明对应的网络权限，否则无法访问网络
