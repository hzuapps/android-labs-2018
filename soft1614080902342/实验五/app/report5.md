一、实验目标

掌握在Android App中存储数据
实验内容一（选做1个）

根据选题要求使用文件存储
将应用产生的数据保存到文件存储中；
说明使用的文件存储方式：内部 or 外部；
将运行结果截图。
实验内容二（选做1个）

应用数据存储可采用数据库存储。
将应用产生的数据存储到数据库中；
使用UML类图描述表结构；
将应用运行结果截图。
二、实验步骤

想要做到内部存储保存到文件中，首先要声明私有变量String file，添加一个写入数据的文本框和确定写入数据的按钮，并为按钮添加一个监听器，用FileOutputStream类型的变量打开这个文件，用OutputStreamWriter类型包装FileOutputStream设为utf-8格式，调用write方法把文本框中的内容写入文本中，注意需要添加异常捕捉，然后记得使用flash刷新和用close关闭资源
   $ git add app
   $ git commit -m "#5#1234 第5次实验+截图+实验报告"
   $ git push
 在自己的GitHub库上找到对应的图片，复制地址
 将复制的地址写入第五次实验的实验截图中（report5.md）
三、实验结果

![image](https://github.com/XuJiaHongHong/android-labs-2018/blob/d26d7ccb3afc5f7cc8988121cbdd5c2a5aa4d110/soft1614080902342/%E5%AE%9E%E9%AA%8C%E4%BA%94/app/%E6%89%93%E5%9C%B0%E9%BC%A0%E5%B0%8F%E6%B8%B8%E6%88%8F.JPG) 


![image](https://github.com/XuJiaHongHong/android-labs-2018/blob/d26d7ccb3afc5f7cc8988121cbdd5c2a5aa4d110/soft1614080902342/%E5%AE%9E%E9%AA%8C%E4%BA%94/app/%E6%9C%89%E5%AD%98%E5%82%A8%E5%8A%9F%E8%83%BD%E7%9A%84.JPG) 


四、实验心得
由于java中已经对读写文件操作的语句有了一定的了解，因此入手还是相对简单一些，但是安卓上的运行结果实在太久了，在测试的时候花了不少时间，好在一次就成功了。
