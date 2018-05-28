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
 
 3.在自己MainActivitysoft1614080902404.java文件中编辑好代码 并且在自己的xml文件中添加两个监听按钮以及EaitText 布局弄好（截图在实验结果可看）
 
 4.检查无措后 进入虚拟机调试 
 
 5.成功实现后 将实验结果截图保存 以及相关文件打包利用git bash发送到git上来完成该门实验
 
 ## 四.实验结果
 
 在输入框输入留言
 
 点击发送 将文本存储起来 
 
 点击显示 即可显示留言
 ![在Android SDK Manager中选择6.0库](https://github.com/Beinglzb/android-labs-2018/blob/master/soft1614080902404/main/%E5%AE%9E%E9%AA%8C%E4%BA%941.png)
 
 ![在Android SDK Manager中选择6.0库](https://github.com/Beinglzb/android-labs-2018/blob/master/soft1614080902404/main/%E5%AE%9E%E9%AA%8C%E4%BA%943.png)
 
 ## 五.实验体会
   
   这次实验对于我来说 完成的可谓是转转折折 一开始选取的是文件存储 
   
   在查询很多资料后并且上机调试 未果失败（运行各种错误 上网搜索错误原因还是解决不了只能放弃）
   
   第二次尝试数据库存储 也是未果失败（同样都是运行出错 解决不了）
   
   最后只能在宿友的帮助下 选取了SharedPreferences轻量级的存储类 这个相对来说 借助网上的资源来实现起来挺容易的 
   
   总之 在完成实验的时候 一定一定要提前做好功课 否则做下去 出错了 碰了一鼻子灰 是一件很浪费精力以及时间的
