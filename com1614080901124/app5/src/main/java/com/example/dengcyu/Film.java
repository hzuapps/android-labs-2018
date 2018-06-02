package com.example.dengcyu;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;




public class Film extends AppCompatActivity {
    public static final String DIRECTORY = "leaderboard";
    public static final String FILENAME = "file_leaderboard.txt";

    public static final String TAG = Film.class.getSimpleName();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_Film);

        Button textView2 = (Button) findViewById(R.id.button_open3);
        textView2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Film.this, com1614080901124Activity.class);
                startActivity(intent);
        Button textView3 = (Button) findViewById(R.id.button_open4);
                textView3.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Intent intent = new Intent（Activity2.class, Film.class);
                        startActivity(intent);
            }
        });
    }
