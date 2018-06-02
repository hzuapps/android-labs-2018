package com.example.administrator.soft1614080902230;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class ThirdActivity extends AppCompatActivity {
    private ImageView kebiao;
    private Handler handler=new Handler();
    private Button xiazai;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third);
        kebiao=(ImageView)findViewById(R.id.kebiao);
        xiazai=(Button)findViewById(R.id.xiazai);
        xiazai.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new HttpThread("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1527937861957&di=f6d7eea5e3df91e6488c7cd867e4a947&imgtype=0&src=http%3A%2F%2Fpic2.ooopic.com%2F10%2F53%2F44%2F82b1OOOPIC10.jpg",kebiao,handler).start();
            }
        });
    }
}
