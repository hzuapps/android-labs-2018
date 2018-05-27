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
     
1、创建一个JSON文件，记录所要显示的数据，提交到Github上；      
     
2、在activity中建立一个listView控件，绑定id,用来展示json文件中的数据；   
    
3、在上述activity的xml文件创建用于获取github库中json文件内容的方法，同时将获取到的内容置于textView中展示；    

4、测试并截图    

#实验结果          
      
![image](https://github.com/Yxiansheng/android-labs-2018/blob/master/com1614080901108/report6Img/745576919903581344.jpg)    
               
#实验体会      
       
这次实验学会了如何访问远端的json文件，难度不高，不过在处理json文件的路径时遇到一点麻烦，要将https://github.com改为https:/raw.githubusercontent.com
才能获取github库中的实际内容，要不然返回一个html文档。  



