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
1. 创建JSON文件并上传到github上，取得网址通过URL类和HttpURLConnection类从网页
   读取数据，存入Stringbuffer。
2. 利用JSONObject 解析JSON文件并转为String，添加到ListView。
## 实验截图
![image](https://github.com/JWL1ang/android-labs-2018/blob/master/soft1614080902326/experiment%206.jpg)
## 实验体会
   通过这次实验，学习到了Android网络编程的应用，开始测试时总是由于线程超时退出页面，添加了子线程后正常下载，完成后调用runOnUiThread回到主线程添加进ListView，
   解析JSON时需对应元素输出，否则会无结果。
