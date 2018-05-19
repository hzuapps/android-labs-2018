package com.hzu.com1614080901120;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class Com1614080901120MainActivity extends AppCompatActivity {
    private ImageView imageView;
    private Button newbutton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_com1614080901120_main);

        imageView = (ImageView) findViewById(R.id.textview_01);
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(Com1614080901120MainActivity.this,AddPictureActivity.class);
                startActivity(intent);
            }
        });
        newbutton=(Button) findViewById(R.id.button);
        newbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(Com1614080901120MainActivity.this,AddPictureActivity.class);
                startActivity(intent);
            }
        });
}
}