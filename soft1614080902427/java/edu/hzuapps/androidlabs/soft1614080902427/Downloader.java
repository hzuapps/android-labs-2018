package edu.hzuapps.androidlabs.soft1614080902427;

import android.os.AsyncTask;
import android.util.Log;

import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.Reader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.charset.StandardCharsets;


public class Downloader {
    private final static String TAG = Downloader.class.getSimpleName();

    private final DownloaderListener listener;

    public Downloader(DownloaderListener listener) {
        this.listener = listener;
    }

    public void createTask(String url) {

        new AsyncTask<String, Integer, ByteArrayOutputStream>() {
            public String url;

            @Override
            protected ByteArrayOutputStream doInBackground(String[] params) {
                this.url = params[0];

                HttpURLConnection connection = null;
                InputStream is = null;
                ByteArrayOutputStream out = null;
                try {
                    connection = (HttpURLConnection) new URL(this.url).openConnection();
                    is = connection.getInputStream();
                    out = new ByteArrayOutputStream();
                    byte[] buffer = new byte[256];
                    int bytesRead;
                    while((bytesRead = is.read(buffer))!=-1){
                        out.write(buffer,0,bytesRead);
                    }
                } catch (Exception e) {
                    Log.e(TAG,"下载 " +url + "出现错误: "+e.toString());
                }
                return out;
            }

            @Override
            protected void onPreExecute() {
                super.onPreExecute();
            }

            @Override
            protected void onPostExecute(ByteArrayOutputStream stream) {
                super.onPostExecute(stream);
                Downloader.this.listener.onDone(this.url, stream);
            }

            @Override
            protected void onProgressUpdate(Integer... values) {
                super.onProgressUpdate(values);
            }

            @Override
            protected void onCancelled(ByteArrayOutputStream stream) {
                super.onCancelled(stream);
                listener.onError(this.url);
            }

        }.execute(url);
    }
}