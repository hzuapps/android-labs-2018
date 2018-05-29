package soft1614080902333.androidlabs.hzuapps.edu.soft1614080902333;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
public class RingReceivedActivity extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
          //  Log.i("test","闹钟响了");
            //跳转到Activity n //广播接受者中（跳转Activity）
            Intent intent1=new Intent(context,RingActivity.class);
            //给Intent设置标志位
            intent1.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        context.startActivity(intent1);
    }
}
