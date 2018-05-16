## 实验目标
* 掌握在Android App中存储数据
## 实验内容一（选做1个）
* 根据选题要求使用文件存储

1. 将应用产生的数据保存到文件存储中；
2. 说明使用的文件存储方式：内部 or 外部；
3. 将运行结果截图。

## 实验内容二（选做1个）
* 应用数据存储可采用数据库存储。

1. 将应用产生的数据存储到数据库中；
2. 使用UML类图描述表结构；
3. 将应用运行结果截图。

## 实验步骤

1. 因为歌单所包含的数据比较少，没有并发量需求，所以采用“文件存储”的方式存储。考虑到“内部”存储空间较小，可以把歌单存放在“外部”存储中。

我用一个 Setting类 存放歌单数据，未来扩展的时候还可以添加其他需要保存的数据

经过网上搜索和比较，我准备用 Gson 库 序列化Setting，让它转换 成一个JSON字符串，然后写入到外部存储的data.json文件中。

添加Gson库的方法如下：

* 打开你项目下的build.gradle
* 在dependencies里的最后一行添加 `implementation 'com.google.code.gson:gson:2.8.4'`
* 同步gradle
* 导入具体的包 `import com.google.gson.Gson;`

Gson的具体使用方法教程网上都有

2. 我在动作栏里添加了一个菜单选项，分别是“扫描”,“设置”,“返回”；这些选项都没有实际功能，只是为了方便实验

3. 在执行“扫描”功能的时候，随机产生5首歌曲的信息，然后返回这些歌曲数据。然后listview的adapter根据数据刷新视图，接着保存设置并写入外部存储中

## 实验结果
APP刚安装的时候，没有数据
![](https://github.com/harytfw/android-labs-2018/blob/master/soft1614080902427/Screenshot_1526454044.png)
菜单选项
![](https://github.com/harytfw/android-labs-2018/blob/master/soft1614080902427/Screenshot_1526454716.png)
“扫描”完成后，listview被刷新，保存设置
![](https://github.com/harytfw/android-labs-2018/blob/master/soft1614080902427/Screenshot_1526454721.png)

## 实验心得
把数据保存成文件的方式有很多，如object序列化，手动选择数据并写入，等等。在这次实验里我选择了用Gson 库序列化对象到JSON的方法。
安卓在存储方面的操作不像电脑那么直接，需要先判断存储路径是否可读可写，然后才可以进行下一步的读写操作，幸好安卓的读写与普通JAVA的读写并无太大差别，大部分代码是通用的



