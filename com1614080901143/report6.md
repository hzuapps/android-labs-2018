## 一.实验目标
（1）掌握Android网络访问方法；

（2）理解XML和JSON表示数据的方法。

## 二.实验内容（选做了第一个）
（1）在个人目录中创建一个表示数据的XML或JSON文件；

（2）数据文件代码提交之后从GitHub获取文件URL；

（3）在应用中通过网络编程访问GitHub的数据文件；

（4）在应用中解析并显示文件所包含的数据；

（5）将应用运行结果截图。

## 三.实验步骤
（1）通过网上的json在线编辑器，然后编写一个json文件，编写完下载到本地。

（2）然后把json文件提交到自己github上的库中

（3）然后在Android studio 上创建一个新的Activity,从github获取json文件URL,再通过BufferedReader对服务器的流进行读取，再调用函数进行json解析。

（4）在AndroidManifest.xml添加对应代码获取网络权限

（5）提交实验。

## 四.实验结果
https://github.com/Chengzid/android-labs-2018/blob/master/com1614080901143/%E5%AE%9E%E9%AA%8C%E5%85%AD%E6%88%AA%E5%9B%BE2.jpg
https://github.com/Chengzid/android-labs-2018/blob/master/com1614080901143/%E5%AE%9E%E9%AA%8C%E5%85%AD%E6%88%AA%E5%9B%BE1.jpg
## 五.实验体会
1.这个实验主要考验我们对网络权限的理解，以及对json解析的理解；<br>
2.实验过程中要特别注意json文件的格式，否则很容易出错
