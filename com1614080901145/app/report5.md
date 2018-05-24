# 第五次实验

## 实验目标

掌握在Android App中存储数据

## 二.实验内容
 
根据选题要求使用文件存储
 
 将应用产生的数据保存到文件存储中；
 说明使用的文件存储方式：内部 or 外部；
 将运行结果截图。

## 实验步骤
1.程序采用内部存储的方式。

2.根据前面所做，本app已经有了一个EditText来输入要搜索的资源名，同时存在一个Button作为事件监听器，点击按钮，保存文件。

3.添加save函数，写入保存文件的方法，将保存的文件命名为“file_demo”。

4.在 activity_Com_1614080901145 中添加一个TextView 以便显示文件存储的路径。

5.运行程序并截图


## 实验结果

![截图](https://github.com/TheZhangh/android-labs-2018/blob/master/com1614080901145/%E5%AE%9E%E9%AA%8C5%E6%88%AA%E5%9B%BE1.PNG)
![截图](https://github.com/TheZhangh/android-labs-2018/blob/master/com1614080901145/%E5%AE%9E%E9%AA%8C%E4%BA%94%E6%88%AA%E5%9B%BE2.PNG)

## 实验体会
	讲真，因为缺乏java的基础知识，实验做起来十分不易，虽然最后app成功跑起来了，文件也写进了内存，但save方法的代码还是没看懂，只是看出个大概功能。而且，由于获取不了AVD的读写权限，故我直接把文件的存取路径在app上显示出来。



