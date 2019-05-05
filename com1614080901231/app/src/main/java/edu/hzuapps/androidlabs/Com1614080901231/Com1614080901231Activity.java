package ezu.hzuapps.androidlabs.Com1614080901231;

import android.Manifest;
import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.os.IBinder;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.ba.balabdemo.R;

import java.io.File;

public class Com1614080901231Activity extends AppCompatActivity {
    MyDownloadService.DownloadBind downloadBind;
    ServiceConnection connection = new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName name, IBinder service) {
            downloadBind = (MyDownloadService.DownloadBind) service;
        }

        @Override
        public void onServiceDisconnected(ComponentName name) {

        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_com1614080901231);


        Button fab = (Button) findViewById(R.id.startActivity);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(Com1614080901231Activity.this,SecondActivity.class);
                startActivity(intent);
            }
        });

        Button check=(Button)findViewById(R.id.checkUpData);
        check.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                downloadBind.startDownload
                        ("http://dl-cdn.coolapkmarket.com/down/apk_upload/2017/0731/app-release-for-152725-o_1bmc0gmt11l6vn5voikiva3or2g-uid-569540.apk?_upt=3d7374321527862114",
                                "/storage/emulated/0/leejh");
            }
        });


        Intent intent = new Intent(this, MyDownloadService.class);
        startService(intent);
        bindService(intent, connection, BIND_AUTO_CREATE);

        int wesp = ContextCompat.checkSelfPermission(this,
                Manifest.permission.WRITE_EXTERNAL_STORAGE);
        if (wesp != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(this
                    , new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE}, 1);
        } else {
            File file = new File("/storage/emulated/0/leejh");
            if (!file.isDirectory())
                file.mkdir();
        }
    }


    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        switch (requestCode) {
            case 1:
                if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    File file = new File("/storage/emulated/0/leejh");
                    if (!file.isDirectory())
                        file.mkdir();
                } else {
                    Toast.makeText(this, "没有权限", Toast.LENGTH_SHORT).show();
                   // finish();
                }
                break;
        }

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Intent intent = new Intent(this, MyDownloadService.class);
        stopService(intent);
        unbindService(connection);
    }

}
