package edu.hzuapps.androidlabs.soft1614080902445;
import android.content.ContextWrapper;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import org.w3c.dom.Text;

import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;

import android.view.View;
import android.widget.Toast;

public class Soft1614080902445Activity2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_soft1614080902445_02);
        ((Button) findViewById(R.id.button2)).

                setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        String text = ((EditText) findViewById(R.id.editText2)).getText().toString();
                        save(text);
                    }
                });
        ((Button) findViewById(R.id.button3)).

                setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        read();
                    }
                });

    }





    public void save(String text) {
        FileOutputStream out = null;
        BufferedWriter writer = null;
        try {
            out = openFileOutput("zz.txt", ContextWrapper.MODE_APPEND);
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
            Toast.makeText(Soft1614080902415Activity2.this, "借书成功", Toast.LENGTH_SHORT).show();
        }
    }

    public void read() {
        String content = "";
        try {
            FileInputStream fis = openFileInput("zz.txt");
            byte[] buffer = new byte[fis.available()];
            fis.read(buffer);
            content = new String(buffer);
            fis.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        Toast.makeText(Soft1614080902415Activity2.this, "你借的书是" + content, Toast.LENGTH_SHORT).show();
    }
}

