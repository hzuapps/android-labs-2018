-ʵ����
-=
-һ.ʵ��Ŀ��
--
-����Android������ʷ�����
-  
-��.ʵ������
--
-�ڸ���Ŀ¼�д���һ����ʾ���ݵ�XML��JSON�ļ���<br>
-����һ��sevlet��������ͨ��json�����ݴ��͸�android����<br>
-��Ӧ���н���json�����������ݣ�<br>
-��Ӧ�����н����ͼ��<br>
-����ʵ�鲽��
--
-1������һ��������
-2������OkHttpClient client = new OkHttpClient();��ȡOkHttpClient����
-3��OkHttp�Ѿ��������������װ��
-4�� Gson gson = new Gson();
     User user = gson.fromJson(response.body().charStream(), User.class);��δ��뽫���ȡ�������ϴ�����
��josn���󲢽�json����ֵ��JAVABEAN��
-5���������߳�ȥ����UI����runOnUiThread�������
-�ġ�ʵ�����
![image](https://github.com/unihaoke/android-labs-2018/blob/master/soft1609081602618/889509428610662967.jpg)
--
-��ε�ʵ����Ҫʹ����������ܣ�OkHttp��Gson����ļ������ǵĴ��룬���������ǿ��ٿ���app��
ʹ��Glidֱ�ӻ�ȡ�����ϵ�ͼƬ
