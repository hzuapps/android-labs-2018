实验五
=
一.实验目的
-
掌握在Android App中存储数据
  
二.实验内容
-
根据选题要求使用数据库存储<br>
应用数据存储可采用数据库存储。<br>
将应用产生的数据存储到数据库中；<br>
将应用运行结果截图。<br>

三.实验步骤
-
数据存储部分:<br>
用Android的文件存储的数据存储方式，并且用了内部存储实现存储<br>
1.创建新的一个Activity4，用来在游戏结束后显示成绩和用EditText控件供玩家输入游戏呢称<br>
2.在Activity4.xml文件中添加EditT的相关代码与属性，然后用Context类中的openFileOutput()方法，将数据存储到data文件中<br>
3.在Activity4.xml的文件中继续添加Context类的openFileInput()方法，从文件data中读取数据，返回一个FileInputStream对象，
再通过Java流的方式将数据读取出来。还通过Toast短暂地提示读取成功<br><br>

四.实验截图
-
app运行看见第一个Activity:
-
![screen](https://github.com/xuguh/android-labs-2018/blob/master/soft1614080902226/Soft1614080902226Activity/jietu1.png)

点击下方"开始游戏"按钮后调到另一个Activity：
-
![screen](https://github.com/xuguh/android-labs-2018/blob/master/soft1614080902226/Soft1614080902226Activity/jietu2.png)

选择“难度1”后，正式进入游戏界面，并开始游戏：
-
![screen](https://github.com/xuguh/android-labs-2018/blob/master/soft1614080902226/Soft1614080902226Activity/jietu3.png)

游戏结束后，进入输入玩家昵称与显示成绩画面：
-
![screen](https://github.com/xuguh/android-labs-2018/blob/master/soft1614080902226/Soft1614080902226Activity/jietu4.png)

退出后再一次进入结算界面时，会自动把之前玩家输入的昵称与成绩显示，并弹出读取成功提示：
-
![screen](https://github.com/xuguh/android-labs-2018/blob/master/soft1614080902226/Soft1614080902226Activity/jietu5.png)
-
五.实验体会
-
1.这次实验查找资料比较多，因为要做完全没接触过的文件存储，但也学到了很多，原来简单地写入读取一些简单的文本数据也不是想象中那么难。<br>
2.实验中用到了Toast短暂地提示读取数据成功，显得很有趣，我也可以做得像平时所用的APP那般弹出提示信息<br>

 
  
