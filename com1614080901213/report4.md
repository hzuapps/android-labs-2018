# ���Ĵ�ʵ��

## 1.ʵ��Ŀ��
 ����ѡ��Ҫ����ƽ��沼�ּ��ؼ�ʹ�ã�
 ����xml��������Ʋ��������ύ����ͼ��
 ��Ӧ�����н����ͼ������Ҫ����¼ע�ᣡ��
## 2.ʵ�鲽��
 (1)��ʵ����Ļ����ϱ�д�ʹ����µ��ļ���������drawable��������ͼƬ���ֱַ�Ϊbeimian.png  fangkuai.png
 ��activity_second.xml���в��֣���������
     <LinearLayout
        android:layout_width="match_parent"
        android:layout_height="match_parent"
        android:orientation="vertical">

        <TextView
            android:id="@+id/mText"
            android:layout_width="750px"
            android:layout_height="300px"
            android:layout_x="20px"
            android:layout_y="32px"
            android:text="�����һ���Ƿ���A"
            android:textSize="18sp">
        </TextView>

        <LinearLayout
            android:layout_width="match_parent"
            android:layout_height="200dp">

            <ImageButton
                android:id="@+id/mImage01"
                android:layout_width="127dp"
                android:layout_height="200dp"
                android:background="@drawable/beimian" />

            <ImageButton
                android:id="@+id/mImage02"
                android:layout_width="125dp"
                android:layout_height="200dp"
                android:background="@drawable/beimian" />

            <ImageButton
                android:id="@+id/mImage03"
                android:layout_width="125dp"
                android:layout_height="200dp"
                android:background="@drawable/beimian" />

        </LinearLayout>

    </LinearLayout>
������design�������ֽ��

��Second.java ��д���������¼���������
private ImageButton pai1, pai2, pai3;
    private Button mImage01;
    private Button mImage02;
    private Button mImage03;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        pai1 = (ImageButton) findViewById(R.id.mImage01);
        pai2 = (ImageButton) findViewById(R.id.mImage02);
        pai3 = (ImageButton) findViewById(R.id.mImage03);
        pai1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SecondActivity.this, ThreeActivity.class);

                startActivity(intent);
            }
        });

        pai2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SecondActivity.this, FourActivity.class);

                startActivity(intent);
            }
        });

        pai3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SecondActivity.this, FourActivity.class);

                startActivity(intent);
            }
        });

    }
���������µ�Activity���ֱַ�ΪThreeActivity  FourActivity.

��activity_three.xml��д��Ϸ��ת��������������
    <LinearLayout
        android:layout_width="match_parent"
        android:layout_height="match_parent"
        android:orientation="vertical">
        <TextView
            android:layout_width="750px"
            android:layout_height="100px"
            android:layout_x="20px"
            android:layout_y="32px"
            android:text="��ϲ��¶���"
            android:textSize="18sp">
        </TextView>

        <TextView
            android:id="@+id/text2"
            android:layout_width="380sp"
            android:layout_height="500sp"
            android:background="@drawable/fangkuai"/>

    </LinearLayout>

�� activity_four.xml��д��һ����Ϸ�������������
  <LinearLayout
        android:layout_width="match_parent"
        android:layout_height="match_parent"
        android:orientation="vertical">
        <TextView
            android:id="@+id/mText"
            android:layout_width="750px"
            android:layout_height="100px"
            android:layout_x="20px"
            android:layout_y="32px"
            android:text="���ź��´���"
            android:textSize="18sp">
        </TextView>

    </LinearLayout>
(2)
ʹ��Git�������ύ���Լ��Ŀ��У�https://github.com/YOUR_NAME/android-labs-2018 

$ git pull 

$ git add ѧ��Ŀ¼/* 

$ git commit "#3 #1453���Ĵ�ʵ��+����" 

$ git push 

���Լ���GitHub���ϴ����ͷ���Pull Request��ע��鿴Changed files�� 

// �Ƿ�ֻ�޸����Լ����ļ��� 

��GitHub��ʹ��Markdown�ļ���дʵ�鱨�棨report4.md�� 

// �������Լ����ļ����� 
## 3.ʵ����
![image](https://github.com/huangdewei/android-labs-2018/blob/master/com1614080901213/5.png)

![image](https://github.com/huangdewei/android-labs-2018/blob/master/com1614080901213/6.png)
## 5.ʵ�����

ͨ�����ʵ��Խ��沼�ִ�İ������һ�����˽⣬����ôȥ��д���������˽��¼�����ô������