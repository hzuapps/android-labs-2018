package edu.hzuapps.androidlabs.com1614080901113;

import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {
    private TextView picture,tv_grade;
    private Button camera;
    private Button test;

    private SharedPreferences sp;
    private SharedPreferences.Editor editor;
    int grade;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        sp=getSharedPreferences("Grade",MODE_PRIVATE);
        editor=sp.edit();

        picture=(TextView)findViewById(R.id.picture);
        camera=(Button)findViewById(R.id.camera);
        test=(Button)findViewById(R.id.test);
        tv_grade=(TextView)findViewById(R.id.tv_grade);

        test.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                grade=(int)(Math.random()*99+1);
                editor.putInt("Grade",grade);
                editor.commit();

                Integer Grade=sp.getInt("Grade",0);
                tv_grade.setText(Grade+" !");
            }
        });
    }


}
