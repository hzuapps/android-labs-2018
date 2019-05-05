package edu.androidlabs.soft1614080902413;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View.OnClickListener;
import android.widget.TextView;
import android.content.Intent;
import android.widget.Button;
import android.view.View;
public class Soft1614080902413Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_soft1614080902413);
        Button button1 = (Button)findViewById(R.id.my_button);/*c将layout中创建的button关联起来*/
        button1.setOnClickListener(button_listener);
    }
    private Button.OnClickListener button_listener = new Button.OnClickListener(){     //创建button listener
        public void onClick(View v){

            Intent intent = new Intent();
            intent.setClass(Soft1614080902413Activity.this,OpenActivity.class);
            startActivity(intent);

        }
    };


}
