-实验六
-=
-一.实验目的
--
-掌握Android网络访问方法；
-  
-二.实验内容
--
-在个人目录中创建一个表示数据的XML或JSON文件；<br>
-创建一个sevlet服务器，通过json将数据传送给android程序；<br>
-在应用中解析json所包含的数据；<br>
-将应用运行结果截图。<br>
-三、实验步骤
--
-1、创建一个服务器
-2、利用OkHttpClient client = new OkHttpClient();获取OkHttpClient对象
-3、OkHttp已经将输入输出流封装好
-4、 Gson gson = new Gson();
     User user = gson.fromJson(response.body().charStream(), User.class);这段代码将会获取服务器上传回来
的josn对象并将json对象赋值到JAVABEAN中
-5、返回主线程去更新UI利用runOnUiThread（）便可
-四、实验体会
![image](https://github.com/unihaoke/android-labs-2018/blob/master/soft1609081602618/889509428610662967.jpg)
--
-这次的实验主要使用了两个框架：OkHttp和Gson极大的简化了我们的代码，有利于我们快速开发app。
使用Glid直接获取网络上的图片
