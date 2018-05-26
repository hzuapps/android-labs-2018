package edu.hzuapps.androidlabs.com1614080901240;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Environment;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.TextView;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
public class Com1614080901240_Activity3 extends AppCompatActivity {
    EditText editText_url;
    ListView listView;  //heap堆，可以被整个对象所有方法访问
    TextView textView;
    ProgressBar progressBar;

    ArrayList<String> arrayList = new ArrayList<>();
    ArrayList<String> localImages = new ArrayList<>();
    ArrayAdapter<String> arrayAdapter;


    MyAsyncTask asyncTask;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_com1614080901240_3);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        editText_url = findViewById(R.id.editText_url);
        listView = findViewById(R.id.listView);
        arrayAdapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,arrayList);
        listView.setAdapter(arrayAdapter);

        textView = findViewById(R.id.textView);
        progressBar = findViewById(R.id.progressBar);

        asyncTask = new MyAsyncTask();

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();

            }
        });
    }

    public void add(View view){
        arrayList.add(editText_url.getText().toString());
        arrayAdapter.notifyDataSetChanged();
    }

    public void download(View view){

        switch (asyncTask.getStatus()){
            case PENDING:
                asyncTask.execute(0);
                break;
            case RUNNING:
                break;
            case FINISHED:
                asyncTask = new MyAsyncTask();
                asyncTask.execute(0);
                break;
        }

    }

    class MyAsyncTask extends AsyncTask<Integer,Integer,Integer>{

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            localImages.clear();
        }


        @Override
        protected Integer doInBackground(Integer... integers) {
            //在另外一个线程里面！！！
            for(int i=0;i<arrayList.size();i++){
                String s = arrayList.get(i);
                try {
                    URL url = new URL(s);
                    URLConnection connection = url.openConnection();
                    int size = connection.getContentLength();  //图片大小

                    publishProgress(0,i+1,size);



                    InputStream inputStream = connection.getInputStream();  //流
                    byte[] bytes = new byte[100];
                    int len = -1;

                    //准备好外部存储文件
                    File file = getExternalFilesDir(Environment.DIRECTORY_DOWNLOADS);
                    String filename = file.getAbsolutePath()+"/"+i+".jpg";
                    FileOutputStream fileOutputStream = new FileOutputStream(filename);

                    while ((len=inputStream.read(bytes))!=-1){
                        fileOutputStream.write(bytes,0,len);
//                        Thread.sleep(1);
                        publishProgress(1,len);
                    }

                    fileOutputStream.close();
                    inputStream.close();

                    localImages.add(filename);

                } catch (MalformedURLException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            return null;
        }

        @Override
        protected void onProgressUpdate(Integer... values) {
            super.onProgressUpdate(values);

            switch (values[0]){
                case 0:
                    textView.setText("正在下载第"+values[1]+"个文件！！！");
                    progressBar.setMax(values[2]);
                    progressBar.setProgress(0);
                    break;
                case 1:
                    progressBar.incrementProgressBy(values[1]);
                    break;
            }



        }

        @Override
        protected void onPostExecute(Integer integer) {
            super.onPostExecute(integer);
            textView.setText("下载完成！！！");
            progressBar.setProgress(0);
        }
    }

    public void showImages(View view){
        Intent intent = new Intent(this,Com1614080901240Activity4.class);
        intent.putExtra("images",localImages);
        startActivity(intent);
    }
}
