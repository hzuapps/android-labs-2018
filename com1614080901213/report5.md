#实验五实验报告

##实验目的

1、Android存储编程

##实验要求

1、掌握在Android App中存储数据。

实验内容一（选做1个）

·根据选题要求使用文件存储

1、将应用产生的数据保存到文件存储中；

2、说明使用的文件存储方式：内部 or 外部

3、将运行结果截图。

实验内容二（选做1个）

·应用数据存储可采用数据库存储

1、将应用产生的数据存储到数据库中；

2、使用UML类图描述表结构；

3、将应用运行结果截图。
##实验步骤

1、阅读实验要求：https://github.com/hzuapps/android-labs-2018/labels/Lab；

运行Android studio；

在实验四的基础上编写，先在activity_second.xml添加一个文本框用于显示存储信息，

在SecondActivity.java编写写入数据和读取数据的函数（运用FileOutputStream、FileInputStream、BufferedWriter等来实现）；

在监听器中调用写入数据函数和读取数据函数来完成数据存储和读取的功能。

3、使用Git将代码提交到自己的库中：https://github.com/HHuangF/android-labs-2018；
   $ git pull
   $ git add soft1614080902440/*  
   $ git commit "#5 #991 第五次实验 "
   $ git push
4、在自己的GitHub库上创建和发送Pull Request；

5、在GitHub中使用Markdown文件编写实验报告（report5.md）；

##实验结果
![image](https://github.com/huangdewei/android-labs-2018/blob/master/com1614080901213/7.png)

![image](https://github.com/huangdewei/android-labs-2018/blob/master/com1614080901213/8.png)

![image](https://github.com/huangdewei/android-labs-2018/blob/master/com1614080901213/9.png)

##实验体会

这次实验，让我了解到数据存储有多种方式，有简单的也有复杂的，我采用了比较简单入门的外部文件存储，
这次实验让我对FileOutputStream、FileInputStream、BufferedWriter、Toast等的使用有了更进一步的了解，
对数据的写入和读取有了更加的理解，提高了我的编程能力。亲自动手才能更好的学习，这次实验我刚开始
有点不懂，不过在网上查找了一些有关数据读取的内容并在实验中进行运用，并且成功了。
