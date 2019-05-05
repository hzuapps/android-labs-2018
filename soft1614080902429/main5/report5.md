实验四

一.实验目的

掌握在Android App中存储数据

 二.实验要求

1.根据选题要求使用文件存储

2.将应用产生的数据保存到文件存储中；

3.说明使用的文件存储方式：内部 or 外部；

4.将运行结果截图。

 三.实验步骤

1、首先查看实验要求，然后打开实验四做的android进行补充，最后一个结束答题后，我设计为问题反馈栏目，按钮分别为写入按钮，和校验按钮；

2、然后在layout进行布局，两个文本，两个按钮，然后对按钮进行事件监听，在按钮里面的监听事件，添加文本储存的输入输出流；

3、然后一边通过查看android机子显示的结果，一边对代码进行调整，修改；

4、对实验过程和结果进行截图和保存代码在指定的文件夹；

5、通过git bash上传代码入库，然后在github检查文件是否上传成功

四.实验过程截图

![image](https://github.com/hwp001/android-labs-2018/blob/master/soft1614080902429/main5/%E5%AE%9E%E9%AA%8C%E4%BA%94%E8%BF%87%E7%A8%8B%E6%88%AA%E5%9B%BE/311ec97f951268bca7e4dab3a923a70.png)

！[image](https://github.com/hwp001/android-labs-2018/blob/master/soft1614080902429/main5/%E5%AE%9E%E9%AA%8C%E4%BA%94%E8%BF%87%E7%A8%8B%E6%88%AA%E5%9B%BE/49fd9a408b36462a5ace5886d15e682.png)

五.实验结果截图

第一次自己测试实验（写入的值不可覆盖）


写入

![image](https://github.com/hwp001/android-labs-2018/blob/master/soft1614080902429/main5/%E5%AE%9E%E9%AA%8C%E4%BA%94%E7%BB%93%E6%9E%9C%E6%88%AA%E5%9B%BE/8c5bc6df133899ee5f0df519f35eaeb.png)

校验

![image](https://github.com/hwp001/android-labs-2018/blob/master/soft1614080902429/main5/%E5%AE%9E%E9%AA%8C%E4%BA%94%E7%BB%93%E6%9E%9C%E6%88%AA%E5%9B%BE/6297ad4675d1e5d80928eda80d5ed87.png)

第二次实验测试（写入的值可以覆盖）

写入

![image](https://github.com/hwp001/android-labs-2018/blob/master/soft1614080902429/main5/%E5%AE%9E%E9%AA%8C%E4%BA%94%E7%BB%93%E6%9E%9C%E6%88%AA%E5%9B%BE/493507bce78be15b3419d28aa275f1a.png)

清空

![image](https://github.com/hwp001/android-labs-2018/blob/master/soft1614080902429/main5/%E5%AE%9E%E9%AA%8C%E4%BA%94%E7%BB%93%E6%9E%9C%E6%88%AA%E5%9B%BE/20bf11d537b50d86bb9e648166669f5.png)

校验

![image](https://github.com/hwp001/android-labs-2018/blob/master/soft1614080902429/main5/%E5%AE%9E%E9%AA%8C%E4%BA%94%E7%BB%93%E6%9E%9C%E6%88%AA%E5%9B%BE/a6645731fd9280995aa4c8359c0ddb1.png)


 实验体会

这次实验是一边看视频，一边打的一个代码，还行，主要实验四事件监听弄懂，这次按钮的监听弄得不会那么复杂，主要是输入输出流，上学期没有学好

一边看视频，又要一边百度，弄懂那个代码是什么意思，耗费的时间会比较多，但是也学得比较多，也有在github参考同学们的代码，普遍都是文件存储，

可能文件存储是那里面比较简单的，因为我要设计的软件不需要特别复杂的存储，所以我选用文件存储来弄这个实验，刚开始的时候，写入文本到文件是

没有覆盖的，校验显示出的数值，包括前面写入的也会一起输出，后面在看了视频，就解决了这个问题。


