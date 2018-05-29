# 第六次实验

## 1.实验目标
掌握Android网络访问方法  
## 2.实验内容
在个人目录中创建一个表示数据的XML或JSON文件<br>
数据文件代码提交之后从GitHub获取文件URL<br>
在应用中通过网络编程访问GitHub的数据文件<br>
在应用中解析并显示文件所包含的数据；<br>
将应用运行结果截图。<br>
## 3.实验步骤 
（1）、利用www.bejson.com校验json格式，并复制创建json文件上传至自己的GitHub。记下其URL         
（2）、新建activity，在app里的其中一个activity新建监听按钮，实现点击它跳转到该新的activity。         
（3）、在AndroidManifest.xml中赋予其有关Internet的权限。   
（4）、创建线程，创建URL对象读取url，使用url的方法获取数据。     
（5）、利用输入流将url获取的数据以字符串读入  
（6）、解析json，利用key获取对应的value，然后将其输出在listview上。    
（5）、返回主线程  
## 4.实验结果

![image](https://github.com/xiaojiahao/android-labs-2018/blob/master/soft1614080902319/sy6.png)

## 5.实验体会
这次实验让我了解了一些线程和网络json，url有关的知识，AndroidManifest.xml是放权限的，这次我在一个activity放一张几百k的壁纸，卡爆，
以后我会注意点，不能乱塞。
