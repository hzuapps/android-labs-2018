# 实验目标
#### 1.掌握Android网络访问方法；
#### 2.理解XML和JSON表示数据的方法。
# 实验内容
#### 1.在个人目录中创建一个表示数据的XML或JSON文件；
#### 2.数据文件代码提交之后从GitHub获取文件URL；
#### 3.在应用中通过网络编程访问GitHub的数据文件；
#### 4.在应用中解析并显示文件所包含的数据；
#### 5.将应用运行结果截图。
# 实验步骤
#### 1.在soft1606081301233文件夹下新建一个Text.json文件；
#### 2.通过git bash把Text.json上传到自己的github库下；
#### 3.点击github下的Text.json文件，点击右上角的 raw 按钮，地址栏的地址即Text.json的url地址；
#### 4.新建一个ThirdActivity.java文件，定义获取json文件的方法：新建url对象,使用url.openConnection()去访问，获得请求，使用输入流InputStream读取请求的数据
```
//获取Text.json
public void getJson()
```
#### 定义解析json文件的方法，通过键取得相应的值，添加到数据类型ArrayList：
```
//解析Text.json
 public void parseJson()
```
#### 5.为了能够连接网络，需要在AndroidMainfest.xml中添加相应权限：
```
<uses-permission android:name="android.permission.INTERNET" />
<uses-permission android:name="android.permission.WRITE_EXTERNAL_STORAGE" />
<uses-permission android:name="android.permission.ACCESS_WIFI_STATE" />
<uses-permission android:name="android.permission.CHANGE_WIFI_STATE" />
<uses-permission android:name="android.permission.CHANGE_NETWORK_STATE" />
<uses-permission android:name="android.permission.ACCESS_NETWORK_STATE" />
```
#### 6.运行截图
#### 7.提交创建的文件
# 实验结果
![image](https://github.com/xiaoshanshanlin/android-labs-2018/blob/master/soft1606081301233/lab6.png)
# 实验体会
#### 1.本次实验通过网络编程获取和解析json文件，经过查询相关资料，再参考其他同学的实验，然后做出，不过界面的布局有点不齐；
#### 2.子程序不能用来更新UI，会造成错误，使用runOnThread返回主线程；
#### 3.最开始不知道json文件的格式，弄了挺久，多次上传后又删除；还要注意添加权限；
#### 4.经过本次实验学到了一些新的知识，但还只是最最基础的，仍然需要进一步学习；最后，谢谢老师对我们的耐心指导。
