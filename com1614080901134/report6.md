 第六次实验

 ## 一、实验目的
掌握Android网络访问方法；
理解XML和JSON表示数据的方法。
 
 ## 二、实验内容
在个人目录中创建一个表示数据的XML或JSON文件；
数据文件代码提交之后从GitHub获取文件URL；
在应用中通过网络编程访问GitHub的数据文件；
在应用中解析并显示文件所包含的数据；
将应用运行结果截图。

## 三、实验步骤
1、先将仓库上的代码git pull下来
2、然后先在自己的库上建立一个 content.json文件
3、然后建立一个thirdActivity.java进行与json文件进行交互
4、在这次实验中使用HttpURlConnection方式，在代码实现中
    URL url = new URL("https://github.com/chenjiahui-xxz/android-labs-2018/blob/master/com1614080901134/content.json");
                    HttpURLConnection connection = (HttpURLConnection) url.openConnection();
                    connection.setRequestMethod("GET");
                    connection.setConnectTimeout(8000);
                    connection.setReadTimeout(8000);
                    connection.setUseCaches(false);
                    connection.connect();
                    InputStream in = connection.getInputStream();
访问仓库上的content.json文件，再构造一个字节输入流，然后下面在对获取到的输入流进行读取
	   BufferedReader reader=new BufferedReader(input);
最后再通过这个方法对json文件进行解析
	     public void analyzejson()
       {
                try{
                    JSONArray jsonArray=new JSONArray(text);
                    for(int a=0;a<jsonArray.length();a++)
                    {
                        JSONObject jsonObject=jsonArray.getJSONObject(a);
                        String name=jsonObject.getString("name");
                        String price=jsonObject.getString("price");
                        String count=jsonObject.getString("count");
                        String add;
                        add=name+"    "+price+"     "+count;
                        list.add(add);
                        Log.v("结果",add);
                    }
5、最后将自己的app git push 上去

 ## 四、实验截图
 *content.json文件截图<br>
 ![image](https://github.com/chenjiahui-xxz/android-labs-2018/blob/master/com1614080901134/8.png)<br>
 *实验结果截图文件<br>
 ![image](https://github.com/chenjiahui-xxz/android-labs-2018/blob/master/com1614080901134/7.png)<br>

 ## 五、实验体会
     这次实验是Android网络编程，而我使用的是HttpURLConnection的方式进行http请求，在这次实验中我
   使用了一个方法，也就是runOnUiThread（），在使用这个方法前，我了解到Android是不允许在子线程中
   进行UI操作，我们需要通过这个方法将线程切换到主线程，然后再更新Ui元素。在这越来越后的实验中，
   实验难度越来越来大，做实验耗费的时间也越来越大，不过多翻阅书籍，在加上网上的知识，勉强还是
   可以完成老师的要求，希望自己再接再厉。