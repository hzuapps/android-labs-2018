 # 实验目标
 ## 1.掌握Android网络访问方法；
 ## 2.理解XML和JSON表示数据的方法。
 # 实验内容
 ## 1.在个人目录中创建一个表示数据的XML或JSON文件；
 ## 2.数据文件代码提交之后从GitHub获取文件URL；
 ## 3.在应用中通过网络编程访问GitHub的数据文件；
 ## 4.在应用中解析并显示文件所包含的数据；
 ## 5.将应用运行结果截图。
 # 实验步骤
 ## 1.在soft1614080902239文件夹下新建一个content.json文件；
 ## 2.通过git bash把content.json上传到自己的github库下；
 ## 3.点击github下的content.json文件，点击右上角的 raw 按钮，地址栏的地址即content.json的url地址；
 
 ## 4.为了能够连接网络，需要在AndroidMainfest.xml中添加相应权限：
 ```
 <uses-permission android:name="android.permission.INTERNET" />
 <uses-permission android:name="android.permission.WRITE_EXTERNAL_STORAGE" />
 <uses-permission android:name="android.permission.ACCESS_WIFI_STATE" />
 <uses-permission android:name="android.permission.CHANGE_WIFI_STATE" />
 <uses-permission android:name="android.permission.CHANGE_NETWORK_STATE" />
 <uses-permission android:name="android.permission.ACCESS_NETWORK_STATE" />
 ```
 ## 5.运行截图
 ## 6.提交创建的文件
 # 实验结果
 ! https://raw.githubusercontent.com/1614080902239/android-labs-2018/master/soft1614080902239/777.png
 # 实验体会
 ## 本次实验通过网络编程获取和解析json文件，一开始没有注意到json的格式问题，导致运行时出现问题，后面调整过来就好了，界面的布局相对有点简陋，但是经过这次的实验，更加懂得了做什么都还是要很细心，特别是写程序方面，一丁点的错误都会毁掉整个程序，很感谢室友和老师的指导，后面还会继续努力的。
