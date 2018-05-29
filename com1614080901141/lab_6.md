# 第六次实验

 ## 一、实验目的
 掌握Android网络访问方法
 
 ## 二、实验内容
1.从网络下载一个文件（图片、MP3、MP4）；  
2.保存到手机，在应用中使用文件；  
3.将应用运行结果截图。  
 
 ## 三、实验步骤
1、首先用git工具将代码仓库复制到本地后进行修改。  

2、	1）为ThirdActivity中添加一个按钮，并为其添加一个事件，使其跳转到FifthActivity。  
	2）创建一个新的Activity文件————FifthActivity.java,在该Acvitity中编写图片下载功能，进行体育赛事图片下载，并将所下载的图片保存到手机中。  
	  其核心代码如下：   
	Button content;  
    ImageView image;  
    Bitmap bitmap;  
    protected void onCreate(Bundle savedInstanceState) {  
        super.onCreate(savedInstanceState);  
        setContentView(R.layout.activity_fifth);  
        content=(Button)findViewById(R.id.content);  
        image=(ImageView)findViewById(R.id.image);  

        content.setOnClickListener(this);;  
        image.setOnClickListener(this);;  
    }  

    public Bitmap GetImageInputStream(String imageurl){ 
        URL url;  
        HttpURLConnection connection=null;  
        Bitmap bitmap=null;  
        try {  
            url = new URL(imageurl);  
            connection=(HttpURLConnection)url.openConnection();  
            connection.setConnectTimeout(6000);  
            connection.setDoInput(true);  
            connection.setUseCaches(false);  
            InputStream inputStream=connection.getInputStream();  
            bitmap=BitmapFactory.decodeStream(inputStream);  
            inputStream.close();  
        } catch (Exception e) {  
            e.printStackTrace();  
        }  
        return bitmap;  
    }

    public void onClick(View v) {  
        switch (v.getId()) {  
            case R.id.content:  

                new Task().execute("http://s9.sinaimg.cn/mw690/001vZELGzy7gt7rdCiYd8&690"); 
                break;  
 
            case R.id.image:  

                SavaImage(bitmap, Environment.getExternalStorageDirectory().getPath()+"/Test");  
                Toast.makeText(getBaseContext(), "图片保存", Toast.LENGTH_SHORT).show();  
                break;  

            default: 
                break;  
        }  
    } 

    Handler handler=new Handler(){  
        public void handleMessage(android.os.Message msg) {  
            if(msg.what==0x123){  
                image.setImageBitmap(bitmap);  
            }  
        };  
    };  


    class Task extends AsyncTask<String, Integer, Void>{  

        protected Void doInBackground(String... params) {  
            bitmap=GetImageInputStream((String)params[0]);  
            return null;  
        }  

        protected void onPostExecute(Void result) {  
            super.onPostExecute(result);  
            Message message=new Message();  
            message.what=0x123;  
            handler.sendMessage(message);  
        }  

    }

    public void SavaImage(Bitmap bitmap, String path){  
        File file=new File(path);  
        FileOutputStream fileOutputStream=null;  
        if(!file.exists()){  
            file.mkdir();  
        }  
        try {  
            fileOutputStream=new FileOutputStream(path+"/"+System.currentTimeMillis()+".png");  
            bitmap.compress(Bitmap.CompressFormat.JPEG, 100,fileOutputStream);  
            fileOutputStream.close();  
        } catch (Exception e) {  
            e.printStackTrace();  
        }  
    }  

3.实验运行成功后将文件git push 上传到本地仓库

 
 ## 四、实验截图
 *未下载图片时的界面<br>
 ![image](https://github.com/LiuYB135/android-labs-2018/blob/master/com1614080901141/6_1.png)<br>
 *点击按钮，下载图片后的界面<br>
 ![image](https://github.com/LiuYB135/android-labs-2018/blob/master/com1614080901141/6_2.png)<br>
 
 
 ## 五、实验体会
       这次实验，将文件的下载与网络方面相关联起来。以前的各科实验中，大多都是与自己本地电脑相关联，很少跟实际网络联系上的。所以
	   这次实验对我来说是一个挑战，一开始很懵，不过慢慢的参考别的同学的实验后，思路也就渐渐清晰起来，明白了其操作的方法及原理。  
	   这次实验是最后一次实验，也是挺有难度的，虽然一开始总是测验失败，不过最后还是完成了实验，实现了图片下载！
	   