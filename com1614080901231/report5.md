[toc]
# 第五次实验报告
## 需求
1）掌握在Android App中存储数据；
 + 
 + （2）根据选题要求使用文件存储；
 + 
 + （3）将应用产生的数据保存到文件存储中：内部 or 外部；
 + 
 + （4）将应用运行结果截图。
 + 
 + ## 2.实验步骤
 + 
 + （1）在需要存储数据的Activity中，创建存储文件的函数save,使用的是内部存储
实现了计算结果记录
## 使用的储存方案
http://note.youdao.com/noteshare?id=5210e3bf8a1344d85d327eb72f89ac4b&sub=7881F9FB70904007AD76DDCA1821FE37
## 实验步骤
+ 判断是否有历史，没有就不设置显示
+ 退出时保存最后一次结果
## 结果
![image](https://github.com/BACodeLab/android-labs-2018/blob/master/com1614080901231/4.png)
![image](https://github.com/BACodeLab/android-labs-2018/blob/master/com1614080901231/5.png)
## 实验体会
Shared Preferences:是一种轻量级的存储,数据会写在本地的一个xml文件中,以键值对的形式存在!如果程序卸载,此文件也跟着卸载!!
+ 保存位置:  data/data/程序包名/share_prefs/
+  主要用途:
   1.保存应用的设置  例如:设置静音,下次进入还是静音
   2.判断是否是第一次登陆

