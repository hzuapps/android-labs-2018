package edu.hzuapps.androidlabs.soft1613071002123.myapplication;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class InputActivity extends AppCompatActivity {

    private static final String TAG = "InputActivity";
    private String edit;
    private EditText editText;
    private SharedPreferences preferences;
    private SharedPreferences.Editor editor;
    private Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_input);
        preferences = PreferenceManager.getDefaultSharedPreferences(this);
        editText = findViewById(R.id.edit_text);
        button = findViewById(R.id.save_btn);

        edit = preferences.getString("edit", "");
        editText.setText(edit);
//        Log.d(TAG, "onCreate: ");
        initButton();
    }

    private void initView() {

    }

    private void initButton() {

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                Log.d(TAG, "onClick: ");
               edit = editText.getText().toString();
                editor = preferences.edit();
                editor.putString("edit", edit);
                editor.apply();
//                Log.d(TAG, "onClick: " + string);
            }
        });
    }

}
