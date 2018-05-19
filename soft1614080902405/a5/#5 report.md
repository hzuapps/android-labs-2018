# 第五次实验报告
 
## 一、实验目标：
掌握在Android App中存储数据
## 二、实验步骤：
1 打开android软件
2 回忆一下上次实验的内容
3 看一下实验要求，发现看不是很懂，决定去网上看一下教学视频
4 视频也感觉挺难，不懂
5 研究实验要求发的例范实验， 大概懂了大部分的过程
6 先做个layout，弄了上次搜索的EditText 然后新建了两个保存内存和外存的按钮
7 把2按钮和EditText 弄了监听，还有取到控件。
8 到了将文字保存到内部存储阶段，将private void saveTextIntoInternalStorage(String text)打上，
用File命令，新建File file = new File(dir, FILENAME);接着判断文件是否存在，开流关流，具体流程和例子差不多。
9 我在内存外存上都加多了一个显示语句。 Toast.makeText(Soft1614080902405Activity.this, "搜索成功", Toast.LENGTH_SHORT).show();
10 连接真机，观察，截图。
## 三、实验结果：
![image](https://github.com/Moshaojia/android-labs-2018/blob/master/soft1614080902405/a5/756426004140734864.jpg) 
![image](https://github.com/Moshaojia/android-labs-2018/blob/master/soft1614080902405/a5/356007936648600018.jpg) 
![image](https://github.com/Moshaojia/android-labs-2018/blob/master/soft1614080902405/a5/245229178346346633.jpg) 
## 四、实验心得：
这次感觉没有上次布局那么难上手，也是因为有了那时候的基础，所以才慢慢可以去看得懂一些代码和操作。不懂的时候还是得多问，多看看别人怎么做的。
java没学好，也是得学学了，不然后面代码真不懂了。
