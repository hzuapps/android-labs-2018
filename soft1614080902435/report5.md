# 第五次实验
## 1.实验目的
掌握在Android App中存储数据
## 2.实验步骤
1、打开之前的项目

2、本APP产生的数据应为计算式子和运算结果，所以将要储存的文件命名为“counting.txt”，和“result.txt”

3、使用了内部存储方式

4、编译运行

5、截图实验结果

6、上传到GitHub

## 3.实验结果
![image](https://raw.githubusercontent.com/AisakaTaika/android-labs-2018/master/soft1614080902435/5.0.png)
## 4.实验心得
此次实验的要求是把APP产生的数据储存起来，在思考之后的结果是计算产生的式子和运算的结果，所以将要储存的文件命名为“counting.txt”，和“result.txt”。然后在jiemianerActivity中添加save函数。然后写监听函数。碰到最大的问题就是在运行APP之后，找不到生成的文件在哪。然后在真机中运行之后，由于手机没有root，所以也看不到生成的文件。最后在网上查了很多资料才知道在Android Studio打开DDMS可以看到原虚拟机操作看不到的文件。
