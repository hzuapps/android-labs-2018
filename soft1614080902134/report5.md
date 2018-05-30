# 第五次实验
## 一.实验目标
掌握在Android App中存储数据。

## 二.实验步骤
1. 在 res 目录下，添加一个名为 raw （一定是这个名字，其他不行）的文件夹，建立一个文本文件 test.txt;
2. 在 test.txt 文件中，写入测试数据 1+2=3 4+6=10 12+98=120 11+20=21 15+12=28 34+12=45；
3. 在 GameStart.java 类中，添加添加一个 read 方法，并在主函数中调用，用以实现文本文件 写入 app
4. read方法的具体实现：通过 Resources 类拿到文件，Resources.findViewById(R.id.***)，打开文件，采用 InputStream 流读取数据。

## 三.实验结果
![image](https://github.com/lgc1999/android-labs-2018/blob/master/soft1614080902134/%E5%AE%9E%E9%AA%8C5.png)

## 四.实验体会
本次实验较难，刚开始自己在 res 目录下创建data文件夹，但是一直报错，无从下手，不知道只能使用 raw 这个特定的文件夹，后来在使用
StdInfo = resources.openRawResource(R.raw.test); 打开文件时，突然留意到 openRawResource ,猜测可能这是个特定存放数据的文件夹，
其他文件只能放 .xml 文件，修改之后成功读取了数据。
