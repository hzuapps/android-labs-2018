## 第六次实验报告
 #### 1.用到的库
  1. OKhttp
  2. gson 
 ####2 .实验步骤
  首先要用到json的源数据,先列出一部分
  ```json
[{
	"id": 0,
	"title": "来至网络请求的第的0条标题",
	"content": "来至网络请求的第的0条内容"
},
{
	"id": 1,
	"title": "来至网络请求的第的1条标题",
	"content": "来至网络请求的第的1条内容"
},
{
	"id": 2,
	"title": "来至网络请求的第的2条标题",
	"content": "来至网络请求的第的2条内容"
},
{
	"id": 3,
	"title": "来至网络请求的第的3条标题",
	"content": "来至网络请求的第的3条内容"
},
{
	"id": 4,
	"title": "来至网络请求的第的4条标题",
	"content": "来至网络请求的第的4条内容"
},
{
	"id": 5,
	"title": "来至网络请求的第的5条标题",
	"content": "来至网络请求的第的5条内容"
},
{
	"id": 6,
	"title": "来至网络请求的第的6条标题",
	"content": "来至网络请求的第的6条内容"
},
{
	"id": 7,
	"title": "来至网络请求的第的7条标题",
	"content": "来至网络请求的第的7条内容"
},
{
	"id": 8,
	"title": "来至网络请求的第的8条标题",
	"content": "来至网络请求的第的8条内容"
},
{
	"id": 9,
	"title": "来至网络请求的第的9条标题",
	"content": "来至网络请求的第的9条内容"
},
{
	"id": 10,
	"title": "来至网络请求的第的10条标题",
	"content": "来至网络请求的第的10条内容"
},
{
	"id": 11,
	"title": "来至网络请求的第的11条标题",
	"content": "来至网络请求的第的11条内容"
},
{
	"id": 12,
	"title": "来至网络请求的第的12条标题",
	"content": "来至网络请求的第的12条内容"
},
{
	"id": 13,
	"title": "来至网络请求的第的13条标题",
	"content": "来至网络请求的第的13条内容"
},
{
	"id": 14,
	"title": "来至网络请求的第的14条标题",
	"content": "来至网络请求的第的14条内容"
},
{
	"id": 15,
	"title": "来至网络请求的第的15条标题",
	"content": "来至网络请求的第的15条内容"
},
{
	"id": 16,
	"title": "来至网络请求的第的16条标题",
	"content": "来至网络请求的第的16条内容"
},
{
	"id": 17,
	"title": "来至网络请求的第的17条标题",
	"content": "来至网络请求的第的17条内容"
},
{
	"id": 18,
	"title": "来至网络请求的第的18条标题",
	"content": "来至网络请求的第的18条内容"
}
```
然后就是从这个链接上获取json数据
``` https://raw.githubusercontent.com/MoxinHuoHuo/android-labs-2018/master/com1614080901217/jsonFile.json ```


![](https://github.com/MoxinHuoHuo/android-labs-2018/blob/master/com1614080901217/%E6%88%AA%E5%9B%BE/%E5%AE%9E%E9%AA%8C5.jpg)
![](https://github.com/MoxinHuoHuo/android-labs-2018/blob/master/com1614080901217/%E6%88%AA%E5%9B%BE/%E5%AE%9E%E9%AA%8C%E4%BA%94.jpg)
核心代码
```java
private void initDataByJson() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                OkHttpClient okHttpClient = new OkHttpClient();
                Request request = new Request.Builder().url("https://raw.githubusercontent.com/MoxinHuoHuo/android-labs-2018/master/com1614080901217/jsonFile.json").build();
                try {
                    Response execute = okHttpClient.newCall(request).execute();
                    String jsonData = execute.body().string();
                    Gson gson = new Gson();
                    List<BianQian> newData = gson.fromJson(jsonData, new TypeToken<List<BianQian>>() {
                    }.getType());
                    bianQianList.addAll(newData);
                    List<String> strings = initTitle(newData);
                    listContent.addAll(strings);
                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            adapter.notifyDataSetChanged();
                        }
                    });

                } catch (IOException e) {
                    e.printStackTrace();
                }

            }
        }).start();
    }
```
 
 #### 实验体会
  这次实验学到的东西还是蛮多的，很多都是自己通过安卓《第一行代码学习》的，这真的是一本很好的入门书籍。不过很可惜的是，因为还没有看完这本书，只是学了点连皮毛都不到的知识，没办法完成整个app。
  在这个最后一个实验里，还有没有写云同步的功能，和这个功能需要服务器端的接口支持，这样才能完成云同步的功能。总的来说，收获还行，锻炼了自己的自学能力。
    
