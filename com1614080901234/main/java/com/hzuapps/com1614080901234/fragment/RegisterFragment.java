package com.example.intelligentcooker.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

import com.example.intelligentcooker.ClauseActivity;
import com.example.intelligentcooker.MainActivity;
import com.example.intelligentcooker.R;

/**
 * @author henyiwu
 * @date 2017/11/9
 * 注册的碎片
 * 注册碎片中的逻辑应该Fragment中处理，如果在MainActivity中处理，实例化的时候LoginActivity找不到
 * 相对应的控件，会造成空指针异常。
 */

public class RegisterFragment extends Fragment {

    private CheckBox mAgreement;
    private RadioButton mWoman;
    private RadioButton mMan;
    private EditText mConfPassword;
    private EditText mPassword;
    private EditText mUserName;
    private View mView;
    private Intent mIntent;
    private Button mRegisterButton;
    private Button mToClause;

    /**
     * 控件的实例化不应该写在onCreate方法中，因为从碎片的生命周期来看，onCreateView是在onCreate方法之后调用的
     * onCreate方法用于完成与UI无关的Fragment的初始化，在onCreateView中完成与UI相关的初始化，
     * 如果在onCreate中完成UI相关的初始化，布局还没载入（onCreateView没被调用），所以会报出空指针
     * @param inflater
     * @param container
     * @param savedInstanceState
     * @return
     */
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        mView = inflater.inflate(R.layout.register_layout, container, false);
        mToClause = mView.findViewById(R.id.toClause);
        mRegisterButton = mView.findViewById(R.id.register_button);
        mUserName = mView.findViewById(R.id.reg_username_edit);
        mPassword = mView.findViewById(R.id.reg_password_edit);
        mConfPassword = mView.findViewById(R.id.reg_conf_password);
        mMan = mView.findViewById(R.id.sex_man);
        mWoman = mView.findViewById(R.id.sex_woman);
        mAgreement = mView.findViewById(R.id.checkBox);
        mRegisterButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (TextUtils.isEmpty(mUserName.getText())) {
                    Toast.makeText(getContext(), R.string.account_cannot_empty, Toast.LENGTH_SHORT).show();
                } else if (TextUtils.isEmpty(mPassword.getText())) {
                    Toast.makeText(getContext(), R.string.password_cannot_empty, Toast.LENGTH_SHORT).show();
                } else if (TextUtils.isEmpty(mConfPassword.getText())) {
                    Toast.makeText(getContext(), R.string.confirm_password, Toast.LENGTH_SHORT).show();
                } else if(!(mPassword.getText().toString().equals(mConfPassword.getText().toString()))) {
                    Toast.makeText(getContext(), R.string.different_password, Toast.LENGTH_SHORT).show();
                } else if (!mMan.isChecked()&&!mWoman.isChecked()) {
                    Toast.makeText(getContext(), R.string.your_Sex, Toast.LENGTH_SHORT).show();
                } else if (!mAgreement.isChecked()) {
                    Toast.makeText(getContext(), R.string.read_clause, Toast.LENGTH_SHORT).show();
                } else {
                    mIntent = new Intent(getActivity(), MainActivity.class);
                    startActivity(mIntent);
                    Toast.makeText(getContext(), R.string.register_success, Toast.LENGTH_SHORT).show();
                    getActivity().finish();
                }
            }
        });
        mToClause.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), ClauseActivity.class);
                startActivity(intent);
            }
        });
        return mView;
    }

}
