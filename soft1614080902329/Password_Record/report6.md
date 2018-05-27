# 第6次实验
 
## 1.实验目标
* 新增soft1614080902329NetWorkActivity用于联网显示作者信息
 
## 2.实验步骤
### 1. 新增soft1614080902329NetWorkActivity用于联网显示作者信息

* 布局
``` xml
<LinearLayout
        android:layout_width="match_parent"
        android:layout_height="match_parent"
        android:orientation="vertical">
        <Button
            android:id="@+id/see"
            android:layout_width="170sp"
            android:layout_height="wrap_content"
            android:text="联网查看"
            android:textSize="20dp"
            android:layout_gravity="center_horizontal"
            android:layout_marginTop="120px"
            />

        <ImageView
            android:id="@+id/pic"
            android:layout_width="match_parent"
            android:layout_height="match_parent"
            android:layout_gravity="center_horizontal"
            android:layout_marginTop="50px"/>
    </LinearLayout>
```

* 获取相关控件,并设置监听
``` java
        authorSeeButtom = findViewById(R.id.see);
        authorImageView = findViewById(R.id.pic);
        authorSeeButtom.setOnClickListener(new authorSeeButtomListerner());
```

* 监听类
``` java
    private class authorSeeButtomListerner implements View.OnClickListener{

        @Override
        public void onClick(View v) {
            new Thread(){ //开启子线程专门用于联网，防止与主线程一起造成无网络或连接延时造成的假死状态，增加用户体验
                @Override
                public void run() {
                    String path = "https://raw.githubusercontent.com/OrangeHap/android-labs-2018/master/soft1614080902329/lab6_author.png";
                    try{
                        URL url = new URL(path);
                        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
                        connection.setRequestMethod("GET");
                        connection.setConnectTimeout(10000);
                        int code = connection.getResponseCode();
                        if(code == 200){//判断状态码
                            InputStream inputStream = connection.getInputStream();
                            Bitmap bitmap = BitmapFactory.decodeStream(inputStream);
                            Message msg = Message.obtain();
                            msg.obj = bitmap;
                            handler.sendMessage(msg); 3
                            Log.v("code","ok");
                        }
                        Log.v("code","pass");
                    }catch (Exception e){
                        e.printStackTrace();
                    }
                }
            }.start();
        }
    }
```

* 在主线程设置handler
``` java
private Handler handler = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            Bitmap bm = (Bitmap) msg.obj;
            authorImageView.setImageBitmap(bm);
        }
    };
```

* 设置权限
``` xml
  <uses-permission android:name="android.permission.INTERNET"/>
```

## 3.实验结果
* 实验截图
![实验截图](https://github.com/OrangeHap/android-labs-2018/blob/master/soft1614080902329/lab6.png)

## 4.实验体会 

* 1.联网必须开启子线程专门用于联网，防止与主线程一起造成无网络或连接延时造成的假死状态，增加用户体验
* 2.解决线程间通信可用handler来进行
