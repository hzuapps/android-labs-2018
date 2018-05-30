# 第五次实验
## 1.实验目的
&emsp;1. 掌握在Android App中存储数据。 

## 2.实验要求
&emsp;1. 应用数据存储可采用数据库存储。

&emsp;2. 将应用产生的数据存储到数据库中；

&emsp;3. 将应用运行结果截图。  

## 3.实验步骤

- 在电脑上`Android Studio`编写代码  
>打开 `build.gradle` 并引入第三方库 `litepal` & `recyclerview`   
>在 `main` 目录下新建文件夹 `assets`   
>在 `assets` 文件下新建xml文件 `litepal`   
>在 `litepal` 文件下定义所需数据库名称   
>在 `java` 目录下新建 `.java` 文件并加入对数据库进行定义   
>在 `java` 目录下新建 `.java` 文件并加入 `RecyclerView` 适配器代码   
>在 `java` 目录下新建用于 `RecyclerView` 显示的 `Activity` ，并添加初始化函数，以及对数据库中数据的获取与显示   
>在 `layout` 目录下对其所对应的 `xml` 文件添加所需的控件以及 `RecyclerView`   
>在 `layout` 目录下新建 `xml` 文件用于对 `RecyclerView` 单独的内容显示进行配置，并在适配器中进行调用   
>修改 `撰写页面` 的 `xml` 文件，将原先的 `TextView` 换为 `EditText` 
>在原先的撰写页面中，对按钮点击事件进行设置，使其获取文本输入框中的内容并存入数据库   
>将实验结果进行截图

- 使用 `Git` 将代码提交到自己的库中：https://github.com/Strakly/android-labs-2018
  
>$ git add soft1614080902339/*  
>$ git commit -m "#5 #971 Notepad App code update from Strakly"  
>$ git push  

- 使用 `markdown` 软件编写实验报告，将实验截图地址加入实验报告中

- 再一次使用 `Git` 将代码提交到自己的库中

- 在自己的 `GitHub` 库中创建和发送`Pull Request`

## 4.实验截图
&emsp;   
![](https://raw.githubusercontent.com/Strakly/android-labs-2018/master/soft1614080902339/AndroidScreenshot_4.png "Edit Page")
&emsp;   
&emsp;   
![](https://raw.githubusercontent.com/Strakly/android-labs-2018/master/soft1614080902339/AndroidScreenshot_5.png "Show Content Page")
&emsp;   
&emsp;   
![](https://raw.githubusercontent.com/Strakly/android-labs-2018/master/soft1614080902339/AndroidScreenshot_6.png "Read Page")   
## 5.实验体会
&emsp;&emsp;本次实验对总的App设计较大，首先改写了撰写页面，抛弃原先只用于显示效果、无法编辑的TextView控件改为可编辑的EditView文件。   
&emsp;&emsp;并由于存储多条内容后显示对应内容的需要，添加了控件RecyclerView，使得在有限的窗口展示大量的数据。   
&emsp;&emsp;而本次实验重点的内容在于数据库的建立以及存储和读取。其中，数据库的建立以及存储是简单的，但在对数据库中的内容进行读取时，存在一定的难度。需要对整个内容进行遍历并且提取所需要的内容，但由于程序并不需要这样子的要求。因而只需要获取整个数据控中的内容，并用RecyclerView进行显示，在点击某个Item时，反馈对应的数据的标号，并将标号传递至内容显示页面，便可以使得内容显示页面显示对应的文字。   