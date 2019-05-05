package edu.hzuapps.androidlabs.com1614080901230;

public class com1614080901230Activity2 {
    import android.content.Intent;
 import android.graphics.Bitmap;
 import android.graphics.Canvas;
 import android.graphics.Color;
 import android.graphics.Matrix;
 import android.graphics.Paint;
 import android.net.Uri;
 import android.os.Environment;
 import android.support.v7.app.AppCompatActivity;
 import android.os.Bundle;
 import android.view.MotionEvent;
 import android.view.View;
 import android.widget.Button;
 import android.widget.ImageView;
 import android.widget.Toast;
 import com.example.wjk.edu.hzuapps.androidlabs.soft1614080902135.R;
 import java.io.File;
 import java.io.FileOutputStream;
 import java.io.OutputStream;

         public class com1614080901230Activity2 extends AppCompatActivity {
     private ImageView iv;
     private Bitmap baseBitmap;
     private Canvas canvas;
     private Paint paint;
     private Button newButton1;
     @Override
     protected void onCreate(Bundle savedInstanceState) {

                            super.onCreate(savedInstanceState);
                    setContentView(R.layout.activity_com1614080901230);
                    newButton1=(Button)findViewById(R.id.button_3);
                    newButton1.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View v) {
                                    save();
                                }
         });
}
             public void save() {
                         try {
                                File file = new File(Environment.getExternalStorageDirectory(),
                                                System.currentTimeMillis() + ".jpg");
                                 OutputStream stream = new FileOutputStream(file);
                                 baseBitmap.compress(Bitmap.CompressFormat.JPEG, 100, stream);
                                 stream.close();
                                 Intent intent = new Intent();
                                 intent.setAction(Intent.ACTION_MEDIA_MOUNTED);
                                 intent.setData(Uri.fromFile(Environment
                                                .getExternalStorageDirectory()));
                                 sendBroadcast(intent);
                            } catch (Exception e) {
                                 Toast.makeText(com1614080901230Activity2.this, "保存图片成功",Toast.LENGTH_SHORT).show();

                                         e.printStackTrace();
                            }
                     }
 }
