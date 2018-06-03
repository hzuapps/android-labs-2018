# 第五次实验 
## 1.实验目标 
掌握在Android App中存储数据

## 2.实验内容 
①将应用产生的数据保存到文件存储中；                    
②说明使用的文件存储方式：内部；                
③将运行结果截图。      

## 3.实验步骤 
①因为是本地阅读器且只需保存阅读进度数据等简单内容就可，所以选择将文件保存在内部；                         
②类似于将数据存储到文本中，Context类中提供了一个openFIleInput（）方法，用于从文本中读取数据。这个方法
 只接收一个参数即要读取文件的文件名，系统在默认目录中找到这个文件后返回一个FilleInputStream对象，得到这
 个对象后通过java IO流就可以将数据读取出来了。

## 4.实验结果 
在我的手机（小米)中无法跳转，所以我修改了代码，并且使用自己的备用机（三星）进行调试。但背景无法显示
![image](https://github.com/Flash404/android-labs-2018/blob/master/Main.png) 
![image](https://github.com/Flash404/android-labs-2018/blob/master/Browser.png) 
![image]( https://github.com/Flash404/android-labs-2018/blob/master/ReadBook.png) 

## 5.实验体会 
之前也做过在Edit中输入内容，然后保存在相应的文件中。但因为是阅读器。而且之前原计划是做磁力BT的，但因为
搜索磁力相关一直没弄好。所以又换成比较简单和自己喜欢的阅读器，耽搁了较多时间。因此app还有较多问题没弄好。
