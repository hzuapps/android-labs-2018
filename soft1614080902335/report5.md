# 第五次实验 
Android存储编程。
## 1. 实验目标
1.    将应用产生的数据存储到数据库中；  
2.    使用UML类图描述表结构；  
3.    将应用运行结果截图。  
## 2. 实验步骤

1    打开Android Studio，新建UserInformationProvider类以及一个Soft1614080902335Activity4,还有对应的layout.xml；  
2    通过继承ContentProvider类来实现数据库功能；  
3    在UserInformationProvider类中新建一个内部类，来辅助数据库的建立；  
4    在对第一次修改资料时采用插入数据库，第二次后使用更新；  
5    在Soft1614080902335Activity4中，实现的是展示功能，使用showUser()函数查询数据库展示；  
6    在Soft1614080902335Activity3中，实现的更新功能，更新数据库update展示；  
7    代码实现后，通过git将app目录结构且有编码、有添加的文件先储存在自己clone下来的目录下，后上传到GitHub。  
git指令代码如下：  
    git add res/*  
    git add drawable/*  
    git add layout/*  
    git commit -m "#5 #994 QQ the 5th lab"  
    git push  

7    继续上传report5.md文件，写实验报告
## 3. 实验结果
1    UserInformationProvider类的uml图：  
  
![Image text](https://github.com/ChenchenJT/android-labs-2018/blob/master/soft1614080902335/%E5%AE%9E%E9%AA%8C%E4%BA%94uml%E7%B1%BB%E5%9B%BE.png)  

  
2    原先的个人信息：  
  
![Image text](https://github.com/ChenchenJT/android-labs-2018/blob/master/soft1614080902335/%E5%AE%9E%E9%AA%8C%E4%BA%94%E6%88%AA%E5%9B%BE2.png)  

  
3    点击修改资料，编辑资料后保存：
  
![Image text](https://github.com/ChenchenJT/android-labs-2018/blob/master/soft1614080902335/%E5%AE%9E%E9%AA%8C%E4%BA%94%E6%88%AA%E5%9B%BE1.png)  

  
## 4.实验体会  
1    实现在存储方式有两种，分别是文件和数据库，文件适合图片类的，数据库适合数值类的；  
2    本次实验中，所运用到的知识比较多，新知识很多，需要慢慢理解消化才写出这个实验；  
3    这次实验也让我懂得了要自己专研，独立自主学习
