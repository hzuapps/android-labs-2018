# 实验一：Android组件编程
 
## 1.实验目标：
Android组件编程
 
## 2.实验要求：
(1)在Issues中创建自己的选题：https://github.com/hzuapps/android-labs-2018/issues ；
(2)根据自选题目，编写一个或多个Activity（所有均带上学号前缀，放到自己的Java包下）；
(3)将标题设置为自己的学号+对应的功能或题目；
(4)根据自己选择的题目实现Activity中导航、调用等功能（选做）。
 
## 3.实验提示
(1)根据MVC、MVP设计模式或其他Android App设计模式设计Java类；
(2)先设计表示业务数据的Java类，如表示订单、图书、商品、车辆、音乐、笔记等的类；
(3)再考虑设计一些业务服务类，如网络连接等类；
(4)上传代码时，代码放到自己的学号里面，同时保留Studio的目录结果，如：
app
- src
-- main
--- AndroidManifest.xml (第1个文件)
--- java
---- edu / hzuapps / androidlabs / Soft学号 / Soft学号Activity.java (第2个文件)
--- res 
---- layout
----- soft_学号_activity.xml (第3个文件)
---- values
----- strings.xml (第4个文件)
 
## 4.实验体会
 安卓工程目录分类很多，看起来比较复杂，但是这样又很大的好处就是代码文件、布局文件、资源文件能很好的被区分，熟悉之后使用会很方便对项目进行管理。
 在安卓项目中，布局和逻辑是分开的，通过setContentView()方法联系在一起。
 熟悉Activity的声明周期很重要，有关安卓声明周期的方法有onCreate(),onStart(),onPause(),onResume(),onRestart(),onStop(),onDestory()
