package edu.hzuapps.androidlabs.soft1614080902415;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class Soft1614080902415Activity1 extends AppCompatActivity implements View.OnClickListener {
    private Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.acitvity_soft1614080902415_01);
        button = (Button) findViewById(R.id.btn_login);
        button.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        // TODO Auto-generated me
        Intent intent = new Intent(this,Soft1614080902415Activity2.class);

        startActivity(intent);


    }
}