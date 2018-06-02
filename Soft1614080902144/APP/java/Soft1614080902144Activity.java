package edu.huzapps.androidlabs.soft1614080902144;

import android.annotation.SuppressLint;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Environment;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

public class Soft1614080902144Activity extends AppCompatActivity {
    private ImageView imageView1;
    private Button downButton;
    private EditText webEditText;
    private ImageView showImageView;

    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_soft1614080902144);
        imageView1 = (ImageView) findViewById(R.id.image_view);
        webEditText=(EditText)findViewById(R.id.imagepath);
        showImageView=(ImageView)findViewById(R.id.imageView0) ;
        imageView1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Soft1614080902144Activity.this, Soft1614080902144Activity2.class);
                startActivity(intent);
            }
        });
        downButton=(Button)findViewById(R.id.downpt);
        downButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Glide.with(Soft1614080902144Activity.this)
                        .load(webEditText.getText().toString())
                        .into(showImageView);
            }
        });

    }
}