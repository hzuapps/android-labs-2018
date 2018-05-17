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
用Android自带的SQLite实现存储<br>
1.创建MydatabaseHelper.java类继承SQLiteOpenHelper，onCreate()方法会创建一张player表<br>
2.在Activity3的内部监听器类ButtonMonitor的case 9部分,第一次调用时会创建名称为PlayerStore.db的数据库，并创建player表和插入当前玩家的数据<br>
3.在Activity4的sqlPlayerData()方法中实现数据库查询操作,按时间成绩升序作为排行榜<br><br>

额外组件部分:<br>
1.在Activity3中用initCurrentPlayerTextView()方法接收Activity2中玩家输入的名称和选择的信息，并显示在界面左上角作为当前玩家数据<br>
2.在Activity3中用Handler和Runnable实现计时功能，并用TextView timer控件显示在界面右上角<br>
3.在Activity3中用initButton()中初始化界面中间1-9Button,并绑定到同一个监听器ButtonMonitor上<br>
4.在Activity3中用rankList()方法实现排行榜Button,功能是跳转到Activity4<br>
5.在Activity3中用ButtonMonitor实现游戏的逻辑算法<br>
6.在Activity4中用RecyclerView组件实现排行榜:<br>
7.创建PlayerData.java作为一个玩家的数据<br>
8.创建PlayerDataAdapter类作为RecyclerView的适配器<br>
9.创建playerdata_item.xml布局文件作为RecyclerView的子项布局<br>


四.实验截图
-
截图1:
-
![](https://github.com/yangyangyang2017/android-labs-2018/blob/master/soft1614080902221/%E7%AC%AC5%E6%AC%A1%E5%AE%9E%E9%AA%8C%E6%88%AA%E5%9B%BE1.gif)

截图2:
-
![](https://github.com/yangyangyang2017/android-labs-2018/blob/master/soft1614080902221/%E7%AC%AC5%E6%AC%A1%E5%AE%9E%E9%AA%8C%E6%88%AA%E5%9B%BE2.gif)


五.实验体会
-
1.这次实验写的比较多，因为要做数据库，所以要先完成游戏的基本玩法和功能，选择SQLite数据库用来存储玩家信息和成绩。<br>
2.数据库查询所有玩家的数据(也就是排行榜)选择用的是RecyclerView组件,因为数据过多时排行榜可以滚动，不至于超出屏幕。<br>
3.写Android最烦人的是写错了代码导致APP闪退而adroid studio没有提示哪里错误，有时候要找很久才发现。<br>
 
  
