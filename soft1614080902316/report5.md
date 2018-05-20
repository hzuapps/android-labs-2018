# 第五次实验
## 1.实验目标
掌握在Android App中存储数据。
## 2.实验步骤
(1) 、在其他两个界面的基础上我又增加了Main3Activity做第五次试验。文件的数据源来自第二个界面获取的数据。

(2）、新建Main3Activity，在Main2Activity中新建一个按钮用来跳转到Main3Activity

(3）、在Main3Activity中，先用intent导入数据，写入数据时，使用OutputStreamWriter封装openFileOutput，再用BufferedWriter封装OutputStreamWriter，
  这样就可以使用write方法向文件写入数据。
  
(4)、读文件时，使用FileInputStream 的read方法读出。由于读出来的是btye类型的，所欲先用一个byte的数组存，在转化为String类型的。

(5)、由于使用MODE_APPEND，存入的数据会追加在后面。

# 3.实验结果
![](https://github.com/SuperLikeMe/android-labs-2018/blob/master/soft1614080902316/561327242452503109.png)
![](https://github.com/SuperLikeMe/android-labs-2018/blob/master/soft1614080902316/909636762895341218.png)
![](https://github.com/SuperLikeMe/android-labs-2018/blob/master/soft1614080902316/438528273173068936.png)

# 4.实验体会

 本次实验关于如何对对文件进行操作，难度不算太大，主要是对其中的函数和数据类型进行掌握。
