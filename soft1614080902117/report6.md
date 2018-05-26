# 第六次实验

## 一、实验目标

1. 掌握Android网络访问方法；
2. 理解XML和JSON表示数据的方法。

## 二、实验内容（选做一）

1. 在个人目录中创建一个表示数据的XML或JSON文件；
2. 数据文件代码提交之后从GitHub获取文件URL；
3. 在应用中通过网络编程访问GitHub的数据文件；
4. 在应用中解析并显示文件所包含的数据；
5. 将应用运行结果截图。

## 实验内容（选做一）

1. 从网络下载一个文件（图片、MP3、MP4）；
2. 保存到手机，在应用中使用文件；
3. 将应用运行结果截图。

## 三、实验步骤
1.在主类Soft1614080902117Activity中添加一个下载按钮，点击可跳转至Soft1614080902117Activity2
  进入图片下载界面；
  
2.在activity_soft16140809021172.xml中添加EditText控件，使得在EditText中可输入图片下载链接，
  同时添加下载按钮，并添加监听，点击可进行下载并用ImageView显示图片；
 
3.在Soft1614080902117Activity2中添加子线程Thread t=new Thread()；使得可进行多次下载，同时将
  EditText中获取的图片链接用String iPath=editText.getText().toString();进行获取再用
  URL url=new URL(iPath);进行链接，再用InputStream inputStream=url.openStream();打开输出流
  将图片下载转换后关闭输出流inputStream.close();
  
## 四、实验截图
主界面
![image](https://github.com/1614080902117/android-labs-2018/blob/master/soft1614080902117/shiyan6.1.png)
下载
![image](https://github.com/1614080902117/android-labs-2018/blob/master/soft1614080902117/shiyan6.2.png)
## 五、实验体会
  此次实验是通过参考再根据自己需求修改完成的，也大致的了解了Android下载的大概流程，
  获取链接进行连接和转换下载和显示。原本是选做第一个解析JSON文件，但实现过程中不知道
  如何在Android中添加jsoup。
  
