# 第五次实验

## 1. 实验要求
1. 将应用产生的数据保存到文件存储中；
2. 说明使用的文件存储方式：内部 or 外部；
3. 将运行结果截图。
## 2. 实验步骤
我是用外部存储
1. 先用findViewById(R.id.name)).getText()获取到提交的信息。
2. 然后用FileOutputStream 类中的write方法写进数据。
3. 最后用setText()方法把信息都显示出来。

## 3. 实验结果
输入数据后点击上传。  
![](https://github.com/YoMiao/android-labs-2018/blob/master/com1614080901130/screen/report5_screen1.png)  
![](https://github.com/YoMiao/android-labs-2018/blob/master/com1614080901130/screen/report5_screen2.png)  

## 4. 实验心得
1. 实验写入的基本步骤就是：  
(1)获取写入信息；  
(2)创建文件并写入；  
只要清楚这两个步骤，然后按语言的特性编写就行了。
