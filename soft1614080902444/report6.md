实验六
 一.实验目的
 
 掌握Android网络访问方法；
 
 二.实验内容
 
 (1)从网络下载一个文件（图片、MP3、MP4）
 (2)保存到手机，在应用中使用文件
 (3)将应用运行结果截图
 
 三.实验步骤
 
 1.创建一个新的activity
 
 2.在AndroidManifest.xml-中加入实验6指导书中有关网络通讯uses-permission的设置代码段
 
 3.xml部分EditText用于获取图片的url地址
 并且添加Button用于添加监听通过url地址下载图片 ImageView用于显示下载好的图片
 
 3.开启子线程t进行获取url内容，输入输出，下载图片完成
 
 四.实验截图
 
 ![image](https://github.com/linxin666/android-labs-2018/blob/master/soft1614080902444/6-1.png)
 ![image](https://github.com/linxin666/android-labs-2018/blob/master/soft1614080902444/6-2.png)
 
 
 五.实验体会 
 
 一开始并没有注意到需要在AndroidManifest.xml中添加有关有关网络通讯uses-permission的网络通讯设置，所以在运行程序程序总是自动闪退，后来添加添加后程序就能正常运行。正常运
 行后我发现我输入的网址没法显示图片，想了很久，检查代码并无问题，后来我才发现，图片网址必须是erl网址，也就是说需要jpg为后缀的网址，最终改正才完成实验。
