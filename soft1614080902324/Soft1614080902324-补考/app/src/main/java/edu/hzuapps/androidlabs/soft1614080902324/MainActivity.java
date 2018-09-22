package edu.hzuapps.androidlabs.soft1614080902324;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class MainActivity extends AppCompatActivity {
        Button button = null;
        private EditText S;
        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_main);

            Button button1 = (Button)findViewById(R.id.button_open);
            button1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent();
                    intent.setClass(MainActivity.this,Soft1614080902324Activity2.class);
                    startActivity(intent);
                }
            });
            Button button2 = (Button)findViewById(R.id.button);
            button2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    S=(EditText) findViewById(R.id.editText3);
                    saveContent();
                    Intent intent = new Intent();
                    intent.setClass(MainActivity.this,Soft1614080902324Activity3.class);
                    startActivity(intent);

                }
            });
        }
        private void saveContent() {
            FileOutputStream fos = null;
            String content1 = S.getText().toString();

            try {
                fos = this.openFileOutput("search.txt", MODE_PRIVATE);
                fos.write(content1.getBytes());
                fos.flush();
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                if (fos != null) {
                    try {
                        fos.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
}
