# 实验六：Android网络编程
## 实验目标
1. 掌握Android网络访问方法；
2.理解XMl和JSON表示数据的方法;
## 实验内容（选做一）
1. 在个人目录中创建一个表示数据的XML或JSON文件；
2. 数据文件代码提交之后从GitHub获取文件URL；
3. 在应用中通过网络编程访问GitHub的数据文件；
4. 在应用中解析并显示文件所包含的数据；
5. 将应用运行结果截图。
## 实验步骤
1. 没有自己创建JSON文件，而是通过在网上查找实时更新的天气预报API文档，通过URL类和HttpURLConnection类从网上
   读取数据，存入Stringbuffer中。
2. 用JSONObject 读取 API文档中的室外温度、风向、湿度数据，然后添加到TextView中。
## 实验截图
![](https://github.com/hzutanziyang/android-labs-2018/blob/master/soft1614080902227/%E7%AC%AC%E5%85%AD%E6%AC%A1%E5%AE%9E%E9%AA%8C%E6%88%AA%E5%9B%BE.jpg?raw=true)
## 实验体会
   通过这次实验，让我学习到了Android网络编程的应用，这次的实验难度还是很大的，因为很多细节的东西都没有搞懂，
   因为不是自己定义的JSON串，所以读取方式和格式困扰了自己很久，还有在子线程中不能直接调用已定义的TextView
   控件，这个在请教同学后才知道要通过runOnUiThread回到主线程调用才不会出现异常。
