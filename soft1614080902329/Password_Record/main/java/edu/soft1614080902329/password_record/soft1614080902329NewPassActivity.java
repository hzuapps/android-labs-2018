package edu.soft1614080902329.password_record;

import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class soft1614080902329NewPassActivity extends AppCompatActivity {

    private SQLiteDatabase DB;
    private Button newPassButton = null;
    private EditText tipMsgEditText = null;
    private EditText newUsernameEditText = null;
    private EditText newPasswrodEditText = null;
    private String tipMsg = null;
    private String newUsername = null;
    private String newPassword = null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_soft1614080902329_new_pass);

        newPassButton = findViewById(R.id.save);
        newPassButton.setOnClickListener(new newPassButtonListener());
    }

    class newPassButtonListener implements View.OnClickListener {
        public void onClick(View v) {
            tipMsgEditText = findViewById(R.id.tip_msg);
            newUsernameEditText = findViewById(R.id.new_username);
            newPasswrodEditText = findViewById(R.id.new_password);
            tipMsg = tipMsgEditText.getText().toString().trim();
            newUsername = newUsernameEditText.getText().toString().trim();
            newPassword = newPasswrodEditText.getText().toString().trim();

            Log.v("sys",tipMsg + "gg");

            if(tipMsg.isEmpty() || newUsername.isEmpty() || newPassword.isEmpty()){
                Toast.makeText(soft1614080902329NewPassActivity.this,"信息不完整",Toast.LENGTH_SHORT).show();
            }else{
                DB = SQLiteDatabase.openOrCreateDatabase(getFilesDir() + "/pass_record_info.db", null);
                String sql = "insert into pass values (?,?,?);";
                DB.execSQL(sql,new String[] { tipMsg, newUsername, newPassword});
                Toast.makeText(soft1614080902329NewPassActivity.this,"保存成功",Toast.LENGTH_SHORT).show();
            }

        }
    }
}
