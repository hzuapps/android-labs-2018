package soft1614080902322.androidlabs.hzuapps.edu.soft1614080902322_;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_soft1614080902322);
            Button btn_Click = (Button)findViewById(R.id.Game1);
            Button btn_Click1 = (Button)findViewById(R.id.Game2);
            Button btn_Click2 = (Button)findViewById(R.id.add);
            btn_Click.setOnClickListener(new MyOnClickListener());
            btn_Click1.setOnClickListener(new MyOnClickListener1());

        }
        class MyOnClickListener implements View.OnClickListener{
            @Override
            public void onClick(View v){
                if(v.getId()==R.id.Game1) {
                    Intent intent = new Intent(MainActivity.this,Remote_0f_Game1.class);
                    startActivity(intent);
                }
            }

        }
        class MyOnClickListener1 implements View.OnClickListener{
            @Override
            public void onClick(View v){
                if(v.getId()==R.id.Game2) {
                    Intent intent1 = new Intent(MainActivity.this,Remote_of_Game2.class);
                    startActivity(intent1);
                }
            }

        }
    }
}
