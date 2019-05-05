package edu.hzuapps.androidlabs.soft1614080902327;

import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

import pub.devrel.easypermissions.AppSettingsDialog;
import pub.devrel.easypermissions.EasyPermissions;


public class ThirdActivity extends AppCompatActivity implements EasyPermissions.PermissionCallbacks {

    private static final int REQUEST_CODE_SAVE_IMG = 10;
    private static final String TAG = "MainActivity";
    private Context mContext;
    private EditText editText;
    private Button button;
    private Button button1;
    private ImageView imageView;
    private Bitmap bitmap;
    //�ֱ����µ�����
    Handler handler=new Handler(){
        public void handleMessage(Message msg) {
            if(msg.what==111){
                imageView.setImageBitmap(bitmap);
            }
        };
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        //��ʼ�����
        editText=(EditText) findViewById(R.id.editText2);
        button=(Button) findViewById(R.id.download);
        button1=(Button)findViewById(R.id.save) ;
        imageView=(ImageView) findViewById(R.id.imageView);

        mContext = this;
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new Thread(t).start();

            }
        });
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                requestPermission();
            }
        });
    }

    //Ϊ������ͼƬ��Դ������һ���µ����߳�
    Thread t=new Thread() {
        public void run() {
            //����ͼƬ��·��
            String iPath = editText.getText().toString();
            try {
                //����Դ����
                URL url = new URL(iPath);
                //��������
                InputStream inputStream = url.openStream();
                //��������Դ��������ת��λͼͼƬ
                bitmap = BitmapFactory.decodeStream(inputStream);
                handler.sendEmptyMessage(111);
                inputStream.close();
            }catch (MalformedURLException e){
                e.printStackTrace();
            }catch (IOException e){
                e.printStackTrace();
            }
        }
    };
    /**
             * �����ȡsd����Ȩ��
             */
                private void requestPermission() {
                    if (Build.VERSION.SDK_INT >= 23) {
                        //��ȡsd����Ȩ��
                        String[] mPermissionList = new String[]{Manifest.permission.READ_EXTERNAL_STORAGE, Manifest.permission.WRITE_EXTERNAL_STORAGE};
                        if (EasyPermissions.hasPermissions(mContext, mPermissionList)) {
                //�Ѿ�ͬ���
                saveImage(bitmap);
            } else {
                //δͬ���,����˵�Ǿܾ��ˣ��ٴ�����Ȩ��
                EasyPermissions.requestPermissions(
                        this,  //������
                        "����ͼƬ��Ҫ��ȡsd����Ȩ��", //��ʾ����
                        REQUEST_CODE_SAVE_IMG, //������
                        mPermissionList //Ȩ���б�
                );
            }
        } else {
            saveImage(bitmap);
        }
    }


    //����ͼƬ
    private void saveImage(Bitmap bitmap) {

        boolean isSaveSuccess = ImgUtils.saveImageToGallery(mContext, bitmap);
        if (isSaveSuccess) {
            Toast.makeText(mContext, "����ͼƬ�ɹ�", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(mContext, "����ͼƬʧ�ܣ����Ժ�����", Toast.LENGTH_SHORT).show();
        }
    }

    //��Ȩ������ַ���ȥ
    @Override
    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        // Forward results to EasyPermissions
        //��ת��onPermissionsGranted����onPermissionsDeniedȥ�ص���Ȩ���
        EasyPermissions.onRequestPermissionsResult(requestCode, permissions, grantResults, this);
    }


    //ͬ����Ȩ
    @Override
    public void onPermissionsGranted(int requestCode, List<String> list) {
        Log.i(TAG, "onPermissionsGranted:" + requestCode + ":" + list.size());
        saveImage(bitmap);
    }

    //�ܾ���Ȩ
    @Override
    public void onPermissionsDenied(int requestCode, List<String> perms) {
        Log.i(TAG, "onPermissionsDenied:" + requestCode + ":" + perms.size());
        if (EasyPermissions.somePermissionPermanentlyDenied(this, perms)) {
            //��ϵͳ���ã��ֶ���Ȩ
            new AppSettingsDialog.Builder(this).build().show();
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == AppSettingsDialog.DEFAULT_SETTINGS_REQ_CODE) {
            //�ܾ���Ȩ�󣬴�ϵͳ��������Ȩ�󣬷���APP������Ӧ�Ĳ���
            Log.i(TAG, "onPermissionsDenied:------>�Զ���������Ȩ�󷵻�APP");
            saveImage(bitmap);
        }
    }
}