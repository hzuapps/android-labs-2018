 第六次实验

 ## 一、实验目的
掌握Android网络访问方法；
理解XML和JSON表示数据的方法。
 
 ## 二、实验内容
在个人目录中创建一个表示数据的XML或JSON文件；<br>
数据文件代码提交之后从GitHub获取文件URL；<br>
在应用中通过网络编程访问GitHub的数据文件；<br>
在应用中解析并显示文件所包含的数据；<br>
将应用运行结果截图。<br>

## 三、实验步骤
1、先将仓库上的代码git pull下来<br>
2、然后先在自己的库上建立一个 content.json文件<br>
3、然后建立一个thirdActivity.java进行与json文件进行交互<br>
4、在这次实验中使用HttpURlConnection方式，在代码实现中<br>
    URL url = new URL("https://github.com/chenjiahui-xxz/android-labs-2018/blob/master/com1614080901134/content.json");<br>
                    HttpURLConnection connection = (HttpURLConnection) url.openConnection();<br>
                    connection.setRequestMethod("GET");<br>
                    connection.setConnectTimeout(8000);<br>
                    connection.setReadTimeout(8000);<br>
                    connection.setUseCaches(false);<br>
                    connection.connect();<br>
                    InputStream in = connection.getInputStream();<br>
访问仓库上的content.json文件，再构造一个字节输入流，然后下面在对获取到的输入流进行读取<br>
	   BufferedReader reader=new BufferedReader(input);<br>
最后再通过这个方法对json文件进行解析<br>
	     public void analyzejson()<br>
       {
                try{<br>
                    JSONArray jsonArray=new JSONArray(text);<br>
                    for(int a=0;a<jsonArray.length();a++)<br>
                    {<br>
                        JSONObject jsonObject=jsonArray.getJSONObject(a);<br>
                        String name=jsonObject.getString("name");<br>
                        String price=jsonObject.getString("price");<br>
                        String count=jsonObject.getString("count");<br>
                        String add;<br>
                        add=name+"    "+price+"     "+count;<br>
                        list.add(add);<br>
                        Log.v("结果",add);<br>
                    }<br>
5、最后将自己的app git push 上去<br>

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
