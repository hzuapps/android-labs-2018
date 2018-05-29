package edu.hzuapps.androidlabs.soft1614080902218;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.support.v7.widget.Toolbar;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.os.Handler;
import android.widget.ImageView;
import java.io.File;



public class soft1614080902218activity extends AppCompatActivity {

    private ImageButton pai1, pai2;
    private Button wendu;
    private Button shidu;
    private ImageView beijin;
    private Handler handler=new Handler();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_soft1614080902218activity);

        beijin=(ImageView)findViewById(R.id.imageView_beijin);
        pai1 = (ImageButton) findViewById(R.id.wendu);
        pai2 = (ImageButton) findViewById(R.id.shidu);

        pai1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(soft1614080902218activity.this,SecordActivity.class);
                startActivity(intent);
            }
        });
        pai2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(soft1614080902218activity.this,ThirdActivity.class);

                startActivity(intent);
            }
        });
        ((Button)findViewById(R.id.button_xiazai)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                       new HttpThread("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1527354054160&di=f05fd0dfb4bc39747b1ff1a9731b5448&imgtype=0&src=http%3A%2F%2Fimgsrc.baidu.com%2Fimgad%2Fpic%2Fitem%2F43a7d933c895d143052ae82979f082025aaf075f.jpg",beijin,handler).start();
                       }});
    }
}
