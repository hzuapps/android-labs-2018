package edu.hzuapps.androidlabs.soft1614080902212;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
public class SecondActivity extends AppCompatActivity {

    private Button Button;
    private EditText Edit;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        Button=(Button)findViewById(R.id.button2);
        Edit = (EditText)findViewById(R.id.sr1);
        Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String sr = Edit.getText().toString();

                if (sr.equals("")) {

                    Toast.makeText(SecondActivity.this, "请输入您的时间段", Toast.LENGTH_SHORT).show();

                } else {
                    Intent intent=new Intent(SecondActivity.this,ThirdActivity.class);
                    startActivity(intent);

                }
            }
        });
    }
}
