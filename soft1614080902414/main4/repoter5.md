# 第五次实验

## 1.实验目标
掌握在Android App中存储数据。

## 2.实验步骤 
（1）在layout中的activity_soft1614080902414.xml中设置TextView，EditText，两个button，且设置好id。         
（2）在Soft1614080902414Activity.java中添加按钮监听，当启动到按钮保存数据时调用方法btn_save，读取数据时则调用方法btn_read。       
（3）实现保存数据的方法btn_save时，调用代码中OutputStream的openFileOutput将数据保存于data.txt中，且用write方法将我们写入的字符串变成字符数组，然后显示“数据保存成功”。
（4）实现读取数据的方法btn_read时，用FileInputStream的openFileInput来打开data.txt，然后read方法实现数据的读取，然后显示“保存的数据是？？”。   
（5）此外，关闭数据流使用.close，使用Toast.makeText通知保存数据成功和读取数据。由于使用Toast.LENGTH_SHORT).show()，会将之前保存的数据一起读入。
## 3.实验结果

![image](https://github.com/haoxinchen/android-labs-2018/blob/master/soft1614080902414/main4/6181F5410E0639CB3A6168EAC66D5535.jpg)
## 4.实验体会
这次实验没有及时的去网上查资料，过了很久才来弄，所以一开始并不知道要搞些什么，开始看老师的代码时有些疑惑，开始并不懂存储的方法，之后通过一些网上资料后，
慢慢的懂存储方法的运行过程，感觉又学会了一些东西，开心。
   
  
