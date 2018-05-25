# 第六次实验 
Android网络编程。
## 1. 实验目标
1.    掌握Android网络访问方法；  
2.    理解XML和JSON表示数据的方法。 
## 2. 实验内容  

1    在个人目录中创建一个表示数据的XML或JSON文件；  
2    数据文件代码提交之后从GitHub获取文件URL；  
3    在应用中通过网络编程访问GitHub的数据文件；  
4    在应用中解析并显示文件所包含的数据；  
5    将应用运行结果截图。  

## 3. 实验步骤

1    打开Android Studio，新建一个Soft1614080902335Activity6,还有对应的layout.xml；  
2    通过HttpURLConnectionr类来建立对URL的连接；  
3    对于解析网络上的Json，必须先通过将其转换为字节数组，然后在进行操作，所以这里使用到了InputStream类；  
4    将得到的字节数组通过JSONObject类建立对象；  
5    通过对成员变量（key）获取对应的值（value）；  
6    在通过findViewById获取控件Id，在用setText设置控件文本；  
7    代码实现后，通过git将app目录结构且有编码、有添加的文件先储存在自己clone下来的目录下，后上传到GitHub。  
  
git指令代码如下：  
    git add java/*  
    git add layout/*  
    git commit -m "#6 #994 QQ the 6th lab"  
    git push  

8    继续上传report6.md文件，写实验报告  
## 4. 实验结果
1    虚拟机运行结果：  
  
![Image text](https://github.com/ChenchenJT/android-labs-2018/blob/master/soft1614080902335/%E5%AE%9E%E9%AA%8C%E5%85%AD%E6%88%AA%E5%9B%BE1.png)  

  
2    通过Log.v输出字节数组：  
  
![Image text](https://github.com/ChenchenJT/android-labs-2018/blob/master/soft1614080902335/%E5%AE%9E%E9%AA%8C%E5%85%AD%E6%88%AA%E5%9B%BE2.png)  
  
## 5.实验体会  
1    这次实验是解析网络上的Json，通过自己查找Json书写格式和获取方法写的，这次实验收获挺大的；  
2    这次实验一开始一直出错在Json格式，原来到最后是没有点击Raw。
