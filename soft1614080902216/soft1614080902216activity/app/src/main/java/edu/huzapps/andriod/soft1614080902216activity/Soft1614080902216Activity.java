package edu.huzapps.andriod.soft1614080902216;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
public class Soft1614080902216Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_soft1614080902216);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
        Button btnOpen1 = (Button) findViewById(R.id.button1);
        btnOpen1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Soft1614080902216Activity.this, MainActivity.class);
                startActivity(intent);
                //thisActivity.startActivityForResult(intent, 2016);
            }
        });
        Button btnOpen2 = (Button) findViewById(R.id.button2);
        btnOpen2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Soft1614080902216Activity.this, Main2Activity.class);
                startActivity(intent);
                //thisActivity.startActivityForResult(intent, 2016);
            }
        });
        Button btnOpen3 = (Button) findViewById(R.id.button3);
        btnOpen3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Soft1614080902216Activity.this, Main3Activity.class);
                startActivity(intent);
                //thisActivity.startActivityForResult(intent, 2016);
            }
        });
        Button btnOpen4 = (Button) findViewById(R.id.button4);
        btnOpen4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Soft1614080902216Activity.this, Main4Activity.class);
                startActivity(intent);
                //thisActivity.startActivityForResult(intent, 2016);
            }
        });
        Button btnOpen5 = (Button) findViewById(R.id.button5);
        btnOpen5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Soft1614080902216Activity.this, Main5Activity.class);
                startActivity(intent);
                //thisActivity.startActivityForResult(intent, 2016);
            }
        });
        Button btnOpen6 = (Button) findViewById(R.id.button6);
        btnOpen6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Soft1614080902216Activity.this, Main6Activity.class);
                startActivity(intent);
                //thisActivity.startActivityForResult(intent, 2016);
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_soft1614080902216, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }


}
