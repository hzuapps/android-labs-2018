# 第五次实验报告
## 实验目标
### 应用数据存储可采用数据库存储。
### 1、将应用产生的数据存储到数据库中；
### 2、将应用运行结果截图。
## 实验步骤
### 1、先创建一个继承SQLiteOpenHelper的java类(ScoreDataBase)，并且在oncreate方法中创建表，在upgrade中更新表，表名为score，主键玩家姓名playername，其它是玩家得分playscore。
### 2、创建一个玩家得分的测试activity(Playing)，此activity只有edittext和一个跳转button，测试时在edittext中输入玩家得分。
### 3、创建一个输入玩家名的activity(InputName)，此activity的布局与上面的一样，但要创建数据库，并且由于插入在点击事件中所以定义SQLiteDatabase时前面要加final，还有由于排名不超过十个，所以插入的元组不超过10个，超过则删除最低分。
### 4、创建一个显示排名、玩家名与得分的activity(Score)，用cursor进行得到数据库中的数据并且文字垂直居中左对齐。
### 5、把原本要替换的用git rm删除，然后把需要的文件用git add添加然后git push
## 实验结果
### ![image](https://github.com/ChenYHeng/android-labs-2018/blob/master/Soft1613090502218/r51.png)
### ![image](https://github.com/ChenYHeng/android-labs-2018/blob/master/Soft1613090502218/r52.png)
### ![image](https://github.com/ChenYHeng/android-labs-2018/blob/master/Soft1613090502218/r53.png)
## 实验体会
### 这次的实验本来是应该很简单的，但是由于我的失误，让我没有发现已经存在的表中的主键的名字是playername，所以我一直都是用playname去进行调试，再加上电脑的运行速度问题，导致我的实验过了很久才交。
### 不过虽然数据库是有学过，但是我认为还是有一点难度，而且熟悉Java也用了很长一段时间，因此我认为应该多做一些题目，这样以至于排错能力继续提高。