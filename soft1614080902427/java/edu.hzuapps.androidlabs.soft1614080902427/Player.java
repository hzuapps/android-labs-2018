package edu.hzuapps.androidlabs.soft1614080902427;

import android.content.Context;
import android.content.Intent;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.app.Activity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;


public class Player extends Activity implements View.OnClickListener {
    private static final int READ_REQUEST_CODE = 42;

    private static boolean playing = false;
    private MediaPlayer mp = null;
    private Button BtnPrev,BtnNext,BtnPlay;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_player);

        //设置按钮监听事件
        BtnPrev = (Button) findViewById(R.id.BtnPrev);
        BtnPrev.setOnClickListener(this);
        BtnNext = (Button) findViewById(R.id.BtnNext);
        BtnNext.setOnClickListener(this);
        BtnPlay = (Button) findViewById(R.id.BtnPlay);
        BtnPlay.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        Button btn = (Button)v;
        if(btn==BtnPrev) {
            openFilePicker();
        }
        else if(btn==BtnPlay){
            if(playing==false) onPlayerPlay(null);
            else onPlayerPause();
        }
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode,Intent resultData){
        //从谷歌Android文档复制
        if(requestCode==READ_REQUEST_CODE && resultCode == Activity.RESULT_OK){
            Uri uri = null;
            if (resultData != null) {
                uri = resultData.getData();
                onPlayerPlay(uri);
            }

        }
    }
    public void onPlayerPlay(Uri uri) {
        if(uri!=null) {
            if (mp != null) mp.stop();
            TextView tv = (TextView)findViewById(R.id.editText);
            tv.setText(uri.toString());
            mp = MediaPlayer.create(this, uri);
            mp.setLooping(true);
        }
        try {
            mp.start();
            playing = true;
            BtnPlay.setText(R.string.player_control_pause);
        } catch (Exception e) {
            e.printStackTrace();
            playing = false;
            BtnPlay.setText(R.string.player_control_play);
            Toast.makeText(this,"没有正在播放的文件",Toast.LENGTH_LONG).show();
        }
    }

    public void onPlayerPause(){
        if(mp!=null){
            mp.pause();
            playing = false;
            BtnPlay.setText(R.string.player_control_play);
        }
    }
    public void openFilePicker() {
        //从谷歌Android文档复制
        Intent intent = new Intent(Intent.ACTION_OPEN_DOCUMENT);

        // Filter to only show results that can be "opened", such as a
        // file (as opposed to a list of contacts or timezones)
        intent.addCategory(Intent.CATEGORY_OPENABLE);

        // Filter to show only images, using the image MIME data type.
        // If one wanted to search for ogg vorbis files, the type would be "audio/ogg".
        // To search for all documents available via installed storage providers,
        // it would be "*/*".
        intent.setType("audio/*");

        startActivityForResult(intent, READ_REQUEST_CODE);
    }

}
