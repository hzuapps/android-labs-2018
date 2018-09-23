## 实验五

## 一.实验目的

掌握在Android App中存储数据

## 二.实验内容

根据选题选了SharedPreferences轻量级的存储类

用来保存应用的一些常用配置，比如Activity状态，Activity暂停时，

将此activity的状态保存到SharedPereferences中；

当Activity重载，系统回调方法onSaveInstanceState时，再从SharedPreferences中将值取出。 

（参考网址：https://blog.csdn.net/MR_Condingson/article/details/58586419）

## 三.实验步骤
 
 1.首先构造出自己想要具体存储什么的蓝图并且显示出存储的内容
 
  这里我想出了建造类似评论区的存储显示区（一开始尝试的是搜索功能的实现 未果）
  
 2.开始上网搜寻资料，查询自己选题的SharedPreferences具体使用方法（如何用 上面给出网址里面有讲） 具体实现起来不难
 
 3.在自己MainActivitysoft1614080902139.java文件中编辑好代码 并且在自己的xml文件中添加两个监听按钮以及EaitText 布局弄好（截图在实验结果可看）
 
 4.检查无措后 进入虚拟机调试 
 
 5.成功实现后 将实验结果截图保存 以及相关文件打包利用git bash发送到git上来完成该门实验
 
 ## 四.实验结果
 
 在输入框输入留言
 
 点击发送 将文本存储起来 
 
 点击显示 即可显示留言
 ![在Android SDK Manager中选择6.0库](https://github.com/1614080902139/android-labs-2018/blob/master/Soft1614080902139/7.png)
 
 ![在Android SDK Manager中选择6.0库](https://github.com/1614080902139/android-labs-2018/blob/master/Soft1614080902139/8.png)
 
 ## 五.实验体会
   
   这次实验对于我来说 完成的可谓是转转折折，最后在舍友的帮助下才完成的。
   
