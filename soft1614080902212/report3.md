# ������ʵ��

## 1.ʵ��Ŀ��

������AndroidӦ����ʹ��ͼƬ����Դ�ķ�����

## 2.ʵ�鲽��

��1�����ѽ��õ���Ŀsoft1614080902212

��2��������2��activity��SecondActivity

��3���ڵ�һ��activity��xml�ļ�������Լ���Ҫ��ͼƬ

��4���ڵ�һ��activity��Java�ļ��м���������Ĵ��룺Button=(Button)findViewById(R.id.button1);

        Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(Soft1614080902212MainActivity.this,SecondActivity.class);
                startActivity(intent);
            }
        });

��5����git�ϴ�

## 3.ʵ����

![](https://github.com/hzulinzr/android-labs-2018/blob/master/soft1614080902212/png3.1.png)

![](https://github.com/hzulinzr/android-labs-2018/blob/master/soft1614080902212/png3.2.png)

## 4.ʵ�����

���ʵ�������˵ͦ���ѵģ���ͬѧ�İ����£�������������ʵ�顣�˽������֮ǰ������֪ʶ��