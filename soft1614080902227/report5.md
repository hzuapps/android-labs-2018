# 实验五：Android存储编程
## 实验目标
*  掌握在Android App中存储数据
## 实验内容
*  应用数据存储可采用数据库存储。
1. 将应用产生的数据存储到数据库中；
2. 使用UML类图描述表结构；
3. 将应用运行结果截图。
## 实验步骤
1.  编辑空调遥控类Remote_of_Air，在xml布局文件里，添加了多个操控的按钮和温度显示TextView
2.  新建了一个UserDBHelper类继承SQLiteOpenHelper,用来创建数据库
3.  用数据库来记录TextView的温度的数字，以便返回到第一个Activity，下次打开Remote_of_Air时，温度的数字为返回前的数字
4.  button "+"和"-"控制温度升降，button "开" 点击后会转换成"关"，TextView消失，反之，TextView显示。
## 实验结果
![](https://github.com/hzutanziyang/android-labs-2018/blob/master/soft1614080902227/%E7%AC%AC%E4%BA%94%E6%AC%A1%E5%AE%9E%E9%AA%8C%E6%88%AA%E5%9B%BE.jpg)
## 实验体验
     通过该实验，让我们懂得了数据库在Android studio 上的运用，刚开始接触还是很困难的，数据库的创建格式，符号，参数都有规定，
     不细心写，很容易漏了几个符号就导致运行出错，只是为了存储小小的数据，也花费了相当大的努力。
