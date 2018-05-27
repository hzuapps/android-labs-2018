# 第四次实验
## 1.实验目的
Android界面设计编程  
## 2.实验步骤
1.打开实验3时的工程项目  

2.在second_activity.xml中去掉ImageView标签，并重写布局。对于我这个课题，我选的是做一个简单计算器，因此我用AbsoluteLayout布局  

3.写两个TextView标签counting、result，一个用显示输入的式子，一个用来显示结果。并将它们放入一个大的TextView标签textView里面，方便进行调整。效果如下图:    

![Image text](https://github.com/ccxm/android-labs-2018/blob/master/soft1614080902419/4.1.png)  

4.接下来放键盘，由于键盘太多个了，所以我决定建立一个四行四列子布局GridLayout，代码下如图:    

![Image text](https://github.com/ccxm/android-labs-2018/blob/master/soft1614080902419/4.2.png)  

效果如下图：   

![Image text](https://github.com/ccxm/android-labs-2018/blob/master/soft1614080902419/4.3.png)  

5.最后还有一个0和=号，用一个LinearLayout的子布局存放，代码下如图：  

![Image text](https://github.com/ccxm/android-labs-2018/blob/master/soft1614080902419/4.4.png)  

效果如下图：  

![Image text](https://github.com/ccxm/android-labs-2018/blob/master/soft1614080902419/4.5.png)  

6.至此，界面已经设计好了，效果如下图：  

![Image text](https://github.com/ccxm/android-labs-2018/blob/master/soft1614080902419/4.6.png)  

7.在Second_Acitvity写监听函数，依次监听每个键盘，代码如下图：    

![Image text](https://github.com/ccxm/android-labs-2018/blob/master/soft1614080902419/4.7.png)  

8.编译运行

9.打开git bash，将文件夹push上github，向老师提交pull request.  

## 3.实验结果    

![Image text](https://github.com/ccxm/android-labs-2018/blob/master/soft1614080902419/4.8.PNG)  

## 4.实验心得
总体实验难度不大，但是界面要做得好看需要用很长时间，特别是调颜色的时候，调了好多次颜色才比较满意。通过这次实验，更深刻地了解了布局，以及知道布局里面还可以添加子布局。  
