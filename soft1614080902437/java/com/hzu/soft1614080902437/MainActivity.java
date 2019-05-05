
package com.hzu.soft1614080902437;

        import android.support.v7.app.AppCompatActivity;
        import android.os.Bundle;
        import android.content.Intent;
        import android.widget.Button;
        import android.view.View;
public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button button0 = (Button)findViewById(R.id.button_start);/*c将layout中创建的button关联起来*/
        button0.setOnClickListener(button_listener);
    }
    private Button.OnClickListener button_listener = new Button.OnClickListener(){     //创建button listener
        public void onClick(View v){

            Intent intent = new Intent();
            intent.setClass(MainActivity.this,Soft1614080902437Activity.class);
            startActivity(intent);

        }
    };


}