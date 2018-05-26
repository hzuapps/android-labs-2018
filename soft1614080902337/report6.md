# 第六次实验 

## 1. 实验目标    
1.掌握的Android网络访问方法;  
2.理解XML和JSON表示数据的方法。  
 
## 2. 实验步骤  
1、阅读实验要求：https：//github.com/hzuapps/android-labs-2018/labels/Lab  
2、选择一个实验内容：一个是“解析JSON”；另外一个是“下载文件”，我选择的是解析JSON。      
3、在APP下创建Assets文件下，新建一个Json文件，填入合乎规范的Json格式内容，可以参考bejson网站。               
4、将Json文件提交到Github上面，在网址上面获取它的URL，准备做HttpUrl连接。      
5、新建JsonActivity，书写函数：读取获取的Url上的Json文件、解析获取的Json文件。  
6、设置两个按钮监控是否读取、解析成功Json，观察Activity中的TextView显示结果。                 
7、（例行公事)使用Git将代码、截图、报告提交到自己的库中：https：//github.com/YOUR_NAME/android-labs-2018    
$ git pull  
$ git add 学号目录/*  
$ git commit "#12345678 "  
$ git push  
在自己的GitHub库中创建并发送Pull Requset（合并请求），注意是否只改变自己的文件夹。    
在GitHub中使用Markdown文件编写实验报告。


## 3. 实验结果  

![在Android SDK Manager中选择6.0库](https://raw.githubusercontent.com/DcXuhm/android-labs-2018/master/soft1614080902337/实验6截图/实验六1.png "配置教育网下载代理")      
![在Android SDK Manager中选择6.0库](https://raw.githubusercontent.com/DcXuhm/android-labs-2018/master/soft1614080902337/实验6截图/实验六2.png "配置教育网下载代理")  
![在Android SDK Manager中选择6.0库](https://raw.githubusercontent.com/DcXuhm/android-labs-2018/master/soft1614080902337/实验6截图/实验六3.png "配置教育网下载代理")  
![在Android SDK Manager中选择6.0库](https://raw.githubusercontent.com/DcXuhm/android-labs-2018/master/soft1614080902337/实验6截图/实验六4.png "配置教育网下载代理")    

  
 

## 4. 实验体会  

**老师辛苦了！**    
实验中有以下心得：      
1、Android studio中网络编程一块对我来说比较生疏，需要加强Java的学习，尤其是java web和java 输入输出流这里的知识。        
2、Json是一种数据结构，简单来说就是{}代表着对象，[]代表着数组，不管是属性还是值，都需要用""包起来。可以在bejson网址上学习Json   
3、在读取Json文件的时候，通过查找资料，一般分为两种情况：  
①读取自己本地上的文件，在android studio是通过：XXXActivity.this.getClass().getClassLoader().getResourceAsStream("assets/" + "Text.json");返回相应InputStream.  
②读取网络上的地址，获取Url。需要通过“HttpURLConnection conn = (HttpURLConnection)url.openConnection()”并打开连接，再用“conn.getInputStream()” 返回输入流。  
4、在Android中使用Http中的一系列操作可能阻塞主线程，所以我将本次的Json操作方法都放在了子线程中进行。  
5、在本次实验当中，一开始让读取Json和解析Json在同一个事件中进行，发现只能同时执行一个操作，所以分开到了两个事件中去。