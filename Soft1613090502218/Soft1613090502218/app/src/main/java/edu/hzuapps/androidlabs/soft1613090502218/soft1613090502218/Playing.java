package edu.hzuapps.androidlabs.soft1613090502218.soft1613090502218;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Playing extends Activity {
    EditText et2;
    Button jump2;
    Button jump3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_playing);

        et2=(EditText)findViewById(R.id.et2);

        jump2=(Button)findViewById(R.id.jump2);
        jump3=(Button)findViewById(R.id.jump3);
        jump2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int getet=Integer.parseInt(et2.getText().toString());
                Intent intent=new Intent(Playing.this,InputName.class);
                intent.putExtra("dps",getet);
                startActivity(intent);
            }
        });
        jump3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(Playing.this,ShowNString.class);
                startActivity(intent);
            }
        });
    }
}
