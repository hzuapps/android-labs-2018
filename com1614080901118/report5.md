# 第五次实验

## 一、实验目的
1.掌握在Android App中存储数据

## 二、实验内容
1.将添加行程时产生的数据保存到文件存储中；

2.文件存储方式：内部；

3.实现界面控件的事件处理，例如点击按钮


## 三、实验步骤

1、先初始化SharedPreferences的各个key对应的value为0；

2、绑定点击监听器，设置每次点击对应的value的值加1

3、调用sharedPreferences.Editor对象对数据进行存储；

4、用commit方法将数据存放；

5、通过key获取对应的SharedPreferences中的value；

6、把原来是int型的value转换成string类型输出到TextView中

## 四、实验截图


![image](https://github.com/wojiaojianxiaobai/-/blob/master/%E7%AC%AC%E4%BA%94%E6%AC%A1%E5%AE%9E%E9%AA%8C%E6%88%AA%E5%9B%BE.png)


## 五、实验体会

  本次实验比较难，在实验过程中出现了很多次闪退的问题，花了几天的学习和排查后才顺利完成了实验。本次实验主要利用SharedPreferences轻型数据库来完成，
  把数据存储到data/data/edu.hzuapps.androidlabs.com1614080901118/touch/中。通过本次实验，我了解了SharedPreferences的基本操作，对数据库的存储
  和读取，最重要的是要在后面加上commit，不然之前的修改都没发生改变，本次实验让我受益良多。
