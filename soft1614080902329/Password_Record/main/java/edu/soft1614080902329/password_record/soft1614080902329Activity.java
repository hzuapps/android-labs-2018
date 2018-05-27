package edu.soft1614080902329.password_record;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class soft1614080902329Activity extends AppCompatActivity{

    private Button loginButtom = null;
    private Button authorButtom = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_soft1614080902329);

        loginButtom = findViewById(R.id.login);
        authorButtom = findViewById(R.id.author);
        loginButtom.setOnClickListener(new loginButtomListener());
        authorButtom.setOnClickListener(new authorButtomListerner());
    }

    private class loginButtomListener implements View.OnClickListener {
        public void onClick(View v) {
            Intent intent = new Intent();
            intent.setClass(soft1614080902329Activity.this, soft1614080902329RecordActivity.class);
            soft1614080902329Activity.this.startActivity(intent);
        }
    }
    private class authorButtomListerner implements View.OnClickListener{

        @Override
        public void onClick(View v) {
            Intent intent = new Intent();
            intent.setClass(soft1614080902329Activity.this, soft1614080902329NetWorkActivity.class);
            soft1614080902329Activity.this.startActivity(intent);
        }
    }
}
