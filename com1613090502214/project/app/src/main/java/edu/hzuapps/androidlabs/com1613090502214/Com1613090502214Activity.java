package edu.hzuapps.androidlabs.com1613090502214;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

public class Com1613090502214Activity extends AppCompatActivity {
    private TextView textView;
    private MenuItem setbk;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_com1613090502214);

        textView=(TextView)findViewById(R.id.button);
        textView.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v){
                Intent intent=new Intent(Com1613090502214Activity.this,SecondActivity.class);
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
                intent.setClass(Com1613090502214Activity.this,ThirdActivity.class);
                startActivity(intent);
                Com1613090502214Activity.this.finish();
                break;
        }
        return super.onOptionsItemSelected(item);
    }

}

