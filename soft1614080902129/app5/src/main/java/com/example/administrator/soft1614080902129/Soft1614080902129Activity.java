package com.example.administrator.soft1614080902129;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

public class Soft1614080902129Activity extends AppCompatActivity {
    private TextView textView;
    private MenuItem setbk;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_soft1614080902129);

        textView=(TextView)findViewById(R.id.button);
        textView.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v){
                Intent intent=new Intent(Soft1614080902129Activity.this,SecondActivity.class);
                startActivity(intent);
            }});
        setbk=(MenuItem) findViewById(R.id.action_setbk);
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.setbk, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_setbk:
                Intent intent=new Intent();
                intent.setClass(Soft1614080902129Activity.this,ThirdActivity.class);
                startActivity(intent);
               Soft1614080902129Activity.this.finish();
                break;
        }
        return super.onOptionsItemSelected(item);
    }

}


