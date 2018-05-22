package edu.hzuapps.androidlabs.Com1614080901239;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import static edu.hzuapps.androidlabs.Com1614080901239.Com1614080901239Activity.FPATH;

public class journal extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_journal);
        final Activity thisActivity = this;

        Button btnOpen = (Button) findViewById(R.id.return_btn);
        SharedPreferences sharedPreferences = getSharedPreferences("data",MODE_PRIVATE);

        showResult(sharedPreferences.getString("text",""));
        btnOpen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(thisActivity, Com1614080901239Activity.class);
                thisActivity.startActivity(intent);

                //thisActivity.startActivityForResult(intent, 2016);
            }
        });
    }

    private void showResult(String result) {

        ((TextView) findViewById(R.id.journal)) //
                .setText(result);
    }
}
