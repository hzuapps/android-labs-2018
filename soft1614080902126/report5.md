## 1、实验目标
 （1）掌握在android App中存储数据。

## 2、实验内容

 （1）根据选题要求使用文件存储：

 （2）将应用产生的数据保存到文件存储中。

 （3）说明使用的文件存储方式-内部。

 （4）将运行结果截图。

## 3 .实验步骤

 （1）自行修改项目，实现实验要求中的功能。


## 4、实验提示
 
 （1）重写实验报告，要在自己电脑上执行命令。git pull同步github文件，并上传。

## 5、实验结果

 ![png](https://github.com/WUJINH/android-labs-2018/blob/master/soft1614080902126/%E5%AE%9E%E9%AA%8C5%E6%88%AA%E5%9B%BE1.png)

 ![png](https://github.com/WUJINH/android-labs-2018/blob/master/soft1614080902126/%E5%AE%9E%E9%AA%8C5%E6%88%AA%E5%9B%BE2.png)

 ![png](https://github.com/WUJINH/android-labs-2018/blob/master/soft1614080902126/%E5%AE%9E%E9%AA%8C5%E6%88%AA%E5%9B%BE3.png)

 ![png](https://github.com/WUJINH/android-labs-2018/blob/master/soft1614080902126/%E5%AE%9E%E9%AA%8C5%E6%88%AA%E5%9B%BE4.png)



## 6、实验体会
 
 本次实验5做了存储部分的实验，我在此次实验中选用SharedPreferences的存储方式，这个方式的优点是比较简单。此次存储用EditText和button输入文字数据，存进SharedPreferences中。然后在主函数中用SharedPreferences  pref=getSharedPreferences("data",MODE_PRIVATE);String file2 =pref.getString("file","");得到SharedPreferences中的数据，然后用Log日志输出。

