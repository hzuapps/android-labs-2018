# ������ʵ��

## 1.ʵ��Ŀ��
������AndroidӦ����ʹ��ͼƬ����Դ�ķ�����

## 2.ʵ�鲽��

��1�����ѽ��õ���Ŀsoft1614080902233
��2�������ڶ���activity��secondActivity
��3���ڵ�һ��activity��xml�ļ����������
	<TextView  
    		android:id="@+id/textview_01"  
    		android:layout_width="wrap_content"  
    		android:layout_height="wrap_content"  
    		android:drawableTop="@drawable/maomao"  
    		android:text="hello_world" /> 
	activity��Ԥ��ͼ�оͳ���������Ҫ��ͼƬ��
��4���ڵ�һ��activity��java�ļ��м������������
	public class MainActivity extends Activity  implements OnClickListener {    
    	......    
    
    	@Override    
    	public void onClick(View v) {    
        	if(v.equals(startButton)) {    
         	   // ��һ��Activity���������� = edu.androidlabs.soft123456(����).Soft123456Activity(����)
         	   Intent intent = new Intent("��һ��Activity����������");    
         	   startActivity(intent);    
        		}    
   	 	}    
	}  
	�����Ϳ��Ե������һ���½���activity
��5���� git �ϴ�

## 3.ʵ����

![image](https://github.com/liaohuajjj/android-labs-2018/blob/master/soft1614080902233/tupian3.1.png)

![image](https://github.com/liaohuajjj/android-labs-2018/blob/master/soft1614080902233/tupian3.2.png)

## 4.ʵ�����
���ʵ�������˵�ǳ����ѣ���Ҫ����Ϊ������Java���﷨����Ҫ�ٶ�ѧϰ��
���ѳ���ת��Ϊapk�ļ����ֻ��ϰ�װ���У��о�ͦ�õġ�