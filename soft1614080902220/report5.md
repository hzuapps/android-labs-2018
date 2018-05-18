# 1.实验目的
掌握在Android App中存储数据
# 2.实验内容
根据选题要求使用文件存储

将应用产生的数据保存到文件存储中；

说明使用的文件存储方式：内部 or 外部；

将运行结果截图。
# 3.实验步骤

在activity_laile.xml中添加一个新的EditText，通过它,用户可以把数据传给App；

在方法public String read()中添加 FileInputStream inStream = this.openFileInput("message.txt")，用于写入用户所写入的数据，当点击button_open
时都存入记录到外部txt文件中；

在方法public void write()读出用户所写入过的数据；

在laile.java中还有button_open2, button_close;当点击“关闭”按钮时，button_close响应，返回页面1；
当点击“开始搜索”按钮时，button_open2响应，进入页面3；

# 4.实验结果
![](https://github.com/Mrwuwu12138/android-labs-2018/blob/master/soft1614080902220/687668327104094246.jpg)
![](https://github.com/Mrwuwu12138/android-labs-2018/blob/master/soft1614080902220/881614222882453916.jpg)
![](https://github.com/Mrwuwu12138/android-labs-2018/blob/master/soft1614080902220/371358704010614115.jpg)

# 5.实验体会
这次实验对我来说难度还挺大的，因为以前未学过此内容，刚开始无从下手，通过网络学习，向同学学习，了解了一些基本的存储方法，更加熟悉了EditText属性及使用方法
，对如何添加按钮更加得心应手！
