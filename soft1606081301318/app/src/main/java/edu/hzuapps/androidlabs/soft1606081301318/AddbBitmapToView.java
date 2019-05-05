package androidlabs.hzuapps.edu.soft1606081301318;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.widget.ImageView;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

public class AddbBitmapToView extends AsyncTask<String,Void,Bitmap> {

    private ImageView imageView;

    public AddbBitmapToView(ImageView  imageView){
        this.imageView=imageView;
    }
    @Override
    protected void onPostExecute(Bitmap bitmap) {
        super.onPostExecute(bitmap);
        if(bitmap!=null){
            imageView.setImageBitmap(bitmap);
        }
    }

    @Override
    protected Bitmap doInBackground(String... params) {
        Bitmap bitmap=getPicture(params[0]);

        return bitmap;
    }



    //网络地址获取图片
    private Bitmap getPicture(String path){
        Bitmap bm=null;
        InputStream is;
        try{
            URL url=new URL(path);
            URLConnection connection=url.openConnection();
            connection.connect();
            is=connection.getInputStream();
            BitmapFactory.Options options = new BitmapFactory.Options();
            options.inSampleSize = 2;
            bm= BitmapFactory.decodeStream(is,null,options);
            is.close();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return bm;
    }
}

