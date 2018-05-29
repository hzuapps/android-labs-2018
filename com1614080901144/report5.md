# 实验五
 ## 一.实验目的
 
 掌握在Android App中存储数据
 
 ## 二.实验内容
 
 根据选题要求使用文件存储
 
 将应用产生的数据保存到文件存储中；
 说明使用的文件存储方式：内部 or 外部；
 将运行结果截图。
 
 ## 三.实验步骤
 
 1.选用文件存储方式，属于内部存储。

 2.在com1614080901144Activity.java中获取一个FileOutputStream对象，然后构造出一个BufferedWriter方法。
 
 3.在oncreate获取edittext的实例，重写了onDstory方法，在onDestroy获取输入的内容。
 
 4.调用save（）方法将输入的内容存储在文件中。  
 
 5.将保存的数据导出桌面上，查看。
 
 6.使用Git将代码提交到自己的库中：https://github.com/MaZongXin/android-labs-2018
 
 7.在GitHub中使用Markdown文件编写实验报告  
 
 8.在自己的GitHub库上创建和发送Pull Request
 ## 四.实验截图
 

 ![image](https://github.com/1614080901144/android-labs-2018/blob/master/com1614080901144/%E5%AE%9E%E9%AA%8C5%E6%88%AA%E5%9B%BE%20(2).PNG)

 ![image](https://github.com/1614080901144/android-labs-2018/blob/master/com1614080901144/%E5%AE%9E%E9%AA%8C5%E6%88%AA%E5%9B%BE%20(1).PNG)

 
 ## 五.实验体会
 
 通过这次实验我了解到了Android中存在这五种存储方式，也初略了解了各种存储方式的不同，由于我使用的数据比较简单，所以我使用的是文件存储方式，之前确实没了解过这方面的内容，所以花的时间久了一点。
