package com.example.administrator.ocrtools;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;


/**
 * ����dialog
 * @author Driver
 * @version V1.0
 * @Date 2015-04-01
 */
public class YWLoadingDialog extends Dialog {
	private ImageView iv_load_result;// ���صĽ��ͼ����ʾ
	private TextView tv_load;// ���ص�����չʾ
	private ProgressBar pb_loading;// �����е�ͼƬ
	private final int LOAD_SUCC = 0x001;
	private final int LOAD_FAIL = 0x002;
	private Handler mHandler = new Handler() {
		public void handleMessage(android.os.Message msg) {
			switch (msg.what) {
			case LOAD_SUCC:
				dimissSuc();
				break;
			case LOAD_FAIL:
				dimissFail("未识别到文字");
				break;
			default:
				break;
			}
		};
	};
	public YWLoadingDialog(Context context) {
		super(context, R.style.myDialogTheme2);
	}
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.commom_loading_layout);
		iv_load_result = (ImageView) findViewById(R.id.iv_load_result);
		tv_load = (TextView) findViewById(R.id.tv_load);
		pb_loading = (ProgressBar) findViewById(R.id.pb_loading);

	}
	public void dimissSuc() {// ���سɹ�
		pb_loading.setVisibility(View.GONE);
		iv_load_result.setVisibility(View.VISIBLE);
		tv_load.setText("加载成功");
		iv_load_result.setImageResource(R.drawable.load_suc_icon);
		mHandler.sendEmptyMessageDelayed(LOAD_SUCC, 3000);
	}
	public void dimissFail(String msg) {// ����ʧ��
		pb_loading.setVisibility(View.GONE);
		iv_load_result.setVisibility(View.VISIBLE);
		tv_load.setText(msg);
		iv_load_result.setImageResource(R.drawable.load_fail_icon);
		mHandler.sendEmptyMessageDelayed(LOAD_FAIL, 3000);
	}
}

