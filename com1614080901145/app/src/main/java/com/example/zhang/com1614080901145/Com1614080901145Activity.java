package com.example.zhang.apps;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Com1614080901145Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_com1614080901145);
        Button button=(Button)findViewById(R.id.button_2);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(Com1614080901145Activity.this,Com_1614080901145Activity.class);
                startActivity(intent);
            }
        });
    }
}
