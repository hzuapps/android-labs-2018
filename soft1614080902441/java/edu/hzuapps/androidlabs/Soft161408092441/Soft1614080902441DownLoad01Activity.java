package edu.hzuapps.androidlabs.Soft161408092441;
        import android.os.Bundle;
        import android.support.v7.app.AppCompatActivity;
        import android.view.View;
        import android.widget.Button;
        import android.widget.EditText;
        import android.content.SharedPreferences;
        import android.content.Context;
        import android.content.Intent;
public class Soft1614080902441DownLoad01Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_soft1614080902441_download);
        final EditText editText=(EditText)findViewById(R.id.editText);
        //��ȡ�ؼ�
        Button btnLogin=(Button)findViewById(R.id.button0);
        // Button buttonque=(Button)findViewById(R.id.queding);
        //final EditText EdPassword=(EditText) findViewById(R.id.edit_text);
        final EditText EdUserName=(EditText)findViewById(R.id.editText);

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences sharedPreferences = getSharedPreferences("jnc", Context.MODE_PRIVATE);//����SharedPreferences����
                SharedPreferences.Editor editor = sharedPreferences.edit(); //��Ҫ��ȡSharedPreferences�ı༭����
                editor.putString("username", editText.getText().toString()); //��preferencesд�����ݣ�
                //editor.putString("Password", EdPassword.getText().toString());
                editor.commit();// ��preferences�ļ����ύ���ݣ�
                Intent intent=new Intent(Soft1614080902441DownLoad01Activity.this,Soft1614080902441DownLoad02Activity.class);
                startActivity(intent);
            }
        } );
    }

}