# 实验五：Android存储编程 

## 实验目标
掌握在Android App中存储数据

## 实验内容一（选做1个）
根据选题要求使用文件存储
将应用产生的数据保存到文件存储中
说明使用的文件存储方式：内部 or 外部
将运行结果截图
 
## 实验内容二（选做1个）
应用数据存储可采用数据库存储
将应用产生的数据存储到数据库中
将应用运行结果截图
 
## 实验提示
重写实验报告，可以网站上直接修改和预览，但是要在自己电脑上执行命令
 
## 实验结果
https://github.com/MrZengXianSheng/android-labs-2018/blob/master/soft1614080902131/%E5%AE%9E%E9%AA%8C%E4%BA%94%E6%88%AA%E5%9B%BE1_%E5%B0%81%E9%9D%A2.png

https://github.com/MrZengXianSheng/android-labs-2018/blob/master/soft1614080902131/%E5%AE%9E%E9%AA%8C%E4%BA%94%E6%88%AA%E5%9B%BE2_%E4%B8%BB%E7%95%8C%E9%9D%A2.png

https://github.com/MrZengXianSheng/android-labs-2018/blob/master/soft1614080902131/%E5%AE%9E%E9%AA%8C%E4%BA%94%E6%88%AA%E5%9B%BE3_%E8%AE%A1%E6%97%B6%E9%A1%B5%E9%9D%A2.png

https://github.com/MrZengXianSheng/android-labs-2018/blob/master/soft1614080902131/%E5%AE%9E%E9%AA%8C%E4%BA%94%E6%88%AA%E5%9B%BE4_%E8%AE%A1%E6%97%B6%E9%A1%B5%E9%9D%A22.png

https://github.com/MrZengXianSheng/android-labs-2018/blob/master/soft1614080902131/%E5%AE%9E%E9%AA%8C%E4%BA%94%E6%88%AA%E5%9B%BE5_%E4%BF%9D%E5%AD%98%E9%A1%B5%E9%9D%A2.png

https://github.com/MrZengXianSheng/android-labs-2018/blob/master/soft1614080902131/%E5%AE%9E%E9%AA%8C%E4%BA%94%E6%88%AA%E5%9B%BE6_%E4%BF%9D%E5%AD%98%E9%A1%B5%E9%9D%A22.png

https://github.com/MrZengXianSheng/android-labs-2018/blob/master/soft1614080902131/%E5%AE%9E%E9%AA%8C%E4%BA%94%E6%88%AA%E5%9B%BE7_%E5%8E%86%E5%8F%B2%E9%A1%B5%E9%9D%A2.png

https://github.com/MrZengXianSheng/android-labs-2018/blob/master/soft1614080902131/%E5%AE%9E%E9%AA%8C%E4%BA%94%E6%88%AA%E5%9B%BE8_%E5%8D%95%E6%9D%A1%E8%AE%B0%E5%BD%95%E9%A1%B5%E9%9D%A2.png
 
## 实验体会
    此次储存编程实验中，由于app需要，我把数据库和本地文件操作都做了。
    
    我的app除了计时计次功能，就是重要的历史记录保存和查询功能，需要用到数据库。数据库我用的是安卓的LitePal框架，它封装了各种SQL数据库操作，使用起来非常方便。LitePal使用前需要导入和配置，这个比较容易，后面就要考虑数据库要怎样设计。我的app要记录某次计时的日期时间照片信息，在这一次计时中，又有不定次数的计名次数据。所以，我的数据库需要建两个表，第一个记录计时信息，第二个是记录计次信息，计次表中有一个属性是number，其值为计时表的相对于数据的id。当数据需要显示的时候，我用的是RecyclerView。
    
    文件操作我用的是调用安卓摄像机拍照，将照片存在安卓根目录的aPicture文件夹中，命名规则为p+计时记录在数据库中的序号.jpg。在历史记录中需要用到图片时，我用URL和Glide图片框架显示在界面上。
