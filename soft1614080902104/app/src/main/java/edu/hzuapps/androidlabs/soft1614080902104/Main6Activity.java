package edu.hzuapps.androidlabs.soft1614080902104;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.LinearLayout;

import java.util.ArrayList;

public class Main6Activity extends AppCompatActivity {

    LinearLayout layout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main6);
        layout = findViewById(R.id.layout);

        Intent intent = getIntent();
        ArrayList<String> images = (ArrayList<String>) intent.getSerializableExtra("images");
        for(int i=0;i<images.size();i++){
            String imagePath = images.get(i);
            Bitmap bitmap = BitmapFactory.decodeFile(imagePath);
            ImageView imageView = new ImageView(this);
            imageView.setImageBitmap(bitmap);
            imageView.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
            imageView.setAdjustViewBounds(true);

            layout.addView(imageView);
        }
    }
}