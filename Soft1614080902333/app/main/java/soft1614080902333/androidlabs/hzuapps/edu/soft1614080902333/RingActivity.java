package soft1614080902333.androidlabs.hzuapps.edu.soft1614080902333;

import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class RingActivity extends AppCompatActivity {
    private MediaPlayer mediaPlayer;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ring);
        //时间一到跳转Activity,在这个Activity中播放音乐
        MediaPlayer mp =MediaPlayer.create(this, R.raw.sound);
        mp.start();
    }
    public void stop(View view){
        mediaPlayer.stop();
        finish();
    }

}
