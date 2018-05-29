package edu.hzuapps.androidlabs.soft1614080902427;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class Soft1614080902427Activity extends Activity implements View.OnClickListener {
    public TextView logoBtn = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_soft1614080902427);

        logoBtn = (TextView)findViewById(R.id.textview);

    }

    @Override
    public void onClick(View view){
//        if(view.equals(logoBtn)){

           //启动新的Activity
           Intent intent = new Intent(this,Player.class);
           startActivity(intent);

////        }
    }
}
