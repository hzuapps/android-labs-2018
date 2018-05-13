package edu.soft1614080902329.password_record;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class soft1614080902329RecordActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_soft1614080902329_record);
        ListView LvPassList = findViewById(R.id.pass_list);
        Button newPass = findViewById(R.id.new_pass);
        newPass.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(soft1614080902329RecordActivity.this,"newPass",Toast.LENGTH_SHORT).show();
//                Intent intent = new Intent();
//                intent.setClass(soft1614080902329RecordActivity.this, soft1614080902329RecordActivity.class);
//                soft1614080902329RecordActivity.this.startActivity(intent);
            }
        });
        LvPassList.setAdapter(new passAdapter());

        LvPassList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(soft1614080902329RecordActivity.this,position + "ok",Toast.LENGTH_SHORT).show();
            }
        });
    }

    private class passAdapter extends BaseAdapter {

        @Override
        public int getCount() {
            return 50;
        }

        @Override
        public Object getItem(int position) {
            return null;
        }

        @Override
        public long getItemId(int position) {
            return 0;
        }


        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            TextView tvMsg;
            if(convertView == null){
                tvMsg = new TextView(soft1614080902329RecordActivity.this);
            }else {
                tvMsg = (TextView) convertView;
            }
            tvMsg.setText((position + 1) + "  QQ密码");
            tvMsg.setTextSize(32);
            tvMsg.setPadding(50,50,0,50);
            return tvMsg;
        }
    }

}
