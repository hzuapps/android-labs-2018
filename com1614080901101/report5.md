# 第五次实验

## 实验目的
掌握在Android App中存储数据

## 实验要求
+ 1.将应用产生的数据保存到文件存储中；
+ 2.使用内部文件存储方式。
+ 3.将运行结果截图。

## 实验步骤
+ 1.添加文件保存、复原和修改等BUTTON。
+ 2.编写代码，使用数据流将排行榜第一名数据输出到内部文件"file_leaderboard.txt"
+ 3.为了验证数据复原，将排行榜第一名数据修改为其他数
+ 4.并且使用保存内部文件"file_leaderboard.txt"将排行榜第一名数据更新（还原）
+ 5.使用Git将文件提交到库：https://github.com/Tmouser/android-labs-2018；
+ 6.在自己的GitHub库上创建和发送Pull Request；
+ 7.编写实验报告。
 
## 实验结果
![保存数据](https://github.com/Tmouser/android-labs-2018/blob/master/com1614080901101/values_save.png)
![数据文件](https://github.com/Tmouser/android-labs-2018/blob/master/com1614080901101/values_data.PNG)
![保存数据](https://github.com/Tmouser/android-labs-2018/blob/master/com1614080901101/values_change.png)
![保存数据](https://github.com/Tmouser/android-labs-2018/blob/master/com1614080901101/values_reflash.png)

## 实验体会
本次实验是学习使用存储技术，因为是排行榜，是本地的要保存数据，所以使用了内部存储技术。本来是应该游戏失败或者退出游戏时保存，打开排行榜时更新数据的，但是为了更加直观表现存储的结果，我在排行榜页面添加了保存、修改和更新按钮，并使用Toast来显示每次修改的数据。
