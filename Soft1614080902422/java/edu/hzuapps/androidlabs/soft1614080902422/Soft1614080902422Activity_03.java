package edu.hzuapps.androidlabs.soft1614080902422;

import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

public class Soft1614080902422Activity_03 extends AppCompatActivity {
    protected static final int CHANGE_UI = 1;
    protected static final int ERROR = 2;
    private EditText et_path;
    private ImageView iv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_soft1614080902422_03);
        et_path = (EditText) findViewById(R.id.et_path);
        iv = (ImageView) findViewById(R.id.iv);
        // ���̴߳�����Ϣ������

    }

    ;
    // ���̴߳�����Ϣ������
    private Handler handler = new Handler() {
        @SuppressLint("WrongConstant")
        public void handleMessage(android.os.Message msg) {
            if (msg.what == CHANGE_UI) {
                Bitmap bitmap = (Bitmap) msg.obj;
                iv.setImageBitmap(bitmap);
            } else if (msg.what == ERROR) {
                Toast.makeText(Soft1614080902422Activity_03.this, "��ʾͼƬ����", 0).show();
            }
        }

        ;
    };

    @SuppressLint("WrongConstant")
    public void click(View view) {
        final String path = et_path.getText().toString().trim();
        if (TextUtils.isEmpty(path)) {
            Toast.makeText(this, "ͼƬ·������Ϊ��", 0).show();
        } else {
            //���߳���������,Android4.0�Ժ�������粻�ܷ������߳���
            new Thread() {
                public void run() {
                    // ���ӷ����� get ���� ��ȡͼƬ.
                    try {
                        URL url=new URL(path);
                        HttpURLConnection conn = (HttpURLConnection) url
                                .openConnection();
                        conn.setRequestMethod("GET");
                        //���ó�ʱʱ��
                        conn.setConnectTimeout(5000);
                        int code = conn.getResponseCode();

                        // �õ����������ص���Ӧ��

                        //��������ɹ��󷵻�����200
                        if (code == 200) {
                            //��ȡ������
                            InputStream is = conn.getInputStream();
                            //����ת����Bitmap����
                            Bitmap bitmap = BitmapFactory.decodeStream(is);
                            //iv.setImageBitmap(bitmap);
                            //TODO: �������߳�һ����Ϣ:���Ҹ��Ľ��档����:bitmap
                            Message msg = new Message();
                            msg.what = CHANGE_UI;
                            msg.obj = bitmap;
                            handler.sendMessage(msg);
                        } else {
                            //�����벻��200  ���������ʧ��
                            Message msg = new Message();
                            msg.what = ERROR;
                            handler.sendMessage(msg);
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                        Message msg = new Message();
                        msg.what = ERROR;
                        handler.sendMessage(msg);
                    }
                }

                ;
            }.start();
        }
    }
}