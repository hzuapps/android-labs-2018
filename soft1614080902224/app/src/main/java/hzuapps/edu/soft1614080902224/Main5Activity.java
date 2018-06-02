package com.example.soft1614080902224;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import android.content.ContextWrapper;
import android.widget.Button;
import android.widget.EditText;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;

        import android.view.View;
import android.widget.Toast;

public class Main5Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main5);

                        ((Button) findViewById(R.id.button)).

                                setOnClickListener(new View.OnClickListener() {
                   @Override
                    public void onClick(View v) {
                                               String text = ((EditText) findViewById(R.id.edittext)).getText().toString();
                                               save(text);
                                           }
                });
                ((Button) findViewById(R.id.button2)).

                                setOnClickListener(new View.OnClickListener() {
                    @Override
                  public void onClick(View v) {
                                                readsy5();
                                            }
               });


                            }

            public void save(String text) {
                FileOutputStream out = null;
                BufferedWriter writer = null;
                try {
                        out = openFileOutput("sy.txt", ContextWrapper.MODE_APPEND);
                        writer = new BufferedWriter(new OutputStreamWriter(out));
                        writer.write(text);
                    } catch (IOException e) {
                        e.printStackTrace();
                   } finally {
                        try {
                               if (writer != null) {
                                        writer.close();
                                   }
                           } catch (IOException e) {
                               e.printStackTrace();
                            }
                        Toast.makeText(Main5Activity.this, "数据保存成功", Toast.LENGTH_SHORT).show();
                    }
            }

            public void readsy5() {
                String content = "";
                try {
                        FileInputStream fis = openFileInput("sy.txt");
                        byte[] buffer = new byte[fis.available()];
                        fis.read(buffer);
                        content = new String(buffer);
                        fis.close();
                    } catch (Exception e) {
                       e.printStackTrace();
                   }
                Toast.makeText(Main5Activity.this, "保存的数据是" + content, Toast.LENGTH_SHORT).show();

    }
}