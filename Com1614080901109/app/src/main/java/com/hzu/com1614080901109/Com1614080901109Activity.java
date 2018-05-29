package edu.androidlabs.com1614080901109;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Com1614080901109Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_com1614080901109);
        Button button0 = (Button)findViewById(R.id.xieru);/*c将layout中创建的button关联起来*/
        button0.setOnClickListener(button_listener);
    }
    private Button.OnClickListener button_listener = new Button.OnClickListener(){     //创建button listener
        public void onClick(View v){

            Intent intent = new Intent();
            intent.setClass(Com1614080901109Activity.this,TestActivity.class);
            startActivity(intent);

        }
    };

}
