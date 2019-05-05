package com.example.intelligentcooker.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;

import com.example.intelligentcooker.R;

/**
 * 登录碎片
 * @author henyiwu
 * @date 2017/11/9
 */

public class LoginFragment extends Fragment {

    private EditText mAccountEdit;
    private EditText mPasswordEdit;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.login_layout, container, false);
        Button close1 = view.findViewById(R.id.close1);
        Button close2 = view.findViewById(R.id.close2);
        mAccountEdit = view.findViewById(R.id.account_edit);
        mPasswordEdit = view.findViewById(R.id.password_edit);
        close1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mAccountEdit.setText("");
            }
        });
        close2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mPasswordEdit.setText("");
            }
        });
//        ImageButton close1 = view.findViewById(R.id.close1);
//        ImageButton close2 = view.findViewById(R.id.close2);
//        close1.setOnTouchListener(new View.OnTouchListener() {
//            @Override
//            public boolean onTouch(View v, MotionEvent event) {
//                if (event.getAction() == MotionEvent.ACTION_DOWN) {
//                    v.setBackgroundResource(R.drawable.close_pic_pressed);
//                } else if (event.getAction() == MotionEvent.ACTION_UP) {
//                    v.setBackgroundResource(R.drawable.close_pic);
//                }
//                return false;
//            }
//        });
//        close2.setOnTouchListener(new View.OnTouchListener() {
//            @Override
//            public boolean onTouch(View v, MotionEvent event) {
//                if (event.getAction() == MotionEvent.ACTION_DOWN) {
//                    v.setBackgroundResource(R.drawable.close_pic_pressed);
//                } else if (event.getAction() == MotionEvent.ACTION_UP) {
//                    v.setBackgroundResource(R.drawable.close_pic);
//                }
//                return false;
//            }
//        });
        return view;
    }

}
