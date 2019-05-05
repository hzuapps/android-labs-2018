# 第五次实验

 ## 一、实验目的
 掌握在Android App中存储数据
 
 ## 二、实验内容
将应用产生的数据保存到文件存储中；<br> 
说明使用的文件存储方式：内部 or 外部；<br> 
将运行结果截图。
 
 ## 三、实验步骤
1、首先用git工具将代码仓库复制到本地后进行修改。  

2、	1）为ThirdActivity中的发帖按钮添加点击事件，使其跳转到FourActivity。  
	2）创建一个新的Activity文件————FourActivity.java,在该Acvitity中编写发帖功能，进行发帖，并将帖子的内容保存到文件中。  
	final EditText editText=(EditText) findViewById(R.id.editText_3);  
        Button button4=(Button)findViewById(R.id.button_3);  
        button4.setOnClickListener(new View.OnClickListener() {  
            @Override  
            public void onClick(View view) {  
                SharedPreferences.Editor editor=getSharedPreferences("data",MODE_PRIVATE).edit();  
                editor.putString("发帖的内容",editText.getText().toString());  
                editor.apply();  
            }  
        });  

3.实验运行成功后将文件git push 上传到本地仓库

 
 ## 四、实验截图
 *发帖界面<br>
 ![image](https://github.com/LiuYB135/android-labs-2018/blob/master/com1614080901141/5_1.jpg)<br>
 *存储文件、打开文件内容<br>
 ![image](https://github.com/LiuYB135/android-labs-2018/blob/master/com1614080901141/5_2.jpg)<br>
 
 
 ## 五、实验体会
       在这次实验中，实现了将数据存储起来。在存储的过程中，我使用了SharedPreferences存储，在了解了安卓有几种存储方式后，
	   我发现SharedPreferences存储是不同于其他的存储方式，它是利用键值对的方式来存储数据的。很前后端传递数据时所需使用的
	   Json。  
	   通过这次实验，了解到了数据保存的重要性，也体验到了实时存储的趣味！！！
	   