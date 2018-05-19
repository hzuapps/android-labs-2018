package edu.hzuapps.androidlabs.myapplication;
import android.app.Activity;
import android.content.Intent;
import android.view.View;
import android.os.Bundle;
import android.widget.Button;
public class select extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.select);

        final Activity thisActivity=this;
        Button btnopen1=(Button) findViewById(R.id.button1);
        Button btnOpen2=(Button)findViewById(R.id.button2);

        btnopen1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(v.getId()==R.id.button1){
                    Intent intent=new Intent(select.this,create.class);
                    startActivity(intent);
                }
            }
        });
        btnOpen2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (v.getId() == R.id.button2) {
                    Intent intent = new Intent(select.this, look.class);
                    startActivity(intent);
                }
            }
        });
    }
}
