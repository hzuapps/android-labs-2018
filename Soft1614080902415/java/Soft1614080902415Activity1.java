package edu.hzuapps.androidlabs.soft1614080902415;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class Soft1614080902415Activity extends AppCompatActivity {
private Button button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.acitvity_soft1614080902415_01);
button=(Button)findViewById(R.id.btn_login);
button.setOnClickListener(new View.OnClickListener()
{
    public void onClick(View v)
    {
        Toast.makeText(Soft1614080902415Activity.this,"Äãµ±Ç°Î´×âÈÎºÎ³µÁ¾",Toast.LENGTH_SHORT).show();
    }
});
    }

}
