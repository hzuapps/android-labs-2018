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
1.先加一个按钮，以进入new_item界面。
2.在new_item中添加两个editText，一个用来写入要保存的内容，另一个用来显示保存的内容。
3.在new_item中再加一个button，点击后就会开始保存内容并显示。
## 实验结果

![weith="80dp"](https://github.com/wsgtl/android-labs-2018/blob/master/soft1614080902408/picture/实验五.1.png)

![](https://github.com/wsgtl/android-labs-2018/blob/master/soft1614080902408/picture/实验五.2.png)

![](https://github.com/wsgtl/android-labs-2018/blob/master/soft1614080902408/picture/实验五.3.png)

## 实验心得
这次实验一开始，我没什么头绪，因为我做的这个掌游宝并不需要存储什么东西，不过还是要交作业，所以我就用了先在一个exittext上写入，并在另一个exittext上
显示，并利用一个button监听来做这次实验。实验有点难，因为是第一次做，所以比较生疏，其中 一开始还遇见只显示文件路径而不显示文字的问题，后来发现，是showResult(line);
被我放在读取文件的try,catch语句外面了，把其放进去就可以了



