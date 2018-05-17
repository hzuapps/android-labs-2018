package com.hzu.com1614080901120;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class Com1614080901120MainActivity extends AppCompatActivity {
       private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_com1614080901120_main);

        textView=(TextView)findViewById(R.id.page);

        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                                        Intent intent=new Intent(Com1614080901120MainActivity.this,AddPictureActivity.class);
                                        startActivity(intent);
                                    }
    });
}
}