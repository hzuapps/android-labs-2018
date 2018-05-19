## 1.实验要求  
掌握在Android App中存储数据   
## 2.实验内容  
根据选题要求使用文件存储;  
进行创建文件操作;  
进行文件读取操作;  
将应用运行结果截图.  
## 3.实验步骤
(1). 把两个xml的TextView换成EditText来分别进行编辑与显示；  
(2).在secondActivity.java文件中定义save（）函数，还有onDestory()函数定义返回时保存文件；  
(3).在thirdActivity.java文件中定义load()函数来读取文件。
## 4.实验结果  
添加日记  
![image](https://github.com/Cai-ZT/android-labs-2018/blob/master/com1614080901237/shiyan5-1.png)  
查看日记  
![image](https://github.com/Cai-ZT/android-labs-2018/blob/master/com1614080901237/shiyan5-2.png)

## 5.实验体会  

这次实验，我是用文件存储第一种方式进行持久化。这个方式用java的IO流来进行操作文件。这次形成一个名为data的文件，
然后在查看中查询名为data 的文件进行读取，然后显示出来。实验过程操作跟编写Java中的IO流差不多，比较易懂。
