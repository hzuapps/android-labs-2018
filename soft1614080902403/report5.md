# 第五次实验
## 1.实验目标
1、掌握在Android App中存储数据
2、应用数据存储可采用数据库存储。
3、将应用产生的数据存储到数据库中；
4、将应用运行结果截图。
## 2.实验步骤
1、因为传图识字的结果要保留在我的记录模块中，此处采用sqlite数据库进行存储这些识别记录。
2、为方便使用sqlite，使用了一个DBHelper的sqlite辅助类。
3、创建数据库文件history.db，并使用标准sql语句向其中增删改查数据。以实现传图识字记录的存取。
## 3.实验结果
 ![image](https://raw.githubusercontent.com/w123rq/android-labs-2018/master/soft1614080902403/pic5_1.png)
 ![image](https://raw.githubusercontent.com/w123rq/android-labs-2018/master/soft1614080902403/pic5_2.png)
## 4.实验体会
  本次实验涉及到了AndroidAPP本地持久化数据存储，常见的方案有数据库和文件，sqlite是安卓默认支持的本地数据库，简单易用，因此我选用了sqlite来存取数据，使用了DBHelper类来简化sqlite的使用，sqlite支持标准的sql语句，在接口返回数据之后，将记录插入，在打开我的记录模块的时候，将数据查询出来，实现了APP的数据存储能力。 