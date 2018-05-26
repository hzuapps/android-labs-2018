# 实验五
 ## 一.实验目的
 
 掌握在Android App中存储数据
 
 ## 二.实验内容
 
 根据选题要求使用文件存储
 
 将应用产生的数据保存到文件存储中；
 说明使用的文件存储方式：内部 or 外部；
 将运行结果截图。
 
 ## 三.实验步骤
 
 1.采用了**SharedPreferences**存储数据，这种方式是使用键值对方式来存储数据。 

 2.通过给按钮注册点击事件，然后在点击事件中通过`getSharedPreferences()`方法指定**SharedPreference**的文件名字为data，
 并得到了`SharedPreferences.Editor`对象。接着向这个对象添加数据，调用`apply()`方法进行提交，从而完成了数据存储操作。    
 
 3.将保存的数据导出桌面上，查看。
 
 4.使用Git将代码提交到自己的库中：https://github.com/KalorF/android-labs-2018
 
 5.在GitHub中使用Markdown文件编写实验报告  
 
 6.在自己的GitHub库上创建和发送Pull Request
 ## 四.实验截图
 

 ![image](https://github.com/KalorF/android-labs-2018/blob/master/com1614080901132/img/6.jpg)

 ![image](https://github.com/KalorF/android-labs-2018/blob/master/com1614080901132/img/5.jpg)  
 
 ![image](https://github.com/KalorF/android-labs-2018/blob/master/com1614080901132/img/6.jpg)

 
 ## 五.实验体会
 
 通过这次实验我了解到了Android中存在这五种存储方式，也初略了解了各种存储方式的不同，由于我使用的数据比较简单，所以我使用的是SharedPreferences存储方式，之前确实没了解过这方面的内容，所以花的时间久了一点。
