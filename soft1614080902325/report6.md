# ������ʵ�� 

## 1.ʵ��Ŀ��
����Android������ʷ�����  
���XML��JSON��ʾ���ݵķ�����

###ʵ������
������ʵ��������ʼ���ͼƬ�ķ���������AndroidͼƬ����ͼGlide��ʵ�ַ�������ͼƬ�ģ�û�а�����ʦ˵��ʵ������������������������������
## 2. ʵ�鲽��
1����GitHub��������Glide����������ϸ˵���÷���  
����Android studio��gradle�Ĺ��ܰ����Ǽ��ؿ⣬�����ǣ�  
��bulid.gradle����������´��룺  

    repositories {  
        mavenCentral()  
        google()  
    }  

    implementation 'com.github.bumptech.glide:glide:4.7.1'
    annotationProcessor 'com.github.bumptech.glide:compiler:4.7.1'
���֮�������Ͻǵ�sync now���¡�  
2����ʱ����֮ǰactivity_personal_information.xmlд��һ��ImageView

    <ImageView
        android:id="@+id/tv_11"
        android:layout_width="match_parent"
        android:layout_height="250dp"
        />
��personalInformationActivity.java��������ImageView tv_11��Ȼ����Glideʵ�ַ��������ϵĻ���ѧԺͼ�ꡣ

    private ImageView tv_11;
    
        tv_11=findViewById(R.id.tv_11);
        Glide.with(this).load("http://p8.qhmsg.com/dr/217_214_/t01fe2c1732a6a9a83d.jpg").into((ImageView) tv_11);
3���������Ҫ����Ҫ�õ�������Ȩ��  
��AndroidManifest.xml�ϼ�����룺

    <uses-permission android:name="android.permission.INTERNET"/>
## 3. ʵ����

![��Android SDK](https://github.com/li763407418/android-labs-2018/blob/master/soft1614080902325/%236.png)


## 4. ʵ�����
������������Imageview��ʵ�ַ��������ϵ�ͼƬ������ʦ��Ҫ���е㲻̫һ������ʦҪ�������ر��浽����Ȼ��ͼƬ��ʾ��Ӧ���ϣ����ҵ��ǲ�����ֱ����ʾ��

**�Ӵ�**����