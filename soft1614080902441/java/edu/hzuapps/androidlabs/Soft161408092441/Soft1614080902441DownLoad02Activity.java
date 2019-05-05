package edu.hzuapps.androidlabs.Soft161408092441;

        import android.os.Bundle;
        import android.support.v7.app.AppCompatActivity;
        import android.content.Context;
        import android.content.SharedPreferences;
        import android.graphics.Bitmap;
        import android.graphics.BitmapFactory;
        import android.widget.ImageView;
        import android.widget.TextView;
        import java.io.IOException;
        import java.io.InputStream;
        import java.net.URL;
        import java.net.URLConnection;

public class Soft1614080902441DownLoad02Activity extends AppCompatActivity {

    private ImageView imageView;
    public Bitmap getPicture(String wu){
        Bitmap yu=null;
        try{
            URL url=new URL(wu);
            URLConnection connection=url.openConnection();
            connection.connect();
            InputStream inputStream=connection.getInputStream();
            yu= BitmapFactory.decodeStream(inputStream);
        } catch (java.net.MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return  yu;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_soft1614080902441_download_success);
        imageView = (ImageView) findViewById(R.id.image);
        TextView txtUserName=(TextView) findViewById(R.id.textView3);
        SharedPreferences sharedPreferences = getSharedPreferences("jnc", Context.MODE_PRIVATE);
        final String userName=sharedPreferences.getString("username","");
        txtUserName.setText(userName);
        new Thread(new Runnable() {
            @Override
            public void run() {
                final Bitmap bitmap=getPicture(userName);
                //final Bitmap bitmap=getPicture("https://upload.chebaba.com/cms/article/05338129504020508.jpg");
                try {
                    Thread.sleep(1997);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                imageView.post(new Runnable() {
                    @Override
                    public void run() {
                        imageView.setImageBitmap(bitmap);
                    }
                });
            }
        }).start();
    }
}