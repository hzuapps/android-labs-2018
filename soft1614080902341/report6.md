# ��6��ʵ��
  
## 1.ʵ��Ŀ��
* ����Android������ʷ�����
  
## 2.ʵ�鲽��
### 1.����Activity����һ���µİ�ť�����ڴ�����ͼƬ����Activity��ImageActivity��
<pre><code>img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent();
                intent.setClass(soft1614080902341MainActivity.this, ImageActivity.class); //������ת��Activity
                soft1614080902341MainActivity.this.startActivity(intent);
            }
        });
</code></pre>
### 2.��дImageActivity����д��Ӧ����ָ��url�������õ��ǰٶȵ�һ��ͼƬ�����ص�sd���������Ϊ����ѧԺ.jpg��
<pre><code>
public void onClick(View v) {
                Toast.makeText(ImageActivity.this,"ͼƬ��ʼ����",Toast.LENGTH_SHORT).show();
                new Thread() { //�������߳�ר��������������ֹ�����߳�һ������������������ʱ��ɵļ���״̬�������û�����
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
                            if (code == 200) {//�ж�״̬��
                                InputStream is = connection.getInputStream();
                                Bitmap btImage = BitmapFactory.decodeStream(is);
                                File file = new File(Environment.getExternalStorageDirectory(), "����ѧԺ.jpg");
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
                Toast.makeText(ImageActivity.this, "ͼƬ����ɹ�", Toast.LENGTH_SHORT).show();
            }
</code></pre>
### 3.�����ȡsd����Ȩ�޵Ĵ��롣
<pre><code>
    uses-permission android:name="android.permission.INTERNET" 
    uses-permission android:name="android.permission.MOUNT_UNMOUNT_FILESYSTEMS" 
    uses-permission android:name="android.permission.WRITE_EXTERNAL_STORAGE" 
</code></pre>
### 4.��git �ύ
### 5.��дʵ�鱨��
## 3.ʵ����
* ʵ���ͼ
![ʵ���ͼ](https://github.com/linliyuan/android-labs-2018/blob/master/soft1614080902341/exam6.1.jpg)
![ʵ���ͼ](https://github.com/linliyuan/android-labs-2018/blob/master/soft1614080902341/exam6.2.jpg)
![ʵ���ͼ](https://github.com/linliyuan/android-labs-2018/blob/master/soft1614080902341/exam6.3.jpg)
![ʵ���ͼ](https://github.com/linliyuan/android-labs-2018/blob/master/soft1614080902341/exam6.4.jpg)

## 4.ʵ����� 

* 1.ʵ��ֻҪ�õ���HttpURLConnection�Ļ����÷�����get��ʽ�������磬��ͨ��������Ӧsd���ļ����������ļ���
* 2.��ʼ���Ǽ���Ȩ�ޣ�Ȼ��������⣬��������ǱȽ��ϵİ汾��û����ʾ��һֱ�Ҳ��������������˵������Ȩ������adb�����ö�����Ҫ��
