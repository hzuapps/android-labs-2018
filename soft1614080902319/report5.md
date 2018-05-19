# 第五次实验

## 1.实验目标
掌握在Android App中存储数据。

## 2.实验步骤 
（1）、在res.layout中的activity5_main5.xml中设置一个TextView，一个EditText，两个button，并设置好id。         
（2）、在MainActivity5.java中加入按钮监听，点击按钮保存数据时调用方法save，另一个为readsy5。       
（3）、实现一个保存数据的方法save，用openFileOutput、OutputStreamWriter、BufferedWriter，其中的write等方法实现。  
（4）、实现一个读取数据的方法readsy5，用FileInputStream、openFileInput和其中的read等方法实现。   
（5）、记得关闭数据流使用.close，使用Toast.makeText通知保存数据成功和读取文件数据。由于使用MODE_APPEND，会将之前保存的数据一起读入。
## 3.实验结果

![image](https://github.com/xiaojiahao/android-labs-2018/blob/master/soft1614080902319/sy5(2).png)
![image](https://github.com/xiaojiahao/android-labs-2018/blob/master/soft1614080902319/sy5(1).png)
## 4.实验体会
这次实验参考了很多网上的代码，用老师的代码风格做了监听和保存数据，用网上的方法做了读取数据，成功运用了Toast.makeText。  
以后再也不熬夜写文档了，没放到自己的文件夹下面，失策啊，以后会更加慎重的，对不起老师啊。
   
    
