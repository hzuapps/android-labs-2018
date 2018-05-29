package soft1614080902322.androidlabs.hzuapps.edu.soft1614080902322_;

import android.content.ContextWrapper;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.*;
import java.util.*;

public class Main2Activity extends AppCompatActivity {
    private TextView textView;

    public static final String DIRECTORY = "demo";
    public static final String FILENAME = "file_demo.txt";

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        textView=(TextView)findViewById(R.id.button3);
        textView.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v){
                Intent intent=new Intent(Main2Activity.this,Main2Activity.class);
                startActivity(intent);
            }});

        ((Button) findViewById(R.id.button2)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String text = ((EditText) findViewById(R.id.editText)).getText().toString();
                save(text);
            }
        });
    }

    public void save(String text){
        FileOutputStream out=null;
        BufferedWriter writer=null;
        try{
            out=openFileOutput("demo", ContextWrapper.MODE_APPEND);
            writer=new BufferedWriter(new OutputStreamWriter(out));
            writer.write(text);
        }catch (IOException e){
            e.printStackTrace();
        }finally {
            try {
                if(writer!=null){
                    writer.close();
                }
            }catch (IOException e){
                e.printStackTrace();
            }
        }
        File dir = this.getFilesDir();
        File file = new File(dir, FILENAME);


        if (file.exists()) {
            file.canRead();
            file.canWrite();
            file.canExecute();

            file.getFreeSpace();
            file.getTotalSpace();
        }

        FileOutputStream fos = null;

        try {
            fos = openFileOutput(FILENAME, MODE_PRIVATE);
            fos.write(text.getBytes());
            fos.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                fos.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        FileReader reader = null;

        try {
            reader = new FileReader(file.getAbsoluteFile());
            BufferedReader bReader = new BufferedReader(reader);
            String line = bReader.readLine();
            Log.v("","读取的文件："+line);
            bReader.close();
            reader.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        }
    }
}


