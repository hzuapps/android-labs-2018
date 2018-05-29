## 一、实验目的
掌握在Android应用中使用图片等资源的方法。

## 二、实验要求
在界面上显示至少一张图片（按照自己的题目添加）；<br>
提交res/drawable及图片使用的代码；<br>
提交res/values, res/layout等其他代码；<br>
将应用运行结果截图，放到实验报告中；<br>
点击图片（或按钮）时，打开另一个Activity。<br>

## 三、实验步骤
 1. 定义该项目的UI页面设计需求(通过使用知乎日报官方app来了解界面的相关布局)
    并考虑使用Material Design风格应用

 2. Android Studio 环境开发<br>

 （1）.使用官方提供的Navigation Drawer Acvitity为基础；<br>
 （2）.引入 rollviewpager 库，实现图片轮播效果，并重写部分代码实现文字图片轮播，在网络请求没有返回数据时，使用本地Loading.png做图片过度展示；<br> 
 （3）.引入 okhttp 库，实现日报热门消息和消息内容相关HTTP API的处理，并显示效果；<br>
 （4）.引入 gson 库，方便快速封装 http response 的 json数据，方便控件调用处理；<br>
 （5）.对消息内容Acvityty 使用WebView 进行内容显示，因为日报消息API返回json的body字段均为HTML格式，可直接配合CSS进行展示。<br>
  部分响应实例：
 ```
    {
      body: "<div class="main-wrap content-wrap">...</div>",
      image_source: "Yestone.com 版权图片库",
      title: "深夜惊奇 · 朋友圈错觉",
      image: "http://pic3.zhimg.com/2d41a1d1ebf37fb699795e78db76b5c2.jpg",
      share_url: "http://daily.zhihu.com/story/4772126",
      js: [ ],
      recommenders": [
          { "avatar": "http://pic2.zhimg.com/fcb7039c1_m.jpg" },
          { "avatar": "http://pic1.zhimg.com/29191527c_m.jpg" },
          { "avatar": "http://pic4.zhimg.com/e6637a38d22475432c76e6c9e46336fb_m.jpg" },
          { "avatar": "http://pic1.zhimg.com/bd751e76463e94aa10c7ed2529738314_m.jpg" },
          { "avatar": "http://pic1.zhimg.com/4766e0648_m.jpg" }
      ],
      ga_prefix: "050615",
      section": {
          "thumbnail": "http://pic4.zhimg.com/6a1ddebda9e8899811c4c169b92c35b3.jpg",
          "id": 1,
          "name": "深夜惊奇"
      },
      type: 0,
      id: 4772126,
      css: [
          "http://news.at.zhihu.com/css/news_qa.auto.css?v=1edab"
      ]
  }
  ```
 （6）.运行程序，并截图保存。 <br>

 3. 使用Git将代码提交到自己的库中：https://github.com/soft1606081301318/android-labs-2018 <br>
 4. 在自己的GitHub库上创建和发送Pull Request（注意查看Changed files）<br>
 5. 在GitHub中使用Markdown文件编写实验报告<br>

## 四、实验结果<br>

 ![image_one](https://raw.githubusercontent.com/0r2dev/android-labs-2018/master/soft1606081301318/screenshot3_1.png "截图一")<br>
 ![image_two](https://raw.githubusercontent.com/0r2dev/android-labs-2018/master/soft1606081301318/screenshot3_2.png "截图二")<br>
 从图片轮播点击后进入ContentActicity<br>
 ![image_three](https://raw.githubusercontent.com/0r2dev/android-labs-2018/master/soft1606081301318/screenshot3_3.png "截图三")<br>

## 五、实验体会<br>
1.通过使用不同的库和框架，可以方便我们更迅速更好的进行Android开发(以下为该项目到目前为止所使用的第三方库)<br>
```
    implementation 'com.android.support:design:27.1.1'
    implementation 'com.jude:rollviewpager:1.4.5'
    implementation 'com.squareup.okhttp3:okhttp:3.10.0'
    implementation 'com.squareup.okio:okio:1.14.0'
    implementation 'com.google.code.gson:gson:2.8.4'
```
2.网络请求的异步与同步问题需要更为细心的去处理，分辨不同场景下两种方式的优与劣<br>
3.需要考虑相关缓存问题,不过该项目没有使用<br>
