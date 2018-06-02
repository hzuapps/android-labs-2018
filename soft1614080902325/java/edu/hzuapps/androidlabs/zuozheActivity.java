package edu.hzuapps.androidlabs.soft1614080902325;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.io.FileOutputStream;
import java.util.Map;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

public class zuozheActivity extends AppCompatActivity {
    private Button tv_11;
    private EditText tv_2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_zuozhe);
        tv_11 = (Button)findViewById(R.id.tv_11);
        tv_2 = (EditText)findViewById(R.id.tv_2);
        tv_11.setOnClickListener(new Suibian());

    }
    private class Suibian implements View.OnClickListener{
        @Override
        public void onClick(View v) {
            EditText tv_3 = (EditText)findViewById(R.id.tv_3);
            String content;
            String filename = "data.txt";
            content = "name:"+tv_2.getText().toString()+"gender:"+tv_3.getText().toString();
            FileOutputStream fos;
            try{
                fos = openFileOutput(filename,MODE_PRIVATE);
                fos.write(content.getBytes());
                fos.close();
            }catch (Exception e){
                e.printStackTrace();
            }
        }
    }


}
