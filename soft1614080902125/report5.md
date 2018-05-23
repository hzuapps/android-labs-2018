# 实验五
## 一.实验目的

掌握在Android App中存储数据

## 二.实验内容

根据选题要求使用文件存储

将应用产生的数据保存到文件存储中；
说明使用的文件存储方式：内部 or 外部；
将运行结果截图。

## 三.实验步骤

1.首先在创建一个RW_file_musiclist.class用于读写文件和判断文件是否存在。

2.然后定义一个Song.class用于生成歌曲对象。

3.context.getContentResolver().query()方法读取从手机内存中读取音乐文件并保存到List集合中，
List存放的事Song对象迭代List集合，把每一个Song对象的所有属性，保存到Map对象中，定义一个List集合，并把Map对象添加到List集合中，再将List对象写到list_localmusic文件中。

5.在locallist_Fragment的onStart()方法中读取list_localmusic文件生成item放入LIstView中

6.使用Git将代码提交到自己的库中：https://github.com/linkzw/android-labs-2018

7.在GitHub中使用Markdown文件编写实验报告（report5.md）.

8.在自己的GitHub库上创建和发送Pull Request（注意查看Changed files）.

## 四.实验截图

运行结果：![image](https://github.com/linkzw/android-labs-2018/blob/master/soft1614080902125/p7.jpg)

## 五.实验体会
通过这次实验我更加熟悉android studio 一些控件的使用，并成功实现了android 简单的数据存储和显示，
但同时还有许多未能实现的地方需要努力，值得一提的是，在android6.0及以上版本中，内存读取权限不在自动获取，
这会导致程序崩溃。
