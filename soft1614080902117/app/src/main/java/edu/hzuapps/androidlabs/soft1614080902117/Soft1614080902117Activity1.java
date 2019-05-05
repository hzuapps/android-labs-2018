package edu.hzuapps.androidlabs.soft1614080902117;


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.lang.String;
import android.widget.EditText;


public class Soft1614080902117Activity1 extends Activity {

    private EditText editText;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_soft16140809021171);
        final Activity thisActivity = this;
        Button btnBack = (Button)findViewById(R.id.button3);
        Button btnJoin= (Button)findViewById(R.id.button4);
        editText = (EditText)findViewById(R.id.editText);

        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(thisActivity,Soft1614080902117Activity.class);
                thisActivity.startActivity(intent);
            }
        });
        btnJoin.setOnClickListener(new View.OnClickListener() {   //添加保存文件
            @Override
            public void onClick(View v) {
                String  inputText = editText.getText().toString();
                save(inputText);
                Intent intent = new Intent(thisActivity,Soft1614080902117Activity.class);
                thisActivity.startActivity(intent);
            }
        });
    }

    public void save(String inputText){
        FileOutputStream out;
        BufferedWriter  writer = null;
        try {
            out = openFileOutput("data", MODE_PRIVATE);
            writer = new BufferedWriter(new OutputStreamWriter(out));
            writer.write(inputText);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if(writer!=null){
                    writer.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }
}