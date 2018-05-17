# 第四次实验
## 1.实验目标

（1）根据选题要求设计界面布局及控件使用；

（2）布局xml及界面控制操作代码提交并截图；

（3）将应用运行结果截图。
## 2.实验内容

（1）使用一种布局方式，设计所选题目的界面：

（2）通过控件ID获取界面对象，执行相关操作：

（3）实现界面控件的事件处理，例如点击按钮：
## 3.实验步骤

（1）根据自己设计软件的界面要求进行选择，在这里我选择了LinerLayout布局文件；

（2）打开Android Studio 按照之前的想法，在activity_main.xml中用LinerLayout进行软件主页面底部导航栏的财务管理、财务查询按钮、标题栏进行布局然后在中间布局一个Fragment控件，实现内容窗口的切换；

（3）分别在activity_query.xml和activity_management.xml写入财务管理界面内容和财务查询界面内容，利用TextView以及EditText控件布局内容。

（4）在soft1614080902119MainActivity.java中编写代码，获取activity_main.xml中的控件按钮并监听，根据监听到的内容实现Fragment控件中界面的切换（activity_query.xml和activity_management.xml的切换）。

（5）在activity_management.xml添加一个保存按钮，并在soft1614080902119management_Fragment.java中获取这个按钮，设置监听事件，当点击按钮就会弹出“保存成功”的提示信息。

## 4.实验结果
财务管理界面截图
![image](https://github.com/MaZongXin/android-labs-2018/blob/master/soft1614080902119/4picture1.jpg)

点击财务管理界面底部的保存按钮，显示“保存成功字样”，运行截图
![image](https://github.com/MaZongXin/android-labs-2018/blob/master/soft1614080902119/4picture3.jpg)

点击底部导航栏的财务查询按钮，运行截图
![image](https://github.com/MaZongXin/android-labs-2018/blob/master/soft1614080902119/4picture2.jpg)

## 5.实验体会
通过此次实验，我学会了对一个软件界面的基本布局。一开始做这个实验，真的是抓破头皮，做了半天也没做出个所以然
出来，后来，通过不断的百度，看博客大神写的代码，再根据自己的需求，改写代码变成自己的，实现自己要的功能。记
得有个地方，为了在LinerLyout中的Fragment中的button实现监听事件，结果因为把监听代码放错了地方，导致每次运
行软件调试都闪退，查找了大半天也不知道怎么回事，所幸，最好还是发现了问题，结果了这个问题，成功的完成了实验
的基本布局。这次实验，让我了解到一个界面布局的难度系数是多大。
