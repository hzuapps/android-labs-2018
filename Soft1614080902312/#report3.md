#������ʵ��
## 1.ʵ��Ŀ��

	������AndroidӦ����ʹ��ͼƬ����Դ�ķ�����

## 2.ʵ��Ҫ��

��1���ڽ�������ʾ����һ��ͼƬ��
��2���ύres/drawable��ͼƬʹ�õĴ��룻
��3���ύres/values, res/layout���������룻
��4����Ӧ�����н����ͼ���ŵ�ʵ�鱨���У�
��5�����ͼƬ����ť��ʱ������һ��Activity��

## 3.ʵ�鲽��

��1����Ҫʹ�õ�ͼƬ������res/drawable�У�
��2������saolei.java
��3����Soft1614080902312Activity��Ӵ��룬ʹ����Դ�saolei��
��4���޸�activity_soft1614080902312.xml�еĴ��룬���ͼƬ����Ӧ���ı��Լ�����һ����ť��

	<TextView
        	android:id="@+id/textview_01"
        	android:layout_width="wrap_content"
        	android:layout_height="wrap_content"
        	android:drawableTop="@drawable/sl"
        	android:paddingLeft="100dp"
        	android:paddingRight="100dp"
        	android:paddingTop="100dp" />

��5���޸�saolei.xml�еĴ��룬��ƴ򿪵ĳ���Ľ��棻
��6���޸�AndroidManifest.xml�еĴ��룬������´���
<activity
                 android:name=".saolei"
                    android:label="saolei"
                    android:theme="@style/AppTheme" />

## 4.ʵ����

�򿪳���
![](https://raw.githubusercontent.com/KaiMin8X8/android-labs-2018/master/Soft1614080902312/1.png)

���start game��ť��
![](https://raw.githubusercontent.com/KaiMin8X8/android-labs-2018/master/Soft1614080902312/2.png)

## 5.ʵ�����

	ѧ�����ڽ��������ͼƬ����Ӱ�ť�Լ�������ƣ���ʹ��ť�ĵ���¼�Ϊ��ת��������棻
	��ʵ����������������������ӻ�����ԭ������ʹ���˳�ʱ��ȥ̽�����ʵ�顣