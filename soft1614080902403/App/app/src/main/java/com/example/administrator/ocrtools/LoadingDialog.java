package com.example.administrator.ocrtools;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.NonNull;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

public class LoadingDialog extends Dialog {
    private ImageView img;
    private TextView tex;
    private Handler mHandler = new Handler() {
        public void handleMessage(android.os.Message msg) {
            hide();
        };
    };
    public LoadingDialog(@NonNull Context context) {
        super(context,R.style.myDialogTheme2);
        setContentView(R.layout.commom_loading_layout);
        img = findViewById(R.id.loadimg);
        tex = findViewById(R.id.loadtext);
    }



    public void show(int type,String text){
        switch (type){
            case 1:
                img.setImageResource(R.drawable.loading);
                break;
            case 2:
                img.setImageResource(R.drawable.load_fail_icon);
                mHandler.sendEmptyMessageDelayed(1, 3000);
                break;
            case 3:
                img.setImageResource(R.drawable.load_suc_icon);
                mHandler.sendEmptyMessageDelayed(1, 3000);
                break;
                default:
                    break;
        }
        tex.setText(text);
        show();
    }

}
