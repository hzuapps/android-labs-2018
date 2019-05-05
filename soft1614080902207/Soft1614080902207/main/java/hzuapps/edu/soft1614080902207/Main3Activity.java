package edu.hzuapps.androidlabs.soft1614080902207;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Main3Activity extends AppCompatActivity {
    private EditText picAdd;
    private Button savePic;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        picAdd = this.findViewById(R.id.picAdd);
        savePic = this.findViewById(R.id.savePic);

        savePic.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                SharedPreferences sp = getSharedPreferences("User", Context.MODE_PRIVATE);
                SharedPreferences.Editor edit = sp.edit();
                edit.putString("Address", picAdd.getText().toString());
                edit.commit();
                Intent intent = new Intent(Main3Activity.this, Main4Activity.class);
                startActivity(intent);
            }
        });
    }
}
