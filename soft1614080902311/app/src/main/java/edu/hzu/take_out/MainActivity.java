package edu.hzu.take_out;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;
import java.io.FileInputStream;
import java.io.FileOutputStream;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btn_jmp = findViewById(R.id.btn_jmp);
        ImageButton ib_add = findViewById(R.id.ib_add);
        Button btn_search = findViewById(R.id.btn_search);
        ImageButton ib_info=findViewById(R.id.ib_info);

        btn_jmp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "美味与你常在", Toast.LENGTH_SHORT).show();
                Intent it = new Intent();
                it.setClass(MainActivity.this, Activity3.class);
                startActivity(it);
            }
        });
        ib_add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent it = new Intent();
                it.setClass(MainActivity.this, Activity3.class);
                startActivity(it);
            }
        });

        ib_info.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent it = new Intent();
                it.setClass(MainActivity.this, Activity4.class);
                startActivity(it);
            }
        });


        btn_search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText et_food = findViewById(R.id.et_food);
                String food = et_food.getText().toString().trim();
                if (food.isEmpty())
                    write(food);
                refreshHistory(food);
            }
        });
        initHistory();

    }

    public class Activity2 extends AppCompatActivity {
        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity2);
        }
    }

    public class Activity3 extends AppCompatActivity {
        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity3);
        }

    }
    public class Activity4 extends AppCompatActivity {
        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity3);
        }

    }
    private void refreshHistory(String msg) {
        if (msg == null) return;
        TextView tv_history = findViewById(R.id.tv_history);
        String food = tv_history.getText().toString().trim();
        tv_history.setText(food + "\n" + msg);
    }

    private void initHistory() {
        String food = read();
        if (food != null)
            refreshHistory(food);
    }

    public String read() {
        try {
            FileInputStream fis = this.openFileInput("history.txt");
            byte[] buffer = new byte[1024];
            int hasRead = 0;
            StringBuilder sb = new StringBuilder();
            while ((hasRead = fis.read(buffer)) != -1) {
                sb.append(new String(buffer, 0, hasRead));
            }
            fis.close();
            return sb.toString().trim();
        } catch (Exception e) {
            e.printStackTrace();
             }
             return null;
        }
        public void write(String msg){
        if (msg == null) return;
        try{
            msg+=read();
            FileOutputStream fos=openFileOutput("storage.txt",MODE_APPEND);
            fos.write(msg.getBytes());
            fos.close();
        }catch(Exception e){
            e.printStackTrace();
            }
        }
}
