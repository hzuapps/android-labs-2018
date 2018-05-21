#第六次实验报告

#实验要求    
    
1、掌握Android网络访问方法；    
2、理解XML和JSON表示数据的方法。    

#实验内容   
   
1、在个人目录中创建一个表示数据的XML或JSON文件；    
2、数据文件代码提交之后从GitHub获取文件URL；   
3、在应用中通过网络编程访问GitHub的数据文件；    
4、在应用中解析并显示文件所包含的数据；    
5、将应用运行结果截图。     
     
#实验步骤     
     
1、创建一个JSON文件，记录所要显示的数据，提交到Github；      
     
2、为了支持JSON相应的语法，要从网上下载Android studio的Volley包，然后导入到项目中;         
    
3、在activity_query.xml中建立显示JSON文件数据的文本框；    

4、参考老师所给代码及网上关于Volley网络编程的内容，在Query.class中编写解析JSON文件的代码；     
       
5、在AndroidManifest.xml中添加 <uses-permission android:name="android.permission.INTERNET" />语句，以便程序支持网络连接；    
   
6、在手机上测试APP。    

#实验结果        
     
点击“查询”按钮：     
      
<img width="800" height="800" src="https://raw.githubusercontent.com/GeekLee1998/android-labs-2018/master/soft1612070501311/labpicture/lab6-1.png"/>    
             
断网，再重新点击“查询”按钮：     
      
<img width="800" height="800" src="https://raw.githubusercontent.com/GeekLee1998/android-labs-2018/master/soft1612070501311/labpicture/lab6-2.png"/>       
               
#实验体会      
       
1、由于实验只给了解析JSON文件的代码，没有给出Volley包，所以要自行到网上下载Volley.jar包，并导入项目；  
    
2、解析JSON文件有多种方法，本次实验我所展示的只是其中一种；     

3、数据的显示需要网络的支撑，所以要连接网络来测试APP。         
        
谢谢老师！       




