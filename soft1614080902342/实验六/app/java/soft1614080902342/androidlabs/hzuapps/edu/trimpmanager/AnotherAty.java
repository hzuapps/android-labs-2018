package soft1614080902342.androidlabs.hzuapps.edu.tripmanager;

import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

public class AnotherAty extends AppCompatActivity {
    private TextView show=findViewById(R.id.textView);
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_another_aty);

        new AsyncTask<String,Void,Void>(){

            @Override
            protected  Void doInBackground(String... params){
                try {
                    URL url = new URL(params[0]);
                    URLConnection connection = url.openConnection();
                    InputStream is = connection.getInputStream();
                    InputStreamReader isr = new InputStreamReader(is,"utf-8");
                    BufferedReader br = new BufferedReader(isr);
                    String line;
                    while((line = br.readLine())!=null){
                        show.setText(line);

                    }
                    br.close();
                    isr.close();
                    is.close();

                } catch (MalformedURLException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }

                return null;
            }
        }.execute("https://github.com/XuJiaHongHong/android-labs-2018/blob/master/soft1614080902342/%E5%AE%9E%E9%AA%8C%E5%85%AD/app/test.json");


    }
}
