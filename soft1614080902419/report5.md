# 第五次实验
## 1.实验目的
Android存储编程 
## 2.实验步骤
1.打开实验4的工程项目  

2.分析要储存的数据，我要储存的数据有两个，一个是上次运算的式子，一个是上次运行的结果  

3.在Second_Activity里新建一个函数sava，建立写文件流，在里面新建两个文件counting.txt和result.txt。因为每次都只用保存上次的式子，所以把写文件的属性写成Context.MODE_PRIVATE，完整代码为：out = openFileOutput("counting.txt", Context.MODE_PRIVATE);代码如下图： 

![Image text](https://github.com/ccxm/android-labs-2018/blob/master/soft1614080902419/5.0.png)  

4.在触发监听那里写上触发函数，当点击“=”号的时候，就开始写文件，其代码如下图：  

![Image text](https://github.com/ccxm/android-labs-2018/blob/master/soft1614080902419/5.1.png)  

5.编译运行  

6.打开git bash，将文件夹push上github，向老师提交pull request.

## 3.实验结果
运行截图：  

![Image text](https://github.com/ccxm/android-labs-2018/blob/master/soft1614080902419/5.2.png)  

文件截图：  

![Image text](https://github.com/ccxm/android-labs-2018/blob/master/soft1614080902419/5.3.png)  

## 4.实验心得
这次实验总的难度不大，但也十分曲折。一开始看了一下书，发现和Java写文件差不多，就很快写好了。然后运行，运行了好几遍都没发现文件在哪里。想着会不会是代码发生错误了，然后加上个打印语句，发现没有错误。然后就从硬盘里找data/data/目录，一直没找到。后来翻了一下书，原来那个是在应用里面的数据，并不是项目的数据。然后运行，打开Android Device Monitor ，进入File Explorer，发现里面的文件怎么都点不了，然后书上说可能有bug。没办法，后来放在手机上运行，打开re文件管理器，真的找到了，看到里面有counting.txt和result.txt这两个文件，很高兴，终于做好了。
