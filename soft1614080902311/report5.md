#第五次实验
##1.实验目标

掌握在Android App中存储数据

##2.实验内容

1.将应用产生的数据保存到文件存储中；

2.说明使用的文件存储方式：内部 or 外部；

3.将运行结果截图。

##3.实验步骤

1.在activity3.xml中添加搜索框et_food和搜索按钮btn_search

2.在MainActivity定义et_food和btn_search控件

3.用匿名内部类setOnClickListener监听btn_search

4.定义历史记录方法refreshHitory，初始化历史记录方法initHistory，写入方法write,读入方法read

##4.实验结果

![在Android SDK Manager中选择6.0库](https://github.com/hzuapps/android-labs-2018/blob/ea1e2249089a6ad01c5210a66d3f94c0e3798b6a/soft1614080902311/test5.png "配置教育网下载代理")

## 实验体会

实验的重点和难点在于读写方法的定义。要注意异常的捕获和输入输出流的声明和关闭。
