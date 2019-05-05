package com.example.hzu.com1614080901106;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;

public class com1614080901106Activity extends AppCompatActivity {

    private RadioButton rbMan;
    private RadioButton rbWoman;
    private EditText etTall;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_com1614080901106);
        rbMan = (RadioButton) findViewById(R.id.rbMan);
        rbWoman = (RadioButton) findViewById(R.id.rbWoman);
        etTall = (EditText) findViewById(R.id.etTall);

        Button btn = (Button) findViewById(R.id.button2);
        btn.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick (View v){
                Intent intent = new Intent(com1614080901106Activity.this, thirdActivity.class);
                startActivity(intent);
            }

        });
    }


    public void calculate(View view){
        String sex;
        if(rbMan.isChecked())
            sex=rbMan.getText().toString();
        else
            sex=rbWoman.getText().toString();
        double tall=Double.parseDouble(etTall.getText().toString());
        Intent intent=new Intent();
        intent.setClass(this,secondActivity.class);
        Bundle bundle=new Bundle();
        bundle.putString("sex",sex);
        bundle.putDouble("tall",tall);
        intent.putExtras(bundle);
        startActivity(intent);
    }
}
