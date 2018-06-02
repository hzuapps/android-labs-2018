package edu.hzuapps.androidlabs.com1614080901142;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class com_1614080901142Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_com_1614080901142);
        final TextView textview1=(TextView)findViewById(R.id.textview1);
        final TextView textview2=(TextView)findViewById(R.id.textview2);
        final TextView textview3=(TextView)findViewById(R.id.textview3);
        final TextView textview4=(TextView)findViewById(R.id.textview4);
        Button button3=(Button)findViewById(R.id.button_3);
        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SharedPreferences.Editor editor=getSharedPreferences("data",MODE_PRIVATE).edit();
                editor.putString("商品ID",textview1.getText().toString());
                editor.putString("商品名称",textview2.getText().toString());
                editor.putString("商品价格",textview3.getText().toString());
                editor.putString("商品库存",textview4.getText().toString());
                editor.apply();
                Intent intent=new Intent(com_1614080901142Activity.this,jsonActivity.class);
                startActivity(intent);
            }
        });
    }
}
