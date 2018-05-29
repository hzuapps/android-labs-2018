# 第五次实验报告

## 一.实验目的
### 掌握在Android App中存储数据

## 二.实验步骤
本实验做的是以文件存储到内部储存的方法，由于做的是短信管理器，存储的是短信的信息(amount.txt用于存放短信的数量，name.txt用于存放收件人信息，message.txt用于存放信息,search.txt用于存放搜索的关键词);
### 1.将EditText中的输入内容提取出来，代码如下：
~~~
     EditText t1;
     t1 = (EditText) findViewById(R.id.XXX);
~~~
### 2.写入文件功能如下：
~~~
     saveContent();
~~~
     函数代码：
~~~
     private void saveContent() {
        FileOutputStream fos = null;
        String content1 = t1.getText().toString();
        try {
            fos = this.openFileOutput("XXX.txt", MODE_PRIVATE);
            fos.write(content1.getBytes());
            fos.flush();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (fos != null) {
                try {
                    fos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
~~~
### 3.读取文件功能如下：
~~~
     String s=getContent();
~~~
    函数代码：
~~~
    private String getContent() {
        String s=null;
        FileInputStream fis = null;
        try {
            fis = this.openFileInput("XXX.txt");
            int len = 0;
            byte[] buf = new byte[1024];
            while ((len = fis.read(buf)) != -1) {
                s = new String(buf, 0, len, "UTF-8");
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (fis != null) {
                try {
                    fis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return s;
       }
    }
~~~
    提取的文件以字符串的形式输出，若要转化为整数，可用如下形式：
~~~
   int X=Integer.parseInt(String)
~~~
通过以上代码，实现短信管理其的新建信息的功能。
### 4.在Activity3的XML里用LinearLayout及Textview控件通过嵌套的方式实现搜索功能的输出，代码如下：
~~~
<LinearLayout xmlns:android="http://schemas.android.com/apk/res/android"
        android:id="@+id/linearLayout"
        android:layout_width="384dp"
        android:layout_height="511dp"
        android:orientation="horizontal">

        <LinearLayout
            android:layout_width="match_parent"
            android:layout_height="wrap_content"
            android:orientation="vertical">

            <TextView
                android:id="@+id/title"
                android:layout_width="match_parent"
                android:layout_height="wrap_content"
                android:textColor="#FF000000"
                android:textSize="22px" />

            <TextView
                android:id="@+id/info"
                android:layout_width="match_parent"
                android:layout_height="wrap_content"
                android:textColor="#FF000000"
                android:textSize="13px" />

        </LinearLayout>


    </LinearLayout>
~~~
### 5.在java文件中，定义一个Result类包含s，s1，s2三个关于String的属性；将从search.txt提出的数据存入到s中，name.txt提出的数据存入s1中，message.txt提出的数据存入s2中，通过比较一个字符串中是否包含另一个字符串的函数，确定与搜索关键词有关系的信息；代码如下：
~~~
    String1.indexOf(String2)
~~~
### 6.将搜索结果输出：
~~~
    SimpleAdapter adapter = new SimpleAdapter(this,getData(),R.layout.activity3_soft1614080902314,
                    new String[]{"title","info"},
                    new int[]{R.id.title,R.id.info});
            setListAdapter(adapter);
~~~
~~~
     private List<Map<String, Object>> getData() {
        List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
                Map<String, Object> map = new HashMap<String, Object>();
                map.put("title",String);
                map.put("info", String);
                list.add(map);
        return list;
    }
~~~
## 三.实验结果
### 存储
![在Android SDK Manager中选择6.0库](https://github.com/Zhengmianjie/android-labs-2018/blob/master/soft1614080902314/5.1%E8%BF%90%E8%A1%8C%E6%88%AA%E5%9B%BE.jpg?raw=true"配置教育网下载代理")
### 搜索

![在Android SDK Manager中选择6.0库](https://github.com/Zhengmianjie/android-labs-2018/blob/master/soft1614080902314/5.2%E8%BF%90%E8%A1%8C%E6%88%AA%E5%9B%BE.jpg?raw=true"配置教育网下载代理")

## 四.实验体会    
通过本次实验，了解到android文件的存储，同时也明白了java编程在android开发中的重要。
