# 第六次实验
## 1、实验目标
掌握Android网络访问方法，文件网络编程

## 2、实验步骤
1、在自己的Github库中创建一个songs.JSON数据文件。

2、在子线程中新建一个URL对象，使用url.openConnection()去访问URL，获得请求。

3、使用输入流去读取请求的数据,把JSON的数据类型转换成String。

4、解析JSON，通过键取得对应的值，添加到数据类型ArrayList中。

5、返回主线程去更新UI。

## 3、实验结果
![image](https://github.com/wuyut/android-labs-2018/blob/master/Soft1606070302124/%E7%AC%AC%E5%85%AD%E6%AC%A1%E5%AE%9E%E9%AA%8C%E6%88%AA%E5%9B%BE.png)

## 4、实验体会
1.获取JSON和解析JSON方法比较方便把握。

2.更新UI有一个注意的点，使用 runOnUiThread返回主线程后就可以用来更新UI会造成程序终止。

3.刚开始在获取JSON时有一个问题，同时在问题的解决过程中了解到了网络编程的意义。
