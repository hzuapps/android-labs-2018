# 第五次实验

## 1.实验目标

1. 选择一种Android App的存储方式
2. 以这种存储方式实现一个功能

## 2.实验步骤

1. 我存储的东西类似于便签，所以先新建一个Activity
2. 在这个界面上添加两个控件Button、Edittext
3. 用java代码对这两个控件进行监听
4. Edittext上实现新建一个存储的文件
5. 把Edittext上的文字信息输入到文件中去
6. 重新打开时，把文件的信息重新输入到Edittext中
7. 调整其他界面的跳转
8. 在git上面提交作业

## 3.实验结果

### (1)保存信息的界面

![在Android SDK Manager中选择6.0库](https://github.com/Ghlyh/android-labs-2018/blob/master/soft1614080902402/7.png "配置教育网下载代理")



### （2）保存时所读取的内容

![在Android SDK Manager中选择6.0库](https://github.com/Ghlyh/android-labs-2018/blob/master/soft1614080902402/8.png "配置教育网下载代理")



### （3）重新打开这个保存界面时，所读取文件字符串的信息

![在Android SDK Manager中选择6.0库](https://github.com/Ghlyh/android-labs-2018/blob/master/soft1614080902402/9.png "配置教育网下载代理")

## 4.实验体会

​	这个实验我走了很多的弯路，真的太久没打Java了，要翻翻书才知道错在哪里，同时也犯了些低级错误，例如在存储文件前，首先要判断是否有这个文件，有这个文件才把信息输出，没有则要新建一个文件，我做好的时候没有注意到这一点，所以从第二个页面到第三个页面的时候出现错误，一直打不开第三个界面，仔细看了看报错的信息，过了好久才反应过来。

​	通过这次实验，对java的输入输出流复习了很多，一开始没看懂老师给的代码，拼命地上网查才渐渐地清楚，一条一条语句来查，查到最后把全部代码都明白了。我这人本来就没什么耐心，才早上11点多做到下午3点多，真的是够煎熬。

## 5.实验相关代码注释

~~~ java
public static final String TAG = Third_Activity.class.getSimpleName();
	//Third_Activity类名的简称 TAG
File dir = this.getFilesDir()
    //获取存储目录的绝对路径，以字符串的形式返回数值
if (!file.exists()){ //判断文件是否存在
	try {
		file= File.createTempFile(FILENAME, null, dir);
         //在dir的存储目录下，创建一个以FILENAME名称的文件
		} catch (IOException e) {
		e.printStackTrace();
	}
    Log.i(TAG, file.getAbsolutePath());
    //log.i控制台输出file文件绝对路径的字符串
    Log.i(TAG, file.length() + ""); // bytes*1024=kb *1024 MB
    //file文件的大小
    Log.i(TAG, file.isFile() + "");
    //判断file是否为文件
    file.canRead(); 		//能不能读取，权限
   	file.canWrite();		//能不能写入，权限
    file.canExecute();		//能不能执行，权限
}
FileOutputStream fos = null //字节流
		try { // 使用API打开输出流
            fos = openFileOutput(FILENAME, MODE_PRIVATE);
            //FileOutputStream fos = new FileOutputStream(file);
            fos.write(text.getBytes()); // 写入内容
            fos.close(); // 关闭流
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                fos.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }


FileReader reader = null; // 字符char输出流
        try {
            reader = new FileReader(file.getAbsoluteFile());
            BufferedReader bReader = new BufferedReader(reader);
            // 缓冲输出流
            String line = bReader.readLine();
            showResult(line);   // 显示结果
            Log.i(TAG, "从文件读取的内容: " + line);
            bReader.close();
            reader.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
private void showResult(String result) {
        ((TextView) findViewById(R.id.text)).setText(result.toCharArray(), 0, result.length());
    }
~~~

