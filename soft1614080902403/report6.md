# 第六次实验
## 1.实验目标
1、掌握Android网络访问方法；
2、理解XML和JSON表示数据的方法。
3、在个人目录中创建一个表示数据的XML或JSON文件；
4、数据文件代码提交之后从GitHub获取文件URL；
5、在应用中通过网络编程访问GitHub的数据文件；
6、在应用中解析并显示文件所包含的数据；
7、将应用运行结果截图。
## 2.实验步骤
1、将拍照或者从相册选择的图片进行Base64编码。
2、使用HttpUtils类，将图片数据Post到接口，获取返回的json信息。
3、解析json字符串为JSONObject对象，判断status来判断识别是否成功，来进行相应的交互。
## 3.实验结果
 ![image](https://raw.githubusercontent.com/w123rq/android-labs-2018/master/soft1614080902403/pic6_1.png)
 ![image](https://raw.githubusercontent.com/w123rq/android-labs-2018/master/soft1614080902403/pic6_2.png)
## 4.实验体会
 本次实验目的是掌握Android网络请求的方法，为了方便使用了一个HttpUtils类，在一个请求线程内，通过submitPostData方法，将Base64编码后的图片信息发送至服务端，服务端返回结果后，将Json串进行解析，并根据Json对象的内容，进行相应的操作，这样完成一般网络交互的过程。在本次实验过程中，为了更好的兼容性，避免一些兼容性问题，没有使用二进制方式上传图片，而是使用了Base64方式，不过这样可能会浪费一些传输信息量，所以在Bitmap2StrByBase64方法内对图片进行了压缩以平衡质量和效率。通过本次实验，我更加熟悉了Android网络编程的相关流程和原理。