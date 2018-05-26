
# 第五次实验

## 一、实验目标

掌握在Android App中存储数据

## 二、实验内容

使用文件存储

1.将应用产生的数据保存到文件存储中；

2.说明使用的文件存储方式：内部 or 外部；

3.将运行结果截图。

## 三、实验步骤
1.选用内部存储的方式来存取；

2.创建一个新的Activity3用来实现点击“保存游戏”时页面的跳转

3.在需要读取的数据的activity中编写读取数据和显示数据的代码

4.编译运行成功后截图，并且通过git 发到github库上去，然后在提交
  
## 四、实验截图

![image](https://github.com/Ademzw/android-labs-2018/blob/master/soft1614080902336/%E5%AE%9E%E9%AA%8C%E4%BA%94%E6%88%AA%E5%9B%BE1.png)

![image](https://github.com/Ademzw/android-labs-2018/blob/master/soft1614080902336/%E5%AE%9E%E9%AA%8C%E4%BA%94%E6%88%AA%E5%9B%BE2.png)

![image](https://github.com/Ademzw/android-labs-2018/blob/master/soft1614080902336/%E5%AE%9E%E9%AA%8C%E4%BA%94%E6%88%AA%E5%9B%BE3.png)
## 五、实验体会
 这次的实验内容是文件存储，我选择的是将文件存储在内部，我选择的题目是五子棋，当游戏还在进行而玩家不想玩的时候，点击手机的返回界面，此时屏幕上会出现“开始新游戏”、“继续游戏”、“保存游戏”和“退出游戏”的四个选择按钮，由于这里只是做文件存储，所以我只实现了保存游戏的功能。当点击保存游戏时，系统会保存当前的游戏进度，下一次玩家进入游戏时可继续进行之前未结束的游戏。