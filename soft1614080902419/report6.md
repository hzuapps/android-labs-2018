# 第六次实验
## 1.实验目的  

1.掌握Android网络访问方法

2.理解XML和JSON表示数据的方法  

## 2.实验要求  

1.从网络下载一个文件

2.保存到手机，在应用中使用文件

3.将应用运行结果截图  

## 3.实验步骤  

1.打开实验五的工程项目  

2.AndroidManifest.xml中添加能够写入读出内存空间权限和网络连接权限的代码，其代码如下图： 

![Image text](https://github.com/ccxm/android-labs-2018/blob/master/soft1614080902419/6.1.png)  

3.在second_activity.xml中添加一个TextView,address用来存放图片的地址，一个ImageView,image用来显示图片，其代码如下图： 

![Image text](https://github.com/ccxm/android-labs-2018/blob/master/soft1614080902419/6.2.png)

4.在Second_Activity.java中创建一个线程download,用来下载、存储及显示图片，其代码如下：  

![Image text](https://github.com/ccxm/android-labs-2018/blob/master/soft1614080902419/6.3.png)

5.编译运行  

6.打开git bash，将文件夹push上github，向老师提交pull request.

## 4.实验截图  
按"="号前  

![Image text](https://github.com/ccxm/android-labs-2018/blob/master/soft1614080902419/6.4.png)

按"="号后  

![Image text](https://github.com/ccxm/android-labs-2018/blob/master/soft1614080902419/6.5.png)

## 6.实验心得
做好实验后，运行的时候一直按"="号，可是一直都没有图片，也没有报错，没有抛出异常，加了许多打印语句进去看看是否执行了下载的语句，发现确实又执行了。后来请教了同学，他看了代码也没有问题，然后突然发现我用的是github的图片。发现问题的所在，他说他之前用GitHub的图片也不行，后来再百度上找了一张，运行，按"="，可以了，图片出来了。
