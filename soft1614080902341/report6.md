# 第6次实验
  
## 1.实验目标
* 掌握Android网络访问方法；
  
## 2.实验步骤
### 1.在主Activity创建一个新的按钮，用于打开下载图片的新Activity既ImageActivity。
<pre><code>img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent();
                intent.setClass(soft1614080902341MainActivity.this, ImageActivity.class); //设置跳转的Activity
                soft1614080902341MainActivity.this.startActivity(intent);
            }
        });
</code></pre>
### 2.编写ImageActivity，编写响应，将指定url（这里用的是百度的一张图片）下载到sd卡里，并命名为惠州学院.jpg。
<pre><code>
public void onClick(View v) {
                Toast.makeText(ImageActivity.this,"图片开始下载",Toast.LENGTH_SHORT).show();
                new Thread() { //开启子线程专门用于联网，防止与主线程一起造成无网络或连接延时造成的假死状态，增加用户体验
                    @Override
                    public void run() {
                        String path = "https://gss2.bdstatic.com/-fo3dSag_xI4khGkpoWK1HF6hhy/baike/c0%3Dbaike92" +
                                "%2C5%2C5%2C92%2C30/sign=94e5e15713d5ad6ebef46cb8e0a252be/21a4462309f79052dedc9dad04f3d7ca7acbd566.jpg";
                        try {
                            URL url = new URL(path);
                            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
                            connection.setRequestMethod("GET");
                            connection.setConnectTimeout(10000);
                            int code = connection.getResponseCode();
                            if (code == 200) {//判断状态码
                                InputStream is = connection.getInputStream();
                                Bitmap btImage = BitmapFactory.decodeStream(is);
                                File file = new File(Environment.getExternalStorageDirectory(), "惠州学院.jpg");
                                FileOutputStream out;
                                try {
                                    out = new FileOutputStream(file);
                                    btImage.compress(Bitmap.CompressFormat.JPEG, 90, out);
                                    out.flush();
                                    out.close();
                                } catch (FileNotFoundException e) {
                                    e.printStackTrace();
                                }

                            }
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                }.start();
                Toast.makeText(ImageActivity.this, "图片保存成功", Toast.LENGTH_SHORT).show();
            }
</code></pre>
### 3.加入读取sd卡的权限的代码。
<pre><code>
    uses-permission android:name="android.permission.INTERNET" 
    uses-permission android:name="android.permission.MOUNT_UNMOUNT_FILESYSTEMS" 
    uses-permission android:name="android.permission.WRITE_EXTERNAL_STORAGE" 
</code></pre>
### 4.用git 提交
### 5.编写实验报告
## 3.实验结果
* 实验截图
![实验截图](https://github.com/linliyuan/android-labs-2018/blob/master/soft1614080902341/exam6.1.jpg)
![实验截图](https://github.com/linliyuan/android-labs-2018/blob/master/soft1614080902341/exam6.2.jpg)
![实验截图](https://github.com/linliyuan/android-labs-2018/blob/master/soft1614080902341/exam6.3.jpg)
![实验截图](https://github.com/linliyuan/android-labs-2018/blob/master/soft1614080902341/exam6.4.jpg)

## 4.实验体会 

* 1.实验只要用的是HttpURLConnection的基本用法，用get方式访问网络，并通过建立对应sd的文件夹来保存文件。
* 2.开始忘记加入权限，然后出现问题，虚拟机又是比较老的版本，没有提示，一直找不到代码错误，所以说引包，权限乃至adb的设置都很重要。
