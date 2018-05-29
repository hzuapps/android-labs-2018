## 实验目标
* 掌握在Android App中存储数据
## 实验内容一（选做1个）
* 根据选题要求使用文件存储

1. 将应用产生的数据保存到文件存储中；

2. 说明使用的文件存储方式：内部 or 外部；

3. 将运行结果截图。

## 实验内容二（选做1个）
* 应用数据存储可采用数据库存储。

1. 将应用产生的数据存储到数据库中；

2. 使用UML类图描述表结构；

3. 将应用运行结果截图。

## 实验步骤
* 1.为测试按钮绑定一个产生随机数的事件
* 2.调用getSharedPreferences设置存储数据的文件名称
* 3.调用getSharedPreferences.Editor的方法存储数据
* 4.把产生的随机数保存到Grade文件中
* 5.设置setText读取key为Grade的值显示到TextView中
## 实验结果

![weith="80dp"](https://github.com/BeamGod/picture/blob/master/828544290924097861.png)


## 实验心得
本次实验用到了SharedPreferences数据库的存储方法。改数据库虽然只能存储boolean、float、int、long、及字符串对象类型数据，但是却在使用中非常简便快捷。
通过本次实验，我学会了使用SharedPreferences和SharedPreferences.Editor两个对象变量的使用，以及对SharedPreferences的存储和读取方法来记录相关数据的
操作。
