# 第五次实验
+
+## 1.实验目标
+
+掌握android app中的数据储存功能
+## 2.实验步骤
+（1）在xml布局上，添加SAVE按钮
+（2）为实现计数器的查看历史记录功能，新添增一个SAVE 点击按钮,在原先的Soft1614080902338Activity上进行对此按钮的监听
+     在处理SAVE事件时保存数据（inputText，outputText）；创建文件时若没有即立即创建
+（3）采用文件存储方式，存储到info.text文件上
+（4）文价存储在Tool>>Android>>Android Device Monitor，找到data文件夹，并找到info.text文件，将其导出
+（5）运行截图；
+## 3.实验结果
+
+![结果](https://github.com/kebo24/android-labs-2018/blob/master/soft1614080902338/%E8%BE%93%E5%85%A5.png)
+![结果](https://github.com/kebo24/android-labs-2018/blob/master/soft1614080902338/%E6%A3%80%E6%B5%8B.png)
+![结果](https://github.com/kebo24/android-labs-2018/blob/master/soft1614080902338/%E5%AD%98%E5%82%A8.png)
##4.实验体会：
+Android 又出错了，上次好不容易搞好，才经历了实验3,4，现在又报错，很长时间花在调整它上。我做的是计算器，印象中计算器存储功能好像不多吧。
+这次实验用的是文件存储，输入输出流，这是java的知识点，可能是自己的基础太差，好多东西都得从头开始学。我点击按钮尝试过跳转页面存储，但最后感觉计算器这样来
+设计存储好像挺奇怪的。最后还是直接存储在文件里面。继续努力！！！
