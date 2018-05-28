# 第五次实验
  		  
 ## 1.实验目标
  
掌握在Android App中存储数据
  		  
 ## 2.实验步骤

  1）通过查阅资料了解文件存储与数据库存储。

  2）选择文件内部存储进行进一步学习。

  3）编写写入文件函数，给按钮添加监听，运行测试。

  4）编写读出文件函数，给按钮添加监听，运行测试。

 ## 3.实验结果

https://github.com/luolihaoo/android-labs-2018/blob/master/soft1614080902331/%E7%AC%AC%E4%BA%94%E6%AC%A1%E5%AE%9E%E9%AA%8C.png

 ## 4.实验体会

     文件存储是Android中最基本的一种数据存储方式，它与Java中的文件存储类似，都是通过I/O流的形式把数据原封不动的存储到文档中。而且Android的文件存储分为内部和外部两种，本次实验采用了内部存储。

     context类中提供了一个openFileOutPut( para1 ， para 2)方法，用于将数据存储到指定的文件中。para1 ：文件名。para2 ：文件的操作模式（MODE_PRIVATE:表示当文件重名的时候，直接覆盖原先同名文件；MODE_APPEND:表示当文件重名的时候，向原同名文件增加新有内容）

     ontext类中提供了一个openFileInput("文件名")，用于将数据显示到指定的view中。在文件输出时，主要注意输出条件语句。
