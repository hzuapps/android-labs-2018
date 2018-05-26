# 第六次实验

## 一、实验目标

1.掌握Android网络访问方法

2.理解XML和JSON表示数据的方法、

## 二、实验内容

1.在个人目录中创建一个表示数据的XML或JSON文件

2.数据文件代码提交之后从GitHub获取文件URL

3.在应用中通过网络编程访问GitHub的数据文件

4.在应用中解析并显示文件所包含的数据

5.将应用运行结果截图

## 三、实验步骤

1.在GitHub上编辑JSON文件，获取此文件URLhttps://raw.githubusercontent.com/Qiujialin/android-labs-2018/master/soft1614080902407/get_data.json，打开Android Studio

2.编辑AndroidManifest.xml文件，添加网络访问权限语句：
<uses-permission android:name="android.permission.INTERNET"/>

3.编辑app/build.gradle，在dependencies闭包中添加依赖：
implementation 'com.squareup.okhttp3:okhttp:3.10.0'

4.编辑SecondActivity.java，创建一个OkHttpClient实例，创建一个Request对象并设置目标网络https://raw.githubusercontent.com/Qiujialin/android-labs-2018/master/soft1614080902407/get_data.json
调用OkHttpClient的newCall()方法创建一个Call对象，并调用execute方法发送请求并获取服务器返回的数据

5.调用parseJSONWithJSONObject()方法解析JSON数据，将服务器返回的数据传入JSONArray对象，遍历每一个JSONArray对象，用getString()方法取出数据，并将其显示到EditText中

6.修改原先Button的id为getJson，并修改点击事件为调用sendRequestWithOkHttp()进行读取并解析JSON文件，

## 四、实验代码与截图

1.SecondActivity.java(添加的代码)

    private void sendRequestWithOkHttp(){//访问服务器
        new Thread(new Runnable() {
            @Override
            public void run() {

                try {
                    OkHttpClient client = new OkHttpClient();
                    Request request = new Request.Builder().url("https://raw.githubusercontent.com/Qiujialin/android-labs-2018/master/soft1614080902407/get_data.json").build();
                    Response response = client.newCall(request).execute();
                    String responseData = response.body().string();
                    parseJSONWithJSONObject(responseData);
                } catch (IOException e) {
                    e.printStackTrace();
                }

            }
        }).start();
    }
    private void parseJSONWithJSONObject(String jsonData) {//解析JSON
        try {
            JSONArray jsonArray = new JSONArray(jsonData);
            for(int i=0;i<jsonArray.length();i++){
                JSONObject jsonObject = jsonArray.getJSONObject(i);
                String id = jsonObject.getString("id");
                String  name = jsonObject.getString("name");
                String  text = "id is "+id+"\r\n"+"name is "+name;
                showResponse(text);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }
    private void showResponse(final String response) {//显示出来
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                //editText.append(response);
                editText.setText(response);
            }
        });
    }

2.AndroidManifest.xml

<uses-permission android:name="android.permission.INTERNET"/>

3.app/build.gradle

implementation 'com.squareup.okhttp3:okhttp:3.10.0'

4.activity_second.xml

<?xml version="1.0" encoding="utf-8"?>
<LinearLayout xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:app="http://schemas.android.com/apk/res-auto"
    xmlns:tools="http://schemas.android.com/tools"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    android:orientation="vertical"
    tools:context=".SecondActivity">

    <LinearLayout
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:gravity="center">

        <TextView
            android:layout_width="wrap_content"
            android:layout_height="match_parent"
            android:layout_weight="1"
            android:gravity="center"
            android:text="内容"
            android:textSize="20dp"
            android:textStyle="bold" />

    </LinearLayout>

    <LinearLayout
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:gravity="start">

        <EditText
            android:id="@+id/edittext"
            android:layout_width="wrap_content"
            android:layout_height="wrap_content"
            android:ems="20"
            android:hint="@string/hint_content"
            android:inputType="textMultiLine"
            android:minLines="5"
            android:textAppearance="?android:attr/textAppearanceLargeInverse" />
    </LinearLayout>

    <LinearLayout
        android:layout_width="wrap_content"
        android:layout_height="wrap_content">

        <ImageView
            android:layout_width="match_parent"
            android:layout_height="wrap_content"
            android:background="@drawable/example" />
    </LinearLayout>

    <LinearLayout
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:gravity="center_horizontal">

        <Button
            android:layout_width="wrap_content"
            android:layout_height="wrap_content"
            android:layout_weight="1"
            android:text="定时提醒"
            android:textStyle="bold" />

        <Button
            android:layout_width="wrap_content"
            android:layout_height="wrap_content"
            android:layout_weight="1"
            android:text="添加图片"
            android:textStyle="bold" />
    </LinearLayout>

    <LinearLayout
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:gravity="center_vertical">

        <Button
            android:id="@+id/btnJoin"
            android:layout_width="wrap_content"
            android:layout_height="wrap_content"
            android:layout_weight="1"
            android:text="读取备忘录"
            android:textStyle="bold" />

        <Button
            android:id="@+id/getJson"
            android:layout_width="wrap_content"
            android:layout_height="wrap_content"
            android:layout_weight="1"
            android:text="读取并解析JSON"
            android:textStyle="bold"/>
    </LinearLayout>

</LinearLayout>

5.get_data.json

[{
	"id": "1614080902407",
	"name": "邱家霖"
}]

![image](https://github.com/Qiujialin/android-labs-2018/blob/master/soft1614080902407/%E5%AE%9E%E9%AA%8C%E6%88%AA%E5%9B%BE6-1.jpg?raw=true)

![image](https://github.com/Qiujialin/android-labs-2018/blob/master/soft1614080902407/%E5%AE%9E%E9%AA%8C%E6%88%AA%E5%9B%BE6-2.jpg?raw=true)

## 五、实验体会

通过此次实验，了解了如何访问网络，如何用JSONObject解析JSON的代码，此次实验用OkHttp替代原生的HttpURLConnection，比原来的HttpURLConnection发送HTTP请求会简单，了解了JSON文件的格式以及如何写，在安卓中开启权限需要在AndroidManifest.xml添加相关权限的语句，在一开始由于没有加入网络访问权限语句导致实验不成功，后面找出错误并改正。

