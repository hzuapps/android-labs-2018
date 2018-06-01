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

1. 分析：新闻文件用JSON方式存放在github上（https://github.com/wsgtl/android-labs-2018/blob/master/soft1614080902408/myNews.json）
  在APP中用GSON库解析JSON，获得新闻的字符串。

2. URL链接中不能直接存放中文字符和某些特定字符（空格），所以需要进行URL编码，不然直接出错。我们可以利用Android自带的Uri库对url编码

## 实验结果

![](https://github.com/wsgtl/android-labs-2018/blob/master/soft1614080902408/picture/实验六.1.png)
![](https://github.com/wsgtl/android-labs-2018/blob/master/soft1614080902408/picture/实验六.2.png)


## 实验心得

这次的实验难度还是比较大，主要是我之前的数组都是在本地生成，改成下载文件之后，就比较麻烦，导致多次报错。

