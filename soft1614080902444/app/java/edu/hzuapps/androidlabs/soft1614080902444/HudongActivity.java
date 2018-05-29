package edu.hzuapps.androidlabs.soft1614080902444;

        import android.annotation.SuppressLint;
        import android.content.Context;
        import android.support.v7.app.AppCompatActivity;
        import android.os.Bundle;
        import android.view.View;
        import android.widget.Button;
        import android.widget.EditText;
        import android.widget.Toast;
        import java.io.FileInputStream;
        import java.io.FileOutputStream;
public class HudongActivity extends AppCompatActivity {
    private EditText et_info;
    private Button btn_save;
    private Button btn_read;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);
        et_info = (EditText) findViewById(R.id.et_info);
        btn_save = (Button ) findViewById(R.id.btn_save);
        btn_read = (Button) findViewById(R.id.btn_read);
        //传入实现了OnClickListener接口的类的对象
        btn_save.setOnClickListener(new ButtonListener());
        btn_read.setOnClickListener(new ButtonListener());
    }
    private class ButtonListener implements View.OnClickListener {
        @SuppressLint("WrongConstant")
        @Override
        public void onClick(View v) {
            switch(v.getId()){
                case R.id.btn_save:
                    String saveinfo = et_info.getText().toString().trim();
                    FileOutputStream fos;
                    try{
                        //保存数据，内部存储形式
                        fos = openFileOutput("data.txt", Context.MODE_APPEND);
                        fos.write(saveinfo.getBytes());
                        fos.close();
                    }
                    catch(Exception e){
                        e.printStackTrace(); }
                    Toast.makeText(HudongActivity.this, "数据保存成功", 0).show();
                    break;
                case R.id.btn_read:
                    String content = "";
                    try{
                        //获取保存的数据
                        FileInputStream fis = openFileInput("data.txt");
                        byte[] buffer = new byte[fis.available()];
                        fis.read(buffer);
                        content = new String(buffer);
                        fis.close();
                    }
                    catch(Exception e){
                        e.printStackTrace();
                    }
                    Toast.makeText(HudongActivity.this, "保存的数据是："+content, 0).show();
                    break;
                default:
                    break;
            }

        }

    }

}