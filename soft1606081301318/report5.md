# 第五次实验
## 实验目标

    掌握在Android App中存储数据

## 实验内容
实验内容一（选做1个）

    根据选题要求使用文件存储

    将应用产生的数据保存到文件存储中；
    说明使用的文件存储方式：内部 or 外部；
    将运行结果截图。

实验内容二（选做1个）

    应用数据存储可采用数据库存储。

    将应用产生的数据存储到数据库中；
    将应用运行结果截图。

## 实验步骤与结果

1.本次实验使用数据库储存方式进行数据缓存

2.建立一个sql数据库和表
```
CREATE DATABASE news;

CREATE TABLE news
(_id INTEGER PRIMARY KEY AUTOINCREMENT,
news_id CHAR(20) NOT NULL,
title CHAR(100) NOT NULL,
thumbnail CHAR(100) NOT NULL DEFAULT "http://s6.sinaimg.cn/mw690/003x41sogy6Nk0BvdSl35&690", 
news_url CHAR(100) NOT NULL,
tags TEXT NOT NULL);

```

3.简单的封装了相关的ORM（insert 和 select）

4.在项目执行到获取知乎日报api数据的方法时候，同时进行数据库插入操作

5.在项目程序运行时，进行查询操作，判断数据库是否已经缓存，如果缓存直接从数据库查询数据并更新UI界面

6.运行结果并截图

7.在自己的GitHub库上创建和发送Pull Request

## 实验截图

news表中的部分数据

![image](https://raw.githubusercontent.com/0r2dev/android-labs-2018/master/soft1606081301318/screenshot5_1.png)

没有缓存之前的项目截图
![image](https://raw.githubusercontent.com/0r2dev/android-labs-2018/master/soft1606081301318/screenshot5_2.png)

缓存后断网的项目截图
![image](https://raw.githubusercontent.com/0r2dev/android-labs-2018/master/soft1606081301318/screenshot5_3.png)

## 实验体会
   
  这次实验主要在数据库和表的创建和设计，以及项目缓存点放在哪里的逻辑问题，整体并不难。 也尝试了解如何去写一个最为简单的ORM