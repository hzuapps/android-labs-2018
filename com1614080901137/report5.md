# 第五次实验

## 一、实验目的
 掌握在Android App中存储数据
 
 ## 二、实验内容
将应用产生的数据保存到文件存储中；<br>
说明使用的文件存储方式：内部 or 外部；<br>
将运行结果截图。

 ## 三、实验步骤
1、首先用git工具将代码仓库复制到本地后进行修改。

2、然后打开com1614080901137Activity.java，在这个文件下面增加了一个事件，当点击操作时，将应用上的
数据生成保存在data.xml文件中，这次保存数据是使用SharedPreferences存储，属于内部存储

3.实验运行成功后将文件git push 上传到本地仓库  

4，编写实验报告

5.create new pull request将实验提交到老师的库中



## 四、实验截图

*存储文件<br>
![image](https://github.com/Hongms/android-labs-2018/blob/master/com1614080901137/5.png)<br>
 


 ## 五、实验体会
       在这次实验使用了SharedPreferences存储，在了解到安卓有多种存储方式上，我发现SharedPreferences存储是不同于文件的存储方式，
	它是使用键值对的方式来存储数据的。这个存储方式的时候代码的实现也不难，所以觉得这个是最容易掌握的存储方式。
