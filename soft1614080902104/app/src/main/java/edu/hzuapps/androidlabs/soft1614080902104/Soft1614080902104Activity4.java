package edu.hzuapps.androidlabs.soft1614080902104;


import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.content.Intent;
import android.view.View;
import android.widget.TextView;
import org.w3c.dom.Text;
import android.widget.Button;

public class Soft1614080902104Activity extends AppCompatActivity {
    private TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_soft1614080902104);

        Button btnCancel2=(Button)findViewById(R.id.button2);
        btnCancel2.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent intent = new Intent();
                intent.setClass(Soft1614080902104Activity.this, Main1Activity.class);
                startActivity(intent);
            }
        });




    }
}
