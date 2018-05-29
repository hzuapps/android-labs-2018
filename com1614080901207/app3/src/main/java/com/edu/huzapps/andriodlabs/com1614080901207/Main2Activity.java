package com.edu.huzapps.andriodlabs.com1614080901207;

import android.annotation.SuppressLint;
import android.content.ContextWrapper;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;

import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;

/**
 *
 */
public class Main2Activity extends AppCompatActivity implements View.OnClickListener, AdapterView.OnItemSelectedListener {

    TextView txv,txvTime;
    Spinner cinema,time;
    Button but;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        txv = findViewById(R.id.testview_id);

        txvTime = findViewById(R.id.testview_timer);
        cinema = findViewById(R.id.spinner);

        time = findViewById(R.id.spinner_time);
        time.setOnItemSelectedListener(this);

        but= findViewById(R.id.bt_selt);
        but.setOnClickListener(this);
    }


    @SuppressLint("SetTextI18n")
    @Override
    public void onClick(View view) {

        String [] cinemas=getResources().getStringArray(R.array.cinemas);

        int index = cinema.getSelectedItemPosition();//选取的位置

        txv.setText("订"+" "+cinemas[index]+" "+"票");

        String s = txv.getText().toString().trim();
        save(s);
    }

    //这一种可以实时显示选择
    @SuppressLint("SetTextI18n")
    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
        String [] times=getResources().getStringArray(R.array.time);
        txvTime.setText("时间："+" " + times[i]);
        String s = txvTime.getText().toString().trim();
        save(s);
    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }


    private void save(String s) {
        FileOutputStream out=null;
        BufferedWriter writer=null;
        try{
            try {
                out=openFileOutput("baocun", ContextWrapper.MODE_APPEND);//name:"baocun"是用于指定文件名称。创建的文件保存在/data/data/<package name>/fileMODE_APPEND目录中。MODE_APPEND是私有，在原有内容追加数据。
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
            assert out != null;
            writer=new BufferedWriter(new OutputStreamWriter(out));
            writer.write(s);

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
    }
}
